package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import h.k2.u.a;
import h.p2.b0.g.t.c.x0;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;

/* loaded from: classes3.dex */
public final class ValueParameterDescriptorImpl$WithDestructuringDeclaration$copy$1 extends Lambda implements a<List<? extends x0>> {
    public final /* synthetic */ ValueParameterDescriptorImpl.WithDestructuringDeclaration this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ValueParameterDescriptorImpl$WithDestructuringDeclaration$copy$1(ValueParameterDescriptorImpl.WithDestructuringDeclaration withDestructuringDeclaration) {
        super(0);
        this.this$0 = withDestructuringDeclaration;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends x0> invoke() {
        return this.this$0.K0();
    }
}
