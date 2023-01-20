package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import h.k2.u.a;
import h.p2.b0.g.t.c.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;

/* loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1 extends Lambda implements a<d> {
    public final /* synthetic */ LazyJavaClassDescriptor $javaAnalogueDescriptor;
    public final /* synthetic */ d $kotlinMutableClassIfContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1(LazyJavaClassDescriptor lazyJavaClassDescriptor, d dVar) {
        super(0);
        this.$javaAnalogueDescriptor = lazyJavaClassDescriptor;
        this.$kotlinMutableClassIfContainer = dVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @k.e.a.d
    public final d invoke() {
        return this.$javaAnalogueDescriptor.J0(h.p2.b0.g.t.e.a.t.d.a, this.$kotlinMutableClassIfContainer);
    }
}
