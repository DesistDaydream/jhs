package kotlin.reflect.jvm.internal.impl.load.java;

import h.k2.u.l;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes3.dex */
public final class SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$1 extends Lambda implements l<CallableMemberDescriptor, Boolean> {
    public static final SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$1 INSTANCE = new SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$1();

    public SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(invoke2(callableMemberDescriptor));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d CallableMemberDescriptor callableMemberDescriptor) {
        return ClassicBuiltinSpecialProperties.a.b(DescriptorUtilsKt.o(callableMemberDescriptor));
    }
}
