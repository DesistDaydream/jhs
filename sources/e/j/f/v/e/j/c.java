package e.j.f.v.e.j;

/* loaded from: classes2.dex */
public final class c {
    private final b a;
    private final int[] b;

    public c(b bVar, int[] iArr) {
        if (iArr.length != 0) {
            this.a = bVar;
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

    public c a(c cVar) {
        if (this.a.equals(cVar.a)) {
            if (f()) {
                return cVar;
            }
            if (cVar.f()) {
                return this;
            }
            int[] iArr = this.b;
            int[] iArr2 = cVar.b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i2 = length; i2 < iArr.length; i2++) {
                iArr3[i2] = this.a.a(iArr2[i2 - length], iArr[i2]);
            }
            return new c(this.a, iArr3);
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public int b(int i2) {
        if (i2 == 0) {
            return c(0);
        }
        if (i2 == 1) {
            int i3 = 0;
            for (int i4 : this.b) {
                i3 = this.a.a(i3, i4);
            }
            return i3;
        }
        int[] iArr = this.b;
        int i5 = iArr[0];
        int length = iArr.length;
        for (int i6 = 1; i6 < length; i6++) {
            b bVar = this.a;
            i5 = bVar.a(bVar.i(i2, i5), this.b[i6]);
        }
        return i5;
    }

    public int c(int i2) {
        int[] iArr = this.b;
        return iArr[(iArr.length - 1) - i2];
    }

    public int[] d() {
        return this.b;
    }

    public int e() {
        return this.b.length - 1;
    }

    public boolean f() {
        return this.b[0] == 0;
    }

    public c g(int i2) {
        if (i2 == 0) {
            return this.a.f();
        }
        if (i2 == 1) {
            return this;
        }
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.a.i(this.b[i3], i2);
        }
        return new c(this.a, iArr);
    }

    public c h(c cVar) {
        if (this.a.equals(cVar.a)) {
            if (!f() && !cVar.f()) {
                int[] iArr = this.b;
                int length = iArr.length;
                int[] iArr2 = cVar.b;
                int length2 = iArr2.length;
                int[] iArr3 = new int[(length + length2) - 1];
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = iArr[i2];
                    for (int i4 = 0; i4 < length2; i4++) {
                        int i5 = i2 + i4;
                        b bVar = this.a;
                        iArr3[i5] = bVar.a(iArr3[i5], bVar.i(i3, iArr2[i4]));
                    }
                }
                return new c(this.a, iArr3);
            }
            return this.a.f();
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public c i(int i2, int i3) {
        if (i2 >= 0) {
            if (i3 == 0) {
                return this.a.f();
            }
            int length = this.b.length;
            int[] iArr = new int[i2 + length];
            for (int i4 = 0; i4 < length; i4++) {
                iArr[i4] = this.a.i(this.b[i4], i3);
            }
            return new c(this.a, iArr);
        }
        throw new IllegalArgumentException();
    }

    public c j() {
        int length = this.b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.a.j(0, this.b[i2]);
        }
        return new c(this.a, iArr);
    }

    public c k(c cVar) {
        if (this.a.equals(cVar.a)) {
            return cVar.f() ? this : a(cVar.j());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(e() * 8);
        for (int e2 = e(); e2 >= 0; e2--) {
            int c2 = c(e2);
            if (c2 != 0) {
                if (c2 < 0) {
                    sb.append(" - ");
                    c2 = -c2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (e2 == 0 || c2 != 1) {
                    sb.append(c2);
                }
                if (e2 != 0) {
                    if (e2 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(e2);
                    }
                }
            }
        }
        return sb.toString();
    }
}
