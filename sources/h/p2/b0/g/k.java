package h.p2.b0.g;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\bH\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "clearModuleByClassLoaderCache", "", "getOrCreateModule", "Ljava/lang/Class;", "kotlin-reflection"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class k {
    private static final ConcurrentMap<r, WeakReference<h.p2.b0.g.t.c.f1.a.k>> a = new ConcurrentHashMap();

    public static final void a() {
        a.clear();
    }

    @k.e.a.d
    public static final h.p2.b0.g.t.c.f1.a.k b(@k.e.a.d Class<?> cls) {
        ClassLoader f2 = ReflectClassUtilKt.f(cls);
        r rVar = new r(f2);
        ConcurrentMap<r, WeakReference<h.p2.b0.g.t.c.f1.a.k>> concurrentMap = a;
        WeakReference<h.p2.b0.g.t.c.f1.a.k> weakReference = concurrentMap.get(rVar);
        if (weakReference != null) {
            h.p2.b0.g.t.c.f1.a.k kVar = weakReference.get();
            if (kVar != null) {
                return kVar;
            }
            concurrentMap.remove(rVar, weakReference);
        }
        h.p2.b0.g.t.c.f1.a.k a2 = h.p2.b0.g.t.c.f1.a.k.f15192c.a(f2);
        while (true) {
            try {
                ConcurrentMap<r, WeakReference<h.p2.b0.g.t.c.f1.a.k>> concurrentMap2 = a;
                WeakReference<h.p2.b0.g.t.c.f1.a.k> putIfAbsent = concurrentMap2.putIfAbsent(rVar, new WeakReference<>(a2));
                if (putIfAbsent == null) {
                    return a2;
                }
                h.p2.b0.g.t.c.f1.a.k kVar2 = putIfAbsent.get();
                if (kVar2 != null) {
                    return kVar2;
                }
                concurrentMap2.remove(rVar, putIfAbsent);
            } finally {
                rVar.a(null);
            }
        }
    }
}
