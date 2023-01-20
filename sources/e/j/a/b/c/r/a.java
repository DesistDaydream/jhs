package e.j.a.b.c.r;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import e.j.a.b.c.r.q;

/* loaded from: classes2.dex */
public class a extends q.a {
    @e.j.a.b.c.m.a
    public static Account c(q qVar) {
        if (qVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return qVar.getAccount();
            } catch (RemoteException unused) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // e.j.a.b.c.r.q
    public final Account getAccount() {
        throw new NoSuchMethodError();
    }
}
