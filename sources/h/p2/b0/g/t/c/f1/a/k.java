package h.p2.b0.g.t.c.f1.a;

import h.k2.v.u;
import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.l.b.h;
import h.t1;
import h.t2.y;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;

/* loaded from: classes3.dex */
public final class k {
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public static final a f15192c = new a(null);
    @k.e.a.d
    private final h.p2.b0.g.t.l.b.g a;
    @k.e.a.d
    private final h.p2.b0.g.t.c.f1.a.a b;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k.e.a.d
        public final k a(@k.e.a.d ClassLoader classLoader) {
            LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("RuntimeModuleData");
            JvmBuiltIns jvmBuiltIns = new JvmBuiltIns(lockBasedStorageManager, JvmBuiltIns.Kind.FROM_DEPENDENCIES);
            ModuleDescriptorImpl moduleDescriptorImpl = new ModuleDescriptorImpl(h.p2.b0.g.t.g.f.i("<runtime module for " + classLoader + y.f15692e), lockBasedStorageManager, jvmBuiltIns, null, null, null, 56, null);
            jvmBuiltIns.B0(moduleDescriptorImpl);
            jvmBuiltIns.G0(moduleDescriptorImpl, true);
            g gVar = new g(classLoader);
            DeserializedDescriptorResolver deserializedDescriptorResolver = new DeserializedDescriptorResolver();
            h.p2.b0.g.t.e.a.v.g gVar2 = new h.p2.b0.g.t.e.a.v.g();
            NotFoundClasses notFoundClasses = new NotFoundClasses(lockBasedStorageManager, moduleDescriptorImpl);
            LazyJavaPackageFragmentProvider c2 = l.c(classLoader, moduleDescriptorImpl, lockBasedStorageManager, notFoundClasses, gVar, deserializedDescriptorResolver, gVar2, null, 128, null);
            h.p2.b0.g.t.e.b.c a = l.a(moduleDescriptorImpl, lockBasedStorageManager, notFoundClasses, c2, gVar, deserializedDescriptorResolver);
            deserializedDescriptorResolver.m(a);
            h.p2.b0.g.t.k.p.c cVar = new h.p2.b0.g.t.k.p.c(c2, h.p2.b0.g.t.e.a.t.d.a);
            gVar2.c(cVar);
            h.p2.b0.g.t.b.k.e eVar = new h.p2.b0.g.t.b.k.e(lockBasedStorageManager, new g(t1.class.getClassLoader()), moduleDescriptorImpl, notFoundClasses, jvmBuiltIns.F0(), jvmBuiltIns.F0(), h.a.a, h.p2.b0.g.t.n.e1.l.b.a(), new h.p2.b0.g.t.k.q.b(lockBasedStorageManager, CollectionsKt__CollectionsKt.E()));
            moduleDescriptorImpl.U0(moduleDescriptorImpl);
            moduleDescriptorImpl.O0(new h.p2.b0.g.t.c.d1.h(CollectionsKt__CollectionsKt.L(cVar.a(), eVar)));
            return new k(a.a(), new h.p2.b0.g.t.c.f1.a.a(deserializedDescriptorResolver, gVar), null);
        }
    }

    private k(h.p2.b0.g.t.l.b.g gVar, h.p2.b0.g.t.c.f1.a.a aVar) {
        this.a = gVar;
        this.b = aVar;
    }

    public /* synthetic */ k(h.p2.b0.g.t.l.b.g gVar, h.p2.b0.g.t.c.f1.a.a aVar, u uVar) {
        this(gVar, aVar);
    }

    @k.e.a.d
    public final h.p2.b0.g.t.l.b.g a() {
        return this.a;
    }

    @k.e.a.d
    public final z b() {
        return this.a.p();
    }

    @k.e.a.d
    public final h.p2.b0.g.t.c.f1.a.a c() {
        return this.b;
    }
}
