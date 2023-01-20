package com.jihuanshe.viewmodel.order;

import android.os.CountDownTimer;
import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.ExpressData;
import com.jihuanshe.model.OrderDetailInfo;
import com.jihuanshe.model.PayParams;
import com.jihuanshe.model.Trace;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.vector.util.Res;
import e.l.h.l.b;
import e.l.n.c.k;
import e.l.n.c.l;
import e.n.i;
import e.n.l;
import e.n.p;
import h.e2.c;
import h.t1;
import i.b.v3.f;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class OrderDetailViewModel extends b {
    @d
    private final NLive<OrderDetailInfo> b = new NLive<>(null, 1, null);
    @d

    /* renamed from: c  reason: collision with root package name */
    private l f4487c = new l(-1);
    @d

    /* renamed from: d  reason: collision with root package name */
    private final NLive<List<ExpressData>> f4488d = new NLive<>(null, 1, null);
    @d

    /* renamed from: e  reason: collision with root package name */
    private final p f4489e = new p(null, 1, null);
    @d

    /* renamed from: f  reason: collision with root package name */
    private final i f4490f = new i(Boolean.FALSE);
    @e

    /* renamed from: g  reason: collision with root package name */
    private a f4491g;

    /* loaded from: classes2.dex */
    public static final class a extends CountDownTimer {
        @d
        private final p a;

        public a(long j2, long j3, @d p pVar) {
            super(j2, j3);
            this.a = pVar;
        }

        @d
        public final p a() {
            return this.a;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.a.setValue("00:00");
            cancel();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            this.a.setValue(DateTimeUtil.formatSecondsTo00((int) (j2 / 1000)));
        }
    }

    @d
    public final l A0() {
        return this.f4487c;
    }

    @e
    public final a B0() {
        return this.f4491g;
    }

    @d
    public final i C0() {
        return this.f4490f;
    }

    @d
    public final e.g.d.a<PayParams> D0(int i2) {
        return e.g.d.a.h(e.g.d.a.j(FlowKt.c(l.a.a((e.l.n.c.l) e.l.n.a.d(e.l.n.c.l.class, true, false, false, 60L, true), i2, null, 2, null)), null, OrderDetailViewModel$payOrder$1.INSTANCE, 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    public final void E0(@d e.n.l lVar) {
        this.f4487c = lVar;
    }

    public final void F0(@e a aVar) {
        this.f4491g = aVar;
    }

    @Override // e.t.k.b.a
    public void m0() {
        a aVar = this.f4491g;
        if (aVar != null) {
            aVar.cancel();
        }
        super.m0();
    }

    @d
    public final e.g.d.a<t1> p0(int i2, int i3, @d String str) {
        return e.g.d.a.h(FlowKt.c(((e.l.n.c.l) e.l.n.a.d(e.l.n.c.l.class, true, false, false, 60L, true)).c(i2, i3, str)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final e.g.d.a<t1> q0(int i2, int i3, @d String str) {
        return e.g.d.a.h(FlowKt.c(((e.l.n.c.l) e.l.n.a.d(e.l.n.c.l.class, true, false, false, 60L, true)).g(i2, i3, str)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final e.g.d.a<t1> r0(int i2, @d String str) {
        return e.g.d.a.h(FlowKt.c(((e.l.n.c.l) e.l.n.a.d(e.l.n.c.l.class, true, false, false, 60L, true)).b(i2, str)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final e.g.d.a<t1> s0(int i2) {
        return e.g.d.a.h(FlowKt.c(((e.l.n.c.l) e.l.n.a.d(e.l.n.c.l.class, true, false, false, 60L, true)).h(i2)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final e.g.d.a<t1> t0(int i2) {
        return e.g.d.a.h(FlowKt.c(((e.l.n.c.l) e.l.n.a.d(e.l.n.c.l.class, true, false, false, 60L, true)).d(i2)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    public final int u0(int i2) {
        if (i2 < this.f4487c.getValue().intValue()) {
            return Res.k(R.color.black);
        }
        Integer value = this.f4487c.getValue();
        return (value != null && i2 == value.intValue()) ? Res.k(R.color.common_color_1) : Res.k(R.color.black_b5b5b7);
    }

    @d
    public final e.g.d.a<OrderDetailInfo> v0(int i2) {
        final Flow<OrderDetailInfo> a2 = ((e.l.n.c.l) e.l.n.a.d(e.l.n.c.l.class, true, false, false, 60L, true)).a(i2);
        return e.g.d.a.h(e.g.d.a.j(FlowKt.a(new Flow<OrderDetailInfo>() { // from class: com.jihuanshe.viewmodel.order.OrderDetailViewModel$getDetail$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.order.OrderDetailViewModel$getDetail$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements f<OrderDetailInfo> {
                public final /* synthetic */ f a;
                public final /* synthetic */ OrderDetailViewModel$getDetail$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.order.OrderDetailViewModel$getDetail$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(f fVar, OrderDetailViewModel$getDetail$$inlined$map$1 orderDetailViewModel$getDetail$$inlined$map$1) {
                    this.a = fVar;
                    this.b = orderDetailViewModel$getDetail$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(com.jihuanshe.model.OrderDetailInfo r8, @k.e.a.d h.e2.c r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof com.jihuanshe.viewmodel.order.OrderDetailViewModel$getDetail$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r9
                        com.jihuanshe.viewmodel.order.OrderDetailViewModel$getDetail$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.order.OrderDetailViewModel$getDetail$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.order.OrderDetailViewModel$getDetail$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.order.OrderDetailViewModel$getDetail$$inlined$map$1$2$1
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r9)
                        goto L68
                    L29:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L31:
                        h.r0.n(r9)
                        i.b.v3.f r9 = r7.a
                        com.jihuanshe.model.OrderDetailInfo r8 = (com.jihuanshe.model.OrderDetailInfo) r8
                        java.util.List r2 = r8.getGoods()
                        if (r2 != 0) goto L3f
                        goto L5f
                    L3f:
                        java.util.Iterator r2 = r2.iterator()
                    L43:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto L5f
                        java.lang.Object r4 = r2.next()
                        com.jihuanshe.model.CardProduct r4 = (com.jihuanshe.model.CardProduct) r4
                        java.lang.String r5 = r4.getGameKey()
                        java.lang.String r6 = r4.getGameSubKey()
                        com.jihuanshe.model.Game r5 = e.l.l.a.b(r5, r6)
                        r4.setGame(r5)
                        goto L43
                    L5f:
                        r0.label = r3
                        java.lang.Object r8 = r9.emit(r8, r0)
                        if (r8 != r1) goto L68
                        return r1
                    L68:
                        h.t1 r8 = h.t1.a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.order.OrderDetailViewModel$getDetail$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d f<? super OrderDetailInfo> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }, this.b), null, new OrderDetailViewModel$getDetail$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final e.g.d.a<List<ExpressData>> w0(int i2) {
        final Flow d2 = k.a.d((k) e.l.n.a.d(k.class, true, false, false, 60L, true), Integer.valueOf(i2), null, null, null, 14, null);
        return e.g.d.a.h(FlowKt.a(new Flow<List<? extends ExpressData>>() { // from class: com.jihuanshe.viewmodel.order.OrderDetailViewModel$getExpressData$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.order.OrderDetailViewModel$getExpressData$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements f<Trace> {
                public final /* synthetic */ f a;
                public final /* synthetic */ OrderDetailViewModel$getExpressData$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.order.OrderDetailViewModel$getExpressData$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(f fVar, OrderDetailViewModel$getExpressData$$inlined$map$1 orderDetailViewModel$getExpressData$$inlined$map$1) {
                    this.a = fVar;
                    this.b = orderDetailViewModel$getExpressData$$inlined$map$1;
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
                        boolean r0 = r8 instanceof com.jihuanshe.viewmodel.order.OrderDetailViewModel$getExpressData$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.jihuanshe.viewmodel.order.OrderDetailViewModel$getExpressData$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.order.OrderDetailViewModel$getExpressData$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.order.OrderDetailViewModel$getExpressData$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.order.OrderDetailViewModel$getExpressData$$inlined$map$1$2$1
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
                        com.jihuanshe.viewmodel.order.OrderDetailViewModel$getExpressData$$inlined$map$1 r2 = r6.b
                        com.jihuanshe.viewmodel.order.OrderDetailViewModel r2 = r2
                        e.n.i r2 = r2.C0()
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
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.order.OrderDetailViewModel$getExpressData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d f<? super List<? extends ExpressData>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }, this.f4488d), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<ExpressData>> x0() {
        return this.f4488d;
    }

    @d
    public final NLive<OrderDetailInfo> y0() {
        return this.b;
    }

    @d
    public final p z0() {
        return this.f4489e;
    }
}
