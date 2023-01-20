package h.p2.b0.g.t.n;

import java.util.HashSet;

/* loaded from: classes3.dex */
public final class t {
    @k.e.a.e
    public static final h.p2.b0.g.t.n.g1.g a(@k.e.a.d x0 x0Var, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
        return b(x0Var, gVar, new HashSet());
    }

    private static final h.p2.b0.g.t.n.g1.g b(x0 x0Var, h.p2.b0.g.t.n.g1.g gVar, HashSet<h.p2.b0.g.t.n.g1.m> hashSet) {
        h.p2.b0.g.t.n.g1.g b;
        h.p2.b0.g.t.n.g1.m S = x0Var.S(gVar);
        if (hashSet.add(S)) {
            h.p2.b0.g.t.n.g1.n n = x0Var.n(S);
            if (n != null) {
                b = b(x0Var, x0Var.M(n), hashSet);
                if (b == null) {
                    return null;
                }
                if (!x0Var.E(b) && x0Var.n0(gVar)) {
                    return x0Var.t0(b);
                }
            } else if (!x0Var.x(S)) {
                return gVar;
            } else {
                h.p2.b0.g.t.n.g1.g g0 = x0Var.g0(gVar);
                if (g0 == null || (b = b(x0Var, g0, hashSet)) == null) {
                    return null;
                }
                if (x0Var.E(gVar)) {
                    return x0Var.E(b) ? gVar : ((b instanceof h.p2.b0.g.t.n.g1.i) && x0Var.J((h.p2.b0.g.t.n.g1.i) b)) ? gVar : x0Var.t0(b);
                }
            }
            return b;
        }
        return null;
    }
}
