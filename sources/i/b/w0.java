package i.b;

import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0001\u001a\u00020\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001b\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0087@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0016\u0010\f\u001a\u00020\u0003*\u00020\bH\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\"\u001a\u0010\u0012\u001a\u00020\u000f*\u00020\u000e8@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"", am.av, "(Lh/e2/c;)Ljava/lang/Object;", "", "timeMillis", "Lh/t1;", "b", "(JLh/e2/c;)Ljava/lang/Object;", "Lh/u2/d;", "duration", "c", "(DLh/e2/c;)Ljava/lang/Object;", com.huawei.hms.push.e.a, "(D)J", "Lkotlin/coroutines/CoroutineContext;", "Li/b/v0;", e.j.a.b.c.f.f10128d, "(Lkotlin/coroutines/CoroutineContext;)Li/b/v0;", "delay", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class w0 {
    @k.e.a.e
    public static final Object a(@k.e.a.d h.e2.c<?> cVar) {
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        oVar.G();
        Object B = oVar.B();
        if (B == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return B;
    }

    @k.e.a.e
    public static final Object b(long j2, @k.e.a.d h.e2.c<? super h.t1> cVar) {
        if (j2 <= 0) {
            return h.t1.a;
        }
        o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        oVar.G();
        if (j2 < Long.MAX_VALUE) {
            d(oVar.getContext()).c(j2, oVar);
        }
        Object B = oVar.B();
        if (B == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return B;
    }

    @h.u2.j
    @k.e.a.e
    public static final Object c(double d2, @k.e.a.d h.e2.c<? super h.t1> cVar) {
        Object b = b(e(d2), cVar);
        return b == h.e2.j.b.h() ? b : h.t1.a;
    }

    @k.e.a.d
    public static final v0 d(@k.e.a.d CoroutineContext coroutineContext) {
        CoroutineContext.a aVar = coroutineContext.get(h.e2.d.v0);
        if (!(aVar instanceof v0)) {
            aVar = null;
        }
        v0 v0Var = (v0) aVar;
        return v0Var != null ? v0Var : t0.a();
    }

    @h.u2.j
    public static final long e(double d2) {
        if (h.u2.d.compareTo-LRDsOJo(d2, h.u2.d.f15705e.getZERO-UwyO8pc()) > 0) {
            return h.o2.q.o(h.u2.d.toLongMilliseconds-impl(d2), 1L);
        }
        return 0L;
    }
}
