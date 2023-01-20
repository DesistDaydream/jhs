package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttMessage;

/* loaded from: classes3.dex */
public class MqttReceivedMessage extends MqttMessage {
    public int getMessageId() {
        return super.getId();
    }

    @Override // com.tencent.android.tpns.mqtt.MqttMessage
    public void setDuplicate(boolean z) {
        super.setDuplicate(z);
    }

    public void setMessageId(int i2) {
        super.setId(i2);
    }
}
