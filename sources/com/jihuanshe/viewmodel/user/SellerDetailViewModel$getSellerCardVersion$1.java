package com.jihuanshe.viewmodel.user;

import com.jihuanshe.model.CardProduct;
import com.jihuanshe.ui.widget.GameBar;
import e.n.f;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailViewModel$getSellerCardVersion$1 extends Lambda implements l<CardProduct, t1> {
    public final /* synthetic */ SellerDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailViewModel$getSellerCardVersion$1(SellerDetailViewModel sellerDetailViewModel) {
        super(1);
        this.this$0 = sellerDetailViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(CardProduct cardProduct) {
        invoke2(cardProduct);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e CardProduct cardProduct) {
        f<CardProduct> O0 = this.this$0.O0();
        if (cardProduct == null) {
            cardProduct = null;
        } else {
            cardProduct.setGame(GameBar.b.a().getValue());
            t1 t1Var = t1.a;
        }
        O0.setValue(cardProduct);
    }
}
