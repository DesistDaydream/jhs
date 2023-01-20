package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes3.dex */
public class hy implements ic<hy, Object>, Serializable, Cloneable {

    /* renamed from: j  reason: collision with root package name */
    private static final it f8952j = new it("XmPushActionUnRegistrationResult");

    /* renamed from: k  reason: collision with root package name */
    private static final il f8953k = new il("", (byte) 11, 1);

    /* renamed from: l  reason: collision with root package name */
    private static final il f8954l = new il("", (byte) 12, 2);

    /* renamed from: m  reason: collision with root package name */
    private static final il f8955m = new il("", (byte) 11, 3);
    private static final il n = new il("", (byte) 11, 4);
    private static final il o = new il("", (byte) 10, 6);
    private static final il p = new il("", (byte) 11, 7);
    private static final il q = new il("", (byte) 11, 8);
    private static final il r = new il("", (byte) 10, 9);
    private static final il s = new il("", (byte) 10, 10);
    public String a;
    public hf b;

    /* renamed from: c  reason: collision with root package name */
    public String f8956c;

    /* renamed from: d  reason: collision with root package name */
    public String f8957d;

    /* renamed from: e  reason: collision with root package name */
    public long f8958e;

    /* renamed from: f  reason: collision with root package name */
    public String f8959f;

    /* renamed from: g  reason: collision with root package name */
    public String f8960g;

    /* renamed from: h  reason: collision with root package name */
    public long f8961h;

    /* renamed from: i  reason: collision with root package name */
    public long f8962i;
    private BitSet t = new BitSet(3);

    @Override // com.xiaomi.push.ic
    public void a(io ioVar) {
        ioVar.f();
        while (true) {
            il h2 = ioVar.h();
            byte b = h2.b;
            if (b == 0) {
                ioVar.g();
                if (e()) {
                    k();
                    return;
                }
                throw new ip("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (h2.f9004c) {
                case 1:
                    if (b == 11) {
                        this.a = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 2:
                    if (b == 12) {
                        hf hfVar = new hf();
                        this.b = hfVar;
                        hfVar.a(ioVar);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 3:
                    if (b == 11) {
                        this.f8956c = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 4:
                    if (b == 11) {
                        this.f8957d = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 6:
                    if (b == 10) {
                        this.f8958e = ioVar.t();
                        a(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 7:
                    if (b == 11) {
                        this.f8959f = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 8:
                    if (b == 11) {
                        this.f8960g = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 9:
                    if (b == 10) {
                        this.f8961h = ioVar.t();
                        b(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 10:
                    if (b == 10) {
                        this.f8962i = ioVar.t();
                        c(true);
                        continue;
                        ioVar.i();
                    }
                    break;
            }
            ir.a(ioVar, b);
            ioVar.i();
        }
    }

    public void a(boolean z) {
        this.t.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(hy hyVar) {
        if (hyVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = hyVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(hyVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = hyVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(hyVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hyVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f8956c.equals(hyVar.f8956c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hyVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f8957d.equals(hyVar.f8957d))) || this.f8958e != hyVar.f8958e) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hyVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f8959f.equals(hyVar.f8959f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hyVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f8960g.equals(hyVar.f8960g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hyVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f8961h == hyVar.f8961h)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hyVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f8962i == hyVar.f8962i;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(hy hyVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(hyVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hyVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a9 = id.a(this.a, hyVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hyVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a8 = id.a(this.b, hyVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hyVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a7 = id.a(this.f8956c, hyVar.f8956c)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hyVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a6 = id.a(this.f8957d, hyVar.f8957d)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hyVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a5 = id.a(this.f8958e, hyVar.f8958e)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hyVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a4 = id.a(this.f8959f, hyVar.f8959f)) == 0) {
                                    int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hyVar.h()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!h() || (a3 = id.a(this.f8960g, hyVar.f8960g)) == 0) {
                                        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hyVar.i()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!i() || (a2 = id.a(this.f8961h, hyVar.f8961h)) == 0) {
                                            int compareTo9 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hyVar.j()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!j() || (a = id.a(this.f8962i, hyVar.f8962i)) == 0) {
                                                return 0;
                                            }
                                            return a;
                                        }
                                        return a2;
                                    }
                                    return a3;
                                }
                                return a4;
                            }
                            return a5;
                        }
                        return a6;
                    }
                    return a7;
                }
                return a8;
            }
            return a9;
        }
        return getClass().getName().compareTo(hyVar.getClass().getName());
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        k();
        ioVar.a(f8952j);
        if (this.a != null && a()) {
            ioVar.a(f8953k);
            ioVar.a(this.a);
            ioVar.b();
        }
        if (this.b != null && b()) {
            ioVar.a(f8954l);
            this.b.b(ioVar);
            ioVar.b();
        }
        if (this.f8956c != null) {
            ioVar.a(f8955m);
            ioVar.a(this.f8956c);
            ioVar.b();
        }
        if (this.f8957d != null) {
            ioVar.a(n);
            ioVar.a(this.f8957d);
            ioVar.b();
        }
        ioVar.a(o);
        ioVar.a(this.f8958e);
        ioVar.b();
        if (this.f8959f != null && f()) {
            ioVar.a(p);
            ioVar.a(this.f8959f);
            ioVar.b();
        }
        if (this.f8960g != null && h()) {
            ioVar.a(q);
            ioVar.a(this.f8960g);
            ioVar.b();
        }
        if (i()) {
            ioVar.a(r);
            ioVar.a(this.f8961h);
            ioVar.b();
        }
        if (j()) {
            ioVar.a(s);
            ioVar.a(this.f8962i);
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public void b(boolean z) {
        this.t.set(1, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public void c(boolean z) {
        this.t.set(2, z);
    }

    public boolean c() {
        return this.f8956c != null;
    }

    public boolean d() {
        return this.f8957d != null;
    }

    public boolean e() {
        return this.t.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hy)) {
            return a((hy) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f8959f != null;
    }

    public String g() {
        return this.f8960g;
    }

    public boolean h() {
        return this.f8960g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.t.get(1);
    }

    public boolean j() {
        return this.t.get(2);
    }

    public void k() {
        if (this.f8956c == null) {
            throw new ip("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f8957d != null) {
        } else {
            throw new ip("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = false;
        if (a()) {
            sb.append("debug:");
            String str = this.a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            hf hfVar = this.b;
            if (hfVar == null) {
                sb.append("null");
            } else {
                sb.append(hfVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f8956c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f8957d;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f8958e);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f8959f;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f8960g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f8961h);
        }
        if (j()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f8962i);
        }
        sb.append(")");
        return sb.toString();
    }
}
