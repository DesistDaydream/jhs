package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import h.k2.u.a;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.s;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class JavaTypeResolverKt$getErasedUpperBound$1 extends Lambda implements a<f0> {
    public final /* synthetic */ t0 $this_getErasedUpperBound;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaTypeResolverKt$getErasedUpperBound$1(t0 t0Var) {
        super(0);
        this.$this_getErasedUpperBound = t0Var;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final f0 invoke() {
        return s.j("Can't compute erased upper bound of type parameter `" + this.$this_getErasedUpperBound + '`');
    }
}
