package h.p2.b0.g.t.e.a;

import h.k2.v.f0;
import h.p2.b0.g.t.c.j0;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;

/* loaded from: classes3.dex */
public final class h implements ExternalOverridabilityCondition {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @k.e.a.d
    public ExternalOverridabilityCondition.Contract a() {
        return ExternalOverridabilityCondition.Contract.BOTH;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @k.e.a.d
    public ExternalOverridabilityCondition.Result b(@k.e.a.d h.p2.b0.g.t.c.a aVar, @k.e.a.d h.p2.b0.g.t.c.a aVar2, @k.e.a.e h.p2.b0.g.t.c.d dVar) {
        if ((aVar2 instanceof j0) && (aVar instanceof j0)) {
            j0 j0Var = (j0) aVar2;
            j0 j0Var2 = (j0) aVar;
            if (f0.g(j0Var.getName(), j0Var2.getName())) {
                if (h.p2.b0.g.t.e.a.v.i.b.a(j0Var) && h.p2.b0.g.t.e.a.v.i.b.a(j0Var2)) {
                    return ExternalOverridabilityCondition.Result.OVERRIDABLE;
                }
                if (!h.p2.b0.g.t.e.a.v.i.b.a(j0Var) && !h.p2.b0.g.t.e.a.v.i.b.a(j0Var2)) {
                    return ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
            }
            return ExternalOverridabilityCondition.Result.UNKNOWN;
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
