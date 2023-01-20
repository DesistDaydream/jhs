package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import h.a2.u;
import h.k2.u.l;
import h.k2.v.f0;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.c.c0;
import h.p2.b0.g.t.c.c1.a;
import h.p2.b0.g.t.c.c1.b;
import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.d.b.c;
import h.p2.b0.g.t.l.b.f;
import h.p2.b0.g.t.l.b.h;
import h.p2.b0.g.t.l.b.j;
import h.p2.b0.g.t.l.b.m;
import h.p2.b0.g.t.l.b.p;
import h.p2.b0.g.t.l.b.w.c;
import h.p2.b0.g.t.m.m;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Set;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl;

/* loaded from: classes3.dex */
public final class BuiltInsLoaderImpl implements BuiltInsLoader {
    @d
    private final c b = new c();

    @Override // kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader
    @d
    public c0 a(@d m mVar, @d z zVar, @d Iterable<? extends b> iterable, @d h.p2.b0.g.t.c.c1.c cVar, @d a aVar, boolean z) {
        return b(mVar, zVar, g.s, iterable, cVar, aVar, z, new BuiltInsLoaderImpl$createPackageFragmentProvider$1(this.b));
    }

    @d
    public final c0 b(@d m mVar, @d z zVar, @d Set<h.p2.b0.g.t.g.c> set, @d Iterable<? extends b> iterable, @d h.p2.b0.g.t.c.c1.c cVar, @d a aVar, boolean z, @d l<? super String, ? extends InputStream> lVar) {
        ArrayList<h.p2.b0.g.t.l.b.w.b> arrayList = new ArrayList(u.Y(set, 10));
        for (h.p2.b0.g.t.g.c cVar2 : set) {
            String n = h.p2.b0.g.t.l.b.w.a.n.n(cVar2);
            InputStream invoke = lVar.invoke(n);
            if (invoke != null) {
                arrayList.add(h.p2.b0.g.t.l.b.w.b.n.a(cVar2, mVar, zVar, invoke, z));
            } else {
                throw new IllegalStateException(f0.C("Resource not found in classpath: ", n));
            }
        }
        PackageFragmentProviderImpl packageFragmentProviderImpl = new PackageFragmentProviderImpl(arrayList);
        NotFoundClasses notFoundClasses = new NotFoundClasses(mVar, zVar);
        h.a aVar2 = h.a.a;
        j jVar = new j(packageFragmentProviderImpl);
        h.p2.b0.g.t.l.b.w.a aVar3 = h.p2.b0.g.t.l.b.w.a.n;
        h.p2.b0.g.t.l.b.g gVar = new h.p2.b0.g.t.l.b.g(mVar, zVar, aVar2, jVar, new h.p2.b0.g.t.l.b.b(zVar, notFoundClasses, aVar3), packageFragmentProviderImpl, p.a.a, h.p2.b0.g.t.l.b.l.a, c.a.a, m.a.a, iterable, notFoundClasses, f.a.a(), aVar, cVar, aVar3.e(), null, new h.p2.b0.g.t.k.q.b(mVar, CollectionsKt__CollectionsKt.E()), null, 327680, null);
        for (h.p2.b0.g.t.l.b.w.b bVar : arrayList) {
            bVar.H0(gVar);
        }
        return packageFragmentProviderImpl;
    }
}
