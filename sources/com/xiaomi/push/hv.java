package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class hv implements ic<hv, Object>, Serializable, Cloneable {

    /* renamed from: i  reason: collision with root package name */
    private static final it f8919i = new it("XmPushActionSubscription");

    /* renamed from: j  reason: collision with root package name */
    private static final il f8920j = new il("", (byte) 11, 1);

    /* renamed from: k  reason: collision with root package name */
    private static final il f8921k = new il("", (byte) 12, 2);

    /* renamed from: l  reason: collision with root package name */
    private static final il f8922l = new il("", (byte) 11, 3);

    /* renamed from: m  reason: collision with root package name */
    private static final il f8923m = new il("", (byte) 11, 4);
    private static final il n = new il("", (byte) 11, 5);
    private static final il o = new il("", (byte) 11, 6);
    private static final il p = new il("", (byte) 11, 7);
    private static final il q = new il("", com.umeng.analytics.pro.cb.f7124m, 8);
    public String a;
    public hf b;

    /* renamed from: c  reason: collision with root package name */
    public String f8924c;

    /* renamed from: d  reason: collision with root package name */
    public String f8925d;

    /* renamed from: e  reason: collision with root package name */
    public String f8926e;

    /* renamed from: f  reason: collision with root package name */
    public String f8927f;

    /* renamed from: g  reason: collision with root package name */
    public String f8928g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f8929h;

    public hv a(String str) {
        this.f8924c = str;
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
                i();
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
                        this.f8924c = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 4:
                    if (b == 11) {
                        this.f8925d = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 5:
                    if (b == 11) {
                        this.f8926e = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 6:
                    if (b == 11) {
                        this.f8927f = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 7:
                    if (b == 11) {
                        this.f8928g = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 8:
                    if (b == 15) {
                        im l2 = ioVar.l();
                        this.f8929h = new ArrayList(l2.b);
                        for (int i2 = 0; i2 < l2.b; i2++) {
                            this.f8929h.add(ioVar.v());
                        }
                        ioVar.m();
                        continue;
                        ioVar.i();
                    }
                    break;
            }
            ir.a(ioVar, b);
            ioVar.i();
        }
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(hv hvVar) {
        if (hvVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = hvVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(hvVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = hvVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(hvVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hvVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f8924c.equals(hvVar.f8924c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hvVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f8925d.equals(hvVar.f8925d))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hvVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f8926e.equals(hvVar.f8926e))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hvVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f8927f.equals(hvVar.f8927f))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hvVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f8928g.equals(hvVar.f8928g))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hvVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f8929h.equals(hvVar.f8929h);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(hv hvVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (getClass().equals(hvVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hvVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a8 = id.a(this.a, hvVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hvVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a7 = id.a(this.b, hvVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hvVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a6 = id.a(this.f8924c, hvVar.f8924c)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hvVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a5 = id.a(this.f8925d, hvVar.f8925d)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hvVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a4 = id.a(this.f8926e, hvVar.f8926e)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hvVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a3 = id.a(this.f8927f, hvVar.f8927f)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hvVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a2 = id.a(this.f8928g, hvVar.f8928g)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hvVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a = id.a(this.f8929h, hvVar.f8929h)) == 0) {
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
        return getClass().getName().compareTo(hvVar.getClass().getName());
    }

    public hv b(String str) {
        this.f8925d = str;
        return this;
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        i();
        ioVar.a(f8919i);
        if (this.a != null && a()) {
            ioVar.a(f8920j);
            ioVar.a(this.a);
            ioVar.b();
        }
        if (this.b != null && b()) {
            ioVar.a(f8921k);
            this.b.b(ioVar);
            ioVar.b();
        }
        if (this.f8924c != null) {
            ioVar.a(f8922l);
            ioVar.a(this.f8924c);
            ioVar.b();
        }
        if (this.f8925d != null) {
            ioVar.a(f8923m);
            ioVar.a(this.f8925d);
            ioVar.b();
        }
        if (this.f8926e != null) {
            ioVar.a(n);
            ioVar.a(this.f8926e);
            ioVar.b();
        }
        if (this.f8927f != null && f()) {
            ioVar.a(o);
            ioVar.a(this.f8927f);
            ioVar.b();
        }
        if (this.f8928g != null && g()) {
            ioVar.a(p);
            ioVar.a(this.f8928g);
            ioVar.b();
        }
        if (this.f8929h != null && h()) {
            ioVar.a(q);
            ioVar.a(new im((byte) 11, this.f8929h.size()));
            for (String str : this.f8929h) {
                ioVar.a(str);
            }
            ioVar.e();
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public hv c(String str) {
        this.f8926e = str;
        return this;
    }

    public boolean c() {
        return this.f8924c != null;
    }

    public hv d(String str) {
        this.f8927f = str;
        return this;
    }

    public boolean d() {
        return this.f8925d != null;
    }

    public hv e(String str) {
        this.f8928g = str;
        return this;
    }

    public boolean e() {
        return this.f8926e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hv)) {
            return a((hv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f8927f != null;
    }

    public boolean g() {
        return this.f8928g != null;
    }

    public boolean h() {
        return this.f8929h != null;
    }

    public int hashCode() {
        return 0;
    }

    public void i() {
        if (this.f8924c == null) {
            throw new ip("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f8925d == null) {
            throw new ip("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f8926e != null) {
        } else {
            throw new ip("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
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
        String str2 = this.f8924c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f8925d;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f8926e;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f8927f;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f8928g;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f8929h;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
