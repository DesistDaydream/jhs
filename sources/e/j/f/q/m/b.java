package e.j.f.q.m;

/* loaded from: classes2.dex */
public final class b {
    private final a a;
    private final int[] b;

    public b(a aVar, int[] iArr) {
        if (iArr.length != 0) {
            this.a = aVar;
            int length = iArr.length;
            if (length > 1 && iArr[0] == 0) {
                int i2 = 1;
                while (i2 < length && iArr[i2] == 0) {
                    i2++;
                }
                if (i2 == length) {
                    this.b = new int[]{0};
                    return;
                }
                int[] iArr2 = new int[length - i2];
                this.b = iArr2;
                System.arraycopy(iArr, i2, iArr2, 0, iArr2.length);
                return;
            }
            this.b = iArr;
            return;
        }
        throw new IllegalArgumentException();
    }

    public b a(b bVar) {
        if (this.a.equals(bVar.a)) {
            if (g()) {
                return bVar;
            }
            if (bVar.g()) {
                return this;
            }
            int[] iArr = this.b;
            int[] iArr2 = bVar.b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i2 = length; i2 < iArr.length; i2++) {
                iArr3[i2] = a.a(iArr2[i2 - length], iArr[i2]);
            }
            return new b(this.a, iArr3);
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    public b[] b(b bVar) {
        if (this.a.equals(bVar.a)) {
            if (!bVar.g()) {
                b g2 = this.a.g();
                int h2 = this.a.h(bVar.d(bVar.f()));
                b bVar2 = this;
                while (bVar2.f() >= bVar.f() && !bVar2.g()) {
                    int f2 = bVar2.f() - bVar.f();
                    int j2 = this.a.j(bVar2.d(bVar2.f()), h2);
                    b j3 = bVar.j(f2, j2);
                    g2 = g2.a(this.a.b(f2, j2));
                    bVar2 = bVar2.a(j3);
                }
                return new b[]{g2, bVar2};
            }
            throw new IllegalArgumentException("Divide by 0");
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    public int c(int i2) {
        if (i2 == 0) {
            return d(0);
        }
        if (i2 == 1) {
            int i3 = 0;
            for (int i4 : this.b) {
                i3 = a.a(i3, i4);
            }
            return i3;
        }
        int[] iArr = this.b;
        int i5 = iArr[0];
        int length = iArr.length;
        for (int i6 = 1; i6 < length; i6++) {
            i5 = a.a(this.a.j(i2, i5), this.b[i6]);
        }
        return i5;
    }

    public int d(int i2) {
        int[] iArr = this.b;
        return iArr[(iArr.length - 1) - i2];
    }

    public int[] e() {
        return this.b;
    }

    public int f() {
        return this.b.length - 1;
    }

    public boolean g() {
        return this.b[0] == 0;
    }

    public b h(int i2) {
        if (i2 == 0) {
            return this.a.g();
        }
        if (i2 == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.a.j(this.b[i3], i2);
        }
        return new b(this.a, iArr);
    }

    public b i(b bVar) {
        if (this.a.equals(bVar.a)) {
            if (!g() && !bVar.g()) {
                int[] iArr = this.b;
                int length = iArr.length;
                int[] iArr2 = bVar.b;
                int length2 = iArr2.length;
                int[] iArr3 = new int[(length + length2) - 1];
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = iArr[i2];
                    for (int i4 = 0; i4 < length2; i4++) {
                        int i5 = i2 + i4;
                        iArr3[i5] = a.a(iArr3[i5], this.a.j(i3, iArr2[i4]));
                    }
                }
                return new b(this.a, iArr3);
            }
            return this.a.g();
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    public b j(int i2, int i3) {
        if (i2 >= 0) {
            if (i3 == 0) {
                return this.a.g();
            }
            int length = this.b.length;
            int[] iArr = new int[i2 + length];
            for (int i4 = 0; i4 < length; i4++) {
                iArr[i4] = this.a.j(this.b[i4], i3);
            }
            return new b(this.a, iArr);
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(f() * 8);
        for (int f2 = f(); f2 >= 0; f2--) {
            int d2 = d(f2);
            if (d2 != 0) {
                if (d2 < 0) {
                    sb.append(" - ");
                    d2 = -d2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (f2 == 0 || d2 != 1) {
                    int i2 = this.a.i(d2);
                    if (i2 == 0) {
                        sb.append('1');
                    } else if (i2 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(i2);
                    }
                }
                if (f2 != 0) {
                    if (f2 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(f2);
                    }
                }
            }
        }
        return sb.toString();
    }
}
