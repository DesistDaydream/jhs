package i.b;

import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u001c\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\r\u0010\u0005\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001aO\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0002\b\u000bH\u0086@ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\r\u0010\u000e\u001a\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a#\u0010\u0015\u001a\u00020\u0014*\u00020\u00002\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012¢\u0006\u0004\b\u0015\u0010\u0016\u001a%\u0010\u001a\u001a\u00020\u0014*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0011\u0010\u001c\u001a\u00020\u0014*\u00020\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0013\u0010\u001e\u001a\u00020\u0001H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\"\u001d\u0010$\u001a\u00020 *\u00020\u00008F@\u0006¢\u0006\f\u0012\u0004\b#\u0010\u001d\u001a\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Li/b/n0;", "Lkotlin/coroutines/CoroutineContext;", "context", "m", "(Li/b/n0;Lkotlin/coroutines/CoroutineContext;)Li/b/n0;", "b", "()Li/b/n0;", "R", "Lkotlin/Function2;", "Lh/e2/c;", "", "Lh/q;", ReportItem.LogTypeBlock, "g", "(Lh/k2/u/p;Lh/e2/c;)Ljava/lang/Object;", am.av, "(Lkotlin/coroutines/CoroutineContext;)Li/b/n0;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "Lh/t1;", e.j.a.b.c.f.f10128d, "(Li/b/n0;Ljava/util/concurrent/CancellationException;)V", "", "message", "", "c", "(Li/b/n0;Ljava/lang/String;Ljava/lang/Throwable;)V", "j", "(Li/b/n0;)V", "h", "(Lh/e2/c;)Ljava/lang/Object;", "", "k", "(Li/b/n0;)Z", "isActive$annotations", "isActive", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class o0 {
    @k.e.a.d
    public static final n0 a(@k.e.a.d CoroutineContext coroutineContext) {
        z d2;
        if (coroutineContext.get(b2.y0) == null) {
            d2 = g2.d(null, 1, null);
            coroutineContext = coroutineContext.plus(d2);
        }
        return new i.b.w3.i(coroutineContext);
    }

    @k.e.a.d
    public static final n0 b() {
        return new i.b.w3.i(e3.c(null, 1, null).plus(b1.e()));
    }

    public static final void c(@k.e.a.d n0 n0Var, @k.e.a.d String str, @k.e.a.e Throwable th) {
        d(n0Var, n1.a(str, th));
    }

    public static final void d(@k.e.a.d n0 n0Var, @k.e.a.e CancellationException cancellationException) {
        b2 b2Var = (b2) n0Var.getCoroutineContext().get(b2.y0);
        if (b2Var != null) {
            b2Var.b(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + n0Var).toString());
    }

    public static /* synthetic */ void e(n0 n0Var, String str, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        c(n0Var, str, th);
    }

    public static /* synthetic */ void f(n0 n0Var, CancellationException cancellationException, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        d(n0Var, cancellationException);
    }

    @k.e.a.e
    public static final <R> Object g(@k.e.a.d h.k2.u.p<? super n0, ? super h.e2.c<? super R>, ? extends Object> pVar, @k.e.a.d h.e2.c<? super R> cVar) {
        i.b.w3.e0 e0Var = new i.b.w3.e0(cVar.getContext(), cVar);
        Object f2 = i.b.x3.b.f(e0Var, e0Var, pVar);
        if (f2 == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return f2;
    }

    @k.e.a.e
    public static final Object h(@k.e.a.d h.e2.c<? super CoroutineContext> cVar) {
        return cVar.getContext();
    }

    @k.e.a.e
    private static final Object i(@k.e.a.d h.e2.c cVar) {
        h.k2.v.c0.e(3);
        h.e2.c cVar2 = null;
        return cVar2.getContext();
    }

    public static final void j(@k.e.a.d n0 n0Var) {
        e2.A(n0Var.getCoroutineContext());
    }

    public static final boolean k(@k.e.a.d n0 n0Var) {
        b2 b2Var = (b2) n0Var.getCoroutineContext().get(b2.y0);
        if (b2Var != null) {
            return b2Var.j();
        }
        return true;
    }

    public static /* synthetic */ void l(n0 n0Var) {
    }

    @k.e.a.d
    public static final n0 m(@k.e.a.d n0 n0Var, @k.e.a.d CoroutineContext coroutineContext) {
        return new i.b.w3.i(n0Var.getCoroutineContext().plus(coroutineContext));
    }
}
