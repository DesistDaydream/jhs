package e.j.f.w.c;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import e.j.f.w.c.g;

/* loaded from: classes2.dex */
public final class b {
    private final int a;
    private final byte[] b;

    private b(int i2, byte[] bArr) {
        this.a = i2;
        this.b = bArr;
    }

    public static b[] b(byte[] bArr, g gVar, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length == gVar.h()) {
            g.b f2 = gVar.f(errorCorrectionLevel);
            g.a[] a = f2.a();
            int i2 = 0;
            for (g.a aVar : a) {
                i2 += aVar.a();
            }
            b[] bVarArr = new b[i2];
            int i3 = 0;
            for (g.a aVar2 : a) {
                int i4 = 0;
                while (i4 < aVar2.a()) {
                    int b = aVar2.b();
                    bVarArr[i3] = new b(b, new byte[f2.b() + b]);
                    i4++;
                    i3++;
                }
            }
            int length = bVarArr[0].b.length;
            int i5 = i2 - 1;
            while (i5 >= 0 && bVarArr[i5].b.length != length) {
                i5--;
            }
            int i6 = i5 + 1;
            int b2 = length - f2.b();
            int i7 = 0;
            for (int i8 = 0; i8 < b2; i8++) {
                int i9 = 0;
                while (i9 < i3) {
                    bVarArr[i9].b[i8] = bArr[i7];
                    i9++;
                    i7++;
                }
            }
            int i10 = i6;
            while (i10 < i3) {
                bVarArr[i10].b[b2] = bArr[i7];
                i10++;
                i7++;
            }
            int length2 = bVarArr[0].b.length;
            while (b2 < length2) {
                int i11 = 0;
                while (i11 < i3) {
                    bVarArr[i11].b[i11 < i6 ? b2 : b2 + 1] = bArr[i7];
                    i11++;
                    i7++;
                }
                b2++;
            }
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    public byte[] a() {
        return this.b;
    }

    public int c() {
        return this.a;
    }
}
