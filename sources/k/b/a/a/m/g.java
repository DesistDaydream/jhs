package k.b.a.a.m;

import k.b.a.a.k.p;

/* loaded from: classes4.dex */
public final class g {
    private static final int a = 1540483477;
    private static final int b = 24;

    /* renamed from: c  reason: collision with root package name */
    private static final long f16089c = -4132994306676758123L;

    /* renamed from: d  reason: collision with root package name */
    private static final int f16090d = 47;

    private g() {
    }

    private static int a(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    private static long b(byte[] bArr, int i2) {
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    public static int c(String str) {
        byte[] k2 = p.k(str);
        return e(k2, k2.length);
    }

    public static int d(String str, int i2, int i3) {
        return c(str.substring(i2, i3 + i2));
    }

    public static int e(byte[] bArr, int i2) {
        return f(bArr, i2, -1756908916);
    }

    public static int f(byte[] bArr, int i2, int i3) {
        int i4 = i3 ^ i2;
        int i5 = i2 >> 2;
        for (int i6 = 0; i6 < i5; i6++) {
            int a2 = a(bArr, i6 << 2) * a;
            i4 = (i4 * a) ^ ((a2 ^ (a2 >>> 24)) * a);
        }
        int i7 = i5 << 2;
        int i8 = i2 - i7;
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    i4 ^= (bArr[i7 + 2] & 255) << 16;
                }
                int i9 = ((i4 >>> 13) ^ i4) * a;
                return i9 ^ (i9 >>> 15);
            }
            i4 ^= (bArr[i7 + 1] & 255) << 8;
        }
        i4 = ((bArr[i7] & 255) ^ i4) * a;
        int i92 = ((i4 >>> 13) ^ i4) * a;
        return i92 ^ (i92 >>> 15);
    }

    public static long g(String str) {
        byte[] k2 = p.k(str);
        return i(k2, k2.length);
    }

    public static long h(String str, int i2, int i3) {
        return g(str.substring(i2, i3 + i2));
    }

    public static long i(byte[] bArr, int i2) {
        return j(bArr, i2, -512093083);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static long j(byte[] bArr, int i2, int i3) {
        long j2 = (i3 & 4294967295L) ^ (i2 * f16089c);
        int i4 = i2 >> 3;
        for (int i5 = 0; i5 < i4; i5++) {
            long b2 = b(bArr, i5 << 3) * f16089c;
            j2 = (j2 ^ ((b2 ^ (b2 >>> 47)) * f16089c)) * f16089c;
        }
        int i6 = i4 << 3;
        switch (i2 - i6) {
            case 1:
                j2 = ((bArr[i6] & 255) ^ j2) * f16089c;
                break;
            case 2:
                j2 ^= (bArr[i6 + 1] & 255) << 8;
                j2 = ((bArr[i6] & 255) ^ j2) * f16089c;
                break;
            case 3:
                j2 ^= (bArr[i6 + 2] & 255) << 16;
                j2 ^= (bArr[i6 + 1] & 255) << 8;
                j2 = ((bArr[i6] & 255) ^ j2) * f16089c;
                break;
            case 4:
                j2 ^= (bArr[i6 + 3] & 255) << 24;
                j2 ^= (bArr[i6 + 2] & 255) << 16;
                j2 ^= (bArr[i6 + 1] & 255) << 8;
                j2 = ((bArr[i6] & 255) ^ j2) * f16089c;
                break;
            case 5:
                j2 ^= (bArr[i6 + 4] & 255) << 32;
                j2 ^= (bArr[i6 + 3] & 255) << 24;
                j2 ^= (bArr[i6 + 2] & 255) << 16;
                j2 ^= (bArr[i6 + 1] & 255) << 8;
                j2 = ((bArr[i6] & 255) ^ j2) * f16089c;
                break;
            case 6:
                j2 ^= (bArr[i6 + 5] & 255) << 40;
                j2 ^= (bArr[i6 + 4] & 255) << 32;
                j2 ^= (bArr[i6 + 3] & 255) << 24;
                j2 ^= (bArr[i6 + 2] & 255) << 16;
                j2 ^= (bArr[i6 + 1] & 255) << 8;
                j2 = ((bArr[i6] & 255) ^ j2) * f16089c;
                break;
            case 7:
                j2 ^= (bArr[i6 + 6] & 255) << 48;
                j2 ^= (bArr[i6 + 5] & 255) << 40;
                j2 ^= (bArr[i6 + 4] & 255) << 32;
                j2 ^= (bArr[i6 + 3] & 255) << 24;
                j2 ^= (bArr[i6 + 2] & 255) << 16;
                j2 ^= (bArr[i6 + 1] & 255) << 8;
                j2 = ((bArr[i6] & 255) ^ j2) * f16089c;
                break;
        }
        long j3 = ((j2 >>> 47) ^ j2) * f16089c;
        return j3 ^ (j3 >>> 47);
    }
}
