package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class eg implements ic<eg, Object>, Serializable, Cloneable {

    /* renamed from: d */
    private static final it f8513d = new it("StatsEvents");

    /* renamed from: e */
    private static final il f8514e = new il("", (byte) 11, 1);

    /* renamed from: f */
    private static final il f8515f = new il("", (byte) 11, 2);

    /* renamed from: g */
    private static final il f8516g = new il("", com.umeng.analytics.pro.cb.f7124m, 3);
    public String a;
    public String b;

    /* renamed from: c */
    public List<ef> f8517c;

    public eg() {
    }

    public eg(String str, List<ef> list) {
        this();
        this.a = str;
        this.f8517c = list;
    }

    public eg a(String str) {
        this.b = str;
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
                d();
                return;
            }
            short s = h2.f9004c;
            if (s == 1) {
                if (b == 11) {
                    this.a = ioVar.v();
                    ioVar.i();
                }
                ir.a(ioVar, b);
                ioVar.i();
            } else if (s != 2) {
                if (s == 3 && b == 15) {
                    im l2 = ioVar.l();
                    this.f8517c = new ArrayList(l2.b);
                    for (int i2 = 0; i2 < l2.b; i2++) {
                        ef efVar = new ef();
                        efVar.a(ioVar);
                        this.f8517c.add(efVar);
                    }
                    ioVar.m();
                    ioVar.i();
                }
                ir.a(ioVar, b);
                ioVar.i();
            } else {
                if (b == 11) {
                    this.b = ioVar.v();
                    ioVar.i();
                }
                ir.a(ioVar, b);
                ioVar.i();
            }
        }
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(eg egVar) {
        if (egVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = egVar.a();
        if ((a || a2) && !(a && a2 && this.a.equals(egVar.a))) {
            return false;
        }
        boolean b = b();
        boolean b2 = egVar.b();
        if ((b || b2) && !(b && b2 && this.b.equals(egVar.b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = egVar.c();
        if (c2 || c3) {
            return c2 && c3 && this.f8517c.equals(egVar.f8517c);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(eg egVar) {
        int a;
        int a2;
        int a3;
        if (getClass().equals(egVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(egVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a3 = id.a(this.a, egVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(egVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a2 = id.a(this.b, egVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(egVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a = id.a(this.f8517c, egVar.f8517c)) == 0) {
                        return 0;
                    }
                    return a;
                }
                return a2;
            }
            return a3;
        }
        return getClass().getName().compareTo(egVar.getClass().getName());
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        d();
        ioVar.a(f8513d);
        if (this.a != null) {
            ioVar.a(f8514e);
            ioVar.a(this.a);
            ioVar.b();
        }
        if (this.b != null && b()) {
            ioVar.a(f8515f);
            ioVar.a(this.b);
            ioVar.b();
        }
        if (this.f8517c != null) {
            ioVar.a(f8516g);
            ioVar.a(new im((byte) 12, this.f8517c.size()));
            for (ef efVar : this.f8517c) {
                efVar.b(ioVar);
            }
            ioVar.e();
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public boolean c() {
        return this.f8517c != null;
    }

    public void d() {
        if (this.a == null) {
            throw new ip("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.f8517c != null) {
        } else {
            throw new ip("Required field 'events' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof eg)) {
            return a((eg) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            String str2 = this.b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("events:");
        List<ef> list = this.f8517c;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
