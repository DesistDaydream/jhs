package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.BufferedMessage;
import com.tencent.android.tpns.mqtt.DisconnectedBufferOptions;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttToken;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class DisconnectedMessageBuffer extends TTask {
    private static final String CLASS_NAME = "DisconnectedMessageBuffer";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private Object bufLock = new Object();
    private ArrayList buffer = new ArrayList();
    private DisconnectedBufferOptions bufferOpts;
    private IDisconnectedBufferCallback callback;

    public DisconnectedMessageBuffer(DisconnectedBufferOptions disconnectedBufferOptions) {
        this.bufferOpts = disconnectedBufferOptions;
    }

    @Override // com.tencent.tpns.baseapi.base.util.TTask
    public void TRun() {
        log.fine(CLASS_NAME, "run", "516");
        while (getMessageCount() > 0) {
            try {
                this.callback.publishBufferedMessage(getMessage(0));
                deleteMessage(0);
            } catch (Throwable th) {
                TBaseLogger.e(CLASS_NAME, "run", th);
                return;
            }
        }
    }

    public void deleteMessage(int i2) {
        synchronized (this.bufLock) {
            this.buffer.remove(i2);
        }
    }

    public BufferedMessage getMessage(int i2) {
        BufferedMessage bufferedMessage;
        synchronized (this.bufLock) {
            bufferedMessage = (BufferedMessage) this.buffer.get(i2);
        }
        return bufferedMessage;
    }

    public int getMessageCount() {
        int size;
        synchronized (this.bufLock) {
            size = this.buffer.size();
        }
        return size;
    }

    public boolean isPersistBuffer() {
        return this.bufferOpts.isPersistBuffer();
    }

    public void putMessage(MqttWireMessage mqttWireMessage, MqttToken mqttToken) throws MqttException {
        BufferedMessage bufferedMessage = new BufferedMessage(mqttWireMessage, mqttToken);
        synchronized (this.bufLock) {
            if (this.buffer.size() < this.bufferOpts.getBufferSize()) {
                this.buffer.add(bufferedMessage);
            } else if (this.bufferOpts.isDeleteOldestMessages()) {
                this.buffer.remove(0);
                this.buffer.add(bufferedMessage);
            } else {
                throw new MqttException(32203);
            }
        }
    }

    public void setPublishCallback(IDisconnectedBufferCallback iDisconnectedBufferCallback) {
        this.callback = iDisconnectedBufferCallback;
    }
}
