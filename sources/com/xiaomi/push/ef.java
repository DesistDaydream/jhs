package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes3.dex */
public class ef implements ic<ef, Object>, Serializable, Cloneable {

    /* renamed from: k  reason: collision with root package name */
    private static final it f8502k = new it("StatsEvent");

    /* renamed from: l  reason: collision with root package name */
    private static final il f8503l = new il("", (byte) 3, 1);

    /* renamed from: m  reason: collision with root package name */
    private static final il f8504m = new il("", (byte) 8, 2);
    private static final il n = new il("", (byte) 8, 3);
    private static final il o = new il("", (byte) 11, 4);
    private static final il p = new il("", (byte) 11, 5);
    private static final il q = new il("", (byte) 8, 6);
    private static final il r = new il("", (byte) 11, 7);
    private static final il s = new il("", (byte) 11, 8);
    private static final il t = new il("", (byte) 8, 9);
    private static final il u = new il("", (byte) 8, 10);
    public byte a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f8505c;

    /* renamed from: d  reason: collision with root package name */
    public String f8506d;

    /* renamed from: e  reason: collision with root package name */
    public String f8507e;

    /* renamed from: f  reason: collision with root package name */
    public int f8508f;

    /* renamed from: g  reason: collision with root package name */
    public String f8509g;

    /* renamed from: h  reason: collision with root package name */
    public String f8510h;

    /* renamed from: i  reason: collision with root package name */
    public int f8511i;

    /* renamed from: j  reason: collision with root package name */
    public int f8512j;
    private BitSet v = new BitSet(6);

    public ef a(byte b) {
        this.a = b;
        a(true);
        return this;
    }

    public ef a(int i2) {
        this.b = i2;
        b(true);
        return this;
    }

    public ef a(String str) {
        this.f8506d = str;
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
                if (!a()) {
                    throw new ip("Required field 'chid' was not found in serialized data! Struct: " + toString());
                } else if (!b()) {
                    throw new ip("Required field 'type' was not found in serialized data! Struct: " + toString());
                } else if (c()) {
                    k();
                    return;
                } else {
                    throw new ip("Required field 'value' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (h2.f9004c) {
                case 1:
                    if (b == 3) {
                        this.a = ioVar.q();
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
                    if (b == 8) {
                        this.f8505c = ioVar.s();
                        c(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 4:
                    if (b == 11) {
                        this.f8506d = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 5:
                    if (b == 11) {
                        this.f8507e = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 6:
                    if (b == 8) {
                        this.f8508f = ioVar.s();
                        d(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 7:
                    if (b == 11) {
                        this.f8509g = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 8:
                    if (b == 11) {
                        this.f8510h = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 9:
                    if (b == 8) {
                        this.f8511i = ioVar.s();
                        e(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 10:
                    if (b == 8) {
                        this.f8512j = ioVar.s();
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
        this.v.set(0, z);
    }

    public boolean a() {
        return this.v.get(0);
    }

    public boolean a(ef efVar) {
        if (efVar != null && this.a == efVar.a && this.b == efVar.b && this.f8505c == efVar.f8505c) {
            boolean d2 = d();
            boolean d3 = efVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f8506d.equals(efVar.f8506d))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = efVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f8507e.equals(efVar.f8507e))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = efVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f8508f == efVar.f8508f)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = efVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f8509g.equals(efVar.f8509g))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = efVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f8510h.equals(efVar.f8510h))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = efVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f8511i == efVar.f8511i)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = efVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f8512j == efVar.f8512j;
            }
            return true;
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ef efVar) {
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
        if (getClass().equals(efVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(efVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a10 = id.a(this.a, efVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(efVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a9 = id.a(this.b, efVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(efVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a8 = id.a(this.f8505c, efVar.f8505c)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(efVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a7 = id.a(this.f8506d, efVar.f8506d)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(efVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a6 = id.a(this.f8507e, efVar.f8507e)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(efVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a5 = id.a(this.f8508f, efVar.f8508f)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(efVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a4 = id.a(this.f8509g, efVar.f8509g)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(efVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a3 = id.a(this.f8510h, efVar.f8510h)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(efVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a2 = id.a(this.f8511i, efVar.f8511i)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(efVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a = id.a(this.f8512j, efVar.f8512j)) == 0) {
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
        return getClass().getName().compareTo(efVar.getClass().getName());
    }

    public ef b(int i2) {
        this.f8505c = i2;
        c(true);
        return this;
    }

    public ef b(String str) {
        this.f8507e = str;
        return this;
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        k();
        ioVar.a(f8502k);
        ioVar.a(f8503l);
        ioVar.a(this.a);
        ioVar.b();
        ioVar.a(f8504m);
        ioVar.a(this.b);
        ioVar.b();
        ioVar.a(n);
        ioVar.a(this.f8505c);
        ioVar.b();
        if (this.f8506d != null) {
            ioVar.a(o);
            ioVar.a(this.f8506d);
            ioVar.b();
        }
        if (this.f8507e != null && e()) {
            ioVar.a(p);
            ioVar.a(this.f8507e);
            ioVar.b();
        }
        if (f()) {
            ioVar.a(q);
            ioVar.a(this.f8508f);
            ioVar.b();
        }
        if (this.f8509g != null && g()) {
            ioVar.a(r);
            ioVar.a(this.f8509g);
            ioVar.b();
        }
        if (this.f8510h != null && h()) {
            ioVar.a(s);
            ioVar.a(this.f8510h);
            ioVar.b();
        }
        if (i()) {
            ioVar.a(t);
            ioVar.a(this.f8511i);
            ioVar.b();
        }
        if (j()) {
            ioVar.a(u);
            ioVar.a(this.f8512j);
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public void b(boolean z) {
        this.v.set(1, z);
    }

    public boolean b() {
        return this.v.get(1);
    }

    public ef c(int i2) {
        this.f8508f = i2;
        d(true);
        return this;
    }

    public ef c(String str) {
        this.f8509g = str;
        return this;
    }

    public void c(boolean z) {
        this.v.set(2, z);
    }

    public boolean c() {
        return this.v.get(2);
    }

    public ef d(int i2) {
        this.f8511i = i2;
        e(true);
        return this;
    }

    public ef d(String str) {
        this.f8510h = str;
        return this;
    }

    public void d(boolean z) {
        this.v.set(3, z);
    }

    public boolean d() {
        return this.f8506d != null;
    }

    public void e(boolean z) {
        this.v.set(4, z);
    }

    public boolean e() {
        return this.f8507e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ef)) {
            return a((ef) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.v.set(5, z);
    }

    public boolean f() {
        return this.v.get(3);
    }

    public boolean g() {
        return this.f8509g != null;
    }

    public boolean h() {
        return this.f8510h != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.v.get(4);
    }

    public boolean j() {
        return this.v.get(5);
    }

    public void k() {
        if (this.f8506d != null) {
            return;
        }
        throw new ip("Required field 'connpt' was not present! Struct: " + toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f8505c);
        sb.append(", ");
        sb.append("connpt:");
        String str = this.f8506d;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            String str2 = this.f8507e;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f8508f);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            String str3 = this.f8509g;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            String str4 = this.f8510h;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f8511i);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f8512j);
        }
        sb.append(")");
        return sb.toString();
    }
}
