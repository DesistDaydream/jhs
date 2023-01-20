package e.j.f.q.l;

import com.google.zxing.NotFoundException;
import e.j.f.l;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: h  reason: collision with root package name */
    private static final int f11491h = 10;

    /* renamed from: i  reason: collision with root package name */
    private static final int f11492i = 1;
    private final e.j.f.q.b a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11493c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11494d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11495e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11496f;

    /* renamed from: g  reason: collision with root package name */
    private final int f11497g;

    public c(e.j.f.q.b bVar) throws NotFoundException {
        this(bVar, 10, bVar.n() / 2, bVar.j() / 2);
    }

    private l[] a(l lVar, l lVar2, l lVar3, l lVar4) {
        float c2 = lVar.c();
        float d2 = lVar.d();
        float c3 = lVar2.c();
        float d3 = lVar2.d();
        float c4 = lVar3.c();
        float d4 = lVar3.d();
        float c5 = lVar4.c();
        float d5 = lVar4.d();
        return c2 < ((float) this.f11493c) / 2.0f ? new l[]{new l(c5 - 1.0f, d5 + 1.0f), new l(c3 + 1.0f, d3 + 1.0f), new l(c4 - 1.0f, d4 - 1.0f), new l(c2 + 1.0f, d2 - 1.0f)} : new l[]{new l(c5 + 1.0f, d5 + 1.0f), new l(c3 + 1.0f, d3 - 1.0f), new l(c4 - 1.0f, d4 + 1.0f), new l(c2 - 1.0f, d2 - 1.0f)};
    }

    private boolean b(int i2, int i3, int i4, boolean z) {
        if (z) {
            while (i2 <= i3) {
                if (this.a.f(i2, i4)) {
                    return true;
                }
                i2++;
            }
            return false;
        }
        while (i2 <= i3) {
            if (this.a.f(i4, i2)) {
                return true;
            }
            i2++;
        }
        return false;
    }

    private l d(float f2, float f3, float f4, float f5) {
        int c2 = a.c(a.a(f2, f3, f4, f5));
        float f6 = c2;
        float f7 = (f4 - f2) / f6;
        float f8 = (f5 - f3) / f6;
        for (int i2 = 0; i2 < c2; i2++) {
            float f9 = i2;
            int c3 = a.c((f9 * f7) + f2);
            int c4 = a.c((f9 * f8) + f3);
            if (this.a.f(c3, c4)) {
                return new l(c3, c4);
            }
        }
        return null;
    }

    public l[] c() throws NotFoundException {
        int i2 = this.f11494d;
        int i3 = this.f11495e;
        int i4 = this.f11497g;
        int i5 = this.f11496f;
        boolean z = false;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while (z2) {
            boolean z8 = true;
            boolean z9 = false;
            while (true) {
                if ((z8 || !z3) && i3 < this.f11493c) {
                    z8 = b(i4, i5, i3, false);
                    if (z8) {
                        i3++;
                        z3 = true;
                        z9 = true;
                    } else if (!z3) {
                        i3++;
                    }
                }
            }
            if (i3 < this.f11493c) {
                boolean z10 = true;
                while (true) {
                    if ((z10 || !z4) && i5 < this.b) {
                        z10 = b(i2, i3, i5, true);
                        if (z10) {
                            i5++;
                            z4 = true;
                            z9 = true;
                        } else if (!z4) {
                            i5++;
                        }
                    }
                }
                if (i5 < this.b) {
                    boolean z11 = true;
                    while (true) {
                        if ((z11 || !z5) && i2 >= 0) {
                            z11 = b(i4, i5, i2, false);
                            if (z11) {
                                i2--;
                                z5 = true;
                                z9 = true;
                            } else if (!z5) {
                                i2--;
                            }
                        }
                    }
                    if (i2 >= 0) {
                        z2 = z9;
                        boolean z12 = true;
                        while (true) {
                            if ((z12 || !z7) && i4 >= 0) {
                                z12 = b(i2, i3, i4, true);
                                if (z12) {
                                    i4--;
                                    z2 = true;
                                    z7 = true;
                                } else if (!z7) {
                                    i4--;
                                }
                            }
                        }
                        if (i4 >= 0) {
                            if (z2) {
                                z6 = true;
                            }
                        }
                    }
                }
            }
            z = true;
            break;
        }
        if (z || !z6) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i6 = i3 - i2;
        l lVar = null;
        l lVar2 = null;
        for (int i7 = 1; lVar2 == null && i7 < i6; i7++) {
            lVar2 = d(i2, i5 - i7, i2 + i7, i5);
        }
        if (lVar2 != null) {
            l lVar3 = null;
            for (int i8 = 1; lVar3 == null && i8 < i6; i8++) {
                lVar3 = d(i2, i4 + i8, i2 + i8, i4);
            }
            if (lVar3 != null) {
                l lVar4 = null;
                for (int i9 = 1; lVar4 == null && i9 < i6; i9++) {
                    lVar4 = d(i3, i4 + i9, i3 - i9, i4);
                }
                if (lVar4 != null) {
                    for (int i10 = 1; lVar == null && i10 < i6; i10++) {
                        lVar = d(i3, i5 - i10, i3 - i10, i5);
                    }
                    if (lVar != null) {
                        return a(lVar, lVar2, lVar4, lVar3);
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public c(e.j.f.q.b bVar, int i2, int i3, int i4) throws NotFoundException {
        this.a = bVar;
        int j2 = bVar.j();
        this.b = j2;
        int n = bVar.n();
        this.f11493c = n;
        int i5 = i2 / 2;
        int i6 = i3 - i5;
        this.f11494d = i6;
        int i7 = i3 + i5;
        this.f11495e = i7;
        int i8 = i4 - i5;
        this.f11497g = i8;
        int i9 = i4 + i5;
        this.f11496f = i9;
        if (i8 < 0 || i6 < 0 || i9 >= j2 || i7 >= n) {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
