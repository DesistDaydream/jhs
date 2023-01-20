package kotlin.reflect.jvm.internal.impl.load.java;

import h.k2.u.l;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: classes3.dex */
public final class ClassicBuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1 extends Lambda implements l<CallableMemberDescriptor, Boolean> {
    public static final ClassicBuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1 INSTANCE = new ClassicBuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1();

    public ClassicBuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(invoke2(callableMemberDescriptor));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d CallableMemberDescriptor callableMemberDescriptor) {
        return ClassicBuiltinSpecialProperties.a.b(callableMemberDescriptor);
    }
}
