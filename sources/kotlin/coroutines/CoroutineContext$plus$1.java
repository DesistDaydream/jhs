package kotlin.coroutines;

import h.e2.d;
import h.k2.u.p;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class CoroutineContext$plus$1 extends Lambda implements p<CoroutineContext, CoroutineContext.a, CoroutineContext> {
    public static final CoroutineContext$plus$1 INSTANCE = new CoroutineContext$plus$1();

    public CoroutineContext$plus$1() {
        super(2);
    }

    @Override // h.k2.u.p
    @d
    public final CoroutineContext invoke(@d CoroutineContext coroutineContext, @d CoroutineContext.a aVar) {
        CombinedContext combinedContext;
        CoroutineContext minusKey = coroutineContext.minusKey(aVar.getKey());
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (minusKey == emptyCoroutineContext) {
            return aVar;
        }
        d.b bVar = h.e2.d.v0;
        h.e2.d dVar = (h.e2.d) minusKey.get(bVar);
        if (dVar == null) {
            combinedContext = new CombinedContext(minusKey, aVar);
        } else {
            CoroutineContext minusKey2 = minusKey.minusKey(bVar);
            if (minusKey2 == emptyCoroutineContext) {
                return new CombinedContext(aVar, dVar);
            }
            combinedContext = new CombinedContext(new CombinedContext(minusKey2, aVar), dVar);
        }
        return combinedContext;
    }
}
