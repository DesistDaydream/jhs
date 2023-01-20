package com.bytedance.pangle;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.pangle.f;

/* loaded from: classes.dex */
public interface d extends IInterface {
    ComponentName a(Intent intent, String str);

    void a(f fVar);

    boolean a(Intent intent, f fVar, int i2, String str);

    boolean b(Intent intent, String str);

    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements d {
        public a() {
            attachInterface(this, "com.bytedance.pangle.IServiceManager");
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IServiceManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                return (d) queryLocalInterface;
            }
            return new C0075a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                ComponentName a = a(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(1);
                    a.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i2 == 2) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                boolean b = b(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(b ? 1 : 0);
                return true;
            } else if (i2 == 3) {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                boolean a2 = a(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, f.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(a2 ? 1 : 0);
                return true;
            } else if (i2 != 4) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.bytedance.pangle.IServiceManager");
                return true;
            } else {
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                a(f.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
        }

        public static d a() {
            return C0075a.a;
        }

        /* renamed from: com.bytedance.pangle.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0075a implements d {
            public static d a;
            private IBinder b;

            public C0075a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.bytedance.pangle.d
            public final ComponentName a(Intent intent, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (!this.b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(intent, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (ComponentName) ComponentName.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.b;
            }

            @Override // com.bytedance.pangle.d
            public final boolean b(Intent intent, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (!this.b.transact(2, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().b(intent, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.d
            public final boolean a(Intent intent, f fVar, int i2, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    if (!this.b.transact(3, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(intent, fVar, i2, str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.d
            public final void a(f fVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    obtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                    if (!this.b.transact(4, obtain, obtain2, 0) && a.a() != null) {
                        a.a().a(fVar);
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
