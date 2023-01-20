package kotlin.reflect.jvm.internal.impl.load.java;

import h.k2.u.l;
import h.p2.b0.g.t.b.f;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: classes3.dex */
public final class SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2 extends Lambda implements l<CallableMemberDescriptor, Boolean> {
    public static final SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2 INSTANCE = new SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2();

    public SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(invoke2(callableMemberDescriptor));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d CallableMemberDescriptor callableMemberDescriptor) {
        if (f.d0(callableMemberDescriptor)) {
            BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.n;
            if (BuiltinMethodsWithSpecialGenericSignature.m(callableMemberDescriptor) != null) {
                return true;
            }
        }
        return false;
    }
}
