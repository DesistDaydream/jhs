package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.a2.t0;
import h.k2.u.a;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.b.l;
import h.p2.b0.g.t.e.b.m;
import h.p2.b0.g.t.g.b;
import h.z0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import k.e.a.d;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyJavaPackageFragment$binaryClasses$2 extends Lambda implements a<Map<String, ? extends m>> {
    public final /* synthetic */ LazyJavaPackageFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment$binaryClasses$2(LazyJavaPackageFragment lazyJavaPackageFragment) {
        super(0);
        this.this$0 = lazyJavaPackageFragment;
    }

    @Override // h.k2.u.a
    @d
    public final Map<String, ? extends m> invoke() {
        e eVar;
        e eVar2;
        eVar = this.this$0.f16530g;
        List<String> a = eVar.a().o().a(this.this$0.e().b());
        LazyJavaPackageFragment lazyJavaPackageFragment = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (String str : a) {
            b m2 = b.m(h.p2.b0.g.t.k.p.d.d(str).e());
            eVar2 = lazyJavaPackageFragment.f16530g;
            m b = l.b(eVar2.a().j(), m2);
            Pair a2 = b == null ? null : z0.a(str, b);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return t0.B0(arrayList);
    }
}
