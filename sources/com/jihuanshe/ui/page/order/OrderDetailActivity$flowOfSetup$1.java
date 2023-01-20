package com.jihuanshe.ui.page.order;

import com.jihuanshe.model.OrderDetailInfo;
import e.l.k.q1;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderDetailActivity$flowOfSetup$1 extends Lambda implements l<OrderDetailInfo, t1> {
    public final /* synthetic */ OrderDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderDetailActivity$flowOfSetup$1(OrderDetailActivity orderDetailActivity) {
        super(1);
        this.this$0 = orderDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(OrderDetailInfo orderDetailInfo) {
        invoke2(orderDetailInfo);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d OrderDetailInfo orderDetailInfo) {
        q1 X = this.this$0.X();
        if (X == null) {
            return;
        }
        X.invalidateAll();
    }
}
