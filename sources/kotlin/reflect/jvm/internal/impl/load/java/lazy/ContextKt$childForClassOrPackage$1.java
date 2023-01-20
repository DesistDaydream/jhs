package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import h.k2.u.a;
import h.p2.b0.g.t.c.e;
import h.p2.b0.g.t.e.a.n;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class ContextKt$childForClassOrPackage$1 extends Lambda implements a<n> {
    public final /* synthetic */ e $containingDeclaration;
    public final /* synthetic */ h.p2.b0.g.t.e.a.v.e $this_childForClassOrPackage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextKt$childForClassOrPackage$1(h.p2.b0.g.t.e.a.v.e eVar, e eVar2) {
        super(0);
        this.$this_childForClassOrPackage = eVar;
        this.$containingDeclaration = eVar2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @k.e.a.e
    public final n invoke() {
        return ContextKt.g(this.$this_childForClassOrPackage, this.$containingDeclaration.getAnnotations());
    }
}
