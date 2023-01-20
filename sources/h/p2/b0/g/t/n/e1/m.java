package h.p2.b0.g.t.n.e1;

import h.p2.b0.g.t.n.c1;
import h.p2.b0.g.t.n.e1.g;
import h.p2.b0.g.t.n.z;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;

/* loaded from: classes3.dex */
public final class m implements l {
    @k.e.a.d

    /* renamed from: c */
    private final h f15571c;
    @k.e.a.d

    /* renamed from: d */
    private final g f15572d;
    @k.e.a.d

    /* renamed from: e */
    private final OverridingUtil f15573e;

    public m(@k.e.a.d h hVar, @k.e.a.d g gVar) {
        this.f15571c = hVar;
        this.f15572d = gVar;
        this.f15573e = OverridingUtil.n(c());
    }

    @Override // h.p2.b0.g.t.n.e1.l
    @k.e.a.d
    public OverridingUtil a() {
        return this.f15573e;
    }

    @Override // h.p2.b0.g.t.n.e1.f
    public boolean b(@k.e.a.d z zVar, @k.e.a.d z zVar2) {
        return e(new a(false, false, false, c(), f(), null, 38, null), zVar.L0(), zVar2.L0());
    }

    @Override // h.p2.b0.g.t.n.e1.l
    @k.e.a.d
    public h c() {
        return this.f15571c;
    }

    @Override // h.p2.b0.g.t.n.e1.f
    public boolean d(@k.e.a.d z zVar, @k.e.a.d z zVar2) {
        return g(new a(true, false, false, c(), f(), null, 38, null), zVar.L0(), zVar2.L0());
    }

    public final boolean e(@k.e.a.d a aVar, @k.e.a.d c1 c1Var, @k.e.a.d c1 c1Var2) {
        return h.p2.b0.g.t.n.f.a.i(aVar, c1Var, c1Var2);
    }

    @k.e.a.d
    public g f() {
        return this.f15572d;
    }

    public final boolean g(@k.e.a.d a aVar, @k.e.a.d c1 c1Var, @k.e.a.d c1 c1Var2) {
        return h.p2.b0.g.t.n.f.p(h.p2.b0.g.t.n.f.a, aVar, c1Var, c1Var2, false, 8, null);
    }

    public /* synthetic */ m(h hVar, g gVar, int i2, h.k2.v.u uVar) {
        this(hVar, (i2 & 2) != 0 ? g.a.a : gVar);
    }
}
