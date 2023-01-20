package com.tencent.android.tpush.rpc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.android.tpush.rpc.b;

/* loaded from: classes3.dex */
public interface a extends IInterface {
    void a();

    void a(String str, b bVar);

    void b();

    /* renamed from: com.tencent.android.tpush.rpc.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractBinderC0223a extends Binder implements a {
        public AbstractBinderC0223a() {
            attachInterface(this, "com.tencent.android.tpush.rpc.ITask");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.android.tpush.rpc.ITask");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0224a(iBinder);
        }

        public static a c() {
            return C0224a.a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("com.tencent.android.tpush.rpc.ITask");
                a();
                parcel2.writeNoException();
                return true;
            } else if (i2 == 2) {
                parcel.enforceInterface("com.tencent.android.tpush.rpc.ITask");
                b();
                parcel2.writeNoException();
                return true;
            } else if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.tencent.android.tpush.rpc.ITask");
                return true;
            } else {
                parcel.enforceInterface("com.tencent.android.tpush.rpc.ITask");
                a(parcel.readString(), b.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
        }

        /* renamed from: com.tencent.android.tpush.rpc.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0224a implements a {
            public static a a;
            private IBinder b;

            public C0224a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.tencent.android.tpush.rpc.a
            public void a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.android.tpush.rpc.ITask");
                    if (!this.b.transact(1, obtain, obtain2, 0) && AbstractBinderC0223a.c() != null) {
                        AbstractBinderC0223a.c().a();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.tencent.android.tpush.rpc.a
            public void b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.android.tpush.rpc.ITask");
                    if (!this.b.transact(2, obtain, obtain2, 0) && AbstractBinderC0223a.c() != null) {
                        AbstractBinderC0223a.c().b();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.android.tpush.rpc.a
            public void a(String str, b bVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.android.tpush.rpc.ITask");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (!this.b.transact(3, obtain, obtain2, 0) && AbstractBinderC0223a.c() != null) {
                        AbstractBinderC0223a.c().a(str, bVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
