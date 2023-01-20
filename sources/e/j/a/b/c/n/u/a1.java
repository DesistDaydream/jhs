package e.j.a.b.c.n.u;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import e.j.a.b.c.n.u.g;

/* loaded from: classes2.dex */
public abstract class a1 {
    private final int a;

    public a1(int i2) {
        this.a = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status a(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (e.j.a.b.c.x.v.d() && (remoteException instanceof TransactionTooLargeException)) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }

    public abstract void b(@NonNull Status status);

    public abstract void c(g.a<?> aVar) throws DeadObjectException;

    public abstract void d(@NonNull b0 b0Var, boolean z);

    public abstract void e(@NonNull RuntimeException runtimeException);
}
