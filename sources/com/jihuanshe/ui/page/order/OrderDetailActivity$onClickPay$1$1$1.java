package com.jihuanshe.ui.page.order;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.order.OrderDetailViewModel;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderDetailActivity$onClickPay$1$1$1 extends Lambda implements a<t1> {
    public final /* synthetic */ OrderDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderDetailActivity$onClickPay$1$1$1(OrderDetailActivity orderDetailActivity) {
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
        BinderKt.p(BinderKt.k(((OrderDetailViewModel) this.this$0.L()).D0(this.this$0.c0()), this.this$0, false, 2, null));
    }
}
