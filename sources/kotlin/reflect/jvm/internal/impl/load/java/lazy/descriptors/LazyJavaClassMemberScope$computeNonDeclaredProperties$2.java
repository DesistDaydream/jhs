package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.l;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.g.f;
import java.util.Collection;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyJavaClassMemberScope$computeNonDeclaredProperties$2 extends Lambda implements l<f, Collection<? extends n0>> {
    public final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$computeNonDeclaredProperties$2(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(1);
        this.this$0 = lazyJavaClassMemberScope;
    }

    @Override // h.k2.u.l
    @d
    public final Collection<n0> invoke(@d f fVar) {
        Collection<n0> J0;
        J0 = this.this$0.J0(fVar);
        return J0;
    }
}
