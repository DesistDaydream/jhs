package com.tencent.android.tpns.mqtt;

/* loaded from: classes3.dex */
public interface MqttCallback {
    void connectionLost(Throwable th);

    void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken);

    void messageArrived(String str, MqttMessage mqttMessage) throws Exception;
}
