package h.p2.b0.g.t.e.a;

import h.k2.v.f0;
import h.k2.v.u;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.e.b.h;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class m implements ExternalOverridabilityCondition {
    @k.e.a.d
    public static final a a = new a(null);

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        private final boolean b(v vVar) {
            if (vVar.h().size() != 1) {
                return false;
            }
            h.p2.b0.g.t.c.k b = vVar.b();
            h.p2.b0.g.t.c.d dVar = b instanceof h.p2.b0.g.t.c.d ? (h.p2.b0.g.t.c.d) b : null;
            if (dVar == null) {
                return false;
            }
            h.p2.b0.g.t.c.f c2 = ((v0) CollectionsKt___CollectionsKt.U4(vVar.h())).getType().I0().c();
            h.p2.b0.g.t.c.d dVar2 = c2 instanceof h.p2.b0.g.t.c.d ? (h.p2.b0.g.t.c.d) c2 : null;
            return dVar2 != null && h.p2.b0.g.t.b.f.o0(dVar) && f0.g(DescriptorUtilsKt.i(dVar), DescriptorUtilsKt.i(dVar2));
        }

        private final h.p2.b0.g.t.e.b.h c(v vVar, v0 v0Var) {
            if (!h.p2.b0.g.t.e.b.r.e(vVar) && !b(vVar)) {
                return h.p2.b0.g.t.e.b.r.g(v0Var.getType());
            }
            return h.p2.b0.g.t.e.b.r.g(TypeUtilsKt.p(v0Var.getType()));
        }

        public final boolean a(@k.e.a.d h.p2.b0.g.t.c.a aVar, @k.e.a.d h.p2.b0.g.t.c.a aVar2) {
            if ((aVar2 instanceof JavaMethodDescriptor) && (aVar instanceof v)) {
                JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) aVar2;
                javaMethodDescriptor.h().size();
                v vVar = (v) aVar;
                vVar.h().size();
                for (Pair pair : CollectionsKt___CollectionsKt.V5(javaMethodDescriptor.h0().h(), vVar.a().h())) {
                    if ((c((v) aVar2, (v0) pair.component1()) instanceof h.d) != (c(vVar, (v0) pair.component2()) instanceof h.d)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private final boolean c(h.p2.b0.g.t.c.a aVar, h.p2.b0.g.t.c.a aVar2, h.p2.b0.g.t.c.d dVar) {
        if ((aVar instanceof CallableMemberDescriptor) && (aVar2 instanceof v) && !h.p2.b0.g.t.b.f.d0(aVar2)) {
            v vVar = (v) aVar2;
            if (!BuiltinMethodsWithSpecialGenericSignature.n.l(vVar.getName()) && !SpecialGenericSignatures.a.k(vVar.getName())) {
                return false;
            }
            CallableMemberDescriptor e2 = SpecialBuiltinMembers.e((CallableMemberDescriptor) aVar);
            Boolean valueOf = Boolean.valueOf(vVar.z0());
            boolean z = aVar instanceof v;
            v vVar2 = z ? (v) aVar : null;
            if ((!f0.g(valueOf, vVar2 == null ? null : Boolean.valueOf(vVar2.z0()))) && (e2 == null || !vVar.z0())) {
                return true;
            }
            if ((dVar instanceof h.p2.b0.g.t.e.a.u.c) && vVar.q0() == null && e2 != null && !SpecialBuiltinMembers.f(dVar, e2)) {
                return ((e2 instanceof v) && z && BuiltinMethodsWithSpecialGenericSignature.k((v) e2) != null && f0.g(h.p2.b0.g.t.e.b.r.c(vVar, false, false, 2, null), h.p2.b0.g.t.e.b.r.c(((v) aVar).a(), false, false, 2, null))) ? false : true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @k.e.a.d
    public ExternalOverridabilityCondition.Contract a() {
        return ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @k.e.a.d
    public ExternalOverridabilityCondition.Result b(@k.e.a.d h.p2.b0.g.t.c.a aVar, @k.e.a.d h.p2.b0.g.t.c.a aVar2, @k.e.a.e h.p2.b0.g.t.c.d dVar) {
        if (c(aVar, aVar2, dVar)) {
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        if (a.a(aVar, aVar2)) {
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
