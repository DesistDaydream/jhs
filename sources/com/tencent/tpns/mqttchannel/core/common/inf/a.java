package com.tencent.tpns.mqttchannel.core.common.inf;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.tpns.mqttchannel.core.common.data.Request;

/* loaded from: classes3.dex */
public interface a extends IInterface {

    /* renamed from: com.tencent.tpns.mqttchannel.core.common.inf.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractBinderC0277a extends Binder implements a {
        public AbstractBinderC0277a() {
            attachInterface(this, "com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
                a(parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            } else if (i2 == 2) {
                parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
                a();
                parcel2.writeNoException();
                return true;
            } else if (i2 == 3) {
                parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
                b();
                parcel2.writeNoException();
                return true;
            } else if (i2 != 4) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
                return true;
            } else {
                parcel.enforceInterface("com.tencent.tpns.mqttchannel.core.common.inf.IMqttClientService");
                a(parcel.readInt() != 0 ? Request.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
        }
    }

    void a();

    void a(Request request);

    void a(boolean z);

    void b();
}
