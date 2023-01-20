package e.j.f;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: classes2.dex */
public final class i extends e {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f11336c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11337d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11338e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11339f;

    /* renamed from: g  reason: collision with root package name */
    private final int f11340g;

    public i(int i2, int i3, int[] iArr) {
        super(i2, i3);
        this.f11337d = i2;
        this.f11338e = i3;
        this.f11339f = 0;
        this.f11340g = 0;
        int i4 = i2 * i3;
        this.f11336c = new byte[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = iArr[i5];
            this.f11336c[i5] = (byte) (((((i6 >> 16) & 255) + ((i6 >> 7) & TypedValues.Position.TYPE_POSITION_TYPE)) + (i6 & 255)) / 4);
        }
    }

    @Override // e.j.f.e
    public e a(int i2, int i3, int i4, int i5) {
        return new i(this.f11336c, this.f11337d, this.f11338e, this.f11339f + i2, this.f11340g + i3, i4, i5);
    }

    @Override // e.j.f.e
    public byte[] c() {
        int e2 = e();
        int b = b();
        int i2 = this.f11337d;
        if (e2 == i2 && b == this.f11338e) {
            return this.f11336c;
        }
        int i3 = e2 * b;
        byte[] bArr = new byte[i3];
        int i4 = (this.f11340g * i2) + this.f11339f;
        if (e2 == i2) {
            System.arraycopy(this.f11336c, i4, bArr, 0, i3);
            return bArr;
        }
        for (int i5 = 0; i5 < b; i5++) {
            System.arraycopy(this.f11336c, i4, bArr, i5 * e2, e2);
            i4 += this.f11337d;
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
            System.arraycopy(this.f11336c, ((i2 + this.f11340g) * this.f11337d) + this.f11339f, bArr, 0, e2);
            return bArr;
        }
        throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i2)));
    }

    @Override // e.j.f.e
    public boolean g() {
        return true;
    }

    private i(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i6, i7);
        if (i6 + i4 <= i2 && i7 + i5 <= i3) {
            this.f11336c = bArr;
            this.f11337d = i2;
            this.f11338e = i3;
            this.f11339f = i4;
            this.f11340g = i5;
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }
}
