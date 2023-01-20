package h.e2;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.p;
import h.s0;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ(\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0096\u0002¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\bH&J\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/CoroutineContext$Element;", "get", ExifInterface.LONGITUDE_EAST, "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "interceptContinuation", "Lkotlin/coroutines/Continuation;", ExifInterface.GPS_DIRECTION_TRUE, "continuation", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "releaseInterceptedContinuation", "", "Key", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@s0(version = "1.3")
/* loaded from: classes3.dex */
public interface d extends CoroutineContext.a {
    @k.e.a.d
    public static final b v0 = b.a;

    @Metadata(k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        public static <R> R a(@k.e.a.d d dVar, R r, @k.e.a.d p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) CoroutineContext.a.C0492a.a(dVar, r, pVar);
        }

        @k.e.a.e
        public static <E extends CoroutineContext.a> E b(@k.e.a.d d dVar, @k.e.a.d CoroutineContext.b<E> bVar) {
            if (bVar instanceof h.e2.b) {
                h.e2.b bVar2 = (h.e2.b) bVar;
                if (bVar2.a(dVar.getKey())) {
                    E e2 = (E) bVar2.b(dVar);
                    if (e2 instanceof CoroutineContext.a) {
                        return e2;
                    }
                    return null;
                }
                return null;
            } else if (d.v0 == bVar) {
                Objects.requireNonNull(dVar, "null cannot be cast to non-null type E");
                return dVar;
            } else {
                return null;
            }
        }

        @k.e.a.d
        public static CoroutineContext c(@k.e.a.d d dVar, @k.e.a.d CoroutineContext.b<?> bVar) {
            if (!(bVar instanceof h.e2.b)) {
                return d.v0 == bVar ? EmptyCoroutineContext.INSTANCE : dVar;
            }
            h.e2.b bVar2 = (h.e2.b) bVar;
            return (!bVar2.a(dVar.getKey()) || bVar2.b(dVar) == null) ? dVar : EmptyCoroutineContext.INSTANCE;
        }

        @k.e.a.d
        public static CoroutineContext d(@k.e.a.d d dVar, @k.e.a.d CoroutineContext coroutineContext) {
            return CoroutineContext.a.C0492a.d(dVar, coroutineContext);
        }

        public static void e(@k.e.a.d d dVar, @k.e.a.d c<?> cVar) {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/coroutines/ContinuationInterceptor$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class b implements CoroutineContext.b<d> {
        public static final /* synthetic */ b a = new b();

        private b() {
        }
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @k.e.a.e
    <E extends CoroutineContext.a> E get(@k.e.a.d CoroutineContext.b<E> bVar);

    @k.e.a.d
    <T> c<T> interceptContinuation(@k.e.a.d c<? super T> cVar);

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @k.e.a.d
    CoroutineContext minusKey(@k.e.a.d CoroutineContext.b<?> bVar);

    void releaseInterceptedContinuation(@k.e.a.d c<?> cVar);
}
