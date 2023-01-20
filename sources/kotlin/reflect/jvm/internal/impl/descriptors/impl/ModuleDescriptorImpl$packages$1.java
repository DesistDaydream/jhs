package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import h.k2.u.l;
import h.p2.b0.g.t.c.d1.x;
import h.p2.b0.g.t.c.f0;
import h.p2.b0.g.t.g.c;
import h.p2.b0.g.t.m.m;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class ModuleDescriptorImpl$packages$1 extends Lambda implements l<c, f0> {
    public final /* synthetic */ ModuleDescriptorImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl$packages$1(ModuleDescriptorImpl moduleDescriptorImpl) {
        super(1);
        this.this$0 = moduleDescriptorImpl;
    }

    @Override // h.k2.u.l
    @d
    public final f0 invoke(@d c cVar) {
        x xVar;
        m mVar;
        xVar = this.this$0.f16465h;
        ModuleDescriptorImpl moduleDescriptorImpl = this.this$0;
        mVar = moduleDescriptorImpl.f16460c;
        return xVar.a(moduleDescriptorImpl, cVar, mVar);
    }
}
