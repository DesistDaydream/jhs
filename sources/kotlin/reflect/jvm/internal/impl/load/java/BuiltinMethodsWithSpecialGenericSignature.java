package kotlin.reflect.jvm.internal.impl.load.java;

import h.k2.k;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.e.b.r;
import h.p2.b0.g.t.g.f;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes3.dex */
public final class BuiltinMethodsWithSpecialGenericSignature extends SpecialGenericSignatures {
    @d
    public static final BuiltinMethodsWithSpecialGenericSignature n = new BuiltinMethodsWithSpecialGenericSignature();

    private BuiltinMethodsWithSpecialGenericSignature() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(CallableMemberDescriptor callableMemberDescriptor) {
        return CollectionsKt___CollectionsKt.J1(SpecialGenericSignatures.a.e(), r.d(callableMemberDescriptor));
    }

    @k
    @e
    public static final v k(@d v vVar) {
        if (n.l(vVar.getName())) {
            return (v) DescriptorUtilsKt.d(vVar, false, BuiltinMethodsWithSpecialGenericSignature$getOverriddenBuiltinFunctionWithErasedValueParametersInJava$1.INSTANCE, 1, null);
        }
        return null;
    }

    @k
    @e
    public static final SpecialGenericSignatures.SpecialSignatureInfo m(@d CallableMemberDescriptor callableMemberDescriptor) {
        SpecialGenericSignatures.a aVar = SpecialGenericSignatures.a;
        if (aVar.d().contains(callableMemberDescriptor.getName())) {
            CallableMemberDescriptor d2 = DescriptorUtilsKt.d(callableMemberDescriptor, false, BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1.INSTANCE, 1, null);
            String d3 = d2 == null ? null : r.d(d2);
            if (d3 == null) {
                return null;
            }
            return aVar.l(d3);
        }
        return null;
    }

    public final boolean l(@d f fVar) {
        return SpecialGenericSignatures.a.d().contains(fVar);
    }
}
