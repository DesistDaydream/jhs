package kotlin.reflect.jvm.internal.impl.load.java;

import h.k2.u.l;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.n.z;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class ErasedOverridabilityCondition$isOverridable$signatureTypes$1 extends Lambda implements l<v0, z> {
    public static final ErasedOverridabilityCondition$isOverridable$signatureTypes$1 INSTANCE = new ErasedOverridabilityCondition$isOverridable$signatureTypes$1();

    public ErasedOverridabilityCondition$isOverridable$signatureTypes$1() {
        super(1);
    }

    @Override // h.k2.u.l
    @d
    public final z invoke(v0 v0Var) {
        return v0Var.getType();
    }
}
