package h.p2.b0.g.t.n;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public abstract class u extends c1 implements h.p2.b0.g.t.n.g1.e {
    @k.e.a.d
    private final f0 b;
    @k.e.a.d

    /* renamed from: c */
    private final f0 f15608c;

    public u(@k.e.a.d f0 f0Var, @k.e.a.d f0 f0Var2) {
        super(null);
        this.b = f0Var;
        this.f15608c = f0Var2;
    }

    @Override // h.p2.b0.g.t.n.z
    @k.e.a.d
    public List<s0> H0() {
        return P0().H0();
    }

    @Override // h.p2.b0.g.t.n.z
    @k.e.a.d
    public q0 I0() {
        return P0().I0();
    }

    @Override // h.p2.b0.g.t.n.z
    public boolean J0() {
        return P0().J0();
    }

    @k.e.a.d
    public abstract f0 P0();

    @k.e.a.d
    public final f0 Q0() {
        return this.b;
    }

    @k.e.a.d
    public final f0 R0() {
        return this.f15608c;
    }

    @k.e.a.d
    public abstract String S0(@k.e.a.d DescriptorRenderer descriptorRenderer, @k.e.a.d h.p2.b0.g.t.j.b bVar);

    @Override // h.p2.b0.g.t.c.b1.a
    @k.e.a.d
    public h.p2.b0.g.t.c.b1.e getAnnotations() {
        return P0().getAnnotations();
    }

    @Override // h.p2.b0.g.t.n.z
    @k.e.a.d
    public MemberScope q() {
        return P0().q();
    }

    @k.e.a.d
    public String toString() {
        return DescriptorRenderer.f16753j.y(this);
    }
}
