package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import h.k2.u.a;
import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.g.b;
import h.p2.b0.g.t.m.m;
import h.p2.b0.g.t.n.f0;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;

/* loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer$cloneableType$2 extends Lambda implements a<f0> {
    public final /* synthetic */ m $storageManager;
    public final /* synthetic */ JvmBuiltInsCustomizer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltInsCustomizer$cloneableType$2(JvmBuiltInsCustomizer jvmBuiltInsCustomizer, m mVar) {
        super(0);
        this.this$0 = jvmBuiltInsCustomizer;
        this.$storageManager = mVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final f0 invoke() {
        JvmBuiltIns.a s;
        JvmBuiltIns.a s2;
        s = this.this$0.s();
        z a = s.a();
        b a2 = JvmBuiltInClassDescriptorFactory.f16421d.a();
        m mVar = this.$storageManager;
        s2 = this.this$0.s();
        return FindClassInModuleKt.c(a, a2, new NotFoundClasses(mVar, s2.a())).r();
    }
}
