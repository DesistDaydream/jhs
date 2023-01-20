package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.a2.d1;
import h.a2.t;
import h.a2.u;
import h.a2.y;
import h.k2.u.l;
import h.k2.v.f0;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.a.v.i.c;
import h.p2.b0.g.t.e.a.x.g;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.p.b;
import h.t1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class LazyJavaStaticClassScope extends c {
    @d
    private final g n;
    @d
    private final LazyJavaClassDescriptor o;

    /* loaded from: classes3.dex */
    public static final class a extends b.AbstractC0472b<h.p2.b0.g.t.c.d, t1> {
        public final /* synthetic */ h.p2.b0.g.t.c.d a;
        public final /* synthetic */ Set<R> b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l<MemberScope, Collection<R>> f16551c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(h.p2.b0.g.t.c.d dVar, Set<R> set, l<? super MemberScope, ? extends Collection<? extends R>> lVar) {
            this.a = dVar;
            this.b = set;
            this.f16551c = lVar;
        }

        @Override // h.p2.b0.g.t.p.b.e
        public /* bridge */ /* synthetic */ Object a() {
            e();
            return t1.a;
        }

        @Override // h.p2.b0.g.t.p.b.AbstractC0472b, h.p2.b0.g.t.p.b.e
        /* renamed from: d */
        public boolean c(@d h.p2.b0.g.t.c.d dVar) {
            if (dVar == this.a) {
                return true;
            }
            MemberScope k0 = dVar.k0();
            if (k0 instanceof c) {
                this.b.addAll((Collection) this.f16551c.invoke(k0));
                return false;
            }
            return true;
        }

        public void e() {
        }
    }

    public LazyJavaStaticClassScope(@d e eVar, @d g gVar, @d LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        super(eVar);
        this.n = gVar;
        this.o = lazyJavaClassDescriptor;
    }

    private final <R> Set<R> O(h.p2.b0.g.t.c.d dVar, Set<R> set, l<? super MemberScope, ? extends Collection<? extends R>> lVar) {
        b.b(t.k(dVar), LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1.a, new a(dVar, set, lVar));
        return set;
    }

    private final j0 Q(j0 j0Var) {
        if (j0Var.i().isReal()) {
            return j0Var;
        }
        Collection<? extends j0> d2 = j0Var.d();
        ArrayList arrayList = new ArrayList(u.Y(d2, 10));
        for (j0 j0Var2 : d2) {
            arrayList.add(Q(j0Var2));
        }
        return (j0) CollectionsKt___CollectionsKt.U4(CollectionsKt___CollectionsKt.N1(arrayList));
    }

    private final Set<n0> R(f fVar, h.p2.b0.g.t.c.d dVar) {
        LazyJavaStaticClassScope b = h.p2.b0.g.t.e.a.u.g.b(dVar);
        return b == null ? d1.k() : CollectionsKt___CollectionsKt.N5(b.a(fVar, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @d
    /* renamed from: N */
    public ClassDeclaredMemberIndex q() {
        return new ClassDeclaredMemberIndex(this.n, LazyJavaStaticClassScope$computeMemberIndex$1.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @d
    /* renamed from: P */
    public LazyJavaClassDescriptor D() {
        return this.o;
    }

    @Override // h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
    @k.e.a.e
    public h.p2.b0.g.t.c.f f(@d f fVar, @d h.p2.b0.g.t.d.b.b bVar) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @d
    public Set<f> m(@d h.p2.b0.g.t.k.r.d dVar, @k.e.a.e l<? super f, Boolean> lVar) {
        return d1.k();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @d
    public Set<f> o(@d h.p2.b0.g.t.k.r.d dVar, @k.e.a.e l<? super f, Boolean> lVar) {
        Set<f> M5 = CollectionsKt___CollectionsKt.M5(z().invoke().a());
        LazyJavaStaticClassScope b = h.p2.b0.g.t.e.a.u.g.b(D());
        Set<f> b2 = b == null ? null : b.b();
        if (b2 == null) {
            b2 = d1.k();
        }
        M5.addAll(b2);
        if (this.n.w()) {
            M5.addAll(CollectionsKt__CollectionsKt.L(h.p2.b0.g.t.b.g.f15025c, h.p2.b0.g.t.b.g.b));
        }
        M5.addAll(x().a().w().a(D()));
        return M5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void p(@d Collection<n0> collection, @d f fVar) {
        x().a().w().c(D(), fVar, collection);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void s(@d Collection<n0> collection, @d f fVar) {
        collection.addAll(h.p2.b0.g.t.e.a.t.a.e(fVar, R(fVar, D()), collection, D(), x().a().c(), x().a().k().a()));
        if (this.n.w()) {
            if (f0.g(fVar, h.p2.b0.g.t.b.g.f15025c)) {
                collection.add(h.p2.b0.g.t.k.b.d(D()));
            } else if (f0.g(fVar, h.p2.b0.g.t.b.g.b)) {
                collection.add(h.p2.b0.g.t.k.b.e(D()));
            }
        }
    }

    @Override // h.p2.b0.g.t.e.a.v.i.c, kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void t(@d f fVar, @d Collection<j0> collection) {
        Set O = O(D(), new LinkedHashSet(), new LazyJavaStaticClassScope$computeNonDeclaredProperties$propertiesFromSupertypes$1(fVar));
        if (!collection.isEmpty()) {
            collection.addAll(h.p2.b0.g.t.e.a.t.a.e(fVar, O, collection, D(), x().a().c(), x().a().k().a()));
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : O) {
            j0 Q = Q((j0) obj);
            Object obj2 = linkedHashMap.get(Q);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(Q, obj2);
            }
            ((List) obj2).add(obj);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            y.q0(arrayList, h.p2.b0.g.t.e.a.t.a.e(fVar, (Collection) entry.getValue(), collection, D(), x().a().c(), x().a().k().a()));
        }
        collection.addAll(arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @d
    public Set<f> u(@d h.p2.b0.g.t.k.r.d dVar, @k.e.a.e l<? super f, Boolean> lVar) {
        Set<f> M5 = CollectionsKt___CollectionsKt.M5(z().invoke().c());
        O(D(), M5, LazyJavaStaticClassScope$computePropertyNames$1$1.INSTANCE);
        return M5;
    }
}
