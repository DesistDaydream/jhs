package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class hk implements ic<hk, Object>, Serializable, Cloneable {
    private static final it b = new it("XmPushActionCollectData");

    /* renamed from: c  reason: collision with root package name */
    private static final il f8828c = new il("", com.umeng.analytics.pro.cb.f7124m, 1);
    public List<gy> a;

    public hk a(List<gy> list) {
        this.a = list;
        return this;
    }

    @Override // com.xiaomi.push.ic
    public void a(io ioVar) {
        ioVar.f();
        while (true) {
            il h2 = ioVar.h();
            byte b2 = h2.b;
            if (b2 == 0) {
                ioVar.g();
                b();
                return;
            }
            if (h2.f9004c == 1 && b2 == 15) {
                im l2 = ioVar.l();
                this.a = new ArrayList(l2.b);
                for (int i2 = 0; i2 < l2.b; i2++) {
                    gy gyVar = new gy();
                    gyVar.a(ioVar);
                    this.a.add(gyVar);
                }
                ioVar.m();
            } else {
                ir.a(ioVar, b2);
            }
            ioVar.i();
        }
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(hk hkVar) {
        if (hkVar == null) {
            return false;
        }
        boolean a = a();
        boolean a2 = hkVar.a();
        if (a || a2) {
            return a && a2 && this.a.equals(hkVar.a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(hk hkVar) {
        int a;
        if (getClass().equals(hkVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hkVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a = id.a(this.a, hkVar.a)) == 0) {
                return 0;
            }
            return a;
        }
        return getClass().getName().compareTo(hkVar.getClass().getName());
    }

    public void b() {
        if (this.a != null) {
            return;
        }
        throw new ip("Required field 'dataCollectionItems' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        b();
        ioVar.a(b);
        if (this.a != null) {
            ioVar.a(f8828c);
            ioVar.a(new im((byte) 12, this.a.size()));
            for (gy gyVar : this.a) {
                gyVar.b(ioVar);
            }
            ioVar.e();
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hk)) {
            return a((hk) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<gy> list = this.a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }
}
