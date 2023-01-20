package e.j.a.b.c.r;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzb;

/* loaded from: classes2.dex */
public final class j1 extends e.j.a.b.f.b.a implements s {
    public j1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // e.j.a.b.c.r.s
    public final void g(int i2, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel b0 = b0();
        b0.writeInt(i2);
        b0.writeStrongBinder(iBinder);
        e.j.a.b.f.b.c.d(b0, bundle);
        d0(1, b0);
    }

    @Override // e.j.a.b.c.r.s
    public final void o(int i2, IBinder iBinder, zzb zzbVar) throws RemoteException {
        Parcel b0 = b0();
        b0.writeInt(i2);
        b0.writeStrongBinder(iBinder);
        e.j.a.b.f.b.c.d(b0, zzbVar);
        d0(3, b0);
    }

    @Override // e.j.a.b.c.r.s
    public final void q(int i2, Bundle bundle) throws RemoteException {
        Parcel b0 = b0();
        b0.writeInt(i2);
        e.j.a.b.f.b.c.d(b0, bundle);
        d0(2, b0);
    }
}
