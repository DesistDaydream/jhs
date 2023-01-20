package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import h.k2.u.l;
import h.p2.b0.g.t.n.z;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: classes3.dex */
public final class SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1 extends Lambda implements l<CallableMemberDescriptor, z> {
    public static final SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1 INSTANCE = new SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1();

    public SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1() {
        super(1);
    }

    @Override // h.k2.u.l
    @d
    public final z invoke(@d CallableMemberDescriptor callableMemberDescriptor) {
        return callableMemberDescriptor.getReturnType();
    }
}
