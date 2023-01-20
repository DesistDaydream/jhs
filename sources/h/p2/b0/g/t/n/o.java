package h.p2.b0.g.t.n;

import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class o extends v0 {
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    public static final a f15593e = new a(null);
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final v0 f15594c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final v0 f15595d;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }

        @h.k2.k
        @k.e.a.d
        public final v0 a(@k.e.a.d v0 v0Var, @k.e.a.d v0 v0Var2) {
            return v0Var.f() ? v0Var2 : v0Var2.f() ? v0Var : new o(v0Var, v0Var2, null);
        }
    }

    private o(v0 v0Var, v0 v0Var2) {
        this.f15594c = v0Var;
        this.f15595d = v0Var2;
    }

    public /* synthetic */ o(v0 v0Var, v0 v0Var2, h.k2.v.u uVar) {
        this(v0Var, v0Var2);
    }

    @h.k2.k
    @k.e.a.d
    public static final v0 h(@k.e.a.d v0 v0Var, @k.e.a.d v0 v0Var2) {
        return f15593e.a(v0Var, v0Var2);
    }

    @Override // h.p2.b0.g.t.n.v0
    public boolean a() {
        return this.f15594c.a() || this.f15595d.a();
    }

    @Override // h.p2.b0.g.t.n.v0
    public boolean b() {
        return this.f15594c.b() || this.f15595d.b();
    }

    @Override // h.p2.b0.g.t.n.v0
    @k.e.a.d
    public h.p2.b0.g.t.c.b1.e d(@k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        return this.f15595d.d(this.f15594c.d(eVar));
    }

    @Override // h.p2.b0.g.t.n.v0
    @k.e.a.e
    public s0 e(@k.e.a.d z zVar) {
        s0 e2 = this.f15594c.e(zVar);
        return e2 == null ? this.f15595d.e(zVar) : e2;
    }

    @Override // h.p2.b0.g.t.n.v0
    public boolean f() {
        return false;
    }

    @Override // h.p2.b0.g.t.n.v0
    @k.e.a.d
    public z g(@k.e.a.d z zVar, @k.e.a.d Variance variance) {
        return this.f15595d.g(this.f15594c.g(zVar, variance), variance);
    }
}
