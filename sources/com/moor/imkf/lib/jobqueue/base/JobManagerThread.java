package com.moor.imkf.lib.jobqueue.base;

import android.content.Context;
import androidx.annotation.Nullable;
import com.moor.imkf.lib.jobqueue.base.JobHolder;
import com.moor.imkf.lib.jobqueue.callback.JobManagerCallback;
import com.moor.imkf.lib.jobqueue.config.Configuration;
import com.moor.imkf.lib.jobqueue.di.DependencyInjector;
import com.moor.imkf.lib.jobqueue.log.JqLog;
import com.moor.imkf.lib.jobqueue.messaging.Message;
import com.moor.imkf.lib.jobqueue.messaging.MessageFactory;
import com.moor.imkf.lib.jobqueue.messaging.MessageQueueConsumer;
import com.moor.imkf.lib.jobqueue.messaging.PriorityMessageQueue;
import com.moor.imkf.lib.jobqueue.messaging.Type;
import com.moor.imkf.lib.jobqueue.messaging.message.AddJobMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.CancelMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.CommandMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.ConstraintChangeMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.JobConsumerIdleMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.PublicQueryMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.RunJobResultMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.SchedulerMessage;
import com.moor.imkf.lib.jobqueue.network.NetworkEventProvider;
import com.moor.imkf.lib.jobqueue.network.NetworkUtil;
import com.moor.imkf.lib.jobqueue.scheduling.Scheduler;
import com.moor.imkf.lib.jobqueue.scheduling.SchedulerConstraint;
import com.moor.imkf.lib.jobqueue.timer.Timer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class JobManagerThread implements Runnable, NetworkEventProvider.Listener {
    public static final long NOT_DELAYED_JOB_DELAY = Long.MIN_VALUE;
    public static final long NOT_RUNNING_SESSION_ID = Long.MIN_VALUE;
    public static final long NS_PER_MS = 1000000;
    private final Context appContext;
    public final CallbackManager callbackManager;
    public final ConsumerManager consumerManager;
    private final DependencyInjector dependencyInjector;
    private final MessageFactory messageFactory;
    public final PriorityMessageQueue messageQueue;
    private final NetworkUtil networkUtil;
    public final JobQueue nonPersistentJobQueue;
    @Nullable
    private List<CancelHandler> pendingCancelHandlers;
    @Nullable
    private List<SchedulerConstraint> pendingSchedulerCallbacks;
    public final JobQueue persistentJobQueue;
    @Nullable
    public Scheduler scheduler;
    private final long sessionId;
    public final Timer timer;
    public final Constraint queryConstraint = new Constraint();
    private boolean running = true;
    private boolean shouldCancelAllScheduledWhenEmpty = false;
    private boolean canScheduleConstraintChangeOnIdle = true;

    /* renamed from: com.moor.imkf.lib.jobqueue.base.JobManagerThread$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$moor$imkf$lib$jobqueue$messaging$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$moor$imkf$lib$jobqueue$messaging$Type = iArr;
            try {
                iArr[Type.ADD_JOB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$jobqueue$messaging$Type[Type.JOB_CONSUMER_IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$jobqueue$messaging$Type[Type.RUN_JOB_RESULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$jobqueue$messaging$Type[Type.CONSTRAINT_CHANGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$jobqueue$messaging$Type[Type.CANCEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$jobqueue$messaging$Type[Type.PUBLIC_QUERY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$jobqueue$messaging$Type[Type.COMMAND.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$moor$imkf$lib$jobqueue$messaging$Type[Type.SCHEDULER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public JobManagerThread(Configuration configuration, PriorityMessageQueue priorityMessageQueue, MessageFactory messageFactory) {
        this.messageQueue = priorityMessageQueue;
        if (configuration.getCustomLogger() != null) {
            JqLog.setCustomLogger(configuration.getCustomLogger());
        }
        this.messageFactory = messageFactory;
        Timer timer = configuration.getTimer();
        this.timer = timer;
        this.appContext = configuration.getAppContext();
        long nanoTime = timer.nanoTime();
        this.sessionId = nanoTime;
        Scheduler scheduler = configuration.getScheduler();
        this.scheduler = scheduler;
        if (scheduler != null && configuration.batchSchedulerRequests() && !(this.scheduler instanceof BatchingScheduler)) {
            this.scheduler = new BatchingScheduler(this.scheduler, timer);
        }
        this.persistentJobQueue = configuration.getQueueFactory().createPersistentQueue(configuration, nanoTime);
        this.nonPersistentJobQueue = configuration.getQueueFactory().createNonPersistent(configuration, nanoTime);
        NetworkUtil networkUtil = configuration.getNetworkUtil();
        this.networkUtil = networkUtil;
        this.dependencyInjector = configuration.getDependencyInjector();
        if (networkUtil instanceof NetworkEventProvider) {
            ((NetworkEventProvider) networkUtil).setListener(this);
        }
        this.consumerManager = new ConsumerManager(this, timer, messageFactory, configuration);
        this.callbackManager = new CallbackManager(messageFactory, timer);
    }

    private void cancelSafely(JobHolder jobHolder, int i2) {
        try {
            jobHolder.onCancel(i2);
        } catch (Throwable th) {
            JqLog.e(th, "job's onCancel did throw an exception, ignoring...", new Object[0]);
        }
        this.callbackManager.notifyOnCancel(jobHolder.getJob(), false, jobHolder.getThrowable());
    }

    private void clear() {
        this.nonPersistentJobQueue.clear();
        this.persistentJobQueue.clear();
    }

    private int countReadyJobs(int i2) {
        Collection<String> safe = this.consumerManager.runningJobGroups.getSafe();
        this.queryConstraint.clear();
        this.queryConstraint.setNowInNs(this.timer.nanoTime());
        this.queryConstraint.setMaxNetworkType(i2);
        this.queryConstraint.setExcludeGroups(safe);
        this.queryConstraint.setExcludeRunning(true);
        this.queryConstraint.setTimeLimit(Long.valueOf(this.timer.nanoTime()));
        return this.nonPersistentJobQueue.countReadyJobs(this.queryConstraint) + 0 + this.persistentJobQueue.countReadyJobs(this.queryConstraint);
    }

    private JobHolder findJobBySingleId(String str) {
        if (str != null) {
            this.queryConstraint.clear();
            this.queryConstraint.setTags(new String[]{str});
            this.queryConstraint.setTagConstraint(TagConstraint.ANY);
            this.queryConstraint.setMaxNetworkType(2);
            Set<JobHolder> findJobs = this.nonPersistentJobQueue.findJobs(this.queryConstraint);
            findJobs.addAll(this.persistentJobQueue.findJobs(this.queryConstraint));
            if (findJobs.isEmpty()) {
                return null;
            }
            for (JobHolder jobHolder : findJobs) {
                if (!this.consumerManager.isJobRunning(jobHolder.getId())) {
                    return jobHolder;
                }
            }
            return findJobs.iterator().next();
        }
        return null;
    }

    private JobStatus getJobStatus(String str) {
        if (this.consumerManager.isJobRunning(str)) {
            return JobStatus.RUNNING;
        }
        JobHolder findJobById = this.nonPersistentJobQueue.findJobById(str);
        if (findJobById == null) {
            findJobById = this.persistentJobQueue.findJobById(str);
        }
        if (findJobById == null) {
            return JobStatus.UNKNOWN;
        }
        int networkStatus = getNetworkStatus();
        long nanoTime = this.timer.nanoTime();
        if (networkStatus < findJobById.requiredNetworkType) {
            return JobStatus.WAITING_NOT_READY;
        }
        if (findJobById.getDelayUntilNs() > nanoTime) {
            return JobStatus.WAITING_NOT_READY;
        }
        return JobStatus.WAITING_READY;
    }

    private int getNetworkStatus() {
        NetworkUtil networkUtil = this.networkUtil;
        if (networkUtil == null) {
            return 2;
        }
        return networkUtil.getNetworkStatus(this.appContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAddJob(AddJobMessage addJobMessage) {
        Job job = addJobMessage.getJob();
        long nanoTime = this.timer.nanoTime();
        JobHolder build = new JobHolder.Builder().priority(job.getPriority()).job(job).groupId(job.getRunGroupId()).createdNs(nanoTime).delayUntilNs(job.getDelayInMs() > 0 ? (job.getDelayInMs() * 1000000) + nanoTime : Long.MIN_VALUE).id(job.getId()).tags(job.getTags()).persistent(job.isPersistent()).runCount(0).deadline(job.getDeadlineInMs() > 0 ? (job.getDeadlineInMs() * 1000000) + nanoTime : Long.MAX_VALUE, job.shouldCancelOnDeadline()).requiredNetworkType(job.requiredNetworkType).runningSessionId(Long.MIN_VALUE).build();
        JobHolder findJobBySingleId = findJobBySingleId(job.getSingleInstanceId());
        boolean z = findJobBySingleId == null || this.consumerManager.isJobRunning(findJobBySingleId.getId());
        if (z) {
            JobQueue jobQueue = job.isPersistent() ? this.persistentJobQueue : this.nonPersistentJobQueue;
            if (findJobBySingleId != null) {
                this.consumerManager.markJobsCancelledSingleId(TagConstraint.ANY, new String[]{job.getSingleInstanceId()});
                jobQueue.substitute(build, findJobBySingleId);
            } else {
                jobQueue.insert(build);
            }
            if (JqLog.isDebugEnabled()) {
                JqLog.d("added job class: %s priority: %d delay: %d group : %s persistent: %s", job.getClass().getSimpleName(), Integer.valueOf(job.getPriority()), Long.valueOf(job.getDelayInMs()), job.getRunGroupId(), Boolean.valueOf(job.isPersistent()));
            }
        } else {
            JqLog.d("another job with same singleId: %s was already queued", job.getSingleInstanceId());
        }
        DependencyInjector dependencyInjector = this.dependencyInjector;
        if (dependencyInjector != null) {
            dependencyInjector.inject(job);
        }
        build.setApplicationContext(this.appContext);
        build.getJob().onAdded();
        this.callbackManager.notifyOnAdded(build.getJob());
        if (z) {
            this.consumerManager.onJobAdded();
            if (job.isPersistent()) {
                scheduleWakeUpFor(build, nanoTime);
                return;
            }
            return;
        }
        cancelSafely(build, 1);
        this.callbackManager.notifyOnDone(build.getJob());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCancel(CancelMessage cancelMessage) {
        CancelHandler cancelHandler = new CancelHandler(cancelMessage.getConstraint(), cancelMessage.getTags(), cancelMessage.getCallback());
        cancelHandler.query(this, this.consumerManager);
        if (cancelHandler.isDone()) {
            cancelHandler.commit(this);
            return;
        }
        if (this.pendingCancelHandlers == null) {
            this.pendingCancelHandlers = new ArrayList();
        }
        this.pendingCancelHandlers.add(cancelHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCommand(CommandMessage commandMessage) {
        if (commandMessage.getWhat() == 1) {
            this.messageQueue.stop();
            this.messageQueue.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePublicQuery(PublicQueryMessage publicQueryMessage) {
        int what = publicQueryMessage.getWhat();
        if (what != 101) {
            switch (what) {
                case 0:
                    publicQueryMessage.getCallback().onResult(count());
                    return;
                case 1:
                    publicQueryMessage.getCallback().onResult(countReadyJobs(getNetworkStatus()));
                    return;
                case 2:
                    JqLog.d("handling start request...", new Object[0]);
                    if (this.running) {
                        return;
                    }
                    this.running = true;
                    this.consumerManager.handleConstraintChange();
                    return;
                case 3:
                    JqLog.d("handling stop request...", new Object[0]);
                    this.running = false;
                    this.consumerManager.handleStop();
                    return;
                case 4:
                    publicQueryMessage.getCallback().onResult(getJobStatus(publicQueryMessage.getStringArg()).ordinal());
                    return;
                case 5:
                    clear();
                    if (publicQueryMessage.getCallback() != null) {
                        publicQueryMessage.getCallback().onResult(0);
                        return;
                    }
                    return;
                case 6:
                    publicQueryMessage.getCallback().onResult(this.consumerManager.getWorkerCount());
                    return;
                default:
                    throw new IllegalArgumentException("cannot handle public query with type " + publicQueryMessage.getWhat());
            }
        }
        publicQueryMessage.getCallback().onResult(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRunJobResult(RunJobResultMessage runJobResultMessage) {
        RetryConstraint retryConstraint;
        int result = runJobResultMessage.getResult();
        JobHolder jobHolder = runJobResultMessage.getJobHolder();
        this.callbackManager.notifyOnRun(jobHolder.getJob(), result);
        int i2 = 0;
        switch (result) {
            case 1:
                removeJob(jobHolder);
                retryConstraint = null;
                break;
            case 2:
                cancelSafely(jobHolder, 2);
                removeJob(jobHolder);
                retryConstraint = null;
                break;
            case 3:
                JqLog.d("running job failed and cancelled, doing nothing. Will be removed after it's onCancel is called by the CancelHandler", new Object[0]);
                retryConstraint = null;
                break;
            case 4:
                retryConstraint = jobHolder.getRetryConstraint();
                insertOrReplace(jobHolder);
                break;
            case 5:
                cancelSafely(jobHolder, 5);
                removeJob(jobHolder);
                retryConstraint = null;
                break;
            case 6:
                cancelSafely(jobHolder, 6);
                removeJob(jobHolder);
                retryConstraint = null;
                break;
            case 7:
                cancelSafely(jobHolder, 7);
                removeJob(jobHolder);
                retryConstraint = null;
                break;
            default:
                throw new IllegalArgumentException("unknown job holder result");
        }
        this.consumerManager.handleRunJobResult(runJobResultMessage, jobHolder, retryConstraint);
        this.callbackManager.notifyAfterRun(jobHolder.getJob(), result);
        List<CancelHandler> list = this.pendingCancelHandlers;
        if (list != null) {
            int size = list.size();
            while (i2 < size) {
                CancelHandler cancelHandler = this.pendingCancelHandlers.get(i2);
                cancelHandler.onJobRun(jobHolder, result);
                if (cancelHandler.isDone()) {
                    cancelHandler.commit(this);
                    this.pendingCancelHandlers.remove(i2);
                    i2--;
                    size--;
                }
                i2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSchedulerMessage(SchedulerMessage schedulerMessage) {
        int what = schedulerMessage.getWhat();
        if (what == 1) {
            handleSchedulerStart(schedulerMessage.getConstraint());
        } else if (what == 2) {
            handleSchedulerStop(schedulerMessage.getConstraint());
        } else {
            throw new IllegalArgumentException("Unknown scheduler message with what " + what);
        }
    }

    private void handleSchedulerStart(SchedulerConstraint schedulerConstraint) {
        if (!isRunning()) {
            Scheduler scheduler = this.scheduler;
            if (scheduler != null) {
                scheduler.onFinished(schedulerConstraint, true);
            }
        } else if (!hasJobsWithSchedulerConstraint(schedulerConstraint)) {
            Scheduler scheduler2 = this.scheduler;
            if (scheduler2 != null) {
                scheduler2.onFinished(schedulerConstraint, false);
            }
        } else {
            if (this.pendingSchedulerCallbacks == null) {
                this.pendingSchedulerCallbacks = new ArrayList();
            }
            this.pendingSchedulerCallbacks.add(schedulerConstraint);
            this.consumerManager.handleConstraintChange();
        }
    }

    private void handleSchedulerStop(SchedulerConstraint schedulerConstraint) {
        List<SchedulerConstraint> list = this.pendingSchedulerCallbacks;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size).getUuid().equals(schedulerConstraint.getUuid())) {
                    list.remove(size);
                }
            }
        }
        if (this.scheduler != null && hasJobsWithSchedulerConstraint(schedulerConstraint)) {
            this.scheduler.request(schedulerConstraint);
        }
    }

    private boolean hasJobsWithSchedulerConstraint(SchedulerConstraint schedulerConstraint) {
        if (this.consumerManager.hasJobsWithSchedulerConstraint(schedulerConstraint)) {
            return true;
        }
        this.queryConstraint.clear();
        this.queryConstraint.setNowInNs(this.timer.nanoTime());
        this.queryConstraint.setMaxNetworkType(schedulerConstraint.getNetworkStatus());
        return this.persistentJobQueue.countReadyJobs(this.queryConstraint) > 0;
    }

    private void insertOrReplace(JobHolder jobHolder) {
        RetryConstraint retryConstraint = jobHolder.getRetryConstraint();
        if (retryConstraint == null) {
            reAddJob(jobHolder);
            return;
        }
        if (retryConstraint.getNewPriority() != null) {
            jobHolder.setPriority(retryConstraint.getNewPriority().intValue());
        }
        long longValue = retryConstraint.getNewDelayInMs() != null ? retryConstraint.getNewDelayInMs().longValue() : -1L;
        jobHolder.setDelayUntilNs(longValue > 0 ? this.timer.nanoTime() + (longValue * 1000000) : Long.MIN_VALUE);
        reAddJob(jobHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeSchedulersIfIdle() {
        List<SchedulerConstraint> list;
        if (this.scheduler == null || (list = this.pendingSchedulerCallbacks) == null || list.isEmpty() || !this.consumerManager.areAllConsumersIdle()) {
            return;
        }
        for (int size = this.pendingSchedulerCallbacks.size() - 1; size >= 0; size--) {
            SchedulerConstraint remove = this.pendingSchedulerCallbacks.remove(size);
            this.scheduler.onFinished(remove, hasJobsWithSchedulerConstraint(remove));
        }
    }

    private void reAddJob(JobHolder jobHolder) {
        if (!jobHolder.isCancelled()) {
            if (jobHolder.getJob().isPersistent()) {
                this.persistentJobQueue.insertOrReplace(jobHolder);
                return;
            } else {
                this.nonPersistentJobQueue.insertOrReplace(jobHolder);
                return;
            }
        }
        JqLog.d("not re-adding cancelled job " + jobHolder, new Object[0]);
    }

    private void removeJob(JobHolder jobHolder) {
        if (jobHolder.getJob().isPersistent()) {
            this.persistentJobQueue.remove(jobHolder);
        } else {
            this.nonPersistentJobQueue.remove(jobHolder);
        }
        this.callbackManager.notifyOnDone(jobHolder.getJob());
    }

    private void scheduleWakeUpFor(JobHolder jobHolder, long j2) {
        if (this.scheduler == null) {
            return;
        }
        int i2 = jobHolder.requiredNetworkType;
        long delayUntilNs = jobHolder.getDelayUntilNs();
        long deadlineNs = jobHolder.getDeadlineNs();
        int i3 = (delayUntilNs > j2 ? 1 : (delayUntilNs == j2 ? 0 : -1));
        long millis = i3 > 0 ? TimeUnit.NANOSECONDS.toMillis(delayUntilNs - j2) : 0L;
        Long valueOf = deadlineNs != Long.MAX_VALUE ? Long.valueOf(TimeUnit.NANOSECONDS.toMillis(deadlineNs - j2)) : null;
        boolean z = false;
        boolean z2 = i3 > 0 && millis >= JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS;
        if (valueOf != null && valueOf.longValue() >= JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS) {
            z = true;
        }
        if (i2 != 0 || z2 || z) {
            SchedulerConstraint schedulerConstraint = new SchedulerConstraint(UUID.randomUUID().toString());
            schedulerConstraint.setNetworkStatus(i2);
            schedulerConstraint.setDelayInMs(millis);
            schedulerConstraint.setOverrideDeadlineInMs(valueOf);
            this.scheduler.request(schedulerConstraint);
            this.shouldCancelAllScheduledWhenEmpty = true;
        }
    }

    public void addCallback(JobManagerCallback jobManagerCallback) {
        this.callbackManager.addCallback(jobManagerCallback);
    }

    public boolean canListenToNetwork() {
        return this.networkUtil instanceof NetworkEventProvider;
    }

    public int count() {
        return this.persistentJobQueue.count() + this.nonPersistentJobQueue.count();
    }

    public int countRemainingReadyJobs() {
        return countReadyJobs(getNetworkStatus());
    }

    public JobHolder getNextJob(Collection<String> collection) {
        return getNextJob(collection, false);
    }

    public JobHolder getNextJobForTesting() {
        return getNextJobForTesting(null);
    }

    public Long getNextWakeUpNs(boolean z) {
        Long nextDelayForGroups = this.consumerManager.runningJobGroups.getNextDelayForGroups();
        int networkStatus = getNetworkStatus();
        Collection<String> safe = this.consumerManager.runningJobGroups.getSafe();
        this.queryConstraint.clear();
        this.queryConstraint.setNowInNs(this.timer.nanoTime());
        this.queryConstraint.setMaxNetworkType(networkStatus);
        this.queryConstraint.setExcludeGroups(safe);
        this.queryConstraint.setExcludeRunning(true);
        Long nextJobDelayUntilNs = this.nonPersistentJobQueue.getNextJobDelayUntilNs(this.queryConstraint);
        Long nextJobDelayUntilNs2 = this.persistentJobQueue.getNextJobDelayUntilNs(this.queryConstraint);
        if (nextDelayForGroups == null) {
            nextDelayForGroups = null;
        }
        if (nextJobDelayUntilNs != null) {
            nextDelayForGroups = Long.valueOf(nextDelayForGroups == null ? nextJobDelayUntilNs.longValue() : Math.min(nextJobDelayUntilNs.longValue(), nextDelayForGroups.longValue()));
        }
        if (nextJobDelayUntilNs2 != null) {
            nextDelayForGroups = Long.valueOf(nextDelayForGroups == null ? nextJobDelayUntilNs2.longValue() : Math.min(nextJobDelayUntilNs2.longValue(), nextDelayForGroups.longValue()));
        }
        if (!z || (this.networkUtil instanceof NetworkEventProvider)) {
            return nextDelayForGroups;
        }
        long nanoTime = this.timer.nanoTime() + JobManager.NETWORK_CHECK_INTERVAL;
        if (nextDelayForGroups != null) {
            nanoTime = Math.min(nanoTime, nextDelayForGroups.longValue());
        }
        return Long.valueOf(nanoTime);
    }

    public boolean isRunning() {
        return this.running;
    }

    @Override // com.moor.imkf.lib.jobqueue.network.NetworkEventProvider.Listener
    public void onNetworkChange(int i2) {
        this.messageQueue.post((ConstraintChangeMessage) this.messageFactory.obtain(ConstraintChangeMessage.class));
    }

    public boolean removeCallback(JobManagerCallback jobManagerCallback) {
        return this.callbackManager.removeCallback(jobManagerCallback);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.messageQueue.consume(new MessageQueueConsumer() { // from class: com.moor.imkf.lib.jobqueue.base.JobManagerThread.1
            @Override // com.moor.imkf.lib.jobqueue.messaging.MessageQueueConsumer
            public void handleMessage(Message message) {
                boolean z = true;
                JobManagerThread.this.canScheduleConstraintChangeOnIdle = true;
                switch (AnonymousClass2.$SwitchMap$com$moor$imkf$lib$jobqueue$messaging$Type[message.type.ordinal()]) {
                    case 1:
                        JobManagerThread.this.handleAddJob((AddJobMessage) message);
                        return;
                    case 2:
                        if (JobManagerThread.this.consumerManager.handleIdle((JobConsumerIdleMessage) message)) {
                            return;
                        }
                        JobManagerThread.this.invokeSchedulersIfIdle();
                        return;
                    case 3:
                        JobManagerThread.this.handleRunJobResult((RunJobResultMessage) message);
                        return;
                    case 4:
                        boolean handleConstraintChange = JobManagerThread.this.consumerManager.handleConstraintChange();
                        ConstraintChangeMessage constraintChangeMessage = (ConstraintChangeMessage) message;
                        JobManagerThread jobManagerThread = JobManagerThread.this;
                        if (!handleConstraintChange && constraintChangeMessage.isForNextJob()) {
                            z = false;
                        }
                        jobManagerThread.canScheduleConstraintChangeOnIdle = z;
                        return;
                    case 5:
                        JobManagerThread.this.handleCancel((CancelMessage) message);
                        return;
                    case 6:
                        JobManagerThread.this.handlePublicQuery((PublicQueryMessage) message);
                        return;
                    case 7:
                        JobManagerThread.this.handleCommand((CommandMessage) message);
                        return;
                    case 8:
                        JobManagerThread.this.handleSchedulerMessage((SchedulerMessage) message);
                        return;
                    default:
                        return;
                }
            }

            @Override // com.moor.imkf.lib.jobqueue.messaging.MessageQueueConsumer
            public void onIdle() {
                JqLog.v("joq idle. running:? %s", Boolean.valueOf(JobManagerThread.this.running));
                if (JobManagerThread.this.running) {
                    if (!JobManagerThread.this.canScheduleConstraintChangeOnIdle) {
                        JqLog.v("skipping scheduling a new idle callback because looks like last one did not do anything", new Object[0]);
                        return;
                    }
                    Long nextWakeUpNs = JobManagerThread.this.getNextWakeUpNs(true);
                    JqLog.d("Job queue idle. next job at: %s", nextWakeUpNs);
                    if (nextWakeUpNs != null) {
                        ConstraintChangeMessage constraintChangeMessage = (ConstraintChangeMessage) JobManagerThread.this.messageFactory.obtain(ConstraintChangeMessage.class);
                        constraintChangeMessage.setForNextJob(true);
                        JobManagerThread.this.messageQueue.postAt(constraintChangeMessage, nextWakeUpNs.longValue());
                        return;
                    }
                    JobManagerThread jobManagerThread = JobManagerThread.this;
                    if (jobManagerThread.scheduler != null && jobManagerThread.shouldCancelAllScheduledWhenEmpty && JobManagerThread.this.persistentJobQueue.count() == 0) {
                        JobManagerThread.this.shouldCancelAllScheduledWhenEmpty = false;
                        JobManagerThread.this.scheduler.cancelAll();
                    }
                }
            }
        });
    }

    public JobHolder getNextJob(Collection<String> collection, boolean z) {
        boolean z2;
        DependencyInjector dependencyInjector;
        if (!this.running && !z) {
            return null;
        }
        while (true) {
            JobHolder jobHolder = null;
            while (jobHolder == null) {
                int networkStatus = getNetworkStatus();
                JqLog.v("looking for next job", new Object[0]);
                this.queryConstraint.clear();
                long nanoTime = this.timer.nanoTime();
                this.queryConstraint.setNowInNs(nanoTime);
                this.queryConstraint.setMaxNetworkType(networkStatus);
                this.queryConstraint.setExcludeGroups(collection);
                this.queryConstraint.setExcludeRunning(true);
                this.queryConstraint.setTimeLimit(Long.valueOf(nanoTime));
                jobHolder = this.nonPersistentJobQueue.nextJobAndIncRunCount(this.queryConstraint);
                JqLog.v("non persistent result %s", jobHolder);
                if (jobHolder == null) {
                    jobHolder = this.persistentJobQueue.nextJobAndIncRunCount(this.queryConstraint);
                    JqLog.v("persistent result %s", jobHolder);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (jobHolder == null) {
                    return null;
                }
                if (z2 && (dependencyInjector = this.dependencyInjector) != null) {
                    dependencyInjector.inject(jobHolder.getJob());
                }
                jobHolder.setApplicationContext(this.appContext);
                jobHolder.setDeadlineIsReached(jobHolder.getDeadlineNs() <= nanoTime);
                if (jobHolder.getDeadlineNs() > nanoTime || !jobHolder.shouldCancelOnDeadline()) {
                }
            }
            return jobHolder;
            cancelSafely(jobHolder, 7);
            removeJob(jobHolder);
        }
    }

    public JobHolder getNextJobForTesting(Collection<String> collection) {
        return getNextJob(collection, true);
    }
}
