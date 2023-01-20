package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes3.dex */
public class hm implements ic<hm, Object>, Serializable, Cloneable {

    /* renamed from: k  reason: collision with root package name */
    private static final it f8840k = new it("XmPushActionCommandResult");

    /* renamed from: l  reason: collision with root package name */
    private static final il f8841l = new il("", (byte) 12, 2);

    /* renamed from: m  reason: collision with root package name */
    private static final il f8842m = new il("", (byte) 11, 3);
    private static final il n = new il("", (byte) 11, 4);
    private static final il o = new il("", (byte) 11, 5);
    private static final il p = new il("", (byte) 10, 7);
    private static final il q = new il("", (byte) 11, 8);
    private static final il r = new il("", (byte) 11, 9);
    private static final il s = new il("", com.umeng.analytics.pro.cb.f7124m, 10);
    private static final il t = new il("", (byte) 11, 12);
    private static final il u = new il("", (byte) 2, 13);
    public hf a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f8843c;

    /* renamed from: d  reason: collision with root package name */
    public String f8844d;

    /* renamed from: e  reason: collision with root package name */
    public long f8845e;

    /* renamed from: f  reason: collision with root package name */
    public String f8846f;

    /* renamed from: g  reason: collision with root package name */
    public String f8847g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f8848h;

    /* renamed from: i  reason: collision with root package name */
    public String f8849i;
    private BitSet v = new BitSet(2);

    /* renamed from: j  reason: collision with root package name */
    public boolean f8850j = true;

    @Override // com.xiaomi.push.ic
    public void a(io ioVar) {
        ioVar.f();
        while (true) {
            il h2 = ioVar.h();
            byte b = h2.b;
            if (b == 0) {
                ioVar.g();
                if (g()) {
                    o();
                    return;
                }
                throw new ip("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
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
                        this.f8843c = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 5:
                    if (b == 11) {
                        this.f8844d = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 7:
                    if (b == 10) {
                        this.f8845e = ioVar.t();
                        a(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 8:
                    if (b == 11) {
                        this.f8846f = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 9:
                    if (b == 11) {
                        this.f8847g = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 10:
                    if (b == 15) {
                        im l2 = ioVar.l();
                        this.f8848h = new ArrayList(l2.b);
                        for (int i2 = 0; i2 < l2.b; i2++) {
                            this.f8848h.add(ioVar.v());
                        }
                        ioVar.m();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 12:
                    if (b == 11) {
                        this.f8849i = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 13:
                    if (b == 2) {
                        this.f8850j = ioVar.p();
                        b(true);
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

    public boolean a(hm hmVar) {
        if (hmVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = hmVar.a();
        if ((a || a2) && !(a && a2 && this.a.a(hmVar.a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hmVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.b.equals(hmVar.b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hmVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f8843c.equals(hmVar.f8843c))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hmVar.f();
        if (((f2 || f3) && !(f2 && f3 && this.f8844d.equals(hmVar.f8844d))) || this.f8845e != hmVar.f8845e) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hmVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f8846f.equals(hmVar.f8846f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hmVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f8847g.equals(hmVar.f8847g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hmVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f8848h.equals(hmVar.f8848h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hmVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f8849i.equals(hmVar.f8849i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hmVar.n();
        if (n2 || n3) {
            return n2 && n3 && this.f8850j == hmVar.f8850j;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(hm hmVar) {
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
        if (getClass().equals(hmVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hmVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a10 = id.a(this.a, hmVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hmVar.c()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!c() || (a9 = id.a(this.b, hmVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hmVar.d()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!d() || (a8 = id.a(this.f8843c, hmVar.f8843c)) == 0) {
                        int compareTo4 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hmVar.f()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!f() || (a7 = id.a(this.f8844d, hmVar.f8844d)) == 0) {
                            int compareTo5 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hmVar.g()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!g() || (a6 = id.a(this.f8845e, hmVar.f8845e)) == 0) {
                                int compareTo6 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hmVar.h()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!h() || (a5 = id.a(this.f8846f, hmVar.f8846f)) == 0) {
                                    int compareTo7 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hmVar.i()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!i() || (a4 = id.a(this.f8847g, hmVar.f8847g)) == 0) {
                                        int compareTo8 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hmVar.k()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!k() || (a3 = id.a(this.f8848h, hmVar.f8848h)) == 0) {
                                            int compareTo9 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hmVar.m()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!m() || (a2 = id.a(this.f8849i, hmVar.f8849i)) == 0) {
                                                int compareTo10 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hmVar.n()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!n() || (a = id.a(this.f8850j, hmVar.f8850j)) == 0) {
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
        return getClass().getName().compareTo(hmVar.getClass().getName());
    }

    public String b() {
        return this.b;
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        o();
        ioVar.a(f8840k);
        if (this.a != null && a()) {
            ioVar.a(f8841l);
            this.a.b(ioVar);
            ioVar.b();
        }
        if (this.b != null) {
            ioVar.a(f8842m);
            ioVar.a(this.b);
            ioVar.b();
        }
        if (this.f8843c != null) {
            ioVar.a(n);
            ioVar.a(this.f8843c);
            ioVar.b();
        }
        if (this.f8844d != null) {
            ioVar.a(o);
            ioVar.a(this.f8844d);
            ioVar.b();
        }
        ioVar.a(p);
        ioVar.a(this.f8845e);
        ioVar.b();
        if (this.f8846f != null && h()) {
            ioVar.a(q);
            ioVar.a(this.f8846f);
            ioVar.b();
        }
        if (this.f8847g != null && i()) {
            ioVar.a(r);
            ioVar.a(this.f8847g);
            ioVar.b();
        }
        if (this.f8848h != null && k()) {
            ioVar.a(s);
            ioVar.a(new im((byte) 11, this.f8848h.size()));
            for (String str : this.f8848h) {
                ioVar.a(str);
            }
            ioVar.e();
            ioVar.b();
        }
        if (this.f8849i != null && m()) {
            ioVar.a(t);
            ioVar.a(this.f8849i);
            ioVar.b();
        }
        if (n()) {
            ioVar.a(u);
            ioVar.a(this.f8850j);
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public void b(boolean z) {
        this.v.set(1, z);
    }

    public boolean c() {
        return this.b != null;
    }

    public boolean d() {
        return this.f8843c != null;
    }

    public String e() {
        return this.f8844d;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hm)) {
            return a((hm) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f8844d != null;
    }

    public boolean g() {
        return this.v.get(0);
    }

    public boolean h() {
        return this.f8846f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f8847g != null;
    }

    public List<String> j() {
        return this.f8848h;
    }

    public boolean k() {
        return this.f8848h != null;
    }

    public String l() {
        return this.f8849i;
    }

    public boolean m() {
        return this.f8849i != null;
    }

    public boolean n() {
        return this.v.get(1);
    }

    public void o() {
        if (this.b == null) {
            throw new ip("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f8843c == null) {
            throw new ip("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f8844d != null) {
        } else {
            throw new ip("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
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
        String str2 = this.f8843c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f8844d;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f8845e);
        if (h()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f8846f;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f8847g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f8848h;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f8849i;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f8850j);
        }
        sb.append(")");
        return sb.toString();
    }
}
