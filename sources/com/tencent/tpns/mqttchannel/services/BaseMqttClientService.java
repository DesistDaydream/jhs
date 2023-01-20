package com.tencent.tpns.mqttchannel.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.tencent.tpns.mqttchannel.core.common.inf.a;

/* loaded from: classes3.dex */
public abstract class BaseMqttClientService extends Service {
    private a.AbstractBinderC0277a a;

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return this.a;
    }

    public abstract void onConnectComplete(boolean z);

    public abstract void onConnectionLost();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.a = new com.tencent.tpns.mqttchannel.core.a.a(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.a = null;
        super.onDestroy();
    }

    public abstract void onHeartBeat();

    public abstract void onMessageArrived(String str, String str2);
}
