package h.p2.b0.g.t.k.r;

import h.k2.u.l;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.n0;
import java.util.Collection;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public abstract class a implements MemberScope {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, h.p2.b0.g.t.k.r.h
    @k.e.a.d
    public Collection<n0> a(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar) {
        return j().a(fVar, bVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @k.e.a.d
    public Set<h.p2.b0.g.t.g.f> b() {
        return j().b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @k.e.a.d
    public Collection<j0> c(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar) {
        return j().c(fVar, bVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @k.e.a.d
    public Set<h.p2.b0.g.t.g.f> d() {
        return j().d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @k.e.a.e
    public Set<h.p2.b0.g.t.g.f> e() {
        return j().e();
    }

    @Override // h.p2.b0.g.t.k.r.h
    @k.e.a.e
    public h.p2.b0.g.t.c.f f(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar) {
        return j().f(fVar, bVar);
    }

    @Override // h.p2.b0.g.t.k.r.h
    @k.e.a.d
    public Collection<k> g(@k.e.a.d d dVar, @k.e.a.d l<? super h.p2.b0.g.t.g.f, Boolean> lVar) {
        return j().g(dVar, lVar);
    }

    @Override // h.p2.b0.g.t.k.r.h
    public void h(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar) {
        j().h(fVar, bVar);
    }

    @k.e.a.d
    public final MemberScope i() {
        if (j() instanceof a) {
            return ((a) j()).i();
        }
        return j();
    }

    @k.e.a.d
    public abstract MemberScope j();
}
