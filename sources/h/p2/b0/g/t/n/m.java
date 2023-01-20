package h.p2.b0.g.t.n;

/* loaded from: classes3.dex */
public abstract class m extends l {
    @k.e.a.d
    private final f0 b;

    public m(@k.e.a.d f0 f0Var) {
        this.b = f0Var;
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    /* renamed from: P0 */
    public f0 M0(boolean z) {
        return z == J0() ? this : R0().P0(z).Q0(getAnnotations());
    }

    @Override // h.p2.b0.g.t.n.l
    @k.e.a.d
    public f0 R0() {
        return this.b;
    }

    @Override // h.p2.b0.g.t.n.f0
    @k.e.a.d
    /* renamed from: U0 */
    public m Q0(@k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        return eVar != getAnnotations() ? new g(this, eVar) : this;
    }
}
