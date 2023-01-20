package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import h.a2.u;
import h.k2.v.f0;
import h.p2.b0.g.t.b.f;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.a1;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.r0;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.u0;
import h.p2.b0.g.t.n.w0;
import h.p2.b0.g.t.n.x;
import h.p2.b0.g.t.n.y0;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class CapturedTypeApproximationKt {

    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Variance.values().length];
            iArr[Variance.INVARIANT.ordinal()] = 1;
            iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            a = iArr;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends r0 {
        @Override // h.p2.b0.g.t.n.r0
        @e
        public s0 j(@d q0 q0Var) {
            h.p2.b0.g.t.k.m.a.b bVar = q0Var instanceof h.p2.b0.g.t.k.m.a.b ? (h.p2.b0.g.t.k.m.a.b) q0Var : null;
            if (bVar == null) {
                return null;
            }
            if (bVar.b().b()) {
                return new u0(Variance.OUT_VARIANCE, bVar.b().getType());
            }
            return bVar.b();
        }
    }

    @d
    public static final h.p2.b0.g.t.n.h1.a<z> a(@d z zVar) {
        if (x.b(zVar)) {
            h.p2.b0.g.t.n.h1.a<z> a2 = a(x.c(zVar));
            h.p2.b0.g.t.n.h1.a<z> a3 = a(x.d(zVar));
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            return new h.p2.b0.g.t.n.h1.a<>(a1.b(KotlinTypeFactory.d(x.c(a2.c()), x.d(a3.c())), zVar), a1.b(KotlinTypeFactory.d(x.c(a2.d()), x.d(a3.d())), zVar));
        }
        q0 I0 = zVar.I0();
        if (CapturedTypeConstructorKt.d(zVar)) {
            s0 b2 = ((h.p2.b0.g.t.k.m.a.b) I0).b();
            z b3 = b(b2.getType(), zVar);
            int i2 = a.a[b2.c().ordinal()];
            if (i2 != 2) {
                if (i2 == 3) {
                    return new h.p2.b0.g.t.n.h1.a<>(b(TypeUtilsKt.h(zVar).H(), zVar), b3);
                }
                throw new AssertionError(f0.C("Only nontrivial projections should have been captured, not: ", b2));
            }
            return new h.p2.b0.g.t.n.h1.a<>(b3, TypeUtilsKt.h(zVar).I());
        } else if (!zVar.H0().isEmpty() && zVar.H0().size() == I0.getParameters().size()) {
            ArrayList<h.p2.b0.g.t.n.h1.b> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Pair pair : CollectionsKt___CollectionsKt.V5(zVar.H0(), I0.getParameters())) {
                s0 s0Var = (s0) pair.component1();
                h.p2.b0.g.t.n.h1.b g2 = g(s0Var, (t0) pair.component2());
                if (s0Var.b()) {
                    arrayList.add(g2);
                    arrayList2.add(g2);
                } else {
                    h.p2.b0.g.t.n.h1.a<h.p2.b0.g.t.n.h1.b> d2 = d(g2);
                    arrayList.add(d2.a());
                    arrayList2.add(d2.b());
                }
            }
            boolean z = true;
            if (!arrayList.isEmpty()) {
                for (h.p2.b0.g.t.n.h1.b bVar : arrayList) {
                    if (!bVar.d()) {
                        break;
                    }
                }
            }
            z = false;
            return new h.p2.b0.g.t.n.h1.a<>(z ? TypeUtilsKt.h(zVar).H() : e(zVar, arrayList), e(zVar, arrayList2));
        } else {
            return new h.p2.b0.g.t.n.h1.a<>(zVar, zVar);
        }
    }

    private static final z b(z zVar, z zVar2) {
        return y0.q(zVar, zVar2.J0());
    }

    @e
    public static final s0 c(@e s0 s0Var, boolean z) {
        if (s0Var == null) {
            return null;
        }
        if (s0Var.b()) {
            return s0Var;
        }
        z type = s0Var.getType();
        if (y0.c(type, CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1.INSTANCE)) {
            Variance c2 = s0Var.c();
            if (c2 == Variance.OUT_VARIANCE) {
                return new u0(c2, a(type).d());
            }
            if (z) {
                return new u0(c2, a(type).c());
            }
            return f(s0Var);
        }
        return s0Var;
    }

    private static final h.p2.b0.g.t.n.h1.a<h.p2.b0.g.t.n.h1.b> d(h.p2.b0.g.t.n.h1.b bVar) {
        h.p2.b0.g.t.n.h1.a<z> a2 = a(bVar.a());
        h.p2.b0.g.t.n.h1.a<z> a3 = a(bVar.b());
        return new h.p2.b0.g.t.n.h1.a<>(new h.p2.b0.g.t.n.h1.b(bVar.c(), a2.b(), a3.a()), new h.p2.b0.g.t.n.h1.b(bVar.c(), a2.a(), a3.b()));
    }

    private static final z e(z zVar, List<h.p2.b0.g.t.n.h1.b> list) {
        zVar.H0().size();
        list.size();
        ArrayList arrayList = new ArrayList(u.Y(list, 10));
        for (h.p2.b0.g.t.n.h1.b bVar : list) {
            arrayList.add(h(bVar));
        }
        return w0.e(zVar, arrayList, null, null, 6, null);
    }

    private static final s0 f(s0 s0Var) {
        return TypeSubstitutor.g(new b()).t(s0Var);
    }

    private static final h.p2.b0.g.t.n.h1.b g(s0 s0Var, t0 t0Var) {
        int i2 = a.a[TypeSubstitutor.c(t0Var.o(), s0Var).ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return new h.p2.b0.g.t.n.h1.b(t0Var, DescriptorUtilsKt.g(t0Var).H(), s0Var.getType());
                }
                throw new NoWhenBranchMatchedException();
            }
            return new h.p2.b0.g.t.n.h1.b(t0Var, s0Var.getType(), DescriptorUtilsKt.g(t0Var).I());
        }
        return new h.p2.b0.g.t.n.h1.b(t0Var, s0Var.getType(), s0Var.getType());
    }

    private static final s0 h(h.p2.b0.g.t.n.h1.b bVar) {
        bVar.d();
        if (!f0.g(bVar.a(), bVar.b())) {
            Variance o = bVar.c().o();
            Variance variance = Variance.IN_VARIANCE;
            if (o != variance) {
                if (!f.k0(bVar.a()) || bVar.c().o() == variance) {
                    return f.m0(bVar.b()) ? new u0(i(bVar, variance), bVar.a()) : new u0(i(bVar, Variance.OUT_VARIANCE), bVar.b());
                }
                return new u0(i(bVar, Variance.OUT_VARIANCE), bVar.b());
            }
        }
        return new u0(bVar.a());
    }

    private static final Variance i(h.p2.b0.g.t.n.h1.b bVar, Variance variance) {
        return variance == bVar.c().o() ? Variance.INVARIANT : variance;
    }
}
