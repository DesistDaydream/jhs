package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.model.CardProduct;
import com.jihuanshe.ui.dialog.UseDialog;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$onMinusClick$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardProduct $p;
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$onMinusClick$1(CardProduct cardProduct, SellerDetailActivity sellerDetailActivity) {
        super(1);
        this.$p = cardProduct;
        this.this$0 = sellerDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        if (this.$p.getQuantity() > 1) {
            this.this$0.i1(this.$p);
            return;
        }
        UseDialog useDialog = new UseDialog(this.this$0);
        SellerDetailActivity sellerDetailActivity = this.this$0;
        CardProduct cardProduct = this.$p;
        useDialog.setContent(Res.w(Res.a, R.string.common_remove_product, null, 2, null));
        useDialog.setOnClickRightButton(new SellerDetailActivity$onMinusClick$1$1$1(sellerDetailActivity, cardProduct));
        useDialog.y();
    }
}
