package e.j.a.b.c.r;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ISignInButtonCreator;
import com.google.android.gms.common.internal.SignInButtonConfig;
import e.j.a.b.d.d;

/* loaded from: classes2.dex */
public final class r0 extends e.j.a.b.f.a.a implements ISignInButtonCreator {
    public r0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    @Override // com.google.android.gms.common.internal.ISignInButtonCreator
    public final e.j.a.b.d.d newSignInButton(e.j.a.b.d.d dVar, int i2, int i3) throws RemoteException {
        Parcel b0 = b0();
        e.j.a.b.f.a.c.c(b0, dVar);
        b0.writeInt(i2);
        b0.writeInt(i3);
        Parcel c0 = c0(1, b0);
        e.j.a.b.d.d b = d.a.b(c0.readStrongBinder());
        c0.recycle();
        return b;
    }

    @Override // com.google.android.gms.common.internal.ISignInButtonCreator
    public final e.j.a.b.d.d newSignInButtonFromConfig(e.j.a.b.d.d dVar, SignInButtonConfig signInButtonConfig) throws RemoteException {
        Parcel b0 = b0();
        e.j.a.b.f.a.c.c(b0, dVar);
        e.j.a.b.f.a.c.d(b0, signInButtonConfig);
        Parcel c0 = c0(2, b0);
        e.j.a.b.d.d b = d.a.b(c0.readStrongBinder());
        c0.recycle();
        return b;
    }
}
