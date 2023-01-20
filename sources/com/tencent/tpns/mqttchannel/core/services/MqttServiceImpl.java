package com.tencent.tpns.mqttchannel.core.services;

import android.content.Context;
import com.tencent.tpns.mqttchannel.core.common.inf.IMqttService;
import com.tencent.tpns.mqttchannel.services.BaseMqttClientService;

/* loaded from: classes3.dex */
public class MqttServiceImpl {
    private IMqttService.Stub a;

    public MqttServiceImpl(Context context, BaseMqttClientService baseMqttClientService) {
        this.a = new IMqttServiceImpl(context, baseMqttClientService);
    }

    public IMqttService.Stub getIMqttService() {
        return this.a;
    }

    public MqttServiceImpl(Context context) {
        this.a = new IMqttServiceImpl(context);
    }
}
