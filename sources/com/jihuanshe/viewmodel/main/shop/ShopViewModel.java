package com.jihuanshe.viewmodel.main.shop;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.Banner;
import com.jihuanshe.model.BannerPack;
import com.jihuanshe.model.CardPackage;
import com.jihuanshe.model.Category;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.utils.UpdateManager;
import com.jihuanshe.viewmodel.FilterBarImpl;
import com.vector.design.ui.delegate.LoadMore;
import com.vector.util.LayoutManagers;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.j;
import e.l.n.c.p;
import e.l.s.c;
import e.n.i;
import e.n.l;
import e.t.j.h.g;
import e.t.j.h.h;
import h.k2.v.f0;
import h.k2.v.u;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class ShopViewModel extends b implements c {
    @d

    /* renamed from: m  reason: collision with root package name */
    public static final a f4474m = new a(null);
    @d
    private static final String n = "ShopViewModel";
    @e

    /* renamed from: d  reason: collision with root package name */
    private e.g.d.a<?> f4476d;
    private final /* synthetic */ FilterBarImpl b = new FilterBarImpl();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final f f4475c = new f();
    @d

    /* renamed from: e  reason: collision with root package name */
    private final NLive<List<Category>> f4477e = new NLive<>(null, 1, null);
    @d

    /* renamed from: f  reason: collision with root package name */
    private final NLive<Category> f4478f = new NLive<>(null, 1, null);
    @d

    /* renamed from: g  reason: collision with root package name */
    private final NLive<CardPackage> f4479g = new NLive<>(null, 1, null);
    @d

    /* renamed from: h  reason: collision with root package name */
    private final NLive<List<GameCard>> f4480h = new NLive<>(null, 1, null);
    @d

    /* renamed from: i  reason: collision with root package name */
    private final e.n.f<Banner> f4481i = new e.n.f<>(null, 1, null);
    @d

    /* renamed from: j  reason: collision with root package name */
    private final e.n.f<BannerPack> f4482j = new e.n.f<>(null, 1, null);
    @d

    /* renamed from: k  reason: collision with root package name */
    private final i f4483k = new i(Boolean.valueOf(!UpdateManager.a.f()));
    @d

    /* renamed from: l  reason: collision with root package name */
    private final l f4484l = new l(170);

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public static /* synthetic */ e.g.d.a B0(ShopViewModel shopViewModel, int i2, String str, String str2, boolean z, LoadMore.State state, int i3, Object obj) {
        boolean z2 = (i3 & 8) != 0 ? true : z;
        if ((i3 & 16) != 0) {
            state = null;
        }
        return shopViewModel.A0(i2, str, str2, z2, state);
    }

    public static /* synthetic */ e.g.d.a t0(ShopViewModel shopViewModel, Game game, CardPackage cardPackage, LoadMore.State state, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            state = null;
        }
        if ((i2 & 8) != 0) {
            z = true;
        }
        return shopViewModel.s0(game, cardPackage, state, z);
    }

    @Override // e.l.s.c
    @d
    public e.t.k.a.c.a<Pair<String, String>> A() {
        return this.b.A();
    }

    @d
    public final e.g.d.a<?> A0(int i2, @d String str, @d String str2, boolean z, @e LoadMore.State state) {
        e.g.d.a<?> aVar = this.f4476d;
        if (aVar != null) {
            aVar.b();
        }
        p pVar = (p) e.l.n.a.d(p.class, false, false, false, 60L, true);
        String value = M().getValue();
        Pair<String, String> value2 = L().getValue();
        final Flow<Result<e.l.h.i.e<GameCard>>> a2 = pVar.a(null, i2, value, value2 == null ? null : value2.getSecond(), null, str, str2, this.f4475c.a(state).d());
        e.g.d.a<?> h2 = e.g.d.a.h(e.g.d.a.o(e.g.d.a.j(FlowKt.c(new Flow<Result<e.l.h.i.e<GameCard>>>() { // from class: com.jihuanshe.viewmodel.main.shop.ShopViewModel$getSellerCards$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.main.shop.ShopViewModel$getSellerCards$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<Result<e.l.h.i.e<GameCard>>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ ShopViewModel$getSellerCards$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.main.shop.ShopViewModel$getSellerCards$$inlined$map$1$2$1  reason: invalid class name */
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

                    public AnonymousClass1(h.e2.c cVar) {
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

                public AnonymousClass2(i.b.v3.f fVar, ShopViewModel$getSellerCards$$inlined$map$1 shopViewModel$getSellerCards$$inlined$map$1) {
                    this.a = fVar;
                    this.b = shopViewModel$getSellerCards$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(com.jihuanshe.base.model.Result<e.l.h.i.e<com.jihuanshe.model.GameCard>> r7, @k.e.a.d h.e2.c r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof com.jihuanshe.viewmodel.main.shop.ShopViewModel$getSellerCards$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.jihuanshe.viewmodel.main.shop.ShopViewModel$getSellerCards$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.main.shop.ShopViewModel$getSellerCards$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.main.shop.ShopViewModel$getSellerCards$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.main.shop.ShopViewModel$getSellerCards$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r8)
                        goto L71
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
                        e.l.h.i.e r2 = (e.l.h.i.e) r2
                        if (r2 != 0) goto L41
                        goto L68
                    L41:
                        java.util.List r2 = r2.b()
                        if (r2 != 0) goto L48
                        goto L68
                    L48:
                        java.util.Iterator r2 = r2.iterator()
                    L4c:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto L68
                        java.lang.Object r4 = r2.next()
                        com.jihuanshe.model.GameCard r4 = (com.jihuanshe.model.GameCard) r4
                        com.jihuanshe.ui.widget.GameBar$a r5 = com.jihuanshe.ui.widget.GameBar.b
                        e.n.f r5 = r5.a()
                        java.lang.Object r5 = r5.getValue()
                        com.jihuanshe.model.Game r5 = (com.jihuanshe.model.Game) r5
                        r4.setGame(r5)
                        goto L4c
                    L68:
                        r0.label = r3
                        java.lang.Object r7 = r8.emit(r7, r0)
                        if (r7 != r1) goto L71
                        return r1
                    L71:
                        h.t1 r7 = h.t1.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.main.shop.ShopViewModel$getSellerCards$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super Result<e.l.h.i.e<GameCard>>> fVar, @d h.e2.c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), null, new ShopViewModel$getSellerCards$2(z, this), 1, null), null, new ShopViewModel$getSellerCards$3(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
        this.f4476d = h2;
        return h2;
    }

    @Override // e.l.s.c
    public boolean B() {
        return this.b.B();
    }

    @Override // e.l.s.c
    @d
    public e.n.f<Pair<String, String>> C() {
        return this.b.C();
    }

    @d
    public final i C0() {
        return this.f4483k;
    }

    @d
    public final e.g.d.a<List<Game>> D0() {
        return e.g.d.a.h(e.g.d.a.o(e.g.d.a.j(FlowKt.c(e.l.o.a.a.a.a.a()), null, ShopViewModel$initData$1.INSTANCE, 1, null), null, ShopViewModel$initData$2.INSTANCE, 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    public final void E0(int i2) {
        List<CardPackage> plist;
        NLive<CardPackage> nLive = this.f4479g;
        Category value = this.f4478f.getValue();
        CardPackage cardPackage = null;
        if (value != null && (plist = value.getPlist()) != null) {
            cardPackage = (CardPackage) CollectionsKt___CollectionsKt.J2(plist, i2);
        }
        nLive.r(cardPackage);
    }

    @Override // e.l.s.c
    @d
    public g F(@d View view) {
        return this.b.F(view);
    }

    public final void F0(int i2) {
        NLive<Category> nLive = this.f4478f;
        List<Category> value = this.f4477e.getValue();
        nLive.r(value == null ? null : (Category) CollectionsKt___CollectionsKt.J2(value, i2));
        Game value2 = GameBar.b.a().getValue();
        if ((value2 == null ? false : f0.g(value2.getWarehouse(), 1)) && i2 == 1) {
            s().setValue(Boolean.TRUE);
            return;
        }
        s().setValue(Boolean.FALSE);
        E0(0);
    }

    @Override // e.l.s.c
    @d
    public e.n.f<List<Pair<String, String>>> G() {
        return this.b.G();
    }

    @Override // e.l.s.c
    @d
    public i I() {
        return this.b.I();
    }

    @Override // e.l.s.c
    @d
    public e.n.f<Pair<String, String>> L() {
        return this.b.L();
    }

    @Override // e.l.s.c
    @d
    public e.n.p M() {
        return this.b.M();
    }

    @Override // e.l.s.c
    @d
    public e.n.f<Pair<String, String>> N() {
        return this.b.N();
    }

    @Override // e.l.s.c
    @d
    public g O(@d View view) {
        return this.b.O(view);
    }

    @Override // e.l.s.c
    @d
    public l P() {
        return this.b.P();
    }

    @Override // e.l.s.c
    @d
    public e.t.j.h.l Q() {
        return this.b.Q();
    }

    @Override // e.l.s.c
    @d
    public e.t.k.a.c.a<Rarity> S() {
        return this.b.S();
    }

    @Override // e.l.s.c
    @d
    public e.n.f<String> V() {
        return this.b.V();
    }

    @Override // e.l.s.c
    @d
    public e.n.f<Pair<String, String>> W() {
        return this.b.W();
    }

    @Override // e.l.s.c
    @d
    public i X() {
        return this.b.X();
    }

    @Override // e.l.s.c
    @d
    public LayoutManagers.a Y() {
        return this.b.Y();
    }

    @Override // e.l.s.c
    public boolean Z() {
        return this.b.Z();
    }

    @Override // e.l.s.c
    public void a(@d List<Rarity> list) {
        this.b.a(list);
    }

    @Override // e.l.s.c
    @d
    public g a0(int i2) {
        return this.b.a0(i2);
    }

    @Override // e.l.s.c
    @d
    public g b(@d View view) {
        return this.b.b(view);
    }

    @Override // e.l.s.c
    public void c0(@d TextView textView) {
        this.b.c0(textView);
    }

    @Override // e.l.s.c
    @d
    public i d() {
        return this.b.d();
    }

    @Override // e.l.s.c
    public void d0(int i2) {
        this.b.d0(i2);
    }

    @Override // e.l.s.c
    @d
    public i f0() {
        return this.b.f0();
    }

    @Override // e.l.s.c
    @d
    public g g0() {
        return this.b.g0();
    }

    @Override // e.l.s.c
    @d
    public h.k2.u.l<List<Rarity>, t1> h0() {
        return this.b.h0();
    }

    @Override // e.l.s.c
    @d
    public e.n.f<List<Rarity>> i() {
        return this.b.i();
    }

    @Override // e.l.s.c
    public boolean j0() {
        return false;
    }

    @Override // e.l.s.c
    public boolean k() {
        return this.b.k();
    }

    @Override // e.l.s.c
    @d
    public l l() {
        return this.b.l();
    }

    @Override // e.l.s.c
    @d
    public g m(@d View view) {
        return this.b.m(view);
    }

    @Override // e.l.s.c
    @d
    public e.n.f<Pair<String, String>> n() {
        return this.b.n();
    }

    @Override // e.l.s.c
    @d
    public g q(@d View view) {
        return this.b.q(view);
    }

    @d
    public final e.n.f<Banner> q0() {
        return this.f4481i;
    }

    @Override // e.l.s.c
    public void r(@d Pair<String, String> pair) {
        this.b.r(pair);
    }

    @d
    public final e.n.f<BannerPack> r0() {
        return this.f4482j;
    }

    @Override // e.l.s.c
    @d
    public i s() {
        return this.b.s();
    }

    @d
    public final e.g.d.a<?> s0(@d Game game, @e CardPackage cardPackage, @e LoadMore.State state, boolean z) {
        final Flow<Result<e.l.h.i.b<e.l.h.i.e<GameCard>>>> c2;
        Pair<String, String> value;
        Pair<String, String> value2 = W().getValue();
        final boolean g2 = f0.g(value2 == null ? null : value2.getSecond(), "wish");
        e.g.d.a<?> aVar = this.f4476d;
        if (aVar != null) {
            aVar.b();
        }
        Integer type = cardPackage == null ? null : cardPackage.getType();
        if ((type == null ? Constants.Companion.getTYPE_NEWEST() : type.intValue()) != Constants.Companion.getTYPE_NEWEST()) {
            e.l.o.a.a.a aVar2 = e.l.o.a.a.a.a;
            Integer pid = cardPackage == null ? null : cardPackage.getPid();
            Integer cid = cardPackage == null ? null : cardPackage.getCid();
            String value3 = M().getValue();
            Pair<String, String> value4 = L().getValue();
            String second = value4 == null ? null : value4.getSecond();
            Pair<String, String> value5 = W().getValue();
            c2 = aVar2.c(null, pid, cid, game, null, null, null, value3, second, value5 == null ? null : value5.getSecond(), this.f4475c.a(state).d());
        } else if (g2) {
            Pair<String, String> value6 = L().getValue();
            final Flow a2 = j.a.a((j) e.l.n.a.d(j.class, false, false, false, 60L, true), null, this.f4475c.a(state).d(), M().getValue(), (f0.g(value6 == null ? null : value6.getSecond(), "published_at_desc") || (value = L().getValue()) == null) ? null : value.getSecond(), null, null, null, 112, null);
            c2 = new Flow<Result<e.l.h.i.b<e.l.h.i.e<GameCard>>>>() { // from class: com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCards$$inlined$map$1

                /* renamed from: com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCards$$inlined$map$1$2  reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass2 implements i.b.v3.f<Result<e.l.h.i.e<GameCard>>> {
                    public final /* synthetic */ i.b.v3.f a;
                    public final /* synthetic */ ShopViewModel$getCards$$inlined$map$1 b;

                    /* renamed from: com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCards$$inlined$map$1$2$1  reason: invalid class name */
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

                        public AnonymousClass1(h.e2.c cVar) {
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

                    public AnonymousClass2(i.b.v3.f fVar, ShopViewModel$getCards$$inlined$map$1 shopViewModel$getCards$$inlined$map$1) {
                        this.a = fVar;
                        this.b = shopViewModel$getCards$$inlined$map$1;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                    @Override // i.b.v3.f
                    @k.e.a.e
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public java.lang.Object emit(com.jihuanshe.base.model.Result<e.l.h.i.e<com.jihuanshe.model.GameCard>> r7, @k.e.a.d h.e2.c r8) {
                        /*
                            r6 = this;
                            boolean r0 = r8 instanceof com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCards$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r8
                            com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCards$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCards$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCards$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCards$$inlined$map$1$2$1
                            r0.<init>(r8)
                        L18:
                            java.lang.Object r8 = r0.result
                            java.lang.Object r1 = h.e2.j.b.h()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            h.r0.n(r8)
                            goto L6e
                        L29:
                            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                            r7.<init>(r8)
                            throw r7
                        L31:
                            h.r0.n(r8)
                            i.b.v3.f r8 = r6.a
                            com.jihuanshe.base.model.Result r7 = (com.jihuanshe.base.model.Result) r7
                            com.jihuanshe.base.model.Result r2 = new com.jihuanshe.base.model.Result
                            r2.<init>()
                            java.lang.Integer r4 = r7.getCode()
                            r2.setCode(r4)
                            java.lang.String r4 = r7.getMsg()
                            r2.setMsg(r4)
                            java.lang.String r4 = r7.getMessage()
                            r2.setMessage(r4)
                            e.l.h.i.b r4 = new e.l.h.i.b
                            java.lang.Object r5 = r7.getData()
                            r4.<init>(r5)
                            r2.setData(r4)
                            okhttp3.Headers r7 = r7.getHeader()
                            r2.setHeader(r7)
                            r0.label = r3
                            java.lang.Object r7 = r8.emit(r2, r0)
                            if (r7 != r1) goto L6e
                            return r1
                        L6e:
                            h.t1 r7 = h.t1.a
                            return r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCards$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @e
                public Object e(@d i.b.v3.f<? super Result<e.l.h.i.b<e.l.h.i.e<GameCard>>>> fVar, @d h.e2.c cVar) {
                    Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                    return e2 == h.e2.j.b.h() ? e2 : t1.a;
                }
            };
        } else {
            e.l.o.a.a.a aVar3 = e.l.o.a.a.a.a;
            String value7 = M().getValue();
            Pair<String, String> value8 = L().getValue();
            c2 = aVar3.g(game, value7, value8 == null ? null : value8.getSecond(), null, this.f4475c.a(state).d());
        }
        e.g.d.a<?> h2 = e.g.d.a.h(e.g.d.a.o(e.g.d.a.j(FlowKt.c(new Flow<Result<e.l.h.i.b<e.l.h.i.e<GameCard>>>>() { // from class: com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCards$$inlined$map$2

            /* renamed from: com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCards$$inlined$map$2$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<Result<e.l.h.i.b<e.l.h.i.e<GameCard>>>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ ShopViewModel$getCards$$inlined$map$2 b;

                /* renamed from: com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCards$$inlined$map$2$2$1  reason: invalid class name */
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

                    public AnonymousClass1(h.e2.c cVar) {
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

                public AnonymousClass2(i.b.v3.f fVar, ShopViewModel$getCards$$inlined$map$2 shopViewModel$getCards$$inlined$map$2) {
                    this.a = fVar;
                    this.b = shopViewModel$getCards$$inlined$map$2;
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
                        boolean r0 = r8 instanceof com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCards$$inlined$map$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCards$$inlined$map$2$2$1 r0 = (com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCards$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCards$$inlined$map$2$2$1 r0 = new com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCards$$inlined$map$2$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r8)
                        goto L82
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
                        goto L79
                    L41:
                        java.lang.Object r2 = r2.a()
                        e.l.h.i.e r2 = (e.l.h.i.e) r2
                        if (r2 != 0) goto L4a
                        goto L79
                    L4a:
                        java.util.List r2 = r2.b()
                        if (r2 != 0) goto L51
                        goto L79
                    L51:
                        java.util.Iterator r2 = r2.iterator()
                    L55:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto L79
                        java.lang.Object r4 = r2.next()
                        com.jihuanshe.model.GameCard r4 = (com.jihuanshe.model.GameCard) r4
                        com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCards$$inlined$map$2 r5 = r6.b
                        boolean r5 = r2
                        r5 = r5 ^ r3
                        r4.setOnSale(r5)
                        com.jihuanshe.ui.widget.GameBar$a r5 = com.jihuanshe.ui.widget.GameBar.b
                        e.n.f r5 = r5.a()
                        java.lang.Object r5 = r5.getValue()
                        com.jihuanshe.model.Game r5 = (com.jihuanshe.model.Game) r5
                        r4.setGame(r5)
                        goto L55
                    L79:
                        r0.label = r3
                        java.lang.Object r7 = r8.emit(r7, r0)
                        if (r7 != r1) goto L82
                        return r1
                    L82:
                        h.t1 r7 = h.t1.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCards$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super Result<e.l.h.i.b<e.l.h.i.e<GameCard>>>> fVar, @d h.e2.c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), null, new ShopViewModel$getCards$3(z, this), 1, null), null, new ShopViewModel$getCards$4(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
        this.f4476d = h2;
        return h2;
    }

    @d
    public final NLive<List<Category>> u0() {
        return this.f4477e;
    }

    @Override // e.l.s.c
    public void v(int i2) {
        this.b.v(i2);
    }

    @d
    public final e.g.d.a<?> v0(@d final Game game) {
        this.f4475c.g();
        final Flow<List<Category>> b = e.l.o.a.a.a.a.b(game);
        return e.g.d.a.h(e.g.d.a.o(e.g.d.a.j(FlowKt.b(new Flow<List<Category>>() { // from class: com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCategory$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCategory$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<List<? extends Category>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ ShopViewModel$getCategory$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCategory$$inlined$map$1$2$1  reason: invalid class name */
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

                    public AnonymousClass1(h.e2.c cVar) {
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

                public AnonymousClass2(i.b.v3.f fVar, ShopViewModel$getCategory$$inlined$map$1 shopViewModel$getCategory$$inlined$map$1) {
                    this.a = fVar;
                    this.b = shopViewModel$getCategory$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(java.util.List<? extends com.jihuanshe.model.Category> r8, @k.e.a.d h.e2.c r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCategory$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r9
                        com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCategory$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCategory$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCategory$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCategory$$inlined$map$1$2$1
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r9)
                        goto L90
                    L29:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L31:
                        h.r0.n(r9)
                        i.b.v3.f r9 = r7.a
                        java.util.List r8 = (java.util.List) r8
                        r2 = 0
                        java.lang.Object r4 = kotlin.collections.CollectionsKt___CollectionsKt.J2(r8, r2)
                        com.jihuanshe.model.Category r4 = (com.jihuanshe.model.Category) r4
                        if (r4 != 0) goto L42
                        goto L5d
                    L42:
                        java.util.List r5 = r4.getPlist()
                        if (r5 != 0) goto L4a
                        r5 = 0
                        goto L4e
                    L4a:
                        java.util.List r5 = kotlin.collections.CollectionsKt___CollectionsKt.L5(r5)
                    L4e:
                        if (r5 != 0) goto L51
                        goto L5a
                    L51:
                        com.jihuanshe.model.Constants$Companion r6 = com.jihuanshe.model.Constants.Companion
                        com.jihuanshe.model.CardPackage r6 = r6.getNewestProduct()
                        r5.add(r2, r6)
                    L5a:
                        r4.setPlist(r5)
                    L5d:
                        java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.L5(r8)
                        com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCategory$$inlined$map$1 r4 = r7.b
                        com.jihuanshe.model.Game r4 = r2
                        java.lang.Integer r4 = r4.getWarehouse()
                        if (r4 != 0) goto L6c
                        goto L87
                    L6c:
                        int r4 = r4.intValue()
                        if (r4 != r3) goto L87
                        java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.L5(r8)
                        com.jihuanshe.model.Constants$Companion r8 = com.jihuanshe.model.Constants.Companion
                        com.jihuanshe.model.Category r4 = r8.getCategory()
                        r2.add(r3, r4)
                        r4 = 2
                        com.jihuanshe.model.Category r8 = r8.getCategoryDivider()
                        r2.add(r4, r8)
                    L87:
                        r0.label = r3
                        java.lang.Object r8 = r9.emit(r2, r0)
                        if (r8 != r1) goto L90
                        return r1
                    L90:
                        h.t1 r8 = h.t1.a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.main.shop.ShopViewModel$getCategory$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super List<Category>> fVar, @d h.e2.c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }, this.f4477e, true), null, new ShopViewModel$getCategory$2(this), 1, null), null, ShopViewModel$getCategory$3.INSTANCE, 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @Override // e.l.s.c
    @d
    public h w() {
        return this.b.w();
    }

    @d
    public final NLive<CardPackage> w0() {
        return this.f4479g;
    }

    @d
    public final NLive<Category> x0() {
        return this.f4478f;
    }

    @Override // e.l.s.c
    public void y(int i2) {
        this.b.y(i2);
    }

    @d
    public final NLive<List<GameCard>> y0() {
        return this.f4480h;
    }

    @d
    public final l z0() {
        return this.f4484l;
    }
}
