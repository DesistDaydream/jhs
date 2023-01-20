package e.j.a.b.c.n.u;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import e.j.a.b.c.n.u.g;

/* loaded from: classes2.dex */
public abstract class u2<T> extends a2 {
    public final e.j.a.b.j.l<T> b;

    public u2(int i2, e.j.a.b.j.l<T> lVar) {
        super(i2);
        this.b = lVar;
    }

    @Override // e.j.a.b.c.n.u.a1
    public void b(@NonNull Status status) {
        this.b.c(new ApiException(status));
    }

    @Override // e.j.a.b.c.n.u.a1
    public final void c(g.a<?> aVar) throws DeadObjectException {
        Status a;
        Status a2;
        try {
            i(aVar);
        } catch (DeadObjectException e2) {
            a2 = a1.a(e2);
            b(a2);
            throw e2;
        } catch (RemoteException e3) {
            a = a1.a(e3);
            b(a);
        } catch (RuntimeException e4) {
            e(e4);
        }
    }

    @Override // e.j.a.b.c.n.u.a1
    public void d(@NonNull b0 b0Var, boolean z) {
    }

    @Override // e.j.a.b.c.n.u.a1
    public void e(@NonNull RuntimeException runtimeException) {
        this.b.c(runtimeException);
    }

    public abstract void i(g.a<?> aVar) throws RemoteException;
}
