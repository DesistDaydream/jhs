package h.p2.b0.g.t.b.k;

import h.a2.c1;
import h.a2.d1;
import h.k2.v.f0;
import h.p2.b0.g.t.n.y0;
import h.p2.b0.g.t.n.z;
import java.util.Collection;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes3.dex */
public final class d {
    @k.e.a.d
    public static final d a = new d();

    private d() {
    }

    public static /* synthetic */ h.p2.b0.g.t.c.d h(d dVar, h.p2.b0.g.t.g.c cVar, h.p2.b0.g.t.b.f fVar, Integer num, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        return dVar.g(cVar, fVar, num);
    }

    @k.e.a.d
    public final h.p2.b0.g.t.c.d a(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        h.p2.b0.g.t.g.c p = c.a.p(h.p2.b0.g.t.k.c.m(dVar));
        if (p != null) {
            return DescriptorUtilsKt.g(dVar).o(p);
        }
        throw new IllegalArgumentException("Given class " + dVar + " is not a mutable collection");
    }

    @k.e.a.d
    public final h.p2.b0.g.t.c.d b(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        h.p2.b0.g.t.g.c q = c.a.q(h.p2.b0.g.t.k.c.m(dVar));
        if (q != null) {
            return DescriptorUtilsKt.g(dVar).o(q);
        }
        throw new IllegalArgumentException("Given class " + dVar + " is not a read-only collection");
    }

    public final boolean c(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        return c.a.l(h.p2.b0.g.t.k.c.m(dVar));
    }

    public final boolean d(@k.e.a.d z zVar) {
        h.p2.b0.g.t.c.d f2 = y0.f(zVar);
        return f2 != null && c(f2);
    }

    public final boolean e(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        return c.a.m(h.p2.b0.g.t.k.c.m(dVar));
    }

    public final boolean f(@k.e.a.d z zVar) {
        h.p2.b0.g.t.c.d f2 = y0.f(zVar);
        return f2 != null && e(f2);
    }

    @k.e.a.e
    public final h.p2.b0.g.t.c.d g(@k.e.a.d h.p2.b0.g.t.g.c cVar, @k.e.a.d h.p2.b0.g.t.b.f fVar, @k.e.a.e Integer num) {
        h.p2.b0.g.t.g.b n;
        if (num == null || !f0.g(cVar, c.a.i())) {
            n = c.a.n(cVar);
        } else {
            h.p2.b0.g.t.b.g gVar = h.p2.b0.g.t.b.g.a;
            n = h.p2.b0.g.t.b.g.a(num.intValue());
        }
        if (n != null) {
            return fVar.o(n.b());
        }
        return null;
    }

    @k.e.a.d
    public final Collection<h.p2.b0.g.t.c.d> i(@k.e.a.d h.p2.b0.g.t.g.c cVar, @k.e.a.d h.p2.b0.g.t.b.f fVar) {
        h.p2.b0.g.t.c.d h2 = h(this, cVar, fVar, null, 4, null);
        if (h2 == null) {
            return d1.k();
        }
        h.p2.b0.g.t.g.c q = c.a.q(DescriptorUtilsKt.j(h2));
        return q == null ? c1.f(h2) : CollectionsKt__CollectionsKt.L(h2, fVar.o(q));
    }
}
