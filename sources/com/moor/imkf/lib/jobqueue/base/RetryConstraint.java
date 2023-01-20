package com.moor.imkf.lib.jobqueue.base;

/* loaded from: classes2.dex */
public class RetryConstraint {
    private boolean applyNewDelayToGroup = false;
    private Long newDelayInMs;
    private Integer newPriority;
    private boolean retry;
    public static final RetryConstraint RETRY = new ImmutableRetryConstraint(true);
    public static final RetryConstraint CANCEL = new ImmutableRetryConstraint(false);

    /* loaded from: classes2.dex */
    public static class ImmutableRetryConstraint extends RetryConstraint {
        private static final String MESSAGE = "This object is immutable. Create a new one using the constructor.";

        public ImmutableRetryConstraint(boolean z) {
            super(z);
        }

        @Override // com.moor.imkf.lib.jobqueue.base.RetryConstraint
        public void setNewDelayInMs(Long l2) {
            throw new IllegalStateException(MESSAGE);
        }

        @Override // com.moor.imkf.lib.jobqueue.base.RetryConstraint
        public void setNewPriority(Integer num) {
            throw new IllegalStateException(MESSAGE);
        }

        @Override // com.moor.imkf.lib.jobqueue.base.RetryConstraint
        public void setRetry(boolean z) {
            throw new IllegalStateException(MESSAGE);
        }
    }

    public RetryConstraint(boolean z) {
        this.retry = z;
    }

    public static RetryConstraint createExponentialBackoff(int i2, long j2) {
        RetryConstraint retryConstraint = new RetryConstraint(true);
        retryConstraint.setNewDelayInMs(Long.valueOf(j2 * ((long) Math.pow(2.0d, Math.max(0, i2 - 1)))));
        return retryConstraint;
    }

    public Long getNewDelayInMs() {
        return this.newDelayInMs;
    }

    public Integer getNewPriority() {
        return this.newPriority;
    }

    public void setApplyNewDelayToGroup(boolean z) {
        this.applyNewDelayToGroup = z;
    }

    public void setNewDelayInMs(Long l2) {
        this.newDelayInMs = l2;
    }

    public void setNewPriority(Integer num) {
        this.newPriority = num;
    }

    public void setRetry(boolean z) {
        this.retry = z;
    }

    public boolean shouldRetry() {
        return this.retry;
    }

    public boolean willApplyNewDelayToGroup() {
        return this.applyNewDelayToGroup;
    }
}
