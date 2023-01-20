package com.huawei.hms.common.internal;

import e.k.b.a.l;

/* loaded from: classes2.dex */
public class TaskApiCallWrapper<TResult> extends BaseContentWrapper {
    private final TaskApiCall<? extends AnyClient, TResult> mTaskApiCall;
    private final l<TResult> mTaskCompletionSource;

    public TaskApiCallWrapper(TaskApiCall<? extends AnyClient, TResult> taskApiCall, l<TResult> lVar) {
        super(1);
        this.mTaskApiCall = taskApiCall;
        this.mTaskCompletionSource = lVar;
    }

    public TaskApiCall<? extends AnyClient, TResult> getTaskApiCall() {
        return this.mTaskApiCall;
    }

    public l<TResult> getTaskCompletionSource() {
        return this.mTaskCompletionSource;
    }
}
