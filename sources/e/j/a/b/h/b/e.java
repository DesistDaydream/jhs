package e.j.a.b.h.b;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.zaa;
import com.google.android.gms.signin.internal.zaj;

/* loaded from: classes2.dex */
public abstract class e extends e.j.a.b.f.a.b implements d {
    public e() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // e.j.a.b.f.a.b
    public boolean b0(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 3) {
            r((ConnectionResult) e.j.a.b.f.a.c.b(parcel, ConnectionResult.CREATOR), (zaa) e.j.a.b.f.a.c.b(parcel, zaa.CREATOR));
        } else if (i2 == 4) {
            f((Status) e.j.a.b.f.a.c.b(parcel, Status.CREATOR));
        } else if (i2 == 6) {
            h((Status) e.j.a.b.f.a.c.b(parcel, Status.CREATOR));
        } else if (i2 == 7) {
            i((Status) e.j.a.b.f.a.c.b(parcel, Status.CREATOR), (GoogleSignInAccount) e.j.a.b.f.a.c.b(parcel, GoogleSignInAccount.CREATOR));
        } else if (i2 != 8) {
            return false;
        } else {
            e((zaj) e.j.a.b.f.a.c.b(parcel, zaj.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
