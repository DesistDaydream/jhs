package com.tencent.android.tpns.mqtt;

/* loaded from: classes3.dex */
public interface IMqttMessageListener {
    void messageArrived(String str, MqttMessage mqttMessage) throws Exception;
}
