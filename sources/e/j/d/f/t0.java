package e.j.d.f;

/* loaded from: classes2.dex */
public final class t0 {
    private final String a;
    private final long b;

    @e.j.a.b.c.x.d0
    public t0(String str, long j2) {
        this.a = (String) e.j.a.b.c.r.a0.k(str);
        this.b = j2;
    }

    public final String b() {
        return this.a;
    }

    public final long c() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof t0) {
            t0 t0Var = (t0) obj;
            return this.b == t0Var.b && this.a.equals(t0Var.a);
        }
        return false;
    }

    public final int hashCode() {
        return e.j.a.b.c.r.y.b(this.a, Long.valueOf(this.b));
    }
}
