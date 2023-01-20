package com.jihuanshe.ui.dialog;

import com.jihuanshe.R;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.GameKt;
import com.jihuanshe.ui.widget.GameBar;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardProductDialogFragment$flowOfSetup$2 extends Lambda implements l<CardProductNew, t1> {
    public final /* synthetic */ CardProductDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardProductDialogFragment$flowOfSetup$2(CardProductDialogFragment cardProductDialogFragment) {
        super(1);
        this.this$0 = cardProductDialogFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(CardProductNew cardProductNew) {
        invoke2(cardProductNew);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e CardProductNew cardProductNew) {
        List<GameCard> products;
        GameCard gameCard;
        List<GameCard> products2;
        GameCard gameCard2;
        String str = null;
        List<GameCard> products3 = cardProductNew == null ? null : cardProductNew.getProducts();
        int i2 = 1;
        if (products3 == null || products3.isEmpty()) {
            this.this$0.dismiss();
            e.l.h.j.b.e.d(this.this$0, Res.w(Res.a, R.string.card_removed_tip, null, 2, null), (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? 1 : 0, (r13 & 32) == 0 ? null : null);
            return;
        }
        if (cardProductNew != null) {
            cardProductNew.setUserUploadPhotoPath(null);
        }
        if (cardProductNew != null) {
            if (cardProductNew != null && (products2 = cardProductNew.getProducts()) != null && (gameCard2 = (GameCard) CollectionsKt___CollectionsKt.J2(products2, 0)) != null) {
                str = gameCard2.getNotEmptyImage();
            }
            cardProductNew.setCardVersionDefaultImage(str);
        }
        this.this$0.F().r(cardProductNew);
        e.n.l J = this.this$0.J();
        int max = GameKt.getMax(GameBar.b.a().getValue());
        if (cardProductNew != null && (products = cardProductNew.getProducts()) != null && (gameCard = (GameCard) CollectionsKt___CollectionsKt.J2(products, 0)) != null) {
            i2 = gameCard.getQuantity();
        }
        J.r(Integer.valueOf(Math.min(max, i2)));
    }
}
