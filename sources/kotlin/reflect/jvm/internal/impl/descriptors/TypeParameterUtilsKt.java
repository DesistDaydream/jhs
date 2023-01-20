package kotlin.reflect.jvm.internal.impl.descriptors;

import h.a2.u;
import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.c.b;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.c.g;
import h.p2.b0.g.t.c.h0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.k.c;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.s;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes3.dex */
public final class TypeParameterUtilsKt {
    @e
    public static final h0 a(@d z zVar) {
        f c2 = zVar.I0().c();
        return b(zVar, c2 instanceof g ? (g) c2 : null, 0);
    }

    private static final h0 b(z zVar, g gVar, int i2) {
        if (gVar == null || s.r(gVar)) {
            return null;
        }
        int size = gVar.s().size() + i2;
        if (!gVar.n()) {
            if (size != zVar.H0().size()) {
                c.E(gVar);
            }
            return new h0(gVar, zVar.H0().subList(i2, zVar.H0().size()), null);
        }
        List<s0> subList = zVar.H0().subList(i2, size);
        k b = gVar.b();
        return new h0(gVar, subList, b(zVar, b instanceof g ? (g) b : null, size));
    }

    private static final b c(t0 t0Var, k kVar, int i2) {
        return new b(t0Var, kVar, i2);
    }

    @d
    public static final List<t0> d(@d g gVar) {
        List<t0> list;
        k kVar;
        q0 j2;
        List<t0> s = gVar.s();
        if (gVar.n() || (gVar.b() instanceof a)) {
            List V2 = SequencesKt___SequencesKt.V2(SequencesKt___SequencesKt.A0(SequencesKt___SequencesKt.i0(SequencesKt___SequencesKt.S2(DescriptorUtilsKt.m(gVar), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1.INSTANCE), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2.INSTANCE), TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3.INSTANCE));
            Iterator<k> it = DescriptorUtilsKt.m(gVar).iterator();
            while (true) {
                list = null;
                if (!it.hasNext()) {
                    kVar = null;
                    break;
                }
                kVar = it.next();
                if (kVar instanceof h.p2.b0.g.t.c.d) {
                    break;
                }
            }
            h.p2.b0.g.t.c.d dVar = (h.p2.b0.g.t.c.d) kVar;
            if (dVar != null && (j2 = dVar.j()) != null) {
                list = j2.getParameters();
            }
            if (list == null) {
                list = CollectionsKt__CollectionsKt.E();
            }
            if (V2.isEmpty() && list.isEmpty()) {
                return gVar.s();
            }
            List<t0> q4 = CollectionsKt___CollectionsKt.q4(V2, list);
            ArrayList arrayList = new ArrayList(u.Y(q4, 10));
            for (t0 t0Var : q4) {
                arrayList.add(c(t0Var, gVar, s.size()));
            }
            return CollectionsKt___CollectionsKt.q4(s, arrayList);
        }
        return s;
    }
}
