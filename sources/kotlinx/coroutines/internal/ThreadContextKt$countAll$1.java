package kotlinx.coroutines.internal;

import h.k2.u.p;
import i.b.f3;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "countOrElement", "Lkotlin/coroutines/CoroutineContext$a;", "element", "invoke", "(Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext$a;)Ljava/lang/Object;", "<no name provided>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ThreadContextKt$countAll$1 extends Lambda implements p<Object, CoroutineContext.a, Object> {
    public static final ThreadContextKt$countAll$1 INSTANCE = new ThreadContextKt$countAll$1();

    public ThreadContextKt$countAll$1() {
        super(2);
    }

    @Override // h.k2.u.p
    @e
    public final Object invoke(@e Object obj, @d CoroutineContext.a aVar) {
        if (aVar instanceof f3) {
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            int intValue = num != null ? num.intValue() : 1;
            return intValue == 0 ? aVar : Integer.valueOf(intValue + 1);
        }
        return obj;
    }
}
