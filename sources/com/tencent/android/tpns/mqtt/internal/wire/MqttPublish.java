package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class MqttPublish extends MqttPersistableWireMessage {
    private byte[] encodedPayload;
    private MqttMessage message;
    private String topicName;

    public MqttPublish(String str, MqttMessage mqttMessage) {
        super((byte) 3);
        this.encodedPayload = null;
        this.topicName = str;
        this.message = mqttMessage;
    }

    public static byte[] encodePayload(MqttMessage mqttMessage) {
        return mqttMessage.getPayload();
    }

    public MqttMessage getMessage() {
        return this.message;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public byte getMessageInfo() {
        byte qos = (byte) (this.message.getQos() << 1);
        if (this.message.isRetained()) {
            qos = (byte) (qos | 1);
        }
        return (this.message.isDuplicate() || this.duplicate) ? (byte) (qos | 8) : qos;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public byte[] getPayload() throws MqttException {
        if (this.encodedPayload == null) {
            this.encodedPayload = encodePayload(this.message);
        }
        return this.encodedPayload;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttPersistableWireMessage, com.tencent.android.tpns.mqtt.MqttPersistable
    public int getPayloadLength() {
        try {
            return getPayload().length;
        } catch (MqttException unused) {
            return 0;
        }
    }

    public String getTopicName() {
        return this.topicName;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public byte[] getVariableHeader() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            encodeUTF8(dataOutputStream, this.topicName);
            if (this.message.getQos() > 0) {
                dataOutputStream.writeShort(this.msgId);
            }
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new MqttException(e2);
        }
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public boolean isMessageIdRequired() {
        return true;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public void setMessageId(int i2) {
        super.setMessageId(i2);
        MqttMessage mqttMessage = this.message;
        if (mqttMessage instanceof MqttReceivedMessage) {
            ((MqttReceivedMessage) mqttMessage).setMessageId(i2);
        }
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        byte[] payload = this.message.getPayload();
        int min = Math.min(payload.length, 20);
        for (int i2 = 0; i2 < min; i2++) {
            String hexString = Integer.toHexString(payload[i2]);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            stringBuffer.append(hexString);
        }
        try {
            str = new String(payload, 0, min, "UTF-8");
        } catch (Throwable unused) {
            str = "?";
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(super.toString());
        stringBuffer2.append(" qos:");
        stringBuffer2.append(this.message.getQos());
        if (this.message.getQos() > 0) {
            stringBuffer2.append(" msgId:");
            stringBuffer2.append(this.msgId);
        }
        stringBuffer2.append(" retained:");
        stringBuffer2.append(this.message.isRetained());
        stringBuffer2.append(" dup:");
        stringBuffer2.append(this.duplicate);
        stringBuffer2.append(" topic:\"");
        stringBuffer2.append(this.topicName);
        stringBuffer2.append("\"");
        stringBuffer2.append(" payload:[hex:");
        stringBuffer2.append(stringBuffer);
        stringBuffer2.append(" utf8:\"");
        stringBuffer2.append(str);
        stringBuffer2.append("\"");
        stringBuffer2.append(" length:");
        stringBuffer2.append(payload.length);
        stringBuffer2.append("]");
        return stringBuffer2.toString();
    }

    public MqttPublish(byte b, byte[] bArr) throws MqttException, IOException {
        super((byte) 3);
        this.encodedPayload = null;
        MqttReceivedMessage mqttReceivedMessage = new MqttReceivedMessage();
        this.message = mqttReceivedMessage;
        mqttReceivedMessage.setQos(3 & (b >> 1));
        if ((b & 1) == 1) {
            this.message.setRetained(true);
        }
        if ((b & 8) == 8) {
            ((MqttReceivedMessage) this.message).setDuplicate(true);
        }
        CountingInputStream countingInputStream = new CountingInputStream(new ByteArrayInputStream(bArr));
        DataInputStream dataInputStream = new DataInputStream(countingInputStream);
        this.topicName = decodeUTF8(dataInputStream);
        if (this.message.getQos() > 0) {
            this.msgId = dataInputStream.readUnsignedShort();
        }
        byte[] bArr2 = new byte[bArr.length - countingInputStream.getCounter()];
        dataInputStream.readFully(bArr2);
        dataInputStream.close();
        this.message.setPayload(bArr2);
    }
}
