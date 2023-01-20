package h.p2.b0.g.t.c.d1;

import h.p2.b0.g.t.c.o0;

/* loaded from: classes3.dex */
public abstract class w extends j implements h.p2.b0.g.t.c.b0 {
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private final h.p2.b0.g.t.g.c f15162e;

    public w(@k.e.a.d h.p2.b0.g.t.c.z zVar, @k.e.a.d h.p2.b0.g.t.g.c cVar) {
        super(zVar, h.p2.b0.g.t.c.b1.e.w0.b(), cVar.h(), o0.a);
        this.f15162e = cVar;
    }

    @Override // h.p2.b0.g.t.c.k
    public <R, D> R B(@k.e.a.d h.p2.b0.g.t.c.m<R, D> mVar, D d2) {
        return mVar.h(this, d2);
    }

    @Override // h.p2.b0.g.t.c.b0
    @k.e.a.d
    public final h.p2.b0.g.t.g.c e() {
        return this.f15162e;
    }

    @Override // h.p2.b0.g.t.c.d1.j, h.p2.b0.g.t.c.n
    @k.e.a.d
    public o0 getSource() {
        return o0.a;
    }

    @Override // h.p2.b0.g.t.c.d1.i
    @k.e.a.d
    public String toString() {
        return h.k2.v.f0.C("package ", this.f15162e);
    }

    @Override // h.p2.b0.g.t.c.d1.j, h.p2.b0.g.t.c.k
    @k.e.a.d
    public h.p2.b0.g.t.c.z b() {
        return (h.p2.b0.g.t.c.z) super.b();
    }
}
