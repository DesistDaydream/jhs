package h.p2.b0.g.t.n;

/* loaded from: classes3.dex */
public final class j extends l implements i, h.p2.b0.g.t.n.g1.c {
    @k.e.a.d

    /* renamed from: d */
    public static final a f15584d = new a(null);
    @k.e.a.d
    private final f0 b;

    /* renamed from: c */
    private final boolean f15585c;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }

        private final boolean a(c1 c1Var) {
            return (c1Var.I0() instanceof h.p2.b0.g.t.n.e1.n) || (c1Var.I0().c() instanceof h.p2.b0.g.t.c.t0) || (c1Var instanceof h.p2.b0.g.t.n.e1.j);
        }

        public static /* synthetic */ j c(a aVar, c1 c1Var, boolean z, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            return aVar.b(c1Var, z);
        }

        private final boolean d(c1 c1Var, boolean z) {
            if (a(c1Var)) {
                if (z && (c1Var.I0().c() instanceof h.p2.b0.g.t.c.t0)) {
                    return y0.l(c1Var);
                }
                return !h.p2.b0.g.t.n.e1.o.a.a(c1Var);
            }
            return false;
        }

        @k.e.a.e
        public final j b(@k.e.a.d c1 c1Var, boolean z) {
            if (c1Var instanceof j) {
                return (j) c1Var;
            }
            if (d(c1Var, z)) {
                if (c1Var instanceof u) {
                    u uVar = (u) c1Var;
                    h.k2.v.f0.g(uVar.Q0().I0(), uVar.R0().I0());
                }
                return new j(x.c(c1Var), z, null);
            }
            return null;
        }
    }

    private j(f0 f0Var, boolean z) {
        this.b = f0Var;
        this.f15585c = z;
    }

    public /* synthetic */ j(f0 f0Var, boolean z, h.k2.v.u uVar) {
        this(f0Var, z);
    }

    @Override // h.p2.b0.g.t.n.i
    public boolean A() {
        return (R0().I0() instanceof h.p2.b0.g.t.n.e1.n) || (R0().I0().c() instanceof h.p2.b0.g.t.c.t0);
    }

    @Override // h.p2.b0.g.t.n.l, h.p2.b0.g.t.n.z
    public boolean J0() {
        return false;
    }

    @Override // h.p2.b0.g.t.n.c1
    @k.e.a.d
    /* renamed from: P0 */
    public f0 M0(boolean z) {
        return z ? R0().P0(z) : this;
    }

    @Override // h.p2.b0.g.t.n.l
    @k.e.a.d
    public f0 R0() {
        return this.b;
    }

    @k.e.a.d
    public final f0 U0() {
        return this.b;
    }

    @Override // h.p2.b0.g.t.n.f0
    @k.e.a.d
    /* renamed from: V0 */
    public j Q0(@k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        return new j(R0().Q0(eVar), this.f15585c);
    }

    @Override // h.p2.b0.g.t.n.l
    @k.e.a.d
    /* renamed from: W0 */
    public j T0(@k.e.a.d f0 f0Var) {
        return new j(f0Var, this.f15585c);
    }

    @Override // h.p2.b0.g.t.n.i
    @k.e.a.d
    public z h0(@k.e.a.d z zVar) {
        return i0.e(zVar.L0(), this.f15585c);
    }

    @Override // h.p2.b0.g.t.n.f0
    @k.e.a.d
    public String toString() {
        return R0() + "!!";
    }
}
