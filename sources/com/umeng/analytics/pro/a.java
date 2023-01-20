package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface a extends IInterface {
    String a(String str) throws RemoteException;

    boolean a() throws RemoteException;

    String b() throws RemoteException;

    String b(String str) throws RemoteException;

    String c(String str) throws RemoteException;

    String d(String str) throws RemoteException;

    String e(String str) throws RemoteException;

    /* renamed from: com.umeng.analytics.pro.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractBinderC0278a extends Binder implements a {
        public static final int a = 1;
        public static final int b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f6983c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f6984d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final int f6985e = 5;

        /* renamed from: f  reason: collision with root package name */
        public static final int f6986f = 6;

        /* renamed from: g  reason: collision with root package name */
        public static final int f6987g = 7;

        /* renamed from: h  reason: collision with root package name */
        private static final String f6988h = "com.coolpad.deviceidsupport.IDeviceIdManager";

        public AbstractBinderC0278a() {
            attachInterface(this, f6988h);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f6988h);
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0279a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1598968902) {
                switch (i2) {
                    case 1:
                        parcel.enforceInterface(f6988h);
                        String a2 = a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(a2);
                        return true;
                    case 2:
                        parcel.enforceInterface(f6988h);
                        String b2 = b(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(b2);
                        return true;
                    case 3:
                        parcel.enforceInterface(f6988h);
                        String c2 = c(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(c2);
                        return true;
                    case 4:
                        parcel.enforceInterface(f6988h);
                        String d2 = d(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(d2);
                        return true;
                    case 5:
                        parcel.enforceInterface(f6988h);
                        String e2 = e(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(e2);
                        return true;
                    case 6:
                        parcel.enforceInterface(f6988h);
                        boolean a3 = a();
                        parcel2.writeNoException();
                        parcel2.writeInt(a3 ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface(f6988h);
                        String b3 = b();
                        parcel2.writeNoException();
                        parcel2.writeString(b3);
                        return true;
                    default:
                        return super.onTransact(i2, parcel, parcel2, i3);
                }
            }
            parcel2.writeString(f6988h);
            return true;
        }

        /* renamed from: com.umeng.analytics.pro.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0279a implements a {
            private IBinder a;

            public C0279a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.umeng.analytics.pro.a
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0278a.f6988h);
                    obtain.writeString(str);
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

            @Override // com.umeng.analytics.pro.a
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0278a.f6988h);
                    obtain.writeString(str);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String c() {
                return AbstractBinderC0278a.f6988h;
            }

            @Override // com.umeng.analytics.pro.a
            public String c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0278a.f6988h);
                    obtain.writeString(str);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String d(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0278a.f6988h);
                    obtain.writeString(str);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String e(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0278a.f6988h);
                    obtain.writeString(str);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public boolean a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0278a.f6988h);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0278a.f6988h);
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
