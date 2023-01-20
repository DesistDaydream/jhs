package bykvm_19do.bykvm_19do.bykvm_19do;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface n1 extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements n1 {

        /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.n1$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0009a implements n1 {
            private IBinder a;

            public C0009a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_19do.n1
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static n1 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof n1)) ? new C0009a(iBinder) : (n1) queryLocalInterface;
        }
    }

    String a();
}
