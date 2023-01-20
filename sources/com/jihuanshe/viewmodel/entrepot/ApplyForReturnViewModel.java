package com.jihuanshe.viewmodel.entrepot;

import androidx.core.app.FrameMetricsAggregator;
import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.ReturnCardInfo;
import com.jihuanshe.model.ReturnOrderResult;
import com.jihuanshe.model.UserAddress;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.k;
import e.n.l;
import e.t.j.h.g;
import h.e2.c;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class ApplyForReturnViewModel extends b {
    @d
    private final l b = new l(0);
    @d

    /* renamed from: c */
    private final l f4408c = new l(1);
    @d

    /* renamed from: d */
    private final NLive<List<ReturnCardInfo>> f4409d = new NLive<>(null, 1, null);
    @d

    /* renamed from: e */
    private final l f4410e = new l(0);
    @d

    /* renamed from: f */
    private final f f4411f = new f();
    @d

    /* renamed from: g */
    private final NLive<List<UserAddress>> f4412g = new NLive<>(null, 1, null);
    @d

    /* renamed from: h */
    private final e.n.f<UserAddress> f4413h = new e.n.f<>(null);

    private final String C0() {
        Integer value;
        Integer value2 = this.f4408c.getValue();
        return ((value2 != null && value2.intValue() == 2) || ((value = this.b.getValue()) != null && value.intValue() == 1)) ? "fail" : "pass";
    }

    public static /* synthetic */ a G0(ApplyForReturnViewModel applyForReturnViewModel, Integer num, Integer num2, String str, Integer num3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = null;
        }
        if ((i2 & 2) != 0) {
            num2 = null;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        if ((i2 & 8) != 0) {
            num3 = 1;
        }
        return applyForReturnViewModel.F0(num, num2, str, num3);
    }

    public static /* synthetic */ a u0(ApplyForReturnViewModel applyForReturnViewModel, LoadMore.State state, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            state = null;
        }
        return applyForReturnViewModel.t0(state);
    }

    public static /* synthetic */ a w0(ApplyForReturnViewModel applyForReturnViewModel, LoadMore.State state, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            state = null;
        }
        return applyForReturnViewModel.v0(state);
    }

    @d
    public final l A0() {
        return this.b;
    }

    @d
    public final f B0() {
        return this.f4411f;
    }

    @d
    public final l D0() {
        return this.f4408c;
    }

    @d
    public final l E0() {
        return this.f4410e;
    }

    @d
    public final a<ReturnOrderResult> F0(@e Integer num, @e Integer num2, @e String str, @e Integer num3) {
        k kVar = (k) e.l.n.a.d(k.class, true, false, false, 60L, true);
        UserAddress value = this.f4413h.getValue();
        return a.h(FlowKt.c(k.a.s(kVar, (value == null ? null : Integer.valueOf(value.getId())).intValue(), num, num2, str, num3, null, null, 96, null)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final g p0(int i2) {
        return e.t.j.h.d.a.a(new ApplyForReturnViewModel$chooseMode$1(this, i2));
    }

    @d
    public final g q0(int i2) {
        return e.t.j.h.d.a.a(new ApplyForReturnViewModel$chooseTabTag$1(this, i2));
    }

    @d
    public final a<List<UserAddress>> r0() {
        final Flow<List<UserAddress>> R = ((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).R(null);
        return a.h(a.j(FlowKt.c(new Flow<List<? extends UserAddress>>() { // from class: com.jihuanshe.viewmodel.entrepot.ApplyForReturnViewModel$getAddress$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.entrepot.ApplyForReturnViewModel$getAddress$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<List<? extends UserAddress>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ ApplyForReturnViewModel$getAddress$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.entrepot.ApplyForReturnViewModel$getAddress$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(i.b.v3.f fVar, ApplyForReturnViewModel$getAddress$$inlined$map$1 applyForReturnViewModel$getAddress$$inlined$map$1) {
                    this.a = fVar;
                    this.b = applyForReturnViewModel$getAddress$$inlined$map$1;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                /* JADX WARN: Type inference failed for: r5v1 */
                /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object] */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(java.util.List<? extends com.jihuanshe.model.UserAddress> r8, @k.e.a.d h.e2.c r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof com.jihuanshe.viewmodel.entrepot.ApplyForReturnViewModel$getAddress$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r9
                        com.jihuanshe.viewmodel.entrepot.ApplyForReturnViewModel$getAddress$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.entrepot.ApplyForReturnViewModel$getAddress$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.entrepot.ApplyForReturnViewModel$getAddress$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.entrepot.ApplyForReturnViewModel$getAddress$$inlined$map$1$2$1
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r9)
                        goto L72
                    L29:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L31:
                        h.r0.n(r9)
                        i.b.v3.f r9 = r7.a
                        java.util.List r8 = (java.util.List) r8
                        com.jihuanshe.viewmodel.entrepot.ApplyForReturnViewModel$getAddress$$inlined$map$1 r2 = r7.b
                        com.jihuanshe.viewmodel.entrepot.ApplyForReturnViewModel r2 = r2
                        e.n.f r2 = r2.y0()
                        java.util.Iterator r4 = r8.iterator()
                    L44:
                        boolean r5 = r4.hasNext()
                        if (r5 == 0) goto L65
                        java.lang.Object r5 = r4.next()
                        r6 = r5
                        com.jihuanshe.model.UserAddress r6 = (com.jihuanshe.model.UserAddress) r6
                        int r6 = r6.isDefault()
                        if (r6 != r3) goto L59
                        r6 = 1
                        goto L5a
                    L59:
                        r6 = 0
                    L5a:
                        java.lang.Boolean r6 = h.e2.k.a.a.a(r6)
                        boolean r6 = r6.booleanValue()
                        if (r6 == 0) goto L44
                        goto L66
                    L65:
                        r5 = 0
                    L66:
                        r2.setValue(r5)
                        r0.label = r3
                        java.lang.Object r8 = r9.emit(r8, r0)
                        if (r8 != r1) goto L72
                        return r1
                    L72:
                        h.t1 r8 = h.t1.a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.entrepot.ApplyForReturnViewModel$getAddress$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super List<? extends UserAddress>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), null, new ApplyForReturnViewModel$getAddress$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<UserAddress>> s0() {
        return this.f4412g;
    }

    @d
    public final a<e.l.h.i.e<ReturnCardInfo>> t0(@e LoadMore.State state) {
        return a.h(a.o(BinderKt.b(FlowKt.c(k.a.b((k) e.l.n.a.d(k.class, true, false, false, 60L, true), this.f4411f.a(state).d(), null, null, 6, null)), this.f4409d, this.f4411f.f()), null, new ApplyForReturnViewModel$getAllProducts$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<e.l.h.i.e<ReturnCardInfo>> v0(@e LoadMore.State state) {
        return a.h(a.o(BinderKt.b(FlowKt.c(k.a.c((k) e.l.n.a.d(k.class, true, false, false, 60L, true), C0(), this.f4411f.a(state).d(), null, null, 12, null)), this.f4409d, this.f4411f.f()), null, new ApplyForReturnViewModel$getAvailableReturnProducts$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<ReturnCardInfo>> x0() {
        return this.f4409d;
    }

    @d
    public final e.n.f<UserAddress> y0() {
        return this.f4413h;
    }

    @d
    public final UserAddress z0() {
        if (this.f4412g.getValue() != null && (!this.f4412g.getValue().isEmpty())) {
            return this.f4412g.getValue().get(0);
        }
        UserAddress userAddress = new UserAddress(0, null, null, null, null, null, null, null, 0, FrameMetricsAggregator.EVERY_DURATION, null);
        userAddress.setName("");
        userAddress.setPhone("");
        userAddress.setAddress("");
        userAddress.setProvince("");
        userAddress.setCity("");
        userAddress.setDistrict("");
        userAddress.setAddress("");
        userAddress.setPostCode("");
        return userAddress;
    }
}
