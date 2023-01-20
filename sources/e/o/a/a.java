package e.o.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes2.dex */
public interface a extends IInterface {

    /* renamed from: e.o.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0403a implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // e.o.a.a
        public void p(Bundle bundle) {
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b extends Binder implements a {
        private static final String a = "com.mcs.aidl.IMcsSdkService";
        public static final int b = 1;

        /* renamed from: e.o.a.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0404a implements a {
            public static a b;
            private IBinder a;

            public C0404a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            public String b0() {
                return b.a;
            }

            @Override // e.o.a.a
            public void p(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.a);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.a.transact(1, obtain, obtain2, 0) || b.b0() == null) {
                        obtain2.readException();
                    } else {
                        b.b0().p(bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, a);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0404a(iBinder) : (a) queryLocalInterface;
        }

        public static a b0() {
            return C0404a.b;
        }

        public static boolean c0(a aVar) {
            if (C0404a.b != null || aVar == null) {
                return false;
            }
            C0404a.b = aVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 != 1) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(a);
                return true;
            }
            parcel.enforceInterface(a);
            p(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void p(Bundle bundle);
}
