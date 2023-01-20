package k.b.a.a.m;

import com.umeng.analytics.pro.cb;
import k.b.a.a.k.p;

/* loaded from: classes4.dex */
public final class h {
    @Deprecated
    public static final long a = 2862933555777941757L;
    public static final int b = 104729;

    /* renamed from: c  reason: collision with root package name */
    public static final int f16091c = 8;

    /* renamed from: d  reason: collision with root package name */
    public static final int f16092d = 4;

    /* renamed from: e  reason: collision with root package name */
    public static final int f16093e = 2;

    /* renamed from: f  reason: collision with root package name */
    private static final int f16094f = -862048943;

    /* renamed from: g  reason: collision with root package name */
    private static final int f16095g = 461845907;

    /* renamed from: h  reason: collision with root package name */
    private static final int f16096h = 15;

    /* renamed from: i  reason: collision with root package name */
    private static final int f16097i = 13;

    /* renamed from: j  reason: collision with root package name */
    private static final int f16098j = 5;

    /* renamed from: k  reason: collision with root package name */
    private static final int f16099k = -430675100;

    /* renamed from: l  reason: collision with root package name */
    private static final long f16100l = -8663945395140668459L;

    /* renamed from: m  reason: collision with root package name */
    private static final long f16101m = 5545529020109919103L;
    private static final int n = 31;
    private static final int o = 27;
    private static final int p = 33;
    private static final int q = 5;
    private static final int r = 1390208809;
    private static final int s = 944331445;

    @Deprecated
    /* loaded from: classes4.dex */
    public static class a extends b {
        @Override // k.b.a.a.m.h.b
        @Deprecated
        public int c(int i2, int i3, byte[] bArr, int i4) {
            int i5;
            int i6;
            if (i3 != 1) {
                if (i3 != 2) {
                    i6 = i3 == 3 ? (bArr[2] << cb.n) ^ 0 : 0;
                    return h.d(i2 ^ i4);
                }
                i5 = i6 ^ (bArr[1] << 8);
            } else {
                i5 = 0;
            }
            i2 ^= Integer.rotateLeft((i5 ^ bArr[0]) * h.f16094f, 15) * h.f16095g;
            return h.d(i2 ^ i4);
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: e  reason: collision with root package name */
        private static final int f16102e = 4;
        private final byte[] a = new byte[3];
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f16103c;

        /* renamed from: d  reason: collision with root package name */
        private int f16104d;

        private static int d(byte b, byte b2, byte b3, byte b4) {
            return (b & 255) | ((b2 & 255) << 8) | ((b3 & 255) << 16) | ((b4 & 255) << 24);
        }

        public final void a(byte[] bArr, int i2, int i3) {
            int d2;
            if (i3 <= 0) {
                return;
            }
            this.f16103c += i3;
            int i4 = this.b;
            if ((i4 + i3) - 4 < 0) {
                System.arraycopy(bArr, i2, this.a, i4, i3);
                this.b += i3;
                return;
            }
            if (i4 > 0) {
                if (i4 == 1) {
                    d2 = d(this.a[0], bArr[i2], bArr[i2 + 1], bArr[i2 + 2]);
                } else if (i4 == 2) {
                    byte[] bArr2 = this.a;
                    d2 = d(bArr2[0], bArr2[1], bArr[i2], bArr[i2 + 1]);
                } else if (i4 == 3) {
                    byte[] bArr3 = this.a;
                    d2 = d(bArr3[0], bArr3[1], bArr3[2], bArr[i2]);
                } else {
                    throw new IllegalStateException("Unprocessed length should be 1, 2, or 3: " + this.b);
                }
                this.f16104d = h.E(d2, this.f16104d);
                int i5 = 4 - this.b;
                i2 += i5;
                i3 -= i5;
            }
            int i6 = i3 >> 2;
            for (int i7 = 0; i7 < i6; i7++) {
                this.f16104d = h.E(h.f(bArr, (i7 << 2) + i2), this.f16104d);
            }
            int i8 = i6 << 2;
            int i9 = i3 - i8;
            this.b = i9;
            if (i9 != 0) {
                System.arraycopy(bArr, i2 + i8, this.a, 0, i9);
            }
        }

        public final int b() {
            return c(this.f16104d, this.b, this.a, this.f16103c);
        }

        public int c(int i2, int i3, byte[] bArr, int i4) {
            int i5;
            int i6;
            if (i3 != 1) {
                if (i3 != 2) {
                    i6 = i3 == 3 ? ((bArr[2] & 255) << 16) ^ 0 : 0;
                    return h.d(i2 ^ i4);
                }
                i5 = i6 ^ ((bArr[1] & 255) << 8);
            } else {
                i5 = 0;
            }
            i2 ^= Integer.rotateLeft((i5 ^ (bArr[0] & 255)) * h.f16094f, 15) * h.f16095g;
            return h.d(i2 ^ i4);
        }

        public final void e(int i2) {
            this.f16103c = 0;
            this.b = 0;
            this.f16104d = i2;
        }
    }

    private h() {
    }

    @Deprecated
    public static long A(short s2) {
        return e(((Long.rotateLeft(((((s2 & 255) << 8) ^ 0) ^ (255 & ((s2 & 65280) >> 8))) * f16100l, 31) * f16101m) ^ 104729) ^ 2);
    }

    @Deprecated
    public static long B(byte[] bArr) {
        return D(bArr, 0, bArr.length, b);
    }

    @Deprecated
    public static long C(byte[] bArr, int i2, int i3) {
        return D(bArr, i2, i3, b);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Deprecated
    public static long D(byte[] bArr, int i2, int i3, int i4) {
        int i5;
        long j2 = i4;
        int i6 = i3 >> 3;
        for (int i7 = 0; i7 < i6; i7++) {
            j2 = (Long.rotateLeft(j2 ^ (Long.rotateLeft(g(bArr, i2 + (i7 << 3)) * f16100l, 31) * f16101m), 27) * 5) + 1390208809;
        }
        long j3 = 0;
        switch ((i2 + i3) - (i2 + (i6 << 3))) {
            case 1:
                j2 ^= Long.rotateLeft(((bArr[i5] & 255) ^ j3) * f16100l, 31) * f16101m;
                break;
            case 2:
                j3 ^= (bArr[i5 + 1] & 255) << 8;
                j2 ^= Long.rotateLeft(((bArr[i5] & 255) ^ j3) * f16100l, 31) * f16101m;
                break;
            case 3:
                j3 ^= (bArr[i5 + 2] & 255) << 16;
                j3 ^= (bArr[i5 + 1] & 255) << 8;
                j2 ^= Long.rotateLeft(((bArr[i5] & 255) ^ j3) * f16100l, 31) * f16101m;
                break;
            case 4:
                j3 ^= (bArr[i5 + 3] & 255) << 24;
                j3 ^= (bArr[i5 + 2] & 255) << 16;
                j3 ^= (bArr[i5 + 1] & 255) << 8;
                j2 ^= Long.rotateLeft(((bArr[i5] & 255) ^ j3) * f16100l, 31) * f16101m;
                break;
            case 5:
                j3 ^= (bArr[i5 + 4] & 255) << 32;
                j3 ^= (bArr[i5 + 3] & 255) << 24;
                j3 ^= (bArr[i5 + 2] & 255) << 16;
                j3 ^= (bArr[i5 + 1] & 255) << 8;
                j2 ^= Long.rotateLeft(((bArr[i5] & 255) ^ j3) * f16100l, 31) * f16101m;
                break;
            case 6:
                j3 ^= (bArr[i5 + 5] & 255) << 40;
                j3 ^= (bArr[i5 + 4] & 255) << 32;
                j3 ^= (bArr[i5 + 3] & 255) << 24;
                j3 ^= (bArr[i5 + 2] & 255) << 16;
                j3 ^= (bArr[i5 + 1] & 255) << 8;
                j2 ^= Long.rotateLeft(((bArr[i5] & 255) ^ j3) * f16100l, 31) * f16101m;
                break;
            case 7:
                j3 = 0 ^ ((bArr[i5 + 6] & 255) << 48);
                j3 ^= (bArr[i5 + 5] & 255) << 40;
                j3 ^= (bArr[i5 + 4] & 255) << 32;
                j3 ^= (bArr[i5 + 3] & 255) << 24;
                j3 ^= (bArr[i5 + 2] & 255) << 16;
                j3 ^= (bArr[i5 + 1] & 255) << 8;
                j2 ^= Long.rotateLeft(((bArr[i5] & 255) ^ j3) * f16100l, 31) * f16101m;
                break;
        }
        return e(i3 ^ j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int E(int i2, int i3) {
        return (Integer.rotateLeft((Integer.rotateLeft(i2 * f16094f, 15) * f16095g) ^ i3, 13) * 5) + f16099k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(int i2) {
        int i3 = (i2 ^ (i2 >>> 16)) * (-2048144789);
        int i4 = (i3 ^ (i3 >>> 13)) * (-1028477387);
        return i4 ^ (i4 >>> 16);
    }

    private static long e(long j2) {
        long j3 = (j2 ^ (j2 >>> 33)) * (-49064778989728563L);
        long j4 = (j3 ^ (j3 >>> 33)) * (-4265267296055464877L);
        return j4 ^ (j4 >>> 33);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    private static long g(byte[] bArr, int i2) {
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    @Deprecated
    public static long[] h(String str) {
        byte[] k2 = p.k(str);
        return j(k2, 0, k2.length, b);
    }

    public static long[] i(byte[] bArr) {
        return j(bArr, 0, bArr.length, b);
    }

    @Deprecated
    public static long[] j(byte[] bArr, int i2, int i3, int i4) {
        return m(bArr, i2, i3, i4);
    }

    public static long[] k(byte[] bArr) {
        return l(bArr, 0, bArr.length, 0);
    }

    public static long[] l(byte[] bArr, int i2, int i3, int i4) {
        return m(bArr, i2, i3, i4 & 4294967295L);
    }

    private static long[] m(byte[] bArr, int i2, int i3, long j2) {
        int i4;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        byte[] bArr2 = bArr;
        int i5 = i3 >> 4;
        long j10 = j2;
        long j11 = j10;
        int i6 = 0;
        while (i6 < i5) {
            int i7 = i2 + (i6 << 4);
            long g2 = g(bArr2, i7);
            long g3 = g(bArr2, i7 + 8);
            long rotateLeft = ((Long.rotateLeft((Long.rotateLeft(g2 * f16100l, 31) * f16101m) ^ j10, 27) + j11) * 5) + 1390208809;
            j11 = ((Long.rotateLeft(j11 ^ (Long.rotateLeft(f16101m * g3, 33) * f16100l), 31) + rotateLeft) * 5) + 944331445;
            i6++;
            j10 = rotateLeft;
            bArr2 = bArr;
        }
        long j12 = 0;
        switch ((i2 + i3) - (i2 + (i5 << 4))) {
            case 1:
                j3 = j10;
                j10 = j3 ^ (Long.rotateLeft((j12 ^ (bArr[i4] & 255)) * f16100l, 31) * f16101m);
                break;
            case 2:
                j3 = j10;
                j12 ^= (bArr[i4 + 1] & 255) << 8;
                j10 = j3 ^ (Long.rotateLeft((j12 ^ (bArr[i4] & 255)) * f16100l, 31) * f16101m);
                break;
            case 3:
                j3 = j10;
                j12 ^= (bArr[i4 + 2] & 255) << 16;
                j12 ^= (bArr[i4 + 1] & 255) << 8;
                j10 = j3 ^ (Long.rotateLeft((j12 ^ (bArr[i4] & 255)) * f16100l, 31) * f16101m);
                break;
            case 4:
                j3 = j10;
                j12 ^= (bArr[i4 + 3] & 255) << 24;
                j12 ^= (bArr[i4 + 2] & 255) << 16;
                j12 ^= (bArr[i4 + 1] & 255) << 8;
                j10 = j3 ^ (Long.rotateLeft((j12 ^ (bArr[i4] & 255)) * f16100l, 31) * f16101m);
                break;
            case 5:
                j3 = j10;
                j12 ^= (bArr[i4 + 4] & 255) << 32;
                j12 ^= (bArr[i4 + 3] & 255) << 24;
                j12 ^= (bArr[i4 + 2] & 255) << 16;
                j12 ^= (bArr[i4 + 1] & 255) << 8;
                j10 = j3 ^ (Long.rotateLeft((j12 ^ (bArr[i4] & 255)) * f16100l, 31) * f16101m);
                break;
            case 6:
                j3 = j10;
                j12 ^= (bArr[i4 + 5] & 255) << 40;
                j12 ^= (bArr[i4 + 4] & 255) << 32;
                j12 ^= (bArr[i4 + 3] & 255) << 24;
                j12 ^= (bArr[i4 + 2] & 255) << 16;
                j12 ^= (bArr[i4 + 1] & 255) << 8;
                j10 = j3 ^ (Long.rotateLeft((j12 ^ (bArr[i4] & 255)) * f16100l, 31) * f16101m);
                break;
            case 7:
                j3 = j10;
                j12 ^= (bArr[i4 + 6] & 255) << 48;
                j12 ^= (bArr[i4 + 5] & 255) << 40;
                j12 ^= (bArr[i4 + 4] & 255) << 32;
                j12 ^= (bArr[i4 + 3] & 255) << 24;
                j12 ^= (bArr[i4 + 2] & 255) << 16;
                j12 ^= (bArr[i4 + 1] & 255) << 8;
                j10 = j3 ^ (Long.rotateLeft((j12 ^ (bArr[i4] & 255)) * f16100l, 31) * f16101m);
                break;
            case 8:
                j3 = j10;
                j12 = 0 ^ ((bArr[i4 + 7] & 255) << 56);
                j12 ^= (bArr[i4 + 6] & 255) << 48;
                j12 ^= (bArr[i4 + 5] & 255) << 40;
                j12 ^= (bArr[i4 + 4] & 255) << 32;
                j12 ^= (bArr[i4 + 3] & 255) << 24;
                j12 ^= (bArr[i4 + 2] & 255) << 16;
                j12 ^= (bArr[i4 + 1] & 255) << 8;
                j10 = j3 ^ (Long.rotateLeft((j12 ^ (bArr[i4] & 255)) * f16100l, 31) * f16101m);
                break;
            case 9:
                j3 = j10;
                j4 = 0;
                j11 ^= Long.rotateLeft((j4 ^ (bArr[i4 + 8] & 255)) * f16101m, 33) * f16100l;
                j12 = 0 ^ ((bArr[i4 + 7] & 255) << 56);
                j12 ^= (bArr[i4 + 6] & 255) << 48;
                j12 ^= (bArr[i4 + 5] & 255) << 40;
                j12 ^= (bArr[i4 + 4] & 255) << 32;
                j12 ^= (bArr[i4 + 3] & 255) << 24;
                j12 ^= (bArr[i4 + 2] & 255) << 16;
                j12 ^= (bArr[i4 + 1] & 255) << 8;
                j10 = j3 ^ (Long.rotateLeft((j12 ^ (bArr[i4] & 255)) * f16100l, 31) * f16101m);
                break;
            case 10:
                j3 = j10;
                j5 = 0;
                j4 = j5 ^ ((bArr[i4 + 9] & 255) << 8);
                j11 ^= Long.rotateLeft((j4 ^ (bArr[i4 + 8] & 255)) * f16101m, 33) * f16100l;
                j12 = 0 ^ ((bArr[i4 + 7] & 255) << 56);
                j12 ^= (bArr[i4 + 6] & 255) << 48;
                j12 ^= (bArr[i4 + 5] & 255) << 40;
                j12 ^= (bArr[i4 + 4] & 255) << 32;
                j12 ^= (bArr[i4 + 3] & 255) << 24;
                j12 ^= (bArr[i4 + 2] & 255) << 16;
                j12 ^= (bArr[i4 + 1] & 255) << 8;
                j10 = j3 ^ (Long.rotateLeft((j12 ^ (bArr[i4] & 255)) * f16100l, 31) * f16101m);
                break;
            case 11:
                j3 = j10;
                j6 = 0;
                j5 = j6 ^ ((bArr[i4 + 10] & 255) << 16);
                j4 = j5 ^ ((bArr[i4 + 9] & 255) << 8);
                j11 ^= Long.rotateLeft((j4 ^ (bArr[i4 + 8] & 255)) * f16101m, 33) * f16100l;
                j12 = 0 ^ ((bArr[i4 + 7] & 255) << 56);
                j12 ^= (bArr[i4 + 6] & 255) << 48;
                j12 ^= (bArr[i4 + 5] & 255) << 40;
                j12 ^= (bArr[i4 + 4] & 255) << 32;
                j12 ^= (bArr[i4 + 3] & 255) << 24;
                j12 ^= (bArr[i4 + 2] & 255) << 16;
                j12 ^= (bArr[i4 + 1] & 255) << 8;
                j10 = j3 ^ (Long.rotateLeft((j12 ^ (bArr[i4] & 255)) * f16100l, 31) * f16101m);
                break;
            case 12:
                j3 = j10;
                j7 = 0;
                j6 = j7 ^ ((bArr[i4 + 11] & 255) << 24);
                j5 = j6 ^ ((bArr[i4 + 10] & 255) << 16);
                j4 = j5 ^ ((bArr[i4 + 9] & 255) << 8);
                j11 ^= Long.rotateLeft((j4 ^ (bArr[i4 + 8] & 255)) * f16101m, 33) * f16100l;
                j12 = 0 ^ ((bArr[i4 + 7] & 255) << 56);
                j12 ^= (bArr[i4 + 6] & 255) << 48;
                j12 ^= (bArr[i4 + 5] & 255) << 40;
                j12 ^= (bArr[i4 + 4] & 255) << 32;
                j12 ^= (bArr[i4 + 3] & 255) << 24;
                j12 ^= (bArr[i4 + 2] & 255) << 16;
                j12 ^= (bArr[i4 + 1] & 255) << 8;
                j10 = j3 ^ (Long.rotateLeft((j12 ^ (bArr[i4] & 255)) * f16100l, 31) * f16101m);
                break;
            case 13:
                j3 = j10;
                j8 = 0;
                j7 = j8 ^ ((bArr[i4 + 12] & 255) << 32);
                j6 = j7 ^ ((bArr[i4 + 11] & 255) << 24);
                j5 = j6 ^ ((bArr[i4 + 10] & 255) << 16);
                j4 = j5 ^ ((bArr[i4 + 9] & 255) << 8);
                j11 ^= Long.rotateLeft((j4 ^ (bArr[i4 + 8] & 255)) * f16101m, 33) * f16100l;
                j12 = 0 ^ ((bArr[i4 + 7] & 255) << 56);
                j12 ^= (bArr[i4 + 6] & 255) << 48;
                j12 ^= (bArr[i4 + 5] & 255) << 40;
                j12 ^= (bArr[i4 + 4] & 255) << 32;
                j12 ^= (bArr[i4 + 3] & 255) << 24;
                j12 ^= (bArr[i4 + 2] & 255) << 16;
                j12 ^= (bArr[i4 + 1] & 255) << 8;
                j10 = j3 ^ (Long.rotateLeft((j12 ^ (bArr[i4] & 255)) * f16100l, 31) * f16101m);
                break;
            case 14:
                j9 = 0;
                j3 = j10;
                j8 = ((bArr[i4 + 13] & 255) << 40) ^ j9;
                j7 = j8 ^ ((bArr[i4 + 12] & 255) << 32);
                j6 = j7 ^ ((bArr[i4 + 11] & 255) << 24);
                j5 = j6 ^ ((bArr[i4 + 10] & 255) << 16);
                j4 = j5 ^ ((bArr[i4 + 9] & 255) << 8);
                j11 ^= Long.rotateLeft((j4 ^ (bArr[i4 + 8] & 255)) * f16101m, 33) * f16100l;
                j12 = 0 ^ ((bArr[i4 + 7] & 255) << 56);
                j12 ^= (bArr[i4 + 6] & 255) << 48;
                j12 ^= (bArr[i4 + 5] & 255) << 40;
                j12 ^= (bArr[i4 + 4] & 255) << 32;
                j12 ^= (bArr[i4 + 3] & 255) << 24;
                j12 ^= (bArr[i4 + 2] & 255) << 16;
                j12 ^= (bArr[i4 + 1] & 255) << 8;
                j10 = j3 ^ (Long.rotateLeft((j12 ^ (bArr[i4] & 255)) * f16100l, 31) * f16101m);
                break;
            case 15:
                j9 = ((bArr[i4 + 14] & 255) << 48) ^ 0;
                j3 = j10;
                j8 = ((bArr[i4 + 13] & 255) << 40) ^ j9;
                j7 = j8 ^ ((bArr[i4 + 12] & 255) << 32);
                j6 = j7 ^ ((bArr[i4 + 11] & 255) << 24);
                j5 = j6 ^ ((bArr[i4 + 10] & 255) << 16);
                j4 = j5 ^ ((bArr[i4 + 9] & 255) << 8);
                j11 ^= Long.rotateLeft((j4 ^ (bArr[i4 + 8] & 255)) * f16101m, 33) * f16100l;
                j12 = 0 ^ ((bArr[i4 + 7] & 255) << 56);
                j12 ^= (bArr[i4 + 6] & 255) << 48;
                j12 ^= (bArr[i4 + 5] & 255) << 40;
                j12 ^= (bArr[i4 + 4] & 255) << 32;
                j12 ^= (bArr[i4 + 3] & 255) << 24;
                j12 ^= (bArr[i4 + 2] & 255) << 16;
                j12 ^= (bArr[i4 + 1] & 255) << 8;
                j10 = j3 ^ (Long.rotateLeft((j12 ^ (bArr[i4] & 255)) * f16100l, 31) * f16101m);
                break;
        }
        long j13 = i3;
        long j14 = j10 ^ j13;
        long j15 = j13 ^ j11;
        long j16 = j14 + j15;
        long j17 = j15 + j16;
        long e2 = e(j16);
        long e3 = e(j17);
        long j18 = e2 + e3;
        return new long[]{j18, e3 + j18};
    }

    public static int n(long j2) {
        return o(j2, b);
    }

    public static int o(long j2, int i2) {
        long reverseBytes = Long.reverseBytes(j2);
        return d(E((int) (reverseBytes >>> 32), E((int) reverseBytes, i2)) ^ 8);
    }

    public static int p(long j2, long j3) {
        return q(j2, j3, b);
    }

    public static int q(long j2, long j3, int i2) {
        long reverseBytes = Long.reverseBytes(j2);
        long reverseBytes2 = Long.reverseBytes(j3);
        return d(E((int) (reverseBytes2 >>> 32), E((int) reverseBytes2, E((int) (reverseBytes >>> 32), E((int) reverseBytes, i2)))) ^ 16);
    }

    @Deprecated
    public static int r(String str) {
        byte[] k2 = p.k(str);
        return v(k2, 0, k2.length, b);
    }

    @Deprecated
    public static int s(byte[] bArr) {
        return v(bArr, 0, bArr.length, b);
    }

    @Deprecated
    public static int t(byte[] bArr, int i2) {
        return u(bArr, i2, b);
    }

    @Deprecated
    public static int u(byte[] bArr, int i2, int i3) {
        return v(bArr, 0, i2, i3);
    }

    @Deprecated
    public static int v(byte[] bArr, int i2, int i3, int i4) {
        int i5 = i3 >> 2;
        for (int i6 = 0; i6 < i5; i6++) {
            i4 = E(f(bArr, (i6 << 2) + i2), i4);
        }
        int i7 = (i5 << 2) + i2;
        int i8 = (i2 + i3) - i7;
        if (i8 != 1) {
            if (i8 != 2) {
                r1 = i8 == 3 ? 0 ^ (bArr[i7 + 2] << cb.n) : 0;
                return d(i4 ^ i3);
            }
            r1 ^= bArr[i7 + 1] << 8;
        }
        i4 ^= Integer.rotateLeft((bArr[i7] ^ r1) * f16094f, 15) * f16095g;
        return d(i4 ^ i3);
    }

    public static int w(byte[] bArr) {
        return x(bArr, 0, bArr.length, 0);
    }

    public static int x(byte[] bArr, int i2, int i3, int i4) {
        int i5 = i3 >> 2;
        for (int i6 = 0; i6 < i5; i6++) {
            i4 = E(f(bArr, (i6 << 2) + i2), i4);
        }
        int i7 = (i5 << 2) + i2;
        int i8 = (i2 + i3) - i7;
        if (i8 != 1) {
            if (i8 != 2) {
                r1 = i8 == 3 ? 0 ^ ((bArr[i7 + 2] & 255) << 16) : 0;
                return d(i4 ^ i3);
            }
            r1 ^= (bArr[i7 + 1] & 255) << 8;
        }
        i4 ^= Integer.rotateLeft(((bArr[i7] & 255) ^ r1) * f16094f, 15) * f16095g;
        return d(i4 ^ i3);
    }

    @Deprecated
    public static long y(int i2) {
        return e(((Long.rotateLeft((Integer.reverseBytes(i2) & 4294967295L) * f16100l, 31) * f16101m) ^ 104729) ^ 4);
    }

    @Deprecated
    public static long z(long j2) {
        return e(((Long.rotateLeft((Long.rotateLeft(Long.reverseBytes(j2) * f16100l, 31) * f16101m) ^ 104729, 27) * 5) + 1390208809) ^ 8);
    }
}
