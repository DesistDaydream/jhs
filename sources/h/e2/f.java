package h.e2;

import androidx.exifinterface.media.ExifInterface;
import h.o;
import h.s0;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0007¨\u0006\b"}, d2 = {"getPolymorphicElement", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusPolymorphicKey", "Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class f {
    /* JADX WARN: Multi-variable type inference failed */
    @o
    @k.e.a.e
    @s0(version = "1.3")
    public static final <E extends CoroutineContext.a> E a(@k.e.a.d CoroutineContext.a aVar, @k.e.a.d CoroutineContext.b<E> bVar) {
        if (bVar instanceof b) {
            b bVar2 = (b) bVar;
            if (bVar2.a(aVar.getKey())) {
                E e2 = (E) bVar2.b(aVar);
                if (e2 instanceof CoroutineContext.a) {
                    return e2;
                }
                return null;
            }
            return null;
        } else if (aVar.getKey() == bVar) {
            return aVar;
        } else {
            return null;
        }
    }

    @o
    @s0(version = "1.3")
    @k.e.a.d
    public static final CoroutineContext b(@k.e.a.d CoroutineContext.a aVar, @k.e.a.d CoroutineContext.b<?> bVar) {
        if (!(bVar instanceof b)) {
            return aVar.getKey() == bVar ? EmptyCoroutineContext.INSTANCE : aVar;
        }
        b bVar2 = (b) bVar;
        return (!bVar2.a(aVar.getKey()) || bVar2.b(aVar) == null) ? aVar : EmptyCoroutineContext.INSTANCE;
    }
}
