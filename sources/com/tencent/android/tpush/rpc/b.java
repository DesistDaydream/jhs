package com.tencent.android.tpush.rpc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface b extends IInterface {

    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements b {

        /* renamed from: com.tencent.android.tpush.rpc.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0225a implements b {
            public static b a;
            private IBinder b;

            public C0225a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.tencent.android.tpush.rpc.b
            public void a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.android.tpush.rpc.ITaskCallback");
                    if (!this.b.transact(1, obtain, obtain2, 0) && a.b() != null) {
                        a.b().a();
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
        }

        public a() {
            attachInterface(this, "com.tencent.android.tpush.rpc.ITaskCallback");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.android.tpush.rpc.ITaskCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C0225a(iBinder);
        }

        public static b b() {
            return C0225a.a;
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
                parcel2.writeString("com.tencent.android.tpush.rpc.ITaskCallback");
                return true;
            }
            parcel.enforceInterface("com.tencent.android.tpush.rpc.ITaskCallback");
            a();
            parcel2.writeNoException();
            return true;
        }
    }

    void a();
}
