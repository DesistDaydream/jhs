package kotlinx.coroutines.internal;

import h.k2.u.p;
import i.b.f3;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00002\f\u0010\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Li/b/f3;", "found", "Lkotlin/coroutines/CoroutineContext$a;", "element", "invoke", "(Li/b/f3;Lkotlin/coroutines/CoroutineContext$a;)Li/b/f3;", "<no name provided>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ThreadContextKt$findOne$1 extends Lambda implements p<f3<?>, CoroutineContext.a, f3<?>> {
    public static final ThreadContextKt$findOne$1 INSTANCE = new ThreadContextKt$findOne$1();

    public ThreadContextKt$findOne$1() {
        super(2);
    }

    @Override // h.k2.u.p
    @e
    public final f3<?> invoke(@e f3<?> f3Var, @d CoroutineContext.a aVar) {
        if (f3Var != null) {
            return f3Var;
        }
        if (!(aVar instanceof f3)) {
            aVar = null;
        }
        return (f3) aVar;
    }
}
