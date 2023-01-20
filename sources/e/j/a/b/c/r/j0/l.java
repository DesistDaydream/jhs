package e.j.a.b.c.r.j0;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class l extends e.j.a.b.f.a.b implements k {
    public l() {
        super("com.google.android.gms.common.internal.service.ICommonCallbacks");
    }

    @Override // e.j.a.b.f.a.b
    public boolean b0(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            C(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
