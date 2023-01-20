package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.p;
import h.k2.v.f0;
import h.s0;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH¦\u0002¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00002\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH&J\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002¨\u0006\u0013"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", ExifInterface.LONGITUDE_EAST, "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "plus", "context", "Element", "Key", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@s0(version = "1.3")
/* loaded from: classes3.dex */
public interface CoroutineContext {

    @Metadata(k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        @d
        public static CoroutineContext a(@d CoroutineContext coroutineContext, @d CoroutineContext coroutineContext2) {
            return coroutineContext2 == EmptyCoroutineContext.INSTANCE ? coroutineContext : (CoroutineContext) coroutineContext2.fold(coroutineContext, CoroutineContext$plus$1.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J5\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u0002H\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\r0\u0003H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", ExifInterface.LONGITUDE_EAST, "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public interface a extends CoroutineContext {

        @Metadata(k = 3, mv = {1, 5, 1})
        /* renamed from: kotlin.coroutines.CoroutineContext$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0492a {
            public static <R> R a(@d a aVar, R r, @d p<? super R, ? super a, ? extends R> pVar) {
                return pVar.invoke(r, aVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @e
            public static <E extends a> E b(@d a aVar, @d b<E> bVar) {
                if (f0.g(aVar.getKey(), bVar)) {
                    Objects.requireNonNull(aVar, "null cannot be cast to non-null type E");
                    return aVar;
                }
                return null;
            }

            @d
            public static CoroutineContext c(@d a aVar, @d b<?> bVar) {
                return f0.g(aVar.getKey(), bVar) ? EmptyCoroutineContext.INSTANCE : aVar;
            }

            @d
            public static CoroutineContext d(@d a aVar, @d CoroutineContext coroutineContext) {
                return DefaultImpls.a(aVar, coroutineContext);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <R> R fold(R r, @d p<? super R, ? super a, ? extends R> pVar);

        @Override // kotlin.coroutines.CoroutineContext
        @e
        <E extends a> E get(@d b<E> bVar);

        @d
        b<?> getKey();

        @Override // kotlin.coroutines.CoroutineContext
        @d
        CoroutineContext minusKey(@d b<?> bVar);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Key;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/CoroutineContext$Element;", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public interface b<E extends a> {
    }

    <R> R fold(R r, @d p<? super R, ? super a, ? extends R> pVar);

    @e
    <E extends a> E get(@d b<E> bVar);

    @d
    CoroutineContext minusKey(@d b<?> bVar);

    @d
    CoroutineContext plus(@d CoroutineContext coroutineContext);
}
