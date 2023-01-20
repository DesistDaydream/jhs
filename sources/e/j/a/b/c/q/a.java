package e.j.a.b.c.q;

/* loaded from: classes2.dex */
public final class a {
    private final int a;
    private final int b;

    public a(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    public static a c(String str) throws NumberFormatException {
        if (str != null) {
            int indexOf = str.indexOf(42);
            if (indexOf < 0) {
                indexOf = str.indexOf(120);
            }
            if (indexOf >= 0) {
                try {
                    return new a(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
                } catch (NumberFormatException unused) {
                    throw d(str);
                }
            }
            throw d(str);
        }
        throw new IllegalArgumentException("string must not be null");
    }

    private static NumberFormatException d(String str) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 16);
        sb.append("Invalid Size: \"");
        sb.append(str);
        sb.append("\"");
        throw new NumberFormatException(sb.toString());
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.a == aVar.a && this.b == aVar.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.b;
        int i3 = this.a;
        return i2 ^ ((i3 >>> 16) | (i3 << 16));
    }

    public final String toString() {
        int i2 = this.a;
        int i3 = this.b;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i2);
        sb.append("x");
        sb.append(i3);
        return sb.toString();
    }
}
