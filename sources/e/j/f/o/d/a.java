package e.j.f.o.d;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.j256.ormlite.stmt.query.SimpleComparison;
import e.j.f.l;
import e.j.f.q.b;
import e.j.f.q.h;
import e.j.f.q.m.c;
import h.t2.y;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f11349g = {3808, 476, 2107, 1799};
    private final b a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private int f11350c;

    /* renamed from: d  reason: collision with root package name */
    private int f11351d;

    /* renamed from: e  reason: collision with root package name */
    private int f11352e;

    /* renamed from: f  reason: collision with root package name */
    private int f11353f;

    /* renamed from: e.j.f.o.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0381a {
        private final int a;
        private final int b;

        public C0381a(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public l c() {
            return new l(a(), b());
        }

        public String toString() {
            return SimpleComparison.LESS_THAN_OPERATION + this.a + ' ' + this.b + y.f15692e;
        }
    }

    public a(b bVar) {
        this.a = bVar;
    }

    private static float c(l lVar, l lVar2) {
        return e.j.f.q.l.a.a(lVar.c(), lVar.d(), lVar2.c(), lVar2.d());
    }

    private static float d(C0381a c0381a, C0381a c0381a2) {
        return e.j.f.q.l.a.b(c0381a.a(), c0381a.b(), c0381a2.a(), c0381a2.b());
    }

    private static l[] e(l[] lVarArr, int i2, int i3) {
        float f2 = i3 / (i2 * 2.0f);
        float c2 = lVarArr[0].c() - lVarArr[2].c();
        float d2 = lVarArr[0].d() - lVarArr[2].d();
        float c3 = (lVarArr[0].c() + lVarArr[2].c()) / 2.0f;
        float d3 = (lVarArr[0].d() + lVarArr[2].d()) / 2.0f;
        float f3 = c2 * f2;
        float f4 = d2 * f2;
        l lVar = new l(c3 + f3, d3 + f4);
        l lVar2 = new l(c3 - f3, d3 - f4);
        float c4 = lVarArr[1].c() - lVarArr[3].c();
        float d4 = lVarArr[1].d() - lVarArr[3].d();
        float c5 = (lVarArr[1].c() + lVarArr[3].c()) / 2.0f;
        float d5 = (lVarArr[1].d() + lVarArr[3].d()) / 2.0f;
        float f5 = c4 * f2;
        float f6 = f2 * d4;
        return new l[]{lVar, new l(c5 + f5, d5 + f6), lVar2, new l(c5 - f5, d5 - f6)};
    }

    private void f(l[] lVarArr) throws NotFoundException {
        long j2;
        long j3;
        if (p(lVarArr[0]) && p(lVarArr[1]) && p(lVarArr[2]) && p(lVarArr[3])) {
            int i2 = this.f11352e * 2;
            int[] iArr = {s(lVarArr[0], lVarArr[1], i2), s(lVarArr[1], lVarArr[2], i2), s(lVarArr[2], lVarArr[3], i2), s(lVarArr[3], lVarArr[0], i2)};
            this.f11353f = n(iArr, i2);
            long j4 = 0;
            for (int i3 = 0; i3 < 4; i3++) {
                int i4 = iArr[(this.f11353f + i3) % 4];
                if (this.b) {
                    j2 = j4 << 7;
                    j3 = (i4 >> 1) & 127;
                } else {
                    j2 = j4 << 10;
                    j3 = ((i4 >> 2) & 992) + ((i4 >> 1) & 31);
                }
                j4 = j2 + j3;
            }
            int i5 = i(j4, this.b);
            if (this.b) {
                this.f11350c = (i5 >> 6) + 1;
                this.f11351d = (i5 & 63) + 1;
                return;
            }
            this.f11350c = (i5 >> 11) + 1;
            this.f11351d = (i5 & 2047) + 1;
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private l[] g(C0381a c0381a) throws NotFoundException {
        this.f11352e = 1;
        C0381a c0381a2 = c0381a;
        C0381a c0381a3 = c0381a2;
        C0381a c0381a4 = c0381a3;
        C0381a c0381a5 = c0381a4;
        boolean z = true;
        while (this.f11352e < 9) {
            C0381a k2 = k(c0381a2, z, 1, -1);
            C0381a k3 = k(c0381a3, z, 1, 1);
            C0381a k4 = k(c0381a4, z, -1, 1);
            C0381a k5 = k(c0381a5, z, -1, -1);
            if (this.f11352e > 2) {
                double d2 = (d(k5, k2) * this.f11352e) / (d(c0381a5, c0381a2) * (this.f11352e + 2));
                if (d2 < 0.75d || d2 > 1.25d || !q(k2, k3, k4, k5)) {
                    break;
                }
            }
            z = !z;
            this.f11352e++;
            c0381a5 = k5;
            c0381a2 = k2;
            c0381a3 = k3;
            c0381a4 = k4;
        }
        int i2 = this.f11352e;
        if (i2 != 5 && i2 != 7) {
            throw NotFoundException.getNotFoundInstance();
        }
        this.b = i2 == 5;
        l[] lVarArr = {new l(c0381a2.a() + 0.5f, c0381a2.b() - 0.5f), new l(c0381a3.a() + 0.5f, c0381a3.b() + 0.5f), new l(c0381a4.a() - 0.5f, c0381a4.b() + 0.5f), new l(c0381a5.a() - 0.5f, c0381a5.b() - 0.5f)};
        int i3 = this.f11352e;
        return e(lVarArr, (i3 * 2) - 3, i3 * 2);
    }

    private int h(C0381a c0381a, C0381a c0381a2) {
        float d2 = d(c0381a, c0381a2);
        float a = (c0381a2.a() - c0381a.a()) / d2;
        float b = (c0381a2.b() - c0381a.b()) / d2;
        float a2 = c0381a.a();
        float b2 = c0381a.b();
        boolean f2 = this.a.f(c0381a.a(), c0381a.b());
        int ceil = (int) Math.ceil(d2);
        int i2 = 0;
        for (int i3 = 0; i3 < ceil; i3++) {
            a2 += a;
            b2 += b;
            if (this.a.f(e.j.f.q.l.a.c(a2), e.j.f.q.l.a.c(b2)) != f2) {
                i2++;
            }
        }
        float f3 = i2 / d2;
        if (f3 <= 0.1f || f3 >= 0.9f) {
            return (f3 <= 0.1f) == f2 ? 1 : -1;
        }
        return 0;
    }

    private static int i(long j2, boolean z) throws NotFoundException {
        int i2;
        int i3;
        if (z) {
            i2 = 7;
            i3 = 2;
        } else {
            i2 = 10;
            i3 = 4;
        }
        int i4 = i2 - i3;
        int[] iArr = new int[i2];
        for (int i5 = i2 - 1; i5 >= 0; i5--) {
            iArr[i5] = ((int) j2) & 15;
            j2 >>= 4;
        }
        try {
            new c(e.j.f.q.m.a.f11501k).a(iArr, i4);
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                i6 = (i6 << 4) + iArr[i7];
            }
            return i6;
        } catch (ReedSolomonException unused) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private int j() {
        if (this.b) {
            return (this.f11350c * 4) + 11;
        }
        int i2 = this.f11350c;
        return i2 <= 4 ? (i2 * 4) + 15 : (i2 * 4) + ((((i2 - 4) / 8) + 1) * 2) + 15;
    }

    private C0381a k(C0381a c0381a, boolean z, int i2, int i3) {
        int a = c0381a.a() + i2;
        int b = c0381a.b();
        while (true) {
            b += i3;
            if (!o(a, b) || this.a.f(a, b) != z) {
                break;
            }
            a += i2;
        }
        int i4 = a - i2;
        int i5 = b - i3;
        while (o(i4, i5) && this.a.f(i4, i5) == z) {
            i4 += i2;
        }
        int i6 = i4 - i2;
        while (o(i6, i5) && this.a.f(i6, i5) == z) {
            i5 += i3;
        }
        return new C0381a(i6, i5 - i3);
    }

    private C0381a l() {
        l c2;
        l lVar;
        l lVar2;
        l lVar3;
        l c3;
        l c4;
        l c5;
        l c6;
        try {
            l[] c7 = new e.j.f.q.l.c(this.a).c();
            lVar2 = c7[0];
            lVar3 = c7[1];
            lVar = c7[2];
            c2 = c7[3];
        } catch (NotFoundException unused) {
            int n = this.a.n() / 2;
            int j2 = this.a.j() / 2;
            int i2 = n + 7;
            int i3 = j2 - 7;
            l c8 = k(new C0381a(i2, i3), false, 1, -1).c();
            int i4 = j2 + 7;
            l c9 = k(new C0381a(i2, i4), false, 1, 1).c();
            int i5 = n - 7;
            l c10 = k(new C0381a(i5, i4), false, -1, 1).c();
            c2 = k(new C0381a(i5, i3), false, -1, -1).c();
            lVar = c10;
            lVar2 = c8;
            lVar3 = c9;
        }
        int c11 = e.j.f.q.l.a.c((((lVar2.c() + c2.c()) + lVar3.c()) + lVar.c()) / 4.0f);
        int c12 = e.j.f.q.l.a.c((((lVar2.d() + c2.d()) + lVar3.d()) + lVar.d()) / 4.0f);
        try {
            l[] c13 = new e.j.f.q.l.c(this.a, 15, c11, c12).c();
            c3 = c13[0];
            c4 = c13[1];
            c5 = c13[2];
            c6 = c13[3];
        } catch (NotFoundException unused2) {
            int i6 = c11 + 7;
            int i7 = c12 - 7;
            c3 = k(new C0381a(i6, i7), false, 1, -1).c();
            int i8 = c12 + 7;
            c4 = k(new C0381a(i6, i8), false, 1, 1).c();
            int i9 = c11 - 7;
            c5 = k(new C0381a(i9, i8), false, -1, 1).c();
            c6 = k(new C0381a(i9, i7), false, -1, -1).c();
        }
        return new C0381a(e.j.f.q.l.a.c((((c3.c() + c6.c()) + c4.c()) + c5.c()) / 4.0f), e.j.f.q.l.a.c((((c3.d() + c6.d()) + c4.d()) + c5.d()) / 4.0f));
    }

    private l[] m(l[] lVarArr) {
        return e(lVarArr, this.f11352e * 2, j());
    }

    private static int n(int[] iArr, int i2) throws NotFoundException {
        int i3 = 0;
        for (int i4 : iArr) {
            i3 = (i3 << 3) + ((i4 >> (i2 - 2)) << 1) + (i4 & 1);
        }
        int i5 = ((i3 & 1) << 11) + (i3 >> 1);
        for (int i6 = 0; i6 < 4; i6++) {
            if (Integer.bitCount(f11349g[i6] ^ i5) <= 2) {
                return i6;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private boolean o(int i2, int i3) {
        return i2 >= 0 && i2 < this.a.n() && i3 > 0 && i3 < this.a.j();
    }

    private boolean p(l lVar) {
        return o(e.j.f.q.l.a.c(lVar.c()), e.j.f.q.l.a.c(lVar.d()));
    }

    private boolean q(C0381a c0381a, C0381a c0381a2, C0381a c0381a3, C0381a c0381a4) {
        C0381a c0381a5 = new C0381a(c0381a.a() - 3, c0381a.b() + 3);
        C0381a c0381a6 = new C0381a(c0381a2.a() - 3, c0381a2.b() - 3);
        C0381a c0381a7 = new C0381a(c0381a3.a() + 3, c0381a3.b() - 3);
        C0381a c0381a8 = new C0381a(c0381a4.a() + 3, c0381a4.b() + 3);
        int h2 = h(c0381a8, c0381a5);
        return h2 != 0 && h(c0381a5, c0381a6) == h2 && h(c0381a6, c0381a7) == h2 && h(c0381a7, c0381a8) == h2;
    }

    private b r(b bVar, l lVar, l lVar2, l lVar3, l lVar4) throws NotFoundException {
        h b = h.b();
        int j2 = j();
        float f2 = j2 / 2.0f;
        int i2 = this.f11352e;
        float f3 = f2 - i2;
        float f4 = f2 + i2;
        return b.c(bVar, j2, j2, f3, f3, f4, f3, f4, f4, f3, f4, lVar.c(), lVar.d(), lVar2.c(), lVar2.d(), lVar3.c(), lVar3.d(), lVar4.c(), lVar4.d());
    }

    private int s(l lVar, l lVar2, int i2) {
        float c2 = c(lVar, lVar2);
        float f2 = c2 / i2;
        float c3 = lVar.c();
        float d2 = lVar.d();
        float c4 = ((lVar2.c() - lVar.c()) * f2) / c2;
        float d3 = (f2 * (lVar2.d() - lVar.d())) / c2;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            float f3 = i4;
            if (this.a.f(e.j.f.q.l.a.c((f3 * c4) + c3), e.j.f.q.l.a.c((f3 * d3) + d2))) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    public e.j.f.o.a a() throws NotFoundException {
        return b(false);
    }

    public e.j.f.o.a b(boolean z) throws NotFoundException {
        l[] g2 = g(l());
        if (z) {
            l lVar = g2[0];
            g2[0] = g2[2];
            g2[2] = lVar;
        }
        f(g2);
        b bVar = this.a;
        int i2 = this.f11353f;
        return new e.j.f.o.a(r(bVar, g2[i2 % 4], g2[(i2 + 1) % 4], g2[(i2 + 2) % 4], g2[(i2 + 3) % 4]), m(g2), this.b, this.f11351d, this.f11350c);
    }
}
