package e.j.a.b.c.r;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public interface r extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends e.j.a.b.f.b.b implements r {

        /* renamed from: e.j.a.b.c.r.r$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0341a extends e.j.a.b.f.b.a implements r {
            public C0341a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.ICancelToken");
            }

            @Override // e.j.a.b.c.r.r
            public final void cancel() throws RemoteException {
                e0(2, b0());
            }
        }

        public a() {
            super("com.google.android.gms.common.internal.ICancelToken");
        }

        public static r b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
            if (queryLocalInterface instanceof r) {
                return (r) queryLocalInterface;
            }
            return new C0341a(iBinder);
        }
    }

    void cancel() throws RemoteException;
}
