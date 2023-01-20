package com.jihuanshe.viewmodel.user;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.Banner;
import com.jihuanshe.model.CardProduct;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.model.ShopCarInfo;
import com.jihuanshe.model.ShopCarResult;
import com.jihuanshe.model.User;
import com.jihuanshe.viewmodel.FilterRarityImpl;
import com.jihuanshe.viewmodel.UploadViewModel;
import com.vector.design.ui.delegate.LoadMore;
import com.vector.design.ui.nav.AppBar;
import com.vector.util.UIUtil;
import e.g.d.a;
import e.l.n.c.e;
import e.l.n.c.f;
import e.l.n.c.j;
import e.l.n.c.o;
import e.l.n.c.v;
import e.l.n.c.w;
import e.l.s.b;
import e.l.s.f;
import e.l.s.g;
import e.n.i;
import e.n.l;
import e.n.p;
import e.t.o.d;
import h.e2.c;
import h.k2.v.f0;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class SellerDetailViewModel extends UploadViewModel implements f, g {

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ b f4571d = new b();

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ FilterRarityImpl f4572e = new FilterRarityImpl();

    /* renamed from: f  reason: collision with root package name */
    private final int f4573f;

    /* renamed from: g  reason: collision with root package name */
    private final int f4574g;

    /* renamed from: h  reason: collision with root package name */
    private final int f4575h;
    @d

    /* renamed from: i  reason: collision with root package name */
    private final e.n.f<Banner> f4576i;
    @d

    /* renamed from: j  reason: collision with root package name */
    private final e.n.f<User> f4577j;
    @d

    /* renamed from: k  reason: collision with root package name */
    private final i f4578k;
    @d

    /* renamed from: l  reason: collision with root package name */
    private final NLive<List<GameCard>> f4579l;
    @d

    /* renamed from: m  reason: collision with root package name */
    private final NLive<List<CardProduct>> f4580m;
    @d
    private final i n;
    @d
    private final p o;
    @d
    private final e.n.f<ShopCarInfo> p;
    @d
    private final i q;
    @d
    private final i r;
    @d
    private final i s;
    @d
    private final l t;
    @d
    private final i u;
    @d
    private final i v;
    @d
    private final e.l.h.i.f w;
    @d
    private e.n.f<CardProduct> x;

    public SellerDetailViewModel() {
        d.a aVar = e.t.o.d.a;
        this.f4573f = d.a.c(aVar, null, 1, null).d(6);
        this.f4574g = UIUtil.c() + d.a.c(aVar, null, 1, null).d(58);
        this.f4575h = UIUtil.c() + d.a.c(aVar, null, 1, null).d(AppBar.f7769h.a().j());
        this.f4576i = new e.n.f<>(null, 1, null);
        this.f4577j = new e.n.f<>(null, 1, null);
        Boolean bool = Boolean.FALSE;
        this.f4578k = new i(bool);
        this.f4579l = new NLive<>(null, 1, null);
        this.f4580m = new NLive<>(null, 1, null);
        this.n = new i(bool);
        this.o = new p(null, 1, null);
        this.p = new e.n.f<>(null, 1, null);
        this.q = new i(bool);
        this.r = new i(null, 1, null);
        this.s = new i(bool);
        this.t = new l(0);
        this.u = new i(null, 1, null);
        this.v = new i(null, 1, null);
        this.w = new e.l.h.i.f();
        this.x = new e.n.f<>(null, 1, null);
    }

    public static /* synthetic */ a B0(SellerDetailViewModel sellerDetailViewModel, CardProduct cardProduct, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        return sellerDetailViewModel.A0(cardProduct, i2);
    }

    public static /* synthetic */ a S0(SellerDetailViewModel sellerDetailViewModel, int i2, Integer num, String str, String str2, boolean z, LoadMore.State state, int i3, Object obj) {
        boolean z2 = (i3 & 16) != 0 ? true : z;
        if ((i3 & 32) != 0) {
            state = null;
        }
        return sellerDetailViewModel.R0(i2, num, str, str2, z2, state);
    }

    @k.e.a.d
    public final a<Result<ShopCarResult>> A0(@k.e.a.d CardProduct cardProduct, int i2) {
        return a.h(a.j(FlowKt.c(((e.l.n.c.d) e.l.n.a.d(e.l.n.c.d.class, false, false, false, 60L, true)).a(cardProduct.getPid(), i2)), null, new SellerDetailViewModel$addShopCar$1(this, i2, cardProduct), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @k.e.a.d
    public final a<t1> C0(int i2) {
        return a.h(FlowKt.c(((e) e.l.n.a.d(e.class, true, false, false, 60L, true)).a(i2)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @Override // e.l.s.f
    public void D() {
        this.f4571d.D();
    }

    @k.e.a.d
    public final e.t.j.h.g D0(int i2) {
        return e.t.j.h.d.a.a(new SellerDetailViewModel$clickPriceType$1(this, i2));
    }

    public final int E0() {
        return this.f4575h;
    }

    public final int F0() {
        return this.f4574g;
    }

    @k.e.a.d
    public final e.n.f<Banner> G0() {
        return this.f4576i;
    }

    @Override // e.l.s.g
    @k.e.a.d
    public e.n.f<List<Rarity>> H() {
        return this.f4572e.H();
    }

    @k.e.a.d
    public final NLive<List<GameCard>> H0() {
        return this.f4579l;
    }

    @k.e.a.d
    public final i I0() {
        return this.f4578k;
    }

    @Override // e.l.s.g
    @k.e.a.e
    public String J() {
        return this.f4572e.J();
    }

    public final int J0() {
        return this.f4573f;
    }

    @Override // e.l.s.f
    @k.e.a.d
    public e.n.f<List<e.l.s.a>> K() {
        return this.f4571d.K();
    }

    @k.e.a.d
    public final NLive<List<CardProduct>> K0() {
        return this.f4580m;
    }

    @k.e.a.d
    public final a<Result<List<CardProduct>>> L0(int i2) {
        final Flow<Result<List<CardProduct>>> c2 = ((j) e.l.n.a.d(j.class, false, false, false, 60L, true)).c(i2);
        return a.h(a.j(FlowKt.c(new Flow<Result<List<? extends CardProduct>>>() { // from class: com.jihuanshe.viewmodel.user.SellerDetailViewModel$getMyShopCar$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.user.SellerDetailViewModel$getMyShopCar$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<Result<List<? extends CardProduct>>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ SellerDetailViewModel$getMyShopCar$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.user.SellerDetailViewModel$getMyShopCar$$inlined$map$1$2$1  reason: invalid class name */
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
                    @k.e.a.e
                    public final Object invokeSuspend(@k.e.a.d Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i.b.v3.f fVar, SellerDetailViewModel$getMyShopCar$$inlined$map$1 sellerDetailViewModel$getMyShopCar$$inlined$map$1) {
                    this.a = fVar;
                    this.b = sellerDetailViewModel$getMyShopCar$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(com.jihuanshe.base.model.Result<java.util.List<? extends com.jihuanshe.model.CardProduct>> r8, @k.e.a.d h.e2.c r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof com.jihuanshe.viewmodel.user.SellerDetailViewModel$getMyShopCar$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r9
                        com.jihuanshe.viewmodel.user.SellerDetailViewModel$getMyShopCar$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.user.SellerDetailViewModel$getMyShopCar$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.user.SellerDetailViewModel$getMyShopCar$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.user.SellerDetailViewModel$getMyShopCar$$inlined$map$1$2$1
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r9)
                        goto L6a
                    L29:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L31:
                        h.r0.n(r9)
                        i.b.v3.f r9 = r7.a
                        com.jihuanshe.base.model.Result r8 = (com.jihuanshe.base.model.Result) r8
                        java.lang.Object r2 = r8.getData()
                        java.util.List r2 = (java.util.List) r2
                        if (r2 != 0) goto L41
                        goto L61
                    L41:
                        java.util.Iterator r2 = r2.iterator()
                    L45:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto L61
                        java.lang.Object r4 = r2.next()
                        com.jihuanshe.model.CardProduct r4 = (com.jihuanshe.model.CardProduct) r4
                        java.lang.String r5 = r4.getGameKey()
                        java.lang.String r6 = r4.getGameSubKey()
                        com.jihuanshe.model.Game r5 = e.l.l.a.b(r5, r6)
                        r4.setGame(r5)
                        goto L45
                    L61:
                        r0.label = r3
                        java.lang.Object r8 = r9.emit(r8, r0)
                        if (r8 != r1) goto L6a
                        return r1
                    L6a:
                        h.t1 r8 = h.t1.a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.user.SellerDetailViewModel$getMyShopCar$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @k.e.a.e
            public Object e(@k.e.a.d i.b.v3.f<? super Result<List<? extends CardProduct>>> fVar, @k.e.a.d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), null, new SellerDetailViewModel$getMyShopCar$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @k.e.a.d
    public final l M0() {
        return this.t;
    }

    @k.e.a.d
    public final i N0() {
        return this.u;
    }

    @k.e.a.d
    public final e.n.f<CardProduct> O0() {
        return this.x;
    }

    @k.e.a.d
    public final p P0() {
        return this.o;
    }

    @k.e.a.d
    public final a<CardProduct> Q0(int i2, int i3, @k.e.a.d String str, @k.e.a.d String str2) {
        return a.h(a.j(FlowKt.c(((o) e.l.n.a.d(o.class, true, false, false, 60L, true)).a(i2, i3, str, str2)), null, new SellerDetailViewModel$getSellerCardVersion$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @Override // e.l.s.f
    public void R(@k.e.a.d List<e.l.s.a> list, int i2) {
        this.f4571d.R(list, i2);
    }

    @k.e.a.d
    public final a<Result<e.l.h.i.e<GameCard>>> R0(int i2, @k.e.a.e Integer num, @k.e.a.d String str, @k.e.a.d String str2, boolean z, @k.e.a.e LoadMore.State state) {
        final Flow<Result<e.l.h.i.e<GameCard>>> a;
        if (d1()) {
            e.l.s.a u = u();
            final Flow a2 = j.a.a((j) e.l.n.a.d(j.class, false, false, false, 60L, true), null, this.w.a(state).d(), J(), (f0.g(u, Constants.Companion.getFILTER_INFO_NEWEST()) || u == null) ? null : u.e(), Integer.valueOf(i2), null, null, 96, null);
            a = new Flow<Result<e.l.h.i.e<GameCard>>>() { // from class: com.jihuanshe.viewmodel.user.SellerDetailViewModel$getSellerCards$$inlined$map$1

                /* renamed from: com.jihuanshe.viewmodel.user.SellerDetailViewModel$getSellerCards$$inlined$map$1$2 */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass2 implements i.b.v3.f<Result<e.l.h.i.e<GameCard>>> {
                    public final /* synthetic */ i.b.v3.f a;
                    public final /* synthetic */ SellerDetailViewModel$getSellerCards$$inlined$map$1 b;

                    /* renamed from: com.jihuanshe.viewmodel.user.SellerDetailViewModel$getSellerCards$$inlined$map$1$2$1 */
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

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(c cVar) {
                            super(cVar);
                            AnonymousClass2.this = r1;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @k.e.a.e
                        public final Object invokeSuspend(@k.e.a.d Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(i.b.v3.f fVar, SellerDetailViewModel$getSellerCards$$inlined$map$1 sellerDetailViewModel$getSellerCards$$inlined$map$1) {
                        this.a = fVar;
                        this.b = sellerDetailViewModel$getSellerCards$$inlined$map$1;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:40:0x0023  */
                    /* JADX WARN: Removed duplicated region for block: B:44:0x0031  */
                    @Override // i.b.v3.f
                    @k.e.a.e
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public java.lang.Object emit(com.jihuanshe.base.model.Result<e.l.h.i.e<com.jihuanshe.model.GameCard>> r7, @k.e.a.d h.e2.c r8) {
                        /*
                            r6 = this;
                            boolean r0 = r8 instanceof com.jihuanshe.viewmodel.user.SellerDetailViewModel$getSellerCards$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r8
                            com.jihuanshe.viewmodel.user.SellerDetailViewModel$getSellerCards$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.user.SellerDetailViewModel$getSellerCards$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.jihuanshe.viewmodel.user.SellerDetailViewModel$getSellerCards$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.user.SellerDetailViewModel$getSellerCards$$inlined$map$1$2$1
                            r0.<init>(r8)
                        L18:
                            java.lang.Object r8 = r0.result
                            java.lang.Object r1 = h.e2.j.b.h()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            h.r0.n(r8)
                            goto L66
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
                            goto L5d
                        L41:
                            java.util.List r2 = r2.b()
                            if (r2 != 0) goto L48
                            goto L5d
                        L48:
                            java.util.Iterator r2 = r2.iterator()
                        L4c:
                            boolean r4 = r2.hasNext()
                            if (r4 == 0) goto L5d
                            java.lang.Object r4 = r2.next()
                            com.jihuanshe.model.GameCard r4 = (com.jihuanshe.model.GameCard) r4
                            r5 = 0
                            r4.setOnSale(r5)
                            goto L4c
                        L5d:
                            r0.label = r3
                            java.lang.Object r7 = r8.emit(r7, r0)
                            if (r7 != r1) goto L66
                            return r1
                        L66:
                            h.t1 r7 = h.t1.a
                            return r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.user.SellerDetailViewModel$getSellerCards$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @k.e.a.e
                public Object e(@k.e.a.d i.b.v3.f<? super Result<e.l.h.i.e<GameCard>>> fVar, @k.e.a.d c cVar) {
                    Object e2 = a2.e(new AnonymousClass2(fVar, this), cVar);
                    return e2 == h.e2.j.b.h() ? e2 : t1.a;
                }
            };
        } else {
            e.l.n.c.p pVar = (e.l.n.c.p) e.l.n.a.d(e.l.n.c.p.class, false, false, false, 60L, true);
            String J = J();
            e.l.s.a u2 = u();
            a = pVar.a(num, i2, J, u2 == null ? null : u2.e(), null, str, str2, this.w.a(state).d());
        }
        return a.h(a.o(a.j(FlowKt.c(new Flow<Result<e.l.h.i.e<GameCard>>>() { // from class: com.jihuanshe.viewmodel.user.SellerDetailViewModel$getSellerCards$$inlined$map$2

            /* renamed from: com.jihuanshe.viewmodel.user.SellerDetailViewModel$getSellerCards$$inlined$map$2$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<Result<e.l.h.i.e<GameCard>>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ SellerDetailViewModel$getSellerCards$$inlined$map$2 b;

                /* renamed from: com.jihuanshe.viewmodel.user.SellerDetailViewModel$getSellerCards$$inlined$map$2$2$1  reason: invalid class name */
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
                    @k.e.a.e
                    public final Object invokeSuspend(@k.e.a.d Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i.b.v3.f fVar, SellerDetailViewModel$getSellerCards$$inlined$map$2 sellerDetailViewModel$getSellerCards$$inlined$map$2) {
                    this.a = fVar;
                    this.b = sellerDetailViewModel$getSellerCards$$inlined$map$2;
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
                        boolean r0 = r8 instanceof com.jihuanshe.viewmodel.user.SellerDetailViewModel$getSellerCards$$inlined$map$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.jihuanshe.viewmodel.user.SellerDetailViewModel$getSellerCards$$inlined$map$2$2$1 r0 = (com.jihuanshe.viewmodel.user.SellerDetailViewModel$getSellerCards$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.user.SellerDetailViewModel$getSellerCards$$inlined$map$2$2$1 r0 = new com.jihuanshe.viewmodel.user.SellerDetailViewModel$getSellerCards$$inlined$map$2$2$1
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
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.user.SellerDetailViewModel$getSellerCards$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @k.e.a.e
            public Object e(@k.e.a.d i.b.v3.f<? super Result<e.l.h.i.e<GameCard>>> fVar, @k.e.a.d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), null, new SellerDetailViewModel$getSellerCards$3(z, this), 1, null), null, new SellerDetailViewModel$getSellerCards$4(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @k.e.a.d
    public final e.n.f<ShopCarInfo> T0() {
        return this.p;
    }

    @Override // e.l.s.f
    public void U(@k.e.a.e LifecycleOwner lifecycleOwner, @k.e.a.d h.k2.u.l<? super e.l.s.a, t1> lVar) {
        this.f4571d.U(lifecycleOwner, lVar);
    }

    @k.e.a.d
    public final i U0() {
        return this.s;
    }

    @k.e.a.d
    public final i V0() {
        return this.n;
    }

    @k.e.a.d
    public final i W0() {
        return this.q;
    }

    @k.e.a.d
    public final e.n.f<User> X0() {
        return this.f4577j;
    }

    @k.e.a.d
    public final a<User> Y0(int i2) {
        return a.h(a.j(FlowKt.c(((v) e.l.n.a.d(v.class, true, false, false, 60L, true)).f(i2)), null, new SellerDetailViewModel$getUserDetail$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @k.e.a.d
    public final a<t1> Z0(int i2, @k.e.a.d String str, @k.e.a.d String str2, @k.e.a.d List<String> list) {
        return a.h(a.j(FlowKt.c(f.a.b((e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true), i2, str, str2, list, null, 16, null)), null, new SellerDetailViewModel$goErrorCorrect$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @k.e.a.d
    public final a<t1> a1(int i2) {
        a j2;
        if (this.f4578k.u()) {
            j2 = a.j(FlowKt.c(((w) e.l.n.a.d(w.class, false, false, false, 60L, true)).b(i2)), null, new SellerDetailViewModel$handleFollow$1(this), 1, null);
        } else {
            j2 = a.j(FlowKt.c(((w) e.l.n.a.d(w.class, false, false, false, 60L, true)).c(i2)), null, new SellerDetailViewModel$handleFollow$2(this), 1, null);
        }
        return a.h(j2, ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @Override // e.l.s.g
    public void b0(@k.e.a.e List<Rarity> list) {
        this.f4572e.b0(list);
    }

    @k.e.a.d
    public final i b1() {
        return this.v;
    }

    @Override // e.l.s.g
    @k.e.a.d
    public i c() {
        return this.f4572e.c();
    }

    @k.e.a.d
    public final i c1() {
        return this.r;
    }

    public final boolean d1() {
        Integer value = this.t.getValue();
        return value != null && value.intValue() == 1;
    }

    @Override // e.l.s.f
    @k.e.a.d
    public e.n.f<e.l.s.a> e0() {
        return this.f4571d.e0();
    }

    @k.e.a.d
    public final a<Result<ShopCarResult>> e1(int i2) {
        return a.h(a.j(FlowKt.c(((e.l.n.c.d) e.l.n.a.d(e.l.n.c.d.class, false, false, false, 60L, true)).b(i2)), null, new SellerDetailViewModel$minusShopCar$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @Override // e.l.s.f
    @k.e.a.d
    public l f() {
        return this.f4571d.f();
    }

    @k.e.a.d
    public final a<ShopCarResult> f1(int i2) {
        return a.h(FlowKt.c(((e) e.l.n.a.d(e.class, true, false, false, 60L, true)).b(i2)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @Override // e.l.s.f
    @k.e.a.d
    public i g() {
        return this.f4571d.g();
    }

    @k.e.a.d
    public final a<t1> g1(int i2, int i3, @k.e.a.d String str, @k.e.a.d String str2, @k.e.a.d String str3) {
        return a.h(FlowKt.c(((w) e.l.n.a.d(w.class, false, false, false, 60L, true)).a(i2, i3, str, str2, str3)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    public final void h1(@k.e.a.d e.n.f<CardProduct> fVar) {
        this.x = fVar;
    }

    @Override // e.l.s.g
    @k.e.a.d
    public h.k2.u.l<List<Rarity>, t1> i0() {
        return this.f4572e.i0();
    }

    @Override // e.l.s.g
    public void j() {
        this.f4572e.j();
    }

    @Override // e.l.s.f
    @k.e.a.d
    public h.k2.u.l<e.l.s.a, t1> p() {
        return this.f4571d.p();
    }

    @Override // e.l.s.f
    @k.e.a.e
    public e.l.s.a u() {
        return this.f4571d.u();
    }

    public final void v(int i2) {
    }

    @Override // e.l.s.g
    public void z(@k.e.a.e LifecycleOwner lifecycleOwner, @k.e.a.d h.k2.u.l<? super String, t1> lVar) {
        this.f4572e.z(lifecycleOwner, lVar);
    }
}
