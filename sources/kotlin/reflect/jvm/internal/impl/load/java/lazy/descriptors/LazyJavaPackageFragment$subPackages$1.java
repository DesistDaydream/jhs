package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.e.a.x.u;
import h.p2.b0.g.t.g.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyJavaPackageFragment$subPackages$1 extends Lambda implements a<List<? extends c>> {
    public final /* synthetic */ LazyJavaPackageFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment$subPackages$1(LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(0);
        this.this$0 = lazyJavaPackageFragment;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends c> invoke() {
        u uVar;
        uVar = this.this$0.f16529f;
        Collection<u> v = uVar.v();
        ArrayList arrayList = new ArrayList(h.a2.u.Y(v, 10));
        for (u uVar2 : v) {
            arrayList.add(uVar2.e());
        }
        return arrayList;
    }
}
