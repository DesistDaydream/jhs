package h.p2.b0.g.t.n;

/* loaded from: classes3.dex */
public final class y extends v0 {
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final h.p2.b0.g.t.c.t0[] f15614c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final s0[] f15615d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f15616e;

    public /* synthetic */ y(h.p2.b0.g.t.c.t0[] t0VarArr, s0[] s0VarArr, boolean z, int i2, h.k2.v.u uVar) {
        this(t0VarArr, s0VarArr, (i2 & 4) != 0 ? false : z);
    }

    @Override // h.p2.b0.g.t.n.v0
    public boolean b() {
        return this.f15616e;
    }

    @Override // h.p2.b0.g.t.n.v0
    @k.e.a.e
    public s0 e(@k.e.a.d z zVar) {
        h.p2.b0.g.t.c.f c2 = zVar.I0().c();
        h.p2.b0.g.t.c.t0 t0Var = c2 instanceof h.p2.b0.g.t.c.t0 ? (h.p2.b0.g.t.c.t0) c2 : null;
        if (t0Var == null) {
            return null;
        }
        int f2 = t0Var.f();
        h.p2.b0.g.t.c.t0[] t0VarArr = this.f15614c;
        if (f2 >= t0VarArr.length || !h.k2.v.f0.g(t0VarArr[f2].j(), t0Var.j())) {
            return null;
        }
        return this.f15615d[f2];
    }

    @Override // h.p2.b0.g.t.n.v0
    public boolean f() {
        return this.f15615d.length == 0;
    }

    @k.e.a.d
    public final s0[] h() {
        return this.f15615d;
    }

    @k.e.a.d
    public final h.p2.b0.g.t.c.t0[] i() {
        return this.f15614c;
    }

    public y(@k.e.a.d h.p2.b0.g.t.c.t0[] t0VarArr, @k.e.a.d s0[] s0VarArr, boolean z) {
        this.f15614c = t0VarArr;
        this.f15615d = s0VarArr;
        this.f15616e = z;
        int length = t0VarArr.length;
        int length2 = s0VarArr.length;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public y(@k.e.a.d java.util.List<? extends h.p2.b0.g.t.c.t0> r9, @k.e.a.d java.util.List<? extends h.p2.b0.g.t.n.s0> r10) {
        /*
            r8 = this;
            r0 = 0
            h.p2.b0.g.t.c.t0[] r1 = new h.p2.b0.g.t.c.t0[r0]
            java.lang.Object[] r9 = r9.toArray(r1)
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
            java.util.Objects.requireNonNull(r9, r1)
            r3 = r9
            h.p2.b0.g.t.c.t0[] r3 = (h.p2.b0.g.t.c.t0[]) r3
            h.p2.b0.g.t.n.s0[] r9 = new h.p2.b0.g.t.n.s0[r0]
            java.lang.Object[] r9 = r10.toArray(r9)
            java.util.Objects.requireNonNull(r9, r1)
            r4 = r9
            h.p2.b0.g.t.n.s0[] r4 = (h.p2.b0.g.t.n.s0[]) r4
            r5 = 0
            r6 = 4
            r7 = 0
            r2 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.p2.b0.g.t.n.y.<init>(java.util.List, java.util.List):void");
    }
}
