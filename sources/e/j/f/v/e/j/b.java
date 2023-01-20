package e.j.f.v.e.j;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: f  reason: collision with root package name */
    public static final b f11704f = new b(e.j.f.v.a.a, 3);
    private final int[] a;
    private final int[] b;

    /* renamed from: c  reason: collision with root package name */
    private final c f11705c;

    /* renamed from: d  reason: collision with root package name */
    private final c f11706d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11707e;

    private b(int i2, int i3) {
        this.f11707e = i2;
        this.a = new int[i2];
        this.b = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.a[i5] = i4;
            i4 = (i4 * i3) % i2;
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.b[this.a[i6]] = i6;
        }
        this.f11705c = new c(this, new int[]{0});
        this.f11706d = new c(this, new int[]{1});
    }

    public int a(int i2, int i3) {
        return (i2 + i3) % this.f11707e;
    }

    public c b(int i2, int i3) {
        if (i2 >= 0) {
            if (i3 == 0) {
                return this.f11705c;
            }
            int[] iArr = new int[i2 + 1];
            iArr[0] = i3;
            return new c(this, iArr);
        }
        throw new IllegalArgumentException();
    }

    public int c(int i2) {
        return this.a[i2];
    }

    public c d() {
        return this.f11706d;
    }

    public int e() {
        return this.f11707e;
    }

    public c f() {
        return this.f11705c;
    }

    public int g(int i2) {
        if (i2 != 0) {
            return this.a[(this.f11707e - this.b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    public int h(int i2) {
        if (i2 != 0) {
            return this.b[i2];
        }
        throw new IllegalArgumentException();
    }

    public int i(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.a;
        int[] iArr2 = this.b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.f11707e - 1)];
    }

    public int j(int i2, int i3) {
        int i4 = this.f11707e;
        return ((i2 + i4) - i3) % i4;
    }
}
