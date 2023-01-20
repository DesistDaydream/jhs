package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttTopic;

/* loaded from: classes3.dex */
public interface DestinationProvider {
    MqttTopic getTopic(String str);
}
