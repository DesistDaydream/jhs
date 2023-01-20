package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.BufferedMessage;
import com.tencent.android.tpns.mqtt.MqttException;

/* loaded from: classes3.dex */
public interface IDisconnectedBufferCallback {
    void publishBufferedMessage(BufferedMessage bufferedMessage) throws MqttException;
}
