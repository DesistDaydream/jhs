package h.p2.b0.g.t.e.b;

import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.p0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;

/* loaded from: classes3.dex */
public final class n implements o0 {
    @k.e.a.d
    private final LazyJavaPackageFragment b;

    public n(@k.e.a.d LazyJavaPackageFragment lazyJavaPackageFragment) {
        this.b = lazyJavaPackageFragment;
    }

    @Override // h.p2.b0.g.t.c.o0
    @k.e.a.d
    public p0 b() {
        return p0.a;
    }

    @k.e.a.d
    public String toString() {
        return this.b + ": " + this.b.I0().keySet();
    }
}
