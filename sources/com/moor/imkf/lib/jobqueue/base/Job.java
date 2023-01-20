package com.moor.imkf.lib.jobqueue.base;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.moor.imkf.lib.jobqueue.log.JqLog;
import com.moor.imkf.lib.jobqueue.timer.Timer;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes2.dex */
public abstract class Job implements Serializable {
    public static final int DEFAULT_RETRY_LIMIT = 20;
    public static final String SINGLE_ID_TAG_PREFIX = "job-single-id:";
    private static final long serialVersionUID = 3;
    private transient Context applicationContext;
    private transient boolean cancelOnDeadline;
    public volatile transient boolean cancelled;
    private transient int currentRunCount;
    private transient long deadlineInMs;
    private transient long delayInMs;
    private transient String groupId;
    private transient String id = UUID.randomUUID().toString();
    private volatile transient boolean isDeadlineReached;
    private transient boolean persistent;
    public transient int priority;
    private transient Set<String> readonlyTags;
    public transient int requiredNetworkType;
    private volatile transient boolean sealed;

    public Job(Params params) {
        this.requiredNetworkType = params.requiredNetworkType;
        this.persistent = params.isPersistent();
        this.groupId = params.getGroupId();
        this.priority = params.getPriority();
        this.delayInMs = Math.max(0L, params.getDelayMs());
        this.deadlineInMs = Math.max(0L, params.getDeadlineMs());
        this.cancelOnDeadline = params.shouldCancelOnDeadline();
        String singleId = params.getSingleId();
        if (params.getTags() != null || singleId != null) {
            HashSet<String> tags = params.getTags() != null ? params.getTags() : new HashSet<>();
            if (singleId != null) {
                String createTagForSingleId = createTagForSingleId(singleId);
                tags.add(createTagForSingleId);
                if (this.groupId == null) {
                    this.groupId = createTagForSingleId;
                }
            }
            this.readonlyTags = Collections.unmodifiableSet(tags);
        }
        long j2 = this.deadlineInMs;
        if (j2 <= 0 || j2 >= this.delayInMs) {
            return;
        }
        throw new IllegalArgumentException("deadline cannot be less than the delay. It does not make sense. deadline:" + this.deadlineInMs + ",delay:" + this.delayInMs);
    }

    private String createTagForSingleId(String str) {
        return SINGLE_ID_TAG_PREFIX + str;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        if (!this.sealed) {
            throw new IllegalStateException("A job cannot be serialized w/o first being added into a job manager.");
        }
    }

    public void assertNotCancelled() {
        if (this.cancelled) {
            throw new RuntimeException("job is cancelled");
        }
    }

    public Context getApplicationContext() {
        return this.applicationContext;
    }

    public final int getCurrentRunCount() {
        return this.currentRunCount;
    }

    public long getDeadlineInMs() {
        return this.deadlineInMs;
    }

    public final long getDelayInMs() {
        return this.delayInMs;
    }

    public final String getId() {
        return this.id;
    }

    public final int getPriority() {
        return this.priority;
    }

    public int getRetryLimit() {
        return 20;
    }

    public final String getRunGroupId() {
        return this.groupId;
    }

    public final String getSingleInstanceId() {
        Set<String> set = this.readonlyTags;
        if (set != null) {
            for (String str : set) {
                if (str.startsWith(SINGLE_ID_TAG_PREFIX)) {
                    return str;
                }
            }
            return null;
        }
        return null;
    }

    @Nullable
    public final Set<String> getTags() {
        return this.readonlyTags;
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public boolean isDeadlineReached() {
        return this.isDeadlineReached;
    }

    public final boolean isPersistent() {
        return this.persistent;
    }

    public abstract void onAdded();

    public abstract void onCancel(int i2, @Nullable Throwable th);

    public abstract void onRun() throws Throwable;

    public final boolean requiresNetwork() {
        return this.requiredNetworkType >= 1;
    }

    public final boolean requiresUnmeteredNetwork() {
        return this.requiredNetworkType >= 2;
    }

    public final int safeRun(JobHolder jobHolder, int i2, Timer timer) {
        boolean z;
        boolean z2;
        boolean z3;
        this.currentRunCount = i2;
        if (JqLog.isDebugEnabled()) {
            JqLog.d("running job %s", getClass().getSimpleName());
        }
        Throwable th = null;
        try {
            onRun();
            if (JqLog.isDebugEnabled()) {
                JqLog.d("finished job %s", this);
            }
            z = false;
            z2 = false;
            z3 = false;
        } catch (Throwable th2) {
            th = th2;
            JqLog.e(th, "error while executing job %s", this);
            z = jobHolder.shouldCancelOnDeadline() && jobHolder.getDeadlineNs() <= timer.nanoTime();
            z2 = i2 < getRetryLimit() && !z;
            if (z2 && !this.cancelled) {
                try {
                    RetryConstraint shouldReRunOnThrowable = shouldReRunOnThrowable(th, i2, getRetryLimit());
                    if (shouldReRunOnThrowable == null) {
                        shouldReRunOnThrowable = RetryConstraint.RETRY;
                    }
                    jobHolder.retryConstraint = shouldReRunOnThrowable;
                    z2 = shouldReRunOnThrowable.shouldRetry();
                } catch (Throwable th3) {
                    JqLog.e(th3, "shouldReRunOnThrowable did throw an exception", new Object[0]);
                }
            }
            z3 = true;
        }
        JqLog.d("safeRunResult for %s : %s. re run:%s. cancelled: %s", this, Boolean.valueOf(!z3), Boolean.valueOf(z2), Boolean.valueOf(this.cancelled));
        if (z3) {
            if (jobHolder.isCancelledSingleId()) {
                return 6;
            }
            if (jobHolder.isCancelled()) {
                return 3;
            }
            if (z2) {
                return 4;
            }
            if (z) {
                return 7;
            }
            if (i2 < getRetryLimit()) {
                jobHolder.setThrowable(th);
                return 5;
            }
            jobHolder.setThrowable(th);
            return 2;
        }
        return 1;
    }

    public void setApplicationContext(Context context) {
        this.applicationContext = context;
    }

    public void setDeadlineReached(boolean z) {
        this.isDeadlineReached = z;
    }

    public boolean shouldCancelOnDeadline() {
        return this.cancelOnDeadline;
    }

    public abstract RetryConstraint shouldReRunOnThrowable(@NonNull Throwable th, int i2, int i3);

    public final void updateFromJobHolder(JobHolder jobHolder) {
        if (!this.sealed) {
            this.id = jobHolder.id;
            this.groupId = jobHolder.groupId;
            this.priority = jobHolder.getPriority();
            this.persistent = jobHolder.persistent;
            this.readonlyTags = jobHolder.tags;
            this.requiredNetworkType = jobHolder.requiredNetworkType;
            this.sealed = true;
            return;
        }
        throw new IllegalStateException("Cannot set a Job from JobHolder after it is sealed.");
    }
}
