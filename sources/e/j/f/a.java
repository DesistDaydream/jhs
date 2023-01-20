package e.j.f;

import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public abstract class a {
    private final e a;

    public a(e eVar) {
        this.a = eVar;
    }

    public abstract a a(e eVar);

    public abstract e.j.f.q.b b() throws NotFoundException;

    public abstract e.j.f.q.a c(int i2, e.j.f.q.a aVar) throws NotFoundException;

    public final int d() {
        return this.a.b();
    }

    public final e e() {
        return this.a;
    }

    public final int f() {
        return this.a.e();
    }
}
