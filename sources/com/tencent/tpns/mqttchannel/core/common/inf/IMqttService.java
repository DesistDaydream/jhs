package com.tencent.tpns.mqttchannel.core.common.inf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.tpns.mqttchannel.core.common.data.Request;
import com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback;

/* loaded from: classes3.dex */
public interface IMqttService extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements IMqttService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
        public void getConnectState(IMqttCallback iMqttCallback) {
        }

        @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
        public void ping(IMqttCallback iMqttCallback) {
        }

        @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
        public void sendPublishData(Request request, IMqttCallback iMqttCallback) {
        }

        @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
        public void sendRequest(Request request, IMqttCallback iMqttCallback) {
        }

        @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
        public void startConnect(IMqttCallback iMqttCallback) {
        }

        @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
        public void stopConnect(IMqttCallback iMqttCallback) {
        }

        @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
        public void subscrbie(Request request, IMqttCallback iMqttCallback) {
        }

        @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
        public void unSubscrbie(Request request, IMqttCallback iMqttCallback) {
        }
    }

    void getConnectState(IMqttCallback iMqttCallback);

    void ping(IMqttCallback iMqttCallback);

    void sendPublishData(Request request, IMqttCallback iMqttCallback);

    void sendRequest(Request request, IMqttCallback iMqttCallback);

    void startConnect(IMqttCallback iMqttCallback);

    void stopConnect(IMqttCallback iMqttCallback);

    void subscrbie(Request request, IMqttCallback iMqttCallback);

    void unSubscrbie(Request request, IMqttCallback iMqttCallback);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IMqttService {

        /* loaded from: classes3.dex */
        public static class Proxy implements IMqttService {
            public static IMqttService a;
            private IBinder b;

            public Proxy(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
            public void getConnectState(IMqttCallback iMqttCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    obtain.writeStrongBinder(iMqttCallback != null ? iMqttCallback.asBinder() : null);
                    if (!this.b.transact(3, obtain, obtain2, 0) && Stub.a() != null) {
                        Stub.a().getConnectState(iMqttCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
            public void ping(IMqttCallback iMqttCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    obtain.writeStrongBinder(iMqttCallback != null ? iMqttCallback.asBinder() : null);
                    if (!this.b.transact(4, obtain, obtain2, 0) && Stub.a() != null) {
                        Stub.a().ping(iMqttCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
            public void sendPublishData(Request request, IMqttCallback iMqttCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iMqttCallback != null ? iMqttCallback.asBinder() : null);
                    if (!this.b.transact(6, obtain, obtain2, 0) && Stub.a() != null) {
                        Stub.a().sendPublishData(request, iMqttCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
            public void sendRequest(Request request, IMqttCallback iMqttCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iMqttCallback != null ? iMqttCallback.asBinder() : null);
                    if (!this.b.transact(5, obtain, obtain2, 0) && Stub.a() != null) {
                        Stub.a().sendRequest(request, iMqttCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
            public void startConnect(IMqttCallback iMqttCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    obtain.writeStrongBinder(iMqttCallback != null ? iMqttCallback.asBinder() : null);
                    if (!this.b.transact(1, obtain, obtain2, 0) && Stub.a() != null) {
                        Stub.a().startConnect(iMqttCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
            public void stopConnect(IMqttCallback iMqttCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    obtain.writeStrongBinder(iMqttCallback != null ? iMqttCallback.asBinder() : null);
                    if (!this.b.transact(2, obtain, obtain2, 0) && Stub.a() != null) {
                        Stub.a().stopConnect(iMqttCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
            public void subscrbie(Request request, IMqttCallback iMqttCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iMqttCallback != null ? iMqttCallback.asBinder() : null);
                    if (!this.b.transact(7, obtain, obtain2, 0) && Stub.a() != null) {
                        Stub.a().subscrbie(request, iMqttCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
            public void unSubscrbie(Request request, IMqttCallback iMqttCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iMqttCallback != null ? iMqttCallback.asBinder() : null);
                    if (!this.b.transact(8, obtain, obtain2, 0) && Stub.a() != null) {
                        Stub.a().unSubscrbie(request, iMqttCallback);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
        }

        public static IMqttService a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMqttService)) {
                return (IMqttService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 != 1598968902) {
                switch (i2) {
                    case 1:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        startConnect(IMqttCallback.a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        stopConnect(IMqttCallback.a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        getConnectState(IMqttCallback.a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        ping(IMqttCallback.a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        sendRequest(parcel.readInt() != 0 ? Request.CREATOR.createFromParcel(parcel) : null, IMqttCallback.a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        sendPublishData(parcel.readInt() != 0 ? Request.CREATOR.createFromParcel(parcel) : null, IMqttCallback.a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        subscrbie(parcel.readInt() != 0 ? Request.CREATOR.createFromParcel(parcel) : null, IMqttCallback.a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
                        unSubscrbie(parcel.readInt() != 0 ? Request.CREATOR.createFromParcel(parcel) : null, IMqttCallback.a.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i2, parcel, parcel2, i3);
                }
            }
            parcel2.writeString("com.tencent.tpns.mqttchannel.core.common.inf.IMqttService");
            return true;
        }

        public static IMqttService a() {
            return Proxy.a;
        }
    }
}
