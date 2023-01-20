package e.j.a.b.c.r;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class h1 extends e.j.a.b.f.b.b implements g1 {
    public h1() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static g1 b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        if (queryLocalInterface instanceof g1) {
            return (g1) queryLocalInterface;
        }
        return new i1(iBinder);
    }

    @Override // e.j.a.b.f.b.b
    public final boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            e.j.a.b.d.d Z = Z();
            parcel2.writeNoException();
            e.j.a.b.f.b.c.c(parcel2, Z);
        } else if (i2 != 2) {
            return false;
        } else {
            int a0 = a0();
            parcel2.writeNoException();
            parcel2.writeInt(a0);
        }
        return true;
    }
}
