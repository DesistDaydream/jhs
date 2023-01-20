package e.j.d.f;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class s0 implements p0 {
    private final IBinder a;

    public s0(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }

    @Override // e.j.d.f.p0
    public final void s(Message message) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
        obtain.writeInt(1);
        message.writeToParcel(obtain, 0);
        try {
            this.a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
