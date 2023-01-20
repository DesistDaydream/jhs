package h.p2.b0.g.t.c.f1.a;

import h.p2.b0.g.t.e.b.k;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class g implements h.p2.b0.g.t.e.b.k {
    @k.e.a.d
    private final ClassLoader a;
    @k.e.a.d
    private final h.p2.b0.g.t.l.b.w.c b = new h.p2.b0.g.t.l.b.w.c();

    public g(@k.e.a.d ClassLoader classLoader) {
        this.a = classLoader;
    }

    private final k.a d(String str) {
        f a;
        Class<?> a2 = e.a(this.a, str);
        if (a2 == null || (a = f.f15191c.a(a2)) == null) {
            return null;
        }
        return new k.a.b(a, null, 2, null);
    }

    @Override // h.p2.b0.g.t.e.b.k
    @k.e.a.e
    public k.a a(@k.e.a.d h.p2.b0.g.t.e.a.x.g gVar) {
        h.p2.b0.g.t.g.c e2 = gVar.e();
        String b = e2 == null ? null : e2.b();
        if (b == null) {
            return null;
        }
        return d(b);
    }

    @Override // h.p2.b0.g.t.l.b.o
    @k.e.a.e
    public InputStream b(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        if (cVar.i(h.p2.b0.g.t.b.g.f15035m)) {
            return this.b.a(h.p2.b0.g.t.l.b.w.a.n.n(cVar));
        }
        return null;
    }

    @Override // h.p2.b0.g.t.e.b.k
    @k.e.a.e
    public k.a c(@k.e.a.d h.p2.b0.g.t.g.b bVar) {
        String b;
        b = h.b(bVar);
        return d(b);
    }
}
