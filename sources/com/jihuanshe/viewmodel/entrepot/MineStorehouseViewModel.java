package com.jihuanshe.viewmodel.entrepot;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardConsignmentInfo;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.ExpressData;
import com.jihuanshe.model.FailProductInfo;
import com.jihuanshe.model.SoldProductInfo;
import com.jihuanshe.model.Trace;
import com.jihuanshe.model.WarehouseProductInfo;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.e;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.k;
import e.n.l;
import e.t.j.h.g;
import h.e2.c;
import h.k2.v.f0;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class MineStorehouseViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final NLive<List<CardConsignmentInfo>> f4429c = new NLive<>(null, 1, null);
    @d

    /* renamed from: d  reason: collision with root package name */
    private final NLive<CardConsignmentInfo> f4430d = new NLive<>(null, 1, null);
    @d

    /* renamed from: e  reason: collision with root package name */
    private final NLive<List<WarehouseProductInfo>> f4431e = new NLive<>(null, 1, null);
    @d

    /* renamed from: f  reason: collision with root package name */
    private final NLive<List<FailProductInfo>> f4432f = new NLive<>(null, 1, null);
    @d

    /* renamed from: g  reason: collision with root package name */
    private final NLive<List<SoldProductInfo>> f4433g = new NLive<>(null, 1, null);
    @d

    /* renamed from: h  reason: collision with root package name */
    private final l f4434h = new l(1);
    @d

    /* renamed from: i  reason: collision with root package name */
    private final NLive<List<ExpressData>> f4435i = new NLive<>(null, 1, null);

    public static /* synthetic */ a A0(MineStorehouseViewModel mineStorehouseViewModel, LoadMore.State state, Integer num, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            state = null;
        }
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        return mineStorehouseViewModel.y0(state, num, str);
    }

    public static /* synthetic */ a E0(MineStorehouseViewModel mineStorehouseViewModel, Integer num, LoadMore.State state, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = null;
        }
        if ((i2 & 2) != 0) {
            state = null;
        }
        return mineStorehouseViewModel.C0(num, state);
    }

    public static /* synthetic */ a s0(MineStorehouseViewModel mineStorehouseViewModel, String str, LoadMore.State state, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            state = null;
        }
        return mineStorehouseViewModel.r0(str, state);
    }

    @d
    public final CardProductNew B0(@d WarehouseProductInfo warehouseProductInfo) {
        CardProductNew cardProductNew = new CardProductNew(0.0f, 0.0f, 0, null, null, null, null, null, null, 0.0f, false, null, false, null, null, null, null, null, 262143, null);
        cardProductNew.setGameKey(warehouseProductInfo.getGameKey());
        cardProductNew.setPrice(warehouseProductInfo.getPrice());
        cardProductNew.setAvgPrice((warehouseProductInfo.getAvgPrice() == null || f0.g(warehouseProductInfo.getAvgPrice(), "")) ? 0.0f : Float.parseFloat(warehouseProductInfo.getAvgPrice()));
        cardProductNew.setCardId(warehouseProductInfo.getCardId());
        cardProductNew.setCardNameCn(warehouseProductInfo.getCardName());
        cardProductNew.setCardVersionImage(warehouseProductInfo.getCardVersionImageUrl());
        cardProductNew.setCardVersionNumber(warehouseProductInfo.getCardVersionNumber());
        cardProductNew.setCardVersionRarity(warehouseProductInfo.getCardVersionRarity());
        String minPrice = warehouseProductInfo.getMinPrice();
        cardProductNew.setMinPrice(minPrice == null || minPrice.length() == 0 ? 0.0f : Float.parseFloat(warehouseProductInfo.getMinPrice()));
        cardProductNew.setNeedPublishLocation(false);
        cardProductNew.setProducts(CollectionsKt__CollectionsKt.E());
        cardProductNew.setWarehousePendingProducts(CollectionsKt__CollectionsKt.E());
        cardProductNew.setWarehouseProducts(CollectionsKt__CollectionsKt.E());
        return cardProductNew;
    }

    @d
    public final a<e<SoldProductInfo>> C0(@k.e.a.e Integer num, @k.e.a.e LoadMore.State state) {
        return a.h(a.o(BinderKt.b(FlowKt.c(k.a.g((k) e.l.n.a.d(k.class, true, false, false, 60L, true), num, null, this.b.a(state).d(), null, null, 24, null)), this.f4433g, this.b.f()), null, new MineStorehouseViewModel$getSoldProducts$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<SoldProductInfo>> D0() {
        return this.f4433g;
    }

    @d
    public final l F0() {
        return this.f4434h;
    }

    @d
    public final a<e<WarehouseProductInfo>> G0(@d String str, @k.e.a.e LoadMore.State state, @k.e.a.e String str2, @k.e.a.e String str3, @k.e.a.e String str4, @k.e.a.e String str5) {
        return a.h(a.o(BinderKt.b(FlowKt.c(k.a.k((k) e.l.n.a.d(k.class, true, false, false, 60L, true), str, str2, str3, str4, str5, this.b.a(state).d(), null, null, 192, null)), this.f4431e, this.b.f()), null, new MineStorehouseViewModel$getWarehouseProducts$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> I0(int i2, float f2) {
        return a.h(FlowKt.c(k.a.m((k) e.l.n.a.d(k.class, true, false, false, 60L, true), Integer.valueOf(i2), f2, null, null, 12, null)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> J0() {
        return a.h(FlowKt.c(k.a.o((k) e.l.n.a.d(k.class, true, false, false, 60L, true), null, null, 3, null)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> K0(int i2, float f2) {
        return a.h(FlowKt.c(k.a.p((k) e.l.n.a.d(k.class, true, false, false, 60L, true), Integer.valueOf(i2), f2, null, null, 12, null)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> L0() {
        return a.h(FlowKt.c(k.a.q((k) e.l.n.a.d(k.class, true, false, false, 60L, true), null, null, 3, null)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> M0(int i2, float f2) {
        return a.h(FlowKt.c(k.a.r((k) e.l.n.a.d(k.class, true, false, false, 60L, true), Integer.valueOf(i2), f2, null, null, 12, null)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final g q0(int i2) {
        return e.t.j.h.d.a.a(new MineStorehouseViewModel$chooseTabTag$1(this, i2));
    }

    @d
    public final a<e<CardConsignmentInfo>> r0(@d String str, @k.e.a.e LoadMore.State state) {
        final Flow j2 = k.a.j((k) e.l.n.a.d(k.class, true, false, false, 60L, true), str, this.b.a(state).d(), null, null, 12, null);
        return a.h(a.o(BinderKt.b(FlowKt.c(new Flow<e<CardConsignmentInfo>>() { // from class: com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel$getCardListData$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel$getCardListData$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<e<CardConsignmentInfo>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ MineStorehouseViewModel$getCardListData$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel$getCardListData$$inlined$map$1$2$1  reason: invalid class name */
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
                    public final Object invokeSuspend(@d Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i.b.v3.f fVar, MineStorehouseViewModel$getCardListData$$inlined$map$1 mineStorehouseViewModel$getCardListData$$inlined$map$1) {
                    this.a = fVar;
                    this.b = mineStorehouseViewModel$getCardListData$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(e.l.h.i.e<com.jihuanshe.model.CardConsignmentInfo> r7, @k.e.a.d h.e2.c r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel$getCardListData$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel$getCardListData$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel$getCardListData$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel$getCardListData$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel$getCardListData$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r8)
                        goto L6d
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        h.r0.n(r8)
                        i.b.v3.f r8 = r6.a
                        e.l.h.i.e r7 = (e.l.h.i.e) r7
                        java.util.List r2 = r7.b()
                        r4 = 0
                        if (r2 != 0) goto L41
                    L3f:
                        r2 = 0
                        goto L49
                    L41:
                        boolean r2 = r2.isEmpty()
                        r2 = r2 ^ r3
                        if (r2 != r3) goto L3f
                        r2 = 1
                    L49:
                        if (r2 == 0) goto L64
                        com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel$getCardListData$$inlined$map$1 r2 = r6.b
                        com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel r2 = r2
                        com.eth.model.NLive r2 = r2.u0()
                        java.util.List r5 = r7.b()
                        if (r5 != 0) goto L5b
                        r4 = 0
                        goto L61
                    L5b:
                        java.lang.Object r4 = r5.get(r4)
                        com.jihuanshe.model.CardConsignmentInfo r4 = (com.jihuanshe.model.CardConsignmentInfo) r4
                    L61:
                        r2.setValue(r4)
                    L64:
                        r0.label = r3
                        java.lang.Object r7 = r8.emit(r7, r0)
                        if (r7 != r1) goto L6d
                        return r1
                    L6d:
                        h.t1 r7 = h.t1.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel$getCardListData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @k.e.a.e
            public Object e(@d i.b.v3.f<? super e<CardConsignmentInfo>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), this.f4429c, this.b.f()), null, new MineStorehouseViewModel$getCardListData$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<CardConsignmentInfo>> t0() {
        return this.f4429c;
    }

    @d
    public final NLive<CardConsignmentInfo> u0() {
        return this.f4430d;
    }

    @d
    public final NLive<List<WarehouseProductInfo>> v0() {
        return this.f4431e;
    }

    @d
    public final a<List<ExpressData>> w0(int i2) {
        final Flow<Trace> U = ((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).U(null, Integer.valueOf(i2), null, "warehouse_order");
        return a.h(FlowKt.a(new Flow<List<? extends ExpressData>>() { // from class: com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel$getExpressData$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel$getExpressData$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<Trace> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ MineStorehouseViewModel$getExpressData$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel$getExpressData$$inlined$map$1$2$1  reason: invalid class name */
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
                    public final Object invokeSuspend(@d Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i.b.v3.f fVar, MineStorehouseViewModel$getExpressData$$inlined$map$1 mineStorehouseViewModel$getExpressData$$inlined$map$1) {
                    this.a = fVar;
                    this.b = mineStorehouseViewModel$getExpressData$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(com.jihuanshe.model.Trace r5, @k.e.a.d h.e2.c r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel$getExpressData$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel$getExpressData$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel$getExpressData$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel$getExpressData$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel$getExpressData$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r6)
                        goto L4f
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        h.r0.n(r6)
                        i.b.v3.f r6 = r4.a
                        com.jihuanshe.model.Trace r5 = (com.jihuanshe.model.Trace) r5
                        java.util.List r5 = r5.getData()
                        if (r5 != 0) goto L42
                        java.util.List r5 = kotlin.collections.CollectionsKt__CollectionsKt.E()
                    L42:
                        java.util.List r5 = kotlin.collections.CollectionsKt___CollectionsKt.K4(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4f
                        return r1
                    L4f:
                        h.t1 r5 = h.t1.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel$getExpressData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @k.e.a.e
            public Object e(@d i.b.v3.f<? super List<? extends ExpressData>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }, this.f4435i), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<ExpressData>> x0() {
        return this.f4435i;
    }

    @d
    public final a<e<FailProductInfo>> y0(@k.e.a.e LoadMore.State state, @k.e.a.e Integer num, @k.e.a.e String str) {
        return a.h(a.o(BinderKt.b(FlowKt.c(k.a.e((k) e.l.n.a.d(k.class, true, false, false, 60L, true), str, null, num, this.b.a(state).d(), null, null, 48, null)), this.f4432f, this.b.f()), null, new MineStorehouseViewModel$getFailProducts$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<FailProductInfo>> z0() {
        return this.f4432f;
    }
}
