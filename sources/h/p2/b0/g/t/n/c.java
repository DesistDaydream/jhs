package h.p2.b0.g.t.n;

import java.util.ArrayDeque;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;

/* loaded from: classes3.dex */
public final class c {
    @k.e.a.d
    public static final c a = new c();

    private c() {
    }

    private final boolean c(AbstractTypeCheckerContext abstractTypeCheckerContext, h.p2.b0.g.t.n.g1.i iVar, h.p2.b0.g.t.n.g1.m mVar) {
        h.p2.b0.g.t.n.g1.p j2 = abstractTypeCheckerContext.j();
        if (j2.i0(iVar)) {
            return true;
        }
        if (j2.v(iVar)) {
            return false;
        }
        if (abstractTypeCheckerContext.o() && j2.D(iVar)) {
            return true;
        }
        return j2.s0(j2.c(iVar), mVar);
    }

    private final boolean e(AbstractTypeCheckerContext abstractTypeCheckerContext, h.p2.b0.g.t.n.g1.i iVar, h.p2.b0.g.t.n.g1.i iVar2) {
        h.p2.b0.g.t.n.g1.p j2 = abstractTypeCheckerContext.j();
        if (f.b) {
            if (!j2.s(iVar) && !j2.f0(j2.c(iVar))) {
                abstractTypeCheckerContext.m(iVar);
            }
            if (!j2.s(iVar2)) {
                abstractTypeCheckerContext.m(iVar2);
            }
        }
        if (j2.v(iVar2) || j2.V(iVar)) {
            return true;
        }
        if ((iVar instanceof h.p2.b0.g.t.n.g1.b) && j2.h((h.p2.b0.g.t.n.g1.b) iVar)) {
            return true;
        }
        c cVar = a;
        if (cVar.a(abstractTypeCheckerContext, iVar, AbstractTypeCheckerContext.a.b.a)) {
            return true;
        }
        if (j2.V(iVar2) || cVar.a(abstractTypeCheckerContext, iVar2, AbstractTypeCheckerContext.a.d.a) || j2.H(iVar)) {
            return false;
        }
        return cVar.b(abstractTypeCheckerContext, iVar, j2.c(iVar2));
    }

    public final boolean a(@k.e.a.d AbstractTypeCheckerContext abstractTypeCheckerContext, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar, @k.e.a.d AbstractTypeCheckerContext.a aVar) {
        h.p2.b0.g.t.n.g1.p j2 = abstractTypeCheckerContext.j();
        if (!((j2.H(iVar) && !j2.v(iVar)) || j2.V(iVar))) {
            abstractTypeCheckerContext.k();
            ArrayDeque<h.p2.b0.g.t.n.g1.i> h2 = abstractTypeCheckerContext.h();
            Set<h.p2.b0.g.t.n.g1.i> i2 = abstractTypeCheckerContext.i();
            h2.push(iVar);
            while (!h2.isEmpty()) {
                if (i2.size() > 1000) {
                    throw new IllegalStateException(("Too many supertypes for type: " + iVar + ". Supertypes = " + CollectionsKt___CollectionsKt.Z2(i2, null, null, null, 0, null, null, 63, null)).toString());
                }
                h.p2.b0.g.t.n.g1.i pop = h2.pop();
                if (i2.add(pop)) {
                    AbstractTypeCheckerContext.a aVar2 = j2.v(pop) ? AbstractTypeCheckerContext.a.c.a : aVar;
                    if (!(!h.k2.v.f0.g(aVar2, AbstractTypeCheckerContext.a.c.a))) {
                        aVar2 = null;
                    }
                    if (aVar2 == null) {
                        continue;
                    } else {
                        h.p2.b0.g.t.n.g1.p j3 = abstractTypeCheckerContext.j();
                        for (h.p2.b0.g.t.n.g1.g gVar : j3.Q(j3.c(pop))) {
                            h.p2.b0.g.t.n.g1.i a2 = aVar2.a(abstractTypeCheckerContext, gVar);
                            if ((j2.H(a2) && !j2.v(a2)) || j2.V(a2)) {
                                abstractTypeCheckerContext.e();
                            } else {
                                h2.add(a2);
                            }
                        }
                    }
                }
            }
            abstractTypeCheckerContext.e();
            return false;
        }
        return true;
    }

    public final boolean b(@k.e.a.d AbstractTypeCheckerContext abstractTypeCheckerContext, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar) {
        h.p2.b0.g.t.n.g1.p j2 = abstractTypeCheckerContext.j();
        if (a.c(abstractTypeCheckerContext, iVar, mVar)) {
            return true;
        }
        abstractTypeCheckerContext.k();
        ArrayDeque<h.p2.b0.g.t.n.g1.i> h2 = abstractTypeCheckerContext.h();
        Set<h.p2.b0.g.t.n.g1.i> i2 = abstractTypeCheckerContext.i();
        h2.push(iVar);
        while (!h2.isEmpty()) {
            if (i2.size() > 1000) {
                throw new IllegalStateException(("Too many supertypes for type: " + iVar + ". Supertypes = " + CollectionsKt___CollectionsKt.Z2(i2, null, null, null, 0, null, null, 63, null)).toString());
            }
            h.p2.b0.g.t.n.g1.i pop = h2.pop();
            if (i2.add(pop)) {
                AbstractTypeCheckerContext.a aVar = j2.v(pop) ? AbstractTypeCheckerContext.a.c.a : AbstractTypeCheckerContext.a.b.a;
                if (!(!h.k2.v.f0.g(aVar, AbstractTypeCheckerContext.a.c.a))) {
                    aVar = null;
                }
                if (aVar == null) {
                    continue;
                } else {
                    h.p2.b0.g.t.n.g1.p j3 = abstractTypeCheckerContext.j();
                    for (h.p2.b0.g.t.n.g1.g gVar : j3.Q(j3.c(pop))) {
                        h.p2.b0.g.t.n.g1.i a2 = aVar.a(abstractTypeCheckerContext, gVar);
                        if (a.c(abstractTypeCheckerContext, a2, mVar)) {
                            abstractTypeCheckerContext.e();
                            return true;
                        }
                        h2.add(a2);
                    }
                    continue;
                }
            }
        }
        abstractTypeCheckerContext.e();
        return false;
    }

    public final boolean d(@k.e.a.d AbstractTypeCheckerContext abstractTypeCheckerContext, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar2) {
        return e(abstractTypeCheckerContext, iVar, iVar2);
    }
}
