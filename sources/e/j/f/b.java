package e.j.f;

import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public final class b {
    private final a a;
    private e.j.f.q.b b;

    public b(a aVar) {
        if (aVar != null) {
            this.a = aVar;
            return;
        }
        throw new IllegalArgumentException("Binarizer must be non-null.");
    }

    public b a(int i2, int i3, int i4, int i5) {
        return new b(this.a.a(this.a.e().a(i2, i3, i4, i5)));
    }

    public e.j.f.q.b b() throws NotFoundException {
        if (this.b == null) {
            this.b = this.a.b();
        }
        return this.b;
    }

    public e.j.f.q.a c(int i2, e.j.f.q.a aVar) throws NotFoundException {
        return this.a.c(i2, aVar);
    }

    public int d() {
        return this.a.d();
    }

    public int e() {
        return this.a.f();
    }

    public boolean f() {
        return this.a.e().g();
    }

    public boolean g() {
        return this.a.e().h();
    }

    public b h() {
        return new b(this.a.a(this.a.e().i()));
    }

    public b i() {
        return new b(this.a.a(this.a.e().j()));
    }

    public String toString() {
        try {
            return b().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
