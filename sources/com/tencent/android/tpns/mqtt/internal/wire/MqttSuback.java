package com.tencent.android.tpns.mqtt.internal.wire;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpns.mqtt.MqttException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class MqttSuback extends MqttAck {
    private int[] grantedQos;

    public MqttSuback(byte b, byte[] bArr) throws IOException {
        super((byte) 9);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.msgId = dataInputStream.readUnsignedShort();
        this.grantedQos = new int[bArr.length - 2];
        int i2 = 0;
        for (int read = dataInputStream.read(); read != -1; read = dataInputStream.read()) {
            this.grantedQos[i2] = read;
            i2++;
        }
        dataInputStream.close();
    }

    public int[] getGrantedQos() {
        return this.grantedQos;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public byte[] getVariableHeader() throws MqttException {
        return new byte[0];
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttAck, com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        stringBuffer.append(" granted Qos");
        for (int i2 = 0; i2 < this.grantedQos.length; i2++) {
            stringBuffer.append(ExpandableTextView.N);
            stringBuffer.append(this.grantedQos[i2]);
        }
        return stringBuffer.toString();
    }
}
