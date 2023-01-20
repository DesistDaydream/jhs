package com.moor.imkf.lib.jobqueue.base;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.moor.imkf.lib.jobqueue.timer.Timer;
import java.util.Set;

/* loaded from: classes2.dex */
public class JobHolder {
    public static final int RUN_RESULT_FAIL_FOR_CANCEL = 3;
    public static final int RUN_RESULT_FAIL_RUN_LIMIT = 2;
    public static final int RUN_RESULT_FAIL_SHOULD_RE_RUN = 5;
    public static final int RUN_RESULT_FAIL_SINGLE_ID = 6;
    public static final int RUN_RESULT_HIT_DEADLINE = 7;
    public static final int RUN_RESULT_SUCCESS = 1;
    public static final int RUN_RESULT_TRY_AGAIN = 4;
    private boolean cancelOnDeadline;
    private volatile boolean cancelled;
    private volatile boolean cancelledSingleId;
    private long createdNs;
    private long deadlineNs;
    private long delayUntilNs;
    public final String groupId;
    public final String id;
    private Long insertionOrder;
    public final transient Job job;
    public final boolean persistent;
    private int priority;
    public int requiredNetworkType;
    public RetryConstraint retryConstraint;
    private int runCount;
    private long runningSessionId;
    public final Set<String> tags;
    @Nullable
    private Throwable throwable;

    /* loaded from: classes2.dex */
    public static class Builder {
        private static final int FLAG_CREATED_NS = 32;
        private static final int FLAG_DEADLINE = 128;
        private static final int FLAG_DELAY_UNTIL = 64;
        private static final int FLAG_GROUP_ID = 8;
        private static final int FLAG_ID = 4;
        private static final int FLAG_JOB = 16;
        private static final int FLAG_PERSISTENT = 2;
        private static final int FLAG_PRIORITY = 1;
        private static final int FLAG_REQ_NETWORK = 1024;
        private static final int FLAG_RUNNING_SESSION_ID = 256;
        private static final int FLAG_TAGS = 512;
        private static final int REQUIRED_FLAGS = 2047;
        private long createdNs;
        private String groupId;
        private String id;
        private Long insertionOrder;
        private Job job;
        private boolean persistent;
        private int priority;
        private int requiredNetworkType;
        private long runningSessionId;
        private Set<String> tags;
        private int runCount = 0;
        private long delayUntilNs = Long.MIN_VALUE;
        private long deadlineNs = Long.MAX_VALUE;
        private boolean cancelOnDeadline = false;
        private int providedFlags = 0;

        public JobHolder build() {
            JobHolder jobHolder;
            Job job = this.job;
            if (job != null) {
                int i2 = this.providedFlags & REQUIRED_FLAGS;
                if (i2 == REQUIRED_FLAGS) {
                    JobHolder jobHolder2 = new JobHolder(this.id, this.persistent, this.priority, this.groupId, this.runCount, job, this.createdNs, this.delayUntilNs, this.runningSessionId, this.tags, this.requiredNetworkType, this.deadlineNs, this.cancelOnDeadline);
                    Long l2 = this.insertionOrder;
                    if (l2 != null) {
                        jobHolder = jobHolder2;
                        jobHolder.setInsertionOrder(l2.longValue());
                    } else {
                        jobHolder = jobHolder2;
                    }
                    this.job.updateFromJobHolder(jobHolder);
                    return jobHolder;
                }
                throw new IllegalArgumentException("must provide all required fields. your result:" + Long.toBinaryString(i2));
            }
            throw new IllegalArgumentException("must provide a job");
        }

        public Builder createdNs(long j2) {
            this.createdNs = j2;
            this.providedFlags |= 32;
            return this;
        }

        public Builder deadline(long j2, boolean z) {
            this.deadlineNs = j2;
            this.cancelOnDeadline = z;
            this.providedFlags |= 128;
            return this;
        }

        public Builder delayUntilNs(long j2) {
            this.delayUntilNs = j2;
            this.providedFlags |= 64;
            return this;
        }

        public Builder groupId(String str) {
            this.groupId = str;
            this.providedFlags |= 8;
            return this;
        }

        public Builder id(String str) {
            this.id = str;
            this.providedFlags |= 4;
            return this;
        }

        public Builder insertionOrder(long j2) {
            this.insertionOrder = Long.valueOf(j2);
            return this;
        }

        public Builder job(Job job) {
            this.job = job;
            this.providedFlags |= 16;
            return this;
        }

        public Builder persistent(boolean z) {
            this.persistent = z;
            this.providedFlags |= 2;
            return this;
        }

        public Builder priority(int i2) {
            this.priority = i2;
            this.providedFlags |= 1;
            return this;
        }

        public Builder requiredNetworkType(int i2) {
            this.requiredNetworkType = i2;
            this.providedFlags |= 1024;
            return this;
        }

        public Builder runCount(int i2) {
            this.runCount = i2;
            return this;
        }

        public Builder runningSessionId(long j2) {
            this.runningSessionId = j2;
            this.providedFlags |= 256;
            return this;
        }

        public Builder tags(Set<String> set) {
            this.tags = set;
            this.providedFlags |= 512;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof JobHolder) {
            return this.id.equals(((JobHolder) obj).id);
        }
        return false;
    }

    public long getCreatedNs() {
        return this.createdNs;
    }

    public long getDeadlineNs() {
        return this.deadlineNs;
    }

    public long getDelayUntilNs() {
        return this.delayUntilNs;
    }

    public String getGroupId() {
        return this.groupId;
    }

    @NonNull
    public String getId() {
        return this.id;
    }

    public Long getInsertionOrder() {
        return this.insertionOrder;
    }

    public Job getJob() {
        return this.job;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getRequiredNetworkType() {
        return this.requiredNetworkType;
    }

    public RetryConstraint getRetryConstraint() {
        return this.retryConstraint;
    }

    public int getRunCount() {
        return this.runCount;
    }

    public long getRunningSessionId() {
        return this.runningSessionId;
    }

    public final String getSingleInstanceId() {
        Set<String> set = this.tags;
        if (set != null) {
            for (String str : set) {
                if (str.startsWith(Job.SINGLE_ID_TAG_PREFIX)) {
                    return str;
                }
            }
            return null;
        }
        return null;
    }

    public Set<String> getTags() {
        return this.tags;
    }

    @Nullable
    public Throwable getThrowable() {
        return this.throwable;
    }

    public boolean hasDeadline() {
        return this.deadlineNs != Long.MAX_VALUE;
    }

    public boolean hasDelay() {
        return this.delayUntilNs != Long.MIN_VALUE;
    }

    public boolean hasTags() {
        Set<String> set = this.tags;
        return set != null && set.size() > 0;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public boolean isCancelledSingleId() {
        return this.cancelledSingleId;
    }

    public void markAsCancelled() {
        this.cancelled = true;
        this.job.cancelled = true;
    }

    public void markAsCancelledSingleId() {
        this.cancelledSingleId = true;
        markAsCancelled();
    }

    public void onCancel(int i2) {
        this.job.onCancel(i2, this.throwable);
    }

    public int safeRun(int i2, Timer timer) {
        return this.job.safeRun(this, i2, timer);
    }

    public void setApplicationContext(Context context) {
        this.job.setApplicationContext(context);
    }

    public void setDeadlineIsReached(boolean z) {
        this.job.setDeadlineReached(z);
    }

    public void setDelayUntilNs(long j2) {
        this.delayUntilNs = j2;
    }

    public void setInsertionOrder(long j2) {
        this.insertionOrder = Long.valueOf(j2);
    }

    public void setPriority(int i2) {
        this.priority = i2;
        this.job.priority = i2;
    }

    public void setRunCount(int i2) {
        this.runCount = i2;
    }

    public void setRunningSessionId(long j2) {
        this.runningSessionId = j2;
    }

    public void setThrowable(@Nullable Throwable th) {
        this.throwable = th;
    }

    public boolean shouldCancelOnDeadline() {
        return this.cancelOnDeadline;
    }

    private JobHolder(String str, boolean z, int i2, String str2, int i3, Job job, long j2, long j3, long j4, Set<String> set, int i4, long j5, boolean z2) {
        this.id = str;
        this.persistent = z;
        this.priority = i2;
        this.groupId = str2;
        this.runCount = i3;
        this.createdNs = j2;
        this.delayUntilNs = j3;
        this.job = job;
        this.runningSessionId = j4;
        this.requiredNetworkType = i4;
        this.tags = set;
        this.deadlineNs = j5;
        this.cancelOnDeadline = z2;
    }
}
