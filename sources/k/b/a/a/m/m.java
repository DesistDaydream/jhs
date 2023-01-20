package k.b.a.a.m;

import java.util.zip.Checksum;

/* loaded from: classes4.dex */
public class m implements Checksum {

    /* renamed from: h  reason: collision with root package name */
    private static final int f16124h = 16;

    /* renamed from: i  reason: collision with root package name */
    private static final int f16125i = 13;

    /* renamed from: j  reason: collision with root package name */
    private static final int f16126j = -1640531535;

    /* renamed from: k  reason: collision with root package name */
    private static final int f16127k = -2048144777;

    /* renamed from: l  reason: collision with root package name */
    private static final int f16128l = -1028477379;

    /* renamed from: m  reason: collision with root package name */
    private static final int f16129m = 668265263;
    private static final int n = 374761393;
    private final byte[] a;
    private final int[] b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f16130c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16131d;

    /* renamed from: e  reason: collision with root package name */
    private int f16132e;

    /* renamed from: f  reason: collision with root package name */
    private int f16133f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f16134g;

    public m() {
        this(0);
    }

    private static int a(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    private void b() {
        int[] iArr = this.b;
        int i2 = this.f16131d;
        iArr[0] = i2 + f16126j + f16127k;
        iArr[1] = f16127k + i2;
        iArr[2] = i2;
        iArr[3] = i2 - f16126j;
    }

    private void c(byte[] bArr, int i2) {
        int[] iArr = this.b;
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        int i6 = iArr[3];
        int rotateLeft = Integer.rotateLeft(i3 + (a(bArr, i2) * f16127k), 13) * f16126j;
        int rotateLeft2 = Integer.rotateLeft(i4 + (a(bArr, i2 + 4) * f16127k), 13) * f16126j;
        int rotateLeft3 = Integer.rotateLeft(i5 + (a(bArr, i2 + 8) * f16127k), 13) * f16126j;
        int rotateLeft4 = Integer.rotateLeft(i6 + (a(bArr, i2 + 12) * f16127k), 13) * f16126j;
        int[] iArr2 = this.b;
        iArr2[0] = rotateLeft;
        iArr2[1] = rotateLeft2;
        iArr2[2] = rotateLeft3;
        iArr2[3] = rotateLeft4;
        this.f16134g = true;
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        int i2;
        int i3 = 0;
        if (this.f16134g) {
            i2 = Integer.rotateLeft(this.b[0], 1) + Integer.rotateLeft(this.b[1], 7) + Integer.rotateLeft(this.b[2], 12) + Integer.rotateLeft(this.b[3], 18);
        } else {
            i2 = this.b[2] + n;
        }
        int i4 = i2 + this.f16132e;
        int i5 = this.f16133f - 4;
        while (i3 <= i5) {
            i4 = Integer.rotateLeft(i4 + (a(this.f16130c, i3) * f16128l), 17) * f16129m;
            i3 += 4;
        }
        while (i3 < this.f16133f) {
            i4 = Integer.rotateLeft(i4 + ((this.f16130c[i3] & 255) * n), 11) * f16126j;
            i3++;
        }
        int i6 = (i4 ^ (i4 >>> 15)) * f16127k;
        int i7 = (i6 ^ (i6 >>> 13)) * f16128l;
        return (i7 ^ (i7 >>> 16)) & 4294967295L;
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        b();
        this.f16132e = 0;
        this.f16133f = 0;
        this.f16134g = false;
    }

    @Override // java.util.zip.Checksum
    public void update(int i2) {
        byte[] bArr = this.a;
        bArr[0] = (byte) (i2 & 255);
        update(bArr, 0, 1);
    }

    public m(int i2) {
        this.a = new byte[1];
        this.b = new int[4];
        this.f16130c = new byte[16];
        this.f16131d = i2;
        b();
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i2, int i3) {
        if (i3 <= 0) {
            return;
        }
        this.f16132e += i3;
        int i4 = i2 + i3;
        int i5 = this.f16133f;
        if ((i5 + i3) - 16 < 0) {
            System.arraycopy(bArr, i2, this.f16130c, i5, i3);
            this.f16133f += i3;
            return;
        }
        if (i5 > 0) {
            int i6 = 16 - i5;
            System.arraycopy(bArr, i2, this.f16130c, i5, i6);
            c(this.f16130c, 0);
            i2 += i6;
        }
        int i7 = i4 - 16;
        while (i2 <= i7) {
            c(bArr, i2);
            i2 += 16;
        }
        if (i2 < i4) {
            int i8 = i4 - i2;
            this.f16133f = i8;
            System.arraycopy(bArr, i2, this.f16130c, 0, i8);
            return;
        }
        this.f16133f = 0;
    }
}
