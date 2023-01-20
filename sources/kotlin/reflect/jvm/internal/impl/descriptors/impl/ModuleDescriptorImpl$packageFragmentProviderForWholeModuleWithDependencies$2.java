package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import h.a2.u;
import h.k2.u.a;
import h.p2.b0.g.t.c.c0;
import h.p2.b0.g.t.c.d1.h;
import h.p2.b0.g.t.c.d1.t;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2 extends Lambda implements a<h> {
    public final /* synthetic */ ModuleDescriptorImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2(ModuleDescriptorImpl moduleDescriptorImpl) {
        super(0);
        this.this$0 = moduleDescriptorImpl;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final h invoke() {
        t tVar;
        String L0;
        c0 c0Var;
        tVar = this.this$0.f16466i;
        ModuleDescriptorImpl moduleDescriptorImpl = this.this$0;
        if (tVar != null) {
            List<ModuleDescriptorImpl> a = tVar.a();
            a.contains(this.this$0);
            for (ModuleDescriptorImpl moduleDescriptorImpl2 : a) {
                moduleDescriptorImpl2.P0();
            }
            ArrayList arrayList = new ArrayList(u.Y(a, 10));
            for (ModuleDescriptorImpl moduleDescriptorImpl3 : a) {
                c0Var = moduleDescriptorImpl3.f16467j;
                arrayList.add(c0Var);
            }
            return new h(arrayList);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Dependencies of module ");
        L0 = moduleDescriptorImpl.L0();
        sb.append(L0);
        sb.append(" were not set before querying module content");
        throw new AssertionError(sb.toString());
    }
}
