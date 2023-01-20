package i.b;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Li/b/f3;", ExifInterface.LATITUDE_SOUTH, "Lkotlin/coroutines/CoroutineContext$a;", "Lkotlin/coroutines/CoroutineContext;", "context", "u0", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "oldState", "Lh/t1;", "J", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public interface f3<S> extends CoroutineContext.a {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        public static <S, R> R a(@k.e.a.d f3<S> f3Var, R r, @k.e.a.d h.k2.u.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) CoroutineContext.a.C0492a.a(f3Var, r, pVar);
        }

        @k.e.a.e
        public static <S, E extends CoroutineContext.a> E b(@k.e.a.d f3<S> f3Var, @k.e.a.d CoroutineContext.b<E> bVar) {
            return (E) CoroutineContext.a.C0492a.b(f3Var, bVar);
        }

        @k.e.a.d
        public static <S> CoroutineContext c(@k.e.a.d f3<S> f3Var, @k.e.a.d CoroutineContext.b<?> bVar) {
            return CoroutineContext.a.C0492a.c(f3Var, bVar);
        }

        @k.e.a.d
        public static <S> CoroutineContext d(@k.e.a.d f3<S> f3Var, @k.e.a.d CoroutineContext coroutineContext) {
            return CoroutineContext.a.C0492a.d(f3Var, coroutineContext);
        }
    }

    void J(@k.e.a.d CoroutineContext coroutineContext, S s);

    S u0(@k.e.a.d CoroutineContext coroutineContext);
}
