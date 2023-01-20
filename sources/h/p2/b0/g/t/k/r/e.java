package h.p2.b0.g.t.k.r;

import h.k2.u.l;
import h.k2.v.f0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.s0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class e extends f {
    @k.e.a.d
    private final MemberScope b;

    public e(@k.e.a.d MemberScope memberScope) {
        this.b = memberScope;
    }

    @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @k.e.a.d
    public Set<h.p2.b0.g.t.g.f> b() {
        return this.b.b();
    }

    @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @k.e.a.d
    public Set<h.p2.b0.g.t.g.f> d() {
        return this.b.d();
    }

    @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @k.e.a.e
    public Set<h.p2.b0.g.t.g.f> e() {
        return this.b.e();
    }

    @Override // h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
    @k.e.a.e
    public h.p2.b0.g.t.c.f f(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar) {
        h.p2.b0.g.t.c.f f2 = this.b.f(fVar, bVar);
        if (f2 == null) {
            return null;
        }
        h.p2.b0.g.t.c.d dVar = f2 instanceof h.p2.b0.g.t.c.d ? (h.p2.b0.g.t.c.d) f2 : null;
        if (dVar == null) {
            if (f2 instanceof s0) {
                return (s0) f2;
            }
            return null;
        }
        return dVar;
    }

    @Override // h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
    public void h(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar) {
        this.b.h(fVar, bVar);
    }

    @Override // h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
    @k.e.a.d
    /* renamed from: i */
    public List<h.p2.b0.g.t.c.f> g(@k.e.a.d d dVar, @k.e.a.d l<? super h.p2.b0.g.t.g.f, Boolean> lVar) {
        d n = dVar.n(d.f15480c.c());
        if (n == null) {
            return CollectionsKt__CollectionsKt.E();
        }
        Collection<k> g2 = this.b.g(n, lVar);
        ArrayList arrayList = new ArrayList();
        for (Object obj : g2) {
            if (obj instanceof h.p2.b0.g.t.c.g) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @k.e.a.d
    public String toString() {
        return f0.C("Classes from ", this.b);
    }
}
