package kotlinx.coroutines.flow.internal;

import h.k2.u.p;
import i.b.b2;
import java.util.Objects;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "count", "Lkotlin/coroutines/CoroutineContext$a;", "element", "invoke", "(ILkotlin/coroutines/CoroutineContext$a;)I", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class SafeCollector_commonKt$checkContext$result$1 extends Lambda implements p<Integer, CoroutineContext.a, Integer> {
    public final /* synthetic */ SafeCollector $this_checkContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeCollector_commonKt$checkContext$result$1(SafeCollector safeCollector) {
        super(2);
        this.$this_checkContext = safeCollector;
    }

    public final int invoke(int i2, @d CoroutineContext.a aVar) {
        CoroutineContext.b<?> key = aVar.getKey();
        CoroutineContext.a aVar2 = this.$this_checkContext.collectContext.get(key);
        if (key != b2.y0) {
            if (aVar != aVar2) {
                return Integer.MIN_VALUE;
            }
            return i2 + 1;
        }
        b2 b2Var = (b2) aVar2;
        Objects.requireNonNull(aVar, "null cannot be cast to non-null type kotlinx.coroutines.Job");
        b2 b = SafeCollector_commonKt.b((b2) aVar, b2Var);
        if (b == b2Var) {
            return b2Var == null ? i2 : i2 + 1;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + b + ", expected child of " + b2Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Integer invoke(Integer num, CoroutineContext.a aVar) {
        return Integer.valueOf(invoke(num.intValue(), aVar));
    }
}
