package com.jihuanshe.ui.page.order;

import com.jihuanshe.adapter.OrderProductAdapter;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderConfirmActivity$adapter$2 extends Lambda implements a<OrderProductAdapter> {
    public final /* synthetic */ OrderConfirmActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderConfirmActivity$adapter$2(OrderConfirmActivity orderConfirmActivity) {
        super(0);
        this.this$0 = orderConfirmActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final OrderProductAdapter invoke() {
        return new OrderProductAdapter(this.this$0);
    }
}
