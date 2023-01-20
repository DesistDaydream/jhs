package com.tencent.android.tpns.mqtt.internal.wire;

/* loaded from: classes3.dex */
public abstract class MqttAck extends MqttWireMessage {
    public MqttAck(byte b) {
        super(b);
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public byte getMessageInfo() {
        return (byte) 0;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public String toString() {
        return super.toString() + " msgId " + this.msgId;
    }
}
