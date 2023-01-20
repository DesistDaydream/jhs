package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.a2.e1;
import h.a2.y;
import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.u;
import h.p2.b0.g.t.c.c;
import h.p2.b0.g.t.c.d1.a0;
import h.p2.b0.g.t.c.d1.b0;
import h.p2.b0.g.t.c.j;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k0;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.e.a.m;
import h.p2.b0.g.t.e.a.o;
import h.p2.b0.g.t.e.a.p;
import h.p2.b0.g.t.e.a.s;
import h.p2.b0.g.t.e.a.t.a;
import h.p2.b0.g.t.e.a.t.e;
import h.p2.b0.g.t.e.a.u.b;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.a.x.g;
import h.p2.b0.g.t.e.a.x.k;
import h.p2.b0.g.t.e.a.x.n;
import h.p2.b0.g.t.e.a.x.w;
import h.p2.b0.g.t.e.a.x.x;
import h.p2.b0.g.t.e.b.r;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.m.h;
import h.p2.b0.g.t.n.y0;
import h.p2.b0.g.t.n.z;
import h.p2.b0.g.t.p.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k.e.a.d;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;

/* loaded from: classes3.dex */
public final class LazyJavaClassMemberScope extends LazyJavaScope {
    @d
    private final h.p2.b0.g.t.c.d n;
    @d
    private final g o;
    private final boolean p;
    @d
    private final h<List<c>> q;
    @d
    private final h<Set<f>> r;
    @d
    private final h<Map<f, n>> s;
    @d
    private final h.p2.b0.g.t.m.g<f, h.p2.b0.g.t.c.d1.f> t;

    public /* synthetic */ LazyJavaClassMemberScope(e eVar, h.p2.b0.g.t.c.d dVar, g gVar, boolean z, LazyJavaClassMemberScope lazyJavaClassMemberScope, int i2, u uVar) {
        this(eVar, dVar, gVar, z, (i2 & 16) != 0 ? null : lazyJavaClassMemberScope);
    }

    private final Set<j0> A0(f fVar) {
        Collection<z> c0 = c0();
        ArrayList arrayList = new ArrayList();
        for (z zVar : c0) {
            Collection<? extends j0> c2 = zVar.q().c(fVar, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            ArrayList arrayList2 = new ArrayList(h.a2.u.Y(c2, 10));
            for (j0 j0Var : c2) {
                arrayList2.add(j0Var);
            }
            y.q0(arrayList, arrayList2);
        }
        return CollectionsKt___CollectionsKt.N5(arrayList);
    }

    private final boolean B0(n0 n0Var, v vVar) {
        return f0.g(r.c(n0Var, false, false, 2, null), r.c(vVar.a(), false, false, 2, null)) && !p0(n0Var, vVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0065, code lost:
        if (h.p2.b0.g.t.e.a.o.c(r7.getName().b()) == false) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x006c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean C0(h.p2.b0.g.t.c.n0 r7) {
        /*
            r6 = this;
            h.p2.b0.g.t.g.f r0 = r7.getName()
            java.util.List r0 = h.p2.b0.g.t.e.a.r.a(r0)
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L16
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L16
        L14:
            r0 = 0
            goto L70
        L16:
            java.util.Iterator r0 = r0.iterator()
        L1a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L14
            java.lang.Object r1 = r0.next()
            h.p2.b0.g.t.g.f r1 = (h.p2.b0.g.t.g.f) r1
            java.util.Set r1 = r6.A0(r1)
            boolean r4 = r1 instanceof java.util.Collection
            if (r4 == 0) goto L36
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto L36
        L34:
            r1 = 0
            goto L6d
        L36:
            java.util.Iterator r1 = r1.iterator()
        L3a:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L34
            java.lang.Object r4 = r1.next()
            h.p2.b0.g.t.c.j0 r4 = (h.p2.b0.g.t.c.j0) r4
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1 r5 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$isVisibleAsFunctionInCurrentClass$1$1$1
            r5.<init>(r7, r6)
            boolean r5 = r6.o0(r4, r5)
            if (r5 == 0) goto L69
            boolean r4 = r4.O()
            if (r4 != 0) goto L67
            h.p2.b0.g.t.e.a.o r4 = h.p2.b0.g.t.e.a.o.a
            h.p2.b0.g.t.g.f r4 = r7.getName()
            java.lang.String r4 = r4.b()
            boolean r4 = h.p2.b0.g.t.e.a.o.c(r4)
            if (r4 != 0) goto L69
        L67:
            r4 = 1
            goto L6a
        L69:
            r4 = 0
        L6a:
            if (r4 == 0) goto L3a
            r1 = 1
        L6d:
            if (r1 == 0) goto L1a
            r0 = 1
        L70:
            if (r0 == 0) goto L73
            return r3
        L73:
            boolean r0 = r6.q0(r7)
            if (r0 != 0) goto L86
            boolean r0 = r6.K0(r7)
            if (r0 != 0) goto L86
            boolean r7 = r6.s0(r7)
            if (r7 != 0) goto L86
            goto L87
        L86:
            r2 = 0
        L87:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.C0(h.p2.b0.g.t.c.n0):boolean");
    }

    private final n0 D0(n0 n0Var, l<? super f, ? extends Collection<? extends n0>> lVar, Collection<? extends n0> collection) {
        n0 h0;
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.n;
        v k2 = BuiltinMethodsWithSpecialGenericSignature.k(n0Var);
        if (k2 == null || (h0 = h0(k2, lVar)) == null) {
            return null;
        }
        if (!C0(h0)) {
            h0 = null;
        }
        if (h0 == null) {
            return null;
        }
        return g0(h0, k2, collection);
    }

    private final n0 E0(n0 n0Var, l<? super f, ? extends Collection<? extends n0>> lVar, f fVar, Collection<? extends n0> collection) {
        n0 n0Var2 = (n0) SpecialBuiltinMembers.d(n0Var);
        if (n0Var2 == null) {
            return null;
        }
        for (n0 n0Var3 : lVar.invoke(f.f(SpecialBuiltinMembers.b(n0Var2)))) {
            n0 m0 = m0(n0Var3, fVar);
            if (r0(n0Var2, m0)) {
                return g0(m0, n0Var2, collection);
            }
        }
        return null;
    }

    private final n0 F0(n0 n0Var, l<? super f, ? extends Collection<? extends n0>> lVar) {
        if (n0Var.isSuspend()) {
            for (n0 n0Var2 : lVar.invoke(n0Var.getName())) {
                n0 n0 = n0(n0Var2);
                if (n0 == null || !p0(n0, n0Var)) {
                    n0 = null;
                    continue;
                }
                if (n0 != null) {
                    return n0;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b G0(k kVar) {
        h.p2.b0.g.t.c.d D = D();
        b o1 = b.o1(D, h.p2.b0.g.t.e.a.v.d.a(x(), kVar), false, x().a().t().a(kVar));
        e e2 = ContextKt.e(x(), o1, kVar, D.s().size());
        LazyJavaScope.b L = L(e2, o1, kVar.h());
        List<t0> s = D.s();
        List<h.p2.b0.g.t.e.a.x.y> typeParameters = kVar.getTypeParameters();
        ArrayList arrayList = new ArrayList(h.a2.u.Y(typeParameters, 10));
        for (h.p2.b0.g.t.e.a.x.y yVar : typeParameters) {
            arrayList.add(e2.f().a(yVar));
        }
        o1.m1(L.a(), s.a(kVar.getVisibility()), CollectionsKt___CollectionsKt.q4(s, arrayList));
        o1.U0(false);
        o1.V0(L.b());
        o1.c1(D.r());
        e2.a().h().a(kVar, o1);
        return o1;
    }

    private final JavaMethodDescriptor H0(w wVar) {
        JavaMethodDescriptor l1 = JavaMethodDescriptor.l1(D(), h.p2.b0.g.t.e.a.v.d.a(x(), wVar), wVar.getName(), x().a().t().a(wVar), true);
        l1.k1(null, A(), CollectionsKt__CollectionsKt.E(), CollectionsKt__CollectionsKt.E(), x().g().n(wVar.getType(), JavaTypeResolverKt.f(TypeUsage.COMMON, false, null, 2, null)), Modality.Companion.a(false, false, true), h.p2.b0.g.t.c.r.f15211e, null);
        l1.o1(false, false);
        x().a().h().c(wVar, l1);
        return l1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<n0> I0(f fVar) {
        Collection<h.p2.b0.g.t.e.a.x.r> d2 = z().invoke().d(fVar);
        ArrayList arrayList = new ArrayList(h.a2.u.Y(d2, 10));
        for (h.p2.b0.g.t.e.a.x.r rVar : d2) {
            arrayList.add(J(rVar));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x000d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Collection<h.p2.b0.g.t.c.n0> J0(h.p2.b0.g.t.g.f r5) {
        /*
            r4 = this;
            java.util.Set r5 = r4.y0(r5)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
        Ld:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L32
            java.lang.Object r1 = r5.next()
            r2 = r1
            h.p2.b0.g.t.c.n0 r2 = (h.p2.b0.g.t.c.n0) r2
            boolean r3 = kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.a(r2)
            if (r3 != 0) goto L2b
            kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature r3 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.n
            h.p2.b0.g.t.c.v r2 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.k(r2)
            if (r2 == 0) goto L29
            goto L2b
        L29:
            r2 = 0
            goto L2c
        L2b:
            r2 = 1
        L2c:
            if (r2 != 0) goto Ld
            r0.add(r1)
            goto Ld
        L32:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.J0(h.p2.b0.g.t.g.f):java.util.Collection");
    }

    private final boolean K0(n0 n0Var) {
        if (BuiltinMethodsWithSpecialGenericSignature.n.l(n0Var.getName())) {
            Set<n0> y0 = y0(n0Var.getName());
            ArrayList<v> arrayList = new ArrayList();
            for (n0 n0Var2 : y0) {
                BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.n;
                v k2 = BuiltinMethodsWithSpecialGenericSignature.k(n0Var2);
                if (k2 != null) {
                    arrayList.add(k2);
                }
            }
            if (arrayList.isEmpty()) {
                return false;
            }
            for (v vVar : arrayList) {
                if (B0(n0Var, vVar)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private final void V(List<v0> list, j jVar, int i2, h.p2.b0.g.t.e.a.x.r rVar, z zVar, z zVar2) {
        list.add(new ValueParameterDescriptorImpl(jVar, null, i2, h.p2.b0.g.t.c.b1.e.w0.b(), rVar.getName(), y0.n(zVar), rVar.N(), false, false, zVar2 == null ? null : y0.n(zVar2), x().a().t().a(rVar)));
    }

    private final void W(Collection<n0> collection, f fVar, Collection<? extends n0> collection2, boolean z) {
        Collection<? extends n0> d2 = a.d(fVar, collection2, collection, D(), x().a().c(), x().a().k().a());
        if (!z) {
            collection.addAll(d2);
            return;
        }
        List q4 = CollectionsKt___CollectionsKt.q4(collection, d2);
        ArrayList arrayList = new ArrayList(h.a2.u.Y(d2, 10));
        for (n0 n0Var : d2) {
            n0 n0Var2 = (n0) SpecialBuiltinMembers.e(n0Var);
            if (n0Var2 != null) {
                n0Var = g0(n0Var, n0Var2, q4);
            }
            arrayList.add(n0Var);
        }
        collection.addAll(arrayList);
    }

    private final void X(f fVar, Collection<? extends n0> collection, Collection<? extends n0> collection2, Collection<n0> collection3, l<? super f, ? extends Collection<? extends n0>> lVar) {
        for (n0 n0Var : collection2) {
            h.p2.b0.g.t.p.a.a(collection3, E0(n0Var, lVar, fVar, collection));
            h.p2.b0.g.t.p.a.a(collection3, D0(n0Var, lVar, collection));
            h.p2.b0.g.t.p.a.a(collection3, F0(n0Var, lVar));
        }
    }

    private final void Y(Set<? extends j0> set, Collection<j0> collection, Set<j0> set2, l<? super f, ? extends Collection<? extends n0>> lVar) {
        for (j0 j0Var : set) {
            h.p2.b0.g.t.e.a.u.e i0 = i0(j0Var, lVar);
            if (i0 != null) {
                collection.add(i0);
                if (set2 == null) {
                    return;
                }
                set2.add(j0Var);
                return;
            }
        }
    }

    private final void Z(f fVar, Collection<j0> collection) {
        h.p2.b0.g.t.e.a.x.r rVar = (h.p2.b0.g.t.e.a.x.r) CollectionsKt___CollectionsKt.V4(z().invoke().d(fVar));
        if (rVar == null) {
            return;
        }
        collection.add(k0(this, rVar, null, Modality.FINAL, 2, null));
    }

    private final Collection<z> c0() {
        return this.p ? D().j().j() : x().a().k().c().f(D());
    }

    private final List<v0> d0(h.p2.b0.g.t.c.d1.e eVar) {
        Pair pair;
        Collection<h.p2.b0.g.t.e.a.x.r> B = this.o.B();
        ArrayList arrayList = new ArrayList(B.size());
        h.p2.b0.g.t.e.a.v.j.a f2 = JavaTypeResolverKt.f(TypeUsage.COMMON, true, null, 2, null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : B) {
            if (f0.g(((h.p2.b0.g.t.e.a.x.r) obj).getName(), p.f15244c)) {
                arrayList2.add(obj);
            } else {
                arrayList3.add(obj);
            }
        }
        Pair pair2 = new Pair(arrayList2, arrayList3);
        List list = (List) pair2.component1();
        List<h.p2.b0.g.t.e.a.x.r> list2 = (List) pair2.component2();
        list.size();
        h.p2.b0.g.t.e.a.x.r rVar = (h.p2.b0.g.t.e.a.x.r) CollectionsKt___CollectionsKt.t2(list);
        if (rVar != null) {
            x returnType = rVar.getReturnType();
            if (returnType instanceof h.p2.b0.g.t.e.a.x.f) {
                h.p2.b0.g.t.e.a.x.f fVar = (h.p2.b0.g.t.e.a.x.f) returnType;
                pair = new Pair(x().g().j(fVar, f2, true), x().g().n(fVar.l(), f2));
            } else {
                pair = new Pair(x().g().n(returnType, f2), null);
            }
            V(arrayList, eVar, 0, rVar, (z) pair.component1(), (z) pair.component2());
        }
        int i2 = 0;
        int i3 = rVar == null ? 0 : 1;
        for (h.p2.b0.g.t.e.a.x.r rVar2 : list2) {
            V(arrayList, eVar, i2 + i3, rVar2, x().g().n(rVar2.getReturnType(), f2), null);
            i2++;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c e0() {
        List<v0> emptyList;
        boolean m2 = this.o.m();
        if ((this.o.K() || !this.o.q()) && !m2) {
            return null;
        }
        h.p2.b0.g.t.c.d D = D();
        b o1 = b.o1(D, h.p2.b0.g.t.c.b1.e.w0.b(), true, x().a().t().a(this.o));
        if (m2) {
            emptyList = d0(o1);
        } else {
            emptyList = Collections.emptyList();
        }
        o1.V0(false);
        o1.l1(emptyList, w0(D));
        o1.U0(true);
        o1.c1(D.r());
        x().a().h().a(this.o, o1);
        return o1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c f0() {
        h.p2.b0.g.t.c.d D = D();
        b o1 = b.o1(D, h.p2.b0.g.t.c.b1.e.w0.b(), true, x().a().t().a(this.o));
        List<v0> l0 = l0(o1);
        o1.V0(false);
        o1.l1(l0, w0(D));
        o1.U0(false);
        o1.c1(D.r());
        return o1;
    }

    private final n0 g0(n0 n0Var, h.p2.b0.g.t.c.a aVar, Collection<? extends n0> collection) {
        boolean z;
        boolean z2 = false;
        if (!(collection instanceof Collection) || !collection.isEmpty()) {
            for (n0 n0Var2 : collection) {
                if (!f0.g(n0Var, n0Var2) && n0Var2.q0() == null && p0(n0Var2, aVar)) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
        }
        z2 = true;
        return z2 ? n0Var : n0Var.x().h().build();
    }

    private final n0 h0(v vVar, l<? super f, ? extends Collection<? extends n0>> lVar) {
        Object obj;
        Iterator<T> it = lVar.invoke(vVar.getName()).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (B0((n0) obj, vVar)) {
                break;
            }
        }
        n0 n0Var = (n0) obj;
        if (n0Var == null) {
            return null;
        }
        v.a<? extends n0> x = n0Var.x();
        List<v0> h2 = vVar.h();
        ArrayList arrayList = new ArrayList(h.a2.u.Y(h2, 10));
        for (v0 v0Var : h2) {
            arrayList.add(new h.p2.b0.g.t.e.a.u.h(v0Var.getType(), v0Var.x0()));
        }
        x.b(h.p2.b0.g.t.e.a.u.g.a(arrayList, n0Var.h(), vVar));
        x.s();
        x.k();
        return x.build();
    }

    private final h.p2.b0.g.t.e.a.u.e i0(j0 j0Var, l<? super f, ? extends Collection<? extends n0>> lVar) {
        b0 b0Var = null;
        if (o0(j0Var, lVar)) {
            n0 u0 = u0(j0Var, lVar);
            n0 v0 = j0Var.O() ? v0(j0Var, lVar) : null;
            if (v0 != null) {
                v0.t();
                u0.t();
            }
            h.p2.b0.g.t.e.a.u.d dVar = new h.p2.b0.g.t.e.a.u.d(D(), u0, v0, j0Var);
            dVar.W0(u0.getReturnType(), CollectionsKt__CollectionsKt.E(), A(), null);
            a0 h2 = h.p2.b0.g.t.k.b.h(dVar, u0.getAnnotations(), false, false, false, u0.getSource());
            h2.J0(u0);
            h2.M0(dVar.getType());
            if (v0 != null) {
                v0 v0Var = (v0) CollectionsKt___CollectionsKt.t2(v0.h());
                if (v0Var != null) {
                    b0Var = h.p2.b0.g.t.k.b.j(dVar, v0.getAnnotations(), v0Var.getAnnotations(), false, false, false, v0.getVisibility(), v0.getSource());
                    b0Var.J0(v0);
                } else {
                    throw new AssertionError(f0.C("No parameter found for ", v0));
                }
            }
            dVar.Q0(h2, b0Var);
            return dVar;
        }
        return null;
    }

    private final h.p2.b0.g.t.e.a.u.e j0(h.p2.b0.g.t.e.a.x.r rVar, z zVar, Modality modality) {
        h.p2.b0.g.t.e.a.u.e Y0 = h.p2.b0.g.t.e.a.u.e.Y0(D(), h.p2.b0.g.t.e.a.v.d.a(x(), rVar), modality, s.a(rVar.getVisibility()), false, rVar.getName(), x().a().t().a(rVar), false);
        a0 b = h.p2.b0.g.t.k.b.b(Y0, h.p2.b0.g.t.c.b1.e.w0.b());
        Y0.Q0(b, null);
        z r = zVar == null ? r(rVar, ContextKt.f(x(), Y0, rVar, 0, 4, null)) : zVar;
        Y0.W0(r, CollectionsKt__CollectionsKt.E(), A(), null);
        b.M0(r);
        return Y0;
    }

    public static /* synthetic */ h.p2.b0.g.t.e.a.u.e k0(LazyJavaClassMemberScope lazyJavaClassMemberScope, h.p2.b0.g.t.e.a.x.r rVar, z zVar, Modality modality, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            zVar = null;
        }
        return lazyJavaClassMemberScope.j0(rVar, zVar, modality);
    }

    private final List<v0> l0(h.p2.b0.g.t.c.d1.e eVar) {
        Collection<w> i2 = this.o.i();
        ArrayList arrayList = new ArrayList(i2.size());
        z zVar = null;
        h.p2.b0.g.t.e.a.v.j.a f2 = JavaTypeResolverKt.f(TypeUsage.COMMON, false, null, 2, null);
        int i3 = 0;
        for (w wVar : i2) {
            int i4 = i3 + 1;
            z n = x().g().n(wVar.getType(), f2);
            arrayList.add(new ValueParameterDescriptorImpl(eVar, null, i3, h.p2.b0.g.t.c.b1.e.w0.b(), wVar.getName(), n, false, false, false, wVar.k() ? x().a().m().k().k(n) : zVar, x().a().t().a(wVar)));
            i3 = i4;
            zVar = null;
        }
        return arrayList;
    }

    private final n0 m0(n0 n0Var, f fVar) {
        v.a<? extends n0> x = n0Var.x();
        x.i(fVar);
        x.s();
        x.k();
        return x.build();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
        if (h.p2.b0.g.t.b.h.a(r2, x().a().q().c()) == false) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final h.p2.b0.g.t.c.n0 n0(h.p2.b0.g.t.c.n0 r5) {
        /*
            r4 = this;
            java.util.List r0 = r5.h()
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.i3(r0)
            h.p2.b0.g.t.c.v0 r0 = (h.p2.b0.g.t.c.v0) r0
            r1 = 0
            if (r0 != 0) goto Lf
        Ld:
            r0 = r1
            goto L4c
        Lf:
            h.p2.b0.g.t.n.z r2 = r0.getType()
            h.p2.b0.g.t.n.q0 r2 = r2.I0()
            h.p2.b0.g.t.c.f r2 = r2.c()
            if (r2 != 0) goto L1f
            r2 = r1
            goto L23
        L1f:
            h.p2.b0.g.t.g.d r2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.j(r2)
        L23:
            if (r2 != 0) goto L27
        L25:
            r2 = r1
            goto L36
        L27:
            boolean r3 = r2.f()
            if (r3 == 0) goto L2e
            goto L2f
        L2e:
            r2 = r1
        L2f:
            if (r2 != 0) goto L32
            goto L25
        L32:
            h.p2.b0.g.t.g.c r2 = r2.l()
        L36:
            h.p2.b0.g.t.e.a.v.e r3 = r4.x()
            h.p2.b0.g.t.e.a.v.b r3 = r3.a()
            h.p2.b0.g.t.e.a.v.c r3 = r3.q()
            boolean r3 = r3.c()
            boolean r2 = h.p2.b0.g.t.b.h.a(r2, r3)
            if (r2 == 0) goto Ld
        L4c:
            if (r0 != 0) goto L4f
            return r1
        L4f:
            h.p2.b0.g.t.c.v$a r1 = r5.x()
            java.util.List r5 = r5.h()
            r2 = 1
            java.util.List r5 = kotlin.collections.CollectionsKt___CollectionsKt.Q1(r5, r2)
            h.p2.b0.g.t.c.v$a r5 = r1.b(r5)
            h.p2.b0.g.t.n.z r0 = r0.getType()
            java.util.List r0 = r0.H0()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            h.p2.b0.g.t.n.s0 r0 = (h.p2.b0.g.t.n.s0) r0
            h.p2.b0.g.t.n.z r0 = r0.getType()
            h.p2.b0.g.t.c.v$a r5 = r5.l(r0)
            h.p2.b0.g.t.c.v r5 = r5.build()
            h.p2.b0.g.t.c.n0 r5 = (h.p2.b0.g.t.c.n0) r5
            r0 = r5
            h.p2.b0.g.t.c.d1.d0 r0 = (h.p2.b0.g.t.c.d1.d0) r0
            if (r0 != 0) goto L83
            goto L86
        L83:
            r0.d1(r2)
        L86:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.n0(h.p2.b0.g.t.c.n0):h.p2.b0.g.t.c.n0");
    }

    private final boolean o0(j0 j0Var, l<? super f, ? extends Collection<? extends n0>> lVar) {
        if (h.p2.b0.g.t.e.a.v.i.b.a(j0Var)) {
            return false;
        }
        n0 u0 = u0(j0Var, lVar);
        n0 v0 = v0(j0Var, lVar);
        if (u0 == null) {
            return false;
        }
        if (j0Var.O()) {
            return v0 != null && v0.t() == u0.t();
        }
        return true;
    }

    private final boolean p0(h.p2.b0.g.t.c.a aVar, h.p2.b0.g.t.c.a aVar2) {
        return OverridingUtil.f16771d.G(aVar2, aVar, true).c() == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE && !m.a.a(aVar2, aVar);
    }

    private final boolean q0(n0 n0Var) {
        boolean z;
        List<f> b = SpecialGenericSignatures.a.b(n0Var.getName());
        if (!(b instanceof Collection) || !b.isEmpty()) {
            for (f fVar : b) {
                Set<n0> y0 = y0(fVar);
                ArrayList<n0> arrayList = new ArrayList();
                for (Object obj : y0) {
                    if (SpecialBuiltinMembers.a((n0) obj)) {
                        arrayList.add(obj);
                    }
                }
                if (!arrayList.isEmpty()) {
                    n0 m0 = m0(n0Var, fVar);
                    if (!arrayList.isEmpty()) {
                        for (n0 n0Var2 : arrayList) {
                            if (r0(n0Var2, m0)) {
                                z = true;
                                continue;
                                break;
                            }
                        }
                    }
                }
                z = false;
                continue;
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean r0(n0 n0Var, v vVar) {
        if (BuiltinMethodsWithDifferentJvmName.n.k(n0Var)) {
            vVar = vVar.a();
        }
        return p0(vVar, n0Var);
    }

    private final boolean s0(n0 n0Var) {
        boolean z;
        n0 n0 = n0(n0Var);
        if (n0 == null) {
            return false;
        }
        Set<n0> y0 = y0(n0Var.getName());
        if ((y0 instanceof Collection) && y0.isEmpty()) {
            return false;
        }
        for (n0 n0Var2 : y0) {
            if (n0Var2.isSuspend() && p0(n0, n0Var2)) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private final n0 t0(j0 j0Var, String str, l<? super f, ? extends Collection<? extends n0>> lVar) {
        n0 n0Var;
        Iterator<T> it = lVar.invoke(f.f(str)).iterator();
        do {
            n0Var = null;
            if (!it.hasNext()) {
                break;
            }
            n0 n0Var2 = (n0) it.next();
            if (n0Var2.h().size() == 0) {
                h.p2.b0.g.t.n.e1.f fVar = h.p2.b0.g.t.n.e1.f.a;
                z returnType = n0Var2.getReturnType();
                if (returnType == null ? false : fVar.d(returnType, j0Var.getType())) {
                    n0Var = n0Var2;
                    continue;
                } else {
                    continue;
                }
            }
        } while (n0Var == null);
        return n0Var;
    }

    private final n0 u0(j0 j0Var, l<? super f, ? extends Collection<? extends n0>> lVar) {
        k0 getter = j0Var.getGetter();
        k0 k0Var = getter == null ? null : (k0) SpecialBuiltinMembers.d(getter);
        String a = k0Var != null ? ClassicBuiltinSpecialProperties.a.a(k0Var) : null;
        if (a != null && !SpecialBuiltinMembers.f(D(), k0Var)) {
            return t0(j0Var, a, lVar);
        }
        o oVar = o.a;
        return t0(j0Var, o.a(j0Var.getName().b()), lVar);
    }

    private final n0 v0(j0 j0Var, l<? super f, ? extends Collection<? extends n0>> lVar) {
        n0 n0Var;
        z returnType;
        o oVar = o.a;
        Iterator<T> it = lVar.invoke(f.f(o.d(j0Var.getName().b()))).iterator();
        do {
            n0Var = null;
            if (!it.hasNext()) {
                break;
            }
            n0 n0Var2 = (n0) it.next();
            if (n0Var2.h().size() == 1 && (returnType = n0Var2.getReturnType()) != null && h.p2.b0.g.t.b.f.z0(returnType) && h.p2.b0.g.t.n.e1.f.a.b(((v0) CollectionsKt___CollectionsKt.U4(n0Var2.h())).getType(), j0Var.getType())) {
                n0Var = n0Var2;
                continue;
            }
        } while (n0Var == null);
        return n0Var;
    }

    private final h.p2.b0.g.t.c.s w0(h.p2.b0.g.t.c.d dVar) {
        h.p2.b0.g.t.c.s visibility = dVar.getVisibility();
        return f0.g(visibility, h.p2.b0.g.t.e.a.l.b) ? h.p2.b0.g.t.e.a.l.f15241c : visibility;
    }

    private final Set<n0> y0(f fVar) {
        Collection<z> c0 = c0();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (z zVar : c0) {
            y.q0(linkedHashSet, zVar.q().a(fVar, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @k.e.a.e
    public m0 A() {
        return h.p2.b0.g.t.k.c.l(D());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public boolean H(@d JavaMethodDescriptor javaMethodDescriptor) {
        if (this.o.m()) {
            return false;
        }
        return C0(javaMethodDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @d
    public LazyJavaScope.a I(@d h.p2.b0.g.t.e.a.x.r rVar, @d List<? extends t0> list, @d z zVar, @d List<? extends v0> list2) {
        e.b a = x().a().s().a(rVar, D(), zVar, null, list2, list);
        return new LazyJavaScope.a(a.d(), a.c(), a.f(), a.e(), a.g(), a.b());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, h.p2.b0.g.t.k.r.h
    @d
    public Collection<n0> a(@d f fVar, @d h.p2.b0.g.t.d.b.b bVar) {
        h(fVar, bVar);
        return super.a(fVar, bVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @d
    /* renamed from: a0 */
    public LinkedHashSet<f> o(@d h.p2.b0.g.t.k.r.d dVar, @k.e.a.e l<? super f, Boolean> lVar) {
        Collection<z> j2 = D().j().j();
        LinkedHashSet<f> linkedHashSet = new LinkedHashSet<>();
        for (z zVar : j2) {
            y.q0(linkedHashSet, zVar.q().b());
        }
        linkedHashSet.addAll(z().invoke().a());
        linkedHashSet.addAll(z().invoke().b());
        linkedHashSet.addAll(m(dVar, lVar));
        linkedHashSet.addAll(x().a().w().e(D()));
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @d
    /* renamed from: b0 */
    public ClassDeclaredMemberIndex q() {
        return new ClassDeclaredMemberIndex(this.o, LazyJavaClassMemberScope$computeMemberIndex$1.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope, h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @d
    public Collection<j0> c(@d f fVar, @d h.p2.b0.g.t.d.b.b bVar) {
        h(fVar, bVar);
        return super.c(fVar, bVar);
    }

    @Override // h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
    @k.e.a.e
    public h.p2.b0.g.t.c.f f(@d f fVar, @d h.p2.b0.g.t.d.b.b bVar) {
        h.p2.b0.g.t.m.g<f, h.p2.b0.g.t.c.d1.f> gVar;
        h(fVar, bVar);
        LazyJavaClassMemberScope lazyJavaClassMemberScope = (LazyJavaClassMemberScope) C();
        h.p2.b0.g.t.c.d1.f fVar2 = null;
        if (lazyJavaClassMemberScope != null && (gVar = lazyJavaClassMemberScope.t) != null) {
            fVar2 = gVar.invoke(fVar);
        }
        return fVar2 == null ? this.t.invoke(fVar) : fVar2;
    }

    @Override // h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
    public void h(@d f fVar, @d h.p2.b0.g.t.d.b.b bVar) {
        h.p2.b0.g.t.d.a.a(x().a().l(), bVar, D(), fVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @d
    public Set<f> m(@d h.p2.b0.g.t.k.r.d dVar, @k.e.a.e l<? super f, Boolean> lVar) {
        return e1.C(this.r.invoke(), this.s.invoke().keySet());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void p(@d Collection<n0> collection, @d f fVar) {
        if (this.o.o() && z().invoke().e(fVar) != null) {
            boolean z = true;
            if (!collection.isEmpty()) {
                Iterator<T> it = collection.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((n0) it.next()).h().isEmpty()) {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                collection.add(H0(z().invoke().e(fVar)));
            }
        }
        x().a().w().d(D(), fVar, collection);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void s(@d Collection<n0> collection, @d f fVar) {
        boolean z;
        Set<n0> y0 = y0(fVar);
        if (!SpecialGenericSignatures.a.k(fVar) && !BuiltinMethodsWithSpecialGenericSignature.n.l(fVar)) {
            if (!(y0 instanceof Collection) || !y0.isEmpty()) {
                for (v vVar : y0) {
                    if (vVar.isSuspend()) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : y0) {
                    if (C0((n0) obj)) {
                        arrayList.add(obj);
                    }
                }
                W(collection, fVar, arrayList, false);
                return;
            }
        }
        h.p2.b0.g.t.p.e a = h.p2.b0.g.t.p.e.f15632c.a();
        Collection<? extends n0> d2 = a.d(fVar, y0, CollectionsKt__CollectionsKt.E(), D(), h.p2.b0.g.t.l.b.l.a, x().a().k().a());
        X(fVar, collection, d2, collection, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$3(this));
        X(fVar, collection, d2, a, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$4(this));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : y0) {
            if (C0((n0) obj2)) {
                arrayList2.add(obj2);
            }
        }
        W(collection, fVar, CollectionsKt___CollectionsKt.q4(arrayList2, a), true);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void t(@d f fVar, @d Collection<j0> collection) {
        if (this.o.m()) {
            Z(fVar, collection);
        }
        Set<j0> A0 = A0(fVar);
        if (A0.isEmpty()) {
            return;
        }
        e.b bVar = h.p2.b0.g.t.p.e.f15632c;
        h.p2.b0.g.t.p.e a = bVar.a();
        h.p2.b0.g.t.p.e a2 = bVar.a();
        Y(A0, collection, a, new LazyJavaClassMemberScope$computeNonDeclaredProperties$1(this));
        Y(e1.x(A0, a), a2, null, new LazyJavaClassMemberScope$computeNonDeclaredProperties$2(this));
        collection.addAll(a.d(fVar, e1.C(A0, a2), collection, D(), x().a().c(), x().a().k().a()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @d
    public String toString() {
        return f0.C("Lazy Java member scope for ", this.o.e());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @d
    public Set<f> u(@d h.p2.b0.g.t.k.r.d dVar, @k.e.a.e l<? super f, Boolean> lVar) {
        if (this.o.m()) {
            return b();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(z().invoke().c());
        for (z zVar : D().j().j()) {
            y.q0(linkedHashSet, zVar.q().d());
        }
        return linkedHashSet;
    }

    @d
    public final h<List<c>> x0() {
        return this.q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @d
    /* renamed from: z0 */
    public h.p2.b0.g.t.c.d D() {
        return this.n;
    }

    public LazyJavaClassMemberScope(@d h.p2.b0.g.t.e.a.v.e eVar, @d h.p2.b0.g.t.c.d dVar, @d g gVar, boolean z, @k.e.a.e LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(eVar, lazyJavaClassMemberScope);
        this.n = dVar;
        this.o = gVar;
        this.p = z;
        this.q = eVar.e().c(new LazyJavaClassMemberScope$constructors$1(this, eVar));
        this.r = eVar.e().c(new LazyJavaClassMemberScope$nestedClassIndex$1(this));
        this.s = eVar.e().c(new LazyJavaClassMemberScope$enumEntryIndex$1(this));
        this.t = eVar.e().g(new LazyJavaClassMemberScope$nestedClasses$1(this, eVar));
    }
}
