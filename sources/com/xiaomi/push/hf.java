package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes3.dex */
public class hf implements ic<hf, Object>, Serializable, Cloneable {

    /* renamed from: g  reason: collision with root package name */
    private static final it f8791g = new it("Target");

    /* renamed from: h  reason: collision with root package name */
    private static final il f8792h = new il("", (byte) 10, 1);

    /* renamed from: i  reason: collision with root package name */
    private static final il f8793i = new il("", (byte) 11, 2);

    /* renamed from: j  reason: collision with root package name */
    private static final il f8794j = new il("", (byte) 11, 3);

    /* renamed from: k  reason: collision with root package name */
    private static final il f8795k = new il("", (byte) 11, 4);

    /* renamed from: l  reason: collision with root package name */
    private static final il f8796l = new il("", (byte) 2, 5);

    /* renamed from: m  reason: collision with root package name */
    private static final il f8797m = new il("", (byte) 11, 7);
    public String b;

    /* renamed from: f  reason: collision with root package name */
    public String f8801f;
    private BitSet n = new BitSet(2);
    public long a = 5;

    /* renamed from: c  reason: collision with root package name */
    public String f8798c = "xiaomi.com";

    /* renamed from: d  reason: collision with root package name */
    public String f8799d = "";

    /* renamed from: e  reason: collision with root package name */
    public boolean f8800e = false;

    @Override // com.xiaomi.push.ic
    public void a(io ioVar) {
        ioVar.f();
        while (true) {
            il h2 = ioVar.h();
            byte b = h2.b;
            if (b == 0) {
                break;
            }
            short s = h2.f9004c;
            if (s == 1) {
                if (b == 10) {
                    this.a = ioVar.t();
                    a(true);
                    ioVar.i();
                }
                ir.a(ioVar, b);
                ioVar.i();
            } else if (s == 2) {
                if (b == 11) {
                    this.b = ioVar.v();
                    ioVar.i();
                }
                ir.a(ioVar, b);
                ioVar.i();
            } else if (s == 3) {
                if (b == 11) {
                    this.f8798c = ioVar.v();
                    ioVar.i();
                }
                ir.a(ioVar, b);
                ioVar.i();
            } else if (s == 4) {
                if (b == 11) {
                    this.f8799d = ioVar.v();
                    ioVar.i();
                }
                ir.a(ioVar, b);
                ioVar.i();
            } else if (s != 5) {
                if (s == 7 && b == 11) {
                    this.f8801f = ioVar.v();
                    ioVar.i();
                }
                ir.a(ioVar, b);
                ioVar.i();
            } else {
                if (b == 2) {
                    this.f8800e = ioVar.p();
                    b(true);
                    ioVar.i();
                }
                ir.a(ioVar, b);
                ioVar.i();
            }
        }
        ioVar.g();
        if (a()) {
            g();
            return;
        }
        throw new ip("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.n.set(0, z);
    }

    public boolean a() {
        return this.n.get(0);
    }

    public boolean a(hf hfVar) {
        if (hfVar != null && this.a == hfVar.a) {
            boolean b = b();
            boolean b2 = hfVar.b();
            if ((b || b2) && !(b && b2 && this.b.equals(hfVar.b))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hfVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f8798c.equals(hfVar.f8798c))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hfVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f8799d.equals(hfVar.f8799d))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hfVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f8800e == hfVar.f8800e)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hfVar.f();
            if (f2 || f3) {
                return f2 && f3 && this.f8801f.equals(hfVar.f8801f);
            }
            return true;
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(hf hfVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        if (getClass().equals(hfVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hfVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a6 = id.a(this.a, hfVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hfVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a5 = id.a(this.b, hfVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hfVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a4 = id.a(this.f8798c, hfVar.f8798c)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hfVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a3 = id.a(this.f8799d, hfVar.f8799d)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hfVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a2 = id.a(this.f8800e, hfVar.f8800e)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hfVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a = id.a(this.f8801f, hfVar.f8801f)) == 0) {
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
        return getClass().getName().compareTo(hfVar.getClass().getName());
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        g();
        ioVar.a(f8791g);
        ioVar.a(f8792h);
        ioVar.a(this.a);
        ioVar.b();
        if (this.b != null) {
            ioVar.a(f8793i);
            ioVar.a(this.b);
            ioVar.b();
        }
        if (this.f8798c != null && c()) {
            ioVar.a(f8794j);
            ioVar.a(this.f8798c);
            ioVar.b();
        }
        if (this.f8799d != null && d()) {
            ioVar.a(f8795k);
            ioVar.a(this.f8799d);
            ioVar.b();
        }
        if (e()) {
            ioVar.a(f8796l);
            ioVar.a(this.f8800e);
            ioVar.b();
        }
        if (this.f8801f != null && f()) {
            ioVar.a(f8797m);
            ioVar.a(this.f8801f);
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public void b(boolean z) {
        this.n.set(1, z);
    }

    public boolean b() {
        return this.b != null;
    }

    public boolean c() {
        return this.f8798c != null;
    }

    public boolean d() {
        return this.f8799d != null;
    }

    public boolean e() {
        return this.n.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hf)) {
            return a((hf) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f8801f != null;
    }

    public void g() {
        if (this.b != null) {
            return;
        }
        throw new ip("Required field 'userId' was not present! Struct: " + toString());
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.a);
        sb.append(", ");
        sb.append("userId:");
        String str = this.b;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            String str2 = this.f8798c;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            String str3 = this.f8799d;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f8800e);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            String str4 = this.f8801f;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
