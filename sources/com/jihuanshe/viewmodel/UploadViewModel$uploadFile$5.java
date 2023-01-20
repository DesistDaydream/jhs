package com.jihuanshe.viewmodel;

import h.e2.c;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
public final class UploadViewModel$uploadFile$5 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ UploadViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadViewModel$uploadFile$5(UploadViewModel uploadViewModel, c<? super UploadViewModel$uploadFile$5> cVar) {
        super(cVar);
        this.this$0 = uploadViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@d Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.r0(null, this);
    }
}
