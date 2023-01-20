package h.p2.b0.g.t.n.e1;

import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.c1;
import h.p2.b0.g.t.n.e1.g;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.r0;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class k {
    private static final List<s0> a(c1 c1Var, CaptureStatus captureStatus) {
        boolean z;
        if (c1Var.H0().size() != c1Var.I0().getParameters().size()) {
            return null;
        }
        List<s0> H0 = c1Var.H0();
        int i2 = 0;
        boolean z2 = true;
        if (!(H0 instanceof Collection) || !H0.isEmpty()) {
            Iterator<T> it = H0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((s0) it.next()).c() == Variance.INVARIANT) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    z2 = false;
                    break;
                }
            }
        }
        if (z2) {
            return null;
        }
        List<Pair> V5 = CollectionsKt___CollectionsKt.V5(H0, c1Var.I0().getParameters());
        ArrayList arrayList = new ArrayList(h.a2.u.Y(V5, 10));
        for (Pair pair : V5) {
            s0 s0Var = (s0) pair.component1();
            t0 t0Var = (t0) pair.component2();
            if (s0Var.c() != Variance.INVARIANT) {
                s0Var = TypeUtilsKt.a(new j(captureStatus, (s0Var.b() || s0Var.c() != Variance.IN_VARIANCE) ? null : s0Var.getType().L0(), s0Var, t0Var));
            }
            arrayList.add(s0Var);
        }
        TypeSubstitutor c2 = r0.f15601c.b(c1Var.I0(), arrayList).c();
        int size = H0.size() - 1;
        if (size >= 0) {
            while (true) {
                int i3 = i2 + 1;
                s0 s0Var2 = H0.get(i2);
                s0 s0Var3 = (s0) arrayList.get(i2);
                if (s0Var2.c() != Variance.INVARIANT) {
                    List<z> upperBounds = c1Var.I0().getParameters().get(i2).getUpperBounds();
                    ArrayList arrayList2 = new ArrayList();
                    for (z zVar : upperBounds) {
                        arrayList2.add(g.a.a.a(c2.n(zVar, Variance.INVARIANT).L0()));
                    }
                    if (!s0Var2.b() && s0Var2.c() == Variance.OUT_VARIANCE) {
                        arrayList2.add(g.a.a.a(s0Var2.getType().L0()));
                    }
                    ((j) s0Var3.getType()).I0().h(arrayList2);
                }
                if (i3 > size) {
                    break;
                }
                i2 = i3;
            }
        }
        return arrayList;
    }

    @k.e.a.e
    public static final f0 b(@k.e.a.d f0 f0Var, @k.e.a.d CaptureStatus captureStatus) {
        List<s0> a = a(f0Var, captureStatus);
        if (a == null) {
            return null;
        }
        return c(f0Var, a);
    }

    private static final f0 c(c1 c1Var, List<? extends s0> list) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        return KotlinTypeFactory.i(c1Var.getAnnotations(), c1Var.I0(), list, c1Var.J0(), null, 16, null);
    }
}
