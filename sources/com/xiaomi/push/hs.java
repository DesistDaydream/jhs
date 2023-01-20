package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes3.dex */
public class hs implements ic<hs, Object>, Serializable, Cloneable {
    public String a;
    public hf b;

    /* renamed from: c  reason: collision with root package name */
    public String f8886c;

    /* renamed from: d  reason: collision with root package name */
    public String f8887d;

    /* renamed from: e  reason: collision with root package name */
    public long f8888e;

    /* renamed from: f  reason: collision with root package name */
    public String f8889f;

    /* renamed from: g  reason: collision with root package name */
    public String f8890g;

    /* renamed from: h  reason: collision with root package name */
    public String f8891h;

    /* renamed from: i  reason: collision with root package name */
    public String f8892i;

    /* renamed from: j  reason: collision with root package name */
    public long f8893j;

    /* renamed from: k  reason: collision with root package name */
    public String f8894k;

    /* renamed from: l  reason: collision with root package name */
    public String f8895l;

    /* renamed from: m  reason: collision with root package name */
    public long f8896m;
    public String n;
    public int o;
    public String p;
    public int q;
    public String r;
    public List<String> t;
    private static final it u = new it("XmPushActionRegistrationResult");
    private static final il v = new il("", (byte) 11, 1);
    private static final il w = new il("", (byte) 12, 2);
    private static final il x = new il("", (byte) 11, 3);
    private static final il y = new il("", (byte) 11, 4);
    private static final il z = new il("", (byte) 10, 6);
    private static final il A = new il("", (byte) 11, 7);
    private static final il B = new il("", (byte) 11, 8);
    private static final il C = new il("", (byte) 11, 9);
    private static final il D = new il("", (byte) 11, 10);
    private static final il E = new il("", (byte) 10, 11);
    private static final il F = new il("", (byte) 11, 12);
    private static final il G = new il("", (byte) 11, 13);
    private static final il H = new il("", (byte) 10, 14);
    private static final il I = new il("", (byte) 11, 15);
    private static final il J = new il("", (byte) 8, 16);
    private static final il K = new il("", (byte) 11, 17);
    private static final il L = new il("", (byte) 8, 18);
    private static final il M = new il("", (byte) 11, 19);
    private static final il N = new il("", (byte) 2, 20);
    private static final il O = new il("", com.umeng.analytics.pro.cb.f7124m, 21);
    private BitSet P = new BitSet(6);
    public boolean s = false;

    @Override // com.xiaomi.push.ic
    public void a(io ioVar) {
        ioVar.f();
        while (true) {
            il h2 = ioVar.h();
            byte b = h2.b;
            if (b == 0) {
                ioVar.g();
                if (g()) {
                    z();
                    return;
                }
                throw new ip("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
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
                        this.f8886c = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 4:
                    if (b == 11) {
                        this.f8887d = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 6:
                    if (b == 10) {
                        this.f8888e = ioVar.t();
                        a(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 7:
                    if (b == 11) {
                        this.f8889f = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 8:
                    if (b == 11) {
                        this.f8890g = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 9:
                    if (b == 11) {
                        this.f8891h = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 10:
                    if (b == 11) {
                        this.f8892i = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 11:
                    if (b == 10) {
                        this.f8893j = ioVar.t();
                        b(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 12:
                    if (b == 11) {
                        this.f8894k = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 13:
                    if (b == 11) {
                        this.f8895l = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 14:
                    if (b == 10) {
                        this.f8896m = ioVar.t();
                        c(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 15:
                    if (b == 11) {
                        this.n = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 16:
                    if (b == 8) {
                        this.o = ioVar.s();
                        d(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 17:
                    if (b == 11) {
                        this.p = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 18:
                    if (b == 8) {
                        this.q = ioVar.s();
                        e(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 19:
                    if (b == 11) {
                        this.r = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 20:
                    if (b == 2) {
                        this.s = ioVar.p();
                        f(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 21:
                    if (b == 15) {
                        im l2 = ioVar.l();
                        this.t = new ArrayList(l2.b);
                        for (int i2 = 0; i2 < l2.b; i2++) {
                            this.t.add(ioVar.v());
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

    public void a(boolean z2) {
        this.P.set(0, z2);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(hs hsVar) {
        if (hsVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = hsVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(hsVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = hsVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(hsVar.b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hsVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f8886c.equals(hsVar.f8886c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hsVar.e();
        if (((e2 || e3) && !(e2 && e3 && this.f8887d.equals(hsVar.f8887d))) || this.f8888e != hsVar.f8888e) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hsVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f8889f.equals(hsVar.f8889f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hsVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f8890g.equals(hsVar.f8890g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hsVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f8891h.equals(hsVar.f8891h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hsVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f8892i.equals(hsVar.f8892i))) {
            return false;
        }
        boolean n = n();
        boolean n2 = hsVar.n();
        if ((n || n2) && !(n && n2 && this.f8893j == hsVar.f8893j)) {
            return false;
        }
        boolean o = o();
        boolean o2 = hsVar.o();
        if ((o || o2) && !(o && o2 && this.f8894k.equals(hsVar.f8894k))) {
            return false;
        }
        boolean p = p();
        boolean p2 = hsVar.p();
        if ((p || p2) && !(p && p2 && this.f8895l.equals(hsVar.f8895l))) {
            return false;
        }
        boolean q = q();
        boolean q2 = hsVar.q();
        if ((q || q2) && !(q && q2 && this.f8896m == hsVar.f8896m)) {
            return false;
        }
        boolean r = r();
        boolean r2 = hsVar.r();
        if ((r || r2) && !(r && r2 && this.n.equals(hsVar.n))) {
            return false;
        }
        boolean s = s();
        boolean s2 = hsVar.s();
        if ((s || s2) && !(s && s2 && this.o == hsVar.o)) {
            return false;
        }
        boolean t = t();
        boolean t2 = hsVar.t();
        if ((t || t2) && !(t && t2 && this.p.equals(hsVar.p))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = hsVar.u();
        if ((u2 || u3) && !(u2 && u3 && this.q == hsVar.q)) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = hsVar.v();
        if ((v2 || v3) && !(v2 && v3 && this.r.equals(hsVar.r))) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = hsVar.w();
        if ((w2 || w3) && !(w2 && w3 && this.s == hsVar.s)) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = hsVar.y();
        if (y2 || y3) {
            return y2 && y3 && this.t.equals(hsVar.t);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(hs hsVar) {
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
        if (getClass().equals(hsVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hsVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a20 = id.a(this.a, hsVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hsVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a19 = id.a(this.b, hsVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hsVar.d()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!d() || (a18 = id.a(this.f8886c, hsVar.f8886c)) == 0) {
                        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hsVar.e()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!e() || (a17 = id.a(this.f8887d, hsVar.f8887d)) == 0) {
                            int compareTo5 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hsVar.g()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!g() || (a16 = id.a(this.f8888e, hsVar.f8888e)) == 0) {
                                int compareTo6 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hsVar.h()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!h() || (a15 = id.a(this.f8889f, hsVar.f8889f)) == 0) {
                                    int compareTo7 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hsVar.i()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!i() || (a14 = id.a(this.f8890g, hsVar.f8890g)) == 0) {
                                        int compareTo8 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hsVar.k()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!k() || (a13 = id.a(this.f8891h, hsVar.f8891h)) == 0) {
                                            int compareTo9 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hsVar.m()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!m() || (a12 = id.a(this.f8892i, hsVar.f8892i)) == 0) {
                                                int compareTo10 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hsVar.n()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!n() || (a11 = id.a(this.f8893j, hsVar.f8893j)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hsVar.o()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!o() || (a10 = id.a(this.f8894k, hsVar.f8894k)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hsVar.p()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!p() || (a9 = id.a(this.f8895l, hsVar.f8895l)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hsVar.q()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!q() || (a8 = id.a(this.f8896m, hsVar.f8896m)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hsVar.r()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!r() || (a7 = id.a(this.n, hsVar.n)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hsVar.s()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!s() || (a6 = id.a(this.o, hsVar.o)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hsVar.t()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!t() || (a5 = id.a(this.p, hsVar.p)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(hsVar.u()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!u() || (a4 = id.a(this.q, hsVar.q)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(hsVar.v()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!v() || (a3 = id.a(this.r, hsVar.r)) == 0) {
                                                                                    int compareTo19 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(hsVar.w()));
                                                                                    if (compareTo19 != 0) {
                                                                                        return compareTo19;
                                                                                    }
                                                                                    if (!w() || (a2 = id.a(this.s, hsVar.s)) == 0) {
                                                                                        int compareTo20 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(hsVar.y()));
                                                                                        if (compareTo20 != 0) {
                                                                                            return compareTo20;
                                                                                        }
                                                                                        if (!y() || (a = id.a(this.t, hsVar.t)) == 0) {
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
        return getClass().getName().compareTo(hsVar.getClass().getName());
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        z();
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
        if (this.f8886c != null) {
            ioVar.a(x);
            ioVar.a(this.f8886c);
            ioVar.b();
        }
        if (this.f8887d != null) {
            ioVar.a(y);
            ioVar.a(this.f8887d);
            ioVar.b();
        }
        ioVar.a(z);
        ioVar.a(this.f8888e);
        ioVar.b();
        if (this.f8889f != null && h()) {
            ioVar.a(A);
            ioVar.a(this.f8889f);
            ioVar.b();
        }
        if (this.f8890g != null && i()) {
            ioVar.a(B);
            ioVar.a(this.f8890g);
            ioVar.b();
        }
        if (this.f8891h != null && k()) {
            ioVar.a(C);
            ioVar.a(this.f8891h);
            ioVar.b();
        }
        if (this.f8892i != null && m()) {
            ioVar.a(D);
            ioVar.a(this.f8892i);
            ioVar.b();
        }
        if (n()) {
            ioVar.a(E);
            ioVar.a(this.f8893j);
            ioVar.b();
        }
        if (this.f8894k != null && o()) {
            ioVar.a(F);
            ioVar.a(this.f8894k);
            ioVar.b();
        }
        if (this.f8895l != null && p()) {
            ioVar.a(G);
            ioVar.a(this.f8895l);
            ioVar.b();
        }
        if (q()) {
            ioVar.a(H);
            ioVar.a(this.f8896m);
            ioVar.b();
        }
        if (this.n != null && r()) {
            ioVar.a(I);
            ioVar.a(this.n);
            ioVar.b();
        }
        if (s()) {
            ioVar.a(J);
            ioVar.a(this.o);
            ioVar.b();
        }
        if (this.p != null && t()) {
            ioVar.a(K);
            ioVar.a(this.p);
            ioVar.b();
        }
        if (u()) {
            ioVar.a(L);
            ioVar.a(this.q);
            ioVar.b();
        }
        if (this.r != null && v()) {
            ioVar.a(M);
            ioVar.a(this.r);
            ioVar.b();
        }
        if (w()) {
            ioVar.a(N);
            ioVar.a(this.s);
            ioVar.b();
        }
        if (this.t != null && y()) {
            ioVar.a(O);
            ioVar.a(new im((byte) 11, this.t.size()));
            for (String str : this.t) {
                ioVar.a(str);
            }
            ioVar.e();
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

    public String c() {
        return this.f8886c;
    }

    public void c(boolean z2) {
        this.P.set(2, z2);
    }

    public void d(boolean z2) {
        this.P.set(3, z2);
    }

    public boolean d() {
        return this.f8886c != null;
    }

    public void e(boolean z2) {
        this.P.set(4, z2);
    }

    public boolean e() {
        return this.f8887d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hs)) {
            return a((hs) obj);
        }
        return false;
    }

    public long f() {
        return this.f8888e;
    }

    public void f(boolean z2) {
        this.P.set(5, z2);
    }

    public boolean g() {
        return this.P.get(0);
    }

    public boolean h() {
        return this.f8889f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f8890g != null;
    }

    public String j() {
        return this.f8891h;
    }

    public boolean k() {
        return this.f8891h != null;
    }

    public String l() {
        return this.f8892i;
    }

    public boolean m() {
        return this.f8892i != null;
    }

    public boolean n() {
        return this.P.get(1);
    }

    public boolean o() {
        return this.f8894k != null;
    }

    public boolean p() {
        return this.f8895l != null;
    }

    public boolean q() {
        return this.P.get(2);
    }

    public boolean r() {
        return this.n != null;
    }

    public boolean s() {
        return this.P.get(3);
    }

    public boolean t() {
        return this.p != null;
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
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
        String str2 = this.f8886c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(com.xiaomi.push.service.ag.a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f8887d;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f8888e);
        if (h()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f8889f;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            String str5 = this.f8890g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f8892i;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f8893j);
        }
        if (o()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str7 = this.f8894k;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("clientId:");
            String str8 = this.f8895l;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f8896m);
        }
        if (r()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str9 = this.n;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.o);
        }
        if (t()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            String str10 = this.p;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.q);
        }
        if (v()) {
            sb.append(", ");
            sb.append("region:");
            String str11 = this.r;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (w()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.s);
        }
        if (y()) {
            sb.append(", ");
            sb.append("autoMarkPkgs:");
            List<String> list = this.t;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.P.get(4);
    }

    public boolean v() {
        return this.r != null;
    }

    public boolean w() {
        return this.P.get(5);
    }

    public List<String> x() {
        return this.t;
    }

    public boolean y() {
        return this.t != null;
    }

    public void z() {
        if (this.f8886c == null) {
            throw new ip("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f8887d != null) {
        } else {
            throw new ip("Required field 'appId' was not present! Struct: " + toString());
        }
    }
}
