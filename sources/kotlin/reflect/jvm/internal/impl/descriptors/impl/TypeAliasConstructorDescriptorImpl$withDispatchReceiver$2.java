package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import h.k2.u.a;
import h.p2.b0.g.t.c.c;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.s0;
import h.p2.b0.g.t.m.m;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* loaded from: classes3.dex */
public final class TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2 extends Lambda implements a<TypeAliasConstructorDescriptorImpl> {
    public final /* synthetic */ c $underlyingConstructorDescriptor;
    public final /* synthetic */ TypeAliasConstructorDescriptorImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2(TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl, c cVar) {
        super(0);
        this.this$0 = typeAliasConstructorDescriptorImpl;
        this.$underlyingConstructorDescriptor = cVar;
    }

    @Override // h.k2.u.a
    @e
    public final TypeAliasConstructorDescriptorImpl invoke() {
        TypeSubstitutor c2;
        m N = this.this$0.N();
        s0 k1 = this.this$0.k1();
        c cVar = this.$underlyingConstructorDescriptor;
        TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl = new TypeAliasConstructorDescriptorImpl(N, k1, cVar, this.this$0, cVar.getAnnotations(), this.$underlyingConstructorDescriptor.i(), this.this$0.k1().getSource(), null);
        TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl2 = this.this$0;
        c cVar2 = this.$underlyingConstructorDescriptor;
        c2 = TypeAliasConstructorDescriptorImpl.H.c(typeAliasConstructorDescriptorImpl2.k1());
        if (c2 == null) {
            return null;
        }
        m0 M = cVar2.M();
        typeAliasConstructorDescriptorImpl.N0(null, M == null ? null : M.c(c2), typeAliasConstructorDescriptorImpl2.k1().s(), typeAliasConstructorDescriptorImpl2.h(), typeAliasConstructorDescriptorImpl2.getReturnType(), Modality.FINAL, typeAliasConstructorDescriptorImpl2.k1().getVisibility());
        return typeAliasConstructorDescriptorImpl;
    }
}
