package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import h.a2.u;
import h.k2.v.f0;
import h.o2.q;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.e.a.v.j.a;
import h.p2.b0.g.t.g.c;
import h.p2.b0.g.t.n.k0;
import h.p2.b0.g.t.n.r0;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.u0;
import h.p2.b0.g.t.n.z;
import h.z0;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Set;
import k.e.a.d;
import k.e.a.e;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class JavaTypeResolverKt {
    @d
    private static final c a = new c("java.lang.Class");

    public static final /* synthetic */ c a() {
        return a;
    }

    @d
    public static final z b(@d t0 t0Var, boolean z, @d a aVar, @d h.k2.u.a<? extends z> aVar2) {
        s0 d2;
        if (t0Var == aVar.e()) {
            return aVar2.invoke();
        }
        a h2 = aVar.e() == null ? aVar.h(t0Var) : aVar;
        Set<t0> f2 = TypeUtilsKt.f(t0Var.r(), aVar.e());
        LinkedHashMap linkedHashMap = new LinkedHashMap(q.n(h.a2.s0.j(u.Y(f2, 10)), 16));
        for (t0 t0Var2 : f2) {
            if (t0Var2 != aVar.e()) {
                d2 = RawSubstitution.f16552c.i(t0Var2, z ? aVar : aVar.g(JavaTypeFlexibility.INFLEXIBLE), t0Var2 != aVar.e() ? c(t0Var2, z, h2, null, 4, null) : k0.a(t0Var2));
            } else {
                d2 = d(t0Var2, aVar);
            }
            Pair a2 = z0.a(t0Var2.j(), d2);
            linkedHashMap.put(a2.getFirst(), a2.getSecond());
        }
        TypeSubstitutor g2 = TypeSubstitutor.g(r0.a.e(r0.f15601c, linkedHashMap, false, 2, null));
        z zVar = (z) CollectionsKt___CollectionsKt.o2(t0Var.getUpperBounds());
        if (zVar.I0().c() instanceof h.p2.b0.g.t.c.d) {
            return TypeUtilsKt.r(zVar, g2, linkedHashMap, Variance.OUT_VARIANCE, aVar.e());
        }
        t0 e2 = aVar.e();
        if (e2 != null) {
            t0Var = e2;
        }
        f c2 = zVar.I0().c();
        Objects.requireNonNull(c2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        while (true) {
            t0 t0Var3 = (t0) c2;
            if (!f0.g(t0Var3, t0Var)) {
                z zVar2 = (z) CollectionsKt___CollectionsKt.o2(t0Var3.getUpperBounds());
                if (zVar2.I0().c() instanceof h.p2.b0.g.t.c.d) {
                    return TypeUtilsKt.r(zVar2, g2, linkedHashMap, Variance.OUT_VARIANCE, aVar.e());
                }
                c2 = zVar2.I0().c();
                Objects.requireNonNull(c2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            } else {
                return aVar2.invoke();
            }
        }
    }

    public static /* synthetic */ z c(t0 t0Var, boolean z, a aVar, h.k2.u.a aVar2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            aVar2 = new JavaTypeResolverKt$getErasedUpperBound$1(t0Var);
        }
        return b(t0Var, z, aVar, aVar2);
    }

    @d
    public static final s0 d(@d t0 t0Var, @d a aVar) {
        if (aVar.d() == TypeUsage.SUPERTYPE) {
            return new u0(k0.a(t0Var));
        }
        return new StarProjectionImpl(t0Var);
    }

    @d
    public static final a e(@d TypeUsage typeUsage, boolean z, @e t0 t0Var) {
        return new a(typeUsage, null, z, t0Var, 2, null);
    }

    public static /* synthetic */ a f(TypeUsage typeUsage, boolean z, t0 t0Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            t0Var = null;
        }
        return e(typeUsage, z, t0Var);
    }
}
