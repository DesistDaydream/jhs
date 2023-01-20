package h.p2.b0.g.t.n;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public abstract class z implements h.p2.b0.g.t.c.b1.a, h.p2.b0.g.t.n.g1.g {
    private int a;

    private z() {
    }

    public /* synthetic */ z(h.k2.v.u uVar) {
        this();
    }

    private final int G0() {
        if (a0.a(this)) {
            return super.hashCode();
        }
        return (((I0().hashCode() * 31) + H0().hashCode()) * 31) + (J0() ? 1 : 0);
    }

    @k.e.a.d
    public abstract List<s0> H0();

    @k.e.a.d
    public abstract q0 I0();

    public abstract boolean J0();

    @k.e.a.d
    public abstract z K0(@k.e.a.d h.p2.b0.g.t.n.e1.h hVar);

    @k.e.a.d
    public abstract c1 L0();

    public final boolean equals(@k.e.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof z) {
            z zVar = (z) obj;
            return J0() == zVar.J0() && h.p2.b0.g.t.n.e1.r.a.a(L0(), zVar.L0());
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.a;
        if (i2 != 0) {
            return i2;
        }
        int G0 = G0();
        this.a = G0;
        return G0;
    }

    @k.e.a.d
    public abstract MemberScope q();
}
