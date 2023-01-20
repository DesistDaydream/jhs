package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.a2.t;
import h.k2.u.l;
import h.k2.v.f0;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.g.f;
import java.util.Collection;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1 extends Lambda implements l<f, Collection<? extends n0>> {
    public final /* synthetic */ n0 $function;
    public final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1(n0 n0Var, LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(1);
        this.$function = n0Var;
        this.this$0 = lazyJavaClassMemberScope;
    }

    @Override // h.k2.u.l
    @d
    public final Collection<n0> invoke(@d f fVar) {
        Collection I0;
        Collection J0;
        if (!f0.g(this.$function.getName(), fVar)) {
            I0 = this.this$0.I0(fVar);
            J0 = this.this$0.J0(fVar);
            return CollectionsKt___CollectionsKt.q4(I0, J0);
        }
        return t.k(this.$function);
    }
}
