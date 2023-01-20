package i.b;

import i.b.b2;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Li/b/z;", "Li/b/b2;", "", "complete", "()Z", "", "exception", e.j.a.b.c.f.f10128d, "(Ljava/lang/Throwable;)Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public interface z extends b2 {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        public static <R> R b(@k.e.a.d z zVar, R r, @k.e.a.d h.k2.u.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) b2.a.d(zVar, r, pVar);
        }

        @k.e.a.e
        public static <E extends CoroutineContext.a> E c(@k.e.a.d z zVar, @k.e.a.d CoroutineContext.b<E> bVar) {
            return (E) b2.a.e(zVar, bVar);
        }

        @k.e.a.d
        public static CoroutineContext d(@k.e.a.d z zVar, @k.e.a.d CoroutineContext.b<?> bVar) {
            return b2.a.g(zVar, bVar);
        }

        @k.e.a.d
        public static CoroutineContext e(@k.e.a.d z zVar, @k.e.a.d CoroutineContext coroutineContext) {
            return b2.a.h(zVar, coroutineContext);
        }

        @h.i(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @k.e.a.d
        public static b2 f(@k.e.a.d z zVar, @k.e.a.d b2 b2Var) {
            return b2.a.i(zVar, b2Var);
        }
    }

    boolean complete();

    boolean d(@k.e.a.d Throwable th);
}
