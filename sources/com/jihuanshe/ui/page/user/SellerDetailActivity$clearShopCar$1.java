package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.model.CardProduct;
import com.jihuanshe.ui.dialog.UseDialog;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$clearShopCar$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$clearShopCar$1(SellerDetailActivity sellerDetailActivity) {
        super(1);
        this.this$0 = sellerDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        List<CardProduct> value = ((SellerDetailViewModel) this.this$0.L()).K0().getValue();
        if (value == null || value.isEmpty()) {
            return;
        }
        UseDialog useDialog = new UseDialog(this.this$0);
        SellerDetailActivity sellerDetailActivity = this.this$0;
        useDialog.setContent(R.string.coomon_clear_shop_car_confirm);
        useDialog.setOnClickRightButton(new SellerDetailActivity$clearShopCar$1$1$1(sellerDetailActivity));
        useDialog.y();
    }
}
