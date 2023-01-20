package e.j.a.b.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import e.j.a.b.d.d;

/* loaded from: classes2.dex */
public final class j extends e.j.a.b.f.b.a implements i {
    public j(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // e.j.a.b.e.i
    public final int L() throws RemoteException {
        Parcel c0 = c0(6, b0());
        int readInt = c0.readInt();
        c0.recycle();
        return readInt;
    }

    @Override // e.j.a.b.e.i
    public final e.j.a.b.d.d Q(e.j.a.b.d.d dVar, String str, int i2) throws RemoteException {
        Parcel b0 = b0();
        e.j.a.b.f.b.c.c(b0, dVar);
        b0.writeString(str);
        b0.writeInt(i2);
        Parcel c0 = c0(2, b0);
        e.j.a.b.d.d b = d.a.b(c0.readStrongBinder());
        c0.recycle();
        return b;
    }

    @Override // e.j.a.b.e.i
    public final int T(e.j.a.b.d.d dVar, String str, boolean z) throws RemoteException {
        Parcel b0 = b0();
        e.j.a.b.f.b.c.c(b0, dVar);
        b0.writeString(str);
        e.j.a.b.f.b.c.a(b0, z);
        Parcel c0 = c0(5, b0);
        int readInt = c0.readInt();
        c0.recycle();
        return readInt;
    }

    @Override // e.j.a.b.e.i
    public final int W(e.j.a.b.d.d dVar, String str, boolean z) throws RemoteException {
        Parcel b0 = b0();
        e.j.a.b.f.b.c.c(b0, dVar);
        b0.writeString(str);
        e.j.a.b.f.b.c.a(b0, z);
        Parcel c0 = c0(3, b0);
        int readInt = c0.readInt();
        c0.recycle();
        return readInt;
    }

    @Override // e.j.a.b.e.i
    public final e.j.a.b.d.d X(e.j.a.b.d.d dVar, String str, int i2) throws RemoteException {
        Parcel b0 = b0();
        e.j.a.b.f.b.c.c(b0, dVar);
        b0.writeString(str);
        b0.writeInt(i2);
        Parcel c0 = c0(4, b0);
        e.j.a.b.d.d b = d.a.b(c0.readStrongBinder());
        c0.recycle();
        return b;
    }
}
