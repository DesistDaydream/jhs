package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes3.dex */
public class gz implements ic<gz, Object>, Serializable, Cloneable {

    /* renamed from: d  reason: collision with root package name */
    private static final it f8738d = new it("NormalConfig");

    /* renamed from: e  reason: collision with root package name */
    private static final il f8739e = new il("", (byte) 8, 1);

    /* renamed from: f  reason: collision with root package name */
    private static final il f8740f = new il("", com.umeng.analytics.pro.cb.f7124m, 2);

    /* renamed from: g  reason: collision with root package name */
    private static final il f8741g = new il("", (byte) 8, 3);
    public int a;
    public List<hb> b;

    /* renamed from: c  reason: collision with root package name */
    public gw f8742c;

    /* renamed from: h  reason: collision with root package name */
    private BitSet f8743h = new BitSet(1);

    public int a() {
        return this.a;
    }

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
                if (b == 8) {
                    this.a = ioVar.s();
                    a(true);
                    ioVar.i();
                }
                ir.a(ioVar, b);
                ioVar.i();
            } else if (s != 2) {
                if (s == 3 && b == 8) {
                    this.f8742c = gw.a(ioVar.s());
                    ioVar.i();
                }
                ir.a(ioVar, b);
                ioVar.i();
            } else {
                if (b == 15) {
                    im l2 = ioVar.l();
                    this.b = new ArrayList(l2.b);
                    for (int i2 = 0; i2 < l2.b; i2++) {
                        hb hbVar = new hb();
                        hbVar.a(ioVar);
                        this.b.add(hbVar);
                    }
                    ioVar.m();
                    ioVar.i();
                }
                ir.a(ioVar, b);
                ioVar.i();
            }
        }
        ioVar.g();
        if (b()) {
            f();
            return;
        }
        throw new ip("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f8743h.set(0, z);
    }

    public boolean a(gz gzVar) {
        if (gzVar != null && this.a == gzVar.a) {
            boolean c2 = c();
            boolean c3 = gzVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.b.equals(gzVar.b))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = gzVar.e();
            if (e2 || e3) {
                return e2 && e3 && this.f8742c.equals(gzVar.f8742c);
            }
            return true;
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(gz gzVar) {
        int a;
        int a2;
        int a3;
        if (getClass().equals(gzVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gzVar.b()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!b() || (a3 = id.a(this.a, gzVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gzVar.c()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!c() || (a2 = id.a(this.b, gzVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gzVar.e()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!e() || (a = id.a(this.f8742c, gzVar.f8742c)) == 0) {
                        return 0;
                    }
                    return a;
                }
                return a2;
            }
            return a3;
        }
        return getClass().getName().compareTo(gzVar.getClass().getName());
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        f();
        ioVar.a(f8738d);
        ioVar.a(f8739e);
        ioVar.a(this.a);
        ioVar.b();
        if (this.b != null) {
            ioVar.a(f8740f);
            ioVar.a(new im((byte) 12, this.b.size()));
            for (hb hbVar : this.b) {
                hbVar.b(ioVar);
            }
            ioVar.e();
            ioVar.b();
        }
        if (this.f8742c != null && e()) {
            ioVar.a(f8741g);
            ioVar.a(this.f8742c.a());
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public boolean b() {
        return this.f8743h.get(0);
    }

    public boolean c() {
        return this.b != null;
    }

    public gw d() {
        return this.f8742c;
    }

    public boolean e() {
        return this.f8742c != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gz)) {
            return a((gz) obj);
        }
        return false;
    }

    public void f() {
        if (this.b != null) {
            return;
        }
        throw new ip("Required field 'configItems' was not present! Struct: " + toString());
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.a);
        sb.append(", ");
        sb.append("configItems:");
        List<hb> list = this.b;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            gw gwVar = this.f8742c;
            if (gwVar == null) {
                sb.append("null");
            } else {
                sb.append(gwVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
