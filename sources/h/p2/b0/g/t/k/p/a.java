package h.p2.b0.g.t.k.p;

import h.a2.y;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.g.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public final class a implements e {
    @k.e.a.d
    private final List<e> b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@k.e.a.d List<? extends e> list) {
        this.b = list;
    }

    @Override // h.p2.b0.g.t.k.p.e
    @k.e.a.d
    public List<f> a(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        List<e> list = this.b;
        ArrayList arrayList = new ArrayList();
        for (e eVar : list) {
            y.q0(arrayList, eVar.a(dVar));
        }
        return arrayList;
    }

    @Override // h.p2.b0.g.t.k.p.e
    public void b(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d List<h.p2.b0.g.t.c.c> list) {
        for (e eVar : this.b) {
            eVar.b(dVar, list);
        }
    }

    @Override // h.p2.b0.g.t.k.p.e
    public void c(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d f fVar, @k.e.a.d Collection<n0> collection) {
        for (e eVar : this.b) {
            eVar.c(dVar, fVar, collection);
        }
    }

    @Override // h.p2.b0.g.t.k.p.e
    public void d(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d f fVar, @k.e.a.d Collection<n0> collection) {
        for (e eVar : this.b) {
            eVar.d(dVar, fVar, collection);
        }
    }

    @Override // h.p2.b0.g.t.k.p.e
    @k.e.a.d
    public List<f> e(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        List<e> list = this.b;
        ArrayList arrayList = new ArrayList();
        for (e eVar : list) {
            y.q0(arrayList, eVar.e(dVar));
        }
        return arrayList;
    }
}
