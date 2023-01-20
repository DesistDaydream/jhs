package e.j.f;

/* loaded from: classes2.dex */
public abstract class e {
    private final int a;
    private final int b;

    public e(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    public e a(int i2, int i3, int i4, int i5) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }

    public final int b() {
        return this.b;
    }

    public abstract byte[] c();

    public abstract byte[] d(int i2, byte[] bArr);

    public final int e() {
        return this.a;
    }

    public e f() {
        return new d(this);
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public e i() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public e j() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public final String toString() {
        int i2 = this.a;
        byte[] bArr = new byte[i2];
        StringBuilder sb = new StringBuilder(this.b * (i2 + 1));
        for (int i3 = 0; i3 < this.b; i3++) {
            bArr = d(i3, bArr);
            for (int i4 = 0; i4 < this.a; i4++) {
                int i5 = bArr[i4] & 255;
                sb.append(i5 < 64 ? '#' : i5 < 128 ? '+' : i5 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
