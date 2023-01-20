package i.b;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"i/b/f2", "i/b/g2"}, d2 = {}, k = 4, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class e2 {
    public static final void A(@k.e.a.d CoroutineContext coroutineContext) {
        g2.y(coroutineContext);
    }

    public static final void B(@k.e.a.d b2 b2Var) {
        g2.z(b2Var);
    }

    @k.e.a.d
    public static final b2 C(@k.e.a.d CoroutineContext coroutineContext) {
        return g2.A(coroutineContext);
    }

    public static final boolean D(@k.e.a.d CoroutineContext coroutineContext) {
        return g2.B(coroutineContext);
    }

    @x1
    @k.e.a.d
    public static final e1 a(@k.e.a.d h.k2.u.a<h.t1> aVar) {
        return g2.a(aVar);
    }

    @k.e.a.d
    public static final z b(@k.e.a.e b2 b2Var) {
        return g2.b(b2Var);
    }

    public static final void g(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.e CancellationException cancellationException) {
        g2.g(coroutineContext, cancellationException);
    }

    public static final void h(@k.e.a.d b2 b2Var, @k.e.a.d String str, @k.e.a.e Throwable th) {
        g2.h(b2Var, str, th);
    }

    @k.e.a.e
    public static final Object m(@k.e.a.d b2 b2Var, @k.e.a.d h.e2.c<? super h.t1> cVar) {
        return g2.m(b2Var, cVar);
    }

    public static final void p(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.e CancellationException cancellationException) {
        g2.p(coroutineContext, cancellationException);
    }

    public static final void s(@k.e.a.d b2 b2Var, @k.e.a.e CancellationException cancellationException) {
        g2.s(b2Var, cancellationException);
    }

    public static final void x(@k.e.a.d n<?> nVar, @k.e.a.d Future<?> future) {
        f2.a(nVar, future);
    }

    @x1
    @k.e.a.d
    public static final e1 y(@k.e.a.d b2 b2Var, @k.e.a.d Future<?> future) {
        return f2.b(b2Var, future);
    }

    @k.e.a.d
    public static final e1 z(@k.e.a.d b2 b2Var, @k.e.a.d e1 e1Var) {
        return g2.x(b2Var, e1Var);
    }
}
