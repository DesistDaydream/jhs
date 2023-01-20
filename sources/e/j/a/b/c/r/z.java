package e.j.a.b.c.r;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class z {
    private static final b a = new s0();

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public interface a<R extends e.j.a.b.c.n.p, T> {
        @e.j.a.b.c.m.a
        T a(R r);
    }

    /* loaded from: classes2.dex */
    public interface b {
        ApiException a(Status status);
    }

    @e.j.a.b.c.m.a
    public static <R extends e.j.a.b.c.n.p, T extends e.j.a.b.c.n.o<R>> e.j.a.b.j.k<T> a(e.j.a.b.c.n.k<R> kVar, T t) {
        return b(kVar, new u0(t));
    }

    @e.j.a.b.c.m.a
    public static <R extends e.j.a.b.c.n.p, T> e.j.a.b.j.k<T> b(e.j.a.b.c.n.k<R> kVar, a<R, T> aVar) {
        b bVar = a;
        e.j.a.b.j.l lVar = new e.j.a.b.j.l();
        kVar.b(new t0(kVar, lVar, aVar, bVar));
        return lVar.a();
    }

    @e.j.a.b.c.m.a
    public static <R extends e.j.a.b.c.n.p> e.j.a.b.j.k<Void> c(e.j.a.b.c.n.k<R> kVar) {
        return b(kVar, new v0());
    }
}
