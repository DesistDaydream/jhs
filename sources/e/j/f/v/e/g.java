package e.j.f.v.e;

import e.j.f.l;

/* loaded from: classes2.dex */
public final class g extends f {

    /* renamed from: d  reason: collision with root package name */
    private final boolean f11701d;

    public g(c cVar, boolean z) {
        super(cVar);
        this.f11701d = z;
    }

    private void h(a aVar) {
        c a = a();
        l h2 = this.f11701d ? a.h() : a.i();
        l b = this.f11701d ? a.b() : a.c();
        int e2 = e((int) b.d());
        d[] d2 = d();
        int i2 = -1;
        int i3 = 0;
        int i4 = 1;
        for (int e3 = e((int) h2.d()); e3 < e2; e3++) {
            if (d2[e3] != null) {
                d dVar = d2[e3];
                dVar.j();
                int c2 = dVar.c() - i2;
                if (c2 == 0) {
                    i3++;
                } else {
                    if (c2 == 1) {
                        i4 = Math.max(i4, i3);
                        i2 = dVar.c();
                    } else if (dVar.c() >= aVar.c()) {
                        d2[e3] = null;
                    } else {
                        i2 = dVar.c();
                    }
                    i3 = 1;
                }
            }
        }
    }

    private void l(d[] dVarArr, a aVar) {
        for (int i2 = 0; i2 < dVarArr.length; i2++) {
            d dVar = dVarArr[i2];
            if (dVarArr[i2] != null) {
                int e2 = dVar.e() % 30;
                int c2 = dVar.c();
                if (c2 > aVar.c()) {
                    dVarArr[i2] = null;
                } else {
                    if (!this.f11701d) {
                        c2 += 2;
                    }
                    int i3 = c2 % 3;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 == 2 && e2 + 1 != aVar.a()) {
                                dVarArr[i2] = null;
                            }
                        } else if (e2 / 3 != aVar.b() || e2 % 3 != aVar.d()) {
                            dVarArr[i2] = null;
                        }
                    } else if ((e2 * 3) + 1 != aVar.e()) {
                        dVarArr[i2] = null;
                    }
                }
            }
        }
    }

    private void m() {
        d[] d2;
        for (d dVar : d()) {
            if (dVar != null) {
                dVar.j();
            }
        }
    }

    public void g(a aVar) {
        d[] d2 = d();
        m();
        l(d2, aVar);
        c a = a();
        l h2 = this.f11701d ? a.h() : a.i();
        l b = this.f11701d ? a.b() : a.c();
        int e2 = e((int) h2.d());
        int e3 = e((int) b.d());
        int i2 = -1;
        int i3 = 0;
        int i4 = 1;
        while (e2 < e3) {
            if (d2[e2] != null) {
                d dVar = d2[e2];
                int c2 = dVar.c() - i2;
                if (c2 == 0) {
                    i3++;
                } else {
                    if (c2 == 1) {
                        i4 = Math.max(i4, i3);
                        i2 = dVar.c();
                    } else if (c2 < 0 || dVar.c() >= aVar.c() || c2 > e2) {
                        d2[e2] = null;
                    } else {
                        if (i4 > 2) {
                            c2 *= i4 - 2;
                        }
                        boolean z = c2 >= e2;
                        for (int i5 = 1; i5 <= c2 && !z; i5++) {
                            z = d2[e2 - i5] != null;
                        }
                        if (z) {
                            d2[e2] = null;
                        } else {
                            i2 = dVar.c();
                        }
                    }
                    i3 = 1;
                }
            }
            e2++;
        }
    }

    public a i() {
        d[] d2 = d();
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        for (d dVar : d2) {
            if (dVar != null) {
                dVar.j();
                int e2 = dVar.e() % 30;
                int c2 = dVar.c();
                if (!this.f11701d) {
                    c2 += 2;
                }
                int i2 = c2 % 3;
                if (i2 == 0) {
                    bVar2.c((e2 * 3) + 1);
                } else if (i2 == 1) {
                    bVar4.c(e2 / 3);
                    bVar3.c(e2 % 3);
                } else if (i2 == 2) {
                    bVar.c(e2 + 1);
                }
            }
        }
        if (bVar.b().length == 0 || bVar2.b().length == 0 || bVar3.b().length == 0 || bVar4.b().length == 0 || bVar.b()[0] <= 0 || bVar2.b()[0] + bVar3.b()[0] < 3 || bVar2.b()[0] + bVar3.b()[0] > 90) {
            return null;
        }
        a aVar = new a(bVar.b()[0], bVar2.b()[0], bVar3.b()[0], bVar4.b()[0]);
        l(d2, aVar);
        return aVar;
    }

    public int[] j() {
        d[] d2;
        int c2;
        a i2 = i();
        if (i2 == null) {
            return null;
        }
        h(i2);
        int c3 = i2.c();
        int[] iArr = new int[c3];
        for (d dVar : d()) {
            if (dVar != null && (c2 = dVar.c()) < c3) {
                iArr[c2] = iArr[c2] + 1;
            }
        }
        return iArr;
    }

    public boolean k() {
        return this.f11701d;
    }

    @Override // e.j.f.v.e.f
    public String toString() {
        return "IsLeft: " + this.f11701d + '\n' + super.toString();
    }
}
