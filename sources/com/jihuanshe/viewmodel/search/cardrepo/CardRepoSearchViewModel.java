package com.jihuanshe.viewmodel.search.cardrepo;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.model.CardInfo;
import com.jihuanshe.model.CardPackage;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.Rarity;
import com.vector.design.ui.delegate.LoadMore;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.a;
import e.l.n.c.k;
import e.l.n.c.o;
import e.l.n.c.x;
import h.e2.c;
import h.k2.v.u;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class CardRepoSearchViewModel extends b {
    @d

    /* renamed from: h  reason: collision with root package name */
    public static final a f4515h = new a(null);
    @d

    /* renamed from: i  reason: collision with root package name */
    private static final String f4516i = "CardRepoSearchViewModel";
    @d
    private final NLive<List<GameCard>> b = new NLive<>(null, 1, null);
    @d

    /* renamed from: c  reason: collision with root package name */
    private final NLive<CardProductNew> f4517c = new NLive<>(null, 1, null);
    @d

    /* renamed from: d  reason: collision with root package name */
    private final f f4518d = new f();
    @d

    /* renamed from: e  reason: collision with root package name */
    private final e.n.f<List<Rarity>> f4519e = new e.n.f<>(null, 1, null);
    @d

    /* renamed from: f  reason: collision with root package name */
    private final e.n.f<String> f4520f = new e.n.f<>(null, 1, null);

    /* renamed from: g  reason: collision with root package name */
    private boolean f4521g;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public static /* synthetic */ e.g.d.a B0(CardRepoSearchViewModel cardRepoSearchViewModel, int i2, int i3, int i4, String str, String str2, int i5, Object obj) {
        if ((i5 & 16) != 0) {
            str2 = null;
        }
        return cardRepoSearchViewModel.A0(i2, i3, i4, str, str2);
    }

    public static /* synthetic */ e.g.d.a u0(CardRepoSearchViewModel cardRepoSearchViewModel, Game game, CardPackage cardPackage, String str, LoadMore.State state, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            state = null;
        }
        return cardRepoSearchViewModel.t0(game, cardPackage, str, state);
    }

    @d
    public final e.g.d.a<CardProductNew> A0(int i2, int i3, int i4, @d String str, @e String str2) {
        return e.g.d.a.h(FlowKt.a(((o) e.l.n.a.d(o.class, true, false, false, 60L, true)).b(i2, i3, i4, str, str2), this.f4517c), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    public final boolean C0() {
        return this.f4521g;
    }

    public final void D0(boolean z) {
        this.f4521g = z;
    }

    @d
    public final e.g.d.a<t1> p0(@e Integer num, @e Float f2, @e Integer num2, @e Integer num3, @e String str, @e String str2) {
        return e.g.d.a.h(FlowKt.c(k.a.a((k) e.l.n.a.d(k.class, true, false, false, 60L, true), num, f2, num2, num3, str, str2, null, 64, null)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final e.g.d.a<t1> q0(int i2, int i3, float f2, int i4, @d String str, @d String str2, @d String str3) {
        return e.g.d.a.h(FlowKt.c(((x) e.l.n.a.d(x.class, true, false, false, 60L, true)).a(i2, i3, f2, i4, str, str2, str3)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final e.g.d.a<t1> r0(@e Float f2, @e Integer num, @e String str, @e Integer num2, @e Integer num3, @e String str2, @e Integer num4) {
        return e.g.d.a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).Y(f2, num, str, num2, num3, str2, num4)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final e.g.d.a<e.l.h.i.b<CardInfo>> s0(int i2) {
        final Flow a2 = a.C0390a.a((e.l.n.c.a) e.l.n.a.d(e.l.n.c.a.class, true, true, true, 60L, true), i2, null, null, 6, null);
        return e.g.d.a.h(FlowKt.c(new Flow<e.l.h.i.b<CardInfo>>() { // from class: com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel$getCardInfo$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel$getCardInfo$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<e.l.h.i.b<CardInfo>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ CardRepoSearchViewModel$getCardInfo$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel$getCardInfo$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    public Object L$0;
                    public Object L$1;
                    public Object L$2;
                    public Object L$3;
                    public Object L$4;
                    public Object L$5;
                    public Object L$6;
                    public Object L$7;
                    public int label;
                    public /* synthetic */ Object result;

                    public AnonymousClass1(c cVar) {
                        super(cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @e
                    public final Object invokeSuspend(@d Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i.b.v3.f fVar, CardRepoSearchViewModel$getCardInfo$$inlined$map$1 cardRepoSearchViewModel$getCardInfo$$inlined$map$1) {
                    this.a = fVar;
                    this.b = cardRepoSearchViewModel$getCardInfo$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(e.l.h.i.b<com.jihuanshe.model.CardInfo> r11, @k.e.a.d h.e2.c r12) {
                    /*
                        r10 = this;
                        boolean r0 = r12 instanceof com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel$getCardInfo$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r12
                        com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel$getCardInfo$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel$getCardInfo$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel$getCardInfo$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel$getCardInfo$$inlined$map$1$2$1
                        r0.<init>(r12)
                    L18:
                        java.lang.Object r12 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        h.r0.n(r12)
                        goto Lc8
                    L2a:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r12)
                        throw r11
                    L32:
                        h.r0.n(r12)
                        i.b.v3.f r12 = r10.a
                        e.l.h.i.b r11 = (e.l.h.i.b) r11
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r2.<init>()
                        java.lang.Object r4 = r11.a()
                        com.jihuanshe.model.CardInfo r4 = (com.jihuanshe.model.CardInfo) r4
                        java.util.List r4 = r4.getVersions()
                        if (r4 != 0) goto L4c
                        goto Lbf
                    L4c:
                        java.util.Iterator r4 = r4.iterator()
                    L50:
                        boolean r5 = r4.hasNext()
                        if (r5 == 0) goto Lbf
                        java.lang.Object r5 = r4.next()
                        com.jihuanshe.model.CardVersion r5 = (com.jihuanshe.model.CardVersion) r5
                        java.util.List r6 = r5.getPack()
                        if (r6 != 0) goto L63
                        goto L50
                    L63:
                        java.util.Iterator r6 = r6.iterator()
                    L67:
                        boolean r7 = r6.hasNext()
                        if (r7 == 0) goto L50
                        java.lang.Object r7 = r6.next()
                        com.jihuanshe.model.CardPack r7 = (com.jihuanshe.model.CardPack) r7
                        java.lang.Float r8 = r5.getMinPrice()
                        if (r8 != 0) goto L7b
                        r8 = 0
                        goto L7f
                    L7b:
                        float r8 = r8.floatValue()
                    L7f:
                        r7.setMinPrice(r8)
                        java.lang.StringBuilder r8 = new java.lang.StringBuilder
                        r8.<init>()
                        java.lang.String r9 = r5.getNumber()
                        r8.append(r9)
                        java.lang.String r9 = " ["
                        r8.append(r9)
                        java.lang.String r9 = r5.getRarity()
                        r8.append(r9)
                        java.lang.String r9 = "] "
                        r8.append(r9)
                        java.lang.String r9 = r7.getNameCN()
                        r8.append(r9)
                        java.lang.String r8 = r8.toString()
                        r7.setVersionStr(r8)
                        int r8 = r5.getId()
                        r7.setVersionId(r8)
                        java.lang.String r8 = r5.getImage()
                        r7.setImage(r8)
                        r2.add(r7)
                        goto L67
                    Lbf:
                        r0.label = r3
                        java.lang.Object r11 = r12.emit(r11, r0)
                        if (r11 != r1) goto Lc8
                        return r1
                    Lc8:
                        h.t1 r11 = h.t1.a
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel$getCardInfo$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super e.l.h.i.b<CardInfo>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @e
    public final e.g.d.a<?> t0(@d Game game, @e CardPackage cardPackage, @e String str, @e LoadMore.State state) {
        if (this.f4521g) {
            return null;
        }
        this.f4521g = true;
        return e.g.d.a.h(e.g.d.a.o(e.g.d.a.j(FlowKt.c(e.l.o.a.a.a.a.c(null, cardPackage == null ? null : cardPackage.getPid(), cardPackage == null ? null : cardPackage.getCid(), game, str, null, null, this.f4520f.getValue(), null, null, this.f4518d.a(state).d())), null, new CardRepoSearchViewModel$getCards$1(this), 1, null), null, new CardRepoSearchViewModel$getCards$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final e.n.f<String> v0() {
        return this.f4520f;
    }

    @d
    public final NLive<List<GameCard>> w0() {
        return this.b;
    }

    @d
    public final NLive<CardProductNew> x0() {
        return this.f4517c;
    }

    @d
    public final f y0() {
        return this.f4518d;
    }

    @d
    public final e.n.f<List<Rarity>> z0() {
        return this.f4519e;
    }
}
