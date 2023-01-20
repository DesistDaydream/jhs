package h.p2.b0.g.t.c.d1;

import kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;

/* loaded from: classes3.dex */
public interface x {
    @k.e.a.d
    public static final a a = a.a;

    /* loaded from: classes3.dex */
    public static final class a {
        public static final /* synthetic */ a a = new a();
        @k.e.a.d
        private static final h.p2.b0.g.t.c.y<x> b = new h.p2.b0.g.t.c.y<>("PackageViewDescriptorFactory");

        private a() {
        }

        @k.e.a.d
        public final h.p2.b0.g.t.c.y<x> a() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements x {
        @k.e.a.d
        public static final b b = new b();

        private b() {
        }

        @Override // h.p2.b0.g.t.c.d1.x
        @k.e.a.d
        public h.p2.b0.g.t.c.f0 a(@k.e.a.d ModuleDescriptorImpl moduleDescriptorImpl, @k.e.a.d h.p2.b0.g.t.g.c cVar, @k.e.a.d h.p2.b0.g.t.m.m mVar) {
            return new LazyPackageViewDescriptorImpl(moduleDescriptorImpl, cVar, mVar);
        }
    }

    @k.e.a.d
    h.p2.b0.g.t.c.f0 a(@k.e.a.d ModuleDescriptorImpl moduleDescriptorImpl, @k.e.a.d h.p2.b0.g.t.g.c cVar, @k.e.a.d h.p2.b0.g.t.m.m mVar);
}
