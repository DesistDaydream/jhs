package com.jihuanshe.viewmodel.shop;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.model.Result;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.CardInfo;
import com.jihuanshe.model.CardPackage;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.UploadViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.l.h.i.b;
import e.l.h.i.f;
import e.l.n.c.a;
import e.l.n.c.f;
import e.l.n.c.k;
import e.l.n.c.o;
import e.l.n.c.x;
import e.n.l;
import h.e2.c;
import h.k2.v.u;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class ChooseCardViewModel extends UploadViewModel {
    @d

    /* renamed from: k  reason: collision with root package name */
    public static final a f4534k = new a(null);
    @d

    /* renamed from: l  reason: collision with root package name */
    private static final String f4535l = "ChooseCardViewModel";
    @d

    /* renamed from: d  reason: collision with root package name */
    private final NLive<List<GameCard>> f4536d = new NLive<>(null, 1, null);
    @d

    /* renamed from: e  reason: collision with root package name */
    private final NLive<CardProductNew> f4537e = new NLive<>(null, 1, null);
    @d

    /* renamed from: f  reason: collision with root package name */
    private final f f4538f = new f();
    @d

    /* renamed from: g  reason: collision with root package name */
    private e.n.f<List<Rarity>> f4539g = new e.n.f<>(null, 1, null);
    @d

    /* renamed from: h  reason: collision with root package name */
    private final e.n.f<String> f4540h = new e.n.f<>(null, 1, null);
    @d

    /* renamed from: i  reason: collision with root package name */
    private final l f4541i = new l(null, 1, null);

    /* renamed from: j  reason: collision with root package name */
    private boolean f4542j;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public static /* synthetic */ e.g.d.a F0(ChooseCardViewModel chooseCardViewModel, Game game, CardPackage cardPackage, String str, Integer num, LoadMore.State state, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            state = null;
        }
        return chooseCardViewModel.E0(game, cardPackage, str, num, state);
    }

    public static /* synthetic */ e.g.d.a L0(ChooseCardViewModel chooseCardViewModel, int i2, int i3, int i4, String str, String str2, int i5, Object obj) {
        if ((i5 & 16) != 0) {
            str2 = null;
        }
        return chooseCardViewModel.K0(i2, i3, i4, str, str2);
    }

    @d
    public final e.g.d.a<t1> A0(int i2, int i3, float f2, int i4, @d String str, @d String str2, @d String str3) {
        return e.g.d.a.h(FlowKt.c(((x) e.l.n.a.d(x.class, true, false, false, 60L, true)).a(i2, i3, f2, i4, str, str2, str3)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final e.g.d.a<t1> B0(@e Float f2, @e Integer num, @e String str, @e Integer num2, @e Integer num3, @e String str2, @e Integer num4) {
        return e.g.d.a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).Y(f2, num, str, num2, num3, str2, num4)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final e.g.d.a<CardProductNew> C0(int i2) {
        o oVar = (o) e.l.n.a.d(o.class, true, false, false, 60L, true);
        int v = UserKV.f3913c.v();
        Game value = GameBar.b.a().getValue();
        String gameKey = value == null ? null : value.getGameKey();
        if (gameKey == null) {
            gameKey = "";
        }
        return e.g.d.a.h(FlowKt.c(o.a.a(oVar, v, i2, 0, gameKey, null, 16, null)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final e.g.d.a<b<CardInfo>> D0(int i2) {
        final Flow a2 = a.C0390a.a((e.l.n.c.a) e.l.n.a.d(e.l.n.c.a.class, true, true, true, 60L, true), i2, null, null, 6, null);
        return e.g.d.a.h(FlowKt.c(new Flow<b<CardInfo>>() { // from class: com.jihuanshe.viewmodel.shop.ChooseCardViewModel$getCardInfo$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.shop.ChooseCardViewModel$getCardInfo$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<b<CardInfo>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ ChooseCardViewModel$getCardInfo$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.shop.ChooseCardViewModel$getCardInfo$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(i.b.v3.f fVar, ChooseCardViewModel$getCardInfo$$inlined$map$1 chooseCardViewModel$getCardInfo$$inlined$map$1) {
                    this.a = fVar;
                    this.b = chooseCardViewModel$getCardInfo$$inlined$map$1;
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
                        boolean r0 = r12 instanceof com.jihuanshe.viewmodel.shop.ChooseCardViewModel$getCardInfo$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r12
                        com.jihuanshe.viewmodel.shop.ChooseCardViewModel$getCardInfo$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.shop.ChooseCardViewModel$getCardInfo$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.shop.ChooseCardViewModel$getCardInfo$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.shop.ChooseCardViewModel$getCardInfo$$inlined$map$1$2$1
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
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.shop.ChooseCardViewModel$getCardInfo$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super b<CardInfo>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @e
    public final e.g.d.a<?> E0(@d final Game game, @e CardPackage cardPackage, @e String str, @e Integer num, @e LoadMore.State state) {
        if (this.f4542j) {
            return null;
        }
        this.f4542j = true;
        e.l.o.a.a.a aVar = e.l.o.a.a.a.a;
        Integer pid = cardPackage == null ? null : cardPackage.getPid();
        Integer cid = cardPackage == null ? null : cardPackage.getCid();
        Integer value = this.f4541i.getValue();
        final Flow<Result<b<e.l.h.i.e<GameCard>>>> c2 = aVar.c(num, pid, cid, game, str, (value != null && value.intValue() == 2) ? 1 : null, null, this.f4540h.getValue(), null, null, this.f4538f.a(state).d());
        return e.g.d.a.h(e.g.d.a.o(e.g.d.a.j(FlowKt.c(new Flow<Result<b<e.l.h.i.e<GameCard>>>>() { // from class: com.jihuanshe.viewmodel.shop.ChooseCardViewModel$getCards$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.shop.ChooseCardViewModel$getCards$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<Result<b<e.l.h.i.e<GameCard>>>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ ChooseCardViewModel$getCards$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.shop.ChooseCardViewModel$getCards$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(i.b.v3.f fVar, ChooseCardViewModel$getCards$$inlined$map$1 chooseCardViewModel$getCards$$inlined$map$1) {
                    this.a = fVar;
                    this.b = chooseCardViewModel$getCards$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(com.jihuanshe.base.model.Result<e.l.h.i.b<e.l.h.i.e<com.jihuanshe.model.GameCard>>> r7, @k.e.a.d h.e2.c r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof com.jihuanshe.viewmodel.shop.ChooseCardViewModel$getCards$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.jihuanshe.viewmodel.shop.ChooseCardViewModel$getCards$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.shop.ChooseCardViewModel$getCards$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.shop.ChooseCardViewModel$getCards$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.shop.ChooseCardViewModel$getCards$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r8)
                        goto L72
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        h.r0.n(r8)
                        i.b.v3.f r8 = r6.a
                        com.jihuanshe.base.model.Result r7 = (com.jihuanshe.base.model.Result) r7
                        java.lang.Object r2 = r7.getData()
                        e.l.h.i.b r2 = (e.l.h.i.b) r2
                        if (r2 != 0) goto L41
                        goto L69
                    L41:
                        java.lang.Object r2 = r2.a()
                        e.l.h.i.e r2 = (e.l.h.i.e) r2
                        if (r2 != 0) goto L4a
                        goto L69
                    L4a:
                        java.util.List r2 = r2.b()
                        if (r2 != 0) goto L51
                        goto L69
                    L51:
                        java.util.Iterator r2 = r2.iterator()
                    L55:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto L69
                        java.lang.Object r4 = r2.next()
                        com.jihuanshe.model.GameCard r4 = (com.jihuanshe.model.GameCard) r4
                        com.jihuanshe.viewmodel.shop.ChooseCardViewModel$getCards$$inlined$map$1 r5 = r6.b
                        com.jihuanshe.model.Game r5 = r2
                        r4.setGame(r5)
                        goto L55
                    L69:
                        r0.label = r3
                        java.lang.Object r7 = r8.emit(r7, r0)
                        if (r7 != r1) goto L72
                        return r1
                    L72:
                        h.t1 r7 = h.t1.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.shop.ChooseCardViewModel$getCards$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super Result<b<e.l.h.i.e<GameCard>>>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), null, new ChooseCardViewModel$getCards$2(this), 1, null), null, new ChooseCardViewModel$getCards$3(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<GameCard>> G0() {
        return this.f4536d;
    }

    @d
    public final NLive<CardProductNew> H0() {
        return this.f4537e;
    }

    @d
    public final f I0() {
        return this.f4538f;
    }

    @d
    public final e.n.f<List<Rarity>> J0() {
        return this.f4539g;
    }

    @d
    public final e.g.d.a<CardProductNew> K0(int i2, int i3, int i4, @d String str, @e String str2) {
        return e.g.d.a.h(FlowKt.a(((o) e.l.n.a.d(o.class, true, false, false, 60L, true)).b(i2, i3, i4, str, str2), this.f4537e), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final l M0() {
        return this.f4541i;
    }

    @d
    public final e.n.f<String> N() {
        return this.f4540h;
    }

    @d
    public final e.g.d.a<t1> N0(int i2, @d String str, @d String str2, @d List<String> list) {
        return e.g.d.a.h(e.g.d.a.j(FlowKt.c(f.a.b((e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true), i2, str, str2, list, null, 16, null)), null, new ChooseCardViewModel$goErrorCorrect$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    public final boolean O0() {
        return this.f4542j;
    }

    public final void P0(boolean z) {
        this.f4542j = z;
    }

    public final void Q0(@d e.n.f<List<Rarity>> fVar) {
        this.f4539g = fVar;
    }

    @d
    public final e.g.d.a<t1> z0(@e Integer num, @e Float f2, @e Integer num2, @e Integer num3, @e String str, @e String str2, @d String str3) {
        return e.g.d.a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).q(num, f2, num2, num3, str, str2, str3)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
