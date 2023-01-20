package h.p2.b0.g.t.n;

/* loaded from: classes3.dex */
public final class h0 extends l implements z0 {
    @k.e.a.d
    private final f0 b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final z f15582c;

    public h0(@k.e.a.d f0 f0Var, @k.e.a.d z zVar) {
        this.b = f0Var;
        this.f15582c = zVar;
    }

    @Override // h.p2.b0.g.t.n.z0
    @k.e.a.d
    public c1 C0() {
        return R0();
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    /* renamed from: P0 */
    public f0 M0(boolean z) {
        return (f0) a1.d(C0().M0(z), f0().L0().M0(z));
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    /* renamed from: Q0 */
    public f0 O0(@k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        return (f0) a1.d(C0().O0(eVar), f0());
    }

    @Override // h.p2.b0.g.t.n.l
    @k.e.a.d
    public f0 R0() {
        return this.b;
    }

    @Override // h.p2.b0.g.t.n.l
    @k.e.a.d
    /* renamed from: U0 */
    public h0 S0(@k.e.a.d h.p2.b0.g.t.n.e1.h hVar) {
        return new h0((f0) hVar.g(R0()), hVar.g(f0()));
    }

    @Override // h.p2.b0.g.t.n.l
    @k.e.a.d
    /* renamed from: V0 */
    public h0 T0(@k.e.a.d f0 f0Var) {
        return new h0(f0Var, f0());
    }

    @Override // h.p2.b0.g.t.n.z0
    @k.e.a.d
    public z f0() {
        return this.f15582c;
    }
}
