package e.j.f.v.e;

import java.util.Formatter;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private static final int f11700c = 5;
    private final c a;
    private final d[] b;

    public f(c cVar) {
        this.a = new c(cVar);
        this.b = new d[(cVar.e() - cVar.g()) + 1];
    }

    public final c a() {
        return this.a;
    }

    public final d b(int i2) {
        return this.b[e(i2)];
    }

    public final d c(int i2) {
        d dVar;
        d dVar2;
        d b = b(i2);
        if (b != null) {
            return b;
        }
        for (int i3 = 1; i3 < 5; i3++) {
            int e2 = e(i2) - i3;
            if (e2 >= 0 && (dVar2 = this.b[e2]) != null) {
                return dVar2;
            }
            int e3 = e(i2) + i3;
            d[] dVarArr = this.b;
            if (e3 < dVarArr.length && (dVar = dVarArr[e3]) != null) {
                return dVar;
            }
        }
        return null;
    }

    public final d[] d() {
        return this.b;
    }

    public final int e(int i2) {
        return i2 - this.a.g();
    }

    public final void f(int i2, d dVar) {
        this.b[e(i2)] = dVar;
    }

    public String toString() {
        d[] dVarArr;
        Formatter formatter = new Formatter();
        try {
            int i2 = 0;
            for (d dVar : this.b) {
                if (dVar == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i2));
                    i2++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i2), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                    i2++;
                }
            }
            String formatter2 = formatter.toString();
            formatter.close();
            return formatter2;
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
}
