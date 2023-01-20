package h.p2.b0.g.t.n.h1;

import h.k2.v.f0;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes3.dex */
public final class a<T> {
    private final T a;
    private final T b;

    public a(T t, T t2) {
        this.a = t;
        this.b = t2;
    }

    public final T a() {
        return this.a;
    }

    public final T b() {
        return this.b;
    }

    public final T c() {
        return this.a;
    }

    public final T d() {
        return this.b;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f0.g(this.a, aVar.a) && f0.g(this.b, aVar.b);
        }
        return false;
    }

    public int hashCode() {
        T t = this.a;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.b;
        return hashCode + (t2 != null ? t2.hashCode() : 0);
    }

    @d
    public String toString() {
        return "ApproximationBounds(lower=" + this.a + ", upper=" + this.b + ')';
    }
}
