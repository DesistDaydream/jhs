package h.p2.b0.g.t.l.b;

import h.k2.v.f0;

/* loaded from: classes3.dex */
public final class n<T> {
    private final T a;
    private final T b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final String f15525c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final h.p2.b0.g.t.g.b f15526d;

    public n(T t, T t2, @k.e.a.d String str, @k.e.a.d h.p2.b0.g.t.g.b bVar) {
        this.a = t;
        this.b = t2;
        this.f15525c = str;
        this.f15526d = bVar;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            return f0.g(this.a, nVar.a) && f0.g(this.b, nVar.b) && f0.g(this.f15525c, nVar.f15525c) && f0.g(this.f15526d, nVar.f15526d);
        }
        return false;
    }

    public int hashCode() {
        T t = this.a;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.b;
        return ((((hashCode + (t2 != null ? t2.hashCode() : 0)) * 31) + this.f15525c.hashCode()) * 31) + this.f15526d.hashCode();
    }

    @k.e.a.d
    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.a + ", expectedVersion=" + this.b + ", filePath=" + this.f15525c + ", classId=" + this.f15526d + ')';
    }
}
