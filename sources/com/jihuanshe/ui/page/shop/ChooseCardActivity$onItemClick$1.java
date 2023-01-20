package com.jihuanshe.ui.page.shop;

import android.view.View;
import com.eth.model.NLive;
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
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.shop.ChooseCardViewModel;
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
public final class ChooseCardActivity$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ ChooseCardActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.shop.ChooseCardActivity$onItemClick$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<CardProductNew, t1> {
        public final /* synthetic */ GameCard $a;
        public final /* synthetic */ ChooseCardActivity this$0;

        /* renamed from: com.jihuanshe.ui.page.shop.ChooseCardActivity$onItemClick$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01211 extends Lambda implements p<WantCard, Boolean, t1> {
            public final /* synthetic */ GameCard $a;
            public final /* synthetic */ ChooseCardActivity this$0;

            /* renamed from: com.jihuanshe.ui.page.shop.ChooseCardActivity$onItemClick$1$1$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C01221 extends Lambda implements l<t1, t1> {
                public final /* synthetic */ ChooseCardActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01221(ChooseCardActivity chooseCardActivity) {
                    super(1);
                    this.this$0 = chooseCardActivity;
                }

                @Override // h.k2.u.l
                public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
                    invoke2(t1Var);
                    return t1.a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@e t1 t1Var) {
                    i.d(f.b, a.p, null, 2, null);
                    e.l.h.j.b.e.h(this.this$0, Res.w(Res.a, R.string.success, null, 2, null), null, null, null, 0, null, 62, null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01211(ChooseCardActivity chooseCardActivity, GameCard gameCard) {
                super(2);
                this.this$0 = chooseCardActivity;
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
                ChooseCardViewModel chooseCardViewModel = (ChooseCardViewModel) this.this$0.L();
                Integer p0 = this.this$0.p0();
                int intValue = p0 == null ? 0 : p0.intValue();
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
                BinderKt.p(BinderKt.k(e.g.d.a.j(chooseCardViewModel.A0(intValue, versionId, floatValue, quantity, str, gameKey, (value2 == null || (gameSubKey = value2.getGameSubKey()) == null) ? "" : gameSubKey), null, new C01221(this.this$0), 1, null), this.this$0, false, 2, null));
            }
        }

        /* renamed from: com.jihuanshe.ui.page.shop.ChooseCardActivity$onItemClick$1$1$2  reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass2 extends Lambda implements l<e.n.f<PendingProduct>, t1> {
            public final /* synthetic */ ChooseCardActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(ChooseCardActivity chooseCardActivity) {
                super(1);
                this.this$0 = chooseCardActivity;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(e.n.f<PendingProduct> fVar) {
                invoke2(fVar);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@d e.n.f<PendingProduct> fVar) {
                this.this$0.u0(fVar);
                BinderKt.p(this.this$0.Z().w0());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ChooseCardActivity chooseCardActivity, GameCard gameCard) {
            super(1);
            this.this$0 = chooseCardActivity;
            this.$a = gameCard;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(CardProductNew cardProductNew) {
            invoke2(cardProductNew);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e CardProductNew cardProductNew) {
            ChooseCardActivity chooseCardActivity = this.this$0;
            new AddCardConsignmentDialog(chooseCardActivity, cardProductNew, null, null, null, null, true, null, new C01211(chooseCardActivity, this.$a), new AnonymousClass2(this.this$0), 188, null).y();
        }
    }

    /* renamed from: com.jihuanshe.ui.page.shop.ChooseCardActivity$onItemClick$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements l<b<CardInfo>, t1> {
        public final /* synthetic */ GameCard $a;
        public final /* synthetic */ ChooseCardActivity this$0;

        /* renamed from: com.jihuanshe.ui.page.shop.ChooseCardActivity$onItemClick$1$2$1  reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends Lambda implements l<WantCard, t1> {
            public final /* synthetic */ ChooseCardActivity this$0;

            /* renamed from: com.jihuanshe.ui.page.shop.ChooseCardActivity$onItemClick$1$2$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C01231 extends Lambda implements l<t1, t1> {
                public final /* synthetic */ ChooseCardActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01231(ChooseCardActivity chooseCardActivity) {
                    super(1);
                    this.this$0 = chooseCardActivity;
                }

                @Override // h.k2.u.l
                public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
                    invoke2(t1Var);
                    return t1.a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@e t1 t1Var) {
                    i.d(f.b, a.n, null, 2, null);
                    e.l.h.j.b.e.h(this.this$0, Res.w(Res.a, R.string.success, null, 2, null), null, null, null, 0, null, 62, null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ChooseCardActivity chooseCardActivity) {
                super(1);
                this.this$0 = chooseCardActivity;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(WantCard wantCard) {
                invoke2(wantCard);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@d WantCard wantCard) {
                ChooseCardViewModel chooseCardViewModel = (ChooseCardViewModel) this.this$0.L();
                Float wishPrice = wantCard.getWishPrice();
                Integer valueOf = Integer.valueOf(wantCard.getQuantity());
                String remark = wantCard.getRemark();
                Integer valueOf2 = Integer.valueOf(wantCard.getIgnoreVersion());
                Integer versionId = wantCard.getVersionId();
                Game value = GameBar.b.a().getValue();
                BinderKt.p(BinderKt.k(e.g.d.a.j(chooseCardViewModel.B0(wishPrice, valueOf, remark, valueOf2, versionId, value == null ? null : value.getGameKey(), this.this$0.p0()), null, new C01231(this.this$0), 1, null), this.this$0, false, 2, null));
            }
        }

        /* renamed from: com.jihuanshe.ui.page.shop.ChooseCardActivity$onItemClick$1$2$2  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01242 extends Lambda implements l<Integer, t1> {
            public final /* synthetic */ ChooseCardActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01242(ChooseCardActivity chooseCardActivity) {
                super(1);
                this.this$0 = chooseCardActivity;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
                invoke(num.intValue());
                return t1.a;
            }

            public final void invoke(int i2) {
                this.this$0.t0(Integer.valueOf(i2));
                BinderKt.p(SellingChildViewModel.E0(this.this$0.n0(), 1, null, null, null, 8, null));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ChooseCardActivity chooseCardActivity, GameCard gameCard) {
            super(1);
            this.this$0 = chooseCardActivity;
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
            if ((type == null || type.intValue() != 2) && (value = ((ChooseCardViewModel) this.this$0.L()).H0().getValue()) != null) {
                value.setProducts(CollectionsKt__CollectionsKt.E());
            }
            CardInfo a = bVar == null ? null : bVar.a();
            Integer type2 = this.this$0.getType();
            boolean z = type2 == null || type2.intValue() != 1;
            NLive<CardProductNew> H0 = ((ChooseCardViewModel) this.this$0.L()).H0();
            ChooseCardActivity chooseCardActivity = this.this$0;
            new AddCardDialog(chooseCardActivity, a, null, this.$a, null, z, H0, null, new AnonymousClass1(chooseCardActivity), new C01242(this.this$0), 128, null).y();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChooseCardActivity$onItemClick$1(ChooseCardActivity chooseCardActivity) {
        super(2);
        this.this$0 = chooseCardActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<GameCard> value = ((ChooseCardViewModel) this.this$0.L()).G0().getValue();
        GameCard gameCard = value == null ? null : (GameCard) CollectionsKt___CollectionsKt.J2(value, i2);
        if (gameCard == null) {
            return;
        }
        Integer type = this.this$0.getType();
        if (type != null && type.intValue() == 3) {
            ChooseCardViewModel chooseCardViewModel = (ChooseCardViewModel) this.this$0.L();
            int v = UserKV.f3913c.v();
            int versionId = gameCard.getVersionId();
            Game value2 = GameBar.b.a().getValue();
            String gameKey = value2 == null ? null : value2.getGameKey();
            if (gameKey == null) {
                gameKey = "";
            }
            BinderKt.p(BinderKt.k(e.g.d.a.j(chooseCardViewModel.K0(v, versionId, 1, gameKey, null), null, new AnonymousClass1(this.this$0, gameCard), 1, null), this.this$0, false, 2, null));
            return;
        }
        Integer type2 = this.this$0.getType();
        if (type2 != null && type2.intValue() == 2) {
            Integer valueOf = Integer.valueOf(gameCard.getVersionId());
            GameBar.a aVar = GameBar.b;
            Game value3 = aVar.a().getValue();
            String gameKey2 = value3 == null ? null : value3.getGameKey();
            Game value4 = aVar.a().getValue();
            AddProductActivityCreator.create(valueOf, gameKey2, value4 != null ? value4.getGameSubKey() : null).start(this.this$0);
            return;
        }
        BinderKt.p(BinderKt.k(e.g.d.a.j(((ChooseCardViewModel) this.this$0.L()).D0(gameCard.getId()), null, new AnonymousClass2(this.this$0, gameCard), 1, null), this.this$0, false, 2, null));
    }
}
