package com.xiaomi.push;

import java.io.InputStream;
import java.util.Vector;

/* loaded from: classes3.dex */
public final class ab {
    private final byte[] a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f8237c;

    /* renamed from: d  reason: collision with root package name */
    private int f8238d;

    /* renamed from: e  reason: collision with root package name */
    private final InputStream f8239e;

    /* renamed from: f  reason: collision with root package name */
    private int f8240f;

    /* renamed from: g  reason: collision with root package name */
    private int f8241g;

    /* renamed from: h  reason: collision with root package name */
    private int f8242h;

    /* renamed from: i  reason: collision with root package name */
    private int f8243i;

    /* renamed from: j  reason: collision with root package name */
    private int f8244j;

    /* renamed from: k  reason: collision with root package name */
    private int f8245k;

    private ab(InputStream inputStream) {
        this.f8242h = Integer.MAX_VALUE;
        this.f8244j = 64;
        this.f8245k = 67108864;
        this.a = new byte[4096];
        this.b = 0;
        this.f8238d = 0;
        this.f8239e = inputStream;
    }

    private ab(byte[] bArr, int i2, int i3) {
        this.f8242h = Integer.MAX_VALUE;
        this.f8244j = 64;
        this.f8245k = 67108864;
        this.a = bArr;
        this.b = i3 + i2;
        this.f8238d = i2;
        this.f8239e = null;
    }

    public static ab a(InputStream inputStream) {
        return new ab(inputStream);
    }

    public static ab a(byte[] bArr, int i2, int i3) {
        return new ab(bArr, i2, i3);
    }

    private boolean a(boolean z) {
        int i2 = this.f8238d;
        int i3 = this.b;
        if (i2 >= i3) {
            int i4 = this.f8241g;
            if (i4 + i3 == this.f8242h) {
                if (z) {
                    throw cd.a();
                }
                return false;
            }
            this.f8241g = i4 + i3;
            this.f8238d = 0;
            InputStream inputStream = this.f8239e;
            int read = inputStream == null ? -1 : inputStream.read(this.a);
            this.b = read;
            if (read == 0 || read < -1) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.b + "\nThe InputStream implementation is buggy.");
            } else if (read == -1) {
                this.b = 0;
                if (z) {
                    throw cd.a();
                }
                return false;
            } else {
                p();
                int i5 = this.f8241g + this.b + this.f8237c;
                if (i5 > this.f8245k || i5 < 0) {
                    throw cd.h();
                }
                return true;
            }
        }
        throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }

    private void p() {
        int i2 = this.b + this.f8237c;
        this.b = i2;
        int i3 = this.f8241g + i2;
        int i4 = this.f8242h;
        if (i3 <= i4) {
            this.f8237c = 0;
            return;
        }
        int i5 = i3 - i4;
        this.f8237c = i5;
        this.b = i2 - i5;
    }

    public int a() {
        if (n()) {
            this.f8240f = 0;
            return 0;
        }
        int j2 = j();
        this.f8240f = j2;
        if (j2 != 0) {
            return j2;
        }
        throw cd.d();
    }

    public void a(int i2) {
        if (this.f8240f != i2) {
            throw cd.e();
        }
    }

    public void a(de deVar) {
        int j2 = j();
        if (this.f8243i >= this.f8244j) {
            throw cd.g();
        }
        int c2 = c(j2);
        this.f8243i++;
        deVar.c(this);
        a(0);
        this.f8243i--;
        d(c2);
    }

    public void b() {
        int a;
        do {
            a = a();
            if (a == 0) {
                return;
            }
        } while (b(a));
    }

    public boolean b(int i2) {
        int a = ee.a(i2);
        if (a == 0) {
            e();
            return true;
        } else if (a == 1) {
            m();
            return true;
        } else if (a == 2) {
            f(j());
            return true;
        } else if (a == 3) {
            b();
            a(ee.a(ee.b(i2), 4));
            return true;
        } else if (a != 4) {
            if (a == 5) {
                l();
                return true;
            }
            throw cd.f();
        } else {
            return false;
        }
    }

    public int c(int i2) {
        if (i2 >= 0) {
            int i3 = i2 + this.f8241g + this.f8238d;
            int i4 = this.f8242h;
            if (i3 <= i4) {
                this.f8242h = i3;
                p();
                return i4;
            }
            throw cd.a();
        }
        throw cd.b();
    }

    public long c() {
        return k();
    }

    public long d() {
        return k();
    }

    public void d(int i2) {
        this.f8242h = i2;
        p();
    }

    public int e() {
        return j();
    }

    public byte[] e(int i2) {
        if (i2 < 0) {
            throw cd.b();
        }
        int i3 = this.f8241g;
        int i4 = this.f8238d;
        int i5 = i3 + i4 + i2;
        int i6 = this.f8242h;
        if (i5 > i6) {
            f((i6 - i3) - i4);
            throw cd.a();
        }
        int i7 = this.b;
        if (i2 <= i7 - i4) {
            byte[] bArr = new byte[i2];
            System.arraycopy(this.a, i4, bArr, 0, i2);
            this.f8238d += i2;
            return bArr;
        } else if (i2 >= 4096) {
            this.f8241g = i3 + i7;
            this.f8238d = 0;
            this.b = 0;
            int i8 = i7 - i4;
            int i9 = i2 - i8;
            Vector vector = new Vector();
            while (i9 > 0) {
                int min = Math.min(i9, 4096);
                byte[] bArr2 = new byte[min];
                int i10 = 0;
                while (i10 < min) {
                    InputStream inputStream = this.f8239e;
                    int read = inputStream == null ? -1 : inputStream.read(bArr2, i10, min - i10);
                    if (read == -1) {
                        throw cd.a();
                    }
                    this.f8241g += read;
                    i10 += read;
                }
                i9 -= min;
                vector.addElement(bArr2);
            }
            byte[] bArr3 = new byte[i2];
            System.arraycopy(this.a, i4, bArr3, 0, i8);
            for (int i11 = 0; i11 < vector.size(); i11++) {
                byte[] bArr4 = (byte[]) vector.elementAt(i11);
                System.arraycopy(bArr4, 0, bArr3, i8, bArr4.length);
                i8 += bArr4.length;
            }
            return bArr3;
        } else {
            byte[] bArr5 = new byte[i2];
            int i12 = i7 - i4;
            System.arraycopy(this.a, i4, bArr5, 0, i12);
            this.f8238d = this.b;
            while (true) {
                a(true);
                int i13 = i2 - i12;
                int i14 = this.b;
                if (i13 <= i14) {
                    System.arraycopy(this.a, 0, bArr5, i12, i13);
                    this.f8238d = i13;
                    return bArr5;
                }
                System.arraycopy(this.a, 0, bArr5, i12, i14);
                int i15 = this.b;
                i12 += i15;
                this.f8238d = i15;
            }
        }
    }

    public void f(int i2) {
        if (i2 < 0) {
            throw cd.b();
        }
        int i3 = this.f8241g;
        int i4 = this.f8238d;
        int i5 = i3 + i4 + i2;
        int i6 = this.f8242h;
        if (i5 > i6) {
            f((i6 - i3) - i4);
            throw cd.a();
        }
        int i7 = this.b;
        if (i2 <= i7 - i4) {
            this.f8238d = i4 + i2;
            return;
        }
        int i8 = i7 - i4;
        this.f8241g = i3 + i7;
        this.f8238d = 0;
        this.b = 0;
        while (i8 < i2) {
            InputStream inputStream = this.f8239e;
            int skip = inputStream == null ? -1 : (int) inputStream.skip(i2 - i8);
            if (skip <= 0) {
                throw cd.a();
            }
            i8 += skip;
            this.f8241g += skip;
        }
    }

    public boolean f() {
        return j() != 0;
    }

    public String g() {
        int j2 = j();
        if (j2 > this.b - this.f8238d || j2 <= 0) {
            return new String(e(j2), "UTF-8");
        }
        String str = new String(this.a, this.f8238d, j2, "UTF-8");
        this.f8238d += j2;
        return str;
    }

    public a h() {
        int j2 = j();
        int i2 = this.b;
        int i3 = this.f8238d;
        if (j2 > i2 - i3 || j2 <= 0) {
            return a.a(e(j2));
        }
        a a = a.a(this.a, i3, j2);
        this.f8238d += j2;
        return a;
    }

    public int i() {
        return j();
    }

    public int j() {
        int i2;
        byte o = o();
        if (o >= 0) {
            return o;
        }
        int i3 = o & h.k2.v.n.b;
        byte o2 = o();
        if (o2 >= 0) {
            i2 = o2 << 7;
        } else {
            i3 |= (o2 & h.k2.v.n.b) << 7;
            byte o3 = o();
            if (o3 >= 0) {
                i2 = o3 << 14;
            } else {
                i3 |= (o3 & h.k2.v.n.b) << 14;
                byte o4 = o();
                if (o4 < 0) {
                    int i4 = i3 | ((o4 & h.k2.v.n.b) << 21);
                    byte o5 = o();
                    int i5 = i4 | (o5 << 28);
                    if (o5 < 0) {
                        for (int i6 = 0; i6 < 5; i6++) {
                            if (o() >= 0) {
                                return i5;
                            }
                        }
                        throw cd.c();
                    }
                    return i5;
                }
                i2 = o4 << 21;
            }
        }
        return i3 | i2;
    }

    public long k() {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte o = o();
            j2 |= (o & h.k2.v.n.b) << i2;
            if ((o & h.k2.v.n.a) == 0) {
                return j2;
            }
        }
        throw cd.c();
    }

    public int l() {
        return (o() & 255) | ((o() & 255) << 8) | ((o() & 255) << 16) | ((o() & 255) << 24);
    }

    public long m() {
        byte o = o();
        byte o2 = o();
        return ((o2 & 255) << 8) | (o & 255) | ((o() & 255) << 16) | ((o() & 255) << 24) | ((o() & 255) << 32) | ((o() & 255) << 40) | ((o() & 255) << 48) | ((o() & 255) << 56);
    }

    public boolean n() {
        return this.f8238d == this.b && !a(false);
    }

    public byte o() {
        if (this.f8238d == this.b) {
            a(true);
        }
        byte[] bArr = this.a;
        int i2 = this.f8238d;
        this.f8238d = i2 + 1;
        return bArr[i2];
    }
}
