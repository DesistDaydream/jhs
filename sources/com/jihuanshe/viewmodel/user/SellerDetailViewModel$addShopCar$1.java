package com.jihuanshe.viewmodel.user;

import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.CardProduct;
import com.jihuanshe.model.ShopCarInfo;
import com.jihuanshe.model.ShopCarResult;
import e.n.f;
import h.k2.u.l;
import h.t1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;
import okhttp3.Headers;

/* loaded from: classes2.dex */
public final class SellerDetailViewModel$addShopCar$1 extends Lambda implements l<Result<ShopCarResult>, t1> {
    public final /* synthetic */ int $num;
    public final /* synthetic */ CardProduct $pro;
    public final /* synthetic */ SellerDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailViewModel$addShopCar$1(SellerDetailViewModel sellerDetailViewModel, int i2, CardProduct cardProduct) {
        super(1);
        this.this$0 = sellerDetailViewModel;
        this.$num = i2;
        this.$pro = cardProduct;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Result<ShopCarResult> result) {
        invoke2(result);
        return t1.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Result<ShopCarResult> result) {
        boolean z;
        if (result == null || !result.isSuccessful()) {
            e.l.h.j.b.e.f(this.this$0, result != null ? result.getMsg() : 0, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
            return;
        }
        Headers header = result.getHeader();
        if (header == null) {
            return;
        }
        SellerDetailViewModel sellerDetailViewModel = this.this$0;
        int i2 = this.$num;
        CardProduct cardProduct = this.$pro;
        String str = header.get("product_price");
        ShopCarInfo value = sellerDetailViewModel.T0().getValue();
        if (value == null) {
            value = new ShopCarInfo(null, null, null, 0, 15, null);
        }
        f<ShopCarInfo> T0 = sellerDetailViewModel.T0();
        value.setPrice(Float.valueOf(str == null || str.length() == 0 ? 0.0f : Float.parseFloat(str)));
        List<CardProduct> value2 = sellerDetailViewModel.K0().getValue();
        if (value2 != null) {
            Iterator it = value2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((CardProduct) next).getPid() == cardProduct.getPid()) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    r1 = next;
                    break;
                }
            }
            r1 = (CardProduct) r1;
        }
        if (r1 == null) {
            value.setCount(value.getCount() + i2);
            List<CardProduct> value3 = sellerDetailViewModel.K0().getValue();
            if (value3 == null) {
                value3 = new ArrayList<>();
            }
            value3.add(cardProduct);
        }
        t1 t1Var = t1.a;
        T0.setValue(value);
    }
}
