package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes3.dex */
public class ht implements ic<ht, Object>, Serializable, Cloneable {

    /* renamed from: h  reason: collision with root package name */
    private static final it f8897h = new it("XmPushActionSendFeedbackResult");

    /* renamed from: i  reason: collision with root package name */
    private static final il f8898i = new il("", (byte) 11, 1);

    /* renamed from: j  reason: collision with root package name */
    private static final il f8899j = new il("", (byte) 12, 2);

    /* renamed from: k  reason: collision with root package name */
    private static final il f8900k = new il("", (byte) 11, 3);

    /* renamed from: l  reason: collision with root package name */
    private static final il f8901l = new il("", (byte) 11, 4);

    /* renamed from: m  reason: collision with root package name */
    private static final il f8902m = new il("", (byte) 10, 6);
    private static final il n = new il("", (byte) 11, 7);
    private static final il o = new il("", (byte) 11, 8);
    public String a;
    public hf b;

    /* renamed from: c  reason: collision with root package name */
    public String f8903c;

    /* renamed from: d  reason: collision with root package name */
    public String f8904d;

    /* renamed from: e  reason: collision with root package name */
    public long f8905e;

    /* renamed from: f  reason: collision with root package name */
    public String f8906f;

    /* renamed from: g  reason: collision with root package name */
    public String f8907g;
    private BitSet p = new BitSet(1);

    @Override // com.xiaomi.push.ic
    public void a(io ioVar) {
        ioVar.f();
        while (true) {
            il h2 = ioVar.h();
            byte b = h2.b;
            if (b == 0) {
                ioVar.g();
                if (e()) {
                    h();
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
                        this.f8903c = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 4:
                    if (b == 11) {
                        this.f8904d = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 6:
                    if (b == 10) {
                        this.f8905e = ioVar.t();
                        a(true);
                        continue;
                        ioVar.i();
                    }
                    break;
                case 7:
                    if (b == 11) {
                        this.f8906f = ioVar.v();
                        continue;
                        ioVar.i();
                    }
                    break;
                case 8:
                    if (b == 11) {
                        this.f8907g = ioVar.v();
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
        this.p.set(0, z);
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(ht htVar) {
        if (htVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = htVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(htVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = htVar.b();
        if ((b || b2) && !(b && b2 && this.b.a(htVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = htVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f8903c.equals(htVar.f8903c))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = htVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f8904d.equals(htVar.f8904d))) || this.f8905e != htVar.f8905e) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = htVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f8906f.equals(htVar.f8906f))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = htVar.g();
        if (g2 || g3) {
            return g2 && g3 && this.f8907g.equals(htVar.f8907g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(ht htVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (getClass().equals(htVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(htVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a7 = id.a(this.a, htVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(htVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a6 = id.a(this.b, htVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(htVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a5 = id.a(this.f8903c, htVar.f8903c)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(htVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a4 = id.a(this.f8904d, htVar.f8904d)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(htVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a3 = id.a(this.f8905e, htVar.f8905e)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(htVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a2 = id.a(this.f8906f, htVar.f8906f)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(htVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a = id.a(this.f8907g, htVar.f8907g)) == 0) {
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
        return getClass().getName().compareTo(htVar.getClass().getName());
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        h();
        ioVar.a(f8897h);
        if (this.a != null && a()) {
            ioVar.a(f8898i);
            ioVar.a(this.a);
            ioVar.b();
        }
        if (this.b != null && b()) {
            ioVar.a(f8899j);
            this.b.b(ioVar);
            ioVar.b();
        }
        if (this.f8903c != null) {
            ioVar.a(f8900k);
            ioVar.a(this.f8903c);
            ioVar.b();
        }
        if (this.f8904d != null) {
            ioVar.a(f8901l);
            ioVar.a(this.f8904d);
            ioVar.b();
        }
        ioVar.a(f8902m);
        ioVar.a(this.f8905e);
        ioVar.b();
        if (this.f8906f != null && f()) {
            ioVar.a(n);
            ioVar.a(this.f8906f);
            ioVar.b();
        }
        if (this.f8907g != null && g()) {
            ioVar.a(o);
            ioVar.a(this.f8907g);
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public boolean c() {
        return this.f8903c != null;
    }

    public boolean d() {
        return this.f8904d != null;
    }

    public boolean e() {
        return this.p.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ht)) {
            return a((ht) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f8906f != null;
    }

    public boolean g() {
        return this.f8907g != null;
    }

    public void h() {
        if (this.f8903c == null) {
            throw new ip("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f8904d != null) {
        } else {
            throw new ip("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
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
        String str2 = this.f8903c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f8904d;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f8905e);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f8906f;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f8907g;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
