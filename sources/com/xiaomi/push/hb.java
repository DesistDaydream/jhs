package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes3.dex */
public class hb implements ic<hb, Object>, Serializable, Cloneable {

    /* renamed from: h  reason: collision with root package name */
    private static final it f8755h = new it("OnlineConfigItem");

    /* renamed from: i  reason: collision with root package name */
    private static final il f8756i = new il("", (byte) 8, 1);

    /* renamed from: j  reason: collision with root package name */
    private static final il f8757j = new il("", (byte) 8, 2);

    /* renamed from: k  reason: collision with root package name */
    private static final il f8758k = new il("", (byte) 2, 3);

    /* renamed from: l  reason: collision with root package name */
    private static final il f8759l = new il("", (byte) 8, 4);

    /* renamed from: m  reason: collision with root package name */
    private static final il f8760m = new il("", (byte) 10, 5);
    private static final il n = new il("", (byte) 11, 6);
    private static final il o = new il("", (byte) 2, 7);
    public int a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8761c;

    /* renamed from: d  reason: collision with root package name */
    public int f8762d;

    /* renamed from: e  reason: collision with root package name */
    public long f8763e;

    /* renamed from: f  reason: collision with root package name */
    public String f8764f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8765g;
    private BitSet p = new BitSet(6);

    public int a() {
        return this.a;
    }

    @Override // com.xiaomi.push.ic
    public void a(io ioVar) {
        ioVar.f();
        while (true) {
            il h2 = ioVar.h();
            byte b = h2.b;
            if (b == 0) {
                ioVar.g();
                n();
                return;
            }
            switch (h2.f9004c) {
                case 1:
                    if (b == 8) {
                        this.a = ioVar.s();
                        a(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 2:
                    if (b == 8) {
                        this.b = ioVar.s();
                        b(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 3:
                    if (b == 2) {
                        this.f8761c = ioVar.p();
                        c(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 4:
                    if (b == 8) {
                        this.f8762d = ioVar.s();
                        d(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 5:
                    if (b == 10) {
                        this.f8763e = ioVar.t();
                        e(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 6:
                    if (b == 11) {
                        this.f8764f = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 7:
                    if (b == 2) {
                        this.f8765g = ioVar.p();
                        f(true);
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
        this.p.set(0, z);
    }

    public boolean a(hb hbVar) {
        if (hbVar == null) {
            return false;
        }
        boolean b = b();
        boolean b2 = hbVar.b();
        if ((b || b2) && !(b && b2 && this.a == hbVar.a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hbVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.b == hbVar.b)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hbVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f8761c == hbVar.f8761c)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hbVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f8762d == hbVar.f8762d)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hbVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f8763e == hbVar.f8763e)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hbVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f8764f.equals(hbVar.f8764f))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hbVar.m();
        if (m2 || m3) {
            return m2 && m3 && this.f8765g == hbVar.f8765g;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(hb hbVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (getClass().equals(hbVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hbVar.b()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!b() || (a7 = id.a(this.a, hbVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hbVar.d()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!d() || (a6 = id.a(this.b, hbVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hbVar.e()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!e() || (a5 = id.a(this.f8761c, hbVar.f8761c)) == 0) {
                        int compareTo4 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hbVar.g()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!g() || (a4 = id.a(this.f8762d, hbVar.f8762d)) == 0) {
                            int compareTo5 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hbVar.i()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!i() || (a3 = id.a(this.f8763e, hbVar.f8763e)) == 0) {
                                int compareTo6 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hbVar.k()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!k() || (a2 = id.a(this.f8764f, hbVar.f8764f)) == 0) {
                                    int compareTo7 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hbVar.m()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!m() || (a = id.a(this.f8765g, hbVar.f8765g)) == 0) {
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
        return getClass().getName().compareTo(hbVar.getClass().getName());
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        n();
        ioVar.a(f8755h);
        if (b()) {
            ioVar.a(f8756i);
            ioVar.a(this.a);
            ioVar.b();
        }
        if (d()) {
            ioVar.a(f8757j);
            ioVar.a(this.b);
            ioVar.b();
        }
        if (e()) {
            ioVar.a(f8758k);
            ioVar.a(this.f8761c);
            ioVar.b();
        }
        if (g()) {
            ioVar.a(f8759l);
            ioVar.a(this.f8762d);
            ioVar.b();
        }
        if (i()) {
            ioVar.a(f8760m);
            ioVar.a(this.f8763e);
            ioVar.b();
        }
        if (this.f8764f != null && k()) {
            ioVar.a(n);
            ioVar.a(this.f8764f);
            ioVar.b();
        }
        if (m()) {
            ioVar.a(o);
            ioVar.a(this.f8765g);
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public void b(boolean z) {
        this.p.set(1, z);
    }

    public boolean b() {
        return this.p.get(0);
    }

    public int c() {
        return this.b;
    }

    public void c(boolean z) {
        this.p.set(2, z);
    }

    public void d(boolean z) {
        this.p.set(3, z);
    }

    public boolean d() {
        return this.p.get(1);
    }

    public void e(boolean z) {
        this.p.set(4, z);
    }

    public boolean e() {
        return this.p.get(2);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hb)) {
            return a((hb) obj);
        }
        return false;
    }

    public int f() {
        return this.f8762d;
    }

    public void f(boolean z) {
        this.p.set(5, z);
    }

    public boolean g() {
        return this.p.get(3);
    }

    public long h() {
        return this.f8763e;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.p.get(4);
    }

    public String j() {
        return this.f8764f;
    }

    public boolean k() {
        return this.f8764f != null;
    }

    public boolean l() {
        return this.f8765g;
    }

    public boolean m() {
        return this.p.get(5);
    }

    public void n() {
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = false;
        if (b()) {
            sb.append("key:");
            sb.append(this.a);
            z = false;
        } else {
            z = true;
        }
        if (d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.b);
            z = false;
        }
        if (e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f8761c);
            z = false;
        }
        if (g()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f8762d);
            z = false;
        }
        if (i()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f8763e);
            z = false;
        }
        if (k()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            String str = this.f8764f;
            if (str == null) {
                str = "null";
            }
            sb.append(str);
        } else {
            z2 = z;
        }
        if (m()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f8765g);
        }
        sb.append(")");
        return sb.toString();
    }
}
