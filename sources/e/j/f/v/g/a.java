package e.j.f.v.g;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public final class a {
    private final b[] a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11717c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11718d;

    public a(int i2, int i3) {
        b[] bVarArr = new b[i2];
        this.a = bVarArr;
        int length = bVarArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.a[i4] = new b(((i3 + 4) * 17) + 1);
        }
        this.f11718d = i3 * 17;
        this.f11717c = i2;
        this.b = -1;
    }

    public b a() {
        return this.a[this.b];
    }

    public byte[][] b() {
        return c(1, 1);
    }

    public byte[][] c(int i2, int i3) {
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, this.f11717c * i3, this.f11718d * i2);
        int i4 = this.f11717c * i3;
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[(i4 - i5) - 1] = this.a[i5 / i3].b(i2);
        }
        return bArr;
    }

    public void d(int i2, int i3, byte b) {
        this.a[i3].c(i2, b);
    }

    public void e() {
        this.b++;
    }
}
