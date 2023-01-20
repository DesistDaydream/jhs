package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.j0;
import h.k2.g;
import h.k2.u.l;
import h.t1;
import h.u2.j;
import i.b.n0;
import i.b.s1;
import i.b.t3.y;
import i.b.v3.h;
import i.b.w0;
import k.e.a.d;
import kotlin.Metadata;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a-\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a9\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a0\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\n\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a<\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\b\u001a9\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\b\u001a-\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0010\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0011\u0010\u0005\u001a+\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a0\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0019\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "", "timeoutMillis", am.av, "(Lkotlinx/coroutines/flow/Flow;J)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function1;", "b", "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/l;)Lkotlinx/coroutines/flow/Flow;", "Lh/u2/d;", "timeout", "c", "(Lkotlinx/coroutines/flow/Flow;D)Lkotlinx/coroutines/flow/Flow;", f.f10128d, "timeoutMillisSelector", e.a, "periodMillis", "h", "Li/b/n0;", "delayMillis", "initialDelayMillis", "Li/b/t3/y;", "Lh/t1;", "f", "(Li/b/n0;JJ)Li/b/t3/y;", "period", "i", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__DelayKt {
    /* JADX WARN: Multi-variable type inference failed */
    @s1
    @d
    public static final <T> Flow<T> a(@d Flow<? extends T> flow, long j2) {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 >= 0) {
            return i2 == 0 ? flow : e(flow, new FlowKt__DelayKt$debounce$2(j2));
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    }

    @s1
    @j0
    @d
    public static final <T> Flow<T> b(@d Flow<? extends T> flow, @d l<? super T, Long> lVar) {
        return e(flow, lVar);
    }

    @j
    @s1
    @d
    public static final <T> Flow<T> c(@d Flow<? extends T> flow, double d2) {
        return h.f0(flow, w0.e(d2));
    }

    @g(name = "debounceDuration")
    @s1
    @j0
    @j
    @d
    public static final <T> Flow<T> d(@d Flow<? extends T> flow, @d l<? super T, h.u2.d> lVar) {
        return e(flow, new FlowKt__DelayKt$debounce$3(lVar));
    }

    private static final <T> Flow<T> e(Flow<? extends T> flow, l<? super T, Long> lVar) {
        return FlowCoroutineKt.d(new FlowKt__DelayKt$debounceInternal$1(flow, lVar, null));
    }

    @d
    public static final y<t1> f(@d n0 n0Var, long j2, long j3) {
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j2 + " ms").toString());
        }
        if (j3 >= 0) {
            return ProduceKt.f(n0Var, null, 0, new FlowKt__DelayKt$fixedPeriodTicker$3(j3, j2, null), 1, null);
        }
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j3 + " ms").toString());
    }

    public static /* synthetic */ y g(n0 n0Var, long j2, long j3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j3 = j2;
        }
        return h.C0(n0Var, j2, j3);
    }

    @s1
    @d
    public static final <T> Flow<T> h(@d Flow<? extends T> flow, long j2) {
        if (j2 > 0) {
            return FlowCoroutineKt.d(new FlowKt__DelayKt$sample$2(flow, j2, null));
        }
        throw new IllegalArgumentException("Sample period should be positive".toString());
    }

    @j
    @s1
    @d
    public static final <T> Flow<T> i(@d Flow<? extends T> flow, double d2) {
        return h.L1(flow, w0.e(d2));
    }
}
