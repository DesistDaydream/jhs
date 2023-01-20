package com.jihuanshe.ui.page.search.fragments.cardrepo;

import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel;
import h.k2.u.l;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardRepoSearchFragment$onSoldOrOffSold$2 extends Lambda implements l<t1, t1> {
    public final /* synthetic */ GameCard $card;
    public final /* synthetic */ CardRepoSearchFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardRepoSearchFragment$onSoldOrOffSold$2(CardRepoSearchFragment cardRepoSearchFragment, GameCard gameCard) {
        super(1);
        this.this$0 = cardRepoSearchFragment;
        this.$card = gameCard;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
        invoke2(t1Var);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e t1 t1Var) {
        CardProductNew value = ((CardRepoSearchViewModel) this.this$0.T()).x0().getValue();
        List<GameCard> products = value == null ? null : value.getProducts();
        Objects.requireNonNull(products, "null cannot be cast to non-null type java.util.ArrayList<com.jihuanshe.model.GameCard>");
        ((ArrayList) products).remove(this.this$0.v0().intValue());
        this.this$0.D0(null);
        ((CardRepoSearchViewModel) this.this$0.T()).x0().n();
        List<GameCard> value2 = this.this$0.y0().D0().getValue();
        List<GameCard> L5 = value2 != null ? CollectionsKt___CollectionsKt.L5(value2) : null;
        if (L5 != null) {
            L5.remove(this.$card);
        }
        this.this$0.y0().D0().setValue(L5);
    }
}
