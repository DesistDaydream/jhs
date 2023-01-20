package com.jihuanshe.ui.page.order;

import com.jihuanshe.model.OrderDetailInfo;
import e.l.k.k2;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerOrderDetailActivity$flowOfSetup$1 extends Lambda implements l<OrderDetailInfo, t1> {
    public final /* synthetic */ SellerOrderDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerOrderDetailActivity$flowOfSetup$1(SellerOrderDetailActivity sellerOrderDetailActivity) {
        super(1);
        this.this$0 = sellerOrderDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(OrderDetailInfo orderDetailInfo) {
        invoke2(orderDetailInfo);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d OrderDetailInfo orderDetailInfo) {
        k2 Y = this.this$0.Y();
        if (Y == null) {
            return;
        }
        Y.invalidateAll();
    }
}
