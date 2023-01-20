package com.tencent.tpns.mqttchannel.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import androidx.annotation.Nullable;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.mqttchannel.core.common.a.a;
import com.tencent.tpns.mqttchannel.core.services.MqttServiceImpl;

/* loaded from: classes3.dex */
public class MqttService extends Service {
    private MqttServiceImpl a;

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        a.b("MqttService", "onBind: ");
        return this.a.getIMqttService();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            if (!XGApiConfig.isEnableService(this)) {
                a.b("MqttService", "MqttService onCreate  ");
                stopSelf();
                Process.killProcess(Process.myPid());
                return;
            }
        } catch (Throwable unused) {
            a.b("MqttService", "unexpected for MqttService");
        }
        boolean checkTpnsSecurityLibSo = Security.checkTpnsSecurityLibSo(this);
        a.b("MqttService", "MqttService onCreate load lib: " + checkTpnsSecurityLibSo);
        this.a = new MqttServiceImpl(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        a.b("MqttService", "onDestroy: ");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        return 2;
    }
}
