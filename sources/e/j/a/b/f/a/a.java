package e.j.a.b.f.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public class a implements IInterface {
    private final IBinder a;
    private final String b;

    public a(IBinder iBinder, String str) {
        this.a = iBinder;
        this.b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }

    public final Parcel b0() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.b);
        return obtain;
    }

    public final Parcel c0(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.a.transact(i2, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e2) {
                obtain.recycle();
                throw e2;
            }
        } finally {
            parcel.recycle();
        }
    }

    public final void d0(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.a.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public final void e0(int i2, Parcel parcel) throws RemoteException {
        try {
            this.a.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
