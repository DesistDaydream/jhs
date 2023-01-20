package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.ShopCartItem;
import com.jihuanshe.viewmodel.user.ShopCarViewModel;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopCarActivity$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ ShopCarActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopCarActivity$onItemClick$1(ShopCarActivity shopCarActivity) {
        super(2);
        this.this$0 = shopCarActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<ShopCartItem> value = ((ShopCarViewModel) this.this$0.L()).t0().getValue();
        ShopCartItem shopCartItem = value == null ? null : (ShopCartItem) CollectionsKt___CollectionsKt.J2(value, i2);
        if (shopCartItem == null) {
            return;
        }
        SellerDetailActivityCreator.create(shopCartItem.getSellerId(), null).from(Constants.Companion.getSHOP_CAR_ACTIVITY()).start(this.this$0);
    }
}
