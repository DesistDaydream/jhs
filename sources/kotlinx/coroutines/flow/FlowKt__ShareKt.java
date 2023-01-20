package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.e2.c;
import h.t1;
import i.b.i;
import i.b.n0;
import i.b.v3.a0;
import i.b.v3.h;
import i.b.v3.k;
import i.b.v3.l;
import i.b.v3.m;
import i.b.v3.n;
import i.b.v3.p;
import i.b.v3.r;
import i.b.v3.t;
import i.b.v3.u;
import i.b.v3.x;
import i.b.y;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n\u001a-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\r\u001aM\u0010\u0015\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0000*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a;\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a1\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aC\u0010\u001e\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0000*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a#\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b \u0010!\u001a#\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\"¢\u0006\u0004\b#\u0010$\u001aU\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2-\u0010*\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140'\u0012\u0006\u0012\u0004\u0018\u00010(0%¢\u0006\u0002\b)ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "Li/b/n0;", "scope", "Li/b/v3/u;", "started", "", "replay", "Li/b/v3/p;", "g", "(Lkotlinx/coroutines/flow/Flow;Li/b/n0;Li/b/v3/u;I)Li/b/v3/p;", "Li/b/v3/t;", "c", "(Lkotlinx/coroutines/flow/Flow;I)Li/b/v3/t;", "Lkotlin/coroutines/CoroutineContext;", "context", "upstream", "Li/b/v3/k;", "shared", "initialValue", "Lh/t1;", f.f10128d, "(Li/b/n0;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/Flow;Li/b/v3/k;Li/b/v3/u;Ljava/lang/Object;)V", "Li/b/v3/x;", "j", "(Lkotlinx/coroutines/flow/Flow;Li/b/n0;Li/b/v3/u;Ljava/lang/Object;)Li/b/v3/x;", "i", "(Lkotlinx/coroutines/flow/Flow;Li/b/n0;Lh/e2/c;)Ljava/lang/Object;", "Li/b/x;", "result", e.a, "(Li/b/n0;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/Flow;Li/b/x;)V", am.av, "(Li/b/v3/k;)Li/b/v3/p;", "Li/b/v3/l;", "b", "(Li/b/v3/l;)Li/b/v3/x;", "Lkotlin/Function2;", "Li/b/v3/f;", "Lh/e2/c;", "", "Lh/q;", "action", "f", "(Li/b/v3/p;Lh/k2/u/p;)Li/b/v3/p;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__ShareKt {
    @d
    public static final <T> p<T> a(@d k<T> kVar) {
        return new m(kVar);
    }

    @d
    public static final <T> x<T> b(@d l<T> lVar) {
        return new n(lVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0047, code lost:
        if (r9 == 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final <T> i.b.v3.t<T> c(kotlinx.coroutines.flow.Flow<? extends T> r8, int r9) {
        /*
            boolean r0 = i.b.q0.b()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L16
            if (r9 < 0) goto Lc
            r0 = 1
            goto Ld
        Lc:
            r0 = 0
        Ld:
            if (r0 == 0) goto L10
            goto L16
        L10:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            r8.<init>()
            throw r8
        L16:
            i.b.t3.l$b r0 = i.b.t3.l.z0
            int r0 = r0.a()
            int r0 = h.o2.q.n(r9, r0)
            int r0 = r0 - r9
            boolean r3 = r8 instanceof kotlinx.coroutines.flow.internal.ChannelFlow
            if (r3 == 0) goto L53
            r3 = r8
            kotlinx.coroutines.flow.internal.ChannelFlow r3 = (kotlinx.coroutines.flow.internal.ChannelFlow) r3
            kotlinx.coroutines.flow.Flow r4 = r3.m()
            if (r4 == 0) goto L53
            i.b.v3.t r8 = new i.b.v3.t
            int r5 = r3.b
            r6 = -3
            if (r5 == r6) goto L3c
            r6 = -2
            if (r5 == r6) goto L3c
            if (r5 == 0) goto L3c
            r1 = r5
            goto L4b
        L3c:
            kotlinx.coroutines.channels.BufferOverflow r6 = r3.f16970c
            kotlinx.coroutines.channels.BufferOverflow r7 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            if (r6 != r7) goto L47
            if (r5 != 0) goto L45
            goto L4a
        L45:
            r1 = r0
            goto L4b
        L47:
            if (r9 != 0) goto L4a
            goto L4b
        L4a:
            r1 = 0
        L4b:
            kotlinx.coroutines.channels.BufferOverflow r9 = r3.f16970c
            kotlin.coroutines.CoroutineContext r0 = r3.a
            r8.<init>(r4, r1, r9, r0)
            return r8
        L53:
            i.b.v3.t r9 = new i.b.v3.t
            kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r9.<init>(r8, r0, r1, r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt.c(kotlinx.coroutines.flow.Flow, int):i.b.v3.t");
    }

    private static final <T> void d(n0 n0Var, CoroutineContext coroutineContext, Flow<? extends T> flow, k<T> kVar, u uVar, T t) {
        i.f(n0Var, coroutineContext, null, new FlowKt__ShareKt$launchSharing$1(uVar, flow, kVar, t, null), 2, null);
    }

    private static final <T> void e(n0 n0Var, CoroutineContext coroutineContext, Flow<? extends T> flow, i.b.x<x<T>> xVar) {
        i.f(n0Var, coroutineContext, null, new FlowKt__ShareKt$launchSharingDeferred$1(flow, xVar, null), 2, null);
    }

    @d
    public static final <T> p<T> f(@d p<? extends T> pVar, @d h.k2.u.p<? super i.b.v3.f<? super T>, ? super c<? super t1>, ? extends Object> pVar2) {
        return new a0(pVar, pVar2);
    }

    @d
    public static final <T> p<T> g(@d Flow<? extends T> flow, @d n0 n0Var, @d u uVar, int i2) {
        t c2 = c(flow, i2);
        k a = r.a(i2, c2.b, c2.f15870c);
        d(n0Var, c2.f15871d, c2.a, a, uVar, r.a);
        return h.l(a);
    }

    public static /* synthetic */ p h(Flow flow, n0 n0Var, u uVar, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return h.Q1(flow, n0Var, uVar, i2);
    }

    @k.e.a.e
    public static final <T> Object i(@d Flow<? extends T> flow, @d n0 n0Var, @d c<? super x<? extends T>> cVar) {
        t c2 = c(flow, 1);
        i.b.x c3 = y.c(null, 1, null);
        e(n0Var, c2.f15871d, c2.a, c3);
        return c3.r(cVar);
    }

    @d
    public static final <T> x<T> j(@d Flow<? extends T> flow, @d n0 n0Var, @d u uVar, T t) {
        t c2 = c(flow, 1);
        l a = i.b.v3.y.a(t);
        d(n0Var, c2.f15871d, c2.a, a, uVar, t);
        return h.m(a);
    }
}
