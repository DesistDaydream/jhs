package e.j.f.w.c;

import com.google.zxing.FormatException;
import com.google.zxing.qrcode.decoder.DataMask;

/* loaded from: classes2.dex */
public final class a {
    private final e.j.f.q.b a;
    private g b;

    /* renamed from: c  reason: collision with root package name */
    private e f11743c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11744d;

    public a(e.j.f.q.b bVar) throws FormatException {
        int j2 = bVar.j();
        if (j2 >= 21 && (j2 & 3) == 1) {
            this.a = bVar;
            return;
        }
        throw FormatException.getFormatInstance();
    }

    private int a(int i2, int i3, int i4) {
        return this.f11744d ? this.a.f(i3, i2) : this.a.f(i2, i3) ? (i4 << 1) | 1 : i4 << 1;
    }

    public void b() {
        int i2 = 0;
        while (i2 < this.a.n()) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < this.a.j(); i4++) {
                if (this.a.f(i2, i4) != this.a.f(i4, i2)) {
                    this.a.e(i4, i2);
                    this.a.e(i2, i4);
                }
            }
            i2 = i3;
        }
    }

    public byte[] c() throws FormatException {
        e d2 = d();
        g e2 = e();
        DataMask dataMask = DataMask.values()[d2.c()];
        int j2 = this.a.j();
        dataMask.unmaskBitMatrix(this.a, j2);
        e.j.f.q.b a = e2.a();
        byte[] bArr = new byte[e2.h()];
        int i2 = j2 - 1;
        boolean z = true;
        int i3 = i2;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 > 0) {
            if (i3 == 6) {
                i3--;
            }
            for (int i7 = 0; i7 < j2; i7++) {
                int i8 = z ? i2 - i7 : i7;
                for (int i9 = 0; i9 < 2; i9++) {
                    int i10 = i3 - i9;
                    if (!a.f(i10, i8)) {
                        i5++;
                        i6 <<= 1;
                        if (this.a.f(i10, i8)) {
                            i6 |= 1;
                        }
                        if (i5 == 8) {
                            bArr[i4] = (byte) i6;
                            i4++;
                            i5 = 0;
                            i6 = 0;
                        }
                    }
                }
            }
            z = !z;
            i3 -= 2;
        }
        if (i4 == e2.h()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    public e d() throws FormatException {
        e eVar = this.f11743c;
        if (eVar != null) {
            return eVar;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 6; i4++) {
            i3 = a(i4, 8, i3);
        }
        int a = a(8, 7, a(8, 8, a(7, 8, i3)));
        for (int i5 = 5; i5 >= 0; i5--) {
            a = a(8, i5, a);
        }
        int j2 = this.a.j();
        int i6 = j2 - 7;
        for (int i7 = j2 - 1; i7 >= i6; i7--) {
            i2 = a(8, i7, i2);
        }
        for (int i8 = j2 - 8; i8 < j2; i8++) {
            i2 = a(i8, 8, i2);
        }
        e a2 = e.a(a, i2);
        this.f11743c = a2;
        if (a2 != null) {
            return a2;
        }
        throw FormatException.getFormatInstance();
    }

    public g e() throws FormatException {
        g gVar = this.b;
        if (gVar != null) {
            return gVar;
        }
        int j2 = this.a.j();
        int i2 = (j2 - 17) / 4;
        if (i2 <= 6) {
            return g.i(i2);
        }
        int i3 = j2 - 11;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = j2 - 9; i7 >= i3; i7--) {
                i5 = a(i7, i6, i5);
            }
        }
        g c2 = g.c(i5);
        if (c2 != null && c2.e() == j2) {
            this.b = c2;
            return c2;
        }
        for (int i8 = 5; i8 >= 0; i8--) {
            for (int i9 = j2 - 9; i9 >= i3; i9--) {
                i4 = a(i8, i9, i4);
            }
        }
        g c3 = g.c(i4);
        if (c3 != null && c3.e() == j2) {
            this.b = c3;
            return c3;
        }
        throw FormatException.getFormatInstance();
    }

    public void f() {
        if (this.f11743c == null) {
            return;
        }
        DataMask.values()[this.f11743c.c()].unmaskBitMatrix(this.a, this.a.j());
    }

    public void g(boolean z) {
        this.b = null;
        this.f11743c = null;
        this.f11744d = z;
    }
}
