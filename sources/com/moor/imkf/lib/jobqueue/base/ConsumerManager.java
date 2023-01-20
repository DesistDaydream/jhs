package com.moor.imkf.lib.jobqueue.base;

import androidx.annotation.NonNull;
import com.moor.imkf.lib.jobqueue.config.Configuration;
import com.moor.imkf.lib.jobqueue.log.JqLog;
import com.moor.imkf.lib.jobqueue.messaging.Message;
import com.moor.imkf.lib.jobqueue.messaging.MessageFactory;
import com.moor.imkf.lib.jobqueue.messaging.MessagePredicate;
import com.moor.imkf.lib.jobqueue.messaging.MessageQueue;
import com.moor.imkf.lib.jobqueue.messaging.MessageQueueConsumer;
import com.moor.imkf.lib.jobqueue.messaging.SafeMessageQueue;
import com.moor.imkf.lib.jobqueue.messaging.Type;
import com.moor.imkf.lib.jobqueue.messaging.message.CommandMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.JobConsumerIdleMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.RunJobMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.RunJobResultMessage;
import com.moor.imkf.lib.jobqueue.scheduling.SchedulerConstraint;
import com.moor.imkf.lib.jobqueue.timer.Timer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public class ConsumerManager {
    private final long consumerKeepAliveNs;
    private final MessageFactory factory;
    private final JobManagerThread jobManagerThread;
    private final int loadFactor;
    private final int maxConsumerCount;
    private final int minConsumerCount;
    public final RunningJobSet runningJobGroups;
    private final ThreadFactory threadFactory;
    private final int threadPriority;
    private final Timer timer;
    private List<Consumer> waitingConsumers = new ArrayList();
    private final List<Consumer> consumers = new ArrayList();
    private final CopyOnWriteArrayList<Runnable> internalZeroConsumersListeners = new CopyOnWriteArrayList<>();
    private final Map<String, JobHolder> runningJobHolders = new HashMap();
    private final ThreadGroup threadGroup = new ThreadGroup("JobConsumers");

    /* renamed from: com.moor.imkf.lib.jobqueue.base.ConsumerManager$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$moor$imkf$lib$jobqueue$messaging$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$moor$imkf$lib$jobqueue$messaging$Type = iArr;
            try {
                iArr[Type.RUN_JOB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$jobqueue$messaging$Type[Type.COMMAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class Consumer implements Runnable {
        public static final MessagePredicate pokeMessagePredicate = new MessagePredicate() { // from class: com.moor.imkf.lib.jobqueue.base.ConsumerManager.Consumer.1
            @Override // com.moor.imkf.lib.jobqueue.messaging.MessagePredicate
            public boolean onMessage(Message message) {
                return message.type == Type.COMMAND && ((CommandMessage) message).getWhat() == 2;
            }
        };
        public final MessageFactory factory;
        public boolean hasJob;
        public volatile long lastJobCompleted;
        public final SafeMessageQueue messageQueue;
        public final MessageQueue parentMessageQueue;
        public final MessageQueueConsumer queueConsumer = new MessageQueueConsumer() { // from class: com.moor.imkf.lib.jobqueue.base.ConsumerManager.Consumer.2
            @Override // com.moor.imkf.lib.jobqueue.messaging.MessageQueueConsumer
            public void handleMessage(Message message) {
                int i2 = AnonymousClass1.$SwitchMap$com$moor$imkf$lib$jobqueue$messaging$Type[message.type.ordinal()];
                if (i2 == 1) {
                    Consumer.this.handleRunJob((RunJobMessage) message);
                    Consumer.this.removePokeMessages();
                } else if (i2 != 2) {
                } else {
                    Consumer.this.handleCommand((CommandMessage) message);
                }
            }

            @Override // com.moor.imkf.lib.jobqueue.messaging.MessageQueueConsumer
            public void onIdle() {
                JqLog.d("consumer manager on idle", new Object[0]);
                JobConsumerIdleMessage jobConsumerIdleMessage = (JobConsumerIdleMessage) Consumer.this.factory.obtain(JobConsumerIdleMessage.class);
                jobConsumerIdleMessage.setWorker(Consumer.this);
                jobConsumerIdleMessage.setLastJobCompleted(Consumer.this.lastJobCompleted);
                Consumer.this.parentMessageQueue.post(jobConsumerIdleMessage);
            }
        };
        public final Timer timer;

        public Consumer(MessageQueue messageQueue, SafeMessageQueue safeMessageQueue, MessageFactory messageFactory, Timer timer) {
            this.messageQueue = safeMessageQueue;
            this.factory = messageFactory;
            this.parentMessageQueue = messageQueue;
            this.timer = timer;
            this.lastJobCompleted = timer.nanoTime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleCommand(CommandMessage commandMessage) {
            int what = commandMessage.getWhat();
            if (what == 1) {
                this.messageQueue.stop();
            } else if (what != 2) {
            } else {
                JqLog.d("Consumer has been poked.", new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleRunJob(RunJobMessage runJobMessage) {
            JqLog.d("running job %s", runJobMessage.getJobHolder().getClass().getSimpleName());
            JobHolder jobHolder = runJobMessage.getJobHolder();
            int safeRun = jobHolder.safeRun(jobHolder.getRunCount(), this.timer);
            RunJobResultMessage runJobResultMessage = (RunJobResultMessage) this.factory.obtain(RunJobResultMessage.class);
            runJobResultMessage.setJobHolder(jobHolder);
            runJobResultMessage.setResult(safeRun);
            runJobResultMessage.setWorker(this);
            this.lastJobCompleted = this.timer.nanoTime();
            this.parentMessageQueue.post(runJobResultMessage);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removePokeMessages() {
            this.messageQueue.cancelMessages(pokeMessagePredicate);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.messageQueue.consume(this.queueConsumer);
        }
    }

    public ConsumerManager(JobManagerThread jobManagerThread, Timer timer, MessageFactory messageFactory, Configuration configuration) {
        this.jobManagerThread = jobManagerThread;
        this.timer = timer;
        this.factory = messageFactory;
        this.loadFactor = configuration.getLoadFactor();
        this.minConsumerCount = configuration.getMinConsumerCount();
        this.maxConsumerCount = configuration.getMaxConsumerCount();
        this.consumerKeepAliveNs = configuration.getConsumerKeepAlive() * 1000 * 1000000;
        this.threadPriority = configuration.getThreadPriority();
        this.threadFactory = configuration.getThreadFactory();
        this.runningJobGroups = new RunningJobSet(timer);
    }

    private void addWorker() {
        Thread thread;
        JqLog.d("adding another consumer", new Object[0]);
        Consumer consumer = new Consumer(this.jobManagerThread.messageQueue, new SafeMessageQueue(this.timer, this.factory, "consumer"), this.factory, this.timer);
        ThreadFactory threadFactory = this.threadFactory;
        if (threadFactory != null) {
            thread = threadFactory.newThread(consumer);
        } else {
            ThreadGroup threadGroup = this.threadGroup;
            thread = new Thread(threadGroup, consumer, "job-queue-worker-" + UUID.randomUUID());
            thread.setPriority(this.threadPriority);
        }
        this.consumers.add(consumer);
        try {
            thread.start();
        } catch (InternalError e2) {
            JqLog.e(e2, "Cannot start a thread. Looks like app is shutting down.See issue #294 for details.", new Object[0]);
        }
    }

    private boolean considerAddingConsumers(boolean z) {
        JqLog.d("considering adding a new consumer. Should poke all waiting? %s isRunning? %s waiting workers? %d", Boolean.valueOf(z), Boolean.valueOf(this.jobManagerThread.isRunning()), Integer.valueOf(this.waitingConsumers.size()));
        if (!this.jobManagerThread.isRunning()) {
            JqLog.d("jobqueue is not running, no consumers will be added", new Object[0]);
            return false;
        } else if (this.waitingConsumers.size() > 0) {
            JqLog.d("there are waiting workers, will poke them instead", new Object[0]);
            for (int size = this.waitingConsumers.size() - 1; size >= 0; size--) {
                CommandMessage commandMessage = (CommandMessage) this.factory.obtain(CommandMessage.class);
                commandMessage.set(2);
                this.waitingConsumers.remove(size).messageQueue.post(commandMessage);
                if (!z) {
                    break;
                }
            }
            JqLog.d("there were waiting workers, poked them and I'm done", new Object[0]);
            return true;
        } else {
            boolean isAboveLoadFactor = isAboveLoadFactor();
            JqLog.d("nothing has been poked. are we above load factor? %s", Boolean.valueOf(isAboveLoadFactor));
            if (isAboveLoadFactor) {
                addWorker();
                return true;
            }
            return false;
        }
    }

    private boolean isAboveLoadFactor() {
        int size = this.consumers.size();
        if (size >= this.maxConsumerCount) {
            JqLog.d("too many consumers, clearly above load factor %s", Integer.valueOf(size));
            return false;
        }
        int countRemainingReadyJobs = this.jobManagerThread.countRemainingReadyJobs();
        int size2 = this.runningJobHolders.size();
        int i2 = countRemainingReadyJobs + size2;
        boolean z = this.loadFactor * size < i2 || (size < this.minConsumerCount && size < i2);
        JqLog.d("check above load factor: totalCons:%s minCons:%s maxConsCount: %s, loadFactor %s remainingJobs: %s running holders: %s. isAbove:%s", Integer.valueOf(size), Integer.valueOf(this.minConsumerCount), Integer.valueOf(this.maxConsumerCount), Integer.valueOf(this.loadFactor), Integer.valueOf(countRemainingReadyJobs), Integer.valueOf(size2), Boolean.valueOf(z));
        return z;
    }

    public void addNoConsumersListener(Runnable runnable) {
        this.internalZeroConsumersListeners.add(runnable);
    }

    public boolean areAllConsumersIdle() {
        return this.waitingConsumers.size() == this.consumers.size();
    }

    public int getWorkerCount() {
        return this.consumers.size();
    }

    public boolean handleConstraintChange() {
        return considerAddingConsumers(true);
    }

    public boolean handleIdle(@NonNull JobConsumerIdleMessage jobConsumerIdleMessage) {
        CopyOnWriteArrayList<Runnable> copyOnWriteArrayList;
        Consumer consumer = (Consumer) jobConsumerIdleMessage.getWorker();
        if (consumer.hasJob) {
            return true;
        }
        boolean isRunning = this.jobManagerThread.isRunning();
        JobHolder nextJob = isRunning ? this.jobManagerThread.getNextJob(this.runningJobGroups.getSafe()) : null;
        if (nextJob != null) {
            consumer.hasJob = true;
            this.runningJobGroups.add(nextJob.getGroupId());
            RunJobMessage runJobMessage = (RunJobMessage) this.factory.obtain(RunJobMessage.class);
            runJobMessage.setJobHolder(nextJob);
            this.runningJobHolders.put(nextJob.getJob().getId(), nextJob);
            if (nextJob.getGroupId() != null) {
                this.runningJobGroups.add(nextJob.getGroupId());
            }
            consumer.messageQueue.post(runJobMessage);
            return true;
        }
        long lastJobCompleted = jobConsumerIdleMessage.getLastJobCompleted() + this.consumerKeepAliveNs;
        JqLog.v("keep alive: %s", Long.valueOf(lastJobCompleted));
        boolean z = this.consumers.size() > this.minConsumerCount;
        boolean z2 = !isRunning || (z && lastJobCompleted < this.timer.nanoTime());
        JqLog.v("Consumer idle, will kill? %s. isRunning: %s. too many? %s timeout: %s now: %s", Boolean.valueOf(z2), Boolean.valueOf(isRunning), Boolean.valueOf(z), Long.valueOf(lastJobCompleted), Long.valueOf(this.timer.nanoTime()));
        if (z2) {
            CommandMessage commandMessage = (CommandMessage) this.factory.obtain(CommandMessage.class);
            commandMessage.set(1);
            consumer.messageQueue.post(commandMessage);
            this.waitingConsumers.remove(consumer);
            this.consumers.remove(consumer);
            JqLog.d("killed consumers. remaining consumers %d", Integer.valueOf(this.consumers.size()));
            if (this.consumers.isEmpty() && (copyOnWriteArrayList = this.internalZeroConsumersListeners) != null) {
                Iterator<Runnable> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
            }
        } else {
            if (!this.waitingConsumers.contains(consumer)) {
                this.waitingConsumers.add(consumer);
            }
            if (z || !this.jobManagerThread.canListenToNetwork()) {
                CommandMessage commandMessage2 = (CommandMessage) this.factory.obtain(CommandMessage.class);
                commandMessage2.set(2);
                if (!z) {
                    lastJobCompleted = this.timer.nanoTime() + this.consumerKeepAliveNs;
                }
                consumer.messageQueue.postAt(commandMessage2, lastJobCompleted);
                JqLog.d("poke consumer manager at %s", Long.valueOf(lastJobCompleted));
            }
        }
        return false;
    }

    public void handleRunJobResult(RunJobResultMessage runJobResultMessage, JobHolder jobHolder, RetryConstraint retryConstraint) {
        Consumer consumer = (Consumer) runJobResultMessage.getWorker();
        if (consumer.hasJob) {
            consumer.hasJob = false;
            this.runningJobHolders.remove(jobHolder.getJob().getId());
            if (jobHolder.getGroupId() != null) {
                this.runningJobGroups.remove(jobHolder.getGroupId());
                if (retryConstraint == null || !retryConstraint.willApplyNewDelayToGroup() || retryConstraint.getNewDelayInMs().longValue() <= 0) {
                    return;
                }
                this.runningJobGroups.addGroupUntil(jobHolder.getGroupId(), this.timer.nanoTime() + (retryConstraint.getNewDelayInMs().longValue() * 1000000));
                return;
            }
            return;
        }
        throw new IllegalStateException("this worker should not have a job");
    }

    public void handleStop() {
        for (Consumer consumer : this.consumers) {
            SafeMessageQueue safeMessageQueue = consumer.messageQueue;
            CommandMessage commandMessage = (CommandMessage) this.factory.obtain(CommandMessage.class);
            commandMessage.set(2);
            safeMessageQueue.post(commandMessage);
        }
        if (this.consumers.isEmpty()) {
            Iterator<Runnable> it = this.internalZeroConsumersListeners.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }

    public boolean hasJobsWithSchedulerConstraint(SchedulerConstraint schedulerConstraint) {
        for (JobHolder jobHolder : this.runningJobHolders.values()) {
            if (jobHolder.getJob().isPersistent() && schedulerConstraint.getNetworkStatus() >= jobHolder.requiredNetworkType) {
                return true;
            }
        }
        return false;
    }

    public boolean isJobRunning(String str) {
        return this.runningJobHolders.get(str) != null;
    }

    public Set<String> markJobsCancelled(TagConstraint tagConstraint, String[] strArr) {
        return markJobsCancelled(tagConstraint, strArr, false);
    }

    public Set<String> markJobsCancelledSingleId(TagConstraint tagConstraint, String[] strArr) {
        return markJobsCancelled(tagConstraint, strArr, true);
    }

    public void onJobAdded() {
        considerAddingConsumers(false);
    }

    public boolean removeNoConsumersListener(Runnable runnable) {
        return this.internalZeroConsumersListeners.remove(runnable);
    }

    private Set<String> markJobsCancelled(TagConstraint tagConstraint, String[] strArr, boolean z) {
        HashSet hashSet = new HashSet();
        for (JobHolder jobHolder : this.runningJobHolders.values()) {
            JqLog.d("checking job tag %s. tags of job: %s", jobHolder.getJob(), jobHolder.getJob().getTags());
            if (jobHolder.hasTags() && !jobHolder.isCancelled() && tagConstraint.matches(strArr, jobHolder.getTags())) {
                hashSet.add(jobHolder.getId());
                if (z) {
                    jobHolder.markAsCancelledSingleId();
                } else {
                    jobHolder.markAsCancelled();
                }
            }
        }
        return hashSet;
    }
}
