package e.j.f.w.d;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import e.j.f.l;
import e.j.f.m;
import e.j.f.q.f;
import e.j.f.q.h;
import e.j.f.q.j;
import e.j.f.w.c.g;
import java.util.Map;

/* loaded from: classes2.dex */
public class c {
    private final e.j.f.q.b a;
    private m b;

    public c(e.j.f.q.b bVar) {
        this.a = bVar;
    }

    private float b(l lVar, l lVar2) {
        float m2 = m((int) lVar.c(), (int) lVar.d(), (int) lVar2.c(), (int) lVar2.d());
        float m3 = m((int) lVar2.c(), (int) lVar2.d(), (int) lVar.c(), (int) lVar.d());
        return Float.isNaN(m2) ? m3 / 7.0f : Float.isNaN(m3) ? m2 / 7.0f : (m2 + m3) / 14.0f;
    }

    private static int c(l lVar, l lVar2, l lVar3, float f2) throws NotFoundException {
        int c2 = ((e.j.f.q.l.a.c(l.b(lVar, lVar2) / f2) + e.j.f.q.l.a.c(l.b(lVar, lVar3) / f2)) / 2) + 7;
        int i2 = c2 & 3;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return c2;
                }
                throw NotFoundException.getNotFoundInstance();
            }
            return c2 - 1;
        }
        return c2 + 1;
    }

    private static j d(l lVar, l lVar2, l lVar3, l lVar4, int i2) {
        float c2;
        float d2;
        float f2;
        float f3 = i2 - 3.5f;
        if (lVar4 != null) {
            c2 = lVar4.c();
            d2 = lVar4.d();
            f2 = f3 - 3.0f;
        } else {
            c2 = (lVar2.c() - lVar.c()) + lVar3.c();
            d2 = (lVar2.d() - lVar.d()) + lVar3.d();
            f2 = f3;
        }
        return j.b(3.5f, 3.5f, f3, 3.5f, f2, f2, 3.5f, f3, lVar.c(), lVar.d(), lVar2.c(), lVar2.d(), c2, d2, lVar3.c(), lVar3.d());
    }

    private static e.j.f.q.b k(e.j.f.q.b bVar, j jVar, int i2) throws NotFoundException {
        return h.b().d(bVar, i2, i2, jVar);
    }

    private float l(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        c cVar;
        boolean z;
        boolean z2;
        int i11 = 1;
        boolean z3 = Math.abs(i5 - i3) > Math.abs(i4 - i2);
        if (z3) {
            i7 = i2;
            i6 = i3;
            i9 = i4;
            i8 = i5;
        } else {
            i6 = i2;
            i7 = i3;
            i8 = i4;
            i9 = i5;
        }
        int abs = Math.abs(i8 - i6);
        int abs2 = Math.abs(i9 - i7);
        int i12 = (-abs) / 2;
        int i13 = i6 < i8 ? 1 : -1;
        int i14 = i7 < i9 ? 1 : -1;
        int i15 = i8 + i13;
        int i16 = i6;
        int i17 = i7;
        int i18 = 0;
        while (true) {
            if (i16 == i15) {
                i10 = i15;
                break;
            }
            int i19 = z3 ? i17 : i16;
            int i20 = z3 ? i16 : i17;
            if (i18 == i11) {
                cVar = this;
                z = z3;
                i10 = i15;
                z2 = true;
            } else {
                cVar = this;
                z = z3;
                i10 = i15;
                z2 = false;
            }
            if (z2 == cVar.a.f(i19, i20)) {
                if (i18 == 2) {
                    return e.j.f.q.l.a.b(i16, i17, i6, i7);
                }
                i18++;
            }
            i12 += abs2;
            if (i12 > 0) {
                if (i17 == i9) {
                    break;
                }
                i17 += i14;
                i12 -= abs;
            }
            i16 += i13;
            i15 = i10;
            z3 = z;
            i11 = 1;
        }
        if (i18 == 2) {
            return e.j.f.q.l.a.b(i10, i9, i6, i7);
        }
        return Float.NaN;
    }

    private float m(int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float l2 = l(i2, i3, i4, i5);
        int i6 = i2 - (i4 - i2);
        int i7 = 0;
        if (i6 < 0) {
            f2 = i2 / (i2 - i6);
            i6 = 0;
        } else if (i6 >= this.a.n()) {
            f2 = ((this.a.n() - 1) - i2) / (i6 - i2);
            i6 = this.a.n() - 1;
        } else {
            f2 = 1.0f;
        }
        float f4 = i3;
        int i8 = (int) (f4 - ((i5 - i3) * f2));
        if (i8 < 0) {
            f3 = f4 / (i3 - i8);
        } else if (i8 >= this.a.j()) {
            f3 = ((this.a.j() - 1) - i3) / (i8 - i3);
            i7 = this.a.j() - 1;
        } else {
            i7 = i8;
            f3 = 1.0f;
        }
        return (l2 + l(i2, i3, (int) (i2 + ((i6 - i2) * f3)), i7)) - 1.0f;
    }

    public final float a(l lVar, l lVar2, l lVar3) {
        return (b(lVar, lVar2) + b(lVar, lVar3)) / 2.0f;
    }

    public f e() throws NotFoundException, FormatException {
        return f(null);
    }

    public final f f(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        m mVar = map == null ? null : (m) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        this.b = mVar;
        return j(new FinderPatternFinder(this.a, mVar).f(map));
    }

    public final a g(float f2, int i2, int i3, float f3) throws NotFoundException {
        int i4 = (int) (f3 * f2);
        int max = Math.max(0, i2 - i4);
        int min = Math.min(this.a.n() - 1, i2 + i4) - max;
        float f4 = 3.0f * f2;
        if (min >= f4) {
            int max2 = Math.max(0, i3 - i4);
            int min2 = Math.min(this.a.j() - 1, i3 + i4) - max2;
            if (min2 >= f4) {
                return new b(this.a, max, max2, min, min2, f2, this.b).c();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final e.j.f.q.b h() {
        return this.a;
    }

    public final m i() {
        return this.b;
    }

    public final f j(e eVar) throws NotFoundException, FormatException {
        d b = eVar.b();
        d c2 = eVar.c();
        d a = eVar.a();
        float a2 = a(b, c2, a);
        if (a2 >= 1.0f) {
            int c3 = c(b, c2, a, a2);
            g g2 = g.g(c3);
            int e2 = g2.e() - 7;
            a aVar = null;
            if (g2.d().length > 0) {
                float c4 = (c2.c() - b.c()) + a.c();
                float d2 = (c2.d() - b.d()) + a.d();
                float f2 = 1.0f - (3.0f / e2);
                int c5 = (int) (b.c() + ((c4 - b.c()) * f2));
                int d3 = (int) (b.d() + (f2 * (d2 - b.d())));
                for (int i2 = 4; i2 <= 16; i2 <<= 1) {
                    try {
                        aVar = g(a2, c5, d3, i2);
                        break;
                    } catch (NotFoundException unused) {
                    }
                }
            }
            return new f(k(this.a, d(b, c2, a, aVar, c3), c3), aVar == null ? new l[]{a, b, c2} : new l[]{a, b, c2, aVar});
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
