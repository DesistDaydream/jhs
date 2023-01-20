package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttMessageListener;
import com.tencent.android.tpns.mqtt.MqttCallback;
import com.tencent.android.tpns.mqtt.MqttCallbackExtended;
import com.tencent.android.tpns.mqtt.MqttDeliveryToken;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import com.tencent.android.tpns.mqtt.MqttToken;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPubComp;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPublish;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

/* loaded from: classes3.dex */
public class CommsCallback extends TTask {
    private static final int INBOUND_QUEUE_SIZE = 10;
    private Future callbackFuture;
    private Thread callbackThread;
    private ClientComms clientComms;
    private ClientState clientState;
    private MqttCallback mqttCallback;
    private MqttCallbackExtended reconnectInternalCallback;
    private String threadName;
    private static final String CLASS_NAME = "CommsCallback";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    public boolean running = false;
    private boolean quiescing = false;
    private Object lifecycle = new Object();
    private Object workAvailable = new Object();
    private Object spaceAvailable = new Object();
    private boolean manualAcks = false;
    private final Semaphore runningSemaphore = new Semaphore(1);
    private Vector messageQueue = new Vector(10);
    private Vector completeQueue = new Vector(10);
    private Hashtable callbacks = new Hashtable();

    public CommsCallback(ClientComms clientComms) {
        this.clientComms = clientComms;
        log.setResourceName(clientComms.getClient().getClientId());
    }

    private void handleActionComplete(MqttToken mqttToken) throws MqttException {
        synchronized (mqttToken) {
            log.fine(CLASS_NAME, "handleActionComplete", "705", new Object[]{mqttToken.internalTok.getKey()});
            if (mqttToken.isComplete()) {
                this.clientState.notifyComplete(mqttToken);
            }
            mqttToken.internalTok.notifyComplete();
            if (!mqttToken.internalTok.isNotified()) {
                if (this.mqttCallback != null && (mqttToken instanceof MqttDeliveryToken) && mqttToken.isComplete()) {
                    this.mqttCallback.deliveryComplete((MqttDeliveryToken) mqttToken);
                }
                fireActionEvent(mqttToken);
            }
            if (mqttToken.isComplete() && ((mqttToken instanceof MqttDeliveryToken) || (mqttToken.getActionCallback() instanceof IMqttActionListener))) {
                mqttToken.internalTok.setNotified(true);
            }
        }
    }

    private void handleMessage(MqttPublish mqttPublish) throws MqttException, Exception {
        String topicName = mqttPublish.getTopicName();
        log.fine(CLASS_NAME, "handleMessage", "713", new Object[]{new Integer(mqttPublish.getMessageId()), topicName});
        deliverMessage(topicName, mqttPublish.getMessageId(), mqttPublish.getMessage());
        if (this.manualAcks) {
            return;
        }
        if (mqttPublish.getMessage().getQos() == 1) {
            this.clientComms.internalSend(new MqttPubAck(mqttPublish), new MqttToken(this.clientComms.getClient().getClientId()));
        } else if (mqttPublish.getMessage().getQos() == 2) {
            this.clientComms.deliveryComplete(mqttPublish);
            MqttPubComp mqttPubComp = new MqttPubComp(mqttPublish);
            ClientComms clientComms = this.clientComms;
            clientComms.internalSend(mqttPubComp, new MqttToken(clientComms.getClient().getClientId()));
        }
    }

    @Override // com.tencent.tpns.baseapi.base.util.TTask
    public void TRun() {
        MqttToken mqttToken;
        MqttPublish mqttPublish;
        TBaseLogger.d(CLASS_NAME, "run loop callback thread:" + this.threadName);
        Thread currentThread = Thread.currentThread();
        this.callbackThread = currentThread;
        currentThread.setName(this.threadName);
        try {
            this.runningSemaphore.acquire();
            while (this.running) {
                try {
                    try {
                        synchronized (this.workAvailable) {
                            if (this.running && this.messageQueue.isEmpty() && this.completeQueue.isEmpty()) {
                                log.fine(CLASS_NAME, "run", "704");
                                this.workAvailable.wait();
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            TBaseLogger.e(CLASS_NAME, "run", th);
                            this.running = false;
                            this.clientComms.shutdownConnection(null, new MqttException(th));
                            this.runningSemaphore.release();
                            synchronized (this.spaceAvailable) {
                                log.fine(CLASS_NAME, "run", "706");
                                this.spaceAvailable.notifyAll();
                            }
                        } catch (Throwable th2) {
                            this.runningSemaphore.release();
                            synchronized (this.spaceAvailable) {
                                log.fine(CLASS_NAME, "run", "706");
                                this.spaceAvailable.notifyAll();
                                throw th2;
                            }
                        }
                    }
                } catch (InterruptedException unused) {
                }
                if (this.running) {
                    synchronized (this.completeQueue) {
                        if (this.completeQueue.isEmpty()) {
                            mqttToken = null;
                        } else {
                            mqttToken = (MqttToken) this.completeQueue.elementAt(0);
                            this.completeQueue.removeElementAt(0);
                        }
                    }
                    if (mqttToken != null) {
                        handleActionComplete(mqttToken);
                    }
                    synchronized (this.messageQueue) {
                        if (this.messageQueue.isEmpty()) {
                            mqttPublish = null;
                        } else {
                            mqttPublish = (MqttPublish) this.messageQueue.elementAt(0);
                            this.messageQueue.removeElementAt(0);
                        }
                    }
                    if (mqttPublish != null) {
                        handleMessage(mqttPublish);
                    }
                }
                if (this.quiescing) {
                    this.clientState.checkQuiesceLock();
                }
                this.runningSemaphore.release();
                synchronized (this.spaceAvailable) {
                    log.fine(CLASS_NAME, "run", "706");
                    this.spaceAvailable.notifyAll();
                }
            }
        } catch (InterruptedException unused2) {
            this.running = false;
        }
    }

    public void asyncOperationComplete(MqttToken mqttToken) {
        if (this.running) {
            this.completeQueue.addElement(mqttToken);
            synchronized (this.workAvailable) {
                log.fine(CLASS_NAME, "asyncOperationComplete", "715", new Object[]{mqttToken.internalTok.getKey()});
                this.workAvailable.notifyAll();
            }
            return;
        }
        try {
            handleActionComplete(mqttToken);
        } catch (Throwable th) {
            TBaseLogger.e(CLASS_NAME, "asyncOperationComplete", th);
            this.clientComms.shutdownConnection(null, new MqttException(th));
        }
    }

    public void connectionLost(MqttException mqttException) {
        try {
            if (this.mqttCallback != null && mqttException != null) {
                log.fine(CLASS_NAME, "connectionLost", "708", new Object[]{mqttException});
                this.mqttCallback.connectionLost(mqttException);
            }
            MqttCallbackExtended mqttCallbackExtended = this.reconnectInternalCallback;
            if (mqttCallbackExtended == null || mqttException == null) {
                return;
            }
            mqttCallbackExtended.connectionLost(mqttException);
        } catch (Throwable th) {
            TBaseLogger.e(CLASS_NAME, "connectionLost", th);
        }
    }

    public boolean deliverMessage(String str, int i2, MqttMessage mqttMessage) throws Exception {
        Enumeration keys = this.callbacks.keys();
        boolean z = false;
        while (keys.hasMoreElements()) {
            String str2 = (String) keys.nextElement();
            if (MqttTopic.isMatched(str2, str)) {
                mqttMessage.setId(i2);
                ((IMqttMessageListener) this.callbacks.get(str2)).messageArrived(str, mqttMessage);
                z = true;
            }
        }
        if (this.mqttCallback == null || z) {
            return z;
        }
        mqttMessage.setId(i2);
        this.mqttCallback.messageArrived(str, mqttMessage);
        return true;
    }

    public void fireActionEvent(MqttToken mqttToken) {
        IMqttActionListener actionCallback;
        if (mqttToken == null || (actionCallback = mqttToken.getActionCallback()) == null) {
            return;
        }
        if (mqttToken.getException() == null) {
            log.fine(CLASS_NAME, "fireActionEvent", "716", new Object[]{mqttToken.internalTok.getKey()});
            actionCallback.onSuccess(mqttToken);
            return;
        }
        log.fine(CLASS_NAME, "fireActionEvent", "716", new Object[]{mqttToken.internalTok.getKey()});
        actionCallback.onFailure(mqttToken, mqttToken.getException());
    }

    public Thread getThread() {
        return this.callbackThread;
    }

    public boolean isQuiesced() {
        return this.quiescing && this.completeQueue.size() == 0 && this.messageQueue.size() == 0;
    }

    public void messageArrived(MqttPublish mqttPublish) {
        if (this.mqttCallback != null || this.callbacks.size() > 0) {
            synchronized (this.spaceAvailable) {
                while (this.running && !this.quiescing && this.messageQueue.size() >= 10) {
                    try {
                        log.fine(CLASS_NAME, "messageArrived", "709");
                        this.spaceAvailable.wait(200L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            if (this.quiescing) {
                return;
            }
            this.messageQueue.addElement(mqttPublish);
            synchronized (this.workAvailable) {
                log.fine(CLASS_NAME, "messageArrived", "710");
                this.workAvailable.notifyAll();
            }
        }
    }

    public void messageArrivedComplete(int i2, int i3) throws MqttException {
        if (i3 == 1) {
            this.clientComms.internalSend(new MqttPubAck(i2), new MqttToken(this.clientComms.getClient().getClientId()));
        } else if (i3 == 2) {
            this.clientComms.deliveryComplete(i2);
            MqttPubComp mqttPubComp = new MqttPubComp(i2);
            ClientComms clientComms = this.clientComms;
            clientComms.internalSend(mqttPubComp, new MqttToken(clientComms.getClient().getClientId()));
        }
    }

    public void quiesce() {
        this.quiescing = true;
        synchronized (this.spaceAvailable) {
            log.fine(CLASS_NAME, "quiesce", "711");
            this.spaceAvailable.notifyAll();
        }
    }

    public void removeMessageListener(String str) {
        this.callbacks.remove(str);
    }

    public void removeMessageListeners() {
        this.callbacks.clear();
    }

    public void setCallback(MqttCallback mqttCallback) {
        this.mqttCallback = mqttCallback;
    }

    public void setClientState(ClientState clientState) {
        this.clientState = clientState;
    }

    public void setManualAcks(boolean z) {
        this.manualAcks = z;
    }

    public void setMessageListener(String str, IMqttMessageListener iMqttMessageListener) {
        this.callbacks.put(str, iMqttMessageListener);
    }

    public void setReconnectCallback(MqttCallbackExtended mqttCallbackExtended) {
        this.reconnectInternalCallback = mqttCallbackExtended;
    }

    public void start(String str, ExecutorService executorService) {
        this.threadName = str;
        synchronized (this.lifecycle) {
            if (!this.running) {
                this.messageQueue.clear();
                this.completeQueue.clear();
                this.running = true;
                this.quiescing = false;
                this.callbackFuture = executorService.submit(this);
            }
        }
    }

    public void stop() {
        Semaphore semaphore;
        synchronized (this.lifecycle) {
            Future future = this.callbackFuture;
            if (future != null) {
                future.cancel(true);
            }
            if (this.running) {
                Logger logger = log;
                logger.fine(CLASS_NAME, "stop", "700");
                this.running = false;
                if (!Thread.currentThread().equals(this.callbackThread)) {
                    try {
                        synchronized (this.workAvailable) {
                            logger.fine(CLASS_NAME, "stop", "701");
                            this.workAvailable.notifyAll();
                        }
                        this.runningSemaphore.acquire();
                        semaphore = this.runningSemaphore;
                    } catch (InterruptedException unused) {
                        semaphore = this.runningSemaphore;
                    }
                    semaphore.release();
                }
            }
            this.callbackThread = null;
            log.fine(CLASS_NAME, "stop", "703");
        }
    }
}
