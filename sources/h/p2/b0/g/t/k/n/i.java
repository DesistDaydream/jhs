package h.p2.b0.g.t.k.n;

import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.z;
import h.z0;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;

/* loaded from: classes3.dex */
public final class i extends g<Pair<? extends h.p2.b0.g.t.g.b, ? extends h.p2.b0.g.t.g.f>> {
    @k.e.a.d
    private final h.p2.b0.g.t.g.b b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final h.p2.b0.g.t.g.f f15475c;

    public i(@k.e.a.d h.p2.b0.g.t.g.b bVar, @k.e.a.d h.p2.b0.g.t.g.f fVar) {
        super(z0.a(bVar, fVar));
        this.b = bVar;
        this.f15475c = fVar;
    }

    @k.e.a.d
    public final h.p2.b0.g.t.g.f b() {
        return this.f15475c;
    }

    @Override // h.p2.b0.g.t.k.n.g
    @k.e.a.d
    public z getType(@k.e.a.d h.p2.b0.g.t.c.z zVar) {
        h.p2.b0.g.t.c.d a = FindClassInModuleKt.a(zVar, this.b);
        f0 f0Var = null;
        if (a != null) {
            if (!h.p2.b0.g.t.k.c.A(a)) {
                a = null;
            }
            if (a != null) {
                f0Var = a.r();
            }
        }
        if (f0Var == null) {
            return h.p2.b0.g.t.n.s.j("Containing class for error-class based enum entry " + this.b + '.' + this.f15475c);
        }
        return f0Var;
    }

    @Override // h.p2.b0.g.t.k.n.g
    @k.e.a.d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b.j());
        sb.append('.');
        sb.append(this.f15475c);
        return sb.toString();
    }
}
