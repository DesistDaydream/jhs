package e.j.a.b.c.r;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ResolveAccountResponse;

/* loaded from: classes2.dex */
public interface u extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends e.j.a.b.f.a.b implements u {

        /* renamed from: e.j.a.b.c.r.u$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0343a extends e.j.a.b.f.a.a implements u {
            public C0343a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IResolveAccountCallbacks");
            }

            @Override // e.j.a.b.c.r.u
            public void Y(ResolveAccountResponse resolveAccountResponse) throws RemoteException {
                Parcel b0 = b0();
                e.j.a.b.f.a.c.d(b0, resolveAccountResponse);
                d0(2, b0);
            }
        }

        public a() {
            super("com.google.android.gms.common.internal.IResolveAccountCallbacks");
        }

        public static u c0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
            if (queryLocalInterface instanceof u) {
                return (u) queryLocalInterface;
            }
            return new C0343a(iBinder);
        }

        @Override // e.j.a.b.f.a.b
        public boolean b0(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 2) {
                Y((ResolveAccountResponse) e.j.a.b.f.a.c.b(parcel, ResolveAccountResponse.CREATOR));
                parcel2.writeNoException();
                return true;
            }
            return false;
        }
    }

    void Y(ResolveAccountResponse resolveAccountResponse) throws RemoteException;
}
