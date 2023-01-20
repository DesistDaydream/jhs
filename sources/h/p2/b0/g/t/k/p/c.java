package h.p2.b0.g.t.k.p;

import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.e.a.x.g;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class c {
    @k.e.a.d
    private final LazyJavaPackageFragmentProvider a;
    @k.e.a.d
    private final h.p2.b0.g.t.e.a.t.d b;

    public c(@k.e.a.d LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, @k.e.a.d h.p2.b0.g.t.e.a.t.d dVar) {
        this.a = lazyJavaPackageFragmentProvider;
        this.b = dVar;
    }

    @k.e.a.d
    public final LazyJavaPackageFragmentProvider a() {
        return this.a;
    }

    @k.e.a.e
    public final h.p2.b0.g.t.c.d b(@k.e.a.d g gVar) {
        LazyJavaPackageFragment lazyJavaPackageFragment;
        h.p2.b0.g.t.g.c e2 = gVar.e();
        if (e2 != null && gVar.L() == LightClassOriginKind.SOURCE) {
            return this.b.d(e2);
        }
        g f2 = gVar.f();
        if (f2 == null) {
            if (e2 == null || (lazyJavaPackageFragment = (LazyJavaPackageFragment) CollectionsKt___CollectionsKt.t2(this.a.a(e2.e()))) == null) {
                return null;
            }
            return lazyJavaPackageFragment.H0(gVar);
        }
        h.p2.b0.g.t.c.d b = b(f2);
        MemberScope U = b == null ? null : b.U();
        f f3 = U == null ? null : U.f(gVar.getName(), NoLookupLocation.FROM_JAVA_LOADER);
        if (f3 instanceof h.p2.b0.g.t.c.d) {
            return (h.p2.b0.g.t.c.d) f3;
        }
        return null;
    }
}
