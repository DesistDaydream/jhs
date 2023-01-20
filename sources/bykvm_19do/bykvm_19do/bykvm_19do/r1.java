package bykvm_19do.bykvm_19do.bykvm_19do;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface r1 extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements r1 {

        /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.r1$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0013a implements r1 {
            private IBinder a;

            public C0013a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_19do.r1
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
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

        public static r1 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof r1)) ? new C0013a(iBinder) : (r1) queryLocalInterface;
        }
    }

    String a();
}
