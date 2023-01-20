package com.jihuanshe.ui.page.common.card;

import android.view.View;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.ui.dialog.CardBaseInfoDetailDialog;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ProductManagerHeaderImpl$clickProductDetail$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardProductNew $product;
    public final /* synthetic */ ProductManagerHeaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductManagerHeaderImpl$clickProductDetail$1(CardProductNew cardProductNew, ProductManagerHeaderImpl productManagerHeaderImpl) {
        super(1);
        this.$product = cardProductNew;
        this.this$0 = productManagerHeaderImpl;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        CardProductNew cardProductNew = this.$product;
        if (cardProductNew == null) {
            return;
        }
        CardBaseInfoDetailDialog.a aVar = CardBaseInfoDetailDialog.f3950m;
        int cardId = cardProductNew.getCardId();
        int intValue = this.$product.getCardVersionId().intValue();
        String gameKey = this.$product.getGameKey();
        if (gameKey == null) {
            gameKey = "";
        }
        aVar.a(cardId, intValue, gameKey).show(this.this$0.l(), "product_detail");
    }
}
