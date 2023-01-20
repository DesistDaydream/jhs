package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import h.k2.u.a;
import h.p2.b0.g.t.c.z;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;

/* loaded from: classes3.dex */
public final class JvmBuiltIns$initialize$1 extends Lambda implements a<JvmBuiltIns.a> {
    public final /* synthetic */ boolean $isAdditionalBuiltInsFeatureSupported;
    public final /* synthetic */ z $moduleDescriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltIns$initialize$1(z zVar, boolean z) {
        super(0);
        this.$moduleDescriptor = zVar;
        this.$isAdditionalBuiltInsFeatureSupported = z;
    }

    @Override // h.k2.u.a
    @d
    public final JvmBuiltIns.a invoke() {
        return new JvmBuiltIns.a(this.$moduleDescriptor, this.$isAdditionalBuiltInsFeatureSupported);
    }
}
