package h.p2.b0.g.t.e.a.y;

import h.a2.e1;
import h.k2.v.f0;
import h.p2.b0.g.t.e.a.p;
import h.p2.b0.g.t.n.x0;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;

/* loaded from: classes3.dex */
public final class m {
    @k.e.a.d
    public static final e a(@k.e.a.e NullabilityQualifier nullabilityQualifier, @k.e.a.e MutabilityQualifier mutabilityQualifier, boolean z, boolean z2) {
        if (z2 && nullabilityQualifier == NullabilityQualifier.NOT_NULL) {
            return new e(nullabilityQualifier, mutabilityQualifier, true, z);
        }
        return new e(nullabilityQualifier, mutabilityQualifier, false, z);
    }

    public static final boolean b(@k.e.a.d x0 x0Var, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
        return x0Var.l0(gVar, p.q);
    }

    @k.e.a.e
    public static final <T> T c(@k.e.a.d Set<? extends T> set, @k.e.a.d T t, @k.e.a.d T t2, @k.e.a.e T t3, boolean z) {
        Set<? extends T> N5;
        if (z) {
            T t4 = set.contains(t) ? t : set.contains(t2) ? t2 : null;
            if (f0.g(t4, t) && f0.g(t3, t2)) {
                return null;
            }
            return t3 == null ? t4 : t3;
        }
        if (t3 != null && (N5 = CollectionsKt___CollectionsKt.N5(e1.D(set, t3))) != null) {
            set = N5;
        }
        return (T) CollectionsKt___CollectionsKt.V4(set);
    }

    @k.e.a.e
    public static final NullabilityQualifier d(@k.e.a.d Set<? extends NullabilityQualifier> set, @k.e.a.e NullabilityQualifier nullabilityQualifier, boolean z) {
        NullabilityQualifier nullabilityQualifier2 = NullabilityQualifier.FORCE_FLEXIBILITY;
        return nullabilityQualifier == nullabilityQualifier2 ? nullabilityQualifier2 : (NullabilityQualifier) c(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, nullabilityQualifier, z);
    }
}
