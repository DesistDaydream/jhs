package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes3.dex */
public class hl implements ic<hl, Object>, Serializable, Cloneable {

    /* renamed from: k  reason: collision with root package name */
    private static final it f8829k = new it("XmPushActionCommand");

    /* renamed from: l  reason: collision with root package name */
    private static final il f8830l = new il("", (byte) 12, 2);

    /* renamed from: m  reason: collision with root package name */
    private static final il f8831m = new il("", (byte) 11, 3);
    private static final il n = new il("", (byte) 11, 4);
    private static final il o = new il("", (byte) 11, 5);
    private static final il p = new il("", com.umeng.analytics.pro.cb.f7124m, 6);
    private static final il q = new il("", (byte) 11, 7);
    private static final il r = new il("", (byte) 11, 9);
    private static final il s = new il("", (byte) 2, 10);
    private static final il t = new il("", (byte) 2, 11);
    private static final il u = new il("", (byte) 10, 12);
    public hf a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f8832c;

    /* renamed from: d  reason: collision with root package name */
    public String f8833d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f8834e;

    /* renamed from: f  reason: collision with root package name */
    public String f8835f;

    /* renamed from: g  reason: collision with root package name */
    public String f8836g;

    /* renamed from: j  reason: collision with root package name */
    public long f8839j;
    private BitSet v = new BitSet(3);

    /* renamed from: h  reason: collision with root package name */
    public boolean f8837h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f8838i = true;

    public hl a(String str) {
        this.b = str;
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
                l();
                return;
            }
            switch (h2.f9004c) {
                case 2:
                    if (b == 12) {
                        hf hfVar = new hf();
                        this.a = hfVar;
                        hfVar.a(ioVar);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 3:
                    if (b == 11) {
                        this.b = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 4:
                    if (b == 11) {
                        this.f8832c = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 5:
                    if (b == 11) {
                        this.f8833d = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 6:
                    if (b == 15) {
                        im l2 = ioVar.l();
                        this.f8834e = new ArrayList(l2.b);
                        for (int i2 = 0; i2 < l2.b; i2++) {
                            this.f8834e.add(ioVar.v());
                        }
                        ioVar.m();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 7:
                    if (b == 11) {
                        this.f8835f = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 9:
                    if (b == 11) {
                        this.f8836g = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 10:
                    if (b == 2) {
                        this.f8837h = ioVar.p();
                        a(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 11:
                    if (b == 2) {
                        this.f8838i = ioVar.p();
                        b(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 12:
                    if (b == 10) {
                        this.f8839j = ioVar.t();
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
        this.v.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(hl hlVar) {
        if (hlVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = hlVar.a();
        if ((a || a2) && !(a && a2 && this.a.a(hlVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = hlVar.b();
        if ((b || b2) && !(b && b2 && this.b.equals(hlVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hlVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f8832c.equals(hlVar.f8832c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hlVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f8833d.equals(hlVar.f8833d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hlVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f8834e.equals(hlVar.f8834e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hlVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f8835f.equals(hlVar.f8835f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hlVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f8836g.equals(hlVar.f8836g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hlVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f8837h == hlVar.f8837h)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hlVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f8838i == hlVar.f8838i)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hlVar.k();
        if (k2 || k3) {
            return k2 && k3 && this.f8839j == hlVar.f8839j;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(hl hlVar) {
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
        if (getClass().equals(hlVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hlVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a10 = id.a(this.a, hlVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hlVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a9 = id.a(this.b, hlVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hlVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a8 = id.a(this.f8832c, hlVar.f8832c)) == 0) {
                        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hlVar.e()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!e() || (a7 = id.a(this.f8833d, hlVar.f8833d)) == 0) {
                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hlVar.f()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!f() || (a6 = id.a(this.f8834e, hlVar.f8834e)) == 0) {
                                int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hlVar.g()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!g() || (a5 = id.a(this.f8835f, hlVar.f8835f)) == 0) {
                                    int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hlVar.h()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!h() || (a4 = id.a(this.f8836g, hlVar.f8836g)) == 0) {
                                        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hlVar.i()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!i() || (a3 = id.a(this.f8837h, hlVar.f8837h)) == 0) {
                                            int compareTo9 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hlVar.j()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!j() || (a2 = id.a(this.f8838i, hlVar.f8838i)) == 0) {
                                                int compareTo10 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hlVar.k()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!k() || (a = id.a(this.f8839j, hlVar.f8839j)) == 0) {
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
        return getClass().getName().compareTo(hlVar.getClass().getName());
    }

    public hl b(String str) {
        this.f8832c = str;
        return this;
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        l();
        ioVar.a(f8829k);
        if (this.a != null && a()) {
            ioVar.a(f8830l);
            this.a.b(ioVar);
            ioVar.b();
        }
        if (this.b != null) {
            ioVar.a(f8831m);
            ioVar.a(this.b);
            ioVar.b();
        }
        if (this.f8832c != null) {
            ioVar.a(n);
            ioVar.a(this.f8832c);
            ioVar.b();
        }
        if (this.f8833d != null) {
            ioVar.a(o);
            ioVar.a(this.f8833d);
            ioVar.b();
        }
        if (this.f8834e != null && f()) {
            ioVar.a(p);
            ioVar.a(new im((byte) 11, this.f8834e.size()));
            for (String str : this.f8834e) {
                ioVar.a(str);
            }
            ioVar.e();
            ioVar.b();
        }
        if (this.f8835f != null && g()) {
            ioVar.a(q);
            ioVar.a(this.f8835f);
            ioVar.b();
        }
        if (this.f8836g != null && h()) {
            ioVar.a(r);
            ioVar.a(this.f8836g);
            ioVar.b();
        }
        if (i()) {
            ioVar.a(s);
            ioVar.a(this.f8837h);
            ioVar.b();
        }
        if (j()) {
            ioVar.a(t);
            ioVar.a(this.f8838i);
            ioVar.b();
        }
        if (k()) {
            ioVar.a(u);
            ioVar.a(this.f8839j);
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public void b(boolean z) {
        this.v.set(1, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public hl c(String str) {
        this.f8833d = str;
        return this;
    }

    public void c(boolean z) {
        this.v.set(2, z);
    }

    public boolean c() {
        return this.f8832c != null;
    }

    public String d() {
        return this.f8833d;
    }

    public void d(String str) {
        if (this.f8834e == null) {
            this.f8834e = new ArrayList();
        }
        this.f8834e.add(str);
    }

    public hl e(String str) {
        this.f8835f = str;
        return this;
    }

    public boolean e() {
        return this.f8833d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hl)) {
            return a((hl) obj);
        }
        return false;
    }

    public hl f(String str) {
        this.f8836g = str;
        return this;
    }

    public boolean f() {
        return this.f8834e != null;
    }

    public boolean g() {
        return this.f8835f != null;
    }

    public boolean h() {
        return this.f8836g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.v.get(0);
    }

    public boolean j() {
        return this.v.get(1);
    }

    public boolean k() {
        return this.v.get(2);
    }

    public void l() {
        if (this.b == null) {
            throw new ip("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f8832c == null) {
            throw new ip("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f8833d != null) {
        } else {
            throw new ip("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (a()) {
            sb.append("target:");
            hf hfVar = this.a;
            if (hfVar == null) {
                sb.append("null");
            } else {
                sb.append(hfVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.b;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f8832c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f8833d;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (f()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f8834e;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f8835f;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f8836g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f8837h);
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f8838i);
        }
        if (k()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f8839j);
        }
        sb.append(")");
        return sb.toString();
    }
}
