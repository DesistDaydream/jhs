package k.b.a.a.k;

import com.umeng.analytics.pro.cb;
import k.b.a.a.k.j;
import org.apache.commons.codec.CodecPolicy;

/* loaded from: classes4.dex */
public class d extends j {
    private static final int D = 31;
    private static final long E = 15;
    private static final long F = 7;
    private static final long G = 3;
    private static final long H = 1;
    private static final int w = 5;
    private static final int x = 8;
    private static final int y = 5;
    private final int r;
    private final byte[] s;
    private final int t;
    private final byte[] u;
    private final byte[] v;
    private static final byte[] z = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, cb.f7124m, cb.n, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, cb.f7124m, cb.n, 17, 18, 19, 20, 21, 22, 23, 24, 25};
    private static final byte[] A = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55};
    private static final byte[] B = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, cb.f7124m, cb.n, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, cb.f7124m, cb.n, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    private static final byte[] C = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86};

    public d() {
        this(false);
    }

    private void A() {
        if (v()) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character(s) (before the paddings if any) are valid base 32 alphabet but not a possible encoding. Decoding requires either 2, 4, 5, or 7 trailing 5-bit characters to create bytes.");
        }
    }

    private void z(long j2, j.a aVar) {
        if (v() && (j2 & aVar.b) != 0) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 32 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v23 */
    @Override // k.b.a.a.k.j
    public void g(byte[] bArr, int i2, int i3, j.a aVar) {
        byte b;
        if (aVar.f16056f) {
            return;
        }
        ?? r3 = 1;
        if (i3 < 0) {
            aVar.f16056f = true;
        }
        int i4 = i2;
        int i5 = 0;
        while (true) {
            if (i5 >= i3) {
                break;
            }
            int i6 = i4 + 1;
            byte b2 = bArr[i4];
            if (b2 == this.b) {
                aVar.f16056f = r3;
                break;
            }
            byte[] m2 = m(this.r, aVar);
            if (b2 >= 0) {
                byte[] bArr2 = this.s;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    int i7 = (aVar.f16058h + r3) % 8;
                    aVar.f16058h = i7;
                    long j2 = (aVar.b << 5) + b;
                    aVar.b = j2;
                    if (i7 == 0) {
                        int i8 = aVar.f16054d;
                        int i9 = i8 + 1;
                        aVar.f16054d = i9;
                        m2[i8] = (byte) ((j2 >> 32) & 255);
                        int i10 = i9 + 1;
                        aVar.f16054d = i10;
                        m2[i9] = (byte) ((j2 >> 24) & 255);
                        int i11 = i10 + 1;
                        aVar.f16054d = i11;
                        m2[i10] = (byte) ((j2 >> 16) & 255);
                        int i12 = i11 + 1;
                        aVar.f16054d = i12;
                        m2[i11] = (byte) ((j2 >> 8) & 255);
                        aVar.f16054d = i12 + 1;
                        m2[i12] = (byte) (j2 & 255);
                    }
                }
            }
            i5++;
            i4 = i6;
            r3 = 1;
        }
        if (!aVar.f16056f || aVar.f16058h <= 0) {
            return;
        }
        byte[] m3 = m(this.r, aVar);
        switch (aVar.f16058h) {
            case 1:
                A();
                break;
            case 2:
                break;
            case 3:
                A();
                int i13 = aVar.f16054d;
                aVar.f16054d = i13 + 1;
                m3[i13] = (byte) ((aVar.b >> F) & 255);
                return;
            case 4:
                z(15L, aVar);
                long j3 = aVar.b >> 4;
                aVar.b = j3;
                int i14 = aVar.f16054d;
                int i15 = i14 + 1;
                aVar.f16054d = i15;
                m3[i14] = (byte) ((j3 >> 8) & 255);
                aVar.f16054d = i15 + 1;
                m3[i15] = (byte) (j3 & 255);
                return;
            case 5:
                z(1L, aVar);
                long j4 = aVar.b >> 1;
                aVar.b = j4;
                int i16 = aVar.f16054d;
                int i17 = i16 + 1;
                aVar.f16054d = i17;
                m3[i16] = (byte) ((j4 >> 16) & 255);
                int i18 = i17 + 1;
                aVar.f16054d = i18;
                m3[i17] = (byte) ((j4 >> 8) & 255);
                aVar.f16054d = i18 + 1;
                m3[i18] = (byte) (j4 & 255);
                return;
            case 6:
                A();
                long j5 = aVar.b >> 6;
                aVar.b = j5;
                int i19 = aVar.f16054d;
                int i20 = i19 + 1;
                aVar.f16054d = i20;
                m3[i19] = (byte) ((j5 >> 16) & 255);
                int i21 = i20 + 1;
                aVar.f16054d = i21;
                m3[i20] = (byte) ((j5 >> 8) & 255);
                aVar.f16054d = i21 + 1;
                m3[i21] = (byte) (j5 & 255);
                return;
            case 7:
                z(F, aVar);
                long j6 = aVar.b >> G;
                aVar.b = j6;
                int i22 = aVar.f16054d;
                int i23 = i22 + 1;
                aVar.f16054d = i23;
                m3[i22] = (byte) ((j6 >> 24) & 255);
                int i24 = i23 + 1;
                aVar.f16054d = i24;
                m3[i23] = (byte) ((j6 >> 16) & 255);
                int i25 = i24 + 1;
                aVar.f16054d = i25;
                m3[i24] = (byte) ((j6 >> 8) & 255);
                aVar.f16054d = i25 + 1;
                m3[i25] = (byte) (j6 & 255);
                return;
            default:
                throw new IllegalStateException("Impossible modulus " + aVar.f16058h);
        }
        z(G, aVar);
        int i26 = aVar.f16054d;
        aVar.f16054d = i26 + 1;
        m3[i26] = (byte) ((aVar.b >> 2) & 255);
    }

    @Override // k.b.a.a.k.j
    public void i(byte[] bArr, int i2, int i3, j.a aVar) {
        int i4;
        if (aVar.f16056f) {
            return;
        }
        int i5 = 1;
        if (i3 >= 0) {
            int i6 = i2;
            int i7 = 0;
            while (i7 < i3) {
                byte[] m2 = m(this.t, aVar);
                int i8 = (aVar.f16058h + i5) % 5;
                aVar.f16058h = i8;
                int i9 = i6 + 1;
                int i10 = bArr[i6];
                if (i10 < 0) {
                    i10 += 256;
                }
                long j2 = (aVar.b << 8) + i10;
                aVar.b = j2;
                if (i8 == 0) {
                    int i11 = aVar.f16054d;
                    int i12 = i11 + 1;
                    aVar.f16054d = i12;
                    byte[] bArr2 = this.u;
                    m2[i11] = bArr2[((int) (j2 >> 35)) & 31];
                    int i13 = i12 + 1;
                    aVar.f16054d = i13;
                    m2[i12] = bArr2[((int) (j2 >> 30)) & 31];
                    int i14 = i13 + 1;
                    aVar.f16054d = i14;
                    i4 = i9;
                    m2[i13] = bArr2[((int) (j2 >> 25)) & 31];
                    int i15 = i14 + 1;
                    aVar.f16054d = i15;
                    m2[i14] = bArr2[((int) (j2 >> 20)) & 31];
                    int i16 = i15 + 1;
                    aVar.f16054d = i16;
                    m2[i15] = bArr2[((int) (j2 >> 15)) & 31];
                    int i17 = i16 + 1;
                    aVar.f16054d = i17;
                    m2[i16] = bArr2[((int) (j2 >> 10)) & 31];
                    int i18 = i17 + 1;
                    aVar.f16054d = i18;
                    m2[i17] = bArr2[((int) (j2 >> 5)) & 31];
                    int i19 = i18 + 1;
                    aVar.f16054d = i19;
                    m2[i18] = bArr2[((int) j2) & 31];
                    int i20 = aVar.f16057g + 8;
                    aVar.f16057g = i20;
                    int i21 = this.f16050e;
                    if (i21 > 0 && i21 <= i20) {
                        byte[] bArr3 = this.v;
                        System.arraycopy(bArr3, 0, m2, i19, bArr3.length);
                        aVar.f16054d += this.v.length;
                        aVar.f16057g = 0;
                        i7++;
                        i6 = i4;
                        i5 = 1;
                    }
                } else {
                    i4 = i9;
                }
                i7++;
                i6 = i4;
                i5 = 1;
            }
            return;
        }
        aVar.f16056f = true;
        if (aVar.f16058h == 0 && this.f16050e == 0) {
            return;
        }
        byte[] m3 = m(this.t, aVar);
        int i22 = aVar.f16054d;
        int i23 = aVar.f16058h;
        if (i23 != 0) {
            if (i23 == 1) {
                int i24 = i22 + 1;
                aVar.f16054d = i24;
                byte[] bArr4 = this.u;
                long j3 = aVar.b;
                m3[i22] = bArr4[((int) (j3 >> G)) & 31];
                int i25 = i24 + 1;
                aVar.f16054d = i25;
                m3[i24] = bArr4[((int) (j3 << 2)) & 31];
                int i26 = i25 + 1;
                aVar.f16054d = i26;
                byte b = this.b;
                m3[i25] = b;
                int i27 = i26 + 1;
                aVar.f16054d = i27;
                m3[i26] = b;
                int i28 = i27 + 1;
                aVar.f16054d = i28;
                m3[i27] = b;
                int i29 = i28 + 1;
                aVar.f16054d = i29;
                m3[i28] = b;
                int i30 = i29 + 1;
                aVar.f16054d = i30;
                m3[i29] = b;
                aVar.f16054d = i30 + 1;
                m3[i30] = b;
            } else if (i23 == 2) {
                int i31 = i22 + 1;
                aVar.f16054d = i31;
                byte[] bArr5 = this.u;
                long j4 = aVar.b;
                m3[i22] = bArr5[((int) (j4 >> 11)) & 31];
                int i32 = i31 + 1;
                aVar.f16054d = i32;
                m3[i31] = bArr5[((int) (j4 >> 6)) & 31];
                int i33 = i32 + 1;
                aVar.f16054d = i33;
                m3[i32] = bArr5[((int) (j4 >> 1)) & 31];
                int i34 = i33 + 1;
                aVar.f16054d = i34;
                m3[i33] = bArr5[((int) (j4 << 4)) & 31];
                int i35 = i34 + 1;
                aVar.f16054d = i35;
                byte b2 = this.b;
                m3[i34] = b2;
                int i36 = i35 + 1;
                aVar.f16054d = i36;
                m3[i35] = b2;
                int i37 = i36 + 1;
                aVar.f16054d = i37;
                m3[i36] = b2;
                aVar.f16054d = i37 + 1;
                m3[i37] = b2;
            } else if (i23 == 3) {
                int i38 = i22 + 1;
                aVar.f16054d = i38;
                byte[] bArr6 = this.u;
                long j5 = aVar.b;
                m3[i22] = bArr6[((int) (j5 >> 19)) & 31];
                int i39 = i38 + 1;
                aVar.f16054d = i39;
                m3[i38] = bArr6[((int) (j5 >> 14)) & 31];
                int i40 = i39 + 1;
                aVar.f16054d = i40;
                m3[i39] = bArr6[((int) (j5 >> 9)) & 31];
                int i41 = i40 + 1;
                aVar.f16054d = i41;
                m3[i40] = bArr6[((int) (j5 >> 4)) & 31];
                int i42 = i41 + 1;
                aVar.f16054d = i42;
                m3[i41] = bArr6[((int) (j5 << 1)) & 31];
                int i43 = i42 + 1;
                aVar.f16054d = i43;
                byte b3 = this.b;
                m3[i42] = b3;
                int i44 = i43 + 1;
                aVar.f16054d = i44;
                m3[i43] = b3;
                aVar.f16054d = i44 + 1;
                m3[i44] = b3;
            } else if (i23 == 4) {
                int i45 = i22 + 1;
                aVar.f16054d = i45;
                byte[] bArr7 = this.u;
                long j6 = aVar.b;
                m3[i22] = bArr7[((int) (j6 >> 27)) & 31];
                int i46 = i45 + 1;
                aVar.f16054d = i46;
                m3[i45] = bArr7[((int) (j6 >> 22)) & 31];
                int i47 = i46 + 1;
                aVar.f16054d = i47;
                m3[i46] = bArr7[((int) (j6 >> 17)) & 31];
                int i48 = i47 + 1;
                aVar.f16054d = i48;
                m3[i47] = bArr7[((int) (j6 >> 12)) & 31];
                int i49 = i48 + 1;
                aVar.f16054d = i49;
                m3[i48] = bArr7[((int) (j6 >> F)) & 31];
                int i50 = i49 + 1;
                aVar.f16054d = i50;
                m3[i49] = bArr7[((int) (j6 >> 2)) & 31];
                int i51 = i50 + 1;
                aVar.f16054d = i51;
                m3[i50] = bArr7[((int) (j6 << G)) & 31];
                aVar.f16054d = i51 + 1;
                m3[i51] = this.b;
            } else {
                throw new IllegalStateException("Impossible modulus " + aVar.f16058h);
            }
        }
        int i52 = aVar.f16057g;
        int i53 = aVar.f16054d;
        int i54 = i52 + (i53 - i22);
        aVar.f16057g = i54;
        if (this.f16050e <= 0 || i54 <= 0) {
            return;
        }
        byte[] bArr8 = this.v;
        System.arraycopy(bArr8, 0, m3, i53, bArr8.length);
        aVar.f16054d += this.v.length;
    }

    @Override // k.b.a.a.k.j
    public boolean s(byte b) {
        if (b >= 0) {
            byte[] bArr = this.s;
            if (b < bArr.length && bArr[b] != -1) {
                return true;
            }
        }
        return false;
    }

    public d(boolean z2) {
        this(0, null, z2, (byte) 61);
    }

    public d(boolean z2, byte b) {
        this(0, null, z2, b);
    }

    public d(byte b) {
        this(false, b);
    }

    public d(int i2) {
        this(i2, j.q);
    }

    public d(int i2, byte[] bArr) {
        this(i2, bArr, false, (byte) 61);
    }

    public d(int i2, byte[] bArr, boolean z2) {
        this(i2, bArr, z2, (byte) 61);
    }

    public d(int i2, byte[] bArr, boolean z2, byte b) {
        this(i2, bArr, z2, b, j.p);
    }

    public d(int i2, byte[] bArr, boolean z2, byte b, CodecPolicy codecPolicy) {
        super(5, 8, i2, bArr == null ? 0 : bArr.length, b, codecPolicy);
        if (z2) {
            this.u = C;
            this.s = B;
        } else {
            this.u = A;
            this.s = z;
        }
        if (i2 <= 0) {
            this.t = 8;
            this.v = null;
        } else if (bArr != null) {
            if (!c(bArr)) {
                this.t = bArr.length + 8;
                byte[] bArr2 = new byte[bArr.length];
                this.v = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                String t = p.t(bArr);
                throw new IllegalArgumentException("lineSeparator must not contain Base32 characters: [" + t + "]");
            }
        } else {
            throw new IllegalArgumentException("lineLength " + i2 + " > 0, but lineSeparator is null");
        }
        this.r = this.t - 1;
        if (s(b) || j.w(b)) {
            throw new IllegalArgumentException("pad must not be in alphabet or whitespace");
        }
    }
}
