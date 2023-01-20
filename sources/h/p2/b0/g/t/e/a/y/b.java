package h.p2.b0.g.t.e.a.y;

import h.k2.v.f0;
import h.p2.b0.g.t.c.b1.e;
import java.util.Iterator;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes3.dex */
public final class b implements h.p2.b0.g.t.c.b1.e {
    @k.e.a.d
    private final h.p2.b0.g.t.g.c a;

    public b(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        this.a = cVar;
    }

    @Override // h.p2.b0.g.t.c.b1.e
    @k.e.a.e
    /* renamed from: a */
    public a c(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        if (f0.g(cVar, this.a)) {
            return a.a;
        }
        return null;
    }

    @Override // h.p2.b0.g.t.c.b1.e
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    @k.e.a.d
    public Iterator<h.p2.b0.g.t.c.b1.c> iterator() {
        return CollectionsKt__CollectionsKt.E().iterator();
    }

    @Override // h.p2.b0.g.t.c.b1.e
    public boolean n(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        return e.b.b(this, cVar);
    }
}
