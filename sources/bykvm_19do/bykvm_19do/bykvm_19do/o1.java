package bykvm_19do.bykvm_19do.bykvm_19do;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface o1 extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements o1 {

        /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.o1$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0010a implements o1 {
            private IBinder a;

            public C0010a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_19do.o1
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
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

        public static o1 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof o1)) ? new C0010a(iBinder) : (o1) queryLocalInterface;
        }
    }

    String a();
}
