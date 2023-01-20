package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.model.CardProduct;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$onAddClick$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardProduct $p;
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$onAddClick$1(SellerDetailActivity sellerDetailActivity, CardProduct cardProduct) {
        super(1);
        this.this$0 = sellerDetailActivity;
        this.$p = cardProduct;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        this.this$0.g1(this.$p, 1);
    }
}
