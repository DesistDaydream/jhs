package h.p2.b0.g.t.k.n;

import com.j256.ormlite.stmt.query.SimpleComparison;
import h.k2.v.f0;

/* loaded from: classes3.dex */
public final class f {
    @k.e.a.d
    private final h.p2.b0.g.t.g.b a;
    private final int b;

    public f(@k.e.a.d h.p2.b0.g.t.g.b bVar, int i2) {
        this.a = bVar;
        this.b = i2;
    }

    @k.e.a.d
    public final h.p2.b0.g.t.g.b a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.b;
    }

    @k.e.a.d
    public final h.p2.b0.g.t.g.b d() {
        return this.a;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return f0.g(this.a, fVar.a) && this.b == fVar.b;
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    @k.e.a.d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int c2 = c();
        for (int i2 = 0; i2 < c2; i2++) {
            sb.append("kotlin/Array<");
        }
        sb.append(d());
        int c3 = c();
        for (int i3 = 0; i3 < c3; i3++) {
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        }
        return sb.toString();
    }
}
