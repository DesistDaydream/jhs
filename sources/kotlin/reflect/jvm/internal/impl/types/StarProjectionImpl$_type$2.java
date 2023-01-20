package kotlin.reflect.jvm.internal.impl.types;

import h.k2.u.a;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.k0;
import h.p2.b0.g.t.n.z;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class StarProjectionImpl$_type$2 extends Lambda implements a<z> {
    public final /* synthetic */ StarProjectionImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StarProjectionImpl$_type$2(StarProjectionImpl starProjectionImpl) {
        super(0);
        this.this$0 = starProjectionImpl;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final z invoke() {
        t0 t0Var;
        t0Var = this.this$0.a;
        return k0.a(t0Var);
    }
}
