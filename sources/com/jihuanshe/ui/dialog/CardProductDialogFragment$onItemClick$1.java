package com.jihuanshe.ui.dialog;

import android.view.View;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.GameKt;
import com.jihuanshe.ui.widget.GameBar;
import e.n.l;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardProductDialogFragment$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ CardProductDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardProductDialogFragment$onItemClick$1(CardProductDialogFragment cardProductDialogFragment) {
        super(2);
        this.this$0 = cardProductDialogFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<GameCard> products;
        GameCard gameCard;
        List<GameCard> products2;
        GameCard gameCard2;
        this.this$0.E().z(i2);
        int i3 = 1;
        this.this$0.G().setValue(1);
        l J = this.this$0.J();
        int max = GameKt.getMax(GameBar.b.a().getValue());
        CardProductNew value = this.this$0.F().getValue();
        if (value != null && (products2 = value.getProducts()) != null && (gameCard2 = (GameCard) CollectionsKt___CollectionsKt.J2(products2, i2)) != null) {
            i3 = gameCard2.getQuantity();
        }
        J.r(Integer.valueOf(Math.min(max, i3)));
        CardProductNew value2 = this.this$0.F().getValue();
        if (value2 != null) {
            CardProductNew value3 = this.this$0.F().getValue();
            String str = null;
            if (value3 != null && (products = value3.getProducts()) != null && (gameCard = (GameCard) CollectionsKt___CollectionsKt.J2(products, i2)) != null) {
                str = gameCard.getNotEmptyImage();
            }
            value2.setCardVersionDefaultImage(str);
        }
        this.this$0.F().n();
    }
}
