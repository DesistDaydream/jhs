package e.j.a.b.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import e.j.a.b.d.d;

/* loaded from: classes2.dex */
public final class l extends e.j.a.b.f.b.a implements k {
    public l(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    @Override // e.j.a.b.e.k
    public final e.j.a.b.d.d j(e.j.a.b.d.d dVar, String str, int i2, e.j.a.b.d.d dVar2) throws RemoteException {
        Parcel b0 = b0();
        e.j.a.b.f.b.c.c(b0, dVar);
        b0.writeString(str);
        b0.writeInt(i2);
        e.j.a.b.f.b.c.c(b0, dVar2);
        Parcel c0 = c0(2, b0);
        e.j.a.b.d.d b = d.a.b(c0.readStrongBinder());
        c0.recycle();
        return b;
    }

    @Override // e.j.a.b.e.k
    public final e.j.a.b.d.d k(e.j.a.b.d.d dVar, String str, int i2, e.j.a.b.d.d dVar2) throws RemoteException {
        Parcel b0 = b0();
        e.j.a.b.f.b.c.c(b0, dVar);
        b0.writeString(str);
        b0.writeInt(i2);
        e.j.a.b.f.b.c.c(b0, dVar2);
        Parcel c0 = c0(3, b0);
        e.j.a.b.d.d b = d.a.b(c0.readStrongBinder());
        c0.recycle();
        return b;
    }
}
