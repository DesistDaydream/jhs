package i.b;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;

@Metadata(bv = {1, 0, 3}, d1 = {"i/b/h", "i/b/i"}, d2 = {}, k = 4, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class g {
    @k.e.a.d
    public static final <T> u0<T> a(@k.e.a.d n0 n0Var, @k.e.a.d CoroutineContext coroutineContext, @k.e.a.d CoroutineStart coroutineStart, @k.e.a.d h.k2.u.p<? super n0, ? super h.e2.c<? super T>, ? extends Object> pVar) {
        return i.a(n0Var, coroutineContext, coroutineStart, pVar);
    }

    @k.e.a.e
    public static final <T> Object c(@k.e.a.d CoroutineDispatcher coroutineDispatcher, @k.e.a.d h.k2.u.p<? super n0, ? super h.e2.c<? super T>, ? extends Object> pVar, @k.e.a.d h.e2.c<? super T> cVar) {
        return i.c(coroutineDispatcher, pVar, cVar);
    }

    @k.e.a.e
    private static final Object d(@k.e.a.d CoroutineDispatcher coroutineDispatcher, @k.e.a.d h.k2.u.p pVar, @k.e.a.d h.e2.c cVar) {
        return i.c(coroutineDispatcher, pVar, cVar);
    }

    @k.e.a.d
    public static final b2 e(@k.e.a.d n0 n0Var, @k.e.a.d CoroutineContext coroutineContext, @k.e.a.d CoroutineStart coroutineStart, @k.e.a.d h.k2.u.p<? super n0, ? super h.e2.c<? super h.t1>, ? extends Object> pVar) {
        return i.e(n0Var, coroutineContext, coroutineStart, pVar);
    }

    public static final <T> T g(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d h.k2.u.p<? super n0, ? super h.e2.c<? super T>, ? extends Object> pVar) throws InterruptedException {
        return (T) h.a(coroutineContext, pVar);
    }

    @k.e.a.e
    public static final <T> Object i(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d h.k2.u.p<? super n0, ? super h.e2.c<? super T>, ? extends Object> pVar, @k.e.a.d h.e2.c<? super T> cVar) {
        return i.g(coroutineContext, pVar, cVar);
    }
}
