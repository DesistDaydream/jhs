package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class gt implements ic<gt, Object>, Serializable, Cloneable {
    private static final it b = new it("ClientUploadData");

    /* renamed from: c */
    private static final il f8703c = new il("", com.umeng.analytics.pro.cb.f7124m, 1);
    public List<gu> a;

    public int a() {
        List<gu> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void a(gu guVar) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(guVar);
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
                    gu guVar = new gu();
                    guVar.a(ioVar);
                    this.a.add(guVar);
                }
                ioVar.m();
            } else {
                ir.a(ioVar, b2);
            }
            ioVar.i();
        }
    }

    public boolean a(gt gtVar) {
        if (gtVar == null) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = gtVar.b();
        if (b2 || b3) {
            return b2 && b3 && this.a.equals(gtVar.a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(gt gtVar) {
        int a;
        if (getClass().equals(gtVar.getClass())) {
            int compareTo = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gtVar.b()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!b() || (a = id.a(this.a, gtVar.a)) == 0) {
                return 0;
            }
            return a;
        }
        return getClass().getName().compareTo(gtVar.getClass().getName());
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        c();
        ioVar.a(b);
        if (this.a != null) {
            ioVar.a(f8703c);
            ioVar.a(new im((byte) 12, this.a.size()));
            for (gu guVar : this.a) {
                guVar.b(ioVar);
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
        throw new ip("Required field 'uploadDataItems' was not present! Struct: " + toString());
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gt)) {
            return a((gt) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        List<gu> list = this.a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
