package e.j.f.o.e;

/* loaded from: classes2.dex */
public abstract class g {
    public static final g b = new e(null, 0, 0);
    private final g a;

    public g(g gVar) {
        this.a = gVar;
    }

    public final g a(int i2, int i3) {
        return new e(this, i2, i3);
    }

    public final g b(int i2, int i3) {
        return new b(this, i2, i3);
    }

    public abstract void c(e.j.f.q.a aVar, byte[] bArr);

    public final g d() {
        return this.a;
    }
}
