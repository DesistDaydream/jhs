package com.tencent.android.tpns.mqtt.internal;

import com.baidu.mobads.sdk.internal.ca;
import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttAsyncClient;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttMessage;
import com.tencent.android.tpns.mqtt.internal.wire.MqttAck;
import com.tencent.android.tpns.mqtt.internal.wire.MqttConnack;
import com.tencent.android.tpns.mqtt.internal.wire.MqttSuback;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import com.tencent.bugly.Bugly;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;

/* loaded from: classes3.dex */
public class Token {
    private static final String CLASS_NAME = "Token";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private String key;
    private volatile boolean completed = false;
    private boolean pendingComplete = false;
    private boolean sent = false;
    private Object responseLock = new Object();
    private Object sentLock = new Object();
    public MqttMessage message = null;
    private MqttWireMessage response = null;
    private MqttException exception = null;
    private String[] topics = null;
    private IMqttAsyncClient client = null;
    private IMqttActionListener callback = null;
    private Object userContext = null;
    private int messageID = 0;
    private boolean notified = false;

    public Token(String str) {
        log.setResourceName(str);
    }

    public boolean checkResult() throws MqttException {
        if (getException() == null) {
            return true;
        }
        throw getException();
    }

    public IMqttActionListener getActionCallback() {
        return this.callback;
    }

    public IMqttAsyncClient getClient() {
        return this.client;
    }

    public MqttException getException() {
        return this.exception;
    }

    public int[] getGrantedQos() {
        int[] iArr = new int[0];
        MqttWireMessage mqttWireMessage = this.response;
        return mqttWireMessage instanceof MqttSuback ? ((MqttSuback) mqttWireMessage).getGrantedQos() : iArr;
    }

    public String getKey() {
        return this.key;
    }

    public MqttMessage getMessage() {
        return this.message;
    }

    public int getMessageID() {
        return this.messageID;
    }

    public MqttWireMessage getResponse() {
        return this.response;
    }

    public boolean getSessionPresent() {
        MqttWireMessage mqttWireMessage = this.response;
        if (mqttWireMessage instanceof MqttConnack) {
            return ((MqttConnack) mqttWireMessage).getSessionPresent();
        }
        return false;
    }

    public String[] getTopics() {
        return this.topics;
    }

    public Object getUserContext() {
        return this.userContext;
    }

    public MqttWireMessage getWireMessage() {
        return this.response;
    }

    public boolean isComplete() {
        return this.completed;
    }

    public boolean isCompletePending() {
        return this.pendingComplete;
    }

    public boolean isInUse() {
        return (getClient() == null || isComplete()) ? false : true;
    }

    public boolean isNotified() {
        return this.notified;
    }

    public void markComplete(MqttWireMessage mqttWireMessage, MqttException mqttException) {
        log.fine(CLASS_NAME, "markComplete", ca.b, new Object[]{getKey(), mqttWireMessage, mqttException});
        synchronized (this.responseLock) {
            if (mqttWireMessage instanceof MqttAck) {
                this.message = null;
            }
            this.pendingComplete = true;
            this.response = mqttWireMessage;
            this.exception = mqttException;
        }
    }

    public void notifyComplete() {
        log.fine(CLASS_NAME, "notifyComplete", ca.b, new Object[]{getKey(), this.response, this.exception});
        synchronized (this.responseLock) {
            if (this.exception == null && this.pendingComplete) {
                this.completed = true;
                this.pendingComplete = false;
            } else {
                this.pendingComplete = false;
            }
            this.responseLock.notifyAll();
        }
        synchronized (this.sentLock) {
            this.sent = true;
            this.sentLock.notifyAll();
        }
    }

    public void notifySent() {
        log.fine(CLASS_NAME, "notifySent", "403", new Object[]{getKey()});
        synchronized (this.responseLock) {
            this.response = null;
            this.completed = false;
        }
        synchronized (this.sentLock) {
            this.sent = true;
            this.sentLock.notifyAll();
        }
    }

    public void reset() throws MqttException {
        if (!isInUse()) {
            log.fine(CLASS_NAME, "reset", "410", new Object[]{getKey()});
            this.client = null;
            this.completed = false;
            this.response = null;
            this.sent = false;
            this.exception = null;
            this.userContext = null;
            return;
        }
        throw new MqttException(32201);
    }

    public void setActionCallback(IMqttActionListener iMqttActionListener) {
        this.callback = iMqttActionListener;
    }

    public void setClient(IMqttAsyncClient iMqttAsyncClient) {
        this.client = iMqttAsyncClient;
    }

    public void setException(MqttException mqttException) {
        synchronized (this.responseLock) {
            this.exception = mqttException;
        }
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(MqttMessage mqttMessage) {
        this.message = mqttMessage;
    }

    public void setMessageID(int i2) {
        this.messageID = i2;
    }

    public void setNotified(boolean z) {
        this.notified = z;
    }

    public void setTopics(String[] strArr) {
        this.topics = strArr;
    }

    public void setUserContext(Object obj) {
        this.userContext = obj;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(getKey());
        stringBuffer.append(" ,topics=");
        if (getTopics() != null) {
            for (int i2 = 0; i2 < getTopics().length; i2++) {
                stringBuffer.append(getTopics()[i2]);
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(" ,usercontext=");
        stringBuffer.append(getUserContext());
        stringBuffer.append(" ,isComplete=");
        stringBuffer.append(isComplete());
        stringBuffer.append(" ,isNotified=");
        stringBuffer.append(isNotified());
        stringBuffer.append(" ,exception=");
        stringBuffer.append(getException());
        stringBuffer.append(" ,actioncallback=");
        stringBuffer.append(getActionCallback());
        return stringBuffer.toString();
    }

    public void waitForCompletion() throws MqttException {
        waitForCompletion(-1L);
    }

    public MqttWireMessage waitForResponse() throws MqttException {
        return waitForResponse(-1L);
    }

    public void waitUntilSent() throws MqttException {
        boolean z;
        synchronized (this.sentLock) {
            synchronized (this.responseLock) {
                MqttException mqttException = this.exception;
                if (mqttException != null) {
                    throw mqttException;
                }
            }
            while (true) {
                z = this.sent;
                if (z) {
                    break;
                }
                try {
                    log.fine(CLASS_NAME, "waitUntilSent", "409", new Object[]{getKey()});
                    this.sentLock.wait();
                } catch (InterruptedException unused) {
                }
            }
            if (!z) {
                MqttException mqttException2 = this.exception;
                if (mqttException2 == null) {
                    throw ExceptionHelper.createMqttException(6);
                }
                throw mqttException2;
            }
        }
    }

    public void waitForCompletion(long j2) throws MqttException {
        log.fine(CLASS_NAME, "waitForCompletion", "407", new Object[]{getKey(), new Long(j2), this});
        if (waitForResponse(j2) == null && !this.completed) {
            TBaseLogger.e(CLASS_NAME, "waitForCompletion timeout");
            MqttException mqttException = new MqttException(32000);
            this.exception = mqttException;
            throw mqttException;
        }
        checkResult();
    }

    public MqttWireMessage waitForResponse(long j2) throws MqttException {
        synchronized (this.responseLock) {
            Logger logger = log;
            Object[] objArr = new Object[7];
            objArr[0] = getKey();
            objArr[1] = new Long(j2);
            objArr[2] = new Boolean(this.sent);
            objArr[3] = new Boolean(this.completed);
            MqttException mqttException = this.exception;
            objArr[4] = mqttException == null ? Bugly.SDK_IS_DEV : "true";
            objArr[5] = this.response;
            objArr[6] = this;
            logger.fine(CLASS_NAME, "waitForResponse", "400", objArr, mqttException);
            while (!this.completed) {
                if (this.exception == null) {
                    try {
                        log.fine(CLASS_NAME, "waitForResponse", "408", new Object[]{getKey(), new Long(j2)});
                        if (j2 <= 0) {
                            this.responseLock.wait();
                        } else {
                            this.responseLock.wait(j2);
                        }
                    } catch (InterruptedException e2) {
                        this.exception = new MqttException(e2);
                    }
                }
                if (!this.completed) {
                    MqttException mqttException2 = this.exception;
                    if (mqttException2 != null) {
                        log.fine(CLASS_NAME, "waitForResponse", "401", null, mqttException2);
                        throw this.exception;
                    } else if (j2 > 0) {
                        break;
                    }
                }
            }
        }
        log.fine(CLASS_NAME, "waitForResponse", "402", new Object[]{getKey(), this.response});
        return this.response;
    }
}
