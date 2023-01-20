package com.jihuanshe.ui.page.shop;

import android.view.View;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.dialog.EditProductDialog;
import e.l.s.n.a;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddProductActivity$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ AddProductActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddProductActivity$onItemClick$1(AddProductActivity addProductActivity) {
        super(2);
        this.this$0 = addProductActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<GameCard> products;
        CardProductNew value = ((a) this.this$0.L()).A0().getValue();
        GameCard gameCard = null;
        if (value != null && (products = value.getProducts()) != null) {
            gameCard = (GameCard) CollectionsKt___CollectionsKt.J2(products, i2);
        }
        if (gameCard == null || gameCard.getPullOff()) {
            return;
        }
        EditProductDialog.x.a(gameCard.getProductId(), Integer.valueOf(this.this$0.Z()), this.this$0.d0(), this.this$0.e0()).show(this.this$0.getSupportFragmentManager(), "edit");
    }
}
