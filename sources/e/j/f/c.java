package e.j.f;

/* loaded from: classes2.dex */
public final class c {
    private final int a;
    private final int b;

    public c(int i2, int i3) {
        if (i2 >= 0 && i3 >= 0) {
            this.a = i2;
            this.b = i3;
            return;
        }
        throw new IllegalArgumentException();
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.a == cVar.a && this.b == cVar.b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.a * 32713) + this.b;
    }

    public String toString() {
        return this.a + "x" + this.b;
    }
}
