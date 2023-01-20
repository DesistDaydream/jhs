package e.j.a.b.c.n.u;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public interface i extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends e.j.a.b.f.a.b implements i {

        /* renamed from: e.j.a.b.c.n.u.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0337a extends e.j.a.b.f.a.a implements i {
            public C0337a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.api.internal.IStatusCallback");
            }

            @Override // e.j.a.b.c.n.u.i
            public final void n(Status status) throws RemoteException {
                Parcel b0 = b0();
                e.j.a.b.f.a.c.d(b0, status);
                e0(1, b0);
            }
        }

        public a() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        public static i c0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
            if (queryLocalInterface instanceof i) {
                return (i) queryLocalInterface;
            }
            return new C0337a(iBinder);
        }

        @Override // e.j.a.b.f.a.b
        public boolean b0(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                n((Status) e.j.a.b.f.a.c.b(parcel, Status.CREATOR));
                return true;
            }
            return false;
        }
    }

    void n(Status status) throws RemoteException;
}
