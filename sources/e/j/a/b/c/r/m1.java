package e.j.a.b.c.r;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzk;

/* loaded from: classes2.dex */
public final class m1 extends e.j.a.b.f.b.a implements k1 {
    public m1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // e.j.a.b.c.r.k1
    public final boolean m(zzk zzkVar, e.j.a.b.d.d dVar) throws RemoteException {
        Parcel b0 = b0();
        e.j.a.b.f.b.c.d(b0, zzkVar);
        e.j.a.b.f.b.c.c(b0, dVar);
        Parcel c0 = c0(5, b0);
        boolean e2 = e.j.a.b.f.b.c.e(c0);
        c0.recycle();
        return e2;
    }
}
