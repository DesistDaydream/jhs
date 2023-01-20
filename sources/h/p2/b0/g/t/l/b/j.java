package h.p2.b0.g.t.l.b;

import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.c0;
import h.p2.b0.g.t.c.d0;

/* loaded from: classes3.dex */
public final class j implements e {
    @k.e.a.d
    private final c0 a;

    public j(@k.e.a.d c0 c0Var) {
        this.a = c0Var;
    }

    @Override // h.p2.b0.g.t.l.b.e
    @k.e.a.e
    public d a(@k.e.a.d h.p2.b0.g.t.g.b bVar) {
        d a;
        for (b0 b0Var : d0.c(this.a, bVar.h())) {
            if ((b0Var instanceof k) && (a = ((k) b0Var).C0().a(bVar)) != null) {
                return a;
            }
        }
        return null;
    }
}
