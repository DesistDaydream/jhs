package com.jihuanshe.viewmodel.order;

import com.jihuanshe.model.ChangePriceResult;
import com.jihuanshe.model.OrderDetailInfo;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerOrderDetailViewModel$changePrice$1 extends Lambda implements l<ChangePriceResult, t1> {
    public final /* synthetic */ Float $price;
    public final /* synthetic */ Float $shipping;
    public final /* synthetic */ SellerOrderDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerOrderDetailViewModel$changePrice$1(Float f2, SellerOrderDetailViewModel sellerOrderDetailViewModel, Float f3) {
        super(1);
        this.$price = f2;
        this.this$0 = sellerOrderDetailViewModel;
        this.$shipping = f3;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ChangePriceResult changePriceResult) {
        invoke2(changePriceResult);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e ChangePriceResult changePriceResult) {
        Float actualPrice;
        if (this.$price != null) {
            OrderDetailInfo value = this.this$0.C0().getValue();
            if (value != null) {
                value.setActualPrice((changePriceResult == null || (actualPrice = changePriceResult.getActualPrice()) == null) ? 0.0f : actualPrice.floatValue());
            }
            OrderDetailInfo value2 = this.this$0.C0().getValue();
            if (value2 != null) {
                value2.setFee(changePriceResult == null ? null : changePriceResult.getFee());
            }
            OrderDetailInfo value3 = this.this$0.C0().getValue();
            if (value3 != null) {
                Float f2 = this.$shipping;
                value3.setShippingPrice(f2 != null ? f2.floatValue() : 0.0f);
            }
            this.this$0.C0().n();
        }
    }
}
