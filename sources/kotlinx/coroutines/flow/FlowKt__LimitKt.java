package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.p;
import h.k2.u.q;
import h.k2.v.c0;
import h.t1;
import i.b.r1;
import i.b.v3.c0.i;
import i.b.v3.h;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a+\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001aJ\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a+\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0005\u001a+\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001aJ\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\f\u001at\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0014*\b\u0012\u0004\u0012\u00028\u00000\u00012D\b\u0001\u0010\u0019\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0015¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aX\u0010\u001c\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000123\b\u0004\u0010\n\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0080Hø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "", "count", "c", "(Lkotlinx/coroutines/flow/Flow;I)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "Lh/e2/c;", "", "", "predicate", f.f10128d, "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/p;)Lkotlinx/coroutines/flow/Flow;", "f", "Li/b/v3/f;", "value", "Lh/t1;", e.a, "(Li/b/v3/f;Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "g", "R", "Lkotlin/Function3;", "Lh/k0;", "name", "Lh/q;", "transform", "h", "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/q;)Lkotlinx/coroutines/flow/Flow;", am.av, "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/p;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__LimitKt {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$a", "Lkotlinx/coroutines/flow/Flow;", "Li/b/v3/f;", "collector", "Lh/t1;", e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements Flow<T> {
        public final /* synthetic */ Flow a;
        public final /* synthetic */ int b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$a$a", "Li/b/v3/f;", "value", "Lh/t1;", "emit", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__LimitKt$$special$$inlined$collect$1"}, k = 1, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C0500a implements i.b.v3.f<T> {
            public final /* synthetic */ i.b.v3.f a;
            public final /* synthetic */ Ref.IntRef b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f16952c;

            public C0500a(i.b.v3.f fVar, Ref.IntRef intRef, a aVar) {
                this.a = fVar;
                this.b = intRef;
                this.f16952c = aVar;
            }

            @Override // i.b.v3.f
            @k.e.a.e
            public Object emit(Object obj, @d c cVar) {
                Ref.IntRef intRef = this.b;
                int i2 = intRef.element;
                if (i2 >= this.f16952c.b) {
                    Object emit = this.a.emit(obj, cVar);
                    if (emit == b.h()) {
                        return emit;
                    }
                } else {
                    intRef.element = i2 + 1;
                }
                return t1.a;
            }
        }

        public a(Flow flow, int i2) {
            this.a = flow;
            this.b = i2;
        }

        @Override // kotlinx.coroutines.flow.Flow
        @k.e.a.e
        public Object e(@d i.b.v3.f fVar, @d c cVar) {
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 0;
            Object e2 = this.a.e(new C0500a(fVar, intRef, this), cVar);
            return e2 == b.h() ? e2 : t1.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object a(@k.e.a.d kotlinx.coroutines.flow.Flow<? extends T> r4, @k.e.a.d h.k2.u.p<? super T, ? super h.e2.c<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @k.e.a.d h.e2.c<? super h.t1> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r4 = r0.L$2
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1 r4 = (kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1) r4
            java.lang.Object r5 = r0.L$1
            h.k2.u.p r5 = (h.k2.u.p) r5
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.Flow r5 = (kotlinx.coroutines.flow.Flow) r5
            h.r0.n(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L35
            goto L5b
        L35:
            r5 = move-exception
            goto L58
        L37:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3f:
            h.r0.n(r6)
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1 r6 = new kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1
            r6.<init>(r5)
            r0.L$0 = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L56
            r0.L$1 = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L56
            r0.L$2 = r6     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L56
            r0.label = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L56
            java.lang.Object r4 = r4.e(r6, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L56
            if (r4 != r1) goto L5b
            return r1
        L56:
            r5 = move-exception
            r4 = r6
        L58:
            i.b.v3.c0.i.b(r5, r4)
        L5b:
            h.t1 r4 = h.t1.a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt.a(kotlinx.coroutines.flow.Flow, h.k2.u.p, h.e2.c):java.lang.Object");
    }

    @k.e.a.e
    private static final Object b(@d Flow flow, @d p pVar, @d c cVar) {
        FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$1 = new FlowKt__LimitKt$collectWhile$collector$1(pVar);
        try {
            c0.e(0);
            flow.e(flowKt__LimitKt$collectWhile$collector$1, cVar);
            c0.e(2);
            c0.e(1);
        } catch (AbortFlowException e2) {
            i.b(e2, flowKt__LimitKt$collectWhile$collector$1);
        }
        return t1.a;
    }

    @d
    public static final <T> Flow<T> c(@d Flow<? extends T> flow, int i2) {
        if (i2 >= 0) {
            return new a(flow, i2);
        }
        throw new IllegalArgumentException(("Drop count should be non-negative, but had " + i2).toString());
    }

    @d
    public static final <T> Flow<T> d(@d Flow<? extends T> flow, @d p<? super T, ? super c<? super Boolean>, ? extends Object> pVar) {
        return new FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1(flow, pVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ <T> java.lang.Object e(@k.e.a.d i.b.v3.f<? super T> r4, T r5, @k.e.a.d h.e2.c<? super h.t1> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$emitAbort$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2d:
            java.lang.Object r4 = r0.L$1
            java.lang.Object r4 = r0.L$0
            i.b.v3.f r4 = (i.b.v3.f) r4
            h.r0.n(r6)
            goto L47
        L37:
            h.r0.n(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r5 = r4.emit(r5, r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            kotlinx.coroutines.flow.internal.AbortFlowException r5 = new kotlinx.coroutines.flow.internal.AbortFlowException
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt.e(i.b.v3.f, java.lang.Object, h.e2.c):java.lang.Object");
    }

    @d
    public static final <T> Flow<T> f(@d Flow<? extends T> flow, int i2) {
        if (i2 > 0) {
            return new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(flow, i2);
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " should be positive").toString());
    }

    @d
    public static final <T> Flow<T> g(@d Flow<? extends T> flow, @d p<? super T, ? super c<? super Boolean>, ? extends Object> pVar) {
        return new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1(flow, pVar);
    }

    @r1
    @d
    public static final <T, R> Flow<R> h(@d Flow<? extends T> flow, @h.b @d q<? super i.b.v3.f<? super R>, ? super T, ? super c<? super Boolean>, ? extends Object> qVar) {
        return h.N0(new FlowKt__LimitKt$transformWhile$1(flow, qVar, null));
    }
}
