package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.c.d1.z;
import h.p2.b0.g.t.e.a.x.n;
import h.p2.b0.g.t.k.n.g;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyJavaScope$resolveProperty$1 extends Lambda implements a<g<?>> {
    public final /* synthetic */ n $field;
    public final /* synthetic */ z $propertyDescriptor;
    public final /* synthetic */ LazyJavaScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaScope$resolveProperty$1(LazyJavaScope lazyJavaScope, n nVar, z zVar) {
        super(0);
        this.this$0 = lazyJavaScope;
        this.$field = nVar;
        this.$propertyDescriptor = zVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @e
    public final g<?> invoke() {
        return this.this$0.x().a().g().a(this.$field, this.$propertyDescriptor);
    }
}
