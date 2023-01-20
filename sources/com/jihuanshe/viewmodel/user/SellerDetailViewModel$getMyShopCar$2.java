package com.jihuanshe.viewmodel.user;

import com.eth.model.NLive;
import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.CardProduct;
import com.jihuanshe.model.ShopCarInfo;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;
import okhttp3.Headers;

/* loaded from: classes2.dex */
public final class SellerDetailViewModel$getMyShopCar$2 extends Lambda implements l<Result<List<? extends CardProduct>>, t1> {
    public final /* synthetic */ SellerDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailViewModel$getMyShopCar$2(SellerDetailViewModel sellerDetailViewModel) {
        super(1);
        this.this$0 = sellerDetailViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Result<List<? extends CardProduct>> result) {
        invoke2((Result<List<CardProduct>>) result);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Result<List<CardProduct>> result) {
        int i2;
        if (result == null || !result.isSuccessful()) {
            return;
        }
        NLive<List<CardProduct>> K0 = this.this$0.K0();
        List<CardProduct> data = result.getData();
        K0.setValue(data == null ? null : CollectionsKt___CollectionsKt.L5(data));
        List<CardProduct> value = this.this$0.K0().getValue();
        boolean z = false;
        if (value == null) {
            i2 = 0;
        } else {
            i2 = 0;
            for (CardProduct cardProduct : value) {
                i2 += cardProduct.getQuantity();
            }
        }
        Headers header = result.getHeader();
        if (header == null) {
            return;
        }
        SellerDetailViewModel sellerDetailViewModel = this.this$0;
        String str = header.get("product_price");
        String str2 = header.get("free_shipping_amount");
        String str3 = header.get("shipping_price");
        if (str == null || str.length() == 0) {
            sellerDetailViewModel.T0().r(null);
        } else {
            sellerDetailViewModel.T0().r(new ShopCarInfo(Float.valueOf(Float.parseFloat(str)), str3 == null || str3.length() == 0 ? null : Float.valueOf(Float.parseFloat(str3)), (str2 == null || str2.length() == 0) ? true : true ? null : Float.valueOf(Float.parseFloat(str2)), i2));
        }
    }
}
