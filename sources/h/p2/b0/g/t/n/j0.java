package h.p2.b0.g.t.n;

import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class j0 extends t0 {
    @k.e.a.d
    private final z a;

    public j0(@k.e.a.d h.p2.b0.g.t.b.f fVar) {
        this.a = fVar.I();
    }

    @Override // h.p2.b0.g.t.n.s0
    @k.e.a.d
    public s0 a(@k.e.a.d h.p2.b0.g.t.n.e1.h hVar) {
        return this;
    }

    @Override // h.p2.b0.g.t.n.s0
    public boolean b() {
        return true;
    }

    @Override // h.p2.b0.g.t.n.s0
    @k.e.a.d
    public Variance c() {
        return Variance.OUT_VARIANCE;
    }

    @Override // h.p2.b0.g.t.n.s0
    @k.e.a.d
    public z getType() {
        return this.a;
    }
}
