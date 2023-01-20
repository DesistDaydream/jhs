package com.tencent.tpns.mqttchannel.core.a;

import com.tencent.tpns.mqttchannel.core.common.data.Request;
import com.tencent.tpns.mqttchannel.core.common.inf.a;
import com.tencent.tpns.mqttchannel.services.BaseMqttClientService;

/* loaded from: classes3.dex */
public class a extends a.AbstractBinderC0277a {
    private BaseMqttClientService a;

    public a(BaseMqttClientService baseMqttClientService) {
        this.a = baseMqttClientService;
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.inf.a
    public void a(boolean z) {
        this.a.onConnectComplete(z);
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.inf.a
    public void b() {
        this.a.onHeartBeat();
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.inf.a
    public void a() {
        this.a.onConnectionLost();
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.inf.a
    public void a(Request request) {
        this.a.onMessageArrived(request.getTopic(), request.getContent());
    }
}
