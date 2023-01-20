package com.heytap.mcssdk.a;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.cb;
import j.p0;
import java.math.BigInteger;
import java.util.Objects;
import k.b.a.a.k.p;
import k.b.a.a.o.f;

/* loaded from: classes2.dex */
public class a extends b {

    /* renamed from: m  reason: collision with root package name */
    private static final int f3292m = 6;
    private static final int n = 3;
    private static final int o = 4;
    private static final int s = 63;
    private final byte[] t;
    private final byte[] u;
    private final byte[] v;
    private final int w;
    private final int x;
    private int y;
    public static final byte[] a = {13, 10};
    private static final byte[] p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] q = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] r = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, p0.a, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, cb.f7124m, cb.n, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, p0.a, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, f.b, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    public a() {
        this(0);
    }

    public a(int i2) {
        this(i2, a);
    }

    public a(int i2, byte[] bArr) {
        this(i2, bArr, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a(int r5, byte[] r6, boolean r7) {
        /*
            r4 = this;
            r0 = 0
            if (r6 != 0) goto L5
            r1 = 0
            goto L6
        L5:
            int r1 = r6.length
        L6:
            r2 = 3
            r3 = 4
            r4.<init>(r2, r3, r5, r1)
            byte[] r1 = com.heytap.mcssdk.a.a.r
            r4.u = r1
            r1 = 0
            if (r6 == 0) goto L48
            boolean r2 = r4.l(r6)
            if (r2 != 0) goto L28
            if (r5 <= 0) goto L48
            int r5 = r6.length
            int r5 = r5 + r3
            r4.x = r5
            int r5 = r6.length
            byte[] r5 = new byte[r5]
            r4.v = r5
            int r1 = r6.length
            java.lang.System.arraycopy(r6, r0, r5, r0, r1)
            goto L4c
        L28:
            java.lang.String r5 = k.b.a.a.k.p.t(r6)
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "lineSeparator must not contain base64 characters: ["
            r7.append(r0)
            r7.append(r5)
            java.lang.String r5 = "]"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5)
            throw r6
        L48:
            r4.x = r3
            r4.v = r1
        L4c:
            int r5 = r4.x
            int r5 = r5 + (-1)
            r4.w = r5
            if (r7 == 0) goto L57
            byte[] r5 = com.heytap.mcssdk.a.a.q
            goto L59
        L57:
            byte[] r5 = com.heytap.mcssdk.a.a.p
        L59:
            r4.t = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.mcssdk.a.a.<init>(int, byte[], boolean):void");
    }

    public a(boolean z) {
        this(76, a, z);
    }

    public static boolean a(byte b) {
        if (b != 61) {
            if (b >= 0) {
                byte[] bArr = r;
                if (b >= bArr.length || bArr[b] == -1) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean a(String str) {
        return b(p.k(str));
    }

    public static boolean a(byte[] bArr) {
        return b(bArr);
    }

    public static byte[] a(BigInteger bigInteger) {
        Objects.requireNonNull(bigInteger, "encodeInteger called with null parameter");
        return a(b(bigInteger), false);
    }

    public static byte[] a(byte[] bArr, boolean z) {
        return a(bArr, z, false);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2) {
        return a(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2, int i2) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = z ? new a(z2) : new a(0, a, z2);
        long m2 = aVar.m(bArr);
        if (m2 <= i2) {
            return aVar.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + m2 + ") than the specified maximum size of " + i2);
    }

    public static boolean b(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!a(bArr[i2]) && !b.c(bArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public static byte[] b(String str) {
        return new a().c(str);
    }

    public static byte[] b(BigInteger bigInteger) {
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

    public static byte[] c(byte[] bArr) {
        return a(bArr, false);
    }

    public static String d(byte[] bArr) {
        return p.t(a(bArr, false));
    }

    public static byte[] e(byte[] bArr) {
        return a(bArr, false, true);
    }

    public static String f(byte[] bArr) {
        return p.t(a(bArr, false, true));
    }

    public static byte[] g(byte[] bArr) {
        return a(bArr, true);
    }

    public static byte[] h(byte[] bArr) {
        return new a().decode(bArr);
    }

    public static BigInteger i(byte[] bArr) {
        return new BigInteger(1, h(bArr));
    }

    @Override // com.heytap.mcssdk.a.b
    public void a(byte[] bArr, int i2, int i3) {
        if (this.f3301j) {
            return;
        }
        if (i3 >= 0) {
            int i4 = 0;
            while (i4 < i3) {
                a(this.x);
                int i5 = (this.f3303l + 1) % 3;
                this.f3303l = i5;
                int i6 = i2 + 1;
                int i7 = bArr[i2];
                if (i7 < 0) {
                    i7 += 256;
                }
                int i8 = (this.y << 8) + i7;
                this.y = i8;
                if (i5 == 0) {
                    byte[] bArr2 = this.f3299h;
                    int i9 = this.f3300i;
                    int i10 = i9 + 1;
                    this.f3300i = i10;
                    byte[] bArr3 = this.t;
                    bArr2[i9] = bArr3[(i8 >> 18) & 63];
                    int i11 = i10 + 1;
                    this.f3300i = i11;
                    bArr2[i10] = bArr3[(i8 >> 12) & 63];
                    int i12 = i11 + 1;
                    this.f3300i = i12;
                    bArr2[i11] = bArr3[(i8 >> 6) & 63];
                    int i13 = i12 + 1;
                    this.f3300i = i13;
                    bArr2[i12] = bArr3[i8 & 63];
                    int i14 = this.f3302k + 4;
                    this.f3302k = i14;
                    int i15 = this.f3298g;
                    if (i15 > 0 && i15 <= i14) {
                        byte[] bArr4 = this.v;
                        System.arraycopy(bArr4, 0, bArr2, i13, bArr4.length);
                        this.f3300i += this.v.length;
                        this.f3302k = 0;
                    }
                }
                i4++;
                i2 = i6;
            }
            return;
        }
        this.f3301j = true;
        if (this.f3303l == 0 && this.f3298g == 0) {
            return;
        }
        a(this.x);
        int i16 = this.f3300i;
        int i17 = this.f3303l;
        if (i17 == 1) {
            byte[] bArr5 = this.f3299h;
            int i18 = i16 + 1;
            this.f3300i = i18;
            byte[] bArr6 = this.t;
            int i19 = this.y;
            bArr5[i16] = bArr6[(i19 >> 2) & 63];
            int i20 = i18 + 1;
            this.f3300i = i20;
            bArr5[i18] = bArr6[(i19 << 4) & 63];
            if (bArr6 == p) {
                int i21 = i20 + 1;
                this.f3300i = i21;
                bArr5[i20] = 61;
                this.f3300i = i21 + 1;
                bArr5[i21] = 61;
            }
        } else if (i17 == 2) {
            byte[] bArr7 = this.f3299h;
            int i22 = i16 + 1;
            this.f3300i = i22;
            byte[] bArr8 = this.t;
            int i23 = this.y;
            bArr7[i16] = bArr8[(i23 >> 10) & 63];
            int i24 = i22 + 1;
            this.f3300i = i24;
            bArr7[i22] = bArr8[(i23 >> 4) & 63];
            int i25 = i24 + 1;
            this.f3300i = i25;
            bArr7[i24] = bArr8[(i23 << 2) & 63];
            if (bArr8 == p) {
                this.f3300i = i25 + 1;
                bArr7[i25] = 61;
            }
        }
        int i26 = this.f3302k;
        int i27 = this.f3300i;
        int i28 = i26 + (i27 - i16);
        this.f3302k = i28;
        if (this.f3298g <= 0 || i28 <= 0) {
            return;
        }
        byte[] bArr9 = this.v;
        System.arraycopy(bArr9, 0, this.f3299h, i27, bArr9.length);
        this.f3300i += this.v.length;
    }

    public boolean a() {
        return this.t == q;
    }

    @Override // com.heytap.mcssdk.a.b
    public void b(byte[] bArr, int i2, int i3) {
        byte b;
        if (this.f3301j) {
            return;
        }
        if (i3 < 0) {
            this.f3301j = true;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            a(this.w);
            int i5 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 == 61) {
                this.f3301j = true;
                break;
            }
            if (b2 >= 0) {
                byte[] bArr2 = r;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    int i6 = (this.f3303l + 1) % 4;
                    this.f3303l = i6;
                    int i7 = (this.y << 6) + b;
                    this.y = i7;
                    if (i6 == 0) {
                        byte[] bArr3 = this.f3299h;
                        int i8 = this.f3300i;
                        int i9 = i8 + 1;
                        this.f3300i = i9;
                        bArr3[i8] = (byte) ((i7 >> 16) & 255);
                        int i10 = i9 + 1;
                        this.f3300i = i10;
                        bArr3[i9] = (byte) ((i7 >> 8) & 255);
                        this.f3300i = i10 + 1;
                        bArr3[i10] = (byte) (i7 & 255);
                    }
                }
            }
            i4++;
            i2 = i5;
        }
        if (!this.f3301j || this.f3303l == 0) {
            return;
        }
        a(this.w);
        int i11 = this.f3303l;
        if (i11 == 2) {
            int i12 = this.y >> 4;
            this.y = i12;
            byte[] bArr4 = this.f3299h;
            int i13 = this.f3300i;
            this.f3300i = i13 + 1;
            bArr4[i13] = (byte) (i12 & 255);
        } else if (i11 != 3) {
        } else {
            int i14 = this.y >> 2;
            this.y = i14;
            byte[] bArr5 = this.f3299h;
            int i15 = this.f3300i;
            int i16 = i15 + 1;
            this.f3300i = i16;
            bArr5[i15] = (byte) ((i14 >> 8) & 255);
            this.f3300i = i16 + 1;
            bArr5[i16] = (byte) (i14 & 255);
        }
    }

    @Override // com.heytap.mcssdk.a.b
    public boolean b(byte b) {
        if (b >= 0) {
            byte[] bArr = this.u;
            if (b < bArr.length && bArr[b] != -1) {
                return true;
            }
        }
        return false;
    }
}
