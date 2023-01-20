package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import h.k2.v.n;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class MqttConnect extends MqttWireMessage {
    public static final String KEY = "Con";
    private int MqttVersion;
    private boolean cleanSession;
    private String clientId;
    private int keepAliveInterval;
    private char[] password;
    private String userName;
    private String willDestination;
    private MqttMessage willMessage;

    public MqttConnect(byte b, byte[] bArr) throws IOException, MqttException {
        super((byte) 1);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        decodeUTF8(dataInputStream);
        dataInputStream.readByte();
        dataInputStream.readByte();
        this.keepAliveInterval = dataInputStream.readUnsignedShort();
        this.clientId = decodeUTF8(dataInputStream);
        dataInputStream.close();
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public String getKey() {
        return "Con";
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public byte getMessageInfo() {
        return (byte) 0;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public byte[] getPayload() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            encodeUTF8(dataOutputStream, this.clientId);
            if (this.willMessage != null) {
                encodeUTF8(dataOutputStream, this.willDestination);
                dataOutputStream.writeShort(this.willMessage.getPayload().length);
                dataOutputStream.write(this.willMessage.getPayload());
            }
            String str = this.userName;
            if (str != null) {
                encodeUTF8(dataOutputStream, str);
                if (this.password != null) {
                    encodeUTF8(dataOutputStream, new String(this.password));
                }
            }
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new MqttException(e2);
        }
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public byte[] getVariableHeader() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            int i2 = this.MqttVersion;
            if (i2 == 3) {
                encodeUTF8(dataOutputStream, "MQIsdp");
            } else if (i2 == 4) {
                encodeUTF8(dataOutputStream, "MQTT");
            }
            dataOutputStream.write(this.MqttVersion);
            byte b = this.cleanSession ? (byte) 2 : (byte) 0;
            MqttMessage mqttMessage = this.willMessage;
            if (mqttMessage != null) {
                b = (byte) (((byte) (b | 4)) | (mqttMessage.getQos() << 3));
                if (this.willMessage.isRetained()) {
                    b = (byte) (b | 32);
                }
            }
            if (this.userName != null) {
                b = (byte) (b | n.a);
                if (this.password != null) {
                    b = (byte) (b | 64);
                }
            }
            dataOutputStream.write(b);
            dataOutputStream.writeShort(this.keepAliveInterval);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new MqttException(e2);
        }
    }

    public boolean isCleanSession() {
        return this.cleanSession;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public boolean isMessageIdRequired() {
        return false;
    }

    @Override // com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage
    public String toString() {
        String mqttWireMessage = super.toString();
        return mqttWireMessage + " clientId " + this.clientId + " keepAliveInterval " + this.keepAliveInterval;
    }

    public MqttConnect(String str, int i2, boolean z, int i3, String str2, char[] cArr, MqttMessage mqttMessage, String str3) {
        super((byte) 1);
        this.clientId = str;
        this.cleanSession = z;
        this.keepAliveInterval = i3;
        this.userName = str2;
        this.password = cArr;
        this.willMessage = mqttMessage;
        this.willDestination = str3;
        this.MqttVersion = i2;
    }
}
