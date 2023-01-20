package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes3.dex */
public class hc implements ic<hc, Object>, Serializable, Cloneable {
    public hf a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f8766c;

    /* renamed from: d  reason: collision with root package name */
    public String f8767d;

    /* renamed from: e  reason: collision with root package name */
    public long f8768e;

    /* renamed from: f  reason: collision with root package name */
    public long f8769f;

    /* renamed from: g  reason: collision with root package name */
    public String f8770g;

    /* renamed from: h  reason: collision with root package name */
    public String f8771h;

    /* renamed from: i  reason: collision with root package name */
    public String f8772i;

    /* renamed from: j  reason: collision with root package name */
    public String f8773j;

    /* renamed from: k  reason: collision with root package name */
    public String f8774k;

    /* renamed from: l  reason: collision with root package name */
    public hd f8775l;

    /* renamed from: m  reason: collision with root package name */
    public String f8776m;
    public String o;
    public long p;
    public String q;
    public String r;
    private static final it s = new it("PushMessage");
    private static final il t = new il("", (byte) 12, 1);
    private static final il u = new il("", (byte) 11, 2);
    private static final il v = new il("", (byte) 11, 3);
    private static final il w = new il("", (byte) 11, 4);
    private static final il x = new il("", (byte) 10, 5);
    private static final il y = new il("", (byte) 10, 6);
    private static final il z = new il("", (byte) 11, 7);
    private static final il A = new il("", (byte) 11, 8);
    private static final il B = new il("", (byte) 11, 9);
    private static final il C = new il("", (byte) 11, 10);
    private static final il D = new il("", (byte) 11, 11);
    private static final il E = new il("", (byte) 12, 12);
    private static final il F = new il("", (byte) 11, 13);
    private static final il G = new il("", (byte) 2, 14);
    private static final il H = new il("", (byte) 11, 15);
    private static final il I = new il("", (byte) 10, 16);
    private static final il J = new il("", (byte) 11, 20);
    private static final il K = new il("", (byte) 11, 21);
    private BitSet L = new BitSet(4);
    public boolean n = false;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.ic
    public void a(io ioVar) {
        ioVar.f();
        while (true) {
            il h2 = ioVar.h();
            byte b = h2.b;
            if (b == 0) {
                ioVar.g();
                w();
                return;
            }
            short s2 = h2.f9004c;
            if (s2 == 20) {
                if (b == 11) {
                    this.q = ioVar.v();
                    ioVar.i();
                }
                ir.a(ioVar, b);
                ioVar.i();
            } else if (s2 != 21) {
                switch (s2) {
                    case 1:
                        if (b == 12) {
                            hf hfVar = new hf();
                            this.a = hfVar;
                            hfVar.a(ioVar);
                            break;
                        }
                        ir.a(ioVar, b);
                        break;
                    case 2:
                        if (b == 11) {
                            this.b = ioVar.v();
                            break;
                        }
                        ir.a(ioVar, b);
                        break;
                    case 3:
                        if (b == 11) {
                            this.f8766c = ioVar.v();
                            break;
                        }
                        ir.a(ioVar, b);
                        break;
                    case 4:
                        if (b == 11) {
                            this.f8767d = ioVar.v();
                            break;
                        }
                        ir.a(ioVar, b);
                        break;
                    case 5:
                        if (b == 10) {
                            this.f8768e = ioVar.t();
                            a(true);
                            break;
                        }
                        ir.a(ioVar, b);
                        break;
                    case 6:
                        if (b == 10) {
                            this.f8769f = ioVar.t();
                            b(true);
                            break;
                        }
                        ir.a(ioVar, b);
                        break;
                    case 7:
                        if (b == 11) {
                            this.f8770g = ioVar.v();
                            break;
                        }
                        ir.a(ioVar, b);
                        break;
                    case 8:
                        if (b == 11) {
                            this.f8771h = ioVar.v();
                            break;
                        }
                        ir.a(ioVar, b);
                        break;
                    case 9:
                        if (b == 11) {
                            this.f8772i = ioVar.v();
                            break;
                        }
                        ir.a(ioVar, b);
                        break;
                    case 10:
                        if (b == 11) {
                            this.f8773j = ioVar.v();
                            break;
                        }
                        ir.a(ioVar, b);
                        break;
                    case 11:
                        if (b == 11) {
                            this.f8774k = ioVar.v();
                            break;
                        }
                        ir.a(ioVar, b);
                        break;
                    case 12:
                        if (b == 12) {
                            hd hdVar = new hd();
                            this.f8775l = hdVar;
                            hdVar.a(ioVar);
                            break;
                        }
                        ir.a(ioVar, b);
                        break;
                    case 13:
                        if (b == 11) {
                            this.f8776m = ioVar.v();
                            break;
                        }
                        ir.a(ioVar, b);
                        break;
                    case 14:
                        if (b == 2) {
                            this.n = ioVar.p();
                            c(true);
                            break;
                        }
                        ir.a(ioVar, b);
                        break;
                    case 15:
                        if (b == 11) {
                            this.o = ioVar.v();
                            break;
                        }
                        ir.a(ioVar, b);
                        break;
                    case 16:
                        if (b == 10) {
                            this.p = ioVar.t();
                            d(true);
                            break;
                        }
                        ir.a(ioVar, b);
                        break;
                    default:
                        ir.a(ioVar, b);
                        break;
                }
                ioVar.i();
            } else {
                if (b == 11) {
                    this.r = ioVar.v();
                    ioVar.i();
                }
                ir.a(ioVar, b);
                ioVar.i();
            }
        }
    }

    public void a(boolean z2) {
        this.L.set(0, z2);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(hc hcVar) {
        if (hcVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = hcVar.a();
        if ((a || a2) && !(a && a2 && this.a.a(hcVar.a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hcVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.b.equals(hcVar.b))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hcVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f8766c.equals(hcVar.f8766c))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hcVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f8767d.equals(hcVar.f8767d))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hcVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f8768e == hcVar.f8768e)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hcVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f8769f == hcVar.f8769f)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hcVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f8770g.equals(hcVar.f8770g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hcVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f8771h.equals(hcVar.f8771h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hcVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f8772i.equals(hcVar.f8772i))) {
            return false;
        }
        boolean n = n();
        boolean n2 = hcVar.n();
        if ((n || n2) && !(n && n2 && this.f8773j.equals(hcVar.f8773j))) {
            return false;
        }
        boolean o = o();
        boolean o2 = hcVar.o();
        if ((o || o2) && !(o && o2 && this.f8774k.equals(hcVar.f8774k))) {
            return false;
        }
        boolean p = p();
        boolean p2 = hcVar.p();
        if ((p || p2) && !(p && p2 && this.f8775l.a(hcVar.f8775l))) {
            return false;
        }
        boolean q = q();
        boolean q2 = hcVar.q();
        if ((q || q2) && !(q && q2 && this.f8776m.equals(hcVar.f8776m))) {
            return false;
        }
        boolean r = r();
        boolean r2 = hcVar.r();
        if ((r || r2) && !(r && r2 && this.n == hcVar.n)) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = hcVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.o.equals(hcVar.o))) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = hcVar.t();
        if ((t2 || t3) && !(t2 && t3 && this.p == hcVar.p)) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = hcVar.u();
        if ((u2 || u3) && !(u2 && u3 && this.q.equals(hcVar.q))) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = hcVar.v();
        if (v2 || v3) {
            return v2 && v3 && this.r.equals(hcVar.r);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(hc hcVar) {
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
        if (getClass().equals(hcVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hcVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a18 = id.a(this.a, hcVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hcVar.c()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!c() || (a17 = id.a(this.b, hcVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hcVar.e()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!e() || (a16 = id.a(this.f8766c, hcVar.f8766c)) == 0) {
                        int compareTo4 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hcVar.g()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!g() || (a15 = id.a(this.f8767d, hcVar.f8767d)) == 0) {
                            int compareTo5 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hcVar.i()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!i() || (a14 = id.a(this.f8768e, hcVar.f8768e)) == 0) {
                                int compareTo6 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hcVar.j()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!j() || (a13 = id.a(this.f8769f, hcVar.f8769f)) == 0) {
                                    int compareTo7 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hcVar.k()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!k() || (a12 = id.a(this.f8770g, hcVar.f8770g)) == 0) {
                                        int compareTo8 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hcVar.l()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!l() || (a11 = id.a(this.f8771h, hcVar.f8771h)) == 0) {
                                            int compareTo9 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hcVar.m()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!m() || (a10 = id.a(this.f8772i, hcVar.f8772i)) == 0) {
                                                int compareTo10 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hcVar.n()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!n() || (a9 = id.a(this.f8773j, hcVar.f8773j)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hcVar.o()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!o() || (a8 = id.a(this.f8774k, hcVar.f8774k)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hcVar.p()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!p() || (a7 = id.a(this.f8775l, hcVar.f8775l)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hcVar.q()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!q() || (a6 = id.a(this.f8776m, hcVar.f8776m)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hcVar.r()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!r() || (a5 = id.a(this.n, hcVar.n)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hcVar.s()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!s() || (a4 = id.a(this.o, hcVar.o)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hcVar.t()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!t() || (a3 = id.a(this.p, hcVar.p)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(hcVar.u()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!u() || (a2 = id.a(this.q, hcVar.q)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(hcVar.v()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!v() || (a = id.a(this.r, hcVar.r)) == 0) {
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
        return getClass().getName().compareTo(hcVar.getClass().getName());
    }

    public String b() {
        return this.b;
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        w();
        ioVar.a(s);
        if (this.a != null && a()) {
            ioVar.a(t);
            this.a.b(ioVar);
            ioVar.b();
        }
        if (this.b != null) {
            ioVar.a(u);
            ioVar.a(this.b);
            ioVar.b();
        }
        if (this.f8766c != null) {
            ioVar.a(v);
            ioVar.a(this.f8766c);
            ioVar.b();
        }
        if (this.f8767d != null) {
            ioVar.a(w);
            ioVar.a(this.f8767d);
            ioVar.b();
        }
        if (i()) {
            ioVar.a(x);
            ioVar.a(this.f8768e);
            ioVar.b();
        }
        if (j()) {
            ioVar.a(y);
            ioVar.a(this.f8769f);
            ioVar.b();
        }
        if (this.f8770g != null && k()) {
            ioVar.a(z);
            ioVar.a(this.f8770g);
            ioVar.b();
        }
        if (this.f8771h != null && l()) {
            ioVar.a(A);
            ioVar.a(this.f8771h);
            ioVar.b();
        }
        if (this.f8772i != null && m()) {
            ioVar.a(B);
            ioVar.a(this.f8772i);
            ioVar.b();
        }
        if (this.f8773j != null && n()) {
            ioVar.a(C);
            ioVar.a(this.f8773j);
            ioVar.b();
        }
        if (this.f8774k != null && o()) {
            ioVar.a(D);
            ioVar.a(this.f8774k);
            ioVar.b();
        }
        if (this.f8775l != null && p()) {
            ioVar.a(E);
            this.f8775l.b(ioVar);
            ioVar.b();
        }
        if (this.f8776m != null && q()) {
            ioVar.a(F);
            ioVar.a(this.f8776m);
            ioVar.b();
        }
        if (r()) {
            ioVar.a(G);
            ioVar.a(this.n);
            ioVar.b();
        }
        if (this.o != null && s()) {
            ioVar.a(H);
            ioVar.a(this.o);
            ioVar.b();
        }
        if (t()) {
            ioVar.a(I);
            ioVar.a(this.p);
            ioVar.b();
        }
        if (this.q != null && u()) {
            ioVar.a(J);
            ioVar.a(this.q);
            ioVar.b();
        }
        if (this.r != null && v()) {
            ioVar.a(K);
            ioVar.a(this.r);
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public void b(boolean z2) {
        this.L.set(1, z2);
    }

    public void c(boolean z2) {
        this.L.set(2, z2);
    }

    public boolean c() {
        return this.b != null;
    }

    public String d() {
        return this.f8766c;
    }

    public void d(boolean z2) {
        this.L.set(3, z2);
    }

    public boolean e() {
        return this.f8766c != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hc)) {
            return a((hc) obj);
        }
        return false;
    }

    public String f() {
        return this.f8767d;
    }

    public boolean g() {
        return this.f8767d != null;
    }

    public long h() {
        return this.f8768e;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.L.get(0);
    }

    public boolean j() {
        return this.L.get(1);
    }

    public boolean k() {
        return this.f8770g != null;
    }

    public boolean l() {
        return this.f8771h != null;
    }

    public boolean m() {
        return this.f8772i != null;
    }

    public boolean n() {
        return this.f8773j != null;
    }

    public boolean o() {
        return this.f8774k != null;
    }

    public boolean p() {
        return this.f8775l != null;
    }

    public boolean q() {
        return this.f8776m != null;
    }

    public boolean r() {
        return this.L.get(2);
    }

    public boolean s() {
        return this.o != null;
    }

    public boolean t() {
        return this.L.get(3);
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (a()) {
            sb.append("to:");
            hf hfVar = this.a;
            if (hfVar == null) {
                sb.append("null");
            } else {
                sb.append(hfVar);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
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
        String str2 = this.f8766c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("payload:");
        String str3 = this.f8767d;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (i()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f8768e);
        }
        if (j()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f8769f);
        }
        if (k()) {
            sb.append(", ");
            sb.append("collapseKey:");
            String str4 = this.f8770g;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f8771h;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("regId:");
            String str6 = this.f8772i;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f8773j;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("topic:");
            String str8 = this.f8774k;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("metaInfo:");
            hd hdVar = this.f8775l;
            if (hdVar == null) {
                sb.append("null");
            } else {
                sb.append(hdVar);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f8776m;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.n);
        }
        if (s()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.o;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (t()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.p);
        }
        if (u()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.q;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (v()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.r;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.q != null;
    }

    public boolean v() {
        return this.r != null;
    }

    public void w() {
        if (this.b == null) {
            throw new ip("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f8766c == null) {
            throw new ip("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f8767d != null) {
        } else {
            throw new ip("Required field 'payload' was not present! Struct: " + toString());
        }
    }
}
