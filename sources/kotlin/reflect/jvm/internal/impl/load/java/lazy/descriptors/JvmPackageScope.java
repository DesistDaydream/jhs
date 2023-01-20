package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.a2.d1;
import h.a2.y;
import h.k2.v.n0;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.d.b.b;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.a.x.u;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.k.r.g;
import h.p2.b0.g.t.m.h;
import h.p2.b0.g.t.m.l;
import h.p2.b0.g.t.o.k.a;
import h.p2.n;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import k.e.a.d;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class JvmPackageScope implements MemberScope {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f16511f = {n0.r(new PropertyReference1Impl(n0.d(JvmPackageScope.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    @d
    private final e b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final LazyJavaPackageFragment f16512c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final LazyJavaPackageScope f16513d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final h f16514e;

    public JvmPackageScope(@d e eVar, @d u uVar, @d LazyJavaPackageFragment lazyJavaPackageFragment) {
        this.b = eVar;
        this.f16512c = lazyJavaPackageFragment;
        this.f16513d = new LazyJavaPackageScope(eVar, uVar, lazyJavaPackageFragment);
        this.f16514e = eVar.e().c(new JvmPackageScope$kotlinScopes$2(this));
    }

    private final MemberScope[] l() {
        return (MemberScope[]) l.a(this.f16514e, this, f16511f[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, h.p2.b0.g.t.k.r.h
    @d
    public Collection<h.p2.b0.g.t.c.n0> a(@d f fVar, @d b bVar) {
        h(fVar, bVar);
        LazyJavaPackageScope lazyJavaPackageScope = this.f16513d;
        MemberScope[] l2 = l();
        Collection<? extends h.p2.b0.g.t.c.n0> a = lazyJavaPackageScope.a(fVar, bVar);
        int length = l2.length;
        int i2 = 0;
        Collection collection = a;
        while (i2 < length) {
            MemberScope memberScope = l2[i2];
            i2++;
            collection = a.a(collection, memberScope.a(fVar, bVar));
        }
        return collection == null ? d1.k() : collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @d
    public Set<f> b() {
        MemberScope[] l2 = l();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : l2) {
            y.q0(linkedHashSet, memberScope.b());
        }
        linkedHashSet.addAll(k().b());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @d
    public Collection<j0> c(@d f fVar, @d b bVar) {
        h(fVar, bVar);
        LazyJavaPackageScope lazyJavaPackageScope = this.f16513d;
        MemberScope[] l2 = l();
        Collection<? extends j0> c2 = lazyJavaPackageScope.c(fVar, bVar);
        int length = l2.length;
        int i2 = 0;
        Collection collection = c2;
        while (i2 < length) {
            MemberScope memberScope = l2[i2];
            i2++;
            collection = a.a(collection, memberScope.c(fVar, bVar));
        }
        return collection == null ? d1.k() : collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @d
    public Set<f> d() {
        MemberScope[] l2 = l();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : l2) {
            y.q0(linkedHashSet, memberScope.d());
        }
        linkedHashSet.addAll(k().d());
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @k.e.a.e
    public Set<f> e() {
        Set<f> a = g.a(ArraysKt___ArraysKt.Y4(l()));
        if (a == null) {
            return null;
        }
        a.addAll(k().e());
        return a;
    }

    @Override // h.p2.b0.g.t.k.r.h
    @k.e.a.e
    public h.p2.b0.g.t.c.f f(@d f fVar, @d b bVar) {
        h(fVar, bVar);
        h.p2.b0.g.t.c.d f2 = this.f16513d.f(fVar, bVar);
        if (f2 != null) {
            return f2;
        }
        MemberScope[] l2 = l();
        h.p2.b0.g.t.c.f fVar2 = null;
        int i2 = 0;
        int length = l2.length;
        while (i2 < length) {
            MemberScope memberScope = l2[i2];
            i2++;
            h.p2.b0.g.t.c.f f3 = memberScope.f(fVar, bVar);
            if (f3 != null) {
                if (!(f3 instanceof h.p2.b0.g.t.c.g) || !((h.p2.b0.g.t.c.g) f3).i0()) {
                    return f3;
                }
                if (fVar2 == null) {
                    fVar2 = f3;
                }
            }
        }
        return fVar2;
    }

    @Override // h.p2.b0.g.t.k.r.h
    @d
    public Collection<k> g(@d h.p2.b0.g.t.k.r.d dVar, @d h.k2.u.l<? super f, Boolean> lVar) {
        LazyJavaPackageScope lazyJavaPackageScope = this.f16513d;
        MemberScope[] l2 = l();
        Collection<k> g2 = lazyJavaPackageScope.g(dVar, lVar);
        int length = l2.length;
        int i2 = 0;
        while (i2 < length) {
            MemberScope memberScope = l2[i2];
            i2++;
            g2 = a.a(g2, memberScope.g(dVar, lVar));
        }
        return g2 == null ? d1.k() : g2;
    }

    @Override // h.p2.b0.g.t.k.r.h
    public void h(@d f fVar, @d b bVar) {
        h.p2.b0.g.t.d.a.b(this.b.a().l(), bVar, this.f16512c, fVar);
    }

    @d
    public final LazyJavaPackageScope k() {
        return this.f16513d;
    }
}
