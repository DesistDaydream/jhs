package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class gu implements ic<gu, Object>, Serializable, Cloneable {

    /* renamed from: l  reason: collision with root package name */
    private static final it f8704l = new it("ClientUploadDataItem");

    /* renamed from: m  reason: collision with root package name */
    private static final il f8705m = new il("", (byte) 11, 1);
    private static final il n = new il("", (byte) 11, 2);
    private static final il o = new il("", (byte) 11, 3);
    private static final il p = new il("", (byte) 10, 4);
    private static final il q = new il("", (byte) 10, 5);
    private static final il r = new il("", (byte) 2, 6);
    private static final il s = new il("", (byte) 11, 7);
    private static final il t = new il("", (byte) 11, 8);
    private static final il u = new il("", (byte) 11, 9);
    private static final il v = new il("", (byte) 13, 10);
    private static final il w = new il("", (byte) 11, 11);
    public String a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f8706c;

    /* renamed from: d  reason: collision with root package name */
    public long f8707d;

    /* renamed from: e  reason: collision with root package name */
    public long f8708e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f8709f;

    /* renamed from: g  reason: collision with root package name */
    public String f8710g;

    /* renamed from: h  reason: collision with root package name */
    public String f8711h;

    /* renamed from: i  reason: collision with root package name */
    public String f8712i;

    /* renamed from: j  reason: collision with root package name */
    public Map<String, String> f8713j;

    /* renamed from: k  reason: collision with root package name */
    public String f8714k;
    private BitSet x = new BitSet(3);

    public gu a(long j2) {
        this.f8707d = j2;
        a(true);
        return this;
    }

    public gu a(String str) {
        this.a = str;
        return this;
    }

    public gu a(Map<String, String> map) {
        this.f8713j = map;
        return this;
    }

    public String a() {
        return this.a;
    }

    @Override // com.xiaomi.push.ic
    public void a(io ioVar) {
        ioVar.f();
        while (true) {
            il h2 = ioVar.h();
            byte b = h2.b;
            if (b == 0) {
                ioVar.g();
                s();
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
                    if (b == 11) {
                        this.b = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 3:
                    if (b == 11) {
                        this.f8706c = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 4:
                    if (b == 10) {
                        this.f8707d = ioVar.t();
                        a(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 5:
                    if (b == 10) {
                        this.f8708e = ioVar.t();
                        b(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 6:
                    if (b == 2) {
                        this.f8709f = ioVar.p();
                        d(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 7:
                    if (b == 11) {
                        this.f8710g = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 8:
                    if (b == 11) {
                        this.f8711h = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 9:
                    if (b == 11) {
                        this.f8712i = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 10:
                    if (b == 13) {
                        in j2 = ioVar.j();
                        this.f8713j = new HashMap(j2.f9005c * 2);
                        for (int i2 = 0; i2 < j2.f9005c; i2++) {
                            this.f8713j.put(ioVar.v(), ioVar.v());
                        }
                        ioVar.k();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 11:
                    if (b == 11) {
                        this.f8714k = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
            }
            ir.a(ioVar, b);
            ioVar.i();
        }
    }

    public void a(String str, String str2) {
        if (this.f8713j == null) {
            this.f8713j = new HashMap();
        }
        this.f8713j.put(str, str2);
    }

    public void a(boolean z) {
        this.x.set(0, z);
    }

    public boolean a(gu guVar) {
        if (guVar == null) {
            return false;
        }
        boolean b = b();
        boolean b2 = guVar.b();
        if ((b || b2) && !(b && b2 && this.a.equals(guVar.a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = guVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.b.equals(guVar.b))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = guVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f8706c.equals(guVar.f8706c))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = guVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f8707d == guVar.f8707d)) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = guVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f8708e == guVar.f8708e)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = guVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f8709f == guVar.f8709f)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = guVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f8710g.equals(guVar.f8710g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = guVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f8711h.equals(guVar.f8711h))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = guVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f8712i.equals(guVar.f8712i))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = guVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f8713j.equals(guVar.f8713j))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = guVar.r();
        if (r2 || r3) {
            return r2 && r3 && this.f8714k.equals(guVar.f8714k);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(gu guVar) {
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
        if (getClass().equals(guVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(guVar.b()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!b() || (a11 = id.a(this.a, guVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(guVar.c()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!c() || (a10 = id.a(this.b, guVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(guVar.e()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!e() || (a9 = id.a(this.f8706c, guVar.f8706c)) == 0) {
                        int compareTo4 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(guVar.f()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!f() || (a8 = id.a(this.f8707d, guVar.f8707d)) == 0) {
                            int compareTo5 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(guVar.h()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!h() || (a7 = id.a(this.f8708e, guVar.f8708e)) == 0) {
                                int compareTo6 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(guVar.i()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!i() || (a6 = id.a(this.f8709f, guVar.f8709f)) == 0) {
                                    int compareTo7 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(guVar.j()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!j() || (a5 = id.a(this.f8710g, guVar.f8710g)) == 0) {
                                        int compareTo8 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(guVar.l()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!l() || (a4 = id.a(this.f8711h, guVar.f8711h)) == 0) {
                                            int compareTo9 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(guVar.n()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!n() || (a3 = id.a(this.f8712i, guVar.f8712i)) == 0) {
                                                int compareTo10 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(guVar.p()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!p() || (a2 = id.a(this.f8713j, guVar.f8713j)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(guVar.r()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!r() || (a = id.a(this.f8714k, guVar.f8714k)) == 0) {
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
        return getClass().getName().compareTo(guVar.getClass().getName());
    }

    public gu b(long j2) {
        this.f8708e = j2;
        b(true);
        return this;
    }

    public gu b(String str) {
        this.b = str;
        return this;
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        s();
        ioVar.a(f8704l);
        if (this.a != null && b()) {
            ioVar.a(f8705m);
            ioVar.a(this.a);
            ioVar.b();
        }
        if (this.b != null && c()) {
            ioVar.a(n);
            ioVar.a(this.b);
            ioVar.b();
        }
        if (this.f8706c != null && e()) {
            ioVar.a(o);
            ioVar.a(this.f8706c);
            ioVar.b();
        }
        if (f()) {
            ioVar.a(p);
            ioVar.a(this.f8707d);
            ioVar.b();
        }
        if (h()) {
            ioVar.a(q);
            ioVar.a(this.f8708e);
            ioVar.b();
        }
        if (i()) {
            ioVar.a(r);
            ioVar.a(this.f8709f);
            ioVar.b();
        }
        if (this.f8710g != null && j()) {
            ioVar.a(s);
            ioVar.a(this.f8710g);
            ioVar.b();
        }
        if (this.f8711h != null && l()) {
            ioVar.a(t);
            ioVar.a(this.f8711h);
            ioVar.b();
        }
        if (this.f8712i != null && n()) {
            ioVar.a(u);
            ioVar.a(this.f8712i);
            ioVar.b();
        }
        if (this.f8713j != null && p()) {
            ioVar.a(v);
            ioVar.a(new in((byte) 11, (byte) 11, this.f8713j.size()));
            for (Map.Entry<String, String> entry : this.f8713j.entrySet()) {
                ioVar.a(entry.getKey());
                ioVar.a(entry.getValue());
            }
            ioVar.d();
            ioVar.b();
        }
        if (this.f8714k != null && r()) {
            ioVar.a(w);
            ioVar.a(this.f8714k);
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public void b(boolean z) {
        this.x.set(1, z);
    }

    public boolean b() {
        return this.a != null;
    }

    public gu c(String str) {
        this.f8706c = str;
        return this;
    }

    public gu c(boolean z) {
        this.f8709f = z;
        d(true);
        return this;
    }

    public boolean c() {
        return this.b != null;
    }

    public gu d(String str) {
        this.f8710g = str;
        return this;
    }

    public String d() {
        return this.f8706c;
    }

    public void d(boolean z) {
        this.x.set(2, z);
    }

    public gu e(String str) {
        this.f8711h = str;
        return this;
    }

    public boolean e() {
        return this.f8706c != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gu)) {
            return a((gu) obj);
        }
        return false;
    }

    public gu f(String str) {
        this.f8712i = str;
        return this;
    }

    public boolean f() {
        return this.x.get(0);
    }

    public long g() {
        return this.f8708e;
    }

    public gu g(String str) {
        this.f8714k = str;
        return this;
    }

    public boolean h() {
        return this.x.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.x.get(2);
    }

    public boolean j() {
        return this.f8710g != null;
    }

    public String k() {
        return this.f8711h;
    }

    public boolean l() {
        return this.f8711h != null;
    }

    public String m() {
        return this.f8712i;
    }

    public boolean n() {
        return this.f8712i != null;
    }

    public Map<String, String> o() {
        return this.f8713j;
    }

    public boolean p() {
        return this.f8713j != null;
    }

    public String q() {
        return this.f8714k;
    }

    public boolean r() {
        return this.f8714k != null;
    }

    public void s() {
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = false;
        if (b()) {
            sb.append("channel:");
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
        if (c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("data:");
            String str2 = this.b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
            z = false;
        }
        if (e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("name:");
            String str3 = this.f8706c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f8707d);
            z = false;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f8708e);
            z = false;
        }
        if (i()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f8709f);
            z = false;
        }
        if (j()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("category:");
            String str4 = this.f8710g;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
            z = false;
        }
        if (l()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            String str5 = this.f8711h;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
            z = false;
        }
        if (n()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("id:");
            String str6 = this.f8712i;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
            z = false;
        }
        if (p()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("extra:");
            Map<String, String> map = this.f8713j;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        } else {
            z2 = z;
        }
        if (r()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            String str7 = this.f8714k;
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
