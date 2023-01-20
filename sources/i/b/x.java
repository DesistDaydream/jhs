package i.b;

import androidx.exifinterface.media.ExifInterface;
import i.b.u0;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Li/b/x;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/u0;", "value", "", "complete", "(Ljava/lang/Object;)Z", "", "exception", e.j.a.b.c.f.f10128d, "(Ljava/lang/Throwable;)Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public interface x<T> extends u0<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        public static <T, R> R b(@k.e.a.d x<T> xVar, R r, @k.e.a.d h.k2.u.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) u0.a.b(xVar, r, pVar);
        }

        @k.e.a.e
        public static <T, E extends CoroutineContext.a> E c(@k.e.a.d x<T> xVar, @k.e.a.d CoroutineContext.b<E> bVar) {
            return (E) u0.a.c(xVar, bVar);
        }

        @k.e.a.d
        public static <T> CoroutineContext d(@k.e.a.d x<T> xVar, @k.e.a.d CoroutineContext.b<?> bVar) {
            return u0.a.d(xVar, bVar);
        }

        @k.e.a.d
        public static <T> CoroutineContext e(@k.e.a.d x<T> xVar, @k.e.a.d CoroutineContext coroutineContext) {
            return u0.a.e(xVar, coroutineContext);
        }

        @h.i(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @k.e.a.d
        public static <T> b2 f(@k.e.a.d x<T> xVar, @k.e.a.d b2 b2Var) {
            return u0.a.f(xVar, b2Var);
        }
    }

    boolean complete(T t);

    boolean d(@k.e.a.d Throwable th);
}
