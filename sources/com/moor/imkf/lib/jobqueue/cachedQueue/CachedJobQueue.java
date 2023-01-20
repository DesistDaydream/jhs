package com.moor.imkf.lib.jobqueue.cachedQueue;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.moor.imkf.lib.jobqueue.base.Constraint;
import com.moor.imkf.lib.jobqueue.base.JobHolder;
import com.moor.imkf.lib.jobqueue.base.JobQueue;
import java.util.Set;

/* loaded from: classes2.dex */
public class CachedJobQueue implements JobQueue {
    private Integer cachedCount;
    private JobQueue delegate;

    public CachedJobQueue(JobQueue jobQueue) {
        this.delegate = jobQueue;
    }

    private void invalidateCache() {
        this.cachedCount = null;
    }

    private boolean isEmpty() {
        Integer num = this.cachedCount;
        return num != null && num.intValue() == 0;
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public void clear() {
        invalidateCache();
        this.delegate.clear();
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public int count() {
        if (this.cachedCount == null) {
            this.cachedCount = Integer.valueOf(this.delegate.count());
        }
        return this.cachedCount.intValue();
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public int countReadyJobs(@NonNull Constraint constraint) {
        if (isEmpty()) {
            return 0;
        }
        return this.delegate.countReadyJobs(constraint);
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    @Nullable
    public JobHolder findJobById(@NonNull String str) {
        return this.delegate.findJobById(str);
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    @NonNull
    public Set<JobHolder> findJobs(@NonNull Constraint constraint) {
        return this.delegate.findJobs(constraint);
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public Long getNextJobDelayUntilNs(@NonNull Constraint constraint) {
        return this.delegate.getNextJobDelayUntilNs(constraint);
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public boolean insert(@NonNull JobHolder jobHolder) {
        invalidateCache();
        return this.delegate.insert(jobHolder);
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public boolean insertOrReplace(@NonNull JobHolder jobHolder) {
        invalidateCache();
        return this.delegate.insertOrReplace(jobHolder);
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public JobHolder nextJobAndIncRunCount(@NonNull Constraint constraint) {
        Integer num;
        if (isEmpty()) {
            return null;
        }
        JobHolder nextJobAndIncRunCount = this.delegate.nextJobAndIncRunCount(constraint);
        if (nextJobAndIncRunCount != null && (num = this.cachedCount) != null) {
            this.cachedCount = Integer.valueOf(num.intValue() - 1);
        }
        return nextJobAndIncRunCount;
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public void onJobCancelled(@NonNull JobHolder jobHolder) {
        invalidateCache();
        this.delegate.onJobCancelled(jobHolder);
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public void remove(@NonNull JobHolder jobHolder) {
        invalidateCache();
        this.delegate.remove(jobHolder);
    }

    @Override // com.moor.imkf.lib.jobqueue.base.JobQueue
    public void substitute(@NonNull JobHolder jobHolder, @NonNull JobHolder jobHolder2) {
        invalidateCache();
        this.delegate.substitute(jobHolder, jobHolder2);
    }
}
