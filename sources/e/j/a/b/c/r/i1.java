package e.j.a.b.c.r;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import e.j.a.b.d.d;

/* loaded from: classes2.dex */
public final class i1 extends e.j.a.b.f.b.a implements g1 {
    public i1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // e.j.a.b.c.r.g1
    public final e.j.a.b.d.d Z() throws RemoteException {
        Parcel c0 = c0(1, b0());
        e.j.a.b.d.d b = d.a.b(c0.readStrongBinder());
        c0.recycle();
        return b;
    }

    @Override // e.j.a.b.c.r.g1
    public final int a0() throws RemoteException {
        Parcel c0 = c0(2, b0());
        int readInt = c0.readInt();
        c0.recycle();
        return readInt;
    }
}
