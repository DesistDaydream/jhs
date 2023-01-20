package com.jihuanshe.ui.page.user;

import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.CardProduct;
import com.jihuanshe.model.ShopCarResult;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$minusShopCar$1 extends Lambda implements l<Result<ShopCarResult>, t1> {
    public final /* synthetic */ CardProduct $p;
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$minusShopCar$1(SellerDetailActivity sellerDetailActivity, CardProduct cardProduct) {
        super(1);
        this.this$0 = sellerDetailActivity;
        this.$p = cardProduct;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Result<ShopCarResult> result) {
        invoke2(result);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Result<ShopCarResult> result) {
        ShopCarResult data;
        List<CardProduct> value = ((SellerDetailViewModel) this.this$0.L()).K0().getValue();
        List<CardProduct> L5 = value == null ? null : CollectionsKt___CollectionsKt.L5(value);
        if (L5 == null) {
            return;
        }
        CardProduct cardProduct = this.$p;
        SellerDetailActivity sellerDetailActivity = this.this$0;
        for (CardProduct cardProduct2 : L5) {
            if (cardProduct2.getPid() == cardProduct.getPid()) {
                int i2 = 0;
                if (result != null && (data = result.getData()) != null) {
                    i2 = data.getNum();
                }
                if (i2 > 0) {
                    cardProduct2.setQuantity(result.getData().getNum());
                } else {
                    L5.remove(cardProduct2);
                }
                if (L5.isEmpty()) {
                    ((SellerDetailViewModel) sellerDetailActivity.L()).V0().setValue(Boolean.FALSE);
                }
                ((SellerDetailViewModel) sellerDetailActivity.L()).K0().setValue(L5);
                ((SellerDetailViewModel) sellerDetailActivity.L()).L0(sellerDetailActivity.Z0());
                return;
            }
        }
    }
}
