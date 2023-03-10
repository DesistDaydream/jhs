package com.ss.android.downloadlib.a.b;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.a.b.d;
import com.ss.android.downloadlib.addownload.j;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface c extends IInterface {

    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements c {
        private static String a = "";

        /* renamed from: com.ss.android.downloadlib.a.b.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0173a implements c {
            private IBinder a;

            public C0173a(IBinder iBinder) {
                if (TextUtils.isEmpty(a.a)) {
                    JSONObject i2 = j.i();
                    String unused = a.a = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("r"), i2.optString("s"));
                }
                this.a = iBinder;
            }

            @Override // com.ss.android.downloadlib.a.b.c
            public void a(b bVar, d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.a);
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
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

        @Override // android.os.Binder
        @SuppressLint({"WrongConstant"})
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1598968902) {
                parcel2.writeString(a);
                return true;
            }
            if (i2 != 1) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel.enforceInterface(a);
            a(parcel.readInt() != 0 ? b.CREATOR.createFromParcel(parcel) : null, d.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a);
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C0173a(iBinder);
        }
    }

    void a(b bVar, d dVar) throws RemoteException;
}
