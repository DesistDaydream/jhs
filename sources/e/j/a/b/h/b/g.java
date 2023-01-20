package e.j.a.b.h.b;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.signin.internal.zah;
import e.j.a.b.c.r.q;

/* loaded from: classes2.dex */
public final class g extends e.j.a.b.f.a.a implements f {
    public g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // e.j.a.b.h.b.f
    public final void E(q qVar, int i2, boolean z) throws RemoteException {
        Parcel b0 = b0();
        e.j.a.b.f.a.c.c(b0, qVar);
        b0.writeInt(i2);
        e.j.a.b.f.a.c.a(b0, z);
        d0(9, b0);
    }

    @Override // e.j.a.b.h.b.f
    public final void R(zah zahVar, d dVar) throws RemoteException {
        Parcel b0 = b0();
        e.j.a.b.f.a.c.d(b0, zahVar);
        e.j.a.b.f.a.c.c(b0, dVar);
        d0(12, b0);
    }

    @Override // e.j.a.b.h.b.f
    public final void t(int i2) throws RemoteException {
        Parcel b0 = b0();
        b0.writeInt(i2);
        d0(7, b0);
    }
}
