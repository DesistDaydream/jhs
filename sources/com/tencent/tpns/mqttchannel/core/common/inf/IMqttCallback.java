package com.tencent.tpns.mqttchannel.core.common.inf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface IMqttCallback extends IInterface {

    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements IMqttCallback {

        /* renamed from: com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0276a implements IMqttCallback {
            public static IMqttCallback a;
            private IBinder b;

            public C0276a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback
            public void handleCallback(int i2, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback");
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    if (!this.b.transact(1, obtain, obtain2, 0) && a.getDefaultImpl() != null) {
                        a.getDefaultImpl().handleCallback(i2, str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback");
        }

        public static IMqttCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMqttCallback)) {
                return (IMqttCallback) queryLocalInterface;
            }
            return new C0276a(iBinder);
        }

        public static IMqttCallback getDefaultImpl() {
            return C0276a.a;
        }

        public static boolean setDefaultImpl(IMqttCallback iMqttCallback) {
            if (C0276a.a == null) {
                if (iMqttCallback != null) {
                    C0276a.a = iMqttCallback;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
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
                parcel2.writeString("com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback");
                return true;
            }
            parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback");
            handleCallback(parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void handleCallback(int i2, String str);
}
