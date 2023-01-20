package h.p2.b0.g.t.n.e1;

import h.p2.b0.g.t.n.a1;
import h.p2.b0.g.t.n.c1;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.y0;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public abstract class g {

    /* loaded from: classes3.dex */
    public static final class a extends g {
        @k.e.a.d
        public static final a a = new a();

        private a() {
        }
    }

    private final f0 b(f0 f0Var) {
        z type;
        q0 I0 = f0Var.I0();
        boolean z = false;
        IntersectionTypeConstructor intersectionTypeConstructor = null;
        r5 = null;
        c1 L0 = null;
        if (I0 instanceof h.p2.b0.g.t.k.m.a.c) {
            h.p2.b0.g.t.k.m.a.c cVar = (h.p2.b0.g.t.k.m.a.c) I0;
            s0 b = cVar.b();
            if (!(b.c() == Variance.IN_VARIANCE)) {
                b = null;
            }
            if (b != null && (type = b.getType()) != null) {
                L0 = type.L0();
            }
            c1 c1Var = L0;
            if (cVar.f() == null) {
                s0 b2 = cVar.b();
                Collection<z> j2 = cVar.j();
                ArrayList arrayList = new ArrayList(h.a2.u.Y(j2, 10));
                for (z zVar : j2) {
                    arrayList.add(zVar.L0());
                }
                cVar.h(new NewCapturedTypeConstructor(b2, arrayList, null, 4, null));
            }
            return new j(CaptureStatus.FOR_SUBTYPING, cVar.f(), c1Var, f0Var.getAnnotations(), f0Var.J0(), false, 32, null);
        } else if (I0 instanceof h.p2.b0.g.t.k.n.n) {
            Collection<z> j3 = ((h.p2.b0.g.t.k.n.n) I0).j();
            ArrayList arrayList2 = new ArrayList(h.a2.u.Y(j3, 10));
            for (z zVar2 : j3) {
                arrayList2.add(y0.p(zVar2, f0Var.J0()));
            }
            IntersectionTypeConstructor intersectionTypeConstructor2 = new IntersectionTypeConstructor(arrayList2);
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            return KotlinTypeFactory.j(f0Var.getAnnotations(), intersectionTypeConstructor2, CollectionsKt__CollectionsKt.E(), false, f0Var.q());
        } else if ((I0 instanceof IntersectionTypeConstructor) && f0Var.J0()) {
            IntersectionTypeConstructor intersectionTypeConstructor3 = (IntersectionTypeConstructor) I0;
            Collection<z> j4 = intersectionTypeConstructor3.j();
            ArrayList arrayList3 = new ArrayList(h.a2.u.Y(j4, 10));
            for (z zVar3 : j4) {
                arrayList3.add(TypeUtilsKt.p(zVar3));
                z = true;
            }
            if (z) {
                z g2 = intersectionTypeConstructor3.g();
                intersectionTypeConstructor = new IntersectionTypeConstructor(arrayList3).l(g2 != null ? TypeUtilsKt.p(g2) : null);
            }
            if (intersectionTypeConstructor != null) {
                intersectionTypeConstructor3 = intersectionTypeConstructor;
            }
            return intersectionTypeConstructor3.f();
        } else {
            return f0Var;
        }
    }

    @k.e.a.d
    public c1 a(@k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
        c1 d2;
        if (gVar instanceof z) {
            c1 L0 = ((z) gVar).L0();
            if (L0 instanceof f0) {
                d2 = b((f0) L0);
            } else if (L0 instanceof h.p2.b0.g.t.n.u) {
                h.p2.b0.g.t.n.u uVar = (h.p2.b0.g.t.n.u) L0;
                f0 b = b(uVar.Q0());
                f0 b2 = b(uVar.R0());
                if (b == uVar.Q0() && b2 == uVar.R0()) {
                    d2 = L0;
                } else {
                    KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
                    d2 = KotlinTypeFactory.d(b, b2);
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return a1.b(d2, L0);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
