package h.p2.b0.g.t.b;

import h.a2.t0;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.k.n.t;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.z;
import h.z0;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.BuiltInAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class e {
    @h.k2.h
    @k.e.a.d
    public static final f0 a(@k.e.a.d f fVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.e z zVar, @k.e.a.d List<? extends z> list, @k.e.a.e List<h.p2.b0.g.t.g.f> list2, @k.e.a.d z zVar2, boolean z) {
        List<s0> e2 = e(zVar, list, list2, zVar2, fVar);
        int size = list.size();
        if (zVar != null) {
            size++;
        }
        h.p2.b0.g.t.c.d d2 = d(fVar, size, z);
        if (zVar != null) {
            eVar = q(eVar, fVar);
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        return KotlinTypeFactory.g(eVar, d2, e2);
    }

    @k.e.a.e
    public static final h.p2.b0.g.t.g.f c(@k.e.a.d z zVar) {
        String a;
        h.p2.b0.g.t.c.b1.c c2 = zVar.getAnnotations().c(g.a.D);
        if (c2 == null) {
            return null;
        }
        Object V4 = CollectionsKt___CollectionsKt.V4(c2.a().values());
        t tVar = V4 instanceof t ? (t) V4 : null;
        if (tVar == null || (a = tVar.a()) == null || !h.p2.b0.g.t.g.f.h(a)) {
            a = null;
        }
        if (a == null) {
            return null;
        }
        return h.p2.b0.g.t.g.f.f(a);
    }

    @k.e.a.d
    public static final h.p2.b0.g.t.c.d d(@k.e.a.d f fVar, int i2, boolean z) {
        return z ? fVar.W(i2) : fVar.C(i2);
    }

    @k.e.a.d
    public static final List<s0> e(@k.e.a.e z zVar, @k.e.a.d List<? extends z> list, @k.e.a.e List<h.p2.b0.g.t.g.f> list2, @k.e.a.d z zVar2, @k.e.a.d f fVar) {
        h.p2.b0.g.t.g.f fVar2;
        int i2 = 0;
        ArrayList arrayList = new ArrayList(list.size() + (zVar != null ? 1 : 0) + 1);
        h.p2.b0.g.t.p.a.a(arrayList, zVar == null ? null : TypeUtilsKt.a(zVar));
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            z zVar3 = (z) obj;
            if (list2 == null || (fVar2 = list2.get(i2)) == null || fVar2.g()) {
                fVar2 = null;
            }
            if (fVar2 != null) {
                zVar3 = TypeUtilsKt.q(zVar3, h.p2.b0.g.t.c.b1.e.w0.a(CollectionsKt___CollectionsKt.n4(zVar3.getAnnotations(), new BuiltInAnnotationDescriptor(fVar, g.a.D, h.a2.s0.k(z0.a(h.p2.b0.g.t.g.f.f("name"), new t(fVar2.b())))))));
            }
            arrayList.add(TypeUtilsKt.a(zVar3));
            i2 = i3;
        }
        arrayList.add(TypeUtilsKt.a(zVar2));
        return arrayList;
    }

    @k.e.a.e
    public static final FunctionClassKind f(@k.e.a.d k kVar) {
        if ((kVar instanceof h.p2.b0.g.t.c.d) && f.y0(kVar)) {
            return g(DescriptorUtilsKt.j(kVar));
        }
        return null;
    }

    private static final FunctionClassKind g(h.p2.b0.g.t.g.d dVar) {
        if (!dVar.f() || dVar.e()) {
            return null;
        }
        return FunctionClassKind.Companion.b(dVar.i().b(), dVar.l().e());
    }

    @k.e.a.e
    public static final z h(@k.e.a.d z zVar) {
        m(zVar);
        if (p(zVar)) {
            return ((s0) CollectionsKt___CollectionsKt.o2(zVar.H0())).getType();
        }
        return null;
    }

    @k.e.a.d
    public static final z i(@k.e.a.d z zVar) {
        m(zVar);
        return ((s0) CollectionsKt___CollectionsKt.c3(zVar.H0())).getType();
    }

    @k.e.a.d
    public static final List<s0> j(@k.e.a.d z zVar) {
        m(zVar);
        List<s0> H0 = zVar.H0();
        return H0.subList(k(zVar) ? 1 : 0, H0.size() - 1);
    }

    public static final boolean k(@k.e.a.d z zVar) {
        return m(zVar) && p(zVar);
    }

    public static final boolean l(@k.e.a.d k kVar) {
        FunctionClassKind f2 = f(kVar);
        return f2 == FunctionClassKind.Function || f2 == FunctionClassKind.SuspendFunction;
    }

    public static final boolean m(@k.e.a.d z zVar) {
        h.p2.b0.g.t.c.f c2 = zVar.I0().c();
        return h.k2.v.f0.g(c2 == null ? null : Boolean.valueOf(l(c2)), Boolean.TRUE);
    }

    public static final boolean n(@k.e.a.d z zVar) {
        h.p2.b0.g.t.c.f c2 = zVar.I0().c();
        return (c2 == null ? null : f(c2)) == FunctionClassKind.Function;
    }

    public static final boolean o(@k.e.a.d z zVar) {
        h.p2.b0.g.t.c.f c2 = zVar.I0().c();
        return (c2 == null ? null : f(c2)) == FunctionClassKind.SuspendFunction;
    }

    private static final boolean p(z zVar) {
        return zVar.getAnnotations().c(g.a.C) != null;
    }

    @k.e.a.d
    public static final h.p2.b0.g.t.c.b1.e q(@k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d f fVar) {
        h.p2.b0.g.t.g.c cVar = g.a.C;
        return eVar.n(cVar) ? eVar : h.p2.b0.g.t.c.b1.e.w0.a(CollectionsKt___CollectionsKt.n4(eVar, new BuiltInAnnotationDescriptor(fVar, cVar, t0.z())));
    }
}
