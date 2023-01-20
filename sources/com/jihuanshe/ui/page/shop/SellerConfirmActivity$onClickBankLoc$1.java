package com.jihuanshe.ui.page.shop;

import android.view.View;
import com.jihuanshe.ui.dialog.AddressDialog3;
import com.jihuanshe.viewmodel.shop.SellerConfirmViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerConfirmActivity$onClickBankLoc$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SellerConfirmActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerConfirmActivity$onClickBankLoc$1(SellerConfirmActivity sellerConfirmActivity) {
        super(1);
        this.this$0 = sellerConfirmActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        if (((SellerConfirmViewModel) this.this$0.L()).H0() == null) {
            return;
        }
        SellerConfirmActivity sellerConfirmActivity = this.this$0;
        AddressDialog3 addressDialog3 = new AddressDialog3(sellerConfirmActivity, ((SellerConfirmViewModel) sellerConfirmActivity.L()).H0());
        addressDialog3.setListener(new SellerConfirmActivity$onClickBankLoc$1$1$1(this.this$0));
        addressDialog3.y();
    }
}
