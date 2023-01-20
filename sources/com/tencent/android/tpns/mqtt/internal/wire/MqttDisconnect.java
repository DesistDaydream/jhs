package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.IOException;

/* loaded from: classes3.dex */
public class MqttDisconnect extends MqttWireMessage {
    public static final String KEY = "Disc";

    public MqttDisconnect() {
        super((byte) 14);
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public String getKey() {
        return KEY;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public byte getMessageInfo() {
        return (byte) 0;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public byte[] getVariableHeader() throws MqttException {
        return new byte[0];
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public boolean isMessageIdRequired() {
        return false;
    }

    public MqttDisconnect(byte b, byte[] bArr) throws IOException {
        super((byte) 14);
    }
}
