package com.jihuanshe.ext;

import h.e2.c;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes2.dex */
public final class UriExtKt$compress$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public UriExtKt$compress$1(c<? super UriExtKt$compress$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@d Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return UriExtKt.a(null, this);
    }
}
