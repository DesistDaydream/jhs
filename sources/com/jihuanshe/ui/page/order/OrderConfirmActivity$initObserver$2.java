package com.jihuanshe.ui.page.order;

import com.jihuanshe.model.Constants;
import com.jihuanshe.model.OrderConfirmResult;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderConfirmActivity$initObserver$2 extends Lambda implements l<OrderConfirmResult, t1> {
    public final /* synthetic */ OrderConfirmActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderConfirmActivity$initObserver$2(OrderConfirmActivity orderConfirmActivity) {
        super(1);
        this.this$0 = orderConfirmActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(OrderConfirmResult orderConfirmResult) {
        invoke2(orderConfirmResult);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d OrderConfirmResult orderConfirmResult) {
        this.this$0.finish();
        int d0 = this.this$0.d0();
        Constants.Companion companion = Constants.Companion;
        if (d0 == companion.getWAREHOUSE_SELLER_USER_ID()) {
            OrderDetailActivityCreator.create(orderConfirmResult.getOrderId()).from(String.valueOf(companion.getWAREHOUSE_SELLER_USER_ID())).start(this.this$0.getBaseContext());
        } else {
            OrderListActivityCreator.create(Boolean.FALSE).start(this.this$0);
        }
    }
}
