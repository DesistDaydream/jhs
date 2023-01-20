package h.p2.b0.g.t.n;

import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes3.dex */
public final class x {
    @k.e.a.d
    public static final u a(@k.e.a.d z zVar) {
        return (u) zVar.L0();
    }

    public static final boolean b(@k.e.a.d z zVar) {
        return zVar.L0() instanceof u;
    }

    @k.e.a.d
    public static final f0 c(@k.e.a.d z zVar) {
        c1 L0 = zVar.L0();
        if (L0 instanceof u) {
            return ((u) L0).Q0();
        }
        if (L0 instanceof f0) {
            return (f0) L0;
        }
        throw new NoWhenBranchMatchedException();
    }

    @k.e.a.d
    public static final f0 d(@k.e.a.d z zVar) {
        c1 L0 = zVar.L0();
        if (L0 instanceof u) {
            return ((u) L0).R0();
        }
        if (L0 instanceof f0) {
            return (f0) L0;
        }
        throw new NoWhenBranchMatchedException();
    }
}
