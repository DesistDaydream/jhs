package h.p2.b0.g.t.n;

/* loaded from: classes3.dex */
public final class d {
    @k.e.a.d
    public static final d a = new d();

    private d() {
    }

    private final boolean a(h.p2.b0.g.t.n.g1.p pVar, h.p2.b0.g.t.n.g1.i iVar, h.p2.b0.g.t.n.g1.i iVar2) {
        int g2;
        if (pVar.g(iVar) == pVar.g(iVar2) && pVar.v(iVar) == pVar.v(iVar2)) {
            if ((pVar.p0(iVar) == null) == (pVar.p0(iVar2) == null) && pVar.s0(pVar.c(iVar), pVar.c(iVar2))) {
                if (!pVar.G(iVar, iVar2) && (g2 = pVar.g(iVar)) > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2 + 1;
                        h.p2.b0.g.t.n.g1.l A = pVar.A(iVar, i2);
                        h.p2.b0.g.t.n.g1.l A2 = pVar.A(iVar2, i2);
                        if (pVar.q(A) != pVar.q(A2)) {
                            return false;
                        }
                        if (!pVar.q(A) && (pVar.k0(A) != pVar.k0(A2) || !c(pVar, pVar.getType(A), pVar.getType(A2)))) {
                            return false;
                        }
                        if (i3 >= g2) {
                            break;
                        }
                        i2 = i3;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private final boolean c(h.p2.b0.g.t.n.g1.p pVar, h.p2.b0.g.t.n.g1.g gVar, h.p2.b0.g.t.n.g1.g gVar2) {
        if (gVar == gVar2) {
            return true;
        }
        h.p2.b0.g.t.n.g1.i b = pVar.b(gVar);
        h.p2.b0.g.t.n.g1.i b2 = pVar.b(gVar2);
        if (b != null && b2 != null) {
            return a(pVar, b, b2);
        }
        h.p2.b0.g.t.n.g1.e Y = pVar.Y(gVar);
        h.p2.b0.g.t.n.g1.e Y2 = pVar.Y(gVar2);
        return Y != null && Y2 != null && a(pVar, pVar.a(Y), pVar.a(Y2)) && a(pVar, pVar.e(Y), pVar.e(Y2));
    }

    public final boolean b(@k.e.a.d h.p2.b0.g.t.n.g1.p pVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar2) {
        return c(pVar, gVar, gVar2);
    }
}
