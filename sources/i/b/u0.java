package i.b;

import androidx.exifinterface.media.ExifInterface;
import i.b.b2;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0013\u0010\u0003\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00028\u0000H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H'¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Li/b/u0;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/b2;", "r", "(Lh/e2/c;)Ljava/lang/Object;", "n", "()Ljava/lang/Object;", "", "o", "()Ljava/lang/Throwable;", "Li/b/z3/d;", "X", "()Li/b/z3/d;", "onAwait", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public interface u0<T> extends b2 {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        public static <T, R> R b(@k.e.a.d u0<? extends T> u0Var, R r, @k.e.a.d h.k2.u.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) b2.a.d(u0Var, r, pVar);
        }

        @k.e.a.e
        public static <T, E extends CoroutineContext.a> E c(@k.e.a.d u0<? extends T> u0Var, @k.e.a.d CoroutineContext.b<E> bVar) {
            return (E) b2.a.e(u0Var, bVar);
        }

        @k.e.a.d
        public static <T> CoroutineContext d(@k.e.a.d u0<? extends T> u0Var, @k.e.a.d CoroutineContext.b<?> bVar) {
            return b2.a.g(u0Var, bVar);
        }

        @k.e.a.d
        public static <T> CoroutineContext e(@k.e.a.d u0<? extends T> u0Var, @k.e.a.d CoroutineContext coroutineContext) {
            return b2.a.h(u0Var, coroutineContext);
        }

        @h.i(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @k.e.a.d
        public static <T> b2 f(@k.e.a.d u0<? extends T> u0Var, @k.e.a.d b2 b2Var) {
            return b2.a.i(u0Var, b2Var);
        }
    }

    @k.e.a.d
    i.b.z3.d<T> X();

    @r1
    T n();

    @r1
    @k.e.a.e
    Throwable o();

    @k.e.a.e
    Object r(@k.e.a.d h.e2.c<? super T> cVar);
}
