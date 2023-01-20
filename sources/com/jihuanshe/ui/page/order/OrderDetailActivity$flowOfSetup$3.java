package com.jihuanshe.ui.page.order;

import com.jihuanshe.viewmodel.order.OrderDetailViewModel;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderDetailActivity$flowOfSetup$3 extends Lambda implements a<t1> {
    public final /* synthetic */ OrderDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderDetailActivity$flowOfSetup$3(OrderDetailActivity orderDetailActivity) {
        super(0);
        this.this$0 = orderDetailActivity;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((OrderDetailViewModel) this.this$0.L()).A0().setValue(2);
    }
}
