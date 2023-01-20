package h.p2.b0.g.t.k.n;

import h.k2.v.f0;
import h.p2.b0.g.t.n.z;

/* loaded from: classes3.dex */
public abstract class g<T> {
    private final T a;

    public g(T t) {
        this.a = t;
    }

    public T a() {
        return this.a;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this != obj) {
            T a = a();
            g gVar = obj instanceof g ? (g) obj : null;
            if (!f0.g(a, gVar != null ? gVar.a() : null)) {
                return false;
            }
        }
        return true;
    }

    @k.e.a.d
    public abstract z getType(@k.e.a.d h.p2.b0.g.t.c.z zVar);

    public int hashCode() {
        T a = a();
        if (a == null) {
            return 0;
        }
        return a.hashCode();
    }

    @k.e.a.d
    public String toString() {
        return String.valueOf(a());
    }
}
