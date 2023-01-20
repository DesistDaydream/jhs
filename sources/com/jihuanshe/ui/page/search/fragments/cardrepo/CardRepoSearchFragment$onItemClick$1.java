package com.jihuanshe.ui.page.search.fragments.cardrepo;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.CardInfo;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.PendingProduct;
import com.jihuanshe.model.WantCard;
import com.jihuanshe.ui.dialog.AddCardConsignmentDialog;
import com.jihuanshe.ui.dialog.AddCardDialog;
import com.jihuanshe.ui.page.shop.AddProductActivityCreator;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel;
import com.jihuanshe.viewmodel.user.selling.SellingChildViewModel;
import com.vector.util.Res;
import e.l.h.d.f;
import e.l.h.d.i;
import e.l.h.i.b;
import e.l.j.a;
import h.k2.u.l;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardRepoSearchFragment$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ CardRepoSearchFragment this$0;

    /* renamed from: com.jihuanshe.ui.page.search.fragments.cardrepo.CardRepoSearchFragment$onItemClick$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<CardProductNew, t1> {
        public final /* synthetic */ GameCard $a;
        public final /* synthetic */ CardRepoSearchFragment this$0;

        /* renamed from: com.jihuanshe.ui.page.search.fragments.cardrepo.CardRepoSearchFragment$onItemClick$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01141 extends Lambda implements p<WantCard, Boolean, t1> {
            public final /* synthetic */ GameCard $a;
            public final /* synthetic */ CardRepoSearchFragment this$0;

            /* renamed from: com.jihuanshe.ui.page.search.fragments.cardrepo.CardRepoSearchFragment$onItemClick$1$1$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C01151 extends Lambda implements l<t1, t1> {
                public final /* synthetic */ CardRepoSearchFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01151(CardRepoSearchFragment cardRepoSearchFragment) {
                    super(1);
                    this.this$0 = cardRepoSearchFragment;
                }

                @Override // h.k2.u.l
                public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
                    invoke2(t1Var);
                    return t1.a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@e t1 t1Var) {
                    i.d(f.b, a.p, null, 2, null);
                    e.l.h.j.b.e.d(this.this$0, Res.w(Res.a, R.string.success, null, 2, null), (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? 1 : 0, (r13 & 32) == 0 ? null : null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01141(CardRepoSearchFragment cardRepoSearchFragment, GameCard gameCard) {
                super(2);
                this.this$0 = cardRepoSearchFragment;
                this.$a = gameCard;
            }

            @Override // h.k2.u.p
            public /* bridge */ /* synthetic */ t1 invoke(WantCard wantCard, Boolean bool) {
                invoke2(wantCard, bool);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@d WantCard wantCard, @e Boolean bool) {
                String gameKey;
                String gameSubKey;
                CardRepoSearchViewModel cardRepoSearchViewModel = (CardRepoSearchViewModel) this.this$0.T();
                Integer z0 = this.this$0.z0();
                int intValue = z0 == null ? 0 : z0.intValue();
                int versionId = this.$a.getVersionId();
                Float wishPrice = wantCard.getWishPrice();
                float floatValue = wishPrice == null ? 0.0f : wishPrice.floatValue();
                int quantity = wantCard.getQuantity();
                String location = wantCard.getLocation();
                if (location == null) {
                    location = "default";
                }
                String str = location;
                GameBar.a aVar = GameBar.b;
                Game value = aVar.a().getValue();
                if (value == null || (gameKey = value.getGameKey()) == null) {
                    gameKey = "";
                }
                Game value2 = aVar.a().getValue();
                BinderKt.p(BinderKt.j(e.g.d.a.j(cardRepoSearchViewModel.q0(intValue, versionId, floatValue, quantity, str, gameKey, (value2 == null || (gameSubKey = value2.getGameSubKey()) == null) ? "" : gameSubKey), null, new C01151(this.this$0), 1, null), this.this$0, false, 2, null));
            }
        }

        /* renamed from: com.jihuanshe.ui.page.search.fragments.cardrepo.CardRepoSearchFragment$onItemClick$1$1$2  reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass2 extends Lambda implements l<e.n.f<PendingProduct>, t1> {
            public final /* synthetic */ CardRepoSearchFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(CardRepoSearchFragment cardRepoSearchFragment) {
                super(1);
                this.this$0 = cardRepoSearchFragment;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(e.n.f<PendingProduct> fVar) {
                invoke2(fVar);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@d e.n.f<PendingProduct> fVar) {
                this.this$0.E0(fVar);
                BinderKt.p(this.this$0.l0().w0());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CardRepoSearchFragment cardRepoSearchFragment, GameCard gameCard) {
            super(1);
            this.this$0 = cardRepoSearchFragment;
            this.$a = gameCard;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(CardProductNew cardProductNew) {
            invoke2(cardProductNew);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e CardProductNew cardProductNew) {
            if (cardProductNew != null) {
                Game value = GameBar.b.a().getValue();
                String gameKey = value == null ? null : value.getGameKey();
                if (gameKey == null) {
                    gameKey = "";
                }
                cardProductNew.setGameKey(gameKey);
            }
            new AddCardConsignmentDialog(this.this$0.requireActivity(), cardProductNew, null, null, null, null, true, null, new C01141(this.this$0, this.$a), new AnonymousClass2(this.this$0), 188, null).y();
        }
    }

    /* renamed from: com.jihuanshe.ui.page.search.fragments.cardrepo.CardRepoSearchFragment$onItemClick$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements l<b<CardInfo>, t1> {
        public final /* synthetic */ GameCard $a;
        public final /* synthetic */ CardRepoSearchFragment this$0;

        /* renamed from: com.jihuanshe.ui.page.search.fragments.cardrepo.CardRepoSearchFragment$onItemClick$1$2$1  reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends Lambda implements l<WantCard, t1> {
            public final /* synthetic */ CardRepoSearchFragment this$0;

            /* renamed from: com.jihuanshe.ui.page.search.fragments.cardrepo.CardRepoSearchFragment$onItemClick$1$2$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C01161 extends Lambda implements l<t1, t1> {
                public final /* synthetic */ CardRepoSearchFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01161(CardRepoSearchFragment cardRepoSearchFragment) {
                    super(1);
                    this.this$0 = cardRepoSearchFragment;
                }

                @Override // h.k2.u.l
                public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
                    invoke2(t1Var);
                    return t1.a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@e t1 t1Var) {
                    i.d(f.b, a.n, null, 2, null);
                    e.l.h.j.b.e.d(this.this$0, Res.w(Res.a, R.string.success, null, 2, null), (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? 1 : 0, (r13 & 32) == 0 ? null : null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(CardRepoSearchFragment cardRepoSearchFragment) {
                super(1);
                this.this$0 = cardRepoSearchFragment;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(WantCard wantCard) {
                invoke2(wantCard);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@d WantCard wantCard) {
                CardRepoSearchViewModel cardRepoSearchViewModel = (CardRepoSearchViewModel) this.this$0.T();
                Float wishPrice = wantCard.getWishPrice();
                Integer valueOf = Integer.valueOf(wantCard.getQuantity());
                String remark = wantCard.getRemark();
                Integer valueOf2 = Integer.valueOf(wantCard.getIgnoreVersion());
                Integer versionId = wantCard.getVersionId();
                Game value = GameBar.b.a().getValue();
                BinderKt.p(BinderKt.j(e.g.d.a.j(cardRepoSearchViewModel.r0(wishPrice, valueOf, remark, valueOf2, versionId, value == null ? null : value.getGameKey(), this.this$0.z0()), null, new C01161(this.this$0), 1, null), this.this$0, false, 2, null));
            }
        }

        /* renamed from: com.jihuanshe.ui.page.search.fragments.cardrepo.CardRepoSearchFragment$onItemClick$1$2$2  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01172 extends Lambda implements l<Integer, t1> {
            public final /* synthetic */ CardRepoSearchFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01172(CardRepoSearchFragment cardRepoSearchFragment) {
                super(1);
                this.this$0 = cardRepoSearchFragment;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
                invoke(num.intValue());
                return t1.a;
            }

            public final void invoke(int i2) {
                this.this$0.D0(Integer.valueOf(i2));
                BinderKt.p(SellingChildViewModel.E0(this.this$0.y0(), 1, null, null, null, 8, null));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(CardRepoSearchFragment cardRepoSearchFragment, GameCard gameCard) {
            super(1);
            this.this$0 = cardRepoSearchFragment;
            this.$a = gameCard;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(b<CardInfo> bVar) {
            invoke2(bVar);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e b<CardInfo> bVar) {
            CardProductNew value;
            Integer type = this.this$0.getType();
            if ((type == null || type.intValue() != 2) && (value = ((CardRepoSearchViewModel) this.this$0.T()).x0().getValue()) != null) {
                value.setProducts(CollectionsKt__CollectionsKt.E());
            }
            FragmentActivity requireActivity = this.this$0.requireActivity();
            CardInfo a = bVar == null ? null : bVar.a();
            Integer type2 = this.this$0.getType();
            new AddCardDialog(requireActivity, a, null, this.$a, null, type2 == null || type2.intValue() != 1, ((CardRepoSearchViewModel) this.this$0.T()).x0(), null, new AnonymousClass1(this.this$0), new C01172(this.this$0), 128, null).y();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardRepoSearchFragment$onItemClick$1(CardRepoSearchFragment cardRepoSearchFragment) {
        super(2);
        this.this$0 = cardRepoSearchFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        String gameKey;
        String gameSubKey;
        List<GameCard> value = ((CardRepoSearchViewModel) this.this$0.T()).w0().getValue();
        GameCard gameCard = value == null ? null : (GameCard) CollectionsKt___CollectionsKt.J2(value, i2);
        if (gameCard == null) {
            return;
        }
        Integer type = this.this$0.getType();
        String str = "";
        if (type != null && type.intValue() == 3) {
            CardRepoSearchViewModel cardRepoSearchViewModel = (CardRepoSearchViewModel) this.this$0.T();
            int v = UserKV.f3913c.v();
            int versionId = gameCard.getVersionId();
            Game value2 = GameBar.b.a().getValue();
            String gameKey2 = value2 == null ? null : value2.getGameKey();
            BinderKt.p(BinderKt.j(e.g.d.a.j(cardRepoSearchViewModel.A0(v, versionId, 1, gameKey2 != null ? gameKey2 : "", null), null, new AnonymousClass1(this.this$0, gameCard), 1, null), this.this$0, false, 2, null));
            return;
        }
        Integer type2 = this.this$0.getType();
        if (type2 != null && type2.intValue() == 2) {
            Integer valueOf = Integer.valueOf(gameCard.getVersionId());
            GameBar.a aVar = GameBar.b;
            Game value3 = aVar.a().getValue();
            if (value3 == null || (gameKey = value3.getGameKey()) == null) {
                gameKey = "";
            }
            Game value4 = aVar.a().getValue();
            if (value4 != null && (gameSubKey = value4.getGameSubKey()) != null) {
                str = gameSubKey;
            }
            AddProductActivityCreator.create(valueOf, gameKey, str).start(this.this$0.getActivity());
            return;
        }
        BinderKt.p(BinderKt.j(e.g.d.a.j(((CardRepoSearchViewModel) this.this$0.T()).s0(gameCard.getId()), null, new AnonymousClass2(this.this$0, gameCard), 1, null), this.this$0, false, 2, null));
    }
}
