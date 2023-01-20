package com.jihuanshe.ui.page.search.fragments.cardrepo;

import com.jihuanshe.model.GameCard;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardRepoSearchFragment$onSoldOrOffSold$1 extends Lambda implements l<t1, t1> {
    public final /* synthetic */ GameCard $card;
    public final /* synthetic */ CardRepoSearchFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardRepoSearchFragment$onSoldOrOffSold$1(CardRepoSearchFragment cardRepoSearchFragment, GameCard gameCard) {
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
        List<GameCard> value = this.this$0.y0().D0().getValue();
        List<GameCard> L5 = value == null ? null : CollectionsKt___CollectionsKt.L5(value);
        if (L5 != null) {
            L5.remove(this.$card);
        }
        this.this$0.y0().D0().setValue(L5);
    }
}
