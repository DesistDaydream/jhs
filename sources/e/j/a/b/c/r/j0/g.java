package e.j.a.b.c.r.j0;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import e.j.a.b.c.n.u.d;

/* loaded from: classes2.dex */
public final class g extends b {
    private final d.b<Status> b;

    public g(d.b<Status> bVar) {
        this.b = bVar;
    }

    @Override // e.j.a.b.c.r.j0.b, e.j.a.b.c.r.j0.k
    public final void C(int i2) throws RemoteException {
        this.b.setResult(new Status(i2));
    }
}
