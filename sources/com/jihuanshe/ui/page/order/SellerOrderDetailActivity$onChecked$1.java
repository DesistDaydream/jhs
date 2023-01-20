package com.jihuanshe.ui.page.order;

import com.jihuanshe.viewmodel.order.SellerOrderDetailViewModel;
import h.k2.u.p;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerOrderDetailActivity$onChecked$1 extends Lambda implements p<Integer, Integer, t1> {
    public final /* synthetic */ SellerOrderDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerOrderDetailActivity$onChecked$1(SellerOrderDetailActivity sellerOrderDetailActivity) {
        super(2);
        this.this$0 = sellerOrderDetailActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return t1.a;
    }

    public final void invoke(int i2, int i3) {
        ((SellerOrderDetailViewModel) this.this$0.L()).B0().setValue(Integer.valueOf(i2 + 1));
    }
}
