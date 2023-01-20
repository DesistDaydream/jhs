package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.ClientComms;

/* loaded from: classes3.dex */
public interface MqttPingSender {
    void init(ClientComms clientComms);

    void schedule(long j2);

    void start();

    void stop();
}
