package i.b;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import h.e2.d;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DeferredCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u001aQ\u0010\f\u001a\u00020\u000b*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a]\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u000e*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001aW\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u0002\u001a\u00020\u00012'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0086@ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001aH\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e*\u00020\u00142)\b\b\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0086Jø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\"\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019\"\u0016\u0010\u001b\u001a\u00020\u00178\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0019\"\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Li/b/n0;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/CoroutineStart;", MessageKey.MSG_ACCEPT_TIME_START, "Lkotlin/Function2;", "Lh/e2/c;", "Lh/t1;", "", "Lh/q;", ReportItem.LogTypeBlock, "Li/b/b2;", com.huawei.hms.push.e.a, "(Li/b/n0;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lh/k2/u/p;)Li/b/b2;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/u0;", am.av, "(Li/b/n0;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lh/k2/u/p;)Li/b/u0;", "g", "(Lkotlin/coroutines/CoroutineContext;Lh/k2/u/p;Lh/e2/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineDispatcher;", "c", "(Lkotlinx/coroutines/CoroutineDispatcher;Lh/k2/u/p;Lh/e2/c;)Ljava/lang/Object;", "", "b", ExpandableTextView.P, i.b.u3.b.c.f15858c, "RESUMED", "UNDECIDED", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/BuildersKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class i {
    private static final int a = 0;
    private static final int b = 1;

    /* renamed from: c */
    private static final int f15740c = 2;

    @k.e.a.d
    public static final <T> u0<T> a(@k.e.a.d n0 n0Var, @k.e.a.d CoroutineContext coroutineContext, @k.e.a.d CoroutineStart coroutineStart, @k.e.a.d h.k2.u.p<? super n0, ? super h.e2.c<? super T>, ? extends Object> pVar) {
        DeferredCoroutine deferredCoroutine;
        CoroutineContext d2 = i0.d(n0Var, coroutineContext);
        if (coroutineStart.isLazy()) {
            deferredCoroutine = new j2(d2, pVar);
        } else {
            deferredCoroutine = new DeferredCoroutine(d2, true);
        }
        ((a) deferredCoroutine).r1(coroutineStart, deferredCoroutine, pVar);
        return deferredCoroutine;
    }

    public static /* synthetic */ u0 b(n0 n0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, h.k2.u.p pVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return g.a(n0Var, coroutineContext, coroutineStart, pVar);
    }

    @k.e.a.e
    public static final <T> Object c(@k.e.a.d CoroutineDispatcher coroutineDispatcher, @k.e.a.d h.k2.u.p<? super n0, ? super h.e2.c<? super T>, ? extends Object> pVar, @k.e.a.d h.e2.c<? super T> cVar) {
        return g.i(coroutineDispatcher, pVar, cVar);
    }

    @k.e.a.e
    private static final Object d(@k.e.a.d CoroutineDispatcher coroutineDispatcher, @k.e.a.d h.k2.u.p pVar, @k.e.a.d h.e2.c cVar) {
        h.k2.v.c0.e(0);
        Object i2 = g.i(coroutineDispatcher, pVar, cVar);
        h.k2.v.c0.e(1);
        return i2;
    }

    @k.e.a.d
    public static final b2 e(@k.e.a.d n0 n0Var, @k.e.a.d CoroutineContext coroutineContext, @k.e.a.d CoroutineStart coroutineStart, @k.e.a.d h.k2.u.p<? super n0, ? super h.e2.c<? super h.t1>, ? extends Object> pVar) {
        a b3Var;
        CoroutineContext d2 = i0.d(n0Var, coroutineContext);
        if (coroutineStart.isLazy()) {
            b3Var = new k2(d2, pVar);
        } else {
            b3Var = new b3(d2, true);
        }
        b3Var.r1(coroutineStart, b3Var, pVar);
        return b3Var;
    }

    public static /* synthetic */ b2 f(n0 n0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, h.k2.u.p pVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return g.e(n0Var, coroutineContext, coroutineStart, pVar);
    }

    @k.e.a.e
    public static final <T> Object g(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d h.k2.u.p<? super n0, ? super h.e2.c<? super T>, ? extends Object> pVar, @k.e.a.d h.e2.c<? super T> cVar) {
        Object u1;
        CoroutineContext context = cVar.getContext();
        CoroutineContext plus = context.plus(coroutineContext);
        r3.a(plus);
        if (plus == context) {
            i.b.w3.e0 e0Var = new i.b.w3.e0(plus, cVar);
            u1 = i.b.x3.b.f(e0Var, e0Var, pVar);
        } else {
            d.b bVar = h.e2.d.v0;
            if (h.k2.v.f0.g((h.e2.d) plus.get(bVar), (h.e2.d) context.get(bVar))) {
                p3 p3Var = new p3(plus, cVar);
                Object c2 = ThreadContextKt.c(plus, null);
                try {
                    Object f2 = i.b.x3.b.f(p3Var, p3Var, pVar);
                    ThreadContextKt.a(plus, c2);
                    u1 = f2;
                } catch (Throwable th) {
                    ThreadContextKt.a(plus, c2);
                    throw th;
                }
            } else {
                x0 x0Var = new x0(plus, cVar);
                x0Var.n1();
                i.b.x3.a.e(pVar, x0Var, x0Var, null, 4, null);
                u1 = x0Var.u1();
            }
        }
        if (u1 == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return u1;
    }
}
