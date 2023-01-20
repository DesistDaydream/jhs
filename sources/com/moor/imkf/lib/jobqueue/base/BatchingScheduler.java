package com.moor.imkf.lib.jobqueue.base;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.moor.imkf.lib.jobqueue.scheduling.Scheduler;
import com.moor.imkf.lib.jobqueue.scheduling.SchedulerConstraint;
import com.moor.imkf.lib.jobqueue.timer.Timer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class BatchingScheduler extends Scheduler {
    public static final long DEFAULT_BATCHING_PERIOD_IN_MS = TimeUnit.SECONDS.toMillis(900);
    @VisibleForTesting
    public final long batchingDurationInMs;
    @VisibleForTesting
    public final long batchingDurationInNs;
    private final List<ConstraintWrapper> constraints;
    private final Scheduler delegate;
    private final Timer timer;

    /* loaded from: classes2.dex */
    public static class ConstraintWrapper {
        public final SchedulerConstraint constraint;
        @Nullable
        public final Long deadlineNs;
        public final long delayUntilNs;

        public ConstraintWrapper(long j2, @Nullable Long l2, SchedulerConstraint schedulerConstraint) {
            this.delayUntilNs = j2;
            this.deadlineNs = l2;
            this.constraint = schedulerConstraint;
        }
    }

    public BatchingScheduler(Scheduler scheduler, Timer timer) {
        this(scheduler, timer, DEFAULT_BATCHING_PERIOD_IN_MS);
    }

    private boolean addToConstraints(SchedulerConstraint schedulerConstraint) {
        Long l2;
        long nanoTime = this.timer.nanoTime();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long nanos = timeUnit.toNanos(schedulerConstraint.getDelayInMs()) + nanoTime;
        Long l3 = null;
        Long valueOf = schedulerConstraint.getOverrideDeadlineInMs() == null ? null : Long.valueOf(timeUnit.toNanos(schedulerConstraint.getOverrideDeadlineInMs().longValue()) + nanoTime);
        synchronized (this.constraints) {
            for (ConstraintWrapper constraintWrapper : this.constraints) {
                if (covers(constraintWrapper, schedulerConstraint, nanos, valueOf)) {
                    return false;
                }
            }
            long delayInMs = schedulerConstraint.getDelayInMs();
            long j2 = this.batchingDurationInMs;
            long j3 = ((delayInMs / j2) + 1) * j2;
            schedulerConstraint.setDelayInMs(j3);
            if (schedulerConstraint.getOverrideDeadlineInMs() != null) {
                long longValue = schedulerConstraint.getOverrideDeadlineInMs().longValue();
                long j4 = this.batchingDurationInMs;
                l2 = Long.valueOf(((longValue / j4) + 1) * j4);
                schedulerConstraint.setOverrideDeadlineInMs(l2);
            } else {
                l2 = null;
            }
            List<ConstraintWrapper> list = this.constraints;
            TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
            long nanos2 = timeUnit2.toNanos(j3) + nanoTime;
            if (l2 != null) {
                l3 = Long.valueOf(nanoTime + timeUnit2.toNanos(l2.longValue()));
            }
            list.add(new ConstraintWrapper(nanos2, l3, schedulerConstraint));
            return true;
        }
    }

    private boolean covers(ConstraintWrapper constraintWrapper, SchedulerConstraint schedulerConstraint, long j2, Long l2) {
        if (constraintWrapper.constraint.getNetworkStatus() != schedulerConstraint.getNetworkStatus()) {
            return false;
        }
        if (l2 != null) {
            Long l3 = constraintWrapper.deadlineNs;
            if (l3 == null) {
                return false;
            }
            long longValue = l3.longValue() - l2.longValue();
            if (longValue < 1 || longValue > this.batchingDurationInNs) {
                return false;
            }
        } else if (constraintWrapper.deadlineNs != null) {
            return false;
        }
        long j3 = constraintWrapper.delayUntilNs - j2;
        return j3 > 0 && j3 <= this.batchingDurationInNs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromConstraints(SchedulerConstraint schedulerConstraint) {
        synchronized (this.constraints) {
            for (int size = this.constraints.size() - 1; size >= 0; size--) {
                if (this.constraints.get(size).constraint.getUuid().equals(schedulerConstraint.getUuid())) {
                    this.constraints.remove(size);
                }
            }
        }
    }

    @Override // com.moor.imkf.lib.jobqueue.scheduling.Scheduler
    public void cancelAll() {
        synchronized (this.constraints) {
            this.constraints.clear();
        }
        this.delegate.cancelAll();
    }

    @Override // com.moor.imkf.lib.jobqueue.scheduling.Scheduler
    public void init(Context context, Scheduler.Callback callback) {
        super.init(context, callback);
        this.delegate.init(context, new Scheduler.Callback() { // from class: com.moor.imkf.lib.jobqueue.base.BatchingScheduler.1
            @Override // com.moor.imkf.lib.jobqueue.scheduling.Scheduler.Callback
            public boolean start(SchedulerConstraint schedulerConstraint) {
                BatchingScheduler.this.removeFromConstraints(schedulerConstraint);
                return BatchingScheduler.this.start(schedulerConstraint);
            }

            @Override // com.moor.imkf.lib.jobqueue.scheduling.Scheduler.Callback
            public boolean stop(SchedulerConstraint schedulerConstraint) {
                return BatchingScheduler.this.stop(schedulerConstraint);
            }
        });
    }

    @Override // com.moor.imkf.lib.jobqueue.scheduling.Scheduler
    public void onFinished(SchedulerConstraint schedulerConstraint, boolean z) {
        removeFromConstraints(schedulerConstraint);
        this.delegate.onFinished(schedulerConstraint, false);
        if (z) {
            request(schedulerConstraint);
        }
    }

    @Override // com.moor.imkf.lib.jobqueue.scheduling.Scheduler
    public void request(SchedulerConstraint schedulerConstraint) {
        if (addToConstraints(schedulerConstraint)) {
            this.delegate.request(schedulerConstraint);
        }
    }

    public BatchingScheduler(Scheduler scheduler, Timer timer, long j2) {
        this.constraints = new ArrayList();
        this.delegate = scheduler;
        this.timer = timer;
        this.batchingDurationInMs = j2;
        this.batchingDurationInNs = TimeUnit.MILLISECONDS.toNanos(j2);
    }
}
