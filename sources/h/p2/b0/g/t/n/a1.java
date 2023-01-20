package h.p2.b0.g.t.n;

import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes3.dex */
public final class a1 {
    @k.e.a.e
    public static final z a(@k.e.a.d z zVar) {
        if (zVar instanceof z0) {
            return ((z0) zVar).f0();
        }
        return null;
    }

    @k.e.a.d
    public static final c1 b(@k.e.a.d c1 c1Var, @k.e.a.d z zVar) {
        return d(c1Var, a(zVar));
    }

    @k.e.a.d
    public static final z c(@k.e.a.d z zVar) {
        z a = a(zVar);
        return a == null ? zVar : a;
    }

    @k.e.a.d
    public static final c1 d(@k.e.a.d c1 c1Var, @k.e.a.e z zVar) {
        if (zVar == null) {
            return c1Var;
        }
        if (c1Var instanceof f0) {
            return new h0((f0) c1Var, zVar);
        }
        if (c1Var instanceof u) {
            return new w((u) c1Var, zVar);
        }
        throw new NoWhenBranchMatchedException();
    }
}
