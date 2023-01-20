package com.bytedance.pangle;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface c extends IInterface {
    boolean a(String str);

    boolean a(String str, String str2);

    int b(String str);

    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements c {
        public a() {
            attachInterface(this, "com.bytedance.pangle.IPackageManager");
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IPackageManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C0073a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean a = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(a ? 1 : 0);
                return true;
            } else if (i2 == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                int b = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(b);
                return true;
            } else if (i2 != 3) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.bytedance.pangle.IPackageManager");
                return true;
            } else {
                parcel.enforceInterface("com.bytedance.pangle.IPackageManager");
                boolean a2 = a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(a2 ? 1 : 0);
                return true;
            }
        }

        public static c a() {
            return C0073a.a;
        }

        /* renamed from: com.bytedance.pangle.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0073a implements c {
            public static c a;
            private IBinder b;

            public C0073a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.bytedance.pangle.c
            public final boolean a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    if (!this.b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.b;
            }

            @Override // com.bytedance.pangle.c
            public final int b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    if (!this.b.transact(2, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.c
            public final boolean a(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IPackageManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.b.transact(3, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
