package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttToken;
import com.tencent.android.tpns.mqtt.internal.wire.MqttAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttDisconnect;
import com.tencent.android.tpns.mqtt.internal.wire.MqttOutputStream;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class CommsSender extends TTask {
    private static final String CLASS_NAME = "CommsSender";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private ClientComms clientComms;
    private ClientState clientState;
    private MqttOutputStream out;
    private Future senderFuture;
    private String threadName;
    private CommsTokenStore tokenStore;
    private boolean running = false;
    private Object lifecycle = new Object();
    private Thread sendThread = null;
    private final Semaphore runningSemaphore = new Semaphore(1);

    public CommsSender(ClientComms clientComms, ClientState clientState, CommsTokenStore commsTokenStore, OutputStream outputStream) {
        this.clientState = null;
        this.clientComms = null;
        this.tokenStore = null;
        this.out = new MqttOutputStream(clientState, outputStream);
        this.clientComms = clientComms;
        this.clientState = clientState;
        this.tokenStore = commsTokenStore;
        log.setResourceName(clientComms.getClient().getClientId());
        TBaseLogger.d(CLASS_NAME, "init CommsSender");
    }

    private void handleRunException(MqttWireMessage mqttWireMessage, Exception exc) {
        MqttException mqttException;
        log.fine(CLASS_NAME, "handleRunException", "804", null, exc);
        if (!(exc instanceof MqttException)) {
            mqttException = new MqttException(32109, exc);
        } else {
            mqttException = (MqttException) exc;
        }
        this.running = false;
        this.clientComms.shutdownConnection(null, mqttException);
    }

    @Override // com.tencent.tpns.baseapi.base.util.TTask
    public void TRun() {
        TBaseLogger.d(CLASS_NAME, "Run loop sender messages to the server, threadName:" + this.threadName);
        Thread currentThread = Thread.currentThread();
        this.sendThread = currentThread;
        currentThread.setName(this.threadName);
        try {
            this.runningSemaphore.acquire();
            MqttWireMessage mqttWireMessage = null;
            while (this.running && this.out != null) {
                try {
                    try {
                        try {
                            mqttWireMessage = this.clientState.get();
                            if (mqttWireMessage != null) {
                                TBaseLogger.i(CLASS_NAME, "message:" + mqttWireMessage.toString());
                                if (mqttWireMessage instanceof MqttAck) {
                                    this.out.write(mqttWireMessage);
                                    this.out.flush();
                                } else {
                                    MqttToken token = this.tokenStore.getToken(mqttWireMessage);
                                    if (token != null) {
                                        synchronized (token) {
                                            this.out.write(mqttWireMessage);
                                            try {
                                                this.out.flush();
                                            } catch (IOException e2) {
                                                if (!(mqttWireMessage instanceof MqttDisconnect)) {
                                                    throw e2;
                                                    break;
                                                }
                                            }
                                            this.clientState.notifySent(mqttWireMessage);
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            } else {
                                log.fine(CLASS_NAME, "run", "803");
                                this.running = false;
                            }
                        } catch (Exception e3) {
                            handleRunException(mqttWireMessage, e3);
                        }
                    } catch (MqttException e4) {
                        handleRunException(mqttWireMessage, e4);
                    }
                } catch (Throwable th) {
                    this.running = false;
                    this.runningSemaphore.release();
                    throw th;
                }
            }
            this.running = false;
            this.runningSemaphore.release();
            log.fine(CLASS_NAME, "run", "805");
        } catch (InterruptedException unused) {
            this.running = false;
        }
    }

    public void start(String str, ExecutorService executorService) {
        this.threadName = str;
        synchronized (this.lifecycle) {
            if (!this.running) {
                this.running = true;
                this.senderFuture = executorService.submit(this);
            }
        }
    }

    public void stop() {
        Semaphore semaphore;
        synchronized (this.lifecycle) {
            Future future = this.senderFuture;
            if (future != null) {
                future.cancel(true);
            }
            log.fine(CLASS_NAME, "stop", "800");
            if (this.running) {
                this.running = false;
                if (!Thread.currentThread().equals(this.sendThread)) {
                    while (this.running) {
                        try {
                            this.clientState.notifyQueueLock();
                            this.runningSemaphore.tryAcquire(100L, TimeUnit.MILLISECONDS);
                        } catch (InterruptedException unused) {
                            semaphore = this.runningSemaphore;
                        } catch (Throwable th) {
                            this.runningSemaphore.release();
                            throw th;
                        }
                    }
                    semaphore = this.runningSemaphore;
                    semaphore.release();
                }
            }
            this.sendThread = null;
            log.fine(CLASS_NAME, "stop", "801");
        }
    }
}
