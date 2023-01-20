package kotlin.reflect.jvm.internal.impl.load.java;

import h.k2.u.l;
import h.p2.b0.g.t.c.v;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: classes3.dex */
public final class BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1 extends Lambda implements l<CallableMemberDescriptor, Boolean> {
    public static final BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1 INSTANCE = new BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1();

    public BuiltinMethodsWithSpecialGenericSignature$getSpecialSignatureInfo$builtinSignature$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(invoke2(callableMemberDescriptor));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d CallableMemberDescriptor callableMemberDescriptor) {
        boolean j2;
        if (callableMemberDescriptor instanceof v) {
            j2 = BuiltinMethodsWithSpecialGenericSignature.n.j(callableMemberDescriptor);
            if (j2) {
                return true;
            }
        }
        return false;
    }
}
