package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.l;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.e.a.x.n;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.m.g;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyJavaScope$declaredField$1 extends Lambda implements l<f, j0> {
    public final /* synthetic */ LazyJavaScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaScope$declaredField$1(LazyJavaScope lazyJavaScope) {
        super(1);
        this.this$0 = lazyJavaScope;
    }

    @Override // h.k2.u.l
    @e
    public final j0 invoke(@d f fVar) {
        j0 K;
        g gVar;
        if (this.this$0.C() != null) {
            gVar = this.this$0.C().f16541g;
            return (j0) gVar.invoke(fVar);
        }
        n f2 = this.this$0.z().invoke().f(fVar);
        if (f2 == null || f2.J()) {
            return null;
        }
        K = this.this$0.K(f2);
        return K;
    }
}
