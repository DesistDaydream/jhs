package com.jihuanshe.viewmodel.order;

import com.jihuanshe.model.OrderConfirmResult;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderConfirmViewModel$confirm$1 extends Lambda implements l<OrderConfirmResult, t1> {
    public final /* synthetic */ OrderConfirmViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderConfirmViewModel$confirm$1(OrderConfirmViewModel orderConfirmViewModel) {
        super(1);
        this.this$0 = orderConfirmViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(OrderConfirmResult orderConfirmResult) {
        invoke2(orderConfirmResult);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e OrderConfirmResult orderConfirmResult) {
        this.this$0.s0().setValue(orderConfirmResult);
    }
}
