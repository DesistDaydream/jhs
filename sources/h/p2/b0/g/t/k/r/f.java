package h.p2.b0.g.t.k.r;

import h.k2.u.l;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.n0;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;

/* loaded from: classes3.dex */
public abstract class f implements MemberScope {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, h.p2.b0.g.t.k.r.h
    @k.e.a.d
    public Collection<? extends n0> a(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar) {
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @k.e.a.d
    public Set<h.p2.b0.g.t.g.f> b() {
        Collection<k> g2 = g(d.v, FunctionsKt.a());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : g2) {
            if (obj instanceof n0) {
                linkedHashSet.add(((n0) obj).getName());
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @k.e.a.d
    public Collection<? extends j0> c(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar) {
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @k.e.a.d
    public Set<h.p2.b0.g.t.g.f> d() {
        Collection<k> g2 = g(d.w, FunctionsKt.a());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : g2) {
            if (obj instanceof n0) {
                linkedHashSet.add(((n0) obj).getName());
            }
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @k.e.a.e
    public Set<h.p2.b0.g.t.g.f> e() {
        return null;
    }

    @Override // h.p2.b0.g.t.k.r.h
    @k.e.a.e
    public h.p2.b0.g.t.c.f f(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar) {
        return null;
    }

    @Override // h.p2.b0.g.t.k.r.h
    @k.e.a.d
    public Collection<k> g(@k.e.a.d d dVar, @k.e.a.d l<? super h.p2.b0.g.t.g.f, Boolean> lVar) {
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // h.p2.b0.g.t.k.r.h
    public void h(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar) {
        MemberScope.a.a(this, fVar, bVar);
    }
}
