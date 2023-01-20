package e.j.f.q;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class b implements Cloneable {
    private final int a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11457c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f11458d;

    public b(int i2) {
        this(i2, i2);
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.b * (this.a + 1));
        for (int i2 = 0; i2 < this.b; i2++) {
            for (int i3 = 0; i3 < this.a; i3++) {
                sb.append(f(i3, i2) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public static b o(String str, String str2, String str3) {
        if (str != null) {
            boolean[] zArr = new boolean[str.length()];
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = -1;
            int i6 = 0;
            while (i2 < str.length()) {
                if (str.charAt(i2) == '\n' || str.charAt(i2) == '\r') {
                    if (i3 > i4) {
                        if (i5 == -1) {
                            i5 = i3 - i4;
                        } else if (i3 - i4 != i5) {
                            throw new IllegalArgumentException("row lengths do not match");
                        }
                        i6++;
                        i4 = i3;
                    }
                    i2++;
                } else {
                    if (str.substring(i2, str2.length() + i2).equals(str2)) {
                        i2 += str2.length();
                        zArr[i3] = true;
                    } else if (str.substring(i2, str3.length() + i2).equals(str3)) {
                        i2 += str3.length();
                        zArr[i3] = false;
                    } else {
                        throw new IllegalArgumentException("illegal character encountered: " + str.substring(i2));
                    }
                    i3++;
                }
            }
            if (i3 > i4) {
                if (i5 == -1) {
                    i5 = i3 - i4;
                } else if (i3 - i4 != i5) {
                    throw new IllegalArgumentException("row lengths do not match");
                }
                i6++;
            }
            b bVar = new b(i5, i6);
            for (int i7 = 0; i7 < i3; i7++) {
                if (zArr[i7]) {
                    bVar.r(i7 % i5, i7 / i5);
                }
            }
            return bVar;
        }
        throw new IllegalArgumentException();
    }

    public static b p(boolean[][] zArr) {
        int length = zArr.length;
        int length2 = zArr[0].length;
        b bVar = new b(length2, length);
        for (int i2 = 0; i2 < length; i2++) {
            boolean[] zArr2 = zArr[i2];
            for (int i3 = 0; i3 < length2; i3++) {
                if (zArr2[i3]) {
                    bVar.r(i3, i2);
                }
            }
        }
        return bVar;
    }

    public void b() {
        int length = this.f11458d.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f11458d[i2] = 0;
        }
    }

    /* renamed from: c */
    public b clone() {
        return new b(this.a, this.b, this.f11457c, (int[]) this.f11458d.clone());
    }

    public void e(int i2, int i3) {
        int i4 = (i3 * this.f11457c) + (i2 / 32);
        int[] iArr = this.f11458d;
        iArr[i4] = (1 << (i2 & 31)) ^ iArr[i4];
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b && this.f11457c == bVar.f11457c && Arrays.equals(this.f11458d, bVar.f11458d);
        }
        return false;
    }

    public boolean f(int i2, int i3) {
        return ((this.f11458d[(i3 * this.f11457c) + (i2 / 32)] >>> (i2 & 31)) & 1) != 0;
    }

    public int[] g() {
        int length = this.f11458d.length - 1;
        while (length >= 0 && this.f11458d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i2 = this.f11457c;
        int i3 = length / i2;
        int i4 = (length % i2) << 5;
        int i5 = 31;
        while ((this.f11458d[length] >>> i5) == 0) {
            i5--;
        }
        return new int[]{i4 + i5, i3};
    }

    public int[] h() {
        int i2 = this.a;
        int i3 = this.b;
        int i4 = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < this.b; i6++) {
            int i7 = 0;
            while (true) {
                int i8 = this.f11457c;
                if (i7 < i8) {
                    int i9 = this.f11458d[(i8 * i6) + i7];
                    if (i9 != 0) {
                        if (i6 < i3) {
                            i3 = i6;
                        }
                        if (i6 > i5) {
                            i5 = i6;
                        }
                        int i10 = i7 << 5;
                        if (i10 < i2) {
                            int i11 = 0;
                            while ((i9 << (31 - i11)) == 0) {
                                i11++;
                            }
                            int i12 = i11 + i10;
                            if (i12 < i2) {
                                i2 = i12;
                            }
                        }
                        if (i10 + 31 > i4) {
                            int i13 = 31;
                            while ((i9 >>> i13) == 0) {
                                i13--;
                            }
                            int i14 = i10 + i13;
                            if (i14 > i4) {
                                i4 = i14;
                            }
                        }
                    }
                    i7++;
                }
            }
        }
        if (i4 < i2 || i5 < i3) {
            return null;
        }
        return new int[]{i2, i3, (i4 - i2) + 1, (i5 - i3) + 1};
    }

    public int hashCode() {
        int i2 = this.a;
        return (((((((i2 * 31) + i2) * 31) + this.b) * 31) + this.f11457c) * 31) + Arrays.hashCode(this.f11458d);
    }

    public int j() {
        return this.b;
    }

    public a k(int i2, a aVar) {
        if (aVar != null && aVar.n() >= this.a) {
            aVar.e();
        } else {
            aVar = new a(this.a);
        }
        int i3 = i2 * this.f11457c;
        for (int i4 = 0; i4 < this.f11457c; i4++) {
            aVar.t(i4 << 5, this.f11458d[i3 + i4]);
        }
        return aVar;
    }

    public int l() {
        return this.f11457c;
    }

    public int[] m() {
        int[] iArr;
        int i2 = 0;
        while (true) {
            iArr = this.f11458d;
            if (i2 >= iArr.length || iArr[i2] != 0) {
                break;
            }
            i2++;
        }
        if (i2 == iArr.length) {
            return null;
        }
        int i3 = this.f11457c;
        int i4 = i2 / i3;
        int i5 = (i2 % i3) << 5;
        int i6 = iArr[i2];
        int i7 = 0;
        while ((i6 << (31 - i7)) == 0) {
            i7++;
        }
        return new int[]{i5 + i7, i4};
    }

    public int n() {
        return this.a;
    }

    public void q() {
        int n = n();
        int j2 = j();
        a aVar = new a(n);
        a aVar2 = new a(n);
        for (int i2 = 0; i2 < (j2 + 1) / 2; i2++) {
            aVar = k(i2, aVar);
            int i3 = (j2 - 1) - i2;
            aVar2 = k(i3, aVar2);
            aVar.r();
            aVar2.r();
            t(i2, aVar2);
            t(i3, aVar);
        }
    }

    public void r(int i2, int i3) {
        int i4 = (i3 * this.f11457c) + (i2 / 32);
        int[] iArr = this.f11458d;
        iArr[i4] = (1 << (i2 & 31)) | iArr[i4];
    }

    public void s(int i2, int i3, int i4, int i5) {
        if (i3 < 0 || i2 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i5 > 0 && i4 > 0) {
            int i6 = i4 + i2;
            int i7 = i5 + i3;
            if (i7 > this.b || i6 > this.a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i3 < i7) {
                int i8 = this.f11457c * i3;
                for (int i9 = i2; i9 < i6; i9++) {
                    int[] iArr = this.f11458d;
                    int i10 = (i9 / 32) + i8;
                    iArr[i10] = iArr[i10] | (1 << (i9 & 31));
                }
                i3++;
            }
            return;
        }
        throw new IllegalArgumentException("Height and width must be at least 1");
    }

    public void t(int i2, a aVar) {
        int[] k2 = aVar.k();
        int[] iArr = this.f11458d;
        int i3 = this.f11457c;
        System.arraycopy(k2, 0, iArr, i2 * i3, i3);
    }

    public String toString() {
        return u("X ", "  ");
    }

    public String u(String str, String str2) {
        return a(str, str2, "\n");
    }

    @Deprecated
    public String v(String str, String str2, String str3) {
        return a(str, str2, str3);
    }

    public void w(int i2, int i3) {
        int i4 = (i3 * this.f11457c) + (i2 / 32);
        int[] iArr = this.f11458d;
        iArr[i4] = (~(1 << (i2 & 31))) & iArr[i4];
    }

    public void x(b bVar) {
        if (this.a == bVar.n() && this.b == bVar.j() && this.f11457c == bVar.l()) {
            a aVar = new a(this.a);
            for (int i2 = 0; i2 < this.b; i2++) {
                int i3 = this.f11457c * i2;
                int[] k2 = bVar.k(i2, aVar).k();
                for (int i4 = 0; i4 < this.f11457c; i4++) {
                    int[] iArr = this.f11458d;
                    int i5 = i3 + i4;
                    iArr[i5] = iArr[i5] ^ k2[i4];
                }
            }
            return;
        }
        throw new IllegalArgumentException("input matrix dimensions do not match");
    }

    public b(int i2, int i3) {
        if (i2 > 0 && i3 > 0) {
            this.a = i2;
            this.b = i3;
            int i4 = (i2 + 31) / 32;
            this.f11457c = i4;
            this.f11458d = new int[i4 * i3];
            return;
        }
        throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }

    private b(int i2, int i3, int i4, int[] iArr) {
        this.a = i2;
        this.b = i3;
        this.f11457c = i4;
        this.f11458d = iArr;
    }
}
