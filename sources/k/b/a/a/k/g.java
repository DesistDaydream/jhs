package k.b.a.a.k;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.cb;
import j.p0;
import java.math.BigInteger;
import java.util.Objects;
import k.b.a.a.k.j;
import org.apache.commons.codec.CodecPolicy;

/* loaded from: classes4.dex */
public class g extends j {
    private static final int C = 63;
    private static final int D = 15;
    private static final int E = 3;
    private static final int w = 6;
    private static final int x = 3;
    private static final int y = 4;
    private final byte[] r;
    private final byte[] s;
    private final byte[] t;
    private final int u;
    private final int v;
    private static final byte[] z = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] A = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] B = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, p0.a, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, cb.f7124m, cb.n, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, p0.a, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, k.b.a.a.o.f.b, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    public g() {
        this(0);
    }

    public static byte[] A(byte[] bArr) {
        return new g().decode(bArr);
    }

    public static BigInteger B(byte[] bArr) {
        return new BigInteger(1, A(bArr));
    }

    public static byte[] C(byte[] bArr) {
        return D(bArr, false);
    }

    public static byte[] D(byte[] bArr, boolean z2) {
        return E(bArr, z2, false);
    }

    public static byte[] E(byte[] bArr, boolean z2, boolean z3) {
        return F(bArr, z2, z3, Integer.MAX_VALUE);
    }

    public static byte[] F(byte[] bArr, boolean z2, boolean z3, int i2) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        g gVar = z2 ? new g(z3) : new g(0, j.q, z3);
        long q = gVar.q(bArr);
        if (q <= i2) {
            return gVar.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + q + ") than the specified maximum size of " + i2);
    }

    public static byte[] G(byte[] bArr) {
        return D(bArr, true);
    }

    public static String H(byte[] bArr) {
        return p.p(D(bArr, false));
    }

    public static byte[] I(byte[] bArr) {
        return E(bArr, false, true);
    }

    public static String J(byte[] bArr) {
        return p.p(E(bArr, false, true));
    }

    public static byte[] K(BigInteger bigInteger) {
        Objects.requireNonNull(bigInteger, "bigInteger");
        return D(Q(bigInteger), false);
    }

    @Deprecated
    public static boolean L(byte[] bArr) {
        return O(bArr);
    }

    public static boolean M(byte b) {
        if (b != 61) {
            if (b >= 0) {
                byte[] bArr = B;
                if (b >= bArr.length || bArr[b] == -1) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean N(String str) {
        return O(p.k(str));
    }

    public static boolean O(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!M(bArr[i2]) && !j.w(bArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public static byte[] Q(BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i2 = 1;
        if (bigInteger.bitLength() % 8 == 0 || (bigInteger.bitLength() / 8) + 1 != bitLength / 8) {
            int length = byteArray.length;
            if (bigInteger.bitLength() % 8 == 0) {
                length--;
            } else {
                i2 = 0;
            }
            int i3 = bitLength / 8;
            int i4 = i3 - length;
            byte[] bArr = new byte[i3];
            System.arraycopy(byteArray, i2, bArr, i4, length);
            return bArr;
        }
        return byteArray;
    }

    private void R(int i2, j.a aVar) {
        if (v() && (i2 & aVar.a) != 0) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.");
        }
    }

    private void S() {
        if (v()) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Decoding requires at least two trailing 6-bit characters to create bytes.");
        }
    }

    public static byte[] z(String str) {
        return new g().h(str);
    }

    public boolean P() {
        return this.r == A;
    }

    @Override // k.b.a.a.k.j
    public void g(byte[] bArr, int i2, int i3, j.a aVar) {
        byte b;
        if (aVar.f16056f) {
            return;
        }
        if (i3 < 0) {
            aVar.f16056f = true;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            byte[] m2 = m(this.u, aVar);
            int i5 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 == this.b) {
                aVar.f16056f = true;
                break;
            }
            if (b2 >= 0) {
                byte[] bArr2 = B;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    int i6 = (aVar.f16058h + 1) % 4;
                    aVar.f16058h = i6;
                    int i7 = (aVar.a << 6) + b;
                    aVar.a = i7;
                    if (i6 == 0) {
                        int i8 = aVar.f16054d;
                        int i9 = i8 + 1;
                        aVar.f16054d = i9;
                        m2[i8] = (byte) ((i7 >> 16) & 255);
                        int i10 = i9 + 1;
                        aVar.f16054d = i10;
                        m2[i9] = (byte) ((i7 >> 8) & 255);
                        aVar.f16054d = i10 + 1;
                        m2[i10] = (byte) (i7 & 255);
                    }
                }
            }
            i4++;
            i2 = i5;
        }
        if (!aVar.f16056f || aVar.f16058h == 0) {
            return;
        }
        byte[] m3 = m(this.u, aVar);
        int i11 = aVar.f16058h;
        if (i11 == 1) {
            S();
        } else if (i11 == 2) {
            R(15, aVar);
            int i12 = aVar.a >> 4;
            aVar.a = i12;
            int i13 = aVar.f16054d;
            aVar.f16054d = i13 + 1;
            m3[i13] = (byte) (i12 & 255);
        } else if (i11 == 3) {
            R(3, aVar);
            int i14 = aVar.a >> 2;
            aVar.a = i14;
            int i15 = aVar.f16054d;
            int i16 = i15 + 1;
            aVar.f16054d = i16;
            m3[i15] = (byte) ((i14 >> 8) & 255);
            aVar.f16054d = i16 + 1;
            m3[i16] = (byte) (i14 & 255);
        } else {
            throw new IllegalStateException("Impossible modulus " + aVar.f16058h);
        }
    }

    @Override // k.b.a.a.k.j
    public void i(byte[] bArr, int i2, int i3, j.a aVar) {
        if (aVar.f16056f) {
            return;
        }
        if (i3 >= 0) {
            int i4 = 0;
            while (i4 < i3) {
                byte[] m2 = m(this.v, aVar);
                int i5 = (aVar.f16058h + 1) % 3;
                aVar.f16058h = i5;
                int i6 = i2 + 1;
                int i7 = bArr[i2];
                if (i7 < 0) {
                    i7 += 256;
                }
                int i8 = (aVar.a << 8) + i7;
                aVar.a = i8;
                if (i5 == 0) {
                    int i9 = aVar.f16054d;
                    int i10 = i9 + 1;
                    aVar.f16054d = i10;
                    byte[] bArr2 = this.r;
                    m2[i9] = bArr2[(i8 >> 18) & 63];
                    int i11 = i10 + 1;
                    aVar.f16054d = i11;
                    m2[i10] = bArr2[(i8 >> 12) & 63];
                    int i12 = i11 + 1;
                    aVar.f16054d = i12;
                    m2[i11] = bArr2[(i8 >> 6) & 63];
                    int i13 = i12 + 1;
                    aVar.f16054d = i13;
                    m2[i12] = bArr2[i8 & 63];
                    int i14 = aVar.f16057g + 4;
                    aVar.f16057g = i14;
                    int i15 = this.f16050e;
                    if (i15 > 0 && i15 <= i14) {
                        byte[] bArr3 = this.t;
                        System.arraycopy(bArr3, 0, m2, i13, bArr3.length);
                        aVar.f16054d += this.t.length;
                        aVar.f16057g = 0;
                    }
                }
                i4++;
                i2 = i6;
            }
            return;
        }
        aVar.f16056f = true;
        if (aVar.f16058h == 0 && this.f16050e == 0) {
            return;
        }
        byte[] m3 = m(this.v, aVar);
        int i16 = aVar.f16054d;
        int i17 = aVar.f16058h;
        if (i17 != 0) {
            if (i17 == 1) {
                int i18 = i16 + 1;
                aVar.f16054d = i18;
                byte[] bArr4 = this.r;
                int i19 = aVar.a;
                m3[i16] = bArr4[(i19 >> 2) & 63];
                int i20 = i18 + 1;
                aVar.f16054d = i20;
                m3[i18] = bArr4[(i19 << 4) & 63];
                if (bArr4 == z) {
                    int i21 = i20 + 1;
                    aVar.f16054d = i21;
                    byte b = this.b;
                    m3[i20] = b;
                    aVar.f16054d = i21 + 1;
                    m3[i21] = b;
                }
            } else if (i17 == 2) {
                int i22 = i16 + 1;
                aVar.f16054d = i22;
                byte[] bArr5 = this.r;
                int i23 = aVar.a;
                m3[i16] = bArr5[(i23 >> 10) & 63];
                int i24 = i22 + 1;
                aVar.f16054d = i24;
                m3[i22] = bArr5[(i23 >> 4) & 63];
                int i25 = i24 + 1;
                aVar.f16054d = i25;
                m3[i24] = bArr5[(i23 << 2) & 63];
                if (bArr5 == z) {
                    aVar.f16054d = i25 + 1;
                    m3[i25] = this.b;
                }
            } else {
                throw new IllegalStateException("Impossible modulus " + aVar.f16058h);
            }
        }
        int i26 = aVar.f16057g;
        int i27 = aVar.f16054d;
        int i28 = i26 + (i27 - i16);
        aVar.f16057g = i28;
        if (this.f16050e <= 0 || i28 <= 0) {
            return;
        }
        byte[] bArr6 = this.t;
        System.arraycopy(bArr6, 0, m3, i27, bArr6.length);
        aVar.f16054d += this.t.length;
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

    public g(boolean z2) {
        this(76, j.q, z2);
    }

    public g(int i2) {
        this(i2, j.q);
    }

    public g(int i2, byte[] bArr) {
        this(i2, bArr, false);
    }

    public g(int i2, byte[] bArr, boolean z2) {
        this(i2, bArr, z2, j.p);
    }

    public g(int i2, byte[] bArr, boolean z2, CodecPolicy codecPolicy) {
        super(3, 4, i2, bArr == null ? 0 : bArr.length, (byte) 61, codecPolicy);
        this.s = B;
        if (bArr != null) {
            if (c(bArr)) {
                String t = p.t(bArr);
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + t + "]");
            } else if (i2 > 0) {
                this.v = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.t = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.v = 4;
                this.t = null;
            }
        } else {
            this.v = 4;
            this.t = null;
        }
        this.u = this.v - 1;
        this.r = z2 ? A : z;
    }
}
