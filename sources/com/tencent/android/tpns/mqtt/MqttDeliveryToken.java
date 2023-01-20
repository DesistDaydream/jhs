package com.tencent.android.tpns.mqtt;

/* loaded from: classes3.dex */
public class MqttDeliveryToken extends MqttToken implements IMqttDeliveryToken {
    public MqttDeliveryToken() {
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttDeliveryToken
    public MqttMessage getMessage() throws MqttException {
        return this.internalTok.getMessage();
    }

    public void setMessage(MqttMessage mqttMessage) {
        this.internalTok.setMessage(mqttMessage);
    }

    public MqttDeliveryToken(String str) {
        super(str);
    }
}
