package e.j.a.b.c.r;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzb;

/* loaded from: classes2.dex */
public interface s extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends e.j.a.b.f.b.b implements s {
        public a() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        @Override // e.j.a.b.f.b.b
        public final boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                g(parcel.readInt(), parcel.readStrongBinder(), (Bundle) e.j.a.b.f.b.c.b(parcel, Bundle.CREATOR));
            } else if (i2 == 2) {
                q(parcel.readInt(), (Bundle) e.j.a.b.f.b.c.b(parcel, Bundle.CREATOR));
            } else if (i2 != 3) {
                return false;
            } else {
                o(parcel.readInt(), parcel.readStrongBinder(), (zzb) e.j.a.b.f.b.c.b(parcel, zzb.CREATOR));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void g(int i2, IBinder iBinder, Bundle bundle) throws RemoteException;

    void o(int i2, IBinder iBinder, zzb zzbVar) throws RemoteException;

    void q(int i2, Bundle bundle) throws RemoteException;
}
