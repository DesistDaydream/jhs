package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

/* loaded from: classes3.dex */
public class hn implements ic<hn, Object>, Serializable, Cloneable {

    /* renamed from: i  reason: collision with root package name */
    private static final it f8851i = new it("XmPushActionContainer");

    /* renamed from: j  reason: collision with root package name */
    private static final il f8852j = new il("", (byte) 8, 1);

    /* renamed from: k  reason: collision with root package name */
    private static final il f8853k = new il("", (byte) 2, 2);

    /* renamed from: l  reason: collision with root package name */
    private static final il f8854l = new il("", (byte) 2, 3);

    /* renamed from: m  reason: collision with root package name */
    private static final il f8855m = new il("", (byte) 11, 4);
    private static final il n = new il("", (byte) 11, 5);
    private static final il o = new il("", (byte) 11, 6);
    private static final il p = new il("", (byte) 12, 7);
    private static final il q = new il("", (byte) 12, 8);
    public gq a;

    /* renamed from: d  reason: collision with root package name */
    public ByteBuffer f8857d;

    /* renamed from: e  reason: collision with root package name */
    public String f8858e;

    /* renamed from: f  reason: collision with root package name */
    public String f8859f;

    /* renamed from: g  reason: collision with root package name */
    public hf f8860g;

    /* renamed from: h  reason: collision with root package name */
    public hd f8861h;
    private BitSet r = new BitSet(2);
    public boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8856c = true;

    public gq a() {
        return this.a;
    }

    public hn a(gq gqVar) {
        this.a = gqVar;
        return this;
    }

    public hn a(hd hdVar) {
        this.f8861h = hdVar;
        return this;
    }

    public hn a(hf hfVar) {
        this.f8860g = hfVar;
        return this;
    }

    public hn a(String str) {
        this.f8858e = str;
        return this;
    }

    public hn a(ByteBuffer byteBuffer) {
        this.f8857d = byteBuffer;
        return this;
    }

    public hn a(boolean z) {
        this.b = z;
        b(true);
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
                if (!d()) {
                    throw new ip("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                } else if (e()) {
                    o();
                    return;
                } else {
                    throw new ip("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (h2.f9004c) {
                case 1:
                    if (b == 8) {
                        this.a = gq.a(ioVar.s());
                        continue;
                        ioVar.i();
                    }
                    break;
                case 2:
                    if (b == 2) {
                        this.b = ioVar.p();
                        b(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 3:
                    if (b == 2) {
                        this.f8856c = ioVar.p();
                        d(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 4:
                    if (b == 11) {
                        this.f8857d = ioVar.w();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 5:
                    if (b == 11) {
                        this.f8858e = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 6:
                    if (b == 11) {
                        this.f8859f = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 7:
                    if (b == 12) {
                        hf hfVar = new hf();
                        this.f8860g = hfVar;
                        hfVar.a(ioVar);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 8:
                    if (b == 12) {
                        hd hdVar = new hd();
                        this.f8861h = hdVar;
                        hdVar.a(ioVar);
                        continue;
                        ioVar.i();
                    }
                    break;
            }
            ir.a(ioVar, b);
            ioVar.i();
        }
    }

    public boolean a(hn hnVar) {
        if (hnVar == null) {
            return false;
        }
        boolean b = b();
        boolean b2 = hnVar.b();
        if (((!b && !b2) || (b && b2 && this.a.equals(hnVar.a))) && this.b == hnVar.b && this.f8856c == hnVar.f8856c) {
            boolean g2 = g();
            boolean g3 = hnVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f8857d.equals(hnVar.f8857d))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hnVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f8858e.equals(hnVar.f8858e))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hnVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f8859f.equals(hnVar.f8859f))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = hnVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.f8860g.a(hnVar.f8860g))) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = hnVar.n();
            if (n2 || n3) {
                return n2 && n3 && this.f8861h.a(hnVar.f8861h);
            }
            return true;
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(hn hnVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (getClass().equals(hnVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hnVar.b()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!b() || (a8 = id.a(this.a, hnVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hnVar.d()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!d() || (a7 = id.a(this.b, hnVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hnVar.e()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!e() || (a6 = id.a(this.f8856c, hnVar.f8856c)) == 0) {
                        int compareTo4 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hnVar.g()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!g() || (a5 = id.a(this.f8857d, hnVar.f8857d)) == 0) {
                            int compareTo5 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hnVar.i()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!i() || (a4 = id.a(this.f8858e, hnVar.f8858e)) == 0) {
                                int compareTo6 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hnVar.k()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!k() || (a3 = id.a(this.f8859f, hnVar.f8859f)) == 0) {
                                    int compareTo7 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hnVar.l()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!l() || (a2 = id.a(this.f8860g, hnVar.f8860g)) == 0) {
                                        int compareTo8 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hnVar.n()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!n() || (a = id.a(this.f8861h, hnVar.f8861h)) == 0) {
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
        return getClass().getName().compareTo(hnVar.getClass().getName());
    }

    public hn b(String str) {
        this.f8859f = str;
        return this;
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        o();
        ioVar.a(f8851i);
        if (this.a != null) {
            ioVar.a(f8852j);
            ioVar.a(this.a.a());
            ioVar.b();
        }
        ioVar.a(f8853k);
        ioVar.a(this.b);
        ioVar.b();
        ioVar.a(f8854l);
        ioVar.a(this.f8856c);
        ioVar.b();
        if (this.f8857d != null) {
            ioVar.a(f8855m);
            ioVar.a(this.f8857d);
            ioVar.b();
        }
        if (this.f8858e != null && i()) {
            ioVar.a(n);
            ioVar.a(this.f8858e);
            ioVar.b();
        }
        if (this.f8859f != null && k()) {
            ioVar.a(o);
            ioVar.a(this.f8859f);
            ioVar.b();
        }
        if (this.f8860g != null) {
            ioVar.a(p);
            this.f8860g.b(ioVar);
            ioVar.b();
        }
        if (this.f8861h != null && n()) {
            ioVar.a(q);
            this.f8861h.b(ioVar);
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public void b(boolean z) {
        this.r.set(0, z);
    }

    public boolean b() {
        return this.a != null;
    }

    public hn c(boolean z) {
        this.f8856c = z;
        d(true);
        return this;
    }

    public boolean c() {
        return this.b;
    }

    public void d(boolean z) {
        this.r.set(1, z);
    }

    public boolean d() {
        return this.r.get(0);
    }

    public boolean e() {
        return this.r.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hn)) {
            return a((hn) obj);
        }
        return false;
    }

    public byte[] f() {
        a(id.c(this.f8857d));
        return this.f8857d.array();
    }

    public boolean g() {
        return this.f8857d != null;
    }

    public String h() {
        return this.f8858e;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f8858e != null;
    }

    public String j() {
        return this.f8859f;
    }

    public boolean k() {
        return this.f8859f != null;
    }

    public boolean l() {
        return this.f8860g != null;
    }

    public hd m() {
        return this.f8861h;
    }

    public boolean n() {
        return this.f8861h != null;
    }

    public void o() {
        if (this.a == null) {
            throw new ip("Required field 'action' was not present! Struct: " + toString());
        } else if (this.f8857d == null) {
            throw new ip("Required field 'pushAction' was not present! Struct: " + toString());
        } else if (this.f8860g != null) {
        } else {
            throw new ip("Required field 'target' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        gq gqVar = this.a;
        if (gqVar == null) {
            sb.append("null");
        } else {
            sb.append(gqVar);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f8856c);
        if (i()) {
            sb.append(", ");
            sb.append("appid:");
            String str = this.f8858e;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("packageName:");
            String str2 = this.f8859f;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("target:");
        hf hfVar = this.f8860g;
        if (hfVar == null) {
            sb.append("null");
        } else {
            sb.append(hfVar);
        }
        if (n()) {
            sb.append(", ");
            sb.append("metaInfo:");
            hd hdVar = this.f8861h;
            if (hdVar == null) {
                sb.append("null");
            } else {
                sb.append(hdVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
