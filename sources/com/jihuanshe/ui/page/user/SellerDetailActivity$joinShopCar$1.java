package com.jihuanshe.ui.page.user;

import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.CardProduct;
import com.jihuanshe.model.ShopCarResult;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$joinShopCar$1 extends Lambda implements l<Result<ShopCarResult>, t1> {
    public final /* synthetic */ CardProduct $p;
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$joinShopCar$1(SellerDetailActivity sellerDetailActivity, CardProduct cardProduct) {
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
        List<CardProduct> value = ((SellerDetailViewModel) this.this$0.L()).K0().getValue();
        if (value == null) {
            return;
        }
        CardProduct cardProduct = this.$p;
        SellerDetailActivity sellerDetailActivity = this.this$0;
        for (CardProduct cardProduct2 : value) {
            if (cardProduct2.getPid() == cardProduct.getPid()) {
                cardProduct2.setQuantity(result.getData().getNum());
                ((SellerDetailViewModel) sellerDetailActivity.L()).K0().n();
                ((SellerDetailViewModel) sellerDetailActivity.L()).L0(sellerDetailActivity.Z0());
                return;
            }
        }
    }
}
