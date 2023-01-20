package e.j.f.q;

import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public final class i extends g {

    /* renamed from: i  reason: collision with root package name */
    private static final int f11473i = 3;

    /* renamed from: j  reason: collision with root package name */
    private static final int f11474j = 8;

    /* renamed from: k  reason: collision with root package name */
    private static final int f11475k = 7;

    /* renamed from: l  reason: collision with root package name */
    private static final int f11476l = 40;

    /* renamed from: m  reason: collision with root package name */
    private static final int f11477m = 24;

    /* renamed from: h  reason: collision with root package name */
    private b f11478h;

    public i(e.j.f.e eVar) {
        super(eVar);
    }

    private static int[][] i(byte[] bArr, int i2, int i3, int i4, int i5) {
        int i6 = 8;
        int i7 = i5 - 8;
        int i8 = i4 - 8;
        int[][] iArr = (int[][]) Array.newInstance(int.class, i3, i2);
        int i9 = 0;
        while (i9 < i3) {
            int i10 = i9 << 3;
            if (i10 > i7) {
                i10 = i7;
            }
            int i11 = 0;
            while (i11 < i2) {
                int i12 = i11 << 3;
                if (i12 > i8) {
                    i12 = i8;
                }
                int i13 = (i10 * i4) + i12;
                int i14 = 255;
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                while (i15 < i6) {
                    int i18 = i17;
                    int i19 = 0;
                    while (i19 < i6) {
                        int i20 = bArr[i13 + i19] & 255;
                        i16 += i20;
                        if (i20 < i14) {
                            i14 = i20;
                        }
                        if (i20 > i18) {
                            i18 = i20;
                        }
                        i19++;
                        i6 = 8;
                    }
                    if (i18 - i14 <= 24) {
                        i15++;
                        i13 += i4;
                        i17 = i18;
                        i6 = 8;
                    }
                    while (true) {
                        i15++;
                        i13 += i4;
                        if (i15 < 8) {
                            int i21 = 0;
                            for (int i22 = 8; i21 < i22; i22 = 8) {
                                i16 += bArr[i13 + i21] & 255;
                                i21++;
                            }
                        }
                    }
                    i15++;
                    i13 += i4;
                    i17 = i18;
                    i6 = 8;
                }
                int i23 = i16 >> 6;
                if (i17 - i14 <= 24) {
                    i23 = i14 / 2;
                    if (i9 > 0 && i11 > 0) {
                        int i24 = i9 - 1;
                        int i25 = i11 - 1;
                        int i26 = ((iArr[i24][i11] + (iArr[i9][i25] * 2)) + iArr[i24][i25]) / 4;
                        if (i14 < i26) {
                            i23 = i26;
                        }
                        iArr[i9][i11] = i23;
                        i11++;
                        i6 = 8;
                    }
                }
                iArr[i9][i11] = i23;
                i11++;
                i6 = 8;
            }
            i9++;
            i6 = 8;
        }
        return iArr;
    }

    private static void j(byte[] bArr, int i2, int i3, int i4, int i5, int[][] iArr, b bVar) {
        int i6 = i5 - 8;
        int i7 = i4 - 8;
        for (int i8 = 0; i8 < i3; i8++) {
            int i9 = i8 << 3;
            int i10 = i9 > i6 ? i6 : i9;
            int k2 = k(i8, 2, i3 - 3);
            for (int i11 = 0; i11 < i2; i11++) {
                int i12 = i11 << 3;
                int i13 = i12 > i7 ? i7 : i12;
                int k3 = k(i11, 2, i2 - 3);
                int i14 = 0;
                for (int i15 = -2; i15 <= 2; i15++) {
                    int[] iArr2 = iArr[k2 + i15];
                    i14 += iArr2[k3 - 2] + iArr2[k3 - 1] + iArr2[k3] + iArr2[k3 + 1] + iArr2[k3 + 2];
                }
                l(bArr, i13, i10, i14 / 25, i4, bVar);
            }
        }
    }

    private static int k(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    private static void l(byte[] bArr, int i2, int i3, int i4, int i5, b bVar) {
        int i6 = (i3 * i5) + i2;
        int i7 = 0;
        while (i7 < 8) {
            for (int i8 = 0; i8 < 8; i8++) {
                if ((bArr[i6 + i8] & 255) <= i4) {
                    bVar.r(i2 + i8, i3 + i7);
                }
            }
            i7++;
            i6 += i5;
        }
    }

    @Override // e.j.f.q.g, e.j.f.a
    public e.j.f.a a(e.j.f.e eVar) {
        return new i(eVar);
    }

    @Override // e.j.f.q.g, e.j.f.a
    public b b() throws NotFoundException {
        b bVar = this.f11478h;
        if (bVar != null) {
            return bVar;
        }
        e.j.f.e e2 = e();
        int e3 = e2.e();
        int b = e2.b();
        if (e3 >= 40 && b >= 40) {
            byte[] c2 = e2.c();
            int i2 = e3 >> 3;
            if ((e3 & 7) != 0) {
                i2++;
            }
            int i3 = i2;
            int i4 = b >> 3;
            if ((b & 7) != 0) {
                i4++;
            }
            int i5 = i4;
            int[][] i6 = i(c2, i3, i5, e3, b);
            b bVar2 = new b(e3, b);
            j(c2, i3, i5, e3, b, i6, bVar2);
            this.f11478h = bVar2;
        } else {
            this.f11478h = super.b();
        }
        return this.f11478h;
    }
}
