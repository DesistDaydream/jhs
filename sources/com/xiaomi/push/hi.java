package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class hi implements ic<hi, Object>, Serializable, Cloneable {

    /* renamed from: k  reason: collision with root package name */
    private static final it f8813k = new it("XmPushActionAckNotification");

    /* renamed from: l  reason: collision with root package name */
    private static final il f8814l = new il("", (byte) 11, 1);

    /* renamed from: m  reason: collision with root package name */
    private static final il f8815m = new il("", (byte) 12, 2);
    private static final il n = new il("", (byte) 11, 3);
    private static final il o = new il("", (byte) 11, 4);
    private static final il p = new il("", (byte) 11, 5);
    private static final il q = new il("", (byte) 10, 7);
    private static final il r = new il("", (byte) 11, 8);
    private static final il s = new il("", (byte) 13, 9);
    private static final il t = new il("", (byte) 11, 10);
    private static final il u = new il("", (byte) 11, 11);
    public String a;
    public hf b;

    /* renamed from: c  reason: collision with root package name */
    public String f8816c;

    /* renamed from: d  reason: collision with root package name */
    public String f8817d;

    /* renamed from: e  reason: collision with root package name */
    public String f8818e;

    /* renamed from: g  reason: collision with root package name */
    public String f8820g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f8821h;

    /* renamed from: i  reason: collision with root package name */
    public String f8822i;

    /* renamed from: j  reason: collision with root package name */
    public String f8823j;
    private BitSet v = new BitSet(1);

    /* renamed from: f  reason: collision with root package name */
    public long f8819f = 0;

    public hi a(long j2) {
        this.f8819f = j2;
        a(true);
        return this;
    }

    public hi a(hf hfVar) {
        this.b = hfVar;
        return this;
    }

    public hi a(String str) {
        this.f8816c = str;
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
                n();
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
                        this.f8816c = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 4:
                    if (b == 11) {
                        this.f8817d = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 5:
                    if (b == 11) {
                        this.f8818e = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 7:
                    if (b == 10) {
                        this.f8819f = ioVar.t();
                        a(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 8:
                    if (b == 11) {
                        this.f8820g = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 9:
                    if (b == 13) {
                        in j2 = ioVar.j();
                        this.f8821h = new HashMap(j2.f9005c * 2);
                        for (int i2 = 0; i2 < j2.f9005c; i2++) {
                            this.f8821h.put(ioVar.v(), ioVar.v());
                        }
                        ioVar.k();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 10:
                    if (b == 11) {
                        this.f8822i = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 11:
                    if (b == 11) {
                        this.f8823j = ioVar.v();
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
        return this.a != null;
    }

    public boolean a(hi hiVar) {
        if (hiVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = hiVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(hiVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = hiVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(hiVar.b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hiVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f8816c.equals(hiVar.f8816c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hiVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f8817d.equals(hiVar.f8817d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hiVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f8818e.equals(hiVar.f8818e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hiVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f8819f == hiVar.f8819f)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hiVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f8820g.equals(hiVar.f8820g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hiVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f8821h.equals(hiVar.f8821h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hiVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f8822i.equals(hiVar.f8822i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hiVar.m();
        if (m2 || m3) {
            return m2 && m3 && this.f8823j.equals(hiVar.f8823j);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(hi hiVar) {
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
        if (getClass().equals(hiVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hiVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a10 = id.a(this.a, hiVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hiVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a9 = id.a(this.b, hiVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hiVar.d()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!d() || (a8 = id.a(this.f8816c, hiVar.f8816c)) == 0) {
                        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hiVar.e()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!e() || (a7 = id.a(this.f8817d, hiVar.f8817d)) == 0) {
                            int compareTo5 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hiVar.g()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!g() || (a6 = id.a(this.f8818e, hiVar.f8818e)) == 0) {
                                int compareTo6 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hiVar.h()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!h() || (a5 = id.a(this.f8819f, hiVar.f8819f)) == 0) {
                                    int compareTo7 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hiVar.i()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!i() || (a4 = id.a(this.f8820g, hiVar.f8820g)) == 0) {
                                        int compareTo8 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hiVar.k()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!k() || (a3 = id.a(this.f8821h, hiVar.f8821h)) == 0) {
                                            int compareTo9 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hiVar.l()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!l() || (a2 = id.a(this.f8822i, hiVar.f8822i)) == 0) {
                                                int compareTo10 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hiVar.m()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!m() || (a = id.a(this.f8823j, hiVar.f8823j)) == 0) {
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
        return getClass().getName().compareTo(hiVar.getClass().getName());
    }

    public hi b(String str) {
        this.f8817d = str;
        return this;
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        n();
        ioVar.a(f8813k);
        if (this.a != null && a()) {
            ioVar.a(f8814l);
            ioVar.a(this.a);
            ioVar.b();
        }
        if (this.b != null && b()) {
            ioVar.a(f8815m);
            this.b.b(ioVar);
            ioVar.b();
        }
        if (this.f8816c != null) {
            ioVar.a(n);
            ioVar.a(this.f8816c);
            ioVar.b();
        }
        if (this.f8817d != null && e()) {
            ioVar.a(o);
            ioVar.a(this.f8817d);
            ioVar.b();
        }
        if (this.f8818e != null && g()) {
            ioVar.a(p);
            ioVar.a(this.f8818e);
            ioVar.b();
        }
        if (h()) {
            ioVar.a(q);
            ioVar.a(this.f8819f);
            ioVar.b();
        }
        if (this.f8820g != null && i()) {
            ioVar.a(r);
            ioVar.a(this.f8820g);
            ioVar.b();
        }
        if (this.f8821h != null && k()) {
            ioVar.a(s);
            ioVar.a(new in((byte) 11, (byte) 11, this.f8821h.size()));
            for (Map.Entry<String, String> entry : this.f8821h.entrySet()) {
                ioVar.a(entry.getKey());
                ioVar.a(entry.getValue());
            }
            ioVar.d();
            ioVar.b();
        }
        if (this.f8822i != null && l()) {
            ioVar.a(t);
            ioVar.a(this.f8822i);
            ioVar.b();
        }
        if (this.f8823j != null && m()) {
            ioVar.a(u);
            ioVar.a(this.f8823j);
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public hi c(String str) {
        this.f8818e = str;
        return this;
    }

    public String c() {
        return this.f8816c;
    }

    public hi d(String str) {
        this.f8820g = str;
        return this;
    }

    public boolean d() {
        return this.f8816c != null;
    }

    public hi e(String str) {
        this.f8822i = str;
        return this;
    }

    public boolean e() {
        return this.f8817d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hi)) {
            return a((hi) obj);
        }
        return false;
    }

    public String f() {
        return this.f8818e;
    }

    public boolean g() {
        return this.f8818e != null;
    }

    public boolean h() {
        return this.v.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f8820g != null;
    }

    public Map<String, String> j() {
        return this.f8821h;
    }

    public boolean k() {
        return this.f8821h != null;
    }

    public boolean l() {
        return this.f8822i != null;
    }

    public boolean m() {
        return this.f8823j != null;
    }

    public void n() {
        if (this.f8816c != null) {
            return;
        }
        throw new ip("Required field 'id' was not present! Struct: " + toString());
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
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
        String str2 = this.f8816c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f8817d;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f8818e;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f8819f);
        }
        if (i()) {
            sb.append(", ");
            sb.append("reason:");
            String str5 = this.f8820g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f8821h;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f8822i;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f8823j;
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
