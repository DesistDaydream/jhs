package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import h.k2.u.l;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.n.z;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: classes3.dex */
public final class SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$1 extends Lambda implements l<CallableMemberDescriptor, z> {
    public final /* synthetic */ v0 $p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$1(v0 v0Var) {
        super(1);
        this.$p = v0Var;
    }

    @Override // h.k2.u.l
    @d
    public final z invoke(@d CallableMemberDescriptor callableMemberDescriptor) {
        return callableMemberDescriptor.h().get(this.$p.f()).getType();
    }
}
