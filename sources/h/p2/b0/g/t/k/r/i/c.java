package h.p2.b0.g.t.k.r.i;

import h.k2.v.f0;

/* loaded from: classes3.dex */
public class c implements d, g {
    @k.e.a.d
    private final h.p2.b0.g.t.c.d a;
    @k.e.a.d
    private final c b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final h.p2.b0.g.t.c.d f15492c;

    public c(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.e c cVar) {
        this.a = dVar;
        this.b = cVar == null ? this : cVar;
        this.f15492c = dVar;
    }

    public boolean equals(@k.e.a.e Object obj) {
        h.p2.b0.g.t.c.d dVar = this.a;
        c cVar = obj instanceof c ? (c) obj : null;
        return f0.g(dVar, cVar != null ? cVar.a : null);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @k.e.a.d
    public String toString() {
        return "Class{" + getType() + '}';
    }

    @Override // h.p2.b0.g.t.k.r.i.g
    @k.e.a.d
    public final h.p2.b0.g.t.c.d u() {
        return this.a;
    }

    @Override // h.p2.b0.g.t.k.r.i.e
    @k.e.a.d
    public h.p2.b0.g.t.n.f0 getType() {
        return this.a.r();
    }
}
