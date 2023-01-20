package h.p2.b0.g.t.n;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public abstract class d1 extends z {
    public d1() {
        super(null);
    }

    @Override // h.p2.b0.g.t.n.z
    @k.e.a.d
    public List<s0> H0() {
        return M0().H0();
    }

    @Override // h.p2.b0.g.t.n.z
    @k.e.a.d
    public q0 I0() {
        return M0().I0();
    }

    @Override // h.p2.b0.g.t.n.z
    public boolean J0() {
        return M0().J0();
    }

    @Override // h.p2.b0.g.t.n.z
    @k.e.a.d
    public final c1 L0() {
        z M0 = M0();
        while (M0 instanceof d1) {
            M0 = ((d1) M0).M0();
        }
        return (c1) M0;
    }

    @k.e.a.d
    public abstract z M0();

    public boolean N0() {
        return true;
    }

    @Override // h.p2.b0.g.t.c.b1.a
    @k.e.a.d
    public h.p2.b0.g.t.c.b1.e getAnnotations() {
        return M0().getAnnotations();
    }

    @Override // h.p2.b0.g.t.n.z
    @k.e.a.d
    public MemberScope q() {
        return M0().q();
    }

    @k.e.a.d
    public String toString() {
        return N0() ? M0().toString() : "<Not computed yet>";
    }
}
