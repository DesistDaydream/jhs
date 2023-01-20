package e.k.c.a.a.k;

/* loaded from: classes2.dex */
public class l {
    private String a;
    private Character b;

    /* renamed from: c  reason: collision with root package name */
    private Character f11989c;

    /* renamed from: d  reason: collision with root package name */
    private int f11990d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f11991e = 0;

    public l(String str) {
        this.a = str;
    }

    public static boolean e(Character ch) {
        if (ch == null) {
            return false;
        }
        char charValue = ch.charValue();
        return (charValue >= '0' && charValue <= '9') || (charValue >= 'a' && charValue <= 'f') || (charValue >= 'A' && charValue <= 'F');
    }

    public static boolean g(Character ch) {
        char charValue;
        return ch != null && (charValue = ch.charValue()) >= '0' && charValue <= '7';
    }

    public void a(Character ch) {
        this.b = ch;
    }

    public boolean b() {
        if (this.b != null) {
            return true;
        }
        String str = this.a;
        return (str == null || str.length() == 0 || this.f11990d >= this.a.length()) ? false : true;
    }

    public boolean c(char c2) {
        Character ch = this.b;
        if (ch == null || ch.charValue() != c2) {
            String str = this.a;
            return str != null && str.length() != 0 && this.f11990d < this.a.length() && this.a.charAt(this.f11990d) == c2;
        }
        return true;
    }

    public int d() {
        return this.f11990d;
    }

    public void f() {
        this.f11989c = this.b;
        this.f11991e = this.f11990d;
    }

    public Character h() {
        Character ch = this.b;
        if (ch != null) {
            this.b = null;
            return ch;
        }
        String str = this.a;
        if (str == null || str.length() == 0 || this.f11990d >= this.a.length()) {
            return null;
        }
        String str2 = this.a;
        int i2 = this.f11990d;
        this.f11990d = i2 + 1;
        return Character.valueOf(str2.charAt(i2));
    }

    public Character i() {
        Character h2 = h();
        if (h2 != null && e(h2)) {
            return h2;
        }
        return null;
    }

    public Character j() {
        Character h2 = h();
        if (h2 != null && g(h2)) {
            return h2;
        }
        return null;
    }

    public Character k() {
        Character ch = this.b;
        if (ch != null) {
            return ch;
        }
        String str = this.a;
        if (str == null || str.length() == 0 || this.f11990d >= this.a.length()) {
            return null;
        }
        return Character.valueOf(this.a.charAt(this.f11990d));
    }

    public String l() {
        String substring = this.a.substring(this.f11990d);
        if (this.b != null) {
            return this.b + substring;
        }
        return substring;
    }

    public void m() {
        this.b = this.f11989c;
        this.f11990d = this.f11991e;
    }
}
