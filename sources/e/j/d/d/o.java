package e.j.d.d;

import e.j.a.b.c.r.a0;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public final class o {
    private final Class<?> a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11220c;

    private o(Class<?> cls, int i2, int i3) {
        this.a = (Class) a0.l(cls, "Null dependency anInterface.");
        this.b = i2;
        this.f11220c = i3;
    }

    @e.j.a.b.c.m.a
    public static o e(Class<?> cls) {
        return new o(cls, 0, 0);
    }

    @e.j.a.b.c.m.a
    public static o f(Class<?> cls) {
        return new o(cls, 0, 1);
    }

    @e.j.a.b.c.m.a
    public static o g(Class<?> cls) {
        return new o(cls, 1, 0);
    }

    @e.j.a.b.c.m.a
    public static o h(Class<?> cls) {
        return new o(cls, 1, 1);
    }

    @e.j.a.b.c.m.a
    public static o i(Class<?> cls) {
        return new o(cls, 2, 0);
    }

    @e.j.a.b.c.m.a
    public static o j(Class<?> cls) {
        return new o(cls, 2, 1);
    }

    public Class<?> a() {
        return this.a;
    }

    public boolean b() {
        return this.f11220c == 0;
    }

    public boolean c() {
        return this.b == 1;
    }

    public boolean d() {
        return this.b == 2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof o) {
            o oVar = (o) obj;
            return this.a == oVar.a && this.b == oVar.b && this.f11220c == oVar.f11220c;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.f11220c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.a);
        sb.append(", type=");
        int i2 = this.b;
        sb.append(i2 == 1 ? "required" : i2 == 0 ? "optional" : "set");
        sb.append(", direct=");
        sb.append(this.f11220c == 0);
        sb.append("}");
        return sb.toString();
    }
}
