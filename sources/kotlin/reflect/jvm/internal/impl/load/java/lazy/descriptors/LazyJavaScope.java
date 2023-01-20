package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.umeng.analytics.pro.am;
import h.a2.i0;
import h.a2.s0;
import h.k2.v.f0;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.e.a.s;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.a.x.a0;
import h.p2.b0.g.t.e.a.x.x;
import h.p2.b0.g.t.e.a.x.y;
import h.p2.b0.g.t.e.b.r;
import h.p2.b0.g.t.k.c;
import h.p2.b0.g.t.k.r.c;
import h.p2.b0.g.t.k.r.f;
import h.p2.b0.g.t.m.g;
import h.p2.b0.g.t.m.h;
import h.p2.b0.g.t.m.l;
import h.p2.b0.g.t.n.y0;
import h.p2.b0.g.t.n.z;
import h.p2.n;
import h.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k.e.a.d;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;

/* loaded from: classes3.dex */
public abstract class LazyJavaScope extends f {

    /* renamed from: m  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f16536m = {n0.r(new PropertyReference1Impl(n0.d(LazyJavaScope.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), n0.r(new PropertyReference1Impl(n0.d(LazyJavaScope.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), n0.r(new PropertyReference1Impl(n0.d(LazyJavaScope.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    @d
    private final e b;
    @k.e.a.e

    /* renamed from: c  reason: collision with root package name */
    private final LazyJavaScope f16537c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final h<Collection<k>> f16538d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final h<h.p2.b0.g.t.e.a.v.i.a> f16539e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final h.p2.b0.g.t.m.f<h.p2.b0.g.t.g.f, Collection<h.p2.b0.g.t.c.n0>> f16540f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private final g<h.p2.b0.g.t.g.f, j0> f16541g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private final h.p2.b0.g.t.m.f<h.p2.b0.g.t.g.f, Collection<h.p2.b0.g.t.c.n0>> f16542h;
    @d

    /* renamed from: i  reason: collision with root package name */
    private final h f16543i;
    @d

    /* renamed from: j  reason: collision with root package name */
    private final h f16544j;
    @d

    /* renamed from: k  reason: collision with root package name */
    private final h f16545k;
    @d

    /* renamed from: l  reason: collision with root package name */
    private final h.p2.b0.g.t.m.f<h.p2.b0.g.t.g.f, List<j0>> f16546l;

    /* loaded from: classes3.dex */
    public static final class a {
        @d
        private final z a;
        @k.e.a.e
        private final z b;
        @d

        /* renamed from: c  reason: collision with root package name */
        private final List<v0> f16547c;
        @d

        /* renamed from: d  reason: collision with root package name */
        private final List<t0> f16548d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f16549e;
        @d

        /* renamed from: f  reason: collision with root package name */
        private final List<String> f16550f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@d z zVar, @k.e.a.e z zVar2, @d List<? extends v0> list, @d List<? extends t0> list2, boolean z, @d List<String> list3) {
            this.a = zVar;
            this.b = zVar2;
            this.f16547c = list;
            this.f16548d = list2;
            this.f16549e = z;
            this.f16550f = list3;
        }

        @d
        public final List<String> a() {
            return this.f16550f;
        }

        public final boolean b() {
            return this.f16549e;
        }

        @k.e.a.e
        public final z c() {
            return this.b;
        }

        @d
        public final z d() {
            return this.a;
        }

        @d
        public final List<t0> e() {
            return this.f16548d;
        }

        public boolean equals(@k.e.a.e Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return f0.g(this.a, aVar.a) && f0.g(this.b, aVar.b) && f0.g(this.f16547c, aVar.f16547c) && f0.g(this.f16548d, aVar.f16548d) && this.f16549e == aVar.f16549e && f0.g(this.f16550f, aVar.f16550f);
            }
            return false;
        }

        @d
        public final List<v0> f() {
            return this.f16547c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            z zVar = this.b;
            int hashCode2 = (((((hashCode + (zVar == null ? 0 : zVar.hashCode())) * 31) + this.f16547c.hashCode()) * 31) + this.f16548d.hashCode()) * 31;
            boolean z = this.f16549e;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            return ((hashCode2 + i2) * 31) + this.f16550f.hashCode();
        }

        @d
        public String toString() {
            return "MethodSignatureData(returnType=" + this.a + ", receiverType=" + this.b + ", valueParameters=" + this.f16547c + ", typeParameters=" + this.f16548d + ", hasStableParameterNames=" + this.f16549e + ", errors=" + this.f16550f + ')';
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        @d
        private final List<v0> a;
        private final boolean b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@d List<? extends v0> list, boolean z) {
            this.a = list;
            this.b = z;
        }

        @d
        public final List<v0> a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    public /* synthetic */ LazyJavaScope(e eVar, LazyJavaScope lazyJavaScope, int i2, u uVar) {
        this(eVar, (i2 & 2) != 0 ? null : lazyJavaScope);
    }

    private final Set<h.p2.b0.g.t.g.f> B() {
        return (Set) l.a(this.f16543i, this, f16536m[0]);
    }

    private final Set<h.p2.b0.g.t.g.f> E() {
        return (Set) l.a(this.f16544j, this, f16536m[1]);
    }

    private final z F(h.p2.b0.g.t.e.a.x.n nVar) {
        boolean z = false;
        z n = this.b.g().n(nVar.getType(), JavaTypeResolverKt.f(TypeUsage.COMMON, false, null, 3, null));
        if ((h.p2.b0.g.t.b.f.p0(n) || h.p2.b0.g.t.b.f.s0(n)) && G(nVar) && nVar.O()) {
            z = true;
        }
        return z ? y0.n(n) : n;
    }

    private final boolean G(h.p2.b0.g.t.e.a.x.n nVar) {
        return nVar.isFinal() && nVar.Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final j0 K(h.p2.b0.g.t.e.a.x.n nVar) {
        h.p2.b0.g.t.c.d1.z v = v(nVar);
        v.R0(null, null, null, null);
        v.W0(F(nVar), CollectionsKt__CollectionsKt.E(), A(), null);
        if (c.K(v, v.getType())) {
            v.H0(this.b.e().e(new LazyJavaScope$resolveProperty$1(this, nVar, v)));
        }
        this.b.a().h().b(nVar, v);
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(Set<h.p2.b0.g.t.c.n0> set) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : set) {
            String c2 = r.c((h.p2.b0.g.t.c.n0) obj, false, false, 2, null);
            Object obj2 = linkedHashMap.get(c2);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(c2, obj2);
            }
            ((List) obj2).add(obj);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                Collection<? extends h.p2.b0.g.t.c.n0> a2 = OverridingUtilsKt.a(list, LazyJavaScope$retainMostSpecificMethods$mostSpecificMethods$1.INSTANCE);
                set.removeAll(list);
                set.addAll(a2);
            }
        }
    }

    private final h.p2.b0.g.t.c.d1.z v(h.p2.b0.g.t.e.a.x.n nVar) {
        return h.p2.b0.g.t.e.a.u.e.Y0(D(), h.p2.b0.g.t.e.a.v.d.a(this.b, nVar), Modality.FINAL, s.a(nVar.getVisibility()), !nVar.isFinal(), nVar.getName(), this.b.a().t().a(nVar), G(nVar));
    }

    private final Set<h.p2.b0.g.t.g.f> y() {
        return (Set) l.a(this.f16545k, this, f16536m[2]);
    }

    @k.e.a.e
    public abstract m0 A();

    @k.e.a.e
    public final LazyJavaScope C() {
        return this.f16537c;
    }

    @d
    public abstract k D();

    public boolean H(@d JavaMethodDescriptor javaMethodDescriptor) {
        return true;
    }

    @d
    public abstract a I(@d h.p2.b0.g.t.e.a.x.r rVar, @d List<? extends t0> list, @d z zVar, @d List<? extends v0> list2);

    @d
    public final JavaMethodDescriptor J(@d h.p2.b0.g.t.e.a.x.r rVar) {
        Map<? extends a.InterfaceC0434a<?>, ?> z;
        JavaMethodDescriptor l1 = JavaMethodDescriptor.l1(D(), h.p2.b0.g.t.e.a.v.d.a(this.b, rVar), rVar.getName(), this.b.a().t().a(rVar), this.f16539e.invoke().e(rVar.getName()) != null && rVar.h().isEmpty());
        e f2 = ContextKt.f(this.b, l1, rVar, 0, 4, null);
        List<y> typeParameters = rVar.getTypeParameters();
        List<? extends t0> arrayList = new ArrayList<>(h.a2.u.Y(typeParameters, 10));
        for (y yVar : typeParameters) {
            arrayList.add(f2.f().a(yVar));
        }
        b L = L(f2, l1, rVar.h());
        a I = I(rVar, arrayList, r(rVar, f2), L.a());
        z c2 = I.c();
        m0 f3 = c2 == null ? null : h.p2.b0.g.t.k.b.f(l1, c2, h.p2.b0.g.t.c.b1.e.w0.b());
        m0 A = A();
        List<t0> e2 = I.e();
        List<v0> f4 = I.f();
        z d2 = I.d();
        Modality a2 = Modality.Companion.a(false, rVar.isAbstract(), !rVar.isFinal());
        h.p2.b0.g.t.c.s a3 = s.a(rVar.getVisibility());
        if (I.c() != null) {
            z = s0.k(z0.a(JavaMethodDescriptor.F, CollectionsKt___CollectionsKt.o2(L.a())));
        } else {
            z = h.a2.t0.z();
        }
        l1.k1(f3, A, e2, f4, d2, a2, a3, z);
        l1.o1(I.b(), L.b());
        if (!I.a().isEmpty()) {
            f2.a().s().b(l1, I.a());
        }
        return l1;
    }

    @d
    public final b L(@d e eVar, @d v vVar, @d List<? extends a0> list) {
        Pair a2;
        h.p2.b0.g.t.g.f name;
        Iterable<i0> U5 = CollectionsKt___CollectionsKt.U5(list);
        ArrayList arrayList = new ArrayList(h.a2.u.Y(U5, 10));
        boolean z = false;
        boolean z2 = false;
        for (i0 i0Var : U5) {
            int a3 = i0Var.a();
            a0 a0Var = (a0) i0Var.b();
            h.p2.b0.g.t.c.b1.e a4 = h.p2.b0.g.t.e.a.v.d.a(eVar, a0Var);
            h.p2.b0.g.t.e.a.v.j.a f2 = JavaTypeResolverKt.f(TypeUsage.COMMON, z, null, 3, null);
            if (a0Var.k()) {
                x type = a0Var.getType();
                h.p2.b0.g.t.e.a.x.f fVar = type instanceof h.p2.b0.g.t.e.a.x.f ? (h.p2.b0.g.t.e.a.x.f) type : null;
                if (fVar != null) {
                    z j2 = eVar.g().j(fVar, f2, true);
                    a2 = z0.a(j2, eVar.d().k().k(j2));
                } else {
                    throw new AssertionError(f0.C("Vararg parameter should be an array: ", a0Var));
                }
            } else {
                a2 = z0.a(eVar.g().n(a0Var.getType(), f2), null);
            }
            z zVar = (z) a2.component1();
            z zVar2 = (z) a2.component2();
            if (f0.g(vVar.getName().b(), "equals") && list.size() == 1 && f0.g(eVar.d().k().I(), zVar)) {
                name = h.p2.b0.g.t.g.f.f("other");
            } else {
                name = a0Var.getName();
                if (name == null) {
                    z2 = true;
                }
                if (name == null) {
                    name = h.p2.b0.g.t.g.f.f(f0.C(am.ax, Integer.valueOf(a3)));
                }
            }
            arrayList.add(new ValueParameterDescriptorImpl(vVar, null, a3, a4, name, zVar, false, false, false, zVar2, eVar.a().t().a(a0Var)));
            z = false;
        }
        return new b(CollectionsKt___CollectionsKt.I5(arrayList), z2);
    }

    @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, h.p2.b0.g.t.k.r.h
    @d
    public Collection<h.p2.b0.g.t.c.n0> a(@d h.p2.b0.g.t.g.f fVar, @d h.p2.b0.g.t.d.b.b bVar) {
        return !b().contains(fVar) ? CollectionsKt__CollectionsKt.E() : this.f16542h.invoke(fVar);
    }

    @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @d
    public Set<h.p2.b0.g.t.g.f> b() {
        return B();
    }

    @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @d
    public Collection<j0> c(@d h.p2.b0.g.t.g.f fVar, @d h.p2.b0.g.t.d.b.b bVar) {
        return !d().contains(fVar) ? CollectionsKt__CollectionsKt.E() : this.f16546l.invoke(fVar);
    }

    @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @d
    public Set<h.p2.b0.g.t.g.f> d() {
        return E();
    }

    @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @d
    public Set<h.p2.b0.g.t.g.f> e() {
        return y();
    }

    @Override // h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
    @d
    public Collection<k> g(@d h.p2.b0.g.t.k.r.d dVar, @d h.k2.u.l<? super h.p2.b0.g.t.g.f, Boolean> lVar) {
        return this.f16538d.invoke();
    }

    @d
    public abstract Set<h.p2.b0.g.t.g.f> m(@d h.p2.b0.g.t.k.r.d dVar, @k.e.a.e h.k2.u.l<? super h.p2.b0.g.t.g.f, Boolean> lVar);

    @d
    public final List<k> n(@d h.p2.b0.g.t.k.r.d dVar, @d h.k2.u.l<? super h.p2.b0.g.t.g.f, Boolean> lVar) {
        NoLookupLocation noLookupLocation = NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (dVar.a(h.p2.b0.g.t.k.r.d.f15480c.c())) {
            for (h.p2.b0.g.t.g.f fVar : m(dVar, lVar)) {
                if (lVar.invoke(fVar).booleanValue()) {
                    h.p2.b0.g.t.p.a.a(linkedHashSet, f(fVar, noLookupLocation));
                }
            }
        }
        if (dVar.a(h.p2.b0.g.t.k.r.d.f15480c.d()) && !dVar.l().contains(c.a.a)) {
            for (h.p2.b0.g.t.g.f fVar2 : o(dVar, lVar)) {
                if (lVar.invoke(fVar2).booleanValue()) {
                    linkedHashSet.addAll(a(fVar2, noLookupLocation));
                }
            }
        }
        if (dVar.a(h.p2.b0.g.t.k.r.d.f15480c.i()) && !dVar.l().contains(c.a.a)) {
            for (h.p2.b0.g.t.g.f fVar3 : u(dVar, lVar)) {
                if (lVar.invoke(fVar3).booleanValue()) {
                    linkedHashSet.addAll(c(fVar3, noLookupLocation));
                }
            }
        }
        return CollectionsKt___CollectionsKt.I5(linkedHashSet);
    }

    @d
    public abstract Set<h.p2.b0.g.t.g.f> o(@d h.p2.b0.g.t.k.r.d dVar, @k.e.a.e h.k2.u.l<? super h.p2.b0.g.t.g.f, Boolean> lVar);

    public void p(@d Collection<h.p2.b0.g.t.c.n0> collection, @d h.p2.b0.g.t.g.f fVar) {
    }

    @d
    public abstract h.p2.b0.g.t.e.a.v.i.a q();

    @d
    public final z r(@d h.p2.b0.g.t.e.a.x.r rVar, @d e eVar) {
        return eVar.g().n(rVar.getReturnType(), JavaTypeResolverKt.f(TypeUsage.COMMON, rVar.P().m(), null, 2, null));
    }

    public abstract void s(@d Collection<h.p2.b0.g.t.c.n0> collection, @d h.p2.b0.g.t.g.f fVar);

    public abstract void t(@d h.p2.b0.g.t.g.f fVar, @d Collection<j0> collection);

    @d
    public String toString() {
        return f0.C("Lazy scope for ", D());
    }

    @d
    public abstract Set<h.p2.b0.g.t.g.f> u(@d h.p2.b0.g.t.k.r.d dVar, @k.e.a.e h.k2.u.l<? super h.p2.b0.g.t.g.f, Boolean> lVar);

    @d
    public final h<Collection<k>> w() {
        return this.f16538d;
    }

    @d
    public final e x() {
        return this.b;
    }

    @d
    public final h<h.p2.b0.g.t.e.a.v.i.a> z() {
        return this.f16539e;
    }

    public LazyJavaScope(@d e eVar, @k.e.a.e LazyJavaScope lazyJavaScope) {
        this.b = eVar;
        this.f16537c = lazyJavaScope;
        this.f16538d = eVar.e().b(new LazyJavaScope$allDescriptors$1(this), CollectionsKt__CollectionsKt.E());
        this.f16539e = eVar.e().c(new LazyJavaScope$declaredMemberIndex$1(this));
        this.f16540f = eVar.e().i(new LazyJavaScope$declaredFunctions$1(this));
        this.f16541g = eVar.e().g(new LazyJavaScope$declaredField$1(this));
        this.f16542h = eVar.e().i(new LazyJavaScope$functions$1(this));
        this.f16543i = eVar.e().c(new LazyJavaScope$functionNamesLazy$2(this));
        this.f16544j = eVar.e().c(new LazyJavaScope$propertyNamesLazy$2(this));
        this.f16545k = eVar.e().c(new LazyJavaScope$classNamesLazy$2(this));
        this.f16546l = eVar.e().i(new LazyJavaScope$properties$1(this));
    }
}
