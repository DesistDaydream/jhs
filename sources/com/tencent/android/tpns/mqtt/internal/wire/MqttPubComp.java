package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class MqttPubComp extends MqttAck {
    public MqttPubComp(byte b, byte[] bArr) throws IOException {
        super((byte) 7);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.msgId = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public byte[] getVariableHeader() throws MqttException {
        return encodeMessageId();
    }

    public MqttPubComp(MqttPublish mqttPublish) {
        super((byte) 7);
        this.msgId = mqttPublish.getMessageId();
    }

    public MqttPubComp(int i2) {
        super((byte) 7);
        this.msgId = i2;
    }
}
