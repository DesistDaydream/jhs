package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class hu implements ic<hu, Object>, Serializable, Cloneable {

    /* renamed from: m  reason: collision with root package name */
    private static final it f8908m = new it("XmPushActionSendMessage");
    private static final il n = new il("", (byte) 11, 1);
    private static final il o = new il("", (byte) 12, 2);
    private static final il p = new il("", (byte) 11, 3);
    private static final il q = new il("", (byte) 11, 4);
    private static final il r = new il("", (byte) 11, 5);
    private static final il s = new il("", (byte) 11, 6);
    private static final il t = new il("", (byte) 11, 7);
    private static final il u = new il("", (byte) 12, 8);
    private static final il v = new il("", (byte) 2, 9);
    private static final il w = new il("", (byte) 13, 10);
    private static final il x = new il("", (byte) 11, 11);
    private static final il y = new il("", (byte) 11, 12);
    public String a;
    public hf b;

    /* renamed from: c  reason: collision with root package name */
    public String f8909c;

    /* renamed from: d  reason: collision with root package name */
    public String f8910d;

    /* renamed from: e  reason: collision with root package name */
    public String f8911e;

    /* renamed from: f  reason: collision with root package name */
    public String f8912f;

    /* renamed from: g  reason: collision with root package name */
    public String f8913g;

    /* renamed from: h  reason: collision with root package name */
    public hc f8914h;

    /* renamed from: j  reason: collision with root package name */
    public Map<String, String> f8916j;

    /* renamed from: k  reason: collision with root package name */
    public String f8917k;

    /* renamed from: l  reason: collision with root package name */
    public String f8918l;
    private BitSet z = new BitSet(1);

    /* renamed from: i  reason: collision with root package name */
    public boolean f8915i = true;

    @Override // com.xiaomi.push.ic
    public void a(io ioVar) {
        ioVar.f();
        while (true) {
            il h2 = ioVar.h();
            byte b = h2.b;
            if (b == 0) {
                ioVar.g();
                t();
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
                        this.f8909c = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 4:
                    if (b == 11) {
                        this.f8910d = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 5:
                    if (b == 11) {
                        this.f8911e = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 6:
                    if (b == 11) {
                        this.f8912f = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 7:
                    if (b == 11) {
                        this.f8913g = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 8:
                    if (b == 12) {
                        hc hcVar = new hc();
                        this.f8914h = hcVar;
                        hcVar.a(ioVar);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 9:
                    if (b == 2) {
                        this.f8915i = ioVar.p();
                        a(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 10:
                    if (b == 13) {
                        in j2 = ioVar.j();
                        this.f8916j = new HashMap(j2.f9005c * 2);
                        for (int i2 = 0; i2 < j2.f9005c; i2++) {
                            this.f8916j.put(ioVar.v(), ioVar.v());
                        }
                        ioVar.k();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 11:
                    if (b == 11) {
                        this.f8917k = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 12:
                    if (b == 11) {
                        this.f8918l = ioVar.v();
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

    public boolean a(hu huVar) {
        if (huVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = huVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(huVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = huVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(huVar.b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = huVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f8909c.equals(huVar.f8909c))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = huVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f8910d.equals(huVar.f8910d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = huVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f8911e.equals(huVar.f8911e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = huVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f8912f.equals(huVar.f8912f))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = huVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f8913g.equals(huVar.f8913g))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = huVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f8914h.a(huVar.f8914h))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = huVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f8915i == huVar.f8915i)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = huVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f8916j.equals(huVar.f8916j))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = huVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f8917k.equals(huVar.f8917k))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = huVar.s();
        if (s2 || s3) {
            return s2 && s3 && this.f8918l.equals(huVar.f8918l);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(hu huVar) {
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
        if (getClass().equals(huVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(huVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a12 = id.a(this.a, huVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(huVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a11 = id.a(this.b, huVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(huVar.d()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!d() || (a10 = id.a(this.f8909c, huVar.f8909c)) == 0) {
                        int compareTo4 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(huVar.f()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!f() || (a9 = id.a(this.f8910d, huVar.f8910d)) == 0) {
                            int compareTo5 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(huVar.g()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!g() || (a8 = id.a(this.f8911e, huVar.f8911e)) == 0) {
                                int compareTo6 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(huVar.i()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!i() || (a7 = id.a(this.f8912f, huVar.f8912f)) == 0) {
                                    int compareTo7 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(huVar.k()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!k() || (a6 = id.a(this.f8913g, huVar.f8913g)) == 0) {
                                        int compareTo8 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(huVar.m()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!m() || (a5 = id.a(this.f8914h, huVar.f8914h)) == 0) {
                                            int compareTo9 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(huVar.n()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!n() || (a4 = id.a(this.f8915i, huVar.f8915i)) == 0) {
                                                int compareTo10 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(huVar.o()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!o() || (a3 = id.a(this.f8916j, huVar.f8916j)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(huVar.q()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!q() || (a2 = id.a(this.f8917k, huVar.f8917k)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(huVar.s()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!s() || (a = id.a(this.f8918l, huVar.f8918l)) == 0) {
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
        return getClass().getName().compareTo(huVar.getClass().getName());
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        t();
        ioVar.a(f8908m);
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
        if (this.f8909c != null) {
            ioVar.a(p);
            ioVar.a(this.f8909c);
            ioVar.b();
        }
        if (this.f8910d != null) {
            ioVar.a(q);
            ioVar.a(this.f8910d);
            ioVar.b();
        }
        if (this.f8911e != null && g()) {
            ioVar.a(r);
            ioVar.a(this.f8911e);
            ioVar.b();
        }
        if (this.f8912f != null && i()) {
            ioVar.a(s);
            ioVar.a(this.f8912f);
            ioVar.b();
        }
        if (this.f8913g != null && k()) {
            ioVar.a(t);
            ioVar.a(this.f8913g);
            ioVar.b();
        }
        if (this.f8914h != null && m()) {
            ioVar.a(u);
            this.f8914h.b(ioVar);
            ioVar.b();
        }
        if (n()) {
            ioVar.a(v);
            ioVar.a(this.f8915i);
            ioVar.b();
        }
        if (this.f8916j != null && o()) {
            ioVar.a(w);
            ioVar.a(new in((byte) 11, (byte) 11, this.f8916j.size()));
            for (Map.Entry<String, String> entry : this.f8916j.entrySet()) {
                ioVar.a(entry.getKey());
                ioVar.a(entry.getValue());
            }
            ioVar.d();
            ioVar.b();
        }
        if (this.f8917k != null && q()) {
            ioVar.a(x);
            ioVar.a(this.f8917k);
            ioVar.b();
        }
        if (this.f8918l != null && s()) {
            ioVar.a(y);
            ioVar.a(this.f8918l);
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public String c() {
        return this.f8909c;
    }

    public boolean d() {
        return this.f8909c != null;
    }

    public String e() {
        return this.f8910d;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hu)) {
            return a((hu) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f8910d != null;
    }

    public boolean g() {
        return this.f8911e != null;
    }

    public String h() {
        return this.f8912f;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f8912f != null;
    }

    public String j() {
        return this.f8913g;
    }

    public boolean k() {
        return this.f8913g != null;
    }

    public hc l() {
        return this.f8914h;
    }

    public boolean m() {
        return this.f8914h != null;
    }

    public boolean n() {
        return this.z.get(0);
    }

    public boolean o() {
        return this.f8916j != null;
    }

    public String p() {
        return this.f8917k;
    }

    public boolean q() {
        return this.f8917k != null;
    }

    public String r() {
        return this.f8918l;
    }

    public boolean s() {
        return this.f8918l != null;
    }

    public void t() {
        if (this.f8909c == null) {
            throw new ip("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f8910d != null) {
        } else {
            throw new ip("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
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
        String str2 = this.f8909c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f8910d;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f8911e;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f8912f;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str6 = this.f8913g;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("message:");
            hc hcVar = this.f8914h;
            if (hcVar == null) {
                sb.append("null");
            } else {
                sb.append(hcVar);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f8915i);
        }
        if (o()) {
            sb.append(", ");
            sb.append("params:");
            Map<String, String> map = this.f8916j;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f8917k;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str8 = this.f8918l;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
