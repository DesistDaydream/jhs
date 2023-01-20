package h.p2.b0.g.t.g;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: classes3.dex */
public final class f implements Comparable<f> {
    @k.e.a.d
    private final String a;
    private final boolean b;

    private f(@k.e.a.d String str, boolean z) {
        if (str == null) {
            a(0);
        }
        this.a = str;
        this.b = z;
    }

    private static /* synthetic */ void a(int i2) {
        String str = (i2 == 1 || i2 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 1 || i2 == 2) ? 2 : 3];
        if (i2 == 1 || i2 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = "name";
        }
        if (i2 == 1) {
            objArr[1] = "asString";
        } else if (i2 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[1] = "getIdentifier";
        }
        switch (i2) {
            case 1:
            case 2:
                break;
            case 3:
                objArr[2] = "identifier";
                break;
            case 4:
                objArr[2] = "isValidIdentifier";
                break;
            case 5:
                objArr[2] = "special";
                break;
            case 6:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @k.e.a.d
    public static f e(@k.e.a.d String str) {
        if (str == null) {
            a(6);
        }
        if (str.startsWith(SimpleComparison.LESS_THAN_OPERATION)) {
            return i(str);
        }
        return f(str);
    }

    @k.e.a.d
    public static f f(@k.e.a.d String str) {
        if (str == null) {
            a(3);
        }
        return new f(str, false);
    }

    public static boolean h(@k.e.a.d String str) {
        if (str == null) {
            a(4);
        }
        if (str.isEmpty() || str.startsWith(SimpleComparison.LESS_THAN_OPERATION)) {
            return false;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '.' || charAt == '/' || charAt == '\\') {
                return false;
            }
        }
        return true;
    }

    @k.e.a.d
    public static f i(@k.e.a.d String str) {
        if (str == null) {
            a(5);
        }
        if (str.startsWith(SimpleComparison.LESS_THAN_OPERATION)) {
            return new f(str, true);
        }
        throw new IllegalArgumentException("special name must start with '<': " + str);
    }

    @k.e.a.d
    public String b() {
        String str = this.a;
        if (str == null) {
            a(1);
        }
        return str;
    }

    @Override // java.lang.Comparable
    /* renamed from: d */
    public int compareTo(f fVar) {
        return this.a.compareTo(fVar.a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.b == fVar.b && this.a.equals(fVar.a);
        }
        return false;
    }

    public boolean g() {
        return this.b;
    }

    @k.e.a.d
    public String getIdentifier() {
        if (!this.b) {
            String b = b();
            if (b == null) {
                a(2);
            }
            return b;
        }
        throw new IllegalStateException("not identifier: " + this);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + (this.b ? 1 : 0);
    }

    public String toString() {
        return this.a;
    }
}
