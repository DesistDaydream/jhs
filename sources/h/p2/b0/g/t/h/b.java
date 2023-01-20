package h.p2.b0.g.t.h;

/* loaded from: classes3.dex */
public abstract class b {
    @k.e.a.d
    private final String a;
    @k.e.a.d
    private final d b;

    @k.e.a.d
    public String a() {
        return b().getDescription();
    }

    @k.e.a.d
    public d b() {
        return this.b;
    }

    @k.e.a.d
    public String toString() {
        String a = a();
        if (a.length() > 0) {
            return this.a + " (" + a + ')';
        }
        return this.a;
    }
}
