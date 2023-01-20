package k.c.a;

/* loaded from: classes4.dex */
public final class p {
    public final Object a;
    public final n b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f16296c = true;

    public p(Object obj, n nVar) {
        this.a = obj;
        this.b = nVar;
    }

    public boolean equals(Object obj) {
        if (obj instanceof p) {
            p pVar = (p) obj;
            return this.a == pVar.a && this.b.equals(pVar.b);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() + this.b.f16282f.hashCode();
    }
}
