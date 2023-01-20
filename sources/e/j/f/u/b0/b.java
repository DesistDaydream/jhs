package e.j.f.u.b0;

/* loaded from: classes2.dex */
public class b {
    private final int a;
    private final int b;

    public b(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b;
        }
        return false;
    }

    public final int hashCode() {
        return this.a ^ this.b;
    }

    public final String toString() {
        return this.a + "(" + this.b + ')';
    }
}
