package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.model.Constants;
import h.k2.u.a;
import h.k2.v.f0;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ConsignmentOrderFragment$flowOfSetup$1 extends Lambda implements a<t1> {
    public final /* synthetic */ ConsignmentOrderFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsignmentOrderFragment$flowOfSetup$1(ConsignmentOrderFragment consignmentOrderFragment) {
        super(0);
        this.this$0 = consignmentOrderFragment;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (f0.g(this.this$0.getType(), Constants.STATE_WAITING_PAY)) {
            this.this$0.h0().h();
        }
    }
}
