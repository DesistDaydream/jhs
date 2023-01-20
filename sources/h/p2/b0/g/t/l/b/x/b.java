package h.p2.b0.g.t.l.b.x;

import h.k2.v.n0;
import h.p2.b0.g.t.c.b1.e;
import h.p2.b0.g.t.m.l;
import h.p2.b0.g.t.m.m;
import h.p2.n;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes3.dex */
public class b implements h.p2.b0.g.t.c.b1.e {
    public static final /* synthetic */ n<Object>[] b = {n0.r(new PropertyReference1Impl(n0.d(b.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    @k.e.a.d
    private final h.p2.b0.g.t.m.h a;

    public b(@k.e.a.d m mVar, @k.e.a.d h.k2.u.a<? extends List<? extends h.p2.b0.g.t.c.b1.c>> aVar) {
        this.a = mVar.c(aVar);
    }

    private final List<h.p2.b0.g.t.c.b1.c> a() {
        return (List) l.a(this.a, this, b[0]);
    }

    @Override // h.p2.b0.g.t.c.b1.e
    @k.e.a.e
    public h.p2.b0.g.t.c.b1.c c(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        return e.b.a(this, cVar);
    }

    @Override // h.p2.b0.g.t.c.b1.e
    public boolean isEmpty() {
        return a().isEmpty();
    }

    @Override // java.lang.Iterable
    @k.e.a.d
    public Iterator<h.p2.b0.g.t.c.b1.c> iterator() {
        return a().iterator();
    }

    @Override // h.p2.b0.g.t.c.b1.e
    public boolean n(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        return e.b.b(this, cVar);
    }
}
