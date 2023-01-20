package e.j.a.b.c.n.u;

import android.os.RemoteException;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.a.b;
import e.j.a.b.c.n.u.l;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public abstract class y<A extends a.b, L> {
    private final l.a<L> a;

    @e.j.a.b.c.m.a
    public y(l.a<L> aVar) {
        this.a = aVar;
    }

    @e.j.a.b.c.m.a
    public l.a<L> a() {
        return this.a;
    }

    @e.j.a.b.c.m.a
    public abstract void b(A a, e.j.a.b.j.l<Boolean> lVar) throws RemoteException;
}
