package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes3.dex */
public class hw implements ic<hw, Object>, Serializable, Cloneable {

    /* renamed from: j  reason: collision with root package name */
    private static final it f8930j = new it("XmPushActionSubscriptionResult");

    /* renamed from: k  reason: collision with root package name */
    private static final il f8931k = new il("", (byte) 11, 1);

    /* renamed from: l  reason: collision with root package name */
    private static final il f8932l = new il("", (byte) 12, 2);

    /* renamed from: m  reason: collision with root package name */
    private static final il f8933m = new il("", (byte) 11, 3);
    private static final il n = new il("", (byte) 11, 4);
    private static final il o = new il("", (byte) 10, 6);
    private static final il p = new il("", (byte) 11, 7);
    private static final il q = new il("", (byte) 11, 8);
    private static final il r = new il("", (byte) 11, 9);
    private static final il s = new il("", (byte) 11, 10);
    public String a;
    public hf b;

    /* renamed from: c  reason: collision with root package name */
    public String f8934c;

    /* renamed from: d  reason: collision with root package name */
    public String f8935d;

    /* renamed from: e  reason: collision with root package name */
    public long f8936e;

    /* renamed from: f  reason: collision with root package name */
    public String f8937f;

    /* renamed from: g  reason: collision with root package name */
    public String f8938g;

    /* renamed from: h  reason: collision with root package name */
    public String f8939h;

    /* renamed from: i  reason: collision with root package name */
    public String f8940i;
    private BitSet t = new BitSet(1);

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
                        this.f8934c = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 4:
                    if (b == 11) {
                        this.f8935d = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 6:
                    if (b == 10) {
                        this.f8936e = ioVar.t();
                        a(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 7:
                    if (b == 11) {
                        this.f8937f = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 8:
                    if (b == 11) {
                        this.f8938g = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 9:
                    if (b == 11) {
                        this.f8939h = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 10:
                    if (b == 11) {
                        this.f8940i = ioVar.v();
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

    public boolean a(hw hwVar) {
        if (hwVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = hwVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(hwVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = hwVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(hwVar.b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hwVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f8934c.equals(hwVar.f8934c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hwVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f8935d.equals(hwVar.f8935d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hwVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f8936e == hwVar.f8936e)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hwVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f8937f.equals(hwVar.f8937f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hwVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f8938g.equals(hwVar.f8938g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hwVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f8939h.equals(hwVar.f8939h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hwVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.f8940i.equals(hwVar.f8940i);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(hw hwVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(hwVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hwVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a9 = id.a(this.a, hwVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hwVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a8 = id.a(this.b, hwVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hwVar.d()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!d() || (a7 = id.a(this.f8934c, hwVar.f8934c)) == 0) {
                        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hwVar.e()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!e() || (a6 = id.a(this.f8935d, hwVar.f8935d)) == 0) {
                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hwVar.f()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!f() || (a5 = id.a(this.f8936e, hwVar.f8936e)) == 0) {
                                int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hwVar.g()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!g() || (a4 = id.a(this.f8937f, hwVar.f8937f)) == 0) {
                                    int compareTo7 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hwVar.i()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!i() || (a3 = id.a(this.f8938g, hwVar.f8938g)) == 0) {
                                        int compareTo8 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hwVar.j()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!j() || (a2 = id.a(this.f8939h, hwVar.f8939h)) == 0) {
                                            int compareTo9 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hwVar.l()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!l() || (a = id.a(this.f8940i, hwVar.f8940i)) == 0) {
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
        return getClass().getName().compareTo(hwVar.getClass().getName());
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        m();
        ioVar.a(f8930j);
        if (this.a != null && a()) {
            ioVar.a(f8931k);
            ioVar.a(this.a);
            ioVar.b();
        }
        if (this.b != null && b()) {
            ioVar.a(f8932l);
            this.b.b(ioVar);
            ioVar.b();
        }
        if (this.f8934c != null) {
            ioVar.a(f8933m);
            ioVar.a(this.f8934c);
            ioVar.b();
        }
        if (this.f8935d != null && e()) {
            ioVar.a(n);
            ioVar.a(this.f8935d);
            ioVar.b();
        }
        if (f()) {
            ioVar.a(o);
            ioVar.a(this.f8936e);
            ioVar.b();
        }
        if (this.f8937f != null && g()) {
            ioVar.a(p);
            ioVar.a(this.f8937f);
            ioVar.b();
        }
        if (this.f8938g != null && i()) {
            ioVar.a(q);
            ioVar.a(this.f8938g);
            ioVar.b();
        }
        if (this.f8939h != null && j()) {
            ioVar.a(r);
            ioVar.a(this.f8939h);
            ioVar.b();
        }
        if (this.f8940i != null && l()) {
            ioVar.a(s);
            ioVar.a(this.f8940i);
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public String c() {
        return this.f8934c;
    }

    public boolean d() {
        return this.f8934c != null;
    }

    public boolean e() {
        return this.f8935d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hw)) {
            return a((hw) obj);
        }
        return false;
    }

    public boolean f() {
        return this.t.get(0);
    }

    public boolean g() {
        return this.f8937f != null;
    }

    public String h() {
        return this.f8938g;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f8938g != null;
    }

    public boolean j() {
        return this.f8939h != null;
    }

    public String k() {
        return this.f8940i;
    }

    public boolean l() {
        return this.f8940i != null;
    }

    public void m() {
        if (this.f8934c != null) {
            return;
        }
        throw new ip("Required field 'id' was not present! Struct: " + toString());
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
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
        String str2 = this.f8934c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f8935d;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f8936e);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f8937f;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f8938g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f8939h;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f8940i;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
