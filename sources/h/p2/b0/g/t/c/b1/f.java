package h.p2.b0.g.t.c.b1;

import h.p2.b0.g.t.c.b1.e;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class f implements e {
    @k.e.a.d
    private final List<c> a;

    /* JADX WARN: Multi-variable type inference failed */
    public f(@k.e.a.d List<? extends c> list) {
        this.a = list;
    }

    @Override // h.p2.b0.g.t.c.b1.e
    @k.e.a.e
    public c c(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        return e.b.a(this, cVar);
    }

    @Override // h.p2.b0.g.t.c.b1.e
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.lang.Iterable
    @k.e.a.d
    public Iterator<c> iterator() {
        return this.a.iterator();
    }

    @Override // h.p2.b0.g.t.c.b1.e
    public boolean n(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        return e.b.b(this, cVar);
    }

    @k.e.a.d
    public String toString() {
        return this.a.toString();
    }
}
