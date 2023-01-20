package i.b;

import i.b.b2;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@x1
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Li/b/v;", "Li/b/b2;", "Li/b/r2;", "parentJob", "Lh/t1;", "s", "(Li/b/r2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@h.i(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
/* loaded from: classes4.dex */
public interface v extends b2 {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        public static <R> R b(@k.e.a.d v vVar, R r, @k.e.a.d h.k2.u.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) b2.a.d(vVar, r, pVar);
        }

        @k.e.a.e
        public static <E extends CoroutineContext.a> E c(@k.e.a.d v vVar, @k.e.a.d CoroutineContext.b<E> bVar) {
            return (E) b2.a.e(vVar, bVar);
        }

        @k.e.a.d
        public static CoroutineContext d(@k.e.a.d v vVar, @k.e.a.d CoroutineContext.b<?> bVar) {
            return b2.a.g(vVar, bVar);
        }

        @k.e.a.d
        public static CoroutineContext e(@k.e.a.d v vVar, @k.e.a.d CoroutineContext coroutineContext) {
            return b2.a.h(vVar, coroutineContext);
        }

        @h.i(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @k.e.a.d
        public static b2 f(@k.e.a.d v vVar, @k.e.a.d b2 b2Var) {
            return b2.a.i(vVar, b2Var);
        }
    }

    @x1
    void s(@k.e.a.d r2 r2Var);
}
