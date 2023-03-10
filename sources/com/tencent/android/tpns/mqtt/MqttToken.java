package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.Token;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;

/* loaded from: classes3.dex */
public class MqttToken implements IMqttToken {
    public Token internalTok;

    public MqttToken() {
        this.internalTok = null;
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttToken
    public IMqttActionListener getActionCallback() {
        return this.internalTok.getActionCallback();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttToken
    public IMqttAsyncClient getClient() {
        return this.internalTok.getClient();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttToken
    public MqttException getException() {
        return this.internalTok.getException();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttToken
    public int[] getGrantedQos() {
        return this.internalTok.getGrantedQos();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttToken
    public int getMessageId() {
        return this.internalTok.getMessageID();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttToken
    public MqttWireMessage getResponse() {
        return this.internalTok.getResponse();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttToken
    public boolean getSessionPresent() {
        return this.internalTok.getSessionPresent();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttToken
    public String[] getTopics() {
        return this.internalTok.getTopics();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttToken
    public Object getUserContext() {
        return this.internalTok.getUserContext();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttToken
    public boolean isComplete() {
        return this.internalTok.isComplete();
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttToken
    public void setActionCallback(IMqttActionListener iMqttActionListener) {
        this.internalTok.setActionCallback(iMqttActionListener);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttToken
    public void setUserContext(Object obj) {
        this.internalTok.setUserContext(obj);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttToken
    public void waitForCompletion() throws MqttException {
        this.internalTok.waitForCompletion(-1L);
    }

    @Override // com.tencent.android.tpns.mqtt.IMqttToken
    public void waitForCompletion(long j2) throws MqttException {
        this.internalTok.waitForCompletion(j2);
    }

    public MqttToken(String str) {
        this.internalTok = null;
        this.internalTok = new Token(str);
    }
}
