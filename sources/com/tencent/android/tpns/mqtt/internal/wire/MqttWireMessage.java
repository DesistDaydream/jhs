package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttPersistable;
import com.tencent.android.tpns.mqtt.internal.ExceptionHelper;
import com.umeng.analytics.pro.cb;
import h.k2.v.n;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes3.dex */
public abstract class MqttWireMessage {
    public static final byte MESSAGE_TYPE_CONNACK = 2;
    public static final byte MESSAGE_TYPE_CONNECT = 1;
    public static final byte MESSAGE_TYPE_DISCONNECT = 14;
    public static final byte MESSAGE_TYPE_PINGREQ = 12;
    public static final byte MESSAGE_TYPE_PINGRESP = 13;
    public static final byte MESSAGE_TYPE_PUBACK = 4;
    public static final byte MESSAGE_TYPE_PUBCOMP = 7;
    public static final byte MESSAGE_TYPE_PUBLISH = 3;
    public static final byte MESSAGE_TYPE_PUBREC = 5;
    public static final byte MESSAGE_TYPE_PUBREL = 6;
    public static final byte MESSAGE_TYPE_SUBACK = 9;
    public static final byte MESSAGE_TYPE_SUBSCRIBE = 8;
    public static final byte MESSAGE_TYPE_UNSUBACK = 11;
    public static final byte MESSAGE_TYPE_UNSUBSCRIBE = 10;
    private static final String[] PACKET_NAMES = {"reserved", "CONNECT", "CONNACK", "PUBLISH", "PUBACK", "PUBREC", "PUBREL", "PUBCOMP", "SUBSCRIBE", "SUBACK", "UNSUBSCRIBE", "UNSUBACK", "PINGREQ", "PINGRESP", "DISCONNECT"};
    public static final String STRING_ENCODING = "UTF-8";
    public boolean duplicate = false;
    public int msgId = 0;
    private byte type;

    public MqttWireMessage(byte b) {
        this.type = b;
    }

    public static MqttWireMessage createWireMessage(MqttPersistable mqttPersistable) throws MqttException {
        byte[] payloadBytes = mqttPersistable.getPayloadBytes();
        if (payloadBytes == null) {
            payloadBytes = new byte[0];
        }
        return createWireMessage(new MultiByteArrayInputStream(mqttPersistable.getHeaderBytes(), mqttPersistable.getHeaderOffset(), mqttPersistable.getHeaderLength(), payloadBytes, mqttPersistable.getPayloadOffset(), mqttPersistable.getPayloadLength()));
    }

    public static byte[] encodeMBI(long j2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        do {
            byte b = (byte) (j2 % 128);
            j2 /= 128;
            int i3 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i3 > 0) {
                b = (byte) (b | n.a);
            }
            byteArrayOutputStream.write(b);
            i2++;
            if (i3 <= 0) {
                break;
            }
        } while (i2 < 4);
        return byteArrayOutputStream.toByteArray();
    }

    public static MultiByteInteger readMBI(DataInputStream dataInputStream) throws IOException {
        byte readByte;
        long j2 = 0;
        int i2 = 0;
        int i3 = 1;
        do {
            readByte = dataInputStream.readByte();
            i2++;
            j2 += (readByte & n.b) * i3;
            i3 *= 128;
        } while ((readByte & n.a) != 0);
        return new MultiByteInteger(j2, i2);
    }

    public String decodeUTF8(DataInputStream dataInputStream) throws MqttException {
        try {
            byte[] bArr = new byte[dataInputStream.readUnsignedShort()];
            dataInputStream.readFully(bArr);
            return new String(bArr, "UTF-8");
        } catch (IOException e2) {
            throw new MqttException(e2);
        }
    }

    public byte[] encodeMessageId() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeShort(this.msgId);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new MqttException(e2);
        }
    }

    public void encodeUTF8(DataOutputStream dataOutputStream, String str) throws MqttException {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            dataOutputStream.write((byte) ((bytes.length >>> 8) & 255));
            dataOutputStream.write((byte) ((bytes.length >>> 0) & 255));
            dataOutputStream.write(bytes);
        } catch (UnsupportedEncodingException e2) {
            throw new MqttException(e2);
        } catch (IOException e3) {
            throw new MqttException(e3);
        }
    }

    public byte[] getHeader() throws MqttException {
        try {
            int type = ((getType() & cb.f7124m) << 4) ^ (getMessageInfo() & cb.f7124m);
            byte[] variableHeader = getVariableHeader();
            int length = variableHeader.length + getPayload().length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeByte(type);
            dataOutputStream.write(encodeMBI(length));
            dataOutputStream.write(variableHeader);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new MqttException(e2);
        }
    }

    public String getKey() {
        return new Integer(getMessageId()).toString();
    }

    public int getMessageId() {
        return this.msgId;
    }

    public abstract byte getMessageInfo();

    public byte[] getPayload() throws MqttException {
        return new byte[0];
    }

    public byte getType() {
        return this.type;
    }

    public abstract byte[] getVariableHeader() throws MqttException;

    public boolean isMessageIdRequired() {
        return true;
    }

    public boolean isRetryable() {
        return false;
    }

    public void setDuplicate(boolean z) {
        this.duplicate = z;
    }

    public void setMessageId(int i2) {
        this.msgId = i2;
    }

    public String toString() {
        return PACKET_NAMES[this.type];
    }

    public static MqttWireMessage createWireMessage(byte[] bArr) throws MqttException {
        return createWireMessage(new ByteArrayInputStream(bArr));
    }

    private static MqttWireMessage createWireMessage(InputStream inputStream) throws MqttException {
        try {
            CountingInputStream countingInputStream = new CountingInputStream(inputStream);
            DataInputStream dataInputStream = new DataInputStream(countingInputStream);
            int readUnsignedByte = dataInputStream.readUnsignedByte();
            byte b = (byte) (readUnsignedByte >> 4);
            byte b2 = (byte) (readUnsignedByte & 15);
            long counter = (countingInputStream.getCounter() + readMBI(dataInputStream).getValue()) - countingInputStream.getCounter();
            byte[] bArr = new byte[0];
            if (counter > 0) {
                int i2 = (int) counter;
                byte[] bArr2 = new byte[i2];
                dataInputStream.readFully(bArr2, 0, i2);
                bArr = bArr2;
            }
            if (b == 1) {
                return new MqttConnect(b2, bArr);
            }
            if (b == 3) {
                return new MqttPublish(b2, bArr);
            }
            if (b == 4) {
                return new MqttPubAck(b2, bArr);
            }
            if (b == 7) {
                return new MqttPubComp(b2, bArr);
            }
            if (b == 2) {
                return new MqttConnack(b2, bArr);
            }
            if (b == 12) {
                return new MqttPingReq(b2, bArr);
            }
            if (b == 13) {
                return new MqttPingResp(b2, bArr);
            }
            if (b == 8) {
                return new MqttSubscribe(b2, bArr);
            }
            if (b == 9) {
                return new MqttSuback(b2, bArr);
            }
            if (b == 10) {
                return new MqttUnsubscribe(b2, bArr);
            }
            if (b == 11) {
                return new MqttUnsubAck(b2, bArr);
            }
            if (b == 6) {
                return new MqttPubRel(b2, bArr);
            }
            if (b == 5) {
                return new MqttPubRec(b2, bArr);
            }
            if (b == 14) {
                return new MqttDisconnect(b2, bArr);
            }
            throw ExceptionHelper.createMqttException(6);
        } catch (IOException e2) {
            throw new MqttException(e2);
        }
    }
}
