package kotlin.reflect.jvm.internal.impl.resolve;

import h.p2.b0.g.t.c.a;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes3.dex */
public interface ExternalOverridabilityCondition {

    /* loaded from: classes3.dex */
    public enum Contract {
        CONFLICTS_ONLY,
        SUCCESS_ONLY,
        BOTH
    }

    /* loaded from: classes3.dex */
    public enum Result {
        OVERRIDABLE,
        CONFLICT,
        INCOMPATIBLE,
        UNKNOWN
    }

    @d
    Contract a();

    @d
    Result b(@d a aVar, @d a aVar2, @e h.p2.b0.g.t.c.d dVar);
}
