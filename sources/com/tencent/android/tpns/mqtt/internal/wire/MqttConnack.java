package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class MqttConnack extends MqttAck {
    public static final String KEY = "Con";
    private int returnCode;
    private boolean sessionPresent;

    public MqttConnack(byte b, byte[] bArr) throws IOException {
        super((byte) 2);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.sessionPresent = (dataInputStream.readUnsignedByte() & 1) == 1;
        this.returnCode = dataInputStream.readUnsignedByte();
        dataInputStream.close();
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public String getKey() {
        return "Con";
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public boolean getSessionPresent() {
        return this.sessionPresent;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public byte[] getVariableHeader() throws MqttException {
        return new byte[0];
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public boolean isMessageIdRequired() {
        return false;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttAck, com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public String toString() {
        return super.toString() + " session present:" + this.sessionPresent + " return code: " + this.returnCode;
    }
}
