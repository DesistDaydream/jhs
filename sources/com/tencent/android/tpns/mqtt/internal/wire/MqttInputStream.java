package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.internal.ClientState;
import com.tencent.android.tpns.mqtt.internal.ExceptionHelper;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;

/* loaded from: classes3.dex */
public class MqttInputStream extends InputStream {
    private static final String CLASS_NAME = "MqttInputStream";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private ClientState clientState;
    private DataInputStream in;
    private byte[] packet;
    private long packetLen;
    private ByteArrayOutputStream bais = new ByteArrayOutputStream();
    private long remLen = -1;

    public MqttInputStream(ClientState clientState, InputStream inputStream) {
        this.clientState = null;
        this.clientState = clientState;
        this.in = new DataInputStream(inputStream);
    }

    private void readFully() throws IOException {
        int size = this.bais.size();
        long j2 = this.packetLen;
        int i2 = size + ((int) j2);
        int i3 = (int) (this.remLen - j2);
        if (i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i4 = 0;
        while (i4 < i3) {
            try {
                int read = this.in.read(this.packet, i2 + i4, i3 - i4);
                this.clientState.notifyReceivedBytes(read);
                if (read < 0) {
                    throw new EOFException();
                }
                i4 += read;
            } catch (SocketTimeoutException e2) {
                this.packetLen += i4;
                throw e2;
            }
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.in.read();
    }

    public MqttWireMessage readMqttWireMessage() throws IOException, MqttException {
        TBaseLogger.d(CLASS_NAME, "action - readMqttWireMessage");
        try {
            if (this.remLen < 0) {
                this.bais.reset();
                byte readByte = this.in.readByte();
                this.clientState.notifyReceivedBytes(1);
                byte b = (byte) ((readByte >>> 4) & 15);
                if (b >= 1 && b <= 14) {
                    this.remLen = MqttWireMessage.readMBI(this.in).getValue();
                    this.bais.write(readByte);
                    this.bais.write(MqttWireMessage.encodeMBI(this.remLen));
                    this.packet = new byte[(int) (this.bais.size() + this.remLen)];
                    this.packetLen = 0L;
                } else {
                    throw ExceptionHelper.createMqttException(32108);
                }
            }
            if (this.remLen >= 0) {
                readFully();
                this.remLen = -1L;
                byte[] byteArray = this.bais.toByteArray();
                System.arraycopy(byteArray, 0, this.packet, 0, byteArray.length);
                MqttWireMessage createWireMessage = MqttWireMessage.createWireMessage(this.packet);
                log.fine(CLASS_NAME, "readMqttWireMessage", "501", new Object[]{createWireMessage});
                return createWireMessage;
            }
            return null;
        } catch (SocketTimeoutException unused) {
            return null;
        }
    }
}
