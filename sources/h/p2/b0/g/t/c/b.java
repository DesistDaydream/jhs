package h.p2.b0.g.t.c;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class b implements t0 {
    @k.e.a.d
    private final t0 a;
    @k.e.a.d
    private final k b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15082c;

    public b(@k.e.a.d t0 t0Var, @k.e.a.d k kVar, int i2) {
        this.a = t0Var;
        this.b = kVar;
        this.f15082c = i2;
    }

    @Override // h.p2.b0.g.t.c.k
    public <R, D> R B(m<R, D> mVar, D d2) {
        return (R) this.a.B(mVar, d2);
    }

    @Override // h.p2.b0.g.t.c.t0
    @k.e.a.d
    public h.p2.b0.g.t.m.m N() {
        return this.a.N();
    }

    @Override // h.p2.b0.g.t.c.t0
    public boolean S() {
        return true;
    }

    @Override // h.p2.b0.g.t.c.l, h.p2.b0.g.t.c.k
    @k.e.a.d
    public k b() {
        return this.b;
    }

    @Override // h.p2.b0.g.t.c.t0
    public int f() {
        return this.f15082c + this.a.f();
    }

    @Override // h.p2.b0.g.t.c.b1.a
    @k.e.a.d
    public h.p2.b0.g.t.c.b1.e getAnnotations() {
        return this.a.getAnnotations();
    }

    @Override // h.p2.b0.g.t.c.a0
    @k.e.a.d
    public h.p2.b0.g.t.g.f getName() {
        return this.a.getName();
    }

    @Override // h.p2.b0.g.t.c.n
    @k.e.a.d
    public o0 getSource() {
        return this.a.getSource();
    }

    @Override // h.p2.b0.g.t.c.t0
    @k.e.a.d
    public List<h.p2.b0.g.t.n.z> getUpperBounds() {
        return this.a.getUpperBounds();
    }

    @Override // h.p2.b0.g.t.c.t0, h.p2.b0.g.t.c.f
    @k.e.a.d
    public h.p2.b0.g.t.n.q0 j() {
        return this.a.j();
    }

    @Override // h.p2.b0.g.t.c.t0
    public boolean l() {
        return this.a.l();
    }

    @Override // h.p2.b0.g.t.c.t0
    @k.e.a.d
    public Variance o() {
        return this.a.o();
    }

    @Override // h.p2.b0.g.t.c.f
    @k.e.a.d
    public h.p2.b0.g.t.n.f0 r() {
        return this.a.r();
    }

    @k.e.a.d
    public String toString() {
        return this.a + "[inner-copy]";
    }

    @Override // h.p2.b0.g.t.c.t0, h.p2.b0.g.t.c.f, h.p2.b0.g.t.c.k
    @k.e.a.d
    public t0 a() {
        return this.a.a();
    }
}
