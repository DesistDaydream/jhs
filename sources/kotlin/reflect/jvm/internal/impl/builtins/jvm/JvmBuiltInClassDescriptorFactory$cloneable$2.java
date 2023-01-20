package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import h.a2.d1;
import h.a2.t;
import h.k2.u.a;
import h.k2.u.l;
import h.p2.b0.g.t.c.d1.g;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.m.m;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* loaded from: classes3.dex */
public final class JvmBuiltInClassDescriptorFactory$cloneable$2 extends Lambda implements a<g> {
    public final /* synthetic */ m $storageManager;
    public final /* synthetic */ JvmBuiltInClassDescriptorFactory this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmBuiltInClassDescriptorFactory$cloneable$2(JvmBuiltInClassDescriptorFactory jvmBuiltInClassDescriptorFactory, m mVar) {
        super(0);
        this.this$0 = jvmBuiltInClassDescriptorFactory;
        this.$storageManager = mVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final g invoke() {
        l lVar;
        z zVar;
        f fVar;
        z zVar2;
        lVar = this.this$0.b;
        zVar = this.this$0.a;
        k kVar = (k) lVar.invoke(zVar);
        fVar = JvmBuiltInClassDescriptorFactory.f16424g;
        Modality modality = Modality.ABSTRACT;
        ClassKind classKind = ClassKind.INTERFACE;
        zVar2 = this.this$0.a;
        g gVar = new g(kVar, fVar, modality, classKind, t.k(zVar2.k().i()), o0.a, false, this.$storageManager);
        gVar.G0(new h.p2.b0.g.t.b.k.a(this.$storageManager, gVar), d1.k(), null);
        return gVar;
    }
}
