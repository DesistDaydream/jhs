package e.j.a.b.c.r.j0;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class n extends e.j.a.b.f.a.a implements m {
    public n(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    @Override // e.j.a.b.c.r.j0.m
    public final void d(k kVar) throws RemoteException {
        Parcel b0 = b0();
        e.j.a.b.f.a.c.c(b0, kVar);
        e0(1, b0);
    }
}
