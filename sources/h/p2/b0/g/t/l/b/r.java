package h.p2.b0.g.t.l.b;

import h.a2.s0;
import h.p2.b0.g.t.c.o0;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: classes3.dex */
public final class r implements e {
    @k.e.a.d
    private final h.p2.b0.g.t.f.z.c a;
    @k.e.a.d
    private final h.p2.b0.g.t.f.z.a b;
    @k.e.a.d

    /* renamed from: c */
    private final h.k2.u.l<h.p2.b0.g.t.g.b, o0> f15527c;
    @k.e.a.d

    /* renamed from: d */
    private final Map<h.p2.b0.g.t.g.b, ProtoBuf.Class> f15528d;

    /* JADX WARN: Multi-variable type inference failed */
    public r(@k.e.a.d ProtoBuf.PackageFragment packageFragment, @k.e.a.d h.p2.b0.g.t.f.z.c cVar, @k.e.a.d h.p2.b0.g.t.f.z.a aVar, @k.e.a.d h.k2.u.l<? super h.p2.b0.g.t.g.b, ? extends o0> lVar) {
        this.a = cVar;
        this.b = aVar;
        this.f15527c = lVar;
        List<ProtoBuf.Class> class_List = packageFragment.getClass_List();
        LinkedHashMap linkedHashMap = new LinkedHashMap(h.o2.q.n(s0.j(h.a2.u.Y(class_List, 10)), 16));
        for (Object obj : class_List) {
            linkedHashMap.put(q.a(this.a, ((ProtoBuf.Class) obj).getFqName()), obj);
        }
        this.f15528d = linkedHashMap;
    }

    @Override // h.p2.b0.g.t.l.b.e
    @k.e.a.e
    public d a(@k.e.a.d h.p2.b0.g.t.g.b bVar) {
        ProtoBuf.Class r0 = this.f15528d.get(bVar);
        if (r0 == null) {
            return null;
        }
        return new d(this.a, r0, this.b, this.f15527c.invoke(bVar));
    }

    @k.e.a.d
    public final Collection<h.p2.b0.g.t.g.b> b() {
        return this.f15528d.keySet();
    }
}
