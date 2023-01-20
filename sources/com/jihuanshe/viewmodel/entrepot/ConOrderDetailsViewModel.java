package com.jihuanshe.viewmodel.entrepot;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.ApplyForItem;
import com.jihuanshe.model.CardConsignmentInfo;
import com.jihuanshe.model.ExpressData;
import com.jihuanshe.model.OrderReturnDetail;
import com.jihuanshe.model.OrderReturnInfo;
import com.jihuanshe.model.Trace;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.k;
import e.l.n.c.x;
import e.n.i;
import e.n.l;
import h.e2.c;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class ConOrderDetailsViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final NLive<CardConsignmentInfo> f4416c = new NLive<>(null, 1, null);
    @d

    /* renamed from: d  reason: collision with root package name */
    private final NLive<List<ApplyForItem>> f4417d = new NLive<>(null, 1, null);
    @d

    /* renamed from: e  reason: collision with root package name */
    private final l f4418e = new l(0);
    @d

    /* renamed from: f  reason: collision with root package name */
    private final NLive<OrderReturnDetail> f4419f = new NLive<>(null, 1, null);
    @d

    /* renamed from: g  reason: collision with root package name */
    private final NLive<List<OrderReturnInfo>> f4420g = new NLive<>(null, 1, null);
    @d

    /* renamed from: h  reason: collision with root package name */
    private final NLive<Pair<String, String>> f4421h = new NLive<>(null, 1, null);
    @d

    /* renamed from: i  reason: collision with root package name */
    private final i f4422i;
    @d

    /* renamed from: j  reason: collision with root package name */
    private final NLive<List<ExpressData>> f4423j;
    @d

    /* renamed from: k  reason: collision with root package name */
    private final i f4424k;

    public ConOrderDetailsViewModel() {
        Boolean bool = Boolean.FALSE;
        this.f4422i = new i(bool);
        this.f4423j = new NLive<>(null, 1, null);
        this.f4424k = new i(bool);
    }

    public static /* synthetic */ a D0(ConOrderDetailsViewModel conOrderDetailsViewModel, int i2, LoadMore.State state, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            state = null;
        }
        return conOrderDetailsViewModel.C0(i2, state);
    }

    public static /* synthetic */ a y0(ConOrderDetailsViewModel conOrderDetailsViewModel, int i2, LoadMore.State state, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            state = null;
        }
        return conOrderDetailsViewModel.x0(i2, state);
    }

    @d
    public final a<OrderReturnDetail> A0(int i2) {
        final Flow<OrderReturnDetail> h0 = ((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).h0(i2);
        return a.h(a.j(FlowKt.a(new Flow<OrderReturnDetail>() { // from class: com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getReturnOrdersDetails$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getReturnOrdersDetails$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<OrderReturnDetail> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ ConOrderDetailsViewModel$getReturnOrdersDetails$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getReturnOrdersDetails$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(i.b.v3.f fVar, ConOrderDetailsViewModel$getReturnOrdersDetails$$inlined$map$1 conOrderDetailsViewModel$getReturnOrdersDetails$$inlined$map$1) {
                    this.a = fVar;
                    this.b = conOrderDetailsViewModel$getReturnOrdersDetails$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(com.jihuanshe.model.OrderReturnDetail r7, @k.e.a.d h.e2.c r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getReturnOrdersDetails$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getReturnOrdersDetails$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getReturnOrdersDetails$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getReturnOrdersDetails$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getReturnOrdersDetails$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r8)
                        goto L5b
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        h.r0.n(r8)
                        i.b.v3.f r8 = r6.a
                        com.jihuanshe.model.OrderReturnDetail r7 = (com.jihuanshe.model.OrderReturnDetail) r7
                        com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getReturnOrdersDetails$$inlined$map$1 r2 = r6.b
                        com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel r2 = r2
                        e.n.i r2 = r2.E0()
                        java.lang.String r4 = r7.getStatus()
                        java.lang.String r5 = "pending"
                        boolean r4 = h.k2.v.f0.g(r4, r5)
                        r4 = r4 ^ r3
                        java.lang.Boolean r4 = h.e2.k.a.a.a(r4)
                        r2.setValue(r4)
                        r0.label = r3
                        java.lang.Object r7 = r8.emit(r7, r0)
                        if (r7 != r1) goto L5b
                        return r1
                    L5b:
                        h.t1 r7 = h.t1.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getReturnOrdersDetails$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super OrderReturnDetail> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }, this.f4419f), null, new ConOrderDetailsViewModel$getReturnOrdersDetails$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<CardConsignmentInfo> B0(int i2) {
        final Flow<CardConsignmentInfo> c2 = ((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).c(Integer.valueOf(i2));
        return a.h(a.j(FlowKt.a(new Flow<CardConsignmentInfo>() { // from class: com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getWarehouseOrderDetail$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getWarehouseOrderDetail$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<CardConsignmentInfo> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ ConOrderDetailsViewModel$getWarehouseOrderDetail$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getWarehouseOrderDetail$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(i.b.v3.f fVar, ConOrderDetailsViewModel$getWarehouseOrderDetail$$inlined$map$1 conOrderDetailsViewModel$getWarehouseOrderDetail$$inlined$map$1) {
                    this.a = fVar;
                    this.b = conOrderDetailsViewModel$getWarehouseOrderDetail$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(com.jihuanshe.model.CardConsignmentInfo r6, @k.e.a.d h.e2.c r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getWarehouseOrderDetail$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getWarehouseOrderDetail$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getWarehouseOrderDetail$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getWarehouseOrderDetail$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getWarehouseOrderDetail$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r7)
                        goto L50
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        h.r0.n(r7)
                        i.b.v3.f r7 = r5.a
                        com.jihuanshe.model.CardConsignmentInfo r6 = (com.jihuanshe.model.CardConsignmentInfo) r6
                        com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getWarehouseOrderDetail$$inlined$map$1 r2 = r5.b
                        com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel r2 = r2
                        e.n.i r2 = r2.E0()
                        java.lang.Boolean r4 = h.e2.k.a.a.a(r3)
                        r2.setValue(r4)
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L50
                        return r1
                    L50:
                        h.t1 r6 = h.t1.a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getWarehouseOrderDetail$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super CardConsignmentInfo> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }, this.f4416c), null, new ConOrderDetailsViewModel$getWarehouseOrderDetail$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<e.l.h.i.e<ApplyForItem>> C0(int i2, @e LoadMore.State state) {
        return a.h(a.o(BinderKt.b(FlowKt.c(x.a.c((x) e.l.n.a.d(x.class, true, false, false, 60L, true), i2, this.b.a(state).d(), null, null, 12, null)), this.f4417d, this.b.f()), null, new ConOrderDetailsViewModel$getWarehouseOrderList$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final i E0() {
        return this.f4422i;
    }

    @d
    public final i F0() {
        return this.f4424k;
    }

    @d
    public final NLive<List<ApplyForItem>> q0() {
        return this.f4417d;
    }

    @d
    public final NLive<CardConsignmentInfo> r0() {
        return this.f4416c;
    }

    @d
    public final NLive<List<OrderReturnInfo>> s0() {
        return this.f4420g;
    }

    @d
    public final NLive<OrderReturnDetail> t0() {
        return this.f4419f;
    }

    @d
    public final a<List<ExpressData>> u0(int i2, @d String str) {
        final Flow<Trace> U = ((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).U(null, Integer.valueOf(i2), Integer.valueOf(i2), str);
        return a.h(FlowKt.a(new Flow<List<? extends ExpressData>>() { // from class: com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getExpressData$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getExpressData$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<Trace> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ ConOrderDetailsViewModel$getExpressData$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getExpressData$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(i.b.v3.f fVar, ConOrderDetailsViewModel$getExpressData$$inlined$map$1 conOrderDetailsViewModel$getExpressData$$inlined$map$1) {
                    this.a = fVar;
                    this.b = conOrderDetailsViewModel$getExpressData$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(com.jihuanshe.model.Trace r7, @k.e.a.d h.e2.c r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getExpressData$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getExpressData$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getExpressData$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getExpressData$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getExpressData$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r8)
                        goto L6f
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        h.r0.n(r8)
                        i.b.v3.f r8 = r6.a
                        com.jihuanshe.model.Trace r7 = (com.jihuanshe.model.Trace) r7
                        java.util.List r7 = r7.getData()
                        if (r7 != 0) goto L42
                        java.util.List r7 = kotlin.collections.CollectionsKt__CollectionsKt.E()
                    L42:
                        com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getExpressData$$inlined$map$1 r2 = r6.b
                        com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel r2 = r2
                        e.n.i r2 = r2.F0()
                        boolean r4 = r7.isEmpty()
                        r4 = r4 ^ r3
                        if (r4 == 0) goto L5a
                        int r4 = r7.size()
                        r5 = 2
                        if (r4 <= r5) goto L5a
                        r4 = 1
                        goto L5b
                    L5a:
                        r4 = 0
                    L5b:
                        java.lang.Boolean r4 = h.e2.k.a.a.a(r4)
                        r2.setValue(r4)
                        java.util.List r7 = kotlin.collections.CollectionsKt___CollectionsKt.K4(r7)
                        r0.label = r3
                        java.lang.Object r7 = r8.emit(r7, r0)
                        if (r7 != r1) goto L6f
                        return r1
                    L6f:
                        h.t1 r7 = h.t1.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getExpressData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super List<? extends ExpressData>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }, this.f4423j), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<ExpressData>> v0() {
        return this.f4423j;
    }

    @d
    public final l w0() {
        return this.f4418e;
    }

    @d
    public final a<e.l.h.i.e<OrderReturnInfo>> x0(int i2, @e LoadMore.State state) {
        final Flow f2 = k.a.f((k) e.l.n.a.d(k.class, false, false, false, 60L, true), i2, this.b.a(state).d(), null, null, 12, null);
        return a.h(a.o(BinderKt.b(FlowKt.c(new Flow<e.l.h.i.e<OrderReturnInfo>>() { // from class: com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getOrderProducts$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getOrderProducts$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<Result<e.l.h.i.e<OrderReturnInfo>>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ ConOrderDetailsViewModel$getOrderProducts$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getOrderProducts$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(i.b.v3.f fVar, ConOrderDetailsViewModel$getOrderProducts$$inlined$map$1 conOrderDetailsViewModel$getOrderProducts$$inlined$map$1) {
                    this.a = fVar;
                    this.b = conOrderDetailsViewModel$getOrderProducts$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(com.jihuanshe.base.model.Result<e.l.h.i.e<com.jihuanshe.model.OrderReturnInfo>> r8, @k.e.a.d h.e2.c r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getOrderProducts$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r9
                        com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getOrderProducts$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getOrderProducts$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getOrderProducts$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getOrderProducts$$inlined$map$1$2$1
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r9)
                        goto L7b
                    L29:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L31:
                        h.r0.n(r9)
                        i.b.v3.f r9 = r7.a
                        com.jihuanshe.base.model.Result r8 = (com.jihuanshe.base.model.Result) r8
                        kotlin.Result$a r2 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L64
                        com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getOrderProducts$$inlined$map$1 r2 = r7.b     // Catch: java.lang.Throwable -> L64
                        com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel r2 = r2     // Catch: java.lang.Throwable -> L64
                        e.n.l r2 = r2.w0()     // Catch: java.lang.Throwable -> L64
                        okhttp3.Headers r4 = r8.getHeader()     // Catch: java.lang.Throwable -> L64
                        r5 = 0
                        if (r4 != 0) goto L4a
                        goto L5b
                    L4a:
                        java.lang.String r6 = "total_quantity"
                        java.lang.String r4 = r4.get(r6)     // Catch: java.lang.Throwable -> L64
                        if (r4 != 0) goto L53
                        goto L5b
                    L53:
                        int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Throwable -> L64
                        java.lang.Integer r5 = h.e2.k.a.a.f(r4)     // Catch: java.lang.Throwable -> L64
                    L5b:
                        r2.setValue(r5)     // Catch: java.lang.Throwable -> L64
                        h.t1 r2 = h.t1.a     // Catch: java.lang.Throwable -> L64
                        kotlin.Result.m106constructorimpl(r2)     // Catch: java.lang.Throwable -> L64
                        goto L6e
                    L64:
                        r2 = move-exception
                        kotlin.Result$a r4 = kotlin.Result.Companion
                        java.lang.Object r2 = h.r0.a(r2)
                        kotlin.Result.m106constructorimpl(r2)
                    L6e:
                        java.lang.Object r8 = r8.getData()
                        r0.label = r3
                        java.lang.Object r8 = r9.emit(r8, r0)
                        if (r8 != r1) goto L7b
                        return r1
                    L7b:
                        h.t1 r8 = h.t1.a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel$getOrderProducts$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super e.l.h.i.e<OrderReturnInfo>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), this.f4420g, this.b.f()), null, new ConOrderDetailsViewModel$getOrderProducts$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<Pair<String, String>> z0() {
        return this.f4421h;
    }
}
