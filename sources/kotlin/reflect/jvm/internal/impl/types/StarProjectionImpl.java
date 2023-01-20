package kotlin.reflect.jvm.internal.impl.types;

import h.p2.b0.g.t.n.e1.h;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.t0;
import h.w;
import h.z;
import k.e.a.d;
import kotlin.LazyThreadSafetyMode;

/* loaded from: classes3.dex */
public final class StarProjectionImpl extends t0 {
    @d
    private final h.p2.b0.g.t.c.t0 a;
    @d
    private final w b = z.b(LazyThreadSafetyMode.PUBLICATION, new StarProjectionImpl$_type$2(this));

    public StarProjectionImpl(@d h.p2.b0.g.t.c.t0 t0Var) {
        this.a = t0Var;
    }

    private final h.p2.b0.g.t.n.z e() {
        return (h.p2.b0.g.t.n.z) this.b.getValue();
    }

    @Override // h.p2.b0.g.t.n.s0
    @d
    public s0 a(@d h hVar) {
        return this;
    }

    @Override // h.p2.b0.g.t.n.s0
    public boolean b() {
        return true;
    }

    @Override // h.p2.b0.g.t.n.s0
    @d
    public Variance c() {
        return Variance.OUT_VARIANCE;
    }

    @Override // h.p2.b0.g.t.n.s0
    @d
    public h.p2.b0.g.t.n.z getType() {
        return e();
    }
}
