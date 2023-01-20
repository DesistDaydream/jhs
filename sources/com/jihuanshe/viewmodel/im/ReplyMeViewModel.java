package com.jihuanshe.viewmodel.im;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.InteractData;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.e;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.h;
import h.e2.c;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class ReplyMeViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final e.n.f<List<InteractData>> f4462c = new e.n.f<>(null, 1, null);

    public static /* synthetic */ a r0(ReplyMeViewModel replyMeViewModel, LoadMore.State state, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            state = null;
        }
        return replyMeViewModel.q0(state);
    }

    @d
    public final a<e<InteractData>> q0(@k.e.a.e LoadMore.State state) {
        final Flow<e<InteractData>> b = ((h) e.l.n.a.d(h.class, true, false, false, 60L, true)).b(this.b.a(state).d());
        return a.h(a.o(BinderKt.b(FlowKt.c(new Flow<e<InteractData>>() { // from class: com.jihuanshe.viewmodel.im.ReplyMeViewModel$fetchData$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.im.ReplyMeViewModel$fetchData$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<e<InteractData>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ ReplyMeViewModel$fetchData$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.im.ReplyMeViewModel$fetchData$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(i.b.v3.f fVar, ReplyMeViewModel$fetchData$$inlined$map$1 replyMeViewModel$fetchData$$inlined$map$1) {
                    this.a = fVar;
                    this.b = replyMeViewModel$fetchData$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(e.l.h.i.e<com.jihuanshe.model.InteractData> r8, @k.e.a.d h.e2.c r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof com.jihuanshe.viewmodel.im.ReplyMeViewModel$fetchData$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r9
                        com.jihuanshe.viewmodel.im.ReplyMeViewModel$fetchData$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.im.ReplyMeViewModel$fetchData$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.im.ReplyMeViewModel$fetchData$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.im.ReplyMeViewModel$fetchData$$inlined$map$1$2$1
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r9)
                        goto L71
                    L29:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L31:
                        h.r0.n(r9)
                        i.b.v3.f r9 = r7.a
                        e.l.h.i.e r8 = (e.l.h.i.e) r8
                        java.util.List r2 = r8.b()
                        if (r2 != 0) goto L3f
                        goto L68
                    L3f:
                        java.util.Iterator r2 = r2.iterator()
                    L43:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto L68
                        java.lang.Object r4 = r2.next()
                        com.jihuanshe.model.InteractData r4 = (com.jihuanshe.model.InteractData) r4
                        com.jihuanshe.utils.StringUtil r5 = com.jihuanshe.utils.StringUtil.a
                        java.lang.String r6 = r4.getContent()
                        java.lang.CharSequence r6 = r5.i(r6)
                        r4.setHandleContent(r6)
                        java.lang.String r6 = r4.getSourceContent()
                        java.lang.CharSequence r5 = r5.i(r6)
                        r4.setHandleSourceContent(r5)
                        goto L43
                    L68:
                        r0.label = r3
                        java.lang.Object r8 = r9.emit(r8, r0)
                        if (r8 != r1) goto L71
                        return r1
                    L71:
                        h.t1 r8 = h.t1.a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.im.ReplyMeViewModel$fetchData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @k.e.a.e
            public Object e(@d i.b.v3.f<? super e<InteractData>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), this.f4462c, this.b.f()), null, new ReplyMeViewModel$fetchData$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final e.n.f<List<InteractData>> s0() {
        return this.f4462c;
    }

    @d
    public final a<t1> t0(int i2) {
        return a.h(FlowKt.c(((h) e.l.n.a.d(h.class, true, false, false, 60L, true)).f(i2)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
