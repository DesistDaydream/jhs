package kotlinx.coroutines.internal;

import h.k2.u.p;
import i.b.f3;
import i.b.w3.s0;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Li/b/w3/s0;", "state", "Lkotlin/coroutines/CoroutineContext$a;", "element", "invoke", "(Li/b/w3/s0;Lkotlin/coroutines/CoroutineContext$a;)Li/b/w3/s0;", "<no name provided>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ThreadContextKt$updateState$1 extends Lambda implements p<s0, CoroutineContext.a, s0> {
    public static final ThreadContextKt$updateState$1 INSTANCE = new ThreadContextKt$updateState$1();

    public ThreadContextKt$updateState$1() {
        super(2);
    }

    @Override // h.k2.u.p
    @d
    public final s0 invoke(@d s0 s0Var, @d CoroutineContext.a aVar) {
        if (aVar instanceof f3) {
            s0Var.a(((f3) aVar).u0(s0Var.getContext()));
        }
        return s0Var;
    }
}
