package h.p2.b0.g.t.e.a.y;

import h.k2.v.f0;

/* loaded from: classes3.dex */
public final class c<T> {
    private final T a;
    @k.e.a.e
    private final h.p2.b0.g.t.c.b1.e b;

    public c(T t, @k.e.a.e h.p2.b0.g.t.c.b1.e eVar) {
        this.a = t;
        this.b = eVar;
    }

    public final T a() {
        return this.a;
    }

    @k.e.a.e
    public final h.p2.b0.g.t.c.b1.e b() {
        return this.b;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return f0.g(this.a, cVar.a) && f0.g(this.b, cVar.b);
        }
        return false;
    }

    public int hashCode() {
        T t = this.a;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        h.p2.b0.g.t.c.b1.e eVar = this.b;
        return hashCode + (eVar != null ? eVar.hashCode() : 0);
    }

    @k.e.a.d
    public String toString() {
        return "EnhancementResult(result=" + this.a + ", enhancementAnnotations=" + this.b + ')';
    }
}
