package h.p2.b0.g.t.c.f1.a;

import h.p2.b0.g.t.c.f1.b.s;
import h.p2.b0.g.t.e.a.i;
import h.t2.u;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;

/* loaded from: classes3.dex */
public final class d implements h.p2.b0.g.t.e.a.i {
    @k.e.a.d
    private final ClassLoader a;

    public d(@k.e.a.d ClassLoader classLoader) {
        this.a = classLoader;
    }

    @Override // h.p2.b0.g.t.e.a.i
    @k.e.a.e
    public h.p2.b0.g.t.e.a.x.g a(@k.e.a.d i.a aVar) {
        h.p2.b0.g.t.g.b a = aVar.a();
        h.p2.b0.g.t.g.c h2 = a.h();
        String j2 = u.j2(a.i().b(), '.', '$', false, 4, null);
        if (!h2.d()) {
            j2 = h2.b() + '.' + j2;
        }
        Class<?> a2 = e.a(this.a, j2);
        if (a2 != null) {
            return new ReflectJavaClass(a2);
        }
        return null;
    }

    @Override // h.p2.b0.g.t.e.a.i
    @k.e.a.e
    public h.p2.b0.g.t.e.a.x.u b(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        return new s(cVar);
    }

    @Override // h.p2.b0.g.t.e.a.i
    @k.e.a.e
    public Set<String> c(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        return null;
    }
}
