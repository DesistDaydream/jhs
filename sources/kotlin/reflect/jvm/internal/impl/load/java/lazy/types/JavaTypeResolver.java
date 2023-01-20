package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import h.a2.i0;
import h.a2.t;
import h.a2.u;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.a.v.h;
import h.p2.b0.g.t.e.a.v.j.a;
import h.p2.b0.g.t.e.a.x.b0;
import h.p2.b0.g.t.e.a.x.f;
import h.p2.b0.g.t.e.a.x.g;
import h.p2.b0.g.t.e.a.x.i;
import h.p2.b0.g.t.e.a.x.j;
import h.p2.b0.g.t.e.a.x.v;
import h.p2.b0.g.t.e.a.x.x;
import h.p2.b0.g.t.e.a.x.y;
import h.p2.b0.g.t.g.b;
import h.p2.b0.g.t.g.c;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.s;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.u0;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class JavaTypeResolver {
    @d
    private final e a;
    @d
    private final h b;

    public JavaTypeResolver(@d e eVar, @d h hVar) {
        this.a = eVar;
        this.b = hVar;
    }

    private final boolean a(j jVar, h.p2.b0.g.t.c.d dVar) {
        if (b((x) CollectionsKt___CollectionsKt.i3(jVar.z()))) {
            t0 t0Var = (t0) CollectionsKt___CollectionsKt.i3(h.p2.b0.g.t.b.k.d.a.b(dVar).j().getParameters());
            Variance o = t0Var == null ? null : t0Var.o();
            return (o == null || o == Variance.OUT_VARIANCE) ? false : true;
        }
        return false;
    }

    private static final boolean b(x xVar) {
        b0 b0Var = xVar instanceof b0 ? (b0) xVar : null;
        return (b0Var == null || b0Var.x() == null || b0Var.M()) ? false : true;
    }

    private final List<s0> c(j jVar, a aVar, q0 q0Var) {
        s0 i2;
        boolean s = jVar.s();
        boolean z = true;
        if (!s && (!jVar.z().isEmpty() || !(!q0Var.getParameters().isEmpty()))) {
            z = false;
        }
        List<t0> parameters = q0Var.getParameters();
        if (z) {
            ArrayList arrayList = new ArrayList(u.Y(parameters, 10));
            for (t0 t0Var : parameters) {
                if (TypeUtilsKt.j(t0Var, null, aVar.e())) {
                    i2 = new StarProjectionImpl(t0Var);
                } else {
                    i2 = RawSubstitution.f16552c.i(t0Var, s ? aVar : aVar.g(JavaTypeFlexibility.INFLEXIBLE), new LazyWrappedType(this.a.e(), new JavaTypeResolver$computeArguments$1$erasedUpperBound$1(t0Var, s, aVar, q0Var)));
                }
                arrayList.add(i2);
            }
            return CollectionsKt___CollectionsKt.I5(arrayList);
        } else if (parameters.size() != jVar.z().size()) {
            ArrayList arrayList2 = new ArrayList(u.Y(parameters, 10));
            for (t0 t0Var2 : parameters) {
                arrayList2.add(new u0(s.j(t0Var2.getName().b())));
            }
            return CollectionsKt___CollectionsKt.I5(arrayList2);
        } else {
            Iterable<i0> U5 = CollectionsKt___CollectionsKt.U5(jVar.z());
            ArrayList arrayList3 = new ArrayList(u.Y(U5, 10));
            for (i0 i0Var : U5) {
                int a = i0Var.a();
                parameters.size();
                arrayList3.add(o((x) i0Var.b(), JavaTypeResolverKt.f(TypeUsage.COMMON, false, null, 3, null), parameters.get(a)));
            }
            return CollectionsKt___CollectionsKt.I5(arrayList3);
        }
    }

    private final f0 d(j jVar, a aVar, f0 f0Var) {
        h.p2.b0.g.t.c.b1.e annotations = f0Var == null ? null : f0Var.getAnnotations();
        if (annotations == null) {
            annotations = new LazyJavaAnnotations(this.a, jVar, false, 4, null);
        }
        h.p2.b0.g.t.c.b1.e eVar = annotations;
        q0 e2 = e(jVar, aVar);
        if (e2 == null) {
            return null;
        }
        boolean h2 = h(aVar);
        if (h.k2.v.f0.g(f0Var != null ? f0Var.I0() : null, e2) && !jVar.s() && h2) {
            return f0Var.P0(true);
        }
        List<s0> c2 = c(jVar, aVar, e2);
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        return KotlinTypeFactory.i(eVar, e2, c2, h2, null, 16, null);
    }

    private final q0 e(j jVar, a aVar) {
        i a = jVar.a();
        if (a == null) {
            return f(jVar);
        }
        if (a instanceof g) {
            g gVar = (g) a;
            c e2 = gVar.e();
            if (e2 != null) {
                h.p2.b0.g.t.c.d i2 = i(jVar, aVar, e2);
                if (i2 == null) {
                    i2 = this.a.a().n().a(gVar);
                }
                q0 j2 = i2 != null ? i2.j() : null;
                return j2 == null ? f(jVar) : j2;
            }
            throw new AssertionError(h.k2.v.f0.C("Class type should have a FQ name: ", a));
        } else if (a instanceof y) {
            t0 a2 = this.b.a((y) a);
            if (a2 == null) {
                return null;
            }
            return a2.j();
        } else {
            throw new IllegalStateException(h.k2.v.f0.C("Unknown classifier kind: ", a));
        }
    }

    private final q0 f(j jVar) {
        return this.a.a().b().e().q().d(b.m(new c(jVar.H())), t.k(0)).j();
    }

    private final boolean g(Variance variance, t0 t0Var) {
        return (t0Var.o() == Variance.INVARIANT || variance == t0Var.o()) ? false : true;
    }

    private final boolean h(a aVar) {
        return (aVar.c() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || aVar.f() || aVar.d() == TypeUsage.SUPERTYPE) ? false : true;
    }

    private final h.p2.b0.g.t.c.d i(j jVar, a aVar, c cVar) {
        if (aVar.f() && h.k2.v.f0.g(cVar, JavaTypeResolverKt.a())) {
            return this.a.a().p().c();
        }
        h.p2.b0.g.t.b.k.d dVar = h.p2.b0.g.t.b.k.d.a;
        h.p2.b0.g.t.c.d h2 = h.p2.b0.g.t.b.k.d.h(dVar, cVar, this.a.d().k(), null, 4, null);
        if (h2 == null) {
            return null;
        }
        return (dVar.e(h2) && (aVar.c() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || aVar.d() == TypeUsage.SUPERTYPE || a(jVar, h2))) ? dVar.b(h2) : h2;
    }

    public static /* synthetic */ z k(JavaTypeResolver javaTypeResolver, f fVar, a aVar, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return javaTypeResolver.j(fVar, aVar, z);
    }

    private final z l(j jVar, a aVar) {
        boolean z = (aVar.f() || aVar.d() == TypeUsage.SUPERTYPE) ? false : true;
        boolean s = jVar.s();
        if (!s && !z) {
            f0 d2 = d(jVar, aVar, null);
            return d2 == null ? m(jVar) : d2;
        }
        f0 d3 = d(jVar, aVar.g(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), null);
        if (d3 == null) {
            return m(jVar);
        }
        f0 d4 = d(jVar, aVar.g(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), d3);
        if (d4 == null) {
            return m(jVar);
        }
        if (s) {
            return new RawTypeImpl(d3, d4);
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        return KotlinTypeFactory.d(d3, d4);
    }

    private static final f0 m(j jVar) {
        return s.j(h.k2.v.f0.C("Unresolved java class ", jVar.E()));
    }

    private final s0 o(x xVar, a aVar, t0 t0Var) {
        if (xVar instanceof b0) {
            b0 b0Var = (b0) xVar;
            x x = b0Var.x();
            Variance variance = b0Var.M() ? Variance.OUT_VARIANCE : Variance.IN_VARIANCE;
            if (x != null && !g(variance, t0Var)) {
                return TypeUtilsKt.e(n(x, JavaTypeResolverKt.f(TypeUsage.COMMON, false, null, 3, null)), variance, t0Var);
            }
            return JavaTypeResolverKt.d(t0Var, aVar);
        }
        return new u0(Variance.INVARIANT, n(xVar, aVar));
    }

    @d
    public final z j(@d f fVar, @d a aVar, boolean z) {
        x l2 = fVar.l();
        v vVar = l2 instanceof v ? (v) l2 : null;
        PrimitiveType type = vVar == null ? null : vVar.getType();
        LazyJavaAnnotations lazyJavaAnnotations = new LazyJavaAnnotations(this.a, fVar, true);
        if (type != null) {
            f0 N = this.a.d().k().N(type);
            N.Q0(h.p2.b0.g.t.c.b1.e.w0.a(CollectionsKt___CollectionsKt.m4(lazyJavaAnnotations, N.getAnnotations())));
            if (aVar.f()) {
                return N;
            }
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            return KotlinTypeFactory.d(N, N.P0(true));
        }
        z n = n(l2, JavaTypeResolverKt.f(TypeUsage.COMMON, aVar.f(), null, 2, null));
        if (aVar.f()) {
            return this.a.d().k().m(z ? Variance.OUT_VARIANCE : Variance.INVARIANT, n, lazyJavaAnnotations);
        }
        KotlinTypeFactory kotlinTypeFactory2 = KotlinTypeFactory.a;
        return KotlinTypeFactory.d(this.a.d().k().m(Variance.INVARIANT, n, lazyJavaAnnotations), this.a.d().k().m(Variance.OUT_VARIANCE, n, lazyJavaAnnotations).P0(true));
    }

    @d
    public final z n(@k.e.a.e x xVar, @d a aVar) {
        if (xVar instanceof v) {
            PrimitiveType type = ((v) xVar).getType();
            if (type != null) {
                return this.a.d().k().Q(type);
            }
            return this.a.d().k().Y();
        } else if (xVar instanceof j) {
            return l((j) xVar, aVar);
        } else {
            if (xVar instanceof f) {
                return k(this, (f) xVar, aVar, false, 4, null);
            }
            if (xVar instanceof b0) {
                x x = ((b0) xVar).x();
                z n = x == null ? null : n(x, aVar);
                return n == null ? this.a.d().k().y() : n;
            } else if (xVar == null) {
                return this.a.d().k().y();
            } else {
                throw new UnsupportedOperationException(h.k2.v.f0.C("Unsupported type: ", xVar));
            }
        }
    }
}
