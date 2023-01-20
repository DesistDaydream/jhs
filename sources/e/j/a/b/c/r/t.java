package e.j.a.b.c.r;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.zzr;

/* loaded from: classes2.dex */
public interface t extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements t {

        /* renamed from: e.j.a.b.c.r.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0342a implements t {
            private final IBinder a;

            public C0342a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.a;
            }

            @Override // e.j.a.b.c.r.t
            public final void l(s sVar, GetServiceRequest getServiceRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(sVar != null ? sVar.asBinder() : null);
                    if (getServiceRequest != null) {
                        obtain.writeInt(1);
                        getServiceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        @Override // android.os.IInterface
        @e.j.a.b.c.m.a
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            s j1Var;
            if (i2 > 16777215) {
                return super.onTransact(i2, parcel, parcel2, i3);
            }
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                j1Var = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                if (queryLocalInterface instanceof s) {
                    j1Var = (s) queryLocalInterface;
                } else {
                    j1Var = new j1(readStrongBinder);
                }
            }
            if (i2 == 46) {
                l(j1Var, parcel.readInt() != 0 ? GetServiceRequest.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i2 == 47) {
                if (parcel.readInt() != 0) {
                    zzr.CREATOR.createFromParcel(parcel);
                }
                throw new UnsupportedOperationException();
            } else {
                parcel.readInt();
                if (i2 != 4) {
                    parcel.readString();
                }
                if (i2 != 1) {
                    if (i2 != 2 && i2 != 23 && i2 != 25 && i2 != 27) {
                        if (i2 != 30) {
                            if (i2 == 34) {
                                parcel.readString();
                            } else if (i2 != 41 && i2 != 43 && i2 != 37 && i2 != 38) {
                                switch (i2) {
                                    case 9:
                                        parcel.readString();
                                        parcel.createStringArray();
                                        parcel.readString();
                                        parcel.readStrongBinder();
                                        parcel.readString();
                                        if (parcel.readInt() != 0) {
                                            Bundle.CREATOR.createFromParcel(parcel);
                                            break;
                                        }
                                        break;
                                    case 10:
                                        parcel.readString();
                                        parcel.createStringArray();
                                        break;
                                    case 19:
                                        parcel.readStrongBinder();
                                        if (parcel.readInt() != 0) {
                                            Bundle.CREATOR.createFromParcel(parcel);
                                            break;
                                        }
                                        break;
                                }
                            }
                        }
                        parcel.createStringArray();
                        parcel.readString();
                        if (parcel.readInt() != 0) {
                            Bundle.CREATOR.createFromParcel(parcel);
                        }
                    }
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                } else {
                    parcel.readString();
                    parcel.createStringArray();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                }
                throw new UnsupportedOperationException();
            }
        }
    }

    @e.j.a.b.c.m.a
    void l(s sVar, GetServiceRequest getServiceRequest) throws RemoteException;
}
