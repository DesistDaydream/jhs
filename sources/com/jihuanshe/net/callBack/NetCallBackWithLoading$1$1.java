package com.jihuanshe.net.callBack;

import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class NetCallBackWithLoading$1$1 extends Lambda implements a<t1> {
    public final /* synthetic */ NetCallBackWithLoading<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetCallBackWithLoading$1$1(NetCallBackWithLoading<T> netCallBackWithLoading) {
        super(0);
        this.this$0 = netCallBackWithLoading;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.a();
    }
}
