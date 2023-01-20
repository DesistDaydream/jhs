package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes3.dex */
public class gy implements ic<gy, Object>, Serializable, Cloneable {

    /* renamed from: d  reason: collision with root package name */
    private static final it f8732d = new it("DataCollectionItem");

    /* renamed from: e  reason: collision with root package name */
    private static final il f8733e = new il("", (byte) 10, 1);

    /* renamed from: f  reason: collision with root package name */
    private static final il f8734f = new il("", (byte) 8, 2);

    /* renamed from: g  reason: collision with root package name */
    private static final il f8735g = new il("", (byte) 11, 3);
    public long a;
    public gs b;

    /* renamed from: c  reason: collision with root package name */
    public String f8736c;

    /* renamed from: h  reason: collision with root package name */
    private BitSet f8737h = new BitSet(1);

    public gy a(long j2) {
        this.a = j2;
        a(true);
        return this;
    }

    public gy a(gs gsVar) {
        this.b = gsVar;
        return this;
    }

    public gy a(String str) {
        this.f8736c = str;
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
            if (s == 1) {
                if (b == 10) {
                    this.a = ioVar.t();
                    a(true);
                    ioVar.i();
                }
                ir.a(ioVar, b);
                ioVar.i();
            } else if (s != 2) {
                if (s == 3 && b == 11) {
                    this.f8736c = ioVar.v();
                    ioVar.i();
                }
                ir.a(ioVar, b);
                ioVar.i();
            } else {
                if (b == 8) {
                    this.b = gs.a(ioVar.s());
                    ioVar.i();
                }
                ir.a(ioVar, b);
                ioVar.i();
            }
        }
        ioVar.g();
        if (a()) {
            e();
            return;
        }
        throw new ip("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f8737h.set(0, z);
    }

    public boolean a() {
        return this.f8737h.get(0);
    }

    public boolean a(gy gyVar) {
        if (gyVar != null && this.a == gyVar.a) {
            boolean b = b();
            boolean b2 = gyVar.b();
            if ((b || b2) && !(b && b2 && this.b.equals(gyVar.b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = gyVar.d();
            if (d2 || d3) {
                return d2 && d3 && this.f8736c.equals(gyVar.f8736c);
            }
            return true;
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(gy gyVar) {
        int a;
        int a2;
        int a3;
        if (getClass().equals(gyVar.getClass())) {
            int compareTo = Boolean.valueOf(a()).compareTo(Boolean.valueOf(gyVar.a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!a() || (a3 = id.a(this.a, gyVar.a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gyVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a2 = id.a(this.b, gyVar.b)) == 0) {
                    int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gyVar.d()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!d() || (a = id.a(this.f8736c, gyVar.f8736c)) == 0) {
                        return 0;
                    }
                    return a;
                }
                return a2;
            }
            return a3;
        }
        return getClass().getName().compareTo(gyVar.getClass().getName());
    }

    @Override // com.xiaomi.push.ic
    public void b(io ioVar) {
        e();
        ioVar.a(f8732d);
        ioVar.a(f8733e);
        ioVar.a(this.a);
        ioVar.b();
        if (this.b != null) {
            ioVar.a(f8734f);
            ioVar.a(this.b.a());
            ioVar.b();
        }
        if (this.f8736c != null) {
            ioVar.a(f8735g);
            ioVar.a(this.f8736c);
            ioVar.b();
        }
        ioVar.c();
        ioVar.a();
    }

    public boolean b() {
        return this.b != null;
    }

    public String c() {
        return this.f8736c;
    }

    public boolean d() {
        return this.f8736c != null;
    }

    public void e() {
        if (this.b == null) {
            throw new ip("Required field 'collectionType' was not present! Struct: " + toString());
        } else if (this.f8736c != null) {
        } else {
            throw new ip("Required field 'content' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gy)) {
            return a((gy) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.a);
        sb.append(", ");
        sb.append("collectionType:");
        gs gsVar = this.b;
        if (gsVar == null) {
            sb.append("null");
        } else {
            sb.append(gsVar);
        }
        sb.append(", ");
        sb.append("content:");
        String str = this.f8736c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }
}
