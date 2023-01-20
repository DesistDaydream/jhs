package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes3.dex */
public class hx implements ic<hx, Object>, Serializable, Cloneable {

    /* renamed from: m  reason: collision with root package name */
    private static final it f8941m = new it("XmPushActionUnRegistration");
    private static final il n = new il("", (byte) 11, 1);
    private static final il o = new il("", (byte) 12, 2);
    private static final il p = new il("", (byte) 11, 3);
    private static final il q = new il("", (byte) 11, 4);
    private static final il r = new il("", (byte) 11, 5);
    private static final il s = new il("", (byte) 11, 6);
    private static final il t = new il("", (byte) 11, 7);
    private static final il u = new il("", (byte) 11, 8);
    private static final il v = new il("", (byte) 11, 9);
    private static final il w = new il("", (byte) 11, 10);
    private static final il x = new il("", (byte) 2, 11);
    private static final il y = new il("", (byte) 10, 12);
    public String a;
    public hf b;

    /* renamed from: c  reason: collision with root package name */
    public String f8942c;

    /* renamed from: d  reason: collision with root package name */
    public String f8943d;

    /* renamed from: e  reason: collision with root package name */
    public String f8944e;

    /* renamed from: f  reason: collision with root package name */
    public String f8945f;

    /* renamed from: g  reason: collision with root package name */
    public String f8946g;

    /* renamed from: h  reason: collision with root package name */
    public String f8947h;

    /* renamed from: i  reason: collision with root package name */
    public String f8948i;

    /* renamed from: j  reason: collision with root package name */
    public String f8949j;

    /* renamed from: l  reason: collision with root package name */
    public long f8951l;
    private BitSet z = new BitSet(2);

    /* renamed from: k  reason: collision with root package name */
    public boolean f8950k = true;

    public hx a(String str) {
        this.f8942c = str;
        return this;
    }

    @Override // com.xiaomi.push.ic
    public void a(io ioVar) {
        ioVar.f();
        while (true) {
            il h2 = ioVar.h();
            byte b = h2.b;
            if (b == 0) {
                ioVar.g();
                m();
                return;
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
                        this.f8942c = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 4:
                    if (b == 11) {
                        this.f8943d = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 5:
                    if (b == 11) {
                        this.f8944e = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 6:
                    if (b == 11) {
                        this.f8945f = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 7:
                    if (b == 11) {
                        this.f8946g = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 8:
                    if (b == 11) {
                        this.f8947h = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 9:
                    if (b == 11) {
                        this.f8948i = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 10:
                    if (b == 11) {
                        this.f8949j = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 11:
                    if (b == 2) {
                        this.f8950k = ioVar.p();
                        a(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 12:
                    if (b == 10) {
                        this.f8951l = ioVar.t();
                        b(true);
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
        this.z.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(hx hxVar) {
        if (hxVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = hxVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(hxVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = hxVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(hxVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hxVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f8942c.equals(hxVar.f8942c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hxVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f8943d.equals(hxVar.f8943d))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hxVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f8944e.equals(hxVar.f8944e))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hxVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f8945f.equals(hxVar.f8945f))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hxVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f8946g.equals(hxVar.f8946g))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hxVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f8947h.equals(hxVar.f8947h))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hxVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f8948i.equals(hxVar.f8948i))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hxVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f8949j.equals(hxVar.f8949j))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hxVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f8950k == hxVar.f8950k)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hxVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.f8951l == hxVar.f8951l;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(hx hxVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        int a12;
        if (getClass().equals(hxVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hxVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a12 = id.a(this.a, hxVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hxVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a11 = id.a(this.b, hxVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hxVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a10 = id.a(this.f8942c, hxVar.f8942c)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hxVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a9 = id.a(this.f8943d, hxVar.f8943d)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hxVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a8 = id.a(this.f8944e, hxVar.f8944e)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hxVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a7 = id.a(this.f8945f, hxVar.f8945f)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hxVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a6 = id.a(this.f8946g, hxVar.f8946g)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hxVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a5 = id.a(this.f8947h, hxVar.f8947h)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hxVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a4 = id.a(this.f8948i, hxVar.f8948i)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hxVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a3 = id.a(this.f8949j, hxVar.f8949j)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hxVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a2 = id.a(this.f8950k, hxVar.f8950k)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hxVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a = id.a(this.f8951l, hxVar.f8951l)) == 0) {
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
                    return a10;
                }
                return a11;
            }
            return a12;
        }
        return getClass().getName().compareTo(hxVar.getClass().getName());
    }

    public hx b(String str) {
        this.f8943d = str;
        return this;
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        m();
        ioVar.a(f8941m);
        if (this.a != null && a()) {
            ioVar.a(n);
            ioVar.a(this.a);
            ioVar.b();
        }
        if (this.b != null && b()) {
            ioVar.a(o);
            this.b.b(ioVar);
            ioVar.b();
        }
        if (this.f8942c != null) {
            ioVar.a(p);
            ioVar.a(this.f8942c);
            ioVar.b();
        }
        if (this.f8943d != null) {
            ioVar.a(q);
            ioVar.a(this.f8943d);
            ioVar.b();
        }
        if (this.f8944e != null && e()) {
            ioVar.a(r);
            ioVar.a(this.f8944e);
            ioVar.b();
        }
        if (this.f8945f != null && f()) {
            ioVar.a(s);
            ioVar.a(this.f8945f);
            ioVar.b();
        }
        if (this.f8946g != null && g()) {
            ioVar.a(t);
            ioVar.a(this.f8946g);
            ioVar.b();
        }
        if (this.f8947h != null && h()) {
            ioVar.a(u);
            ioVar.a(this.f8947h);
            ioVar.b();
        }
        if (this.f8948i != null && i()) {
            ioVar.a(v);
            ioVar.a(this.f8948i);
            ioVar.b();
        }
        if (this.f8949j != null && j()) {
            ioVar.a(w);
            ioVar.a(this.f8949j);
            ioVar.b();
        }
        if (k()) {
            ioVar.a(x);
            ioVar.a(this.f8950k);
            ioVar.b();
        }
        if (l()) {
            ioVar.a(y);
            ioVar.a(this.f8951l);
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public void b(boolean z) {
        this.z.set(1, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public hx c(String str) {
        this.f8944e = str;
        return this;
    }

    public boolean c() {
        return this.f8942c != null;
    }

    public hx d(String str) {
        this.f8946g = str;
        return this;
    }

    public boolean d() {
        return this.f8943d != null;
    }

    public hx e(String str) {
        this.f8947h = str;
        return this;
    }

    public boolean e() {
        return this.f8944e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hx)) {
            return a((hx) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f8945f != null;
    }

    public boolean g() {
        return this.f8946g != null;
    }

    public boolean h() {
        return this.f8947h != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f8948i != null;
    }

    public boolean j() {
        return this.f8949j != null;
    }

    public boolean k() {
        return this.z.get(0);
    }

    public boolean l() {
        return this.z.get(1);
    }

    public void m() {
        if (this.f8942c == null) {
            throw new ip("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f8943d != null) {
        } else {
            throw new ip("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
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
        String str2 = this.f8942c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f8943d;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            String str4 = this.f8944e;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str5 = this.f8945f;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f8946g;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            String str7 = this.f8947h;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str8 = this.f8948i;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f8949j;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f8950k);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f8951l);
        }
        sb.append(")");
        return sb.toString();
    }
}
