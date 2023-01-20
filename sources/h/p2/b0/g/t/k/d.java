package h.p2.b0.g.t.k;

import h.k2.v.f0;
import h.p2.b0.g.t.c.k0;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.c.x0;
import h.p2.b0.g.t.n.z;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class d {
    @k.e.a.d
    private static final h.p2.b0.g.t.g.c a = new h.p2.b0.g.t.g.c("kotlin.jvm.JvmInline");

    public static final boolean a(@k.e.a.d h.p2.b0.g.t.c.a aVar) {
        return (aVar instanceof k0) && d(((k0) aVar).V());
    }

    public static final boolean b(@k.e.a.d h.p2.b0.g.t.c.k kVar) {
        if (kVar instanceof h.p2.b0.g.t.c.d) {
            h.p2.b0.g.t.c.d dVar = (h.p2.b0.g.t.c.d) kVar;
            if (dVar.isInline() || dVar.w()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean c(@k.e.a.d z zVar) {
        h.p2.b0.g.t.c.f c2 = zVar.I0().c();
        if (c2 == null) {
            return false;
        }
        return b(c2);
    }

    public static final boolean d(@k.e.a.d x0 x0Var) {
        if (x0Var.Q() != null) {
            return false;
        }
        h.p2.b0.g.t.c.k b = x0Var.b();
        if (b(b)) {
            v0 f2 = f((h.p2.b0.g.t.c.d) b);
            return f0.g(f2 == null ? null : f2.getName(), x0Var.getName());
        }
        return false;
    }

    @k.e.a.e
    public static final z e(@k.e.a.d z zVar) {
        v0 g2 = g(zVar);
        if (g2 == null) {
            return null;
        }
        return TypeSubstitutor.f(zVar).p(g2.getType(), Variance.INVARIANT);
    }

    @k.e.a.e
    public static final v0 f(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        h.p2.b0.g.t.c.c E;
        List<v0> h2;
        if (!b(dVar) || (E = dVar.E()) == null || (h2 = E.h()) == null) {
            return null;
        }
        return (v0) CollectionsKt___CollectionsKt.X4(h2);
    }

    @k.e.a.e
    public static final v0 g(@k.e.a.d z zVar) {
        h.p2.b0.g.t.c.f c2 = zVar.I0().c();
        if (!(c2 instanceof h.p2.b0.g.t.c.d)) {
            c2 = null;
        }
        h.p2.b0.g.t.c.d dVar = (h.p2.b0.g.t.c.d) c2;
        if (dVar == null) {
            return null;
        }
        return f(dVar);
    }
}
