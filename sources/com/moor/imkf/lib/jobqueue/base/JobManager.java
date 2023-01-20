package com.moor.imkf.lib.jobqueue.base;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.heytap.mcssdk.constant.a;
import com.moor.imkf.lib.jobqueue.base.CancelResult;
import com.moor.imkf.lib.jobqueue.base.IntCallback;
import com.moor.imkf.lib.jobqueue.callback.JobManagerCallback;
import com.moor.imkf.lib.jobqueue.callback.JobManagerCallbackAdapter;
import com.moor.imkf.lib.jobqueue.config.Configuration;
import com.moor.imkf.lib.jobqueue.log.JqLog;
import com.moor.imkf.lib.jobqueue.messaging.Message;
import com.moor.imkf.lib.jobqueue.messaging.MessageFactory;
import com.moor.imkf.lib.jobqueue.messaging.MessageQueue;
import com.moor.imkf.lib.jobqueue.messaging.PriorityMessageQueue;
import com.moor.imkf.lib.jobqueue.messaging.message.AddJobMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.CancelMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.CommandMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.PublicQueryMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.SchedulerMessage;
import com.moor.imkf.lib.jobqueue.scheduling.Scheduler;
import com.moor.imkf.lib.jobqueue.scheduling.SchedulerConstraint;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class JobManager {
    public static final long MIN_DELAY_TO_USE_SCHEDULER_IN_MS = 30000;
    public static final long NETWORK_CHECK_INTERVAL = TimeUnit.MILLISECONDS.toNanos(a.q);
    public static final long NOT_DELAYED_JOB_DELAY = Long.MIN_VALUE;
    public static final long NOT_RUNNING_SESSION_ID = Long.MIN_VALUE;
    public static final long NS_PER_MS = 1000000;
    private Thread chefThread;
    public final JobManagerThread jobManagerThread;
    private final MessageFactory messageFactory;
    private final PriorityMessageQueue messageQueue;
    @Nullable
    private Scheduler scheduler;

    public JobManager(Configuration configuration) {
        MessageFactory messageFactory = new MessageFactory();
        this.messageFactory = messageFactory;
        PriorityMessageQueue priorityMessageQueue = new PriorityMessageQueue(configuration.getTimer(), messageFactory);
        this.messageQueue = priorityMessageQueue;
        JobManagerThread jobManagerThread = new JobManagerThread(configuration, priorityMessageQueue, messageFactory);
        this.jobManagerThread = jobManagerThread;
        this.chefThread = new Thread(jobManagerThread, "job-manager");
        if (configuration.getScheduler() != null) {
            this.scheduler = configuration.getScheduler();
            configuration.getScheduler().init(configuration.getAppContext(), createSchedulerCallback());
        }
        this.chefThread.start();
    }

    private void assertNotInJobManagerThread(String str) {
        if (Thread.currentThread() == this.chefThread) {
            throw new WrongThreadException(str);
        }
    }

    private void assertNotInMainThread() {
        assertNotInMainThread("Cannot call this method on main thread.");
    }

    private Scheduler.Callback createSchedulerCallback() {
        return new Scheduler.Callback() { // from class: com.moor.imkf.lib.jobqueue.base.JobManager.1
            @Override // com.moor.imkf.lib.jobqueue.scheduling.Scheduler.Callback
            public boolean start(SchedulerConstraint schedulerConstraint) {
                JobManager.this.dispatchSchedulerStart(schedulerConstraint);
                return true;
            }

            @Override // com.moor.imkf.lib.jobqueue.scheduling.Scheduler.Callback
            public boolean stop(SchedulerConstraint schedulerConstraint) {
                JobManager.this.dispatchSchedulerStop(schedulerConstraint);
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchSchedulerStart(SchedulerConstraint schedulerConstraint) {
        SchedulerMessage schedulerMessage = (SchedulerMessage) this.messageFactory.obtain(SchedulerMessage.class);
        schedulerMessage.set(1, schedulerConstraint);
        this.messageQueue.post(schedulerMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchSchedulerStop(SchedulerConstraint schedulerConstraint) {
        SchedulerMessage schedulerMessage = (SchedulerMessage) this.messageFactory.obtain(SchedulerMessage.class);
        schedulerMessage.set(2, schedulerConstraint);
        this.messageQueue.post(schedulerMessage);
    }

    public void addCallback(JobManagerCallback jobManagerCallback) {
        this.jobManagerThread.addCallback(jobManagerCallback);
    }

    public void addJob(Job job) {
        assertNotInMainThread("Cannot call this method on main thread. Use addJobInBackground instead.");
        assertNotInJobManagerThread("Cannot call sync methods in JobManager's callback thread.Use addJobInBackground instead");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final String id = job.getId();
        addCallback(new JobManagerCallbackAdapter() { // from class: com.moor.imkf.lib.jobqueue.base.JobManager.3
            @Override // com.moor.imkf.lib.jobqueue.callback.JobManagerCallbackAdapter, com.moor.imkf.lib.jobqueue.callback.JobManagerCallback
            public void onJobAdded(@NonNull Job job2) {
                if (id.equals(job2.getId())) {
                    countDownLatch.countDown();
                    JobManager.this.removeCallback(this);
                }
            }
        });
        addJobInBackground(job);
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
    }

    public void addJobInBackground(Job job) {
        AddJobMessage addJobMessage = (AddJobMessage) this.messageFactory.obtain(AddJobMessage.class);
        addJobMessage.setJob(job);
        this.messageQueue.post(addJobMessage);
    }

    public CancelResult cancelJobs(TagConstraint tagConstraint, String... strArr) {
        assertNotInMainThread("Cannot call this method on main thread. Use cancelJobsInBackground instead");
        assertNotInJobManagerThread("Cannot call this method on JobManager's thread. UsecancelJobsInBackground instead");
        if (tagConstraint != null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final CancelResult[] cancelResultArr = new CancelResult[1];
            CancelResult.AsyncCancelCallback asyncCancelCallback = new CancelResult.AsyncCancelCallback() { // from class: com.moor.imkf.lib.jobqueue.base.JobManager.5
                @Override // com.moor.imkf.lib.jobqueue.base.CancelResult.AsyncCancelCallback
                public void onCancelled(CancelResult cancelResult) {
                    cancelResultArr[0] = cancelResult;
                    countDownLatch.countDown();
                }
            };
            CancelMessage cancelMessage = (CancelMessage) this.messageFactory.obtain(CancelMessage.class);
            cancelMessage.setConstraint(tagConstraint);
            cancelMessage.setTags(strArr);
            cancelMessage.setCallback(asyncCancelCallback);
            this.messageQueue.post(cancelMessage);
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
            return cancelResultArr[0];
        }
        throw new IllegalArgumentException("must provide a TagConstraint");
    }

    public void cancelJobsInBackground(CancelResult.AsyncCancelCallback asyncCancelCallback, TagConstraint tagConstraint, String... strArr) {
        if (tagConstraint != null) {
            CancelMessage cancelMessage = (CancelMessage) this.messageFactory.obtain(CancelMessage.class);
            cancelMessage.setCallback(asyncCancelCallback);
            cancelMessage.setConstraint(tagConstraint);
            cancelMessage.setTags(strArr);
            this.messageQueue.post(cancelMessage);
            return;
        }
        throw new IllegalArgumentException("must provide a TagConstraint");
    }

    public void clear() {
        assertNotInMainThread();
        assertNotInJobManagerThread("Cannot call clear on JobManager's thread");
        PublicQueryMessage publicQueryMessage = (PublicQueryMessage) this.messageFactory.obtain(PublicQueryMessage.class);
        publicQueryMessage.set(5, null);
        new IntQueryFuture(this.messageQueue, publicQueryMessage).getSafe();
    }

    public int count() {
        assertNotInMainThread();
        assertNotInJobManagerThread("Cannot call count sync method in JobManager's thread");
        PublicQueryMessage publicQueryMessage = (PublicQueryMessage) this.messageFactory.obtain(PublicQueryMessage.class);
        publicQueryMessage.set(0, null);
        return new IntQueryFuture(this.messageQueue, publicQueryMessage).getSafe().intValue();
    }

    public int countReadyJobs() {
        assertNotInMainThread();
        assertNotInJobManagerThread("Cannot call countReadyJobs sync method on JobManager's thread");
        PublicQueryMessage publicQueryMessage = (PublicQueryMessage) this.messageFactory.obtain(PublicQueryMessage.class);
        publicQueryMessage.set(1, null);
        return new IntQueryFuture(this.messageQueue, publicQueryMessage).getSafe().intValue();
    }

    public void destroy() {
        JqLog.d("destroying job queue", new Object[0]);
        stopAndWaitUntilConsumersAreFinished();
        CommandMessage commandMessage = (CommandMessage) this.messageFactory.obtain(CommandMessage.class);
        commandMessage.set(1);
        this.messageQueue.post(commandMessage);
        this.jobManagerThread.callbackManager.destroy();
    }

    public int getActiveConsumerCount() {
        assertNotInMainThread();
        assertNotInJobManagerThread("Cannot call sync methods in JobManager's callback thread.");
        PublicQueryMessage publicQueryMessage = (PublicQueryMessage) this.messageFactory.obtain(PublicQueryMessage.class);
        publicQueryMessage.set(6, null);
        return new IntQueryFuture(this.messageQueue, publicQueryMessage).getSafe().intValue();
    }

    @VisibleForTesting
    public Thread getJobManagerExecutionThread() {
        return this.chefThread;
    }

    public JobStatus getJobStatus(String str) {
        assertNotInMainThread();
        assertNotInJobManagerThread("Cannot call getJobStatus on JobManager's thread");
        PublicQueryMessage publicQueryMessage = (PublicQueryMessage) this.messageFactory.obtain(PublicQueryMessage.class);
        publicQueryMessage.set(4, str, null);
        return JobStatus.values()[new IntQueryFuture(this.messageQueue, publicQueryMessage).getSafe().intValue()];
    }

    @Nullable
    public Scheduler getScheduler() {
        return this.scheduler;
    }

    public void internalRunInJobManagerThread(final Runnable runnable) throws Throwable {
        final Throwable[] thArr = new Throwable[1];
        PublicQueryMessage publicQueryMessage = (PublicQueryMessage) this.messageFactory.obtain(PublicQueryMessage.class);
        publicQueryMessage.set(101, null);
        new IntQueryFuture<PublicQueryMessage>(this.messageQueue, publicQueryMessage) { // from class: com.moor.imkf.lib.jobqueue.base.JobManager.6
            @Override // com.moor.imkf.lib.jobqueue.base.JobManager.IntQueryFuture, com.moor.imkf.lib.jobqueue.base.IntCallback
            public void onResult(int i2) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    thArr[0] = th;
                }
                super.onResult(i2);
            }
        }.getSafe();
        if (thArr[0] != null) {
            throw thArr[0];
        }
    }

    public boolean removeCallback(JobManagerCallback jobManagerCallback) {
        return this.jobManagerThread.removeCallback(jobManagerCallback);
    }

    public void start() {
        PublicQueryMessage publicQueryMessage = (PublicQueryMessage) this.messageFactory.obtain(PublicQueryMessage.class);
        publicQueryMessage.set(2, null);
        this.messageQueue.post(publicQueryMessage);
    }

    public void stop() {
        PublicQueryMessage publicQueryMessage = (PublicQueryMessage) this.messageFactory.obtain(PublicQueryMessage.class);
        publicQueryMessage.set(3, null);
        this.messageQueue.post(publicQueryMessage);
    }

    public void stopAndWaitUntilConsumersAreFinished() {
        waitUntilConsumersAreFinished(true);
    }

    public void waitUntilConsumersAreFinished() {
        waitUntilConsumersAreFinished(false);
    }

    /* loaded from: classes2.dex */
    public static class IntQueryFuture<T extends Message & IntCallback.MessageWithCallback> implements Future<Integer>, IntCallback {
        public final T message;
        public final MessageQueue messageQueue;
        public volatile Integer result = null;
        public final CountDownLatch latch = new CountDownLatch(1);

        public IntQueryFuture(MessageQueue messageQueue, T t) {
            this.messageQueue = messageQueue;
            this.message = t;
            t.setCallback(this);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return false;
        }

        public Integer getSafe() {
            try {
                return get();
            } catch (Throwable th) {
                JqLog.e(th, "message is not complete", new Object[0]);
                throw new RuntimeException("cannot get the result of the JobManager query");
            }
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return false;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.latch.getCount() == 0;
        }

        public void onResult(int i2) {
            this.result = Integer.valueOf(i2);
            this.latch.countDown();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Future
        public Integer get() throws InterruptedException, ExecutionException {
            this.messageQueue.post(this.message);
            this.latch.await();
            return this.result;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Future
        public Integer get(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            this.messageQueue.post(this.message);
            this.latch.await(j2, timeUnit);
            return this.result;
        }
    }

    private void assertNotInMainThread(String str) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new WrongThreadException(str);
        }
    }

    private void waitUntilConsumersAreFinished(boolean z) {
        assertNotInMainThread();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        JqLog.v("adding no consumers listener.", new Object[0]);
        this.jobManagerThread.consumerManager.addNoConsumersListener(new Runnable() { // from class: com.moor.imkf.lib.jobqueue.base.JobManager.2
            @Override // java.lang.Runnable
            public void run() {
                JqLog.v("received no consumers callback", new Object[0]);
                countDownLatch.countDown();
                JobManager.this.jobManagerThread.consumerManager.removeNoConsumersListener(this);
            }
        });
        if (z) {
            stop();
        }
        if (this.jobManagerThread.consumerManager.getWorkerCount() == 0) {
            return;
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        PublicQueryMessage publicQueryMessage = (PublicQueryMessage) this.messageFactory.obtain(PublicQueryMessage.class);
        publicQueryMessage.set(5, null);
        new IntQueryFuture(this.jobManagerThread.callbackManager.messageQueue, publicQueryMessage).getSafe();
    }

    public void addJobInBackground(Job job, final AsyncAddCallback asyncAddCallback) {
        if (asyncAddCallback == null) {
            addJobInBackground(job);
            return;
        }
        final String id = job.getId();
        addCallback(new JobManagerCallbackAdapter() { // from class: com.moor.imkf.lib.jobqueue.base.JobManager.4
            @Override // com.moor.imkf.lib.jobqueue.callback.JobManagerCallbackAdapter, com.moor.imkf.lib.jobqueue.callback.JobManagerCallback
            public void onJobAdded(@NonNull Job job2) {
                if (id.equals(job2.getId())) {
                    try {
                        asyncAddCallback.onAdded();
                    } finally {
                        JobManager.this.removeCallback(this);
                    }
                }
            }
        });
        addJobInBackground(job);
    }
}
