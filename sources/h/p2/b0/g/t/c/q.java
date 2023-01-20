package h.p2.b0.g.t.c;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class q {
    @k.e.a.e
    public static final f a(@k.e.a.d k kVar) {
        k b = kVar.b();
        if (b == null || (kVar instanceof b0)) {
            return null;
        }
        if (!b(b)) {
            return a(b);
        }
        if (b instanceof f) {
            return (f) b;
        }
        return null;
    }

    public static final boolean b(@k.e.a.d k kVar) {
        return kVar.b() instanceof b0;
    }

    @k.e.a.e
    public static final d c(@k.e.a.d z zVar, @k.e.a.d h.p2.b0.g.t.g.c cVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar) {
        MemberScope U;
        if (cVar.d()) {
            return null;
        }
        f f2 = zVar.j0(cVar.e()).q().f(cVar.g(), bVar);
        d dVar = f2 instanceof d ? (d) f2 : null;
        if (dVar == null) {
            d c2 = c(zVar, cVar.e(), bVar);
            f f3 = (c2 == null || (U = c2.U()) == null) ? null : U.f(cVar.g(), bVar);
            if (f3 instanceof d) {
                return (d) f3;
            }
            return null;
        }
        return dVar;
    }
}
