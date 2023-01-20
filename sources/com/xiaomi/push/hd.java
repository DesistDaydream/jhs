package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class hd implements ic<hd, Object>, Serializable, Cloneable {
    private BitSet B;
    public String a;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public String f8777c;

    /* renamed from: d  reason: collision with root package name */
    public String f8778d;

    /* renamed from: e  reason: collision with root package name */
    public String f8779e;

    /* renamed from: f  reason: collision with root package name */
    public int f8780f;

    /* renamed from: g  reason: collision with root package name */
    public String f8781g;

    /* renamed from: h  reason: collision with root package name */
    public int f8782h;

    /* renamed from: i  reason: collision with root package name */
    public int f8783i;

    /* renamed from: j  reason: collision with root package name */
    public Map<String, String> f8784j;

    /* renamed from: k  reason: collision with root package name */
    public Map<String, String> f8785k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f8786l;

    /* renamed from: m  reason: collision with root package name */
    public Map<String, String> f8787m;
    private static final it n = new it("PushMetaInfo");
    private static final il o = new il("", (byte) 11, 1);
    private static final il p = new il("", (byte) 10, 2);
    private static final il q = new il("", (byte) 11, 3);
    private static final il r = new il("", (byte) 11, 4);
    private static final il s = new il("", (byte) 11, 5);
    private static final il t = new il("", (byte) 8, 6);
    private static final il u = new il("", (byte) 11, 7);
    private static final il v = new il("", (byte) 8, 8);
    private static final il w = new il("", (byte) 8, 9);
    private static final il x = new il("", (byte) 13, 10);
    private static final il y = new il("", (byte) 13, 11);
    private static final il z = new il("", (byte) 2, 12);
    private static final il A = new il("", (byte) 13, 13);

    public hd() {
        this.B = new BitSet(5);
        this.f8786l = false;
    }

    public hd(hd hdVar) {
        BitSet bitSet = new BitSet(5);
        this.B = bitSet;
        bitSet.clear();
        this.B.or(hdVar.B);
        if (hdVar.c()) {
            this.a = hdVar.a;
        }
        this.b = hdVar.b;
        if (hdVar.g()) {
            this.f8777c = hdVar.f8777c;
        }
        if (hdVar.i()) {
            this.f8778d = hdVar.f8778d;
        }
        if (hdVar.k()) {
            this.f8779e = hdVar.f8779e;
        }
        this.f8780f = hdVar.f8780f;
        if (hdVar.n()) {
            this.f8781g = hdVar.f8781g;
        }
        this.f8782h = hdVar.f8782h;
        this.f8783i = hdVar.f8783i;
        if (hdVar.t()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : hdVar.f8784j.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f8784j = hashMap;
        }
        if (hdVar.v()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : hdVar.f8785k.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f8785k = hashMap2;
        }
        this.f8786l = hdVar.f8786l;
        if (hdVar.y()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : hdVar.f8787m.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f8787m = hashMap3;
        }
    }

    public hd a() {
        return new hd(this);
    }

    public hd a(int i2) {
        this.f8780f = i2;
        b(true);
        return this;
    }

    public hd a(String str) {
        this.a = str;
        return this;
    }

    public hd a(Map<String, String> map) {
        this.f8784j = map;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.ic
    public void a(io ioVar) {
        ioVar.f();
        while (true) {
            il h2 = ioVar.h();
            byte b = h2.b;
            if (b == 0) {
                ioVar.g();
                if (e()) {
                    z();
                    return;
                }
                throw new ip("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i2 = 0;
            switch (h2.f9004c) {
                case 1:
                    if (b == 11) {
                        this.a = ioVar.v();
                        break;
                    }
                    ir.a(ioVar, b);
                    break;
                case 2:
                    if (b == 10) {
                        this.b = ioVar.t();
                        a(true);
                        break;
                    }
                    ir.a(ioVar, b);
                    break;
                case 3:
                    if (b == 11) {
                        this.f8777c = ioVar.v();
                        break;
                    }
                    ir.a(ioVar, b);
                    break;
                case 4:
                    if (b == 11) {
                        this.f8778d = ioVar.v();
                        break;
                    }
                    ir.a(ioVar, b);
                    break;
                case 5:
                    if (b == 11) {
                        this.f8779e = ioVar.v();
                        break;
                    }
                    ir.a(ioVar, b);
                    break;
                case 6:
                    if (b == 8) {
                        this.f8780f = ioVar.s();
                        b(true);
                        break;
                    }
                    ir.a(ioVar, b);
                    break;
                case 7:
                    if (b == 11) {
                        this.f8781g = ioVar.v();
                        break;
                    }
                    ir.a(ioVar, b);
                    break;
                case 8:
                    if (b == 8) {
                        this.f8782h = ioVar.s();
                        c(true);
                        break;
                    }
                    ir.a(ioVar, b);
                    break;
                case 9:
                    if (b == 8) {
                        this.f8783i = ioVar.s();
                        d(true);
                        break;
                    }
                    ir.a(ioVar, b);
                    break;
                case 10:
                    if (b == 13) {
                        in j2 = ioVar.j();
                        this.f8784j = new HashMap(j2.f9005c * 2);
                        while (i2 < j2.f9005c) {
                            this.f8784j.put(ioVar.v(), ioVar.v());
                            i2++;
                        }
                        ioVar.k();
                        break;
                    }
                    ir.a(ioVar, b);
                    break;
                case 11:
                    if (b == 13) {
                        in j3 = ioVar.j();
                        this.f8785k = new HashMap(j3.f9005c * 2);
                        while (i2 < j3.f9005c) {
                            this.f8785k.put(ioVar.v(), ioVar.v());
                            i2++;
                        }
                        ioVar.k();
                        break;
                    }
                    ir.a(ioVar, b);
                    break;
                case 12:
                    if (b == 2) {
                        this.f8786l = ioVar.p();
                        e(true);
                        break;
                    }
                    ir.a(ioVar, b);
                    break;
                case 13:
                    if (b == 13) {
                        in j4 = ioVar.j();
                        this.f8787m = new HashMap(j4.f9005c * 2);
                        while (i2 < j4.f9005c) {
                            this.f8787m.put(ioVar.v(), ioVar.v());
                            i2++;
                        }
                        ioVar.k();
                        break;
                    }
                    ir.a(ioVar, b);
                    break;
                default:
                    ir.a(ioVar, b);
                    break;
            }
            ioVar.i();
        }
    }

    public void a(String str, String str2) {
        if (this.f8784j == null) {
            this.f8784j = new HashMap();
        }
        this.f8784j.put(str, str2);
    }

    public void a(boolean z2) {
        this.B.set(0, z2);
    }

    public boolean a(hd hdVar) {
        if (hdVar == null) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hdVar.c();
        if (((c2 || c3) && !(c2 && c3 && this.a.equals(hdVar.a))) || this.b != hdVar.b) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hdVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f8777c.equals(hdVar.f8777c))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hdVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f8778d.equals(hdVar.f8778d))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hdVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f8779e.equals(hdVar.f8779e))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hdVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f8780f == hdVar.f8780f)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hdVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f8781g.equals(hdVar.f8781g))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hdVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f8782h == hdVar.f8782h)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hdVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f8783i == hdVar.f8783i)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = hdVar.t();
        if ((t2 || t3) && !(t2 && t3 && this.f8784j.equals(hdVar.f8784j))) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = hdVar.v();
        if ((v2 || v3) && !(v2 && v3 && this.f8785k.equals(hdVar.f8785k))) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = hdVar.x();
        if ((x2 || x3) && !(x2 && x3 && this.f8786l == hdVar.f8786l)) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = hdVar.y();
        if (y2 || y3) {
            return y2 && y3 && this.f8787m.equals(hdVar.f8787m);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(hd hdVar) {
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
        int a13;
        if (getClass().equals(hdVar.getClass())) {
            int compareTo = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hdVar.c()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!c() || (a13 = id.a(this.a, hdVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hdVar.e()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!e() || (a12 = id.a(this.b, hdVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hdVar.g()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!g() || (a11 = id.a(this.f8777c, hdVar.f8777c)) == 0) {
                        int compareTo4 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hdVar.i()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!i() || (a10 = id.a(this.f8778d, hdVar.f8778d)) == 0) {
                            int compareTo5 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hdVar.k()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!k() || (a9 = id.a(this.f8779e, hdVar.f8779e)) == 0) {
                                int compareTo6 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hdVar.m()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!m() || (a8 = id.a(this.f8780f, hdVar.f8780f)) == 0) {
                                    int compareTo7 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hdVar.n()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!n() || (a7 = id.a(this.f8781g, hdVar.f8781g)) == 0) {
                                        int compareTo8 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hdVar.p()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!p() || (a6 = id.a(this.f8782h, hdVar.f8782h)) == 0) {
                                            int compareTo9 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hdVar.r()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!r() || (a5 = id.a(this.f8783i, hdVar.f8783i)) == 0) {
                                                int compareTo10 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hdVar.t()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!t() || (a4 = id.a(this.f8784j, hdVar.f8784j)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(hdVar.v()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!v() || (a3 = id.a(this.f8785k, hdVar.f8785k)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(hdVar.x()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!x() || (a2 = id.a(this.f8786l, hdVar.f8786l)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(hdVar.y()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!y() || (a = id.a(this.f8787m, hdVar.f8787m)) == 0) {
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
            return a13;
        }
        return getClass().getName().compareTo(hdVar.getClass().getName());
    }

    public hd b(int i2) {
        this.f8782h = i2;
        c(true);
        return this;
    }

    public hd b(String str) {
        this.f8777c = str;
        return this;
    }

    public String b() {
        return this.a;
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        z();
        ioVar.a(n);
        if (this.a != null) {
            ioVar.a(o);
            ioVar.a(this.a);
            ioVar.b();
        }
        ioVar.a(p);
        ioVar.a(this.b);
        ioVar.b();
        if (this.f8777c != null && g()) {
            ioVar.a(q);
            ioVar.a(this.f8777c);
            ioVar.b();
        }
        if (this.f8778d != null && i()) {
            ioVar.a(r);
            ioVar.a(this.f8778d);
            ioVar.b();
        }
        if (this.f8779e != null && k()) {
            ioVar.a(s);
            ioVar.a(this.f8779e);
            ioVar.b();
        }
        if (m()) {
            ioVar.a(t);
            ioVar.a(this.f8780f);
            ioVar.b();
        }
        if (this.f8781g != null && n()) {
            ioVar.a(u);
            ioVar.a(this.f8781g);
            ioVar.b();
        }
        if (p()) {
            ioVar.a(v);
            ioVar.a(this.f8782h);
            ioVar.b();
        }
        if (r()) {
            ioVar.a(w);
            ioVar.a(this.f8783i);
            ioVar.b();
        }
        if (this.f8784j != null && t()) {
            ioVar.a(x);
            ioVar.a(new in((byte) 11, (byte) 11, this.f8784j.size()));
            for (Map.Entry<String, String> entry : this.f8784j.entrySet()) {
                ioVar.a(entry.getKey());
                ioVar.a(entry.getValue());
            }
            ioVar.d();
            ioVar.b();
        }
        if (this.f8785k != null && v()) {
            ioVar.a(y);
            ioVar.a(new in((byte) 11, (byte) 11, this.f8785k.size()));
            for (Map.Entry<String, String> entry2 : this.f8785k.entrySet()) {
                ioVar.a(entry2.getKey());
                ioVar.a(entry2.getValue());
            }
            ioVar.d();
            ioVar.b();
        }
        if (x()) {
            ioVar.a(z);
            ioVar.a(this.f8786l);
            ioVar.b();
        }
        if (this.f8787m != null && y()) {
            ioVar.a(A);
            ioVar.a(new in((byte) 11, (byte) 11, this.f8787m.size()));
            for (Map.Entry<String, String> entry3 : this.f8787m.entrySet()) {
                ioVar.a(entry3.getKey());
                ioVar.a(entry3.getValue());
            }
            ioVar.d();
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public void b(String str, String str2) {
        if (this.f8785k == null) {
            this.f8785k = new HashMap();
        }
        this.f8785k.put(str, str2);
    }

    public void b(boolean z2) {
        this.B.set(1, z2);
    }

    public hd c(int i2) {
        this.f8783i = i2;
        d(true);
        return this;
    }

    public hd c(String str) {
        this.f8778d = str;
        return this;
    }

    public void c(boolean z2) {
        this.B.set(2, z2);
    }

    public boolean c() {
        return this.a != null;
    }

    public long d() {
        return this.b;
    }

    public hd d(String str) {
        this.f8779e = str;
        return this;
    }

    public void d(boolean z2) {
        this.B.set(3, z2);
    }

    public void e(boolean z2) {
        this.B.set(4, z2);
    }

    public boolean e() {
        return this.B.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hd)) {
            return a((hd) obj);
        }
        return false;
    }

    public String f() {
        return this.f8777c;
    }

    public boolean g() {
        return this.f8777c != null;
    }

    public String h() {
        return this.f8778d;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f8778d != null;
    }

    public String j() {
        return this.f8779e;
    }

    public boolean k() {
        return this.f8779e != null;
    }

    public int l() {
        return this.f8780f;
    }

    public boolean m() {
        return this.B.get(1);
    }

    public boolean n() {
        return this.f8781g != null;
    }

    public int o() {
        return this.f8782h;
    }

    public boolean p() {
        return this.B.get(2);
    }

    public int q() {
        return this.f8783i;
    }

    public boolean r() {
        return this.B.get(3);
    }

    public Map<String, String> s() {
        return this.f8784j;
    }

    public boolean t() {
        return this.f8784j != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(com.xiaomi.push.service.ag.a(str));
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.b);
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str2 = this.f8777c;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("title:");
            String str3 = this.f8778d;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("description:");
            String str4 = this.f8779e;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f8780f);
        }
        if (n()) {
            sb.append(", ");
            sb.append("url:");
            String str5 = this.f8781g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f8782h);
        }
        if (r()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f8783i);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f8784j;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (v()) {
            sb.append(", ");
            sb.append("internal:");
            Map<String, String> map2 = this.f8785k;
            if (map2 == null) {
                sb.append("null");
            } else {
                sb.append(map2);
            }
        }
        if (x()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f8786l);
        }
        if (y()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f8787m;
            if (map3 == null) {
                sb.append("null");
            } else {
                sb.append(map3);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public Map<String, String> u() {
        return this.f8785k;
    }

    public boolean v() {
        return this.f8785k != null;
    }

    public boolean w() {
        return this.f8786l;
    }

    public boolean x() {
        return this.B.get(4);
    }

    public boolean y() {
        return this.f8787m != null;
    }

    public void z() {
        if (this.a != null) {
            return;
        }
        throw new ip("Required field 'id' was not present! Struct: " + toString());
    }
}
