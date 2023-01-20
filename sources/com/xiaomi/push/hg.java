package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class hg implements ic<hg, Object>, Serializable, Cloneable {
    public String a;
    public hf b;

    /* renamed from: c  reason: collision with root package name */
    public String f8802c;

    /* renamed from: d  reason: collision with root package name */
    public String f8803d;

    /* renamed from: e  reason: collision with root package name */
    public long f8804e;

    /* renamed from: f  reason: collision with root package name */
    public String f8805f;

    /* renamed from: g  reason: collision with root package name */
    public String f8806g;

    /* renamed from: h  reason: collision with root package name */
    public hu f8807h;

    /* renamed from: i  reason: collision with root package name */
    public String f8808i;

    /* renamed from: j  reason: collision with root package name */
    public String f8809j;

    /* renamed from: l  reason: collision with root package name */
    public String f8811l;

    /* renamed from: m  reason: collision with root package name */
    public String f8812m;
    public String n;
    public short o;
    public short p;
    public String q;
    public String r;
    public int s;
    public Map<String, String> t;
    private static final it u = new it("XmPushActionAckMessage");
    private static final il v = new il("", (byte) 11, 1);
    private static final il w = new il("", (byte) 12, 2);
    private static final il x = new il("", (byte) 11, 3);
    private static final il y = new il("", (byte) 11, 4);
    private static final il z = new il("", (byte) 10, 5);
    private static final il A = new il("", (byte) 11, 6);
    private static final il B = new il("", (byte) 11, 7);
    private static final il C = new il("", (byte) 12, 8);
    private static final il D = new il("", (byte) 11, 9);
    private static final il E = new il("", (byte) 11, 10);
    private static final il F = new il("", (byte) 2, 11);
    private static final il G = new il("", (byte) 11, 12);
    private static final il H = new il("", (byte) 11, 13);
    private static final il I = new il("", (byte) 11, 14);
    private static final il J = new il("", (byte) 6, 15);
    private static final il K = new il("", (byte) 6, 16);
    private static final il L = new il("", (byte) 11, 20);
    private static final il M = new il("", (byte) 11, 21);
    private static final il N = new il("", (byte) 8, 22);
    private static final il O = new il("", (byte) 13, 23);
    private BitSet P = new BitSet(5);

    /* renamed from: k  reason: collision with root package name */
    public boolean f8810k = false;

    public hg a(long j2) {
        this.f8804e = j2;
        a(true);
        return this;
    }

    public hg a(String str) {
        this.f8802c = str;
        return this;
    }

    public hg a(short s) {
        this.o = s;
        c(true);
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
                if (e()) {
                    u();
                    return;
                }
                throw new ip("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
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
                        this.f8802c = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 4:
                    if (b == 11) {
                        this.f8803d = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 5:
                    if (b == 10) {
                        this.f8804e = ioVar.t();
                        a(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 6:
                    if (b == 11) {
                        this.f8805f = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 7:
                    if (b == 11) {
                        this.f8806g = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 8:
                    if (b == 12) {
                        hu huVar = new hu();
                        this.f8807h = huVar;
                        huVar.a(ioVar);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 9:
                    if (b == 11) {
                        this.f8808i = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 10:
                    if (b == 11) {
                        this.f8809j = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 11:
                    if (b == 2) {
                        this.f8810k = ioVar.p();
                        b(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 12:
                    if (b == 11) {
                        this.f8811l = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 13:
                    if (b == 11) {
                        this.f8812m = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 14:
                    if (b == 11) {
                        this.n = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 15:
                    if (b == 6) {
                        this.o = ioVar.r();
                        c(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 16:
                    if (b == 6) {
                        this.p = ioVar.r();
                        d(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 20:
                    if (b == 11) {
                        this.q = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 21:
                    if (b == 11) {
                        this.r = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 22:
                    if (b == 8) {
                        this.s = ioVar.s();
                        e(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 23:
                    if (b == 13) {
                        in j2 = ioVar.j();
                        this.t = new HashMap(j2.f9005c * 2);
                        for (int i2 = 0; i2 < j2.f9005c; i2++) {
                            this.t.put(ioVar.v(), ioVar.v());
                        }
                        ioVar.k();
                        continue;
                        ioVar.i();
                    }
                    break;
            }
            ir.a(ioVar, b);
            ioVar.i();
        }
    }

    public void a(boolean z2) {
        this.P.set(0, z2);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(hg hgVar) {
        if (hgVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = hgVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(hgVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = hgVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(hgVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hgVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f8802c.equals(hgVar.f8802c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hgVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f8803d.equals(hgVar.f8803d))) || this.f8804e != hgVar.f8804e) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hgVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f8805f.equals(hgVar.f8805f))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hgVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f8806g.equals(hgVar.f8806g))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hgVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f8807h.a(hgVar.f8807h))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hgVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f8808i.equals(hgVar.f8808i))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hgVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f8809j.equals(hgVar.f8809j))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hgVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f8810k == hgVar.f8810k)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hgVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f8811l.equals(hgVar.f8811l))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hgVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f8812m.equals(hgVar.f8812m))) {
            return false;
        }
        boolean n = n();
        boolean n2 = hgVar.n();
        if ((n || n2) && !(n && n2 && this.n.equals(hgVar.n))) {
            return false;
        }
        boolean o = o();
        boolean o2 = hgVar.o();
        if ((o || o2) && !(o && o2 && this.o == hgVar.o)) {
            return false;
        }
        boolean p = p();
        boolean p2 = hgVar.p();
        if ((p || p2) && !(p && p2 && this.p == hgVar.p)) {
            return false;
        }
        boolean q = q();
        boolean q2 = hgVar.q();
        if ((q || q2) && !(q && q2 && this.q.equals(hgVar.q))) {
            return false;
        }
        boolean r = r();
        boolean r2 = hgVar.r();
        if ((r || r2) && !(r && r2 && this.r.equals(hgVar.r))) {
            return false;
        }
        boolean s = s();
        boolean s2 = hgVar.s();
        if ((s || s2) && !(s && s2 && this.s == hgVar.s)) {
            return false;
        }
        boolean t = t();
        boolean t2 = hgVar.t();
        if (t || t2) {
            return t && t2 && this.t.equals(hgVar.t);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(hg hgVar) {
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
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        int a19;
        int a20;
        if (getClass().equals(hgVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hgVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a20 = id.a(this.a, hgVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hgVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a19 = id.a(this.b, hgVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hgVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a18 = id.a(this.f8802c, hgVar.f8802c)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hgVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a17 = id.a(this.f8803d, hgVar.f8803d)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hgVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a16 = id.a(this.f8804e, hgVar.f8804e)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hgVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a15 = id.a(this.f8805f, hgVar.f8805f)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hgVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a14 = id.a(this.f8806g, hgVar.f8806g)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hgVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a13 = id.a(this.f8807h, hgVar.f8807h)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hgVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a12 = id.a(this.f8808i, hgVar.f8808i)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hgVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a11 = id.a(this.f8809j, hgVar.f8809j)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hgVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a10 = id.a(this.f8810k, hgVar.f8810k)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hgVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a9 = id.a(this.f8811l, hgVar.f8811l)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hgVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a8 = id.a(this.f8812m, hgVar.f8812m)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hgVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a7 = id.a(this.n, hgVar.n)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hgVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a6 = id.a(this.o, hgVar.o)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hgVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a5 = id.a(this.p, hgVar.p)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hgVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a4 = id.a(this.q, hgVar.q)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hgVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a3 = id.a(this.r, hgVar.r)) == 0) {
                                                                                    int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hgVar.s()));
                                                                                    if (compareTo19 != 0) {
                                                                                        return compareTo19;
                                                                                    }
                                                                                    if (!s() || (a2 = id.a(this.s, hgVar.s)) == 0) {
                                                                                        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hgVar.t()));
                                                                                        if (compareTo20 != 0) {
                                                                                            return compareTo20;
                                                                                        }
                                                                                        if (!t() || (a = id.a(this.t, hgVar.t)) == 0) {
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
                                    return a14;
                                }
                                return a15;
                            }
                            return a16;
                        }
                        return a17;
                    }
                    return a18;
                }
                return a19;
            }
            return a20;
        }
        return getClass().getName().compareTo(hgVar.getClass().getName());
    }

    public hg b(String str) {
        this.f8803d = str;
        return this;
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        u();
        ioVar.a(u);
        if (this.a != null && a()) {
            ioVar.a(v);
            ioVar.a(this.a);
            ioVar.b();
        }
        if (this.b != null && b()) {
            ioVar.a(w);
            this.b.b(ioVar);
            ioVar.b();
        }
        if (this.f8802c != null) {
            ioVar.a(x);
            ioVar.a(this.f8802c);
            ioVar.b();
        }
        if (this.f8803d != null) {
            ioVar.a(y);
            ioVar.a(this.f8803d);
            ioVar.b();
        }
        ioVar.a(z);
        ioVar.a(this.f8804e);
        ioVar.b();
        if (this.f8805f != null && f()) {
            ioVar.a(A);
            ioVar.a(this.f8805f);
            ioVar.b();
        }
        if (this.f8806g != null && g()) {
            ioVar.a(B);
            ioVar.a(this.f8806g);
            ioVar.b();
        }
        if (this.f8807h != null && h()) {
            ioVar.a(C);
            this.f8807h.b(ioVar);
            ioVar.b();
        }
        if (this.f8808i != null && i()) {
            ioVar.a(D);
            ioVar.a(this.f8808i);
            ioVar.b();
        }
        if (this.f8809j != null && j()) {
            ioVar.a(E);
            ioVar.a(this.f8809j);
            ioVar.b();
        }
        if (k()) {
            ioVar.a(F);
            ioVar.a(this.f8810k);
            ioVar.b();
        }
        if (this.f8811l != null && l()) {
            ioVar.a(G);
            ioVar.a(this.f8811l);
            ioVar.b();
        }
        if (this.f8812m != null && m()) {
            ioVar.a(H);
            ioVar.a(this.f8812m);
            ioVar.b();
        }
        if (this.n != null && n()) {
            ioVar.a(I);
            ioVar.a(this.n);
            ioVar.b();
        }
        if (o()) {
            ioVar.a(J);
            ioVar.a(this.o);
            ioVar.b();
        }
        if (p()) {
            ioVar.a(K);
            ioVar.a(this.p);
            ioVar.b();
        }
        if (this.q != null && q()) {
            ioVar.a(L);
            ioVar.a(this.q);
            ioVar.b();
        }
        if (this.r != null && r()) {
            ioVar.a(M);
            ioVar.a(this.r);
            ioVar.b();
        }
        if (s()) {
            ioVar.a(N);
            ioVar.a(this.s);
            ioVar.b();
        }
        if (this.t != null && t()) {
            ioVar.a(O);
            ioVar.a(new in((byte) 11, (byte) 11, this.t.size()));
            for (Map.Entry<String, String> entry : this.t.entrySet()) {
                ioVar.a(entry.getKey());
                ioVar.a(entry.getValue());
            }
            ioVar.d();
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public void b(boolean z2) {
        this.P.set(1, z2);
    }

    public boolean b() {
        return this.b != null;
    }

    public hg c(String str) {
        this.f8805f = str;
        return this;
    }

    public void c(boolean z2) {
        this.P.set(2, z2);
    }

    public boolean c() {
        return this.f8802c != null;
    }

    public hg d(String str) {
        this.f8806g = str;
        return this;
    }

    public void d(boolean z2) {
        this.P.set(3, z2);
    }

    public boolean d() {
        return this.f8803d != null;
    }

    public void e(boolean z2) {
        this.P.set(4, z2);
    }

    public boolean e() {
        return this.P.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hg)) {
            return a((hg) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f8805f != null;
    }

    public boolean g() {
        return this.f8806g != null;
    }

    public boolean h() {
        return this.f8807h != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f8808i != null;
    }

    public boolean j() {
        return this.f8809j != null;
    }

    public boolean k() {
        return this.P.get(1);
    }

    public boolean l() {
        return this.f8811l != null;
    }

    public boolean m() {
        return this.f8812m != null;
    }

    public boolean n() {
        return this.n != null;
    }

    public boolean o() {
        return this.P.get(2);
    }

    public boolean p() {
        return this.P.get(3);
    }

    public boolean q() {
        return this.q != null;
    }

    public boolean r() {
        return this.r != null;
    }

    public boolean s() {
        return this.P.get(4);
    }

    public boolean t() {
        return this.t != null;
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z3 = false;
        if (a()) {
            sb.append("debug:");
            String str = this.a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (b()) {
            if (!z2) {
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
            z3 = z2;
        }
        if (!z3) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f8802c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f8803d;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f8804e);
        if (f()) {
            sb.append(", ");
            sb.append("topic:");
            String str4 = this.f8805f;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str5 = this.f8806g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            hu huVar = this.f8807h;
            if (huVar == null) {
                sb.append("null");
            } else {
                sb.append(huVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f8808i;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f8809j;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f8810k);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f8811l;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            String str9 = this.f8812m;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.n;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.o);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.p);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.q;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.r;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.s);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.t;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void u() {
        if (this.f8802c == null) {
            throw new ip("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f8803d != null) {
        } else {
            throw new ip("Required field 'appId' was not present! Struct: " + toString());
        }
    }
}
