package e.j.f.v.e;

import java.util.Formatter;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: e  reason: collision with root package name */
    private static final int f11697e = 2;
    private final a a;
    private final f[] b;

    /* renamed from: c  reason: collision with root package name */
    private c f11698c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11699d;

    public e(a aVar, c cVar) {
        this.a = aVar;
        int a = aVar.a();
        this.f11699d = a;
        this.f11698c = cVar;
        this.b = new f[a + 2];
    }

    private void a(f fVar) {
        if (fVar != null) {
            ((g) fVar).g(this.a);
        }
    }

    private static boolean b(d dVar, d dVar2) {
        if (dVar2 != null && dVar2.g() && dVar2.a() == dVar.a()) {
            dVar.i(dVar2.c());
            return true;
        }
        return false;
    }

    private static int c(int i2, int i3, d dVar) {
        if (dVar == null || dVar.g()) {
            return i3;
        }
        if (dVar.h(i2)) {
            dVar.i(i2);
            return 0;
        }
        return i3 + 1;
    }

    private int d() {
        int f2 = f();
        if (f2 == 0) {
            return 0;
        }
        for (int i2 = 1; i2 < this.f11699d + 1; i2++) {
            d[] d2 = this.b[i2].d();
            for (int i3 = 0; i3 < d2.length; i3++) {
                if (d2[i3] != null && !d2[i3].g()) {
                    e(i2, i3, d2);
                }
            }
        }
        return f2;
    }

    private void e(int i2, int i3, d[] dVarArr) {
        d dVar = dVarArr[i3];
        d[] d2 = this.b[i2 - 1].d();
        f[] fVarArr = this.b;
        int i4 = i2 + 1;
        d[] d3 = fVarArr[i4] != null ? fVarArr[i4].d() : d2;
        d[] dVarArr2 = new d[14];
        dVarArr2[2] = d2[i3];
        dVarArr2[3] = d3[i3];
        if (i3 > 0) {
            int i5 = i3 - 1;
            dVarArr2[0] = dVarArr[i5];
            dVarArr2[4] = d2[i5];
            dVarArr2[5] = d3[i5];
        }
        if (i3 > 1) {
            int i6 = i3 - 2;
            dVarArr2[8] = dVarArr[i6];
            dVarArr2[10] = d2[i6];
            dVarArr2[11] = d3[i6];
        }
        if (i3 < dVarArr.length - 1) {
            int i7 = i3 + 1;
            dVarArr2[1] = dVarArr[i7];
            dVarArr2[6] = d2[i7];
            dVarArr2[7] = d3[i7];
        }
        if (i3 < dVarArr.length - 2) {
            int i8 = i3 + 2;
            dVarArr2[9] = dVarArr[i8];
            dVarArr2[12] = d2[i8];
            dVarArr2[13] = d3[i8];
        }
        for (int i9 = 0; i9 < 14 && !b(dVar, dVarArr2[i9]); i9++) {
        }
    }

    private int f() {
        g();
        return h() + i();
    }

    private void g() {
        f[] fVarArr = this.b;
        if (fVarArr[0] == null || fVarArr[this.f11699d + 1] == null) {
            return;
        }
        d[] d2 = fVarArr[0].d();
        d[] d3 = this.b[this.f11699d + 1].d();
        for (int i2 = 0; i2 < d2.length; i2++) {
            if (d2[i2] != null && d3[i2] != null && d2[i2].c() == d3[i2].c()) {
                for (int i3 = 1; i3 <= this.f11699d; i3++) {
                    d dVar = this.b[i3].d()[i2];
                    if (dVar != null) {
                        dVar.i(d2[i2].c());
                        if (!dVar.g()) {
                            this.b[i3].d()[i2] = null;
                        }
                    }
                }
            }
        }
    }

    private int h() {
        f[] fVarArr = this.b;
        if (fVarArr[0] == null) {
            return 0;
        }
        d[] d2 = fVarArr[0].d();
        int i2 = 0;
        for (int i3 = 0; i3 < d2.length; i3++) {
            if (d2[i3] != null) {
                int c2 = d2[i3].c();
                int i4 = 0;
                for (int i5 = 1; i5 < this.f11699d + 1 && i4 < 2; i5++) {
                    d dVar = this.b[i5].d()[i3];
                    if (dVar != null) {
                        i4 = c(c2, i4, dVar);
                        if (!dVar.g()) {
                            i2++;
                        }
                    }
                }
            }
        }
        return i2;
    }

    private int i() {
        f[] fVarArr = this.b;
        int i2 = this.f11699d;
        if (fVarArr[i2 + 1] == null) {
            return 0;
        }
        d[] d2 = fVarArr[i2 + 1].d();
        int i3 = 0;
        for (int i4 = 0; i4 < d2.length; i4++) {
            if (d2[i4] != null) {
                int c2 = d2[i4].c();
                int i5 = 0;
                for (int i6 = this.f11699d + 1; i6 > 0 && i5 < 2; i6--) {
                    d dVar = this.b[i6].d()[i4];
                    if (dVar != null) {
                        i5 = c(c2, i5, dVar);
                        if (!dVar.g()) {
                            i3++;
                        }
                    }
                }
            }
        }
        return i3;
    }

    public int j() {
        return this.f11699d;
    }

    public int k() {
        return this.a.b();
    }

    public int l() {
        return this.a.c();
    }

    public c m() {
        return this.f11698c;
    }

    public f n(int i2) {
        return this.b[i2];
    }

    public f[] o() {
        a(this.b[0]);
        a(this.b[this.f11699d + 1]);
        int i2 = e.j.f.v.a.b;
        while (true) {
            int d2 = d();
            if (d2 <= 0 || d2 >= i2) {
                break;
            }
            i2 = d2;
        }
        return this.b;
    }

    public void p(c cVar) {
        this.f11698c = cVar;
    }

    public void q(int i2, f fVar) {
        this.b[i2] = fVar;
    }

    public String toString() {
        f[] fVarArr = this.b;
        f fVar = fVarArr[0];
        if (fVar == null) {
            fVar = fVarArr[this.f11699d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i2 = 0; i2 < fVar.d().length; i2++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i2));
                for (int i3 = 0; i3 < this.f11699d + 2; i3++) {
                    f[] fVarArr2 = this.b;
                    if (fVarArr2[i3] == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        d dVar = fVarArr2[i3].d()[i2];
                        if (dVar == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
