package e.j.f.u.b0.g.e;

import com.google.zxing.FormatException;

/* loaded from: classes2.dex */
public final class o extends p {

    /* renamed from: d  reason: collision with root package name */
    public static final int f11612d = 10;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11613c;

    public o(int i2, int i3, int i4) throws FormatException {
        super(i2);
        if (i3 >= 0 && i3 <= 10 && i4 >= 0 && i4 <= 10) {
            this.b = i3;
            this.f11613c = i4;
            return;
        }
        throw FormatException.getFormatInstance();
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.f11613c;
    }

    public int d() {
        return (this.b * 10) + this.f11613c;
    }

    public boolean e() {
        return this.b == 10 || this.f11613c == 10;
    }

    public boolean f() {
        return this.b == 10;
    }

    public boolean g() {
        return this.f11613c == 10;
    }
}
