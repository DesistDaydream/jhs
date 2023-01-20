package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import h.a2.i0;
import h.k2.u.l;
import h.k2.v.f0;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.c.g;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.a1;
import h.p2.b0.g.t.n.c1;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.u;
import h.p2.b0.g.t.n.u0;
import h.p2.b0.g.t.n.w0;
import h.p2.b0.g.t.n.y0;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k.e.a.d;
import k.e.a.e;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class TypeUtilsKt {
    @d
    public static final s0 a(@d z zVar) {
        return new u0(zVar);
    }

    public static final boolean b(@d z zVar, @d l<? super c1, Boolean> lVar) {
        return y0.c(zVar, lVar);
    }

    private static final boolean c(z zVar, q0 q0Var, t0 t0Var) {
        boolean c2;
        if (f0.g(zVar.I0(), q0Var)) {
            return true;
        }
        f c3 = zVar.I0().c();
        g gVar = c3 instanceof g ? (g) c3 : null;
        List<t0> s = gVar == null ? null : gVar.s();
        Iterable<i0> U5 = CollectionsKt___CollectionsKt.U5(zVar.H0());
        if (!(U5 instanceof Collection) || !((Collection) U5).isEmpty()) {
            for (i0 i0Var : U5) {
                int a = i0Var.a();
                s0 s0Var = (s0) i0Var.b();
                t0 t0Var2 = s == null ? null : (t0) CollectionsKt___CollectionsKt.J2(s, a);
                if ((t0Var2 == null || !f0.g(t0Var2, t0Var)) && !s0Var.b()) {
                    c2 = c(s0Var.getType(), q0Var, t0Var);
                    continue;
                } else {
                    c2 = false;
                    continue;
                }
                if (c2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean d(@d z zVar) {
        return b(zVar, TypeUtilsKt$containsTypeAliasParameters$1.INSTANCE);
    }

    @d
    public static final s0 e(@d z zVar, @d Variance variance, @e t0 t0Var) {
        if ((t0Var == null ? null : t0Var.o()) == variance) {
            variance = Variance.INVARIANT;
        }
        return new u0(variance, zVar);
    }

    @d
    public static final Set<t0> f(@d z zVar, @e t0 t0Var) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        g(zVar, zVar, linkedHashSet, t0Var);
        return linkedHashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void g(z zVar, z zVar2, Set<t0> set, t0 t0Var) {
        f c2 = zVar.I0().c();
        if (c2 instanceof t0) {
            if (!f0.g(zVar.I0(), zVar2.I0())) {
                set.add(c2);
                return;
            }
            for (z zVar3 : ((t0) c2).getUpperBounds()) {
                g(zVar3, zVar2, set, t0Var);
            }
            return;
        }
        f c3 = zVar.I0().c();
        g gVar = c3 instanceof g ? (g) c3 : null;
        List<t0> s = gVar == null ? null : gVar.s();
        int i2 = 0;
        for (s0 s0Var : zVar.H0()) {
            int i3 = i2 + 1;
            t0 t0Var2 = s == null ? null : s.get(i2);
            if (!s0Var.b() && ((t0Var2 == null || !f0.g(t0Var2, t0Var)) && !CollectionsKt___CollectionsKt.J1(set, s0Var.getType().I0().c()) && !f0.g(s0Var.getType().I0(), zVar2.I0()))) {
                g(s0Var.getType(), zVar2, set, t0Var);
            }
            i2 = i3;
        }
    }

    @d
    public static final h.p2.b0.g.t.b.f h(@d z zVar) {
        return zVar.I0().k();
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0043, code lost:
        r2 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0044 A[EDGE_INSN: B:52:0x0044->B:47:0x0044 ?: BREAK  , SYNTHETIC] */
    @k.e.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final h.p2.b0.g.t.n.z i(@k.e.a.d h.p2.b0.g.t.c.t0 r6) {
        /*
            java.util.List r0 = r6.getUpperBounds()
            r0.isEmpty()
            java.util.List r0 = r6.getUpperBounds()
            java.util.Iterator r0 = r0.iterator()
        Lf:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L44
            java.lang.Object r1 = r0.next()
            r3 = r1
            h.p2.b0.g.t.n.z r3 = (h.p2.b0.g.t.n.z) r3
            h.p2.b0.g.t.n.q0 r3 = r3.I0()
            h.p2.b0.g.t.c.f r3 = r3.c()
            boolean r4 = r3 instanceof h.p2.b0.g.t.c.d
            if (r4 == 0) goto L2c
            r2 = r3
            h.p2.b0.g.t.c.d r2 = (h.p2.b0.g.t.c.d) r2
        L2c:
            r3 = 0
            if (r2 != 0) goto L30
            goto L41
        L30:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r4 = r2.i()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r5 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE
            if (r4 == r5) goto L41
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r2 = r2.i()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r4 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS
            if (r2 == r4) goto L41
            r3 = 1
        L41:
            if (r3 == 0) goto Lf
            r2 = r1
        L44:
            h.p2.b0.g.t.n.z r2 = (h.p2.b0.g.t.n.z) r2
            if (r2 != 0) goto L53
            java.util.List r6 = r6.getUpperBounds()
            java.lang.Object r6 = kotlin.collections.CollectionsKt___CollectionsKt.o2(r6)
            r2 = r6
            h.p2.b0.g.t.n.z r2 = (h.p2.b0.g.t.n.z) r2
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.i(h.p2.b0.g.t.c.t0):h.p2.b0.g.t.n.z");
    }

    public static final boolean j(@d t0 t0Var, @e q0 q0Var, @e t0 t0Var2) {
        boolean z;
        List<z> upperBounds = t0Var.getUpperBounds();
        if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
            for (z zVar : upperBounds) {
                if (c(zVar, t0Var.r().I0(), t0Var2) && (q0Var == null || f0.g(zVar.I0(), q0Var))) {
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
        }
        return false;
    }

    public static /* synthetic */ boolean k(t0 t0Var, q0 q0Var, t0 t0Var2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            q0Var = null;
        }
        if ((i2 & 4) != 0) {
            t0Var2 = null;
        }
        return j(t0Var, q0Var, t0Var2);
    }

    public static final boolean l(@d z zVar, @d z zVar2) {
        return h.p2.b0.g.t.n.e1.f.a.d(zVar, zVar2);
    }

    public static final boolean m(@d f fVar) {
        return (fVar instanceof t0) && (((t0) fVar).b() instanceof h.p2.b0.g.t.c.s0);
    }

    public static final boolean n(@d z zVar) {
        return y0.m(zVar);
    }

    @d
    public static final z o(@d z zVar) {
        return y0.n(zVar);
    }

    @d
    public static final z p(@d z zVar) {
        return y0.o(zVar);
    }

    @d
    public static final z q(@d z zVar, @d h.p2.b0.g.t.c.b1.e eVar) {
        return (zVar.getAnnotations().isEmpty() && eVar.isEmpty()) ? zVar : zVar.L0().O0(eVar);
    }

    @d
    public static final z r(@d z zVar, @d TypeSubstitutor typeSubstitutor, @d Map<q0, ? extends s0> map, @d Variance variance, @e t0 t0Var) {
        c1 c1Var;
        c1 L0 = zVar.L0();
        if (L0 instanceof u) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            u uVar = (u) L0;
            h.p2.b0.g.t.n.f0 Q0 = uVar.Q0();
            if (!Q0.I0().getParameters().isEmpty() && Q0.I0().c() != null) {
                List<t0> parameters = Q0.I0().getParameters();
                ArrayList arrayList = new ArrayList(h.a2.u.Y(parameters, 10));
                for (t0 t0Var2 : parameters) {
                    s0 s0Var = (s0) CollectionsKt___CollectionsKt.J2(zVar.H0(), t0Var2.f());
                    if (f0.g(t0Var2, t0Var) || s0Var == null || !map.containsKey(s0Var.getType().I0())) {
                        s0Var = new StarProjectionImpl(t0Var2);
                    }
                    arrayList.add(s0Var);
                }
                Q0 = w0.f(Q0, arrayList, null, 2, null);
            }
            h.p2.b0.g.t.n.f0 R0 = uVar.R0();
            if (!R0.I0().getParameters().isEmpty() && R0.I0().c() != null) {
                List<t0> parameters2 = R0.I0().getParameters();
                ArrayList arrayList2 = new ArrayList(h.a2.u.Y(parameters2, 10));
                for (t0 t0Var3 : parameters2) {
                    s0 s0Var2 = (s0) CollectionsKt___CollectionsKt.J2(zVar.H0(), t0Var3.f());
                    if (f0.g(t0Var3, t0Var) || s0Var2 == null || !map.containsKey(s0Var2.getType().I0())) {
                        s0Var2 = new StarProjectionImpl(t0Var3);
                    }
                    arrayList2.add(s0Var2);
                }
                R0 = w0.f(R0, arrayList2, null, 2, null);
            }
            c1Var = KotlinTypeFactory.d(Q0, R0);
        } else if (L0 instanceof h.p2.b0.g.t.n.f0) {
            h.p2.b0.g.t.n.f0 f0Var = (h.p2.b0.g.t.n.f0) L0;
            if (f0Var.I0().getParameters().isEmpty() || f0Var.I0().c() == null) {
                c1Var = f0Var;
            } else {
                List<t0> parameters3 = f0Var.I0().getParameters();
                ArrayList arrayList3 = new ArrayList(h.a2.u.Y(parameters3, 10));
                for (t0 t0Var4 : parameters3) {
                    s0 s0Var3 = (s0) CollectionsKt___CollectionsKt.J2(zVar.H0(), t0Var4.f());
                    if (f0.g(t0Var4, t0Var) || s0Var3 == null || !map.containsKey(s0Var3.getType().I0())) {
                        s0Var3 = new StarProjectionImpl(t0Var4);
                    }
                    arrayList3.add(s0Var3);
                }
                c1Var = w0.f(f0Var, arrayList3, null, 2, null);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return typeSubstitutor.n(a1.b(c1Var, L0), variance);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [h.p2.b0.g.t.n.c1] */
    @d
    public static final z s(@d z zVar) {
        h.p2.b0.g.t.n.f0 f0Var;
        c1 L0 = zVar.L0();
        if (L0 instanceof u) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            u uVar = (u) L0;
            h.p2.b0.g.t.n.f0 Q0 = uVar.Q0();
            if (!Q0.I0().getParameters().isEmpty() && Q0.I0().c() != null) {
                List<t0> parameters = Q0.I0().getParameters();
                ArrayList arrayList = new ArrayList(h.a2.u.Y(parameters, 10));
                for (t0 t0Var : parameters) {
                    arrayList.add(new StarProjectionImpl(t0Var));
                }
                Q0 = w0.f(Q0, arrayList, null, 2, null);
            }
            h.p2.b0.g.t.n.f0 R0 = uVar.R0();
            if (!R0.I0().getParameters().isEmpty() && R0.I0().c() != null) {
                List<t0> parameters2 = R0.I0().getParameters();
                ArrayList arrayList2 = new ArrayList(h.a2.u.Y(parameters2, 10));
                for (t0 t0Var2 : parameters2) {
                    arrayList2.add(new StarProjectionImpl(t0Var2));
                }
                R0 = w0.f(R0, arrayList2, null, 2, null);
            }
            f0Var = KotlinTypeFactory.d(Q0, R0);
        } else if (L0 instanceof h.p2.b0.g.t.n.f0) {
            h.p2.b0.g.t.n.f0 f0Var2 = (h.p2.b0.g.t.n.f0) L0;
            boolean isEmpty = f0Var2.I0().getParameters().isEmpty();
            f0Var = f0Var2;
            if (!isEmpty) {
                f c2 = f0Var2.I0().c();
                f0Var = f0Var2;
                if (c2 != null) {
                    List<t0> parameters3 = f0Var2.I0().getParameters();
                    ArrayList arrayList3 = new ArrayList(h.a2.u.Y(parameters3, 10));
                    for (t0 t0Var3 : parameters3) {
                        arrayList3.add(new StarProjectionImpl(t0Var3));
                    }
                    f0Var = w0.f(f0Var2, arrayList3, null, 2, null);
                }
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return a1.b(f0Var, L0);
    }

    public static final boolean t(@d z zVar) {
        return b(zVar, TypeUtilsKt$requiresTypeAliasExpansion$1.INSTANCE);
    }

    public static final boolean u(@d z zVar) {
        return b(zVar, TypeUtilsKt$shouldBeUpdated$1.INSTANCE);
    }
}
