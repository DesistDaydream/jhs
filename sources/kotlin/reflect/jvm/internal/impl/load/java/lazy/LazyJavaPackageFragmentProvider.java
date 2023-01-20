package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import h.a0;
import h.k2.u.l;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.e0;
import h.p2.b0.g.t.e.a.v.b;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.a.v.h;
import h.p2.b0.g.t.e.a.x.u;
import h.p2.b0.g.t.g.c;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.m.a;
import java.util.Collection;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;

/* loaded from: classes3.dex */
public final class LazyJavaPackageFragmentProvider implements e0 {
    @d
    private final e a;
    @d
    private final a<c, LazyJavaPackageFragment> b;

    public LazyJavaPackageFragmentProvider(@d b bVar) {
        e eVar = new e(bVar, h.a.a, a0.e(null));
        this.a = eVar;
        this.b = eVar.e().a();
    }

    private final LazyJavaPackageFragment e(c cVar) {
        u b = this.a.a().d().b(cVar);
        if (b == null) {
            return null;
        }
        return this.b.a(cVar, new LazyJavaPackageFragmentProvider$getPackageFragment$1(this, b));
    }

    @Override // h.p2.b0.g.t.c.c0
    @d
    public List<LazyJavaPackageFragment> a(@d c cVar) {
        return CollectionsKt__CollectionsKt.M(e(cVar));
    }

    @Override // h.p2.b0.g.t.c.e0
    public void b(@d c cVar, @d Collection<b0> collection) {
        h.p2.b0.g.t.p.a.a(collection, e(cVar));
    }

    @Override // h.p2.b0.g.t.c.e0
    public boolean c(@d c cVar) {
        return this.a.a().d().b(cVar) == null;
    }

    @Override // h.p2.b0.g.t.c.c0
    @d
    /* renamed from: f */
    public List<c> p(@d c cVar, @d l<? super f, Boolean> lVar) {
        LazyJavaPackageFragment e2 = e(cVar);
        List<c> K0 = e2 == null ? null : e2.K0();
        return K0 != null ? K0 : CollectionsKt__CollectionsKt.E();
    }
}
