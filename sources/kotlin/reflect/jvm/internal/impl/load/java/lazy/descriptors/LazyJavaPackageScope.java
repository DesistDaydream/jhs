package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.a2.d1;
import h.k2.u.l;
import h.k2.v.f0;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.e.a.v.i.a;
import h.p2.b0.g.t.e.a.v.i.c;
import h.p2.b0.g.t.e.a.x.u;
import h.p2.b0.g.t.e.b.m;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.g.h;
import h.p2.b0.g.t.k.r.d;
import h.p2.b0.g.t.m.g;
import h.p2.b0.g.t.m.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;

/* loaded from: classes3.dex */
public final class LazyJavaPackageScope extends c {
    @d
    private final u n;
    @d
    private final LazyJavaPackageFragment o;
    @d
    private final i<Set<String>> p;
    @d
    private final g<a, h.p2.b0.g.t.c.d> q;

    /* loaded from: classes3.dex */
    public static final class a {
        @d
        private final f a;
        @e
        private final h.p2.b0.g.t.e.a.x.g b;

        public a(@d f fVar, @e h.p2.b0.g.t.e.a.x.g gVar) {
            this.a = fVar;
            this.b = gVar;
        }

        @e
        public final h.p2.b0.g.t.e.a.x.g a() {
            return this.b;
        }

        @d
        public final f b() {
            return this.a;
        }

        public boolean equals(@e Object obj) {
            return (obj instanceof a) && f0.g(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class b {

        /* loaded from: classes3.dex */
        public static final class a extends b {
            @d
            private final h.p2.b0.g.t.c.d a;

            public a(@d h.p2.b0.g.t.c.d dVar) {
                super(null);
                this.a = dVar;
            }

            @d
            public final h.p2.b0.g.t.c.d a() {
                return this.a;
            }
        }

        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0495b extends b {
            @d
            public static final C0495b a = new C0495b();

            private C0495b() {
                super(null);
            }
        }

        /* loaded from: classes3.dex */
        public static final class c extends b {
            @d
            public static final c a = new c();

            private c() {
                super(null);
            }
        }

        private b() {
        }

        public /* synthetic */ b(h.k2.v.u uVar) {
            this();
        }
    }

    public LazyJavaPackageScope(@d h.p2.b0.g.t.e.a.v.e eVar, @d u uVar, @d LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(eVar);
        this.n = uVar;
        this.o = lazyJavaPackageFragment;
        this.p = eVar.e().e(new LazyJavaPackageScope$knownClassNamesInPackage$1(eVar, this));
        this.q = eVar.e().g(new LazyJavaPackageScope$classes$1(this, eVar));
    }

    private final h.p2.b0.g.t.c.d O(f fVar, h.p2.b0.g.t.e.a.x.g gVar) {
        if (h.b(fVar)) {
            Set<String> invoke = this.p.invoke();
            if (gVar != null || invoke == null || invoke.contains(fVar.b())) {
                return this.q.invoke(new a(fVar, gVar));
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b S(m mVar) {
        if (mVar == null) {
            return b.C0495b.a;
        }
        if (mVar.c().c() == KotlinClassHeader.Kind.CLASS) {
            h.p2.b0.g.t.c.d l2 = x().a().b().l(mVar);
            return l2 != null ? new b.a(l2) : b.C0495b.a;
        }
        return b.c.a;
    }

    @e
    public final h.p2.b0.g.t.c.d P(@d h.p2.b0.g.t.e.a.x.g gVar) {
        return O(gVar.getName(), gVar);
    }

    @Override // h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
    @e
    /* renamed from: Q */
    public h.p2.b0.g.t.c.d f(@d f fVar, @d h.p2.b0.g.t.d.b.b bVar) {
        return O(fVar, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @d
    /* renamed from: R */
    public LazyJavaPackageFragment D() {
        return this.o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @d
    public Collection<j0> c(@d f fVar, @d h.p2.b0.g.t.d.b.b bVar) {
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
    @d
    public Collection<k> g(@d h.p2.b0.g.t.k.r.d dVar, @d l<? super f, Boolean> lVar) {
        d.a aVar = h.p2.b0.g.t.k.r.d.f15480c;
        if (!dVar.a(aVar.e() | aVar.c())) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : w().invoke()) {
            k kVar = (k) obj;
            if ((kVar instanceof h.p2.b0.g.t.c.d) && lVar.invoke(((h.p2.b0.g.t.c.d) kVar).getName()).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @k.e.a.d
    public Set<f> m(@k.e.a.d h.p2.b0.g.t.k.r.d dVar, @e l<? super f, Boolean> lVar) {
        if (dVar.a(h.p2.b0.g.t.k.r.d.f15480c.e())) {
            Set<String> invoke = this.p.invoke();
            if (invoke != null) {
                HashSet hashSet = new HashSet();
                for (String str : invoke) {
                    hashSet.add(f.f(str));
                }
                return hashSet;
            }
            u uVar = this.n;
            if (lVar == null) {
                lVar = FunctionsKt.a();
            }
            Collection<h.p2.b0.g.t.e.a.x.g> F = uVar.F(lVar);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (h.p2.b0.g.t.e.a.x.g gVar : F) {
                f name = gVar.L() == LightClassOriginKind.SOURCE ? null : gVar.getName();
                if (name != null) {
                    linkedHashSet.add(name);
                }
            }
            return linkedHashSet;
        }
        return d1.k();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @k.e.a.d
    public Set<f> o(@k.e.a.d h.p2.b0.g.t.k.r.d dVar, @e l<? super f, Boolean> lVar) {
        return d1.k();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @k.e.a.d
    public h.p2.b0.g.t.e.a.v.i.a q() {
        return a.C0444a.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void s(@k.e.a.d Collection<n0> collection, @k.e.a.d f fVar) {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @k.e.a.d
    public Set<f> u(@k.e.a.d h.p2.b0.g.t.k.r.d dVar, @e l<? super f, Boolean> lVar) {
        return d1.k();
    }
}
