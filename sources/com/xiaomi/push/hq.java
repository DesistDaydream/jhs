package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class hq implements ic<hq, Object>, Serializable, Cloneable {
    private BitSet F;
    public String a;
    public hf b;

    /* renamed from: c  reason: collision with root package name */
    public String f8864c;

    /* renamed from: d  reason: collision with root package name */
    public String f8865d;

    /* renamed from: e  reason: collision with root package name */
    public String f8866e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f8867f;

    /* renamed from: g  reason: collision with root package name */
    public String f8868g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f8869h;

    /* renamed from: i  reason: collision with root package name */
    public String f8870i;

    /* renamed from: j  reason: collision with root package name */
    public String f8871j;

    /* renamed from: k  reason: collision with root package name */
    public String f8872k;

    /* renamed from: l  reason: collision with root package name */
    public String f8873l;

    /* renamed from: m  reason: collision with root package name */
    public ByteBuffer f8874m;
    public long n;
    public boolean o;
    private static final it p = new it("XmPushActionNotification");
    private static final il q = new il("", (byte) 11, 1);
    private static final il r = new il("", (byte) 12, 2);
    private static final il s = new il("", (byte) 11, 3);
    private static final il t = new il("", (byte) 11, 4);
    private static final il u = new il("", (byte) 11, 5);
    private static final il v = new il("", (byte) 2, 6);
    private static final il w = new il("", (byte) 11, 7);
    private static final il x = new il("", (byte) 13, 8);
    private static final il y = new il("", (byte) 11, 9);
    private static final il z = new il("", (byte) 11, 10);
    private static final il A = new il("", (byte) 11, 12);
    private static final il B = new il("", (byte) 11, 13);
    private static final il C = new il("", (byte) 11, 14);
    private static final il D = new il("", (byte) 10, 15);
    private static final il E = new il("", (byte) 2, 20);

    public hq() {
        this.F = new BitSet(3);
        this.f8867f = true;
        this.o = false;
    }

    public hq(String str, boolean z2) {
        this();
        this.f8864c = str;
        this.f8867f = z2;
        b(true);
    }

    public hq a(String str) {
        this.f8864c = str;
        return this;
    }

    public hq a(ByteBuffer byteBuffer) {
        this.f8874m = byteBuffer;
        return this;
    }

    public hq a(Map<String, String> map) {
        this.f8869h = map;
        return this;
    }

    public hq a(boolean z2) {
        this.f8867f = z2;
        b(true);
        return this;
    }

    public hq a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
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
                if (i()) {
                    v();
                    return;
                }
                throw new ip("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
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
                        this.f8864c = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 4:
                    if (b == 11) {
                        this.f8865d = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 5:
                    if (b == 11) {
                        this.f8866e = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 6:
                    if (b == 2) {
                        this.f8867f = ioVar.p();
                        b(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 7:
                    if (b == 11) {
                        this.f8868g = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 8:
                    if (b == 13) {
                        in j2 = ioVar.j();
                        this.f8869h = new HashMap(j2.f9005c * 2);
                        for (int i2 = 0; i2 < j2.f9005c; i2++) {
                            this.f8869h.put(ioVar.v(), ioVar.v());
                        }
                        ioVar.k();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 9:
                    if (b == 11) {
                        this.f8870i = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 10:
                    if (b == 11) {
                        this.f8871j = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 12:
                    if (b == 11) {
                        this.f8872k = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 13:
                    if (b == 11) {
                        this.f8873l = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 14:
                    if (b == 11) {
                        this.f8874m = ioVar.w();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 15:
                    if (b == 10) {
                        this.n = ioVar.t();
                        c(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 20:
                    if (b == 2) {
                        this.o = ioVar.p();
                        d(true);
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
        if (this.f8869h == null) {
            this.f8869h = new HashMap();
        }
        this.f8869h.put(str, str2);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(hq hqVar) {
        if (hqVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = hqVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(hqVar.a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hqVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.b.a(hqVar.b))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hqVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f8864c.equals(hqVar.f8864c))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f8865d.equals(hqVar.f8865d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hqVar.h();
        if (((h2 || h3) && !(h2 && h3 && this.f8866e.equals(hqVar.f8866e))) || this.f8867f != hqVar.f8867f) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hqVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f8868g.equals(hqVar.f8868g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hqVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f8869h.equals(hqVar.f8869h))) {
            return false;
        }
        boolean n = n();
        boolean n2 = hqVar.n();
        if ((n || n2) && !(n && n2 && this.f8870i.equals(hqVar.f8870i))) {
            return false;
        }
        boolean o = o();
        boolean o2 = hqVar.o();
        if ((o || o2) && !(o && o2 && this.f8871j.equals(hqVar.f8871j))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hqVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f8872k.equals(hqVar.f8872k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hqVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f8873l.equals(hqVar.f8873l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = hqVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f8874m.equals(hqVar.f8874m))) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = hqVar.t();
        if ((t2 || t3) && !(t2 && t3 && this.n == hqVar.n)) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = hqVar.u();
        if (u2 || u3) {
            return u2 && u3 && this.o == hqVar.o;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(hq hqVar) {
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
        if (getClass().equals(hqVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hqVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a15 = id.a(this.a, hqVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hqVar.c()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!c() || (a14 = id.a(this.b, hqVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hqVar.e()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!e() || (a13 = id.a(this.f8864c, hqVar.f8864c)) == 0) {
                        int compareTo4 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hqVar.g()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!g() || (a12 = id.a(this.f8865d, hqVar.f8865d)) == 0) {
                            int compareTo5 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hqVar.h()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!h() || (a11 = id.a(this.f8866e, hqVar.f8866e)) == 0) {
                                int compareTo6 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hqVar.i()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!i() || (a10 = id.a(this.f8867f, hqVar.f8867f)) == 0) {
                                    int compareTo7 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hqVar.j()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!j() || (a9 = id.a(this.f8868g, hqVar.f8868g)) == 0) {
                                        int compareTo8 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hqVar.l()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!l() || (a8 = id.a(this.f8869h, hqVar.f8869h)) == 0) {
                                            int compareTo9 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hqVar.n()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!n() || (a7 = id.a(this.f8870i, hqVar.f8870i)) == 0) {
                                                int compareTo10 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hqVar.o()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!o() || (a6 = id.a(this.f8871j, hqVar.f8871j)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hqVar.p()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!p() || (a5 = id.a(this.f8872k, hqVar.f8872k)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hqVar.q()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!q() || (a4 = id.a(this.f8873l, hqVar.f8873l)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hqVar.s()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!s() || (a3 = id.a(this.f8874m, hqVar.f8874m)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hqVar.t()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!t() || (a2 = id.a(this.n, hqVar.n)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(hqVar.u()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!u() || (a = id.a(this.o, hqVar.o)) == 0) {
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
        return getClass().getName().compareTo(hqVar.getClass().getName());
    }

    public hf b() {
        return this.b;
    }

    public hq b(String str) {
        this.f8865d = str;
        return this;
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        v();
        ioVar.a(p);
        if (this.a != null && a()) {
            ioVar.a(q);
            ioVar.a(this.a);
            ioVar.b();
        }
        if (this.b != null && c()) {
            ioVar.a(r);
            this.b.b(ioVar);
            ioVar.b();
        }
        if (this.f8864c != null) {
            ioVar.a(s);
            ioVar.a(this.f8864c);
            ioVar.b();
        }
        if (this.f8865d != null && g()) {
            ioVar.a(t);
            ioVar.a(this.f8865d);
            ioVar.b();
        }
        if (this.f8866e != null && h()) {
            ioVar.a(u);
            ioVar.a(this.f8866e);
            ioVar.b();
        }
        ioVar.a(v);
        ioVar.a(this.f8867f);
        ioVar.b();
        if (this.f8868g != null && j()) {
            ioVar.a(w);
            ioVar.a(this.f8868g);
            ioVar.b();
        }
        if (this.f8869h != null && l()) {
            ioVar.a(x);
            ioVar.a(new in((byte) 11, (byte) 11, this.f8869h.size()));
            for (Map.Entry<String, String> entry : this.f8869h.entrySet()) {
                ioVar.a(entry.getKey());
                ioVar.a(entry.getValue());
            }
            ioVar.d();
            ioVar.b();
        }
        if (this.f8870i != null && n()) {
            ioVar.a(y);
            ioVar.a(this.f8870i);
            ioVar.b();
        }
        if (this.f8871j != null && o()) {
            ioVar.a(z);
            ioVar.a(this.f8871j);
            ioVar.b();
        }
        if (this.f8872k != null && p()) {
            ioVar.a(A);
            ioVar.a(this.f8872k);
            ioVar.b();
        }
        if (this.f8873l != null && q()) {
            ioVar.a(B);
            ioVar.a(this.f8873l);
            ioVar.b();
        }
        if (this.f8874m != null && s()) {
            ioVar.a(C);
            ioVar.a(this.f8874m);
            ioVar.b();
        }
        if (t()) {
            ioVar.a(D);
            ioVar.a(this.n);
            ioVar.b();
        }
        if (u()) {
            ioVar.a(E);
            ioVar.a(this.o);
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public void b(boolean z2) {
        this.F.set(0, z2);
    }

    public hq c(String str) {
        this.f8866e = str;
        return this;
    }

    public void c(boolean z2) {
        this.F.set(1, z2);
    }

    public boolean c() {
        return this.b != null;
    }

    public hq d(String str) {
        this.f8870i = str;
        return this;
    }

    public String d() {
        return this.f8864c;
    }

    public void d(boolean z2) {
        this.F.set(2, z2);
    }

    public boolean e() {
        return this.f8864c != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hq)) {
            return a((hq) obj);
        }
        return false;
    }

    public String f() {
        return this.f8865d;
    }

    public boolean g() {
        return this.f8865d != null;
    }

    public boolean h() {
        return this.f8866e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.F.get(0);
    }

    public boolean j() {
        return this.f8868g != null;
    }

    public Map<String, String> k() {
        return this.f8869h;
    }

    public boolean l() {
        return this.f8869h != null;
    }

    public String m() {
        return this.f8870i;
    }

    public boolean n() {
        return this.f8870i != null;
    }

    public boolean o() {
        return this.f8871j != null;
    }

    public boolean p() {
        return this.f8872k != null;
    }

    public boolean q() {
        return this.f8873l != null;
    }

    public byte[] r() {
        a(id.c(this.f8874m));
        return this.f8874m.array();
    }

    public boolean s() {
        return this.f8874m != null;
    }

    public boolean t() {
        return this.F.get(1);
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
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
        if (c()) {
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
        String str2 = this.f8864c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (g()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f8865d;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f8866e;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f8867f);
        if (j()) {
            sb.append(", ");
            sb.append("payload:");
            String str5 = this.f8868g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f8869h;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f8870i;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f8871j;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f8872k;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f8873l;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f8874m;
            if (byteBuffer == null) {
                sb.append("null");
            } else {
                id.a(byteBuffer, sb);
            }
        }
        if (t()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.n);
        }
        if (u()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.o);
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.F.get(2);
    }

    public void v() {
        if (this.f8864c != null) {
            return;
        }
        throw new ip("Required field 'id' was not present! Struct: " + toString());
    }
}
