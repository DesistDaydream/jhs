package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class hr implements ic<hr, Object>, Serializable, Cloneable {
    private static final it D = new it("XmPushActionRegistration");
    private static final il E = new il("", (byte) 11, 1);
    private static final il F = new il("", (byte) 12, 2);
    private static final il G = new il("", (byte) 11, 3);
    private static final il H = new il("", (byte) 11, 4);
    private static final il I = new il("", (byte) 11, 5);
    private static final il J = new il("", (byte) 11, 6);
    private static final il K = new il("", (byte) 11, 7);
    private static final il L = new il("", (byte) 11, 8);
    private static final il M = new il("", (byte) 11, 9);
    private static final il N = new il("", (byte) 11, 10);
    private static final il O = new il("", (byte) 11, 11);
    private static final il P = new il("", (byte) 11, 12);
    private static final il Q = new il("", (byte) 8, 13);
    private static final il R = new il("", (byte) 8, 14);
    private static final il S = new il("", (byte) 11, 15);
    private static final il T = new il("", (byte) 11, 16);
    private static final il U = new il("", (byte) 11, 17);
    private static final il V = new il("", (byte) 11, 18);
    private static final il W = new il("", (byte) 8, 19);
    private static final il X = new il("", (byte) 8, 20);
    private static final il Y = new il("", (byte) 2, 21);
    private static final il Z = new il("", (byte) 10, 22);
    private static final il aa = new il("", (byte) 10, 23);
    private static final il ab = new il("", (byte) 11, 24);
    private static final il ac = new il("", (byte) 11, 25);
    private static final il ad = new il("", (byte) 2, 26);
    private static final il ae = new il("", (byte) 13, 100);
    private static final il af = new il("", (byte) 2, 101);
    private static final il ag = new il("", (byte) 11, 102);
    public Map<String, String> A;
    public String C;
    public String a;
    public hf b;

    /* renamed from: c  reason: collision with root package name */
    public String f8875c;

    /* renamed from: d  reason: collision with root package name */
    public String f8876d;

    /* renamed from: e  reason: collision with root package name */
    public String f8877e;

    /* renamed from: f  reason: collision with root package name */
    public String f8878f;

    /* renamed from: g  reason: collision with root package name */
    public String f8879g;

    /* renamed from: h  reason: collision with root package name */
    public String f8880h;

    /* renamed from: i  reason: collision with root package name */
    public String f8881i;

    /* renamed from: j  reason: collision with root package name */
    public String f8882j;

    /* renamed from: k  reason: collision with root package name */
    public String f8883k;

    /* renamed from: l  reason: collision with root package name */
    public String f8884l;

    /* renamed from: m  reason: collision with root package name */
    public int f8885m;
    public int n;
    public String o;
    public String p;
    public String q;
    public String r;
    public int s;
    public he t;
    public long v;
    public long w;
    public String x;
    public String y;
    private BitSet ah = new BitSet(8);
    public boolean u = true;
    public boolean B = false;
    public boolean z = false;

    public boolean A() {
        return this.x != null;
    }

    public boolean B() {
        return this.y != null;
    }

    public boolean C() {
        return this.ah.get(6);
    }

    public boolean D() {
        return this.A != null;
    }

    public boolean E() {
        return this.ah.get(7);
    }

    public boolean F() {
        return this.C != null;
    }

    public void G() {
        if (this.f8875c == null) {
            throw new ip("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f8876d == null) {
            throw new ip("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f8879g != null) {
        } else {
            throw new ip("Required field 'token' was not present! Struct: " + toString());
        }
    }

    public hr a(int i2) {
        this.f8885m = i2;
        a(true);
        return this;
    }

    public hr a(he heVar) {
        this.t = heVar;
        return this;
    }

    public hr a(String str) {
        this.f8875c = str;
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
                G();
                return;
            }
            short s = h2.f9004c;
            switch (s) {
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
                        this.f8875c = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 4:
                    if (b == 11) {
                        this.f8876d = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 5:
                    if (b == 11) {
                        this.f8877e = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 6:
                    if (b == 11) {
                        this.f8878f = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 7:
                    if (b == 11) {
                        this.f8879g = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 8:
                    if (b == 11) {
                        this.f8880h = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 9:
                    if (b == 11) {
                        this.f8881i = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 10:
                    if (b == 11) {
                        this.f8882j = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 11:
                    if (b == 11) {
                        this.f8883k = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 12:
                    if (b == 11) {
                        this.f8884l = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 13:
                    if (b == 8) {
                        this.f8885m = ioVar.s();
                        a(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 14:
                    if (b == 8) {
                        this.n = ioVar.s();
                        b(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 15:
                    if (b == 11) {
                        this.o = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 16:
                    if (b == 11) {
                        this.p = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 17:
                    if (b == 11) {
                        this.q = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 18:
                    if (b == 11) {
                        this.r = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 19:
                    if (b == 8) {
                        this.s = ioVar.s();
                        c(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 20:
                    if (b == 8) {
                        this.t = he.a(ioVar.s());
                        continue;
                        ioVar.i();
                    }
                    break;
                case 21:
                    if (b == 2) {
                        this.u = ioVar.p();
                        d(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 22:
                    if (b == 10) {
                        this.v = ioVar.t();
                        e(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 23:
                    if (b == 10) {
                        this.w = ioVar.t();
                        f(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 24:
                    if (b == 11) {
                        this.x = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 25:
                    if (b == 11) {
                        this.y = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 26:
                    if (b == 2) {
                        this.z = ioVar.p();
                        g(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                default:
                    switch (s) {
                        case 100:
                            if (b == 13) {
                                in j2 = ioVar.j();
                                this.A = new HashMap(j2.f9005c * 2);
                                for (int i2 = 0; i2 < j2.f9005c; i2++) {
                                    this.A.put(ioVar.v(), ioVar.v());
                                }
                                ioVar.k();
                                break;
                            }
                            break;
                        case 101:
                            if (b == 2) {
                                this.B = ioVar.p();
                                h(true);
                                break;
                            }
                            break;
                        case 102:
                            if (b == 11) {
                                this.C = ioVar.v();
                                continue;
                            }
                            break;
                    }
                    ioVar.i();
                    break;
            }
            ir.a(ioVar, b);
            ioVar.i();
        }
    }

    public void a(boolean z) {
        this.ah.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(hr hrVar) {
        if (hrVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = hrVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(hrVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = hrVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(hrVar.b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hrVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f8875c.equals(hrVar.f8875c))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hrVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f8876d.equals(hrVar.f8876d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hrVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f8877e.equals(hrVar.f8877e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hrVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f8878f.equals(hrVar.f8878f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hrVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f8879g.equals(hrVar.f8879g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hrVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f8880h.equals(hrVar.f8880h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hrVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f8881i.equals(hrVar.f8881i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hrVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f8882j.equals(hrVar.f8882j))) {
            return false;
        }
        boolean n = n();
        boolean n2 = hrVar.n();
        if ((n || n2) && !(n && n2 && this.f8883k.equals(hrVar.f8883k))) {
            return false;
        }
        boolean o = o();
        boolean o2 = hrVar.o();
        if ((o || o2) && !(o && o2 && this.f8884l.equals(hrVar.f8884l))) {
            return false;
        }
        boolean p = p();
        boolean p2 = hrVar.p();
        if ((p || p2) && !(p && p2 && this.f8885m == hrVar.f8885m)) {
            return false;
        }
        boolean q = q();
        boolean q2 = hrVar.q();
        if ((q || q2) && !(q && q2 && this.n == hrVar.n)) {
            return false;
        }
        boolean r = r();
        boolean r2 = hrVar.r();
        if ((r || r2) && !(r && r2 && this.o.equals(hrVar.o))) {
            return false;
        }
        boolean s = s();
        boolean s2 = hrVar.s();
        if ((s || s2) && !(s && s2 && this.p.equals(hrVar.p))) {
            return false;
        }
        boolean t = t();
        boolean t2 = hrVar.t();
        if ((t || t2) && !(t && t2 && this.q.equals(hrVar.q))) {
            return false;
        }
        boolean u = u();
        boolean u2 = hrVar.u();
        if ((u || u2) && !(u && u2 && this.r.equals(hrVar.r))) {
            return false;
        }
        boolean v = v();
        boolean v2 = hrVar.v();
        if ((v || v2) && !(v && v2 && this.s == hrVar.s)) {
            return false;
        }
        boolean w = w();
        boolean w2 = hrVar.w();
        if ((w || w2) && !(w && w2 && this.t.equals(hrVar.t))) {
            return false;
        }
        boolean x = x();
        boolean x2 = hrVar.x();
        if ((x || x2) && !(x && x2 && this.u == hrVar.u)) {
            return false;
        }
        boolean y = y();
        boolean y2 = hrVar.y();
        if ((y || y2) && !(y && y2 && this.v == hrVar.v)) {
            return false;
        }
        boolean z = z();
        boolean z2 = hrVar.z();
        if ((z || z2) && !(z && z2 && this.w == hrVar.w)) {
            return false;
        }
        boolean A = A();
        boolean A2 = hrVar.A();
        if ((A || A2) && !(A && A2 && this.x.equals(hrVar.x))) {
            return false;
        }
        boolean B = B();
        boolean B2 = hrVar.B();
        if ((B || B2) && !(B && B2 && this.y.equals(hrVar.y))) {
            return false;
        }
        boolean C = C();
        boolean C2 = hrVar.C();
        if ((C || C2) && !(C && C2 && this.z == hrVar.z)) {
            return false;
        }
        boolean D2 = D();
        boolean D3 = hrVar.D();
        if ((D2 || D3) && !(D2 && D3 && this.A.equals(hrVar.A))) {
            return false;
        }
        boolean E2 = E();
        boolean E3 = hrVar.E();
        if ((E2 || E3) && !(E2 && E3 && this.B == hrVar.B)) {
            return false;
        }
        boolean F2 = F();
        boolean F3 = hrVar.F();
        if (F2 || F3) {
            return F2 && F3 && this.C.equals(hrVar.C);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(hr hrVar) {
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
        int a21;
        int a22;
        int a23;
        int a24;
        int a25;
        int a26;
        int a27;
        int a28;
        int a29;
        if (getClass().equals(hrVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hrVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a29 = id.a(this.a, hrVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hrVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a28 = id.a(this.b, hrVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hrVar.d()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!d() || (a27 = id.a(this.f8875c, hrVar.f8875c)) == 0) {
                        int compareTo4 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hrVar.f()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!f() || (a26 = id.a(this.f8876d, hrVar.f8876d)) == 0) {
                            int compareTo5 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hrVar.g()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!g() || (a25 = id.a(this.f8877e, hrVar.f8877e)) == 0) {
                                int compareTo6 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hrVar.h()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!h() || (a24 = id.a(this.f8878f, hrVar.f8878f)) == 0) {
                                    int compareTo7 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hrVar.j()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!j() || (a23 = id.a(this.f8879g, hrVar.f8879g)) == 0) {
                                        int compareTo8 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hrVar.k()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!k() || (a22 = id.a(this.f8880h, hrVar.f8880h)) == 0) {
                                            int compareTo9 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hrVar.l()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!l() || (a21 = id.a(this.f8881i, hrVar.f8881i)) == 0) {
                                                int compareTo10 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hrVar.m()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!m() || (a20 = id.a(this.f8882j, hrVar.f8882j)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hrVar.n()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!n() || (a19 = id.a(this.f8883k, hrVar.f8883k)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hrVar.o()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!o() || (a18 = id.a(this.f8884l, hrVar.f8884l)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hrVar.p()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!p() || (a17 = id.a(this.f8885m, hrVar.f8885m)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hrVar.q()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!q() || (a16 = id.a(this.n, hrVar.n)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hrVar.r()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!r() || (a15 = id.a(this.o, hrVar.o)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hrVar.s()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!s() || (a14 = id.a(this.p, hrVar.p)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hrVar.t()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!t() || (a13 = id.a(this.q, hrVar.q)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(hrVar.u()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!u() || (a12 = id.a(this.r, hrVar.r)) == 0) {
                                                                                    int compareTo19 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(hrVar.v()));
                                                                                    if (compareTo19 != 0) {
                                                                                        return compareTo19;
                                                                                    }
                                                                                    if (!v() || (a11 = id.a(this.s, hrVar.s)) == 0) {
                                                                                        int compareTo20 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(hrVar.w()));
                                                                                        if (compareTo20 != 0) {
                                                                                            return compareTo20;
                                                                                        }
                                                                                        if (!w() || (a10 = id.a(this.t, hrVar.t)) == 0) {
                                                                                            int compareTo21 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(hrVar.x()));
                                                                                            if (compareTo21 != 0) {
                                                                                                return compareTo21;
                                                                                            }
                                                                                            if (!x() || (a9 = id.a(this.u, hrVar.u)) == 0) {
                                                                                                int compareTo22 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(hrVar.y()));
                                                                                                if (compareTo22 != 0) {
                                                                                                    return compareTo22;
                                                                                                }
                                                                                                if (!y() || (a8 = id.a(this.v, hrVar.v)) == 0) {
                                                                                                    int compareTo23 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(hrVar.z()));
                                                                                                    if (compareTo23 != 0) {
                                                                                                        return compareTo23;
                                                                                                    }
                                                                                                    if (!z() || (a7 = id.a(this.w, hrVar.w)) == 0) {
                                                                                                        int compareTo24 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(hrVar.A()));
                                                                                                        if (compareTo24 != 0) {
                                                                                                            return compareTo24;
                                                                                                        }
                                                                                                        if (!A() || (a6 = id.a(this.x, hrVar.x)) == 0) {
                                                                                                            int compareTo25 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(hrVar.B()));
                                                                                                            if (compareTo25 != 0) {
                                                                                                                return compareTo25;
                                                                                                            }
                                                                                                            if (!B() || (a5 = id.a(this.y, hrVar.y)) == 0) {
                                                                                                                int compareTo26 = Boolean.valueOf(C()).compareTo(Boolean.valueOf(hrVar.C()));
                                                                                                                if (compareTo26 != 0) {
                                                                                                                    return compareTo26;
                                                                                                                }
                                                                                                                if (!C() || (a4 = id.a(this.z, hrVar.z)) == 0) {
                                                                                                                    int compareTo27 = Boolean.valueOf(D()).compareTo(Boolean.valueOf(hrVar.D()));
                                                                                                                    if (compareTo27 != 0) {
                                                                                                                        return compareTo27;
                                                                                                                    }
                                                                                                                    if (!D() || (a3 = id.a(this.A, hrVar.A)) == 0) {
                                                                                                                        int compareTo28 = Boolean.valueOf(E()).compareTo(Boolean.valueOf(hrVar.E()));
                                                                                                                        if (compareTo28 != 0) {
                                                                                                                            return compareTo28;
                                                                                                                        }
                                                                                                                        if (!E() || (a2 = id.a(this.B, hrVar.B)) == 0) {
                                                                                                                            int compareTo29 = Boolean.valueOf(F()).compareTo(Boolean.valueOf(hrVar.F()));
                                                                                                                            if (compareTo29 != 0) {
                                                                                                                                return compareTo29;
                                                                                                                            }
                                                                                                                            if (!F() || (a = id.a(this.C, hrVar.C)) == 0) {
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
                                            return a21;
                                        }
                                        return a22;
                                    }
                                    return a23;
                                }
                                return a24;
                            }
                            return a25;
                        }
                        return a26;
                    }
                    return a27;
                }
                return a28;
            }
            return a29;
        }
        return getClass().getName().compareTo(hrVar.getClass().getName());
    }

    public hr b(int i2) {
        this.n = i2;
        b(true);
        return this;
    }

    public hr b(String str) {
        this.f8876d = str;
        return this;
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        G();
        ioVar.a(D);
        if (this.a != null && a()) {
            ioVar.a(E);
            ioVar.a(this.a);
            ioVar.b();
        }
        if (this.b != null && b()) {
            ioVar.a(F);
            this.b.b(ioVar);
            ioVar.b();
        }
        if (this.f8875c != null) {
            ioVar.a(G);
            ioVar.a(this.f8875c);
            ioVar.b();
        }
        if (this.f8876d != null) {
            ioVar.a(H);
            ioVar.a(this.f8876d);
            ioVar.b();
        }
        if (this.f8877e != null && g()) {
            ioVar.a(I);
            ioVar.a(this.f8877e);
            ioVar.b();
        }
        if (this.f8878f != null && h()) {
            ioVar.a(J);
            ioVar.a(this.f8878f);
            ioVar.b();
        }
        if (this.f8879g != null) {
            ioVar.a(K);
            ioVar.a(this.f8879g);
            ioVar.b();
        }
        if (this.f8880h != null && k()) {
            ioVar.a(L);
            ioVar.a(this.f8880h);
            ioVar.b();
        }
        if (this.f8881i != null && l()) {
            ioVar.a(M);
            ioVar.a(this.f8881i);
            ioVar.b();
        }
        if (this.f8882j != null && m()) {
            ioVar.a(N);
            ioVar.a(this.f8882j);
            ioVar.b();
        }
        if (this.f8883k != null && n()) {
            ioVar.a(O);
            ioVar.a(this.f8883k);
            ioVar.b();
        }
        if (this.f8884l != null && o()) {
            ioVar.a(P);
            ioVar.a(this.f8884l);
            ioVar.b();
        }
        if (p()) {
            ioVar.a(Q);
            ioVar.a(this.f8885m);
            ioVar.b();
        }
        if (q()) {
            ioVar.a(R);
            ioVar.a(this.n);
            ioVar.b();
        }
        if (this.o != null && r()) {
            ioVar.a(S);
            ioVar.a(this.o);
            ioVar.b();
        }
        if (this.p != null && s()) {
            ioVar.a(T);
            ioVar.a(this.p);
            ioVar.b();
        }
        if (this.q != null && t()) {
            ioVar.a(U);
            ioVar.a(this.q);
            ioVar.b();
        }
        if (this.r != null && u()) {
            ioVar.a(V);
            ioVar.a(this.r);
            ioVar.b();
        }
        if (v()) {
            ioVar.a(W);
            ioVar.a(this.s);
            ioVar.b();
        }
        if (this.t != null && w()) {
            ioVar.a(X);
            ioVar.a(this.t.a());
            ioVar.b();
        }
        if (x()) {
            ioVar.a(Y);
            ioVar.a(this.u);
            ioVar.b();
        }
        if (y()) {
            ioVar.a(Z);
            ioVar.a(this.v);
            ioVar.b();
        }
        if (z()) {
            ioVar.a(aa);
            ioVar.a(this.w);
            ioVar.b();
        }
        if (this.x != null && A()) {
            ioVar.a(ab);
            ioVar.a(this.x);
            ioVar.b();
        }
        if (this.y != null && B()) {
            ioVar.a(ac);
            ioVar.a(this.y);
            ioVar.b();
        }
        if (C()) {
            ioVar.a(ad);
            ioVar.a(this.z);
            ioVar.b();
        }
        if (this.A != null && D()) {
            ioVar.a(ae);
            ioVar.a(new in((byte) 11, (byte) 11, this.A.size()));
            for (Map.Entry<String, String> entry : this.A.entrySet()) {
                ioVar.a(entry.getKey());
                ioVar.a(entry.getValue());
            }
            ioVar.d();
            ioVar.b();
        }
        if (E()) {
            ioVar.a(af);
            ioVar.a(this.B);
            ioVar.b();
        }
        if (this.C != null && F()) {
            ioVar.a(ag);
            ioVar.a(this.C);
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public void b(boolean z) {
        this.ah.set(1, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public hr c(int i2) {
        this.s = i2;
        c(true);
        return this;
    }

    public hr c(String str) {
        this.f8877e = str;
        return this;
    }

    public String c() {
        return this.f8875c;
    }

    public void c(boolean z) {
        this.ah.set(2, z);
    }

    public hr d(String str) {
        this.f8878f = str;
        return this;
    }

    public void d(boolean z) {
        this.ah.set(3, z);
    }

    public boolean d() {
        return this.f8875c != null;
    }

    public hr e(String str) {
        this.f8879g = str;
        return this;
    }

    public String e() {
        return this.f8876d;
    }

    public void e(boolean z) {
        this.ah.set(4, z);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hr)) {
            return a((hr) obj);
        }
        return false;
    }

    public hr f(String str) {
        this.f8880h = str;
        return this;
    }

    public void f(boolean z) {
        this.ah.set(5, z);
    }

    public boolean f() {
        return this.f8876d != null;
    }

    public hr g(String str) {
        this.f8881i = str;
        return this;
    }

    public void g(boolean z) {
        this.ah.set(6, z);
    }

    public boolean g() {
        return this.f8877e != null;
    }

    public hr h(String str) {
        this.f8884l = str;
        return this;
    }

    public void h(boolean z) {
        this.ah.set(7, z);
    }

    public boolean h() {
        return this.f8878f != null;
    }

    public int hashCode() {
        return 0;
    }

    public hr i(String str) {
        this.r = str;
        return this;
    }

    public String i() {
        return this.f8879g;
    }

    public boolean j() {
        return this.f8879g != null;
    }

    public boolean k() {
        return this.f8880h != null;
    }

    public boolean l() {
        return this.f8881i != null;
    }

    public boolean m() {
        return this.f8882j != null;
    }

    public boolean n() {
        return this.f8883k != null;
    }

    public boolean o() {
        return this.f8884l != null;
    }

    public boolean p() {
        return this.ah.get(0);
    }

    public boolean q() {
        return this.ah.get(1);
    }

    public boolean r() {
        return this.o != null;
    }

    public boolean s() {
        return this.p != null;
    }

    public boolean t() {
        return this.q != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
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
        String str2 = this.f8875c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(com.xiaomi.push.service.ag.a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f8876d;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (g()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str4 = this.f8877e;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f8878f;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(", ");
        sb.append("token:");
        String str6 = this.f8879g;
        if (str6 == null) {
            sb.append("null");
        } else {
            sb.append(str6);
        }
        if (k()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str7 = this.f8880h;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.f8881i;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            String str9 = this.f8882j;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("regId:");
            String str10 = this.f8883k;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            String str11 = this.f8884l;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f8885m);
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.n);
        }
        if (r()) {
            sb.append(", ");
            sb.append("androidId:");
            String str12 = this.o;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("imei:");
            String str13 = this.p;
            if (str13 == null) {
                sb.append("null");
            } else {
                sb.append(str13);
            }
        }
        if (t()) {
            sb.append(", ");
            sb.append("serial:");
            String str14 = this.q;
            if (str14 == null) {
                sb.append("null");
            } else {
                sb.append(str14);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str15 = this.r;
            if (str15 == null) {
                sb.append("null");
            } else {
                sb.append(str15);
            }
        }
        if (v()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.s);
        }
        if (w()) {
            sb.append(", ");
            sb.append("reason:");
            he heVar = this.t;
            if (heVar == null) {
                sb.append("null");
            } else {
                sb.append(heVar);
            }
        }
        if (x()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.u);
        }
        if (y()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.v);
        }
        if (z()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.w);
        }
        if (A()) {
            sb.append(", ");
            sb.append("subImei:");
            String str16 = this.x;
            if (str16 == null) {
                sb.append("null");
            } else {
                sb.append(str16);
            }
        }
        if (B()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            String str17 = this.y;
            if (str17 == null) {
                sb.append("null");
            } else {
                sb.append(str17);
            }
        }
        if (C()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.z);
        }
        if (D()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            Map<String, String> map = this.A;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (E()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.B);
        }
        if (F()) {
            sb.append(", ");
            sb.append("oldRegId:");
            String str18 = this.C;
            if (str18 == null) {
                sb.append("null");
            } else {
                sb.append(str18);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.r != null;
    }

    public boolean v() {
        return this.ah.get(2);
    }

    public boolean w() {
        return this.t != null;
    }

    public boolean x() {
        return this.ah.get(3);
    }

    public boolean y() {
        return this.ah.get(4);
    }

    public boolean z() {
        return this.ah.get(5);
    }
}
