package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class hp implements ic<hp, Object>, Serializable, Cloneable {
    private static final it b = new it("XmPushActionNormalConfig");

    /* renamed from: c  reason: collision with root package name */
    private static final il f8863c = new il("", com.umeng.analytics.pro.cb.f7124m, 1);
    public List<gz> a;

    public List<gz> a() {
        return this.a;
    }

    @Override // com.xiaomi.push.ic
    public void a(io ioVar) {
        ioVar.f();
        while (true) {
            il h2 = ioVar.h();
            byte b2 = h2.b;
            if (b2 == 0) {
                ioVar.g();
                c();
                return;
            }
            if (h2.f9004c == 1 && b2 == 15) {
                im l2 = ioVar.l();
                this.a = new ArrayList(l2.b);
                for (int i2 = 0; i2 < l2.b; i2++) {
                    gz gzVar = new gz();
                    gzVar.a(ioVar);
                    this.a.add(gzVar);
                }
                ioVar.m();
            } else {
                ir.a(ioVar, b2);
            }
            ioVar.i();
        }
    }

    public boolean a(hp hpVar) {
        if (hpVar == null) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hpVar.b();
        if (b2 || b3) {
            return b2 && b3 && this.a.equals(hpVar.a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(hp hpVar) {
        int a;
        if (getClass().equals(hpVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hpVar.b()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!b() || (a = id.a(this.a, hpVar.a)) == 0) {
                return 0;
            }
            return a;
        }
        return getClass().getName().compareTo(hpVar.getClass().getName());
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        c();
        ioVar.a(b);
        if (this.a != null) {
            ioVar.a(f8863c);
            ioVar.a(new im((byte) 12, this.a.size()));
            for (gz gzVar : this.a) {
                gzVar.b(ioVar);
            }
            ioVar.e();
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public boolean b() {
        return this.a != null;
    }

    public void c() {
        if (this.a != null) {
            return;
        }
        throw new ip("Required field 'normalConfigs' was not present! Struct: " + toString());
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return a((hp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<gz> list = this.a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
