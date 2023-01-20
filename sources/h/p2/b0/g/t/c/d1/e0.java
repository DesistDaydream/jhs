package h.p2.b0.g.t.c.d1;

import h.a2.d1;
import h.p2.b0.g.t.k.r.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes3.dex */
public class e0 extends h.p2.b0.g.t.k.r.f {
    @k.e.a.d
    private final h.p2.b0.g.t.c.z b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final h.p2.b0.g.t.g.c f15102c;

    public e0(@k.e.a.d h.p2.b0.g.t.c.z zVar, @k.e.a.d h.p2.b0.g.t.g.c cVar) {
        this.b = zVar;
        this.f15102c = cVar;
    }

    @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @k.e.a.d
    public Set<h.p2.b0.g.t.g.f> e() {
        return d1.k();
    }

    @Override // h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
    @k.e.a.d
    public Collection<h.p2.b0.g.t.c.k> g(@k.e.a.d h.p2.b0.g.t.k.r.d dVar, @k.e.a.d h.k2.u.l<? super h.p2.b0.g.t.g.f, Boolean> lVar) {
        if (dVar.a(h.p2.b0.g.t.k.r.d.f15480c.f())) {
            if (this.f15102c.d() && dVar.l().contains(c.b.a)) {
                return CollectionsKt__CollectionsKt.E();
            }
            Collection<h.p2.b0.g.t.g.c> p = this.b.p(this.f15102c, lVar);
            ArrayList arrayList = new ArrayList(p.size());
            for (h.p2.b0.g.t.g.c cVar : p) {
                h.p2.b0.g.t.g.f g2 = cVar.g();
                if (lVar.invoke(g2).booleanValue()) {
                    h.p2.b0.g.t.p.a.a(arrayList, i(g2));
                }
            }
            return arrayList;
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @k.e.a.e
    public final h.p2.b0.g.t.c.f0 i(@k.e.a.d h.p2.b0.g.t.g.f fVar) {
        if (fVar.g()) {
            return null;
        }
        h.p2.b0.g.t.c.f0 j0 = this.b.j0(this.f15102c.c(fVar));
        if (j0.isEmpty()) {
            return null;
        }
        return j0;
    }
}
