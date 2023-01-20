package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes3.dex */
public class ia implements ic<ia, Object>, Serializable, Cloneable {

    /* renamed from: j  reason: collision with root package name */
    private static final it f8974j = new it("XmPushActionUnSubscriptionResult");

    /* renamed from: k  reason: collision with root package name */
    private static final il f8975k = new il("", (byte) 11, 1);

    /* renamed from: l  reason: collision with root package name */
    private static final il f8976l = new il("", (byte) 12, 2);

    /* renamed from: m  reason: collision with root package name */
    private static final il f8977m = new il("", (byte) 11, 3);
    private static final il n = new il("", (byte) 11, 4);
    private static final il o = new il("", (byte) 10, 6);
    private static final il p = new il("", (byte) 11, 7);
    private static final il q = new il("", (byte) 11, 8);
    private static final il r = new il("", (byte) 11, 9);
    private static final il s = new il("", (byte) 11, 10);
    public String a;
    public hf b;

    /* renamed from: c  reason: collision with root package name */
    public String f8978c;

    /* renamed from: d  reason: collision with root package name */
    public String f8979d;

    /* renamed from: e  reason: collision with root package name */
    public long f8980e;

    /* renamed from: f  reason: collision with root package name */
    public String f8981f;

    /* renamed from: g  reason: collision with root package name */
    public String f8982g;

    /* renamed from: h  reason: collision with root package name */
    public String f8983h;

    /* renamed from: i  reason: collision with root package name */
    public String f8984i;
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
                        this.f8978c = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 4:
                    if (b == 11) {
                        this.f8979d = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 6:
                    if (b == 10) {
                        this.f8980e = ioVar.t();
                        a(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 7:
                    if (b == 11) {
                        this.f8981f = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 8:
                    if (b == 11) {
                        this.f8982g = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 9:
                    if (b == 11) {
                        this.f8983h = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 10:
                    if (b == 11) {
                        this.f8984i = ioVar.v();
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

    public boolean a(ia iaVar) {
        if (iaVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = iaVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(iaVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = iaVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(iaVar.b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iaVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f8978c.equals(iaVar.f8978c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iaVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f8979d.equals(iaVar.f8979d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iaVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f8980e == iaVar.f8980e)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iaVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f8981f.equals(iaVar.f8981f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = iaVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f8982g.equals(iaVar.f8982g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = iaVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f8983h.equals(iaVar.f8983h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = iaVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.f8984i.equals(iaVar.f8984i);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ia iaVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(iaVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(iaVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a9 = id.a(this.a, iaVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iaVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a8 = id.a(this.b, iaVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iaVar.d()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!d() || (a7 = id.a(this.f8978c, iaVar.f8978c)) == 0) {
                        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iaVar.e()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!e() || (a6 = id.a(this.f8979d, iaVar.f8979d)) == 0) {
                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iaVar.f()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!f() || (a5 = id.a(this.f8980e, iaVar.f8980e)) == 0) {
                                int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iaVar.g()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!g() || (a4 = id.a(this.f8981f, iaVar.f8981f)) == 0) {
                                    int compareTo7 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iaVar.i()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!i() || (a3 = id.a(this.f8982g, iaVar.f8982g)) == 0) {
                                        int compareTo8 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iaVar.j()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!j() || (a2 = id.a(this.f8983h, iaVar.f8983h)) == 0) {
                                            int compareTo9 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(iaVar.l()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!l() || (a = id.a(this.f8984i, iaVar.f8984i)) == 0) {
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
        return getClass().getName().compareTo(iaVar.getClass().getName());
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        m();
        ioVar.a(f8974j);
        if (this.a != null && a()) {
            ioVar.a(f8975k);
            ioVar.a(this.a);
            ioVar.b();
        }
        if (this.b != null && b()) {
            ioVar.a(f8976l);
            this.b.b(ioVar);
            ioVar.b();
        }
        if (this.f8978c != null) {
            ioVar.a(f8977m);
            ioVar.a(this.f8978c);
            ioVar.b();
        }
        if (this.f8979d != null && e()) {
            ioVar.a(n);
            ioVar.a(this.f8979d);
            ioVar.b();
        }
        if (f()) {
            ioVar.a(o);
            ioVar.a(this.f8980e);
            ioVar.b();
        }
        if (this.f8981f != null && g()) {
            ioVar.a(p);
            ioVar.a(this.f8981f);
            ioVar.b();
        }
        if (this.f8982g != null && i()) {
            ioVar.a(q);
            ioVar.a(this.f8982g);
            ioVar.b();
        }
        if (this.f8983h != null && j()) {
            ioVar.a(r);
            ioVar.a(this.f8983h);
            ioVar.b();
        }
        if (this.f8984i != null && l()) {
            ioVar.a(s);
            ioVar.a(this.f8984i);
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public String c() {
        return this.f8978c;
    }

    public boolean d() {
        return this.f8978c != null;
    }

    public boolean e() {
        return this.f8979d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ia)) {
            return a((ia) obj);
        }
        return false;
    }

    public boolean f() {
        return this.t.get(0);
    }

    public boolean g() {
        return this.f8981f != null;
    }

    public String h() {
        return this.f8982g;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f8982g != null;
    }

    public boolean j() {
        return this.f8983h != null;
    }

    public String k() {
        return this.f8984i;
    }

    public boolean l() {
        return this.f8984i != null;
    }

    public void m() {
        if (this.f8978c != null) {
            return;
        }
        throw new ip("Required field 'id' was not present! Struct: " + toString());
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
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
        String str2 = this.f8978c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f8979d;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f8980e);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f8981f;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f8982g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f8983h;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f8984i;
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
