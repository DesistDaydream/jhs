package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttToken;
import com.tencent.android.tpns.mqtt.internal.wire.MqttAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttInputStream;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubComp;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubRec;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

/* loaded from: classes3.dex */
public class CommsReceiver extends TTask {
    private static final String CLASS_NAME = "CommsReceiver";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private ClientComms clientComms;
    private ClientState clientState;
    private MqttInputStream in;
    private Future receiverFuture;
    private volatile boolean receiving;
    private String threadName;
    private CommsTokenStore tokenStore;
    private boolean running = false;
    private Object lifecycle = new Object();
    private Thread recThread = null;
    private final Semaphore runningSemaphore = new Semaphore(1);

    public CommsReceiver(ClientComms clientComms, ClientState clientState, CommsTokenStore commsTokenStore, InputStream inputStream) {
        this.clientState = null;
        this.clientComms = null;
        this.tokenStore = null;
        this.in = new MqttInputStream(clientState, inputStream);
        this.clientComms = clientComms;
        this.clientState = clientState;
        this.tokenStore = commsTokenStore;
        log.setResourceName(clientComms.getClient().getClientId());
        TBaseLogger.d(CLASS_NAME, "init CommsReceiver");
    }

    @Override // com.tencent.tpns.baseapi.base.util.TTask
    public void TRun() {
        TBaseLogger.d(CLASS_NAME, "Run loop to receive messages from the server, threadName:" + this.threadName);
        Thread currentThread = Thread.currentThread();
        this.recThread = currentThread;
        currentThread.setName(this.threadName);
        try {
            this.runningSemaphore.acquire();
            MqttToken mqttToken = null;
            while (this.running && this.in != null) {
                try {
                    try {
                        Logger logger = log;
                        logger.fine(CLASS_NAME, "run", "852");
                        this.receiving = this.in.available() > 0;
                        MqttWireMessage readMqttWireMessage = this.in.readMqttWireMessage();
                        this.receiving = false;
                        if (readMqttWireMessage != null) {
                            TBaseLogger.i(CLASS_NAME, readMqttWireMessage.toString());
                        }
                        if (readMqttWireMessage instanceof MqttAck) {
                            mqttToken = this.tokenStore.getToken(readMqttWireMessage);
                            if (mqttToken != null) {
                                synchronized (mqttToken) {
                                    this.clientState.notifyReceivedAck((MqttAck) readMqttWireMessage);
                                }
                            } else {
                                if (!(readMqttWireMessage instanceof MqttPubRec) && !(readMqttWireMessage instanceof MqttPubComp) && !(readMqttWireMessage instanceof MqttPubAck)) {
                                    throw new MqttException(6);
                                }
                                logger.fine(CLASS_NAME, "run", "857");
                            }
                        } else if (readMqttWireMessage != null) {
                            this.clientState.notifyReceivedMsg(readMqttWireMessage);
                        }
                    } catch (MqttException e2) {
                        TBaseLogger.e(CLASS_NAME, "run", e2);
                        this.running = false;
                        this.clientComms.shutdownConnection(mqttToken, e2);
                    } catch (IOException e3) {
                        log.fine(CLASS_NAME, "run", "853");
                        this.running = false;
                        if (!this.clientComms.isDisconnecting()) {
                            this.clientComms.shutdownConnection(mqttToken, new MqttException(32109, e3));
                        }
                    }
                } finally {
                    this.receiving = false;
                    this.runningSemaphore.release();
                }
            }
            log.fine(CLASS_NAME, "run", "854");
        } catch (InterruptedException unused) {
            this.running = false;
        }
    }

    public boolean isReceiving() {
        return this.receiving;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void start(String str, ExecutorService executorService) {
        this.threadName = str;
        log.fine(CLASS_NAME, MessageKey.MSG_ACCEPT_TIME_START, "855");
        synchronized (this.lifecycle) {
            if (!this.running) {
                this.running = true;
                this.receiverFuture = executorService.submit(this);
            }
        }
    }

    public void stop() {
        Semaphore semaphore;
        synchronized (this.lifecycle) {
            Future future = this.receiverFuture;
            if (future != null) {
                future.cancel(true);
            }
            log.fine(CLASS_NAME, "stop", "850");
            if (this.running) {
                this.running = false;
                this.receiving = false;
                if (!Thread.currentThread().equals(this.recThread)) {
                    try {
                        this.runningSemaphore.acquire();
                        semaphore = this.runningSemaphore;
                    } catch (InterruptedException unused) {
                        semaphore = this.runningSemaphore;
                    }
                    semaphore.release();
                }
            }
        }
        this.recThread = null;
        log.fine(CLASS_NAME, "stop", "851");
    }
}
