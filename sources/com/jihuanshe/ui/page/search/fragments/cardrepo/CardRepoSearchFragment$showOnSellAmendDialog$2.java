package com.jihuanshe.ui.page.search.fragments.cardrepo;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.WantCard;
import com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel;
import e.g.d.a;
import h.k2.u.l;
import h.k2.u.p;
import h.k2.v.f0;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardRepoSearchFragment$showOnSellAmendDialog$2 extends Lambda implements p<WantCard, Boolean, t1> {
    public final /* synthetic */ GameCard $card;
    public final /* synthetic */ CardRepoSearchFragment this$0;

    /* renamed from: com.jihuanshe.ui.page.search.fragments.cardrepo.CardRepoSearchFragment$showOnSellAmendDialog$2$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ GameCard $card;
        public final /* synthetic */ Boolean $state;
        public final /* synthetic */ WantCard $wantCard;
        public final /* synthetic */ CardRepoSearchFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GameCard gameCard, WantCard wantCard, CardRepoSearchFragment cardRepoSearchFragment, Boolean bool) {
            super(1);
            this.$card = gameCard;
            this.$wantCard = wantCard;
            this.this$0 = cardRepoSearchFragment;
            this.$state = bool;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            GameCard gameCard = this.$card;
            Float wishPrice = this.$wantCard.getWishPrice();
            gameCard.setCardPrice(wishPrice == null ? 0.0f : wishPrice.floatValue());
            this.$card.setCondition(this.$wantCard.getCondition());
            this.$card.setQuantity(this.$wantCard.getQuantity());
            this.$card.setRemark(this.$wantCard.getRemark());
            this.this$0.A0(this.$state, this.$wantCard, this.$card);
        }
    }

    /* renamed from: com.jihuanshe.ui.page.search.fragments.cardrepo.CardRepoSearchFragment$showOnSellAmendDialog$2$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ GameCard $card;
        public final /* synthetic */ WantCard $wantCard;
        public final /* synthetic */ CardRepoSearchFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(CardRepoSearchFragment cardRepoSearchFragment, WantCard wantCard, GameCard gameCard) {
            super(1);
            this.this$0 = cardRepoSearchFragment;
            this.$wantCard = wantCard;
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
            ArrayList arrayList = (ArrayList) products;
            GameCard gameCard = (GameCard) arrayList.get(this.this$0.v0().intValue());
            Float wishPrice = this.$wantCard.getWishPrice();
            gameCard.setCardPrice(wishPrice == null ? 0.0f : wishPrice.floatValue());
            ((GameCard) arrayList.get(this.this$0.v0().intValue())).setCondition(this.$wantCard.getCondition());
            ((GameCard) arrayList.get(this.this$0.v0().intValue())).setQuantity(this.$wantCard.getQuantity());
            ((GameCard) arrayList.get(this.this$0.v0().intValue())).setRemark(this.$wantCard.getRemark());
            this.this$0.D0(null);
            ((CardRepoSearchViewModel) this.this$0.T()).x0().n();
            GameCard gameCard2 = this.$card;
            Float wishPrice2 = this.$wantCard.getWishPrice();
            gameCard2.setCardPrice(wishPrice2 != null ? wishPrice2.floatValue() : 0.0f);
            this.$card.setCondition(this.$wantCard.getCondition());
            this.$card.setQuantity(this.$wantCard.getQuantity());
            this.$card.setRemark(this.$wantCard.getRemark());
            this.this$0.y0().D0().n();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardRepoSearchFragment$showOnSellAmendDialog$2(GameCard gameCard, CardRepoSearchFragment cardRepoSearchFragment) {
        super(2);
        this.$card = gameCard;
        this.this$0 = cardRepoSearchFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(WantCard wantCard, Boolean bool) {
        invoke2(wantCard, bool);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d WantCard wantCard, @e Boolean bool) {
        Boolean bool2 = Boolean.TRUE;
        boolean z = (f0.e(wantCard.getWishPrice(), this.$card.getCardPrice()) && f0.g(wantCard.getCondition(), this.$card.getCondition()) && f0.g(wantCard.getRemark(), this.$card.getRemark()) && wantCard.getQuantity() == this.$card.getQuantity()) ? false : true;
        if (z && !f0.g(bool2, bool)) {
            a.j(this.this$0.y0().N0(wantCard), null, new AnonymousClass1(this.$card, wantCard, this.this$0, bool), 1, null);
        } else if (z && f0.g(bool2, bool)) {
            BinderKt.p(BinderKt.j(a.j(this.this$0.y0().N0(wantCard), null, new AnonymousClass2(this.this$0, wantCard, this.$card), 1, null), this.this$0, false, 2, null));
        } else if (z || f0.g(bool2, bool)) {
        } else {
            this.this$0.A0(bool, wantCard, this.$card);
        }
    }
}
