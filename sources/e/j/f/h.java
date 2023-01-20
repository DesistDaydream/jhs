package e.j.f;

import androidx.core.view.ViewCompat;

/* loaded from: classes2.dex */
public final class h extends e {

    /* renamed from: h  reason: collision with root package name */
    private static final int f11330h = 2;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f11331c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11332d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11333e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11334f;

    /* renamed from: g  reason: collision with root package name */
    private final int f11335g;

    public h(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        super(i6, i7);
        if (i4 + i6 <= i2 && i5 + i7 <= i3) {
            this.f11331c = bArr;
            this.f11332d = i2;
            this.f11333e = i3;
            this.f11334f = i4;
            this.f11335g = i5;
            if (z) {
                n(i6, i7);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }

    private void n(int i2, int i3) {
        byte[] bArr = this.f11331c;
        int i4 = (this.f11335g * this.f11332d) + this.f11334f;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = (i2 / 2) + i4;
            int i7 = (i4 + i2) - 1;
            int i8 = i4;
            while (i8 < i6) {
                byte b = bArr[i8];
                bArr[i8] = bArr[i7];
                bArr[i7] = b;
                i8++;
                i7--;
            }
            i5++;
            i4 += this.f11332d;
        }
    }

    @Override // e.j.f.e
    public e a(int i2, int i3, int i4, int i5) {
        return new h(this.f11331c, this.f11332d, this.f11333e, this.f11334f + i2, this.f11335g + i3, i4, i5, false);
    }

    @Override // e.j.f.e
    public byte[] c() {
        int e2 = e();
        int b = b();
        int i2 = this.f11332d;
        if (e2 == i2 && b == this.f11333e) {
            return this.f11331c;
        }
        int i3 = e2 * b;
        byte[] bArr = new byte[i3];
        int i4 = (this.f11335g * i2) + this.f11334f;
        if (e2 == i2) {
            System.arraycopy(this.f11331c, i4, bArr, 0, i3);
            return bArr;
        }
        for (int i5 = 0; i5 < b; i5++) {
            System.arraycopy(this.f11331c, i4, bArr, i5 * e2, e2);
            i4 += this.f11332d;
        }
        return bArr;
    }

    @Override // e.j.f.e
    public byte[] d(int i2, byte[] bArr) {
        if (i2 >= 0 && i2 < b()) {
            int e2 = e();
            if (bArr == null || bArr.length < e2) {
                bArr = new byte[e2];
            }
            System.arraycopy(this.f11331c, ((i2 + this.f11335g) * this.f11332d) + this.f11334f, bArr, 0, e2);
            return bArr;
        }
        throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i2)));
    }

    @Override // e.j.f.e
    public boolean g() {
        return true;
    }

    public int k() {
        return b() / 2;
    }

    public int l() {
        return e() / 2;
    }

    public int[] m() {
        int e2 = e() / 2;
        int b = b() / 2;
        int[] iArr = new int[e2 * b];
        byte[] bArr = this.f11331c;
        int i2 = (this.f11335g * this.f11332d) + this.f11334f;
        for (int i3 = 0; i3 < b; i3++) {
            int i4 = i3 * e2;
            for (int i5 = 0; i5 < e2; i5++) {
                iArr[i4 + i5] = ((bArr[(i5 << 1) + i2] & 255) * 65793) | ViewCompat.MEASURED_STATE_MASK;
            }
            i2 += this.f11332d << 1;
        }
        return iArr;
    }
}
