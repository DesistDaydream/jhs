package e.j.f.q;

import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public class g extends e.j.f.a {

    /* renamed from: d  reason: collision with root package name */
    private static final int f11468d = 5;

    /* renamed from: e  reason: collision with root package name */
    private static final int f11469e = 3;

    /* renamed from: f  reason: collision with root package name */
    private static final int f11470f = 32;

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f11471g = new byte[0];
    private byte[] b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f11472c;

    public g(e.j.f.e eVar) {
        super(eVar);
        this.b = f11471g;
        this.f11472c = new int[32];
    }

    private static int g(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (iArr[i5] > i2) {
                i2 = iArr[i5];
                i4 = i5;
            }
            if (iArr[i5] > i3) {
                i3 = iArr[i5];
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i4;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i7) {
                i6 = i8;
                i7 = i10;
            }
        }
        if (i4 <= i6) {
            int i11 = i4;
            i4 = i6;
            i6 = i11;
        }
        if (i4 - i6 > length / 16) {
            int i12 = i4 - 1;
            int i13 = i12;
            int i14 = -1;
            while (i12 > i6) {
                int i15 = i12 - i6;
                int i16 = i15 * i15 * (i4 - i12) * (i3 - iArr[i12]);
                if (i16 > i14) {
                    i13 = i12;
                    i14 = i16;
                }
                i12--;
            }
            return i13 << 3;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void h(int i2) {
        if (this.b.length < i2) {
            this.b = new byte[i2];
        }
        for (int i3 = 0; i3 < 32; i3++) {
            this.f11472c[i3] = 0;
        }
    }

    @Override // e.j.f.a
    public e.j.f.a a(e.j.f.e eVar) {
        return new g(eVar);
    }

    @Override // e.j.f.a
    public b b() throws NotFoundException {
        e.j.f.e e2 = e();
        int e3 = e2.e();
        int b = e2.b();
        b bVar = new b(e3, b);
        h(e3);
        int[] iArr = this.f11472c;
        for (int i2 = 1; i2 < 5; i2++) {
            byte[] d2 = e2.d((b * i2) / 5, this.b);
            int i3 = (e3 << 2) / 5;
            for (int i4 = e3 / 5; i4 < i3; i4++) {
                int i5 = (d2[i4] & 255) >> 3;
                iArr[i5] = iArr[i5] + 1;
            }
        }
        int g2 = g(iArr);
        byte[] c2 = e2.c();
        for (int i6 = 0; i6 < b; i6++) {
            int i7 = i6 * e3;
            for (int i8 = 0; i8 < e3; i8++) {
                if ((c2[i7 + i8] & 255) < g2) {
                    bVar.r(i8, i6);
                }
            }
        }
        return bVar;
    }

    @Override // e.j.f.a
    public a c(int i2, a aVar) throws NotFoundException {
        e.j.f.e e2 = e();
        int e3 = e2.e();
        if (aVar != null && aVar.n() >= e3) {
            aVar.e();
        } else {
            aVar = new a(e3);
        }
        h(e3);
        byte[] d2 = e2.d(i2, this.b);
        int[] iArr = this.f11472c;
        for (int i3 = 0; i3 < e3; i3++) {
            int i4 = (d2[i3] & 255) >> 3;
            iArr[i4] = iArr[i4] + 1;
        }
        int g2 = g(iArr);
        if (e3 < 3) {
            for (int i5 = 0; i5 < e3; i5++) {
                if ((d2[i5] & 255) < g2) {
                    aVar.s(i5);
                }
            }
        } else {
            int i6 = d2[1] & 255;
            int i7 = 1;
            int i8 = d2[0] & 255;
            int i9 = i6;
            while (i7 < e3 - 1) {
                int i10 = i7 + 1;
                int i11 = d2[i10] & 255;
                if ((((i9 << 2) - i8) - i11) / 2 < g2) {
                    aVar.s(i7);
                }
                i8 = i9;
                i7 = i10;
                i9 = i11;
            }
        }
        return aVar;
    }
}
