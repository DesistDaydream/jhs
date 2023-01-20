package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import h.k2.u.l;
import h.p2.b0.g.t.b.k.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer$isMutabilityViolation$2 extends Lambda implements l<CallableMemberDescriptor, Boolean> {
    public final /* synthetic */ JvmBuiltInsCustomizer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltInsCustomizer$isMutabilityViolation$2(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        super(1);
        this.this$0 = jvmBuiltInsCustomizer;
    }

    @Override // h.k2.u.l
    public final Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        boolean z;
        d dVar;
        if (callableMemberDescriptor.i() == CallableMemberDescriptor.Kind.DECLARATION) {
            dVar = this.this$0.b;
            if (dVar.c((h.p2.b0.g.t.c.d) callableMemberDescriptor.b())) {
                z = true;
                return Boolean.valueOf(z);
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
