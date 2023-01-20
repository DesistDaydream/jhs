package e.j.a.b.h.b;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.zaa;
import com.google.android.gms.signin.internal.zaj;

/* loaded from: classes2.dex */
public interface d extends IInterface {
    void e(zaj zajVar) throws RemoteException;

    void f(Status status) throws RemoteException;

    void h(Status status) throws RemoteException;

    void i(Status status, GoogleSignInAccount googleSignInAccount) throws RemoteException;

    void r(ConnectionResult connectionResult, zaa zaaVar) throws RemoteException;
}
