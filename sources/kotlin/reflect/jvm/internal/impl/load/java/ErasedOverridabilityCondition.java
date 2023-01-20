package kotlin.reflect.jvm.internal.impl.load.java;

import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.n.z;
import h.q2.m;
import java.util.Iterator;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes3.dex */
public final class ErasedOverridabilityCondition implements ExternalOverridabilityCondition {

    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[OverridingUtil.OverrideCompatibilityInfo.Result.values().length];
            iArr[OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;
            a = iArr;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @d
    public ExternalOverridabilityCondition.Contract a() {
        return ExternalOverridabilityCondition.Contract.SUCCESS_ONLY;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @d
    public ExternalOverridabilityCondition.Result b(@d h.p2.b0.g.t.c.a aVar, @d h.p2.b0.g.t.c.a aVar2, @e h.p2.b0.g.t.c.d dVar) {
        boolean z;
        n0 c2;
        boolean z2;
        if (aVar2 instanceof JavaMethodDescriptor) {
            JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) aVar2;
            if (!(!javaMethodDescriptor.getTypeParameters().isEmpty())) {
                OverridingUtil.OverrideCompatibilityInfo x = OverridingUtil.x(aVar, aVar2);
                if ((x == null ? null : x.c()) != null) {
                    return ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                m g2 = SequencesKt___SequencesKt.g2(SequencesKt___SequencesKt.d1(CollectionsKt___CollectionsKt.n1(javaMethodDescriptor.h()), ErasedOverridabilityCondition$isOverridable$signatureTypes$1.INSTANCE), javaMethodDescriptor.getReturnType());
                m0 Q = javaMethodDescriptor.Q();
                Iterator it = SequencesKt___SequencesKt.f2(g2, CollectionsKt__CollectionsKt.M(Q != null ? Q.getType() : null)).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    z zVar = (z) it.next();
                    if (!(!zVar.H0().isEmpty()) || (zVar.L0() instanceof RawTypeImpl)) {
                        z2 = false;
                        continue;
                    } else {
                        z2 = true;
                        continue;
                    }
                    if (z2) {
                        z = true;
                        break;
                    }
                }
                if (!z && (c2 = aVar.c(RawSubstitution.f16552c.c())) != null) {
                    if (c2 instanceof n0) {
                        n0 n0Var = (n0) c2;
                        if (!n0Var.getTypeParameters().isEmpty()) {
                            c2 = n0Var.x().o(CollectionsKt__CollectionsKt.E()).build();
                        }
                    }
                    if (a.a[OverridingUtil.f16771d.G(c2, aVar2, false).c().ordinal()] == 1) {
                        return ExternalOverridabilityCondition.Result.OVERRIDABLE;
                    }
                    return ExternalOverridabilityCondition.Result.UNKNOWN;
                }
                return ExternalOverridabilityCondition.Result.UNKNOWN;
            }
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
