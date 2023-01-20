package com.tencent.android.tpns.mqtt.internal.wire;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.internal.ClientState;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class MqttOutputStream extends OutputStream {
    private static final String CLASS_NAME = "MqttOutputStream";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private ClientState clientState;
    private BufferedOutputStream out;

    public MqttOutputStream(ClientState clientState, OutputStream outputStream) {
        this.clientState = null;
        this.clientState = clientState;
        this.out = new BufferedOutputStream(outputStream);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
        this.clientState.notifySentBytes(bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.out.write(bArr, i2, i3);
        this.clientState.notifySentBytes(i3);
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        this.out.write(i2);
    }

    public void write(MqttWireMessage mqttWireMessage) throws IOException, MqttException {
        byte[] header = mqttWireMessage.getHeader();
        byte[] payload = mqttWireMessage.getPayload();
        this.out.write(header, 0, header.length);
        this.clientState.notifySentBytes(header.length);
        int i2 = 0;
        while (i2 < payload.length) {
            int min = Math.min(1024, payload.length - i2);
            this.out.write(payload, i2, min);
            i2 += 1024;
            this.clientState.notifySentBytes(min);
        }
        log.fine(CLASS_NAME, "write", "529", new Object[]{mqttWireMessage});
    }
}
