package com.jihuanshe.ui.page.entrepot;

import e.l.h.j.b.e;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SubmitOrderReturnActivity$flowOfSetup$1 extends Lambda implements a<t1> {
    public final /* synthetic */ SubmitOrderReturnActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubmitOrderReturnActivity$flowOfSetup$1(SubmitOrderReturnActivity submitOrderReturnActivity) {
        super(0);
        this.this$0 = submitOrderReturnActivity;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        e.h(this.this$0, "支付完成", null, null, null, 0, null, 62, null);
        this.this$0.finish();
    }
}
