package e.j.f.u.b0.g;

/* loaded from: classes2.dex */
public final class b {
    private final boolean a;
    private final e.j.f.u.b0.b b;

    /* renamed from: c  reason: collision with root package name */
    private final e.j.f.u.b0.b f11588c;

    /* renamed from: d  reason: collision with root package name */
    private final e.j.f.u.b0.c f11589d;

    public b(e.j.f.u.b0.b bVar, e.j.f.u.b0.b bVar2, e.j.f.u.b0.c cVar, boolean z) {
        this.b = bVar;
        this.f11588c = bVar2;
        this.f11589d = cVar;
        this.a = z;
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public e.j.f.u.b0.c b() {
        return this.f11589d;
    }

    public e.j.f.u.b0.b c() {
        return this.b;
    }

    public e.j.f.u.b0.b d() {
        return this.f11588c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            return a(this.b, bVar.b) && a(this.f11588c, bVar.f11588c) && a(this.f11589d, bVar.f11589d);
        }
        return false;
    }

    public boolean f() {
        return this.a;
    }

    public boolean g() {
        return this.f11588c == null;
    }

    public int hashCode() {
        return (e(this.b) ^ e(this.f11588c)) ^ e(this.f11589d);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.b);
        sb.append(" , ");
        sb.append(this.f11588c);
        sb.append(" : ");
        e.j.f.u.b0.c cVar = this.f11589d;
        sb.append(cVar == null ? "null" : Integer.valueOf(cVar.c()));
        sb.append(" ]");
        return sb.toString();
    }
}
