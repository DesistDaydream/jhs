package com.tencent.android.tpns.mqtt.internal.websocket;

import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/* loaded from: classes3.dex */
public class WebSocketReceiver extends TTask {
    private static final String CLASS_NAME = "WebSocketReceiver";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private InputStream input;
    private PipedOutputStream pipedOutputStream;
    private volatile boolean receiving;
    private boolean running = false;
    private boolean stopping = false;
    private Object lifecycle = new Object();
    private Thread receiverThread = null;

    public WebSocketReceiver(InputStream inputStream, PipedInputStream pipedInputStream) throws IOException {
        this.input = inputStream;
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        this.pipedOutputStream = pipedOutputStream;
        pipedInputStream.connect(pipedOutputStream);
    }

    private void closeOutputStream() {
        try {
            this.pipedOutputStream.close();
        } catch (IOException unused) {
        }
    }

    @Override // com.tencent.tpns.baseapi.base.util.TTask
    public void TRun() {
        while (this.running && this.input != null) {
            try {
                log.fine(CLASS_NAME, "run", "852");
                this.receiving = this.input.available() > 0;
                WebSocketFrame webSocketFrame = new WebSocketFrame(this.input);
                if (!webSocketFrame.isCloseFlag()) {
                    for (int i2 = 0; i2 < webSocketFrame.getPayload().length; i2++) {
                        this.pipedOutputStream.write(webSocketFrame.getPayload()[i2]);
                    }
                    this.pipedOutputStream.flush();
                } else if (!this.stopping) {
                    throw new IOException("Server sent a WebSocket Frame with the Stop OpCode");
                    break;
                }
                this.receiving = false;
            } catch (IOException unused) {
                stop();
            }
        }
    }

    public boolean isReceiving() {
        return this.receiving;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void start(String str) {
        log.fine(CLASS_NAME, MessageKey.MSG_ACCEPT_TIME_START, "855");
        synchronized (this.lifecycle) {
            if (!this.running) {
                this.running = true;
                Thread thread = new Thread(this, str);
                this.receiverThread = thread;
                thread.start();
            }
        }
    }

    public void stop() {
        boolean z = true;
        this.stopping = true;
        synchronized (this.lifecycle) {
            log.fine(CLASS_NAME, "stop", "850");
            if (this.running) {
                this.running = false;
                this.receiving = false;
                closeOutputStream();
            } else {
                z = false;
            }
        }
        if (z && !Thread.currentThread().equals(this.receiverThread)) {
            try {
                this.receiverThread.join();
            } catch (InterruptedException unused) {
            }
        }
        this.receiverThread = null;
        log.fine(CLASS_NAME, "stop", "851");
    }
}
