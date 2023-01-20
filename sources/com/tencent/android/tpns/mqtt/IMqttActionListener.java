package com.tencent.android.tpns.mqtt;

/* loaded from: classes3.dex */
public interface IMqttActionListener {
    void onFailure(IMqttToken iMqttToken, Throwable th);

    void onSuccess(IMqttToken iMqttToken);
}
