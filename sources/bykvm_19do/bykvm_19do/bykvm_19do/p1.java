package bykvm_19do.bykvm_19do.bykvm_19do;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface p1 extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements p1 {

        /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.p1$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0011a implements p1 {
            private IBinder a;

            public C0011a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_19do.p1
            public String b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static p1 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof p1)) ? new C0011a(iBinder) : (p1) queryLocalInterface;
        }
    }

    String b();
}
