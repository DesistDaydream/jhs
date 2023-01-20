package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes3.dex */
public class hj implements ic<hj, Object>, Serializable, Cloneable {

    /* renamed from: c  reason: collision with root package name */
    private static final it f8824c = new it("XmPushActionCheckClientInfo");

    /* renamed from: d  reason: collision with root package name */
    private static final il f8825d = new il("", (byte) 8, 1);

    /* renamed from: e  reason: collision with root package name */
    private static final il f8826e = new il("", (byte) 8, 2);
    public int a;
    public int b;

    /* renamed from: f  reason: collision with root package name */
    private BitSet f8827f = new BitSet(2);

    public hj a(int i2) {
        this.a = i2;
        a(true);
        return this;
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
            if (s != 1) {
                if (s == 2 && b == 8) {
                    this.b = ioVar.s();
                    b(true);
                    ioVar.i();
                }
                ir.a(ioVar, b);
                ioVar.i();
            } else {
                if (b == 8) {
                    this.a = ioVar.s();
                    a(true);
                    ioVar.i();
                }
                ir.a(ioVar, b);
                ioVar.i();
            }
        }
        ioVar.g();
        if (!a()) {
            throw new ip("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
        } else if (b()) {
            c();
        } else {
            throw new ip("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a(boolean z) {
        this.f8827f.set(0, z);
    }

    public boolean a() {
        return this.f8827f.get(0);
    }

    public boolean a(hj hjVar) {
        return hjVar != null && this.a == hjVar.a && this.b == hjVar.b;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(hj hjVar) {
        int a;
        int a2;
        if (getClass().equals(hjVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(hjVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a2 = id.a(this.a, hjVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hjVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a = id.a(this.b, hjVar.b)) == 0) {
                    return 0;
                }
                return a;
            }
            return a2;
        }
        return getClass().getName().compareTo(hjVar.getClass().getName());
    }

    public hj b(int i2) {
        this.b = i2;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        c();
        ioVar.a(f8824c);
        ioVar.a(f8825d);
        ioVar.a(this.a);
        ioVar.b();
        ioVar.a(f8826e);
        ioVar.a(this.b);
        ioVar.b();
        ioVar.c();
        ioVar.a();
    }

    public void b(boolean z) {
        this.f8827f.set(1, z);
    }

    public boolean b() {
        return this.f8827f.get(1);
    }

    public void c() {
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hj)) {
            return a((hj) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.a + ", pluginConfigVersion:" + this.b + ")";
    }
}
