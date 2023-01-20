package e.j.a.b.c.n.u;

import e.j.a.b.c.n.a;
import e.j.a.b.c.n.a.d;

/* loaded from: classes2.dex */
public final class z2<O extends a.d> {
    private final boolean a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final e.j.a.b.c.n.a<O> f10346c;

    /* renamed from: d  reason: collision with root package name */
    private final O f10347d;

    private z2(e.j.a.b.c.n.a<O> aVar, O o) {
        this.a = false;
        this.f10346c = aVar;
        this.f10347d = o;
        this.b = e.j.a.b.c.r.y.b(aVar, o);
    }

    public static <O extends a.d> z2<O> a(e.j.a.b.c.n.a<O> aVar) {
        return new z2<>(aVar);
    }

    public static <O extends a.d> z2<O> b(e.j.a.b.c.n.a<O> aVar, O o) {
        return new z2<>(aVar, o);
    }

    public final String c() {
        return this.f10346c.b();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof z2) {
            z2 z2Var = (z2) obj;
            return !this.a && !z2Var.a && e.j.a.b.c.r.y.a(this.f10346c, z2Var.f10346c) && e.j.a.b.c.r.y.a(this.f10347d, z2Var.f10347d);
        }
        return false;
    }

    public final int hashCode() {
        return this.b;
    }

    private z2(e.j.a.b.c.n.a<O> aVar) {
        this.a = true;
        this.f10346c = aVar;
        this.f10347d = null;
        this.b = System.identityHashCode(this);
    }
}
