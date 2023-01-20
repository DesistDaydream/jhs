package h.p2.b0.g.t.k.m.a;

import h.a2.t;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.e1.h;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.z;
import java.util.Collection;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;

/* loaded from: classes3.dex */
public final class c implements b {
    @d
    private final s0 a;
    @e
    private NewCapturedTypeConstructor b;

    public c(@d s0 s0Var) {
        this.a = s0Var;
        b().c();
        Variance variance = Variance.INVARIANT;
    }

    @Override // h.p2.b0.g.t.k.m.a.b
    @d
    public s0 b() {
        return this.a;
    }

    @Override // h.p2.b0.g.t.n.q0
    public /* bridge */ /* synthetic */ f c() {
        return (f) e();
    }

    @Override // h.p2.b0.g.t.n.q0
    public boolean d() {
        return false;
    }

    @e
    public Void e() {
        return null;
    }

    @e
    public final NewCapturedTypeConstructor f() {
        return this.b;
    }

    @Override // h.p2.b0.g.t.n.q0
    @d
    /* renamed from: g */
    public c a(@d h hVar) {
        return new c(b().a(hVar));
    }

    @Override // h.p2.b0.g.t.n.q0
    @d
    public List<t0> getParameters() {
        return CollectionsKt__CollectionsKt.E();
    }

    public final void h(@e NewCapturedTypeConstructor newCapturedTypeConstructor) {
        this.b = newCapturedTypeConstructor;
    }

    @Override // h.p2.b0.g.t.n.q0
    @d
    public Collection<z> j() {
        z I;
        if (b().c() == Variance.OUT_VARIANCE) {
            I = b().getType();
        } else {
            I = k().I();
        }
        return t.k(I);
    }

    @Override // h.p2.b0.g.t.n.q0
    @d
    public h.p2.b0.g.t.b.f k() {
        return b().getType().I0().k();
    }

    @d
    public String toString() {
        return "CapturedTypeConstructor(" + b() + ')';
    }
}
