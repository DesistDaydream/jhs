package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class MqttPubAck extends MqttAck {
    public MqttPubAck(byte b, byte[] bArr) throws IOException {
        super((byte) 4);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.msgId = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public byte[] getVariableHeader() throws MqttException {
        return encodeMessageId();
    }

    public MqttPubAck(MqttPublish mqttPublish) {
        super((byte) 4);
        this.msgId = mqttPublish.getMessageId();
    }

    public MqttPubAck(int i2) {
        super((byte) 4);
        this.msgId = i2;
    }
}
