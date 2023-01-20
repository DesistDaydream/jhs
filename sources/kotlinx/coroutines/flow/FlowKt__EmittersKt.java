package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.b;
import h.e2.c;
import h.k2.u.p;
import h.k2.u.q;
import h.p0;
import h.t1;
import i.b.v3.h;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\u001au\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022D\b\u0005\u0010\f\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0003¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001au\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022D\b\u0005\u0010\f\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0003¢\u0006\u0002\b\u000bH\u0081\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u000e\u001aU\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022-\u0010\u0011\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0010¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001al\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022D\u0010\u0011\u001a@\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0003¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u000e\u001aU\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022-\u0010\u0011\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0010¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0013\u001as\u0010\u0018\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042D\u0010\u0011\u001a@\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0003¢\u0006\u0002\b\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Li/b/v3/f;", "Lh/k0;", "name", "value", "Lh/e2/c;", "Lh/t1;", "", "Lh/q;", "transform", e.a, "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/q;)Lkotlinx/coroutines/flow/Flow;", "f", "Lkotlin/Function2;", "action", f.f10128d, "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/p;)Lkotlinx/coroutines/flow/Flow;", "", "cause", "b", "c", am.av, "(Li/b/v3/f;Lh/k2/u/q;Ljava/lang/Throwable;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__EmittersKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ <T> java.lang.Object a(@k.e.a.d i.b.v3.f<? super T> r4, @k.e.a.d h.k2.u.q<? super i.b.v3.f<? super T>, ? super java.lang.Throwable, ? super h.e2.c<? super h.t1>, ? extends java.lang.Object> r5, @k.e.a.e java.lang.Throwable r6, @k.e.a.d h.e2.c<? super h.t1> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r4 = r0.L$2
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            java.lang.Object r4 = r0.L$1
            h.k2.u.q r4 = (h.k2.u.q) r4
            java.lang.Object r4 = r0.L$0
            i.b.v3.f r4 = (i.b.v3.f) r4
            h.r0.n(r7)     // Catch: java.lang.Throwable -> L53
            goto L50
        L36:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3e:
            h.r0.n(r7)
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L53
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L53
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L53
            r0.label = r3     // Catch: java.lang.Throwable -> L53
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch: java.lang.Throwable -> L53
            if (r4 != r1) goto L50
            return r1
        L50:
            h.t1 r4 = h.t1.a
            return r4
        L53:
            r4 = move-exception
            if (r6 == 0) goto L5b
            if (r6 == r4) goto L5b
            h.m.a(r4, r6)
        L5b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt.a(i.b.v3.f, h.k2.u.q, java.lang.Throwable, h.e2.c):java.lang.Object");
    }

    @d
    public static final <T> Flow<T> b(@d Flow<? extends T> flow, @d q<? super i.b.v3.f<? super T>, ? super Throwable, ? super c<? super t1>, ? extends Object> qVar) {
        return new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(flow, qVar);
    }

    @d
    public static final <T> Flow<T> c(@d Flow<? extends T> flow, @d p<? super i.b.v3.f<? super T>, ? super c<? super t1>, ? extends Object> pVar) {
        return new FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1(flow, pVar);
    }

    @d
    public static final <T> Flow<T> d(@d Flow<? extends T> flow, @d p<? super i.b.v3.f<? super T>, ? super c<? super t1>, ? extends Object> pVar) {
        return new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(flow, pVar);
    }

    @d
    public static final <T, R> Flow<R> e(@d Flow<? extends T> flow, @b @d q<? super i.b.v3.f<? super R>, ? super T, ? super c<? super t1>, ? extends Object> qVar) {
        return h.N0(new FlowKt__EmittersKt$transform$1(flow, qVar, null));
    }

    @p0
    @d
    public static final <T, R> Flow<R> f(@d Flow<? extends T> flow, @b @d q<? super i.b.v3.f<? super R>, ? super T, ? super c<? super t1>, ? extends Object> qVar) {
        return new FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1(flow, qVar);
    }
}
