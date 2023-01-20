package com.jihuanshe.viewmodel.entrepot;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.OrderReturnDetail;
import com.jihuanshe.model.OrderReturnInfo;
import com.jihuanshe.model.PayParams;
import com.jihuanshe.viewmodel.UploadViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.e;
import e.l.h.i.f;
import e.l.n.c.k;
import e.n.l;
import h.e2.c;
import h.e2.j.b;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class SubmitOrderReturnViewModel extends UploadViewModel {
    @d

    /* renamed from: d  reason: collision with root package name */
    private final f f4443d = new f();
    @d

    /* renamed from: e  reason: collision with root package name */
    private final NLive<OrderReturnDetail> f4444e = new NLive<>(null, 1, null);
    @d

    /* renamed from: f  reason: collision with root package name */
    private final NLive<List<OrderReturnInfo>> f4445f = new NLive<>(null, 1, null);
    @d

    /* renamed from: g  reason: collision with root package name */
    private final l f4446g = new l(0);

    public static /* synthetic */ a E0(SubmitOrderReturnViewModel submitOrderReturnViewModel, int i2, LoadMore.State state, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            state = null;
        }
        return submitOrderReturnViewModel.D0(i2, state);
    }

    @d
    public final NLive<List<OrderReturnInfo>> A0() {
        return this.f4445f;
    }

    @d
    public final NLive<OrderReturnDetail> B0() {
        return this.f4444e;
    }

    @d
    public final l C0() {
        return this.f4446g;
    }

    @d
    public final a<e<OrderReturnInfo>> D0(int i2, @k.e.a.e LoadMore.State state) {
        final Flow f2 = k.a.f((k) e.l.n.a.d(k.class, false, false, false, 60L, true), i2, this.f4443d.a(state).d(), null, null, 12, null);
        return a.h(a.o(BinderKt.b(FlowKt.c(new Flow<e<OrderReturnInfo>>() { // from class: com.jihuanshe.viewmodel.entrepot.SubmitOrderReturnViewModel$getOrderProducts$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.entrepot.SubmitOrderReturnViewModel$getOrderProducts$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<Result<e<OrderReturnInfo>>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ SubmitOrderReturnViewModel$getOrderProducts$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.entrepot.SubmitOrderReturnViewModel$getOrderProducts$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(i.b.v3.f fVar, SubmitOrderReturnViewModel$getOrderProducts$$inlined$map$1 submitOrderReturnViewModel$getOrderProducts$$inlined$map$1) {
                    this.a = fVar;
                    this.b = submitOrderReturnViewModel$getOrderProducts$$inlined$map$1;
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
                        boolean r0 = r9 instanceof com.jihuanshe.viewmodel.entrepot.SubmitOrderReturnViewModel$getOrderProducts$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r9
                        com.jihuanshe.viewmodel.entrepot.SubmitOrderReturnViewModel$getOrderProducts$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.entrepot.SubmitOrderReturnViewModel$getOrderProducts$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.entrepot.SubmitOrderReturnViewModel$getOrderProducts$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.entrepot.SubmitOrderReturnViewModel$getOrderProducts$$inlined$map$1$2$1
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
                        com.jihuanshe.viewmodel.entrepot.SubmitOrderReturnViewModel$getOrderProducts$$inlined$map$1 r2 = r7.b     // Catch: java.lang.Throwable -> L64
                        com.jihuanshe.viewmodel.entrepot.SubmitOrderReturnViewModel r2 = r2     // Catch: java.lang.Throwable -> L64
                        e.n.l r2 = r2.C0()     // Catch: java.lang.Throwable -> L64
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
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.entrepot.SubmitOrderReturnViewModel$getOrderProducts$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @k.e.a.e
            public Object e(@d i.b.v3.f<? super e<OrderReturnInfo>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == b.h() ? e2 : t1.a;
            }
        }), this.f4445f, this.f4443d.f()), null, new SubmitOrderReturnViewModel$getOrderProducts$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<OrderReturnDetail> F0(int i2) {
        return a.h(FlowKt.a(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).h0(i2), this.f4444e), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<PayParams> G0(int i2) {
        return a.h(a.j(FlowKt.c(k.a.n((k) e.l.n.a.d(k.class, true, false, false, 60L, true), i2, null, 2, null)), null, SubmitOrderReturnViewModel$payOrder$1.INSTANCE, 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
