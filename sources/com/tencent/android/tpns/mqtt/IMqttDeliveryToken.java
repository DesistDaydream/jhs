package com.tencent.android.tpns.mqtt;

/* loaded from: classes3.dex */
public interface IMqttDeliveryToken extends IMqttToken {
    MqttMessage getMessage() throws MqttException;
}
