package com.moor.imkf.lib.jobqueue.callback;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.moor.imkf.lib.jobqueue.base.Job;

/* loaded from: classes2.dex */
public class JobManagerCallbackAdapter implements JobManagerCallback {
    @Override // com.moor.imkf.lib.jobqueue.callback.JobManagerCallback
    public void onAfterJobRun(@NonNull Job job, int i2) {
    }

    @Override // com.moor.imkf.lib.jobqueue.callback.JobManagerCallback
    public void onDone(@NonNull Job job) {
    }

    @Override // com.moor.imkf.lib.jobqueue.callback.JobManagerCallback
    public void onJobAdded(@NonNull Job job) {
    }

    @Override // com.moor.imkf.lib.jobqueue.callback.JobManagerCallback
    public void onJobCancelled(@NonNull Job job, boolean z, @Nullable Throwable th) {
    }

    @Override // com.moor.imkf.lib.jobqueue.callback.JobManagerCallback
    public void onJobRun(@NonNull Job job, int i2) {
    }
}
