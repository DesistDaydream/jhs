package com.moor.imkf.lib.socket.websocket;

import com.moor.imkf.lib.socket.java_websocket.drafts.Draft;
import com.moor.imkf.lib.socket.websocket.dispatcher.DefaultResponseDispatcher;
import com.moor.imkf.lib.socket.websocket.dispatcher.IResponseDispatcher;
import com.moor.imkf.lib.socket.websocket.dispatcher.ResponseDelivery;
import java.net.Proxy;
import java.util.Map;

/* loaded from: classes2.dex */
public class WebSocketSetting {
    private String connectUrl;
    private Draft draft;
    private Map<String, String> httpHeaders;
    private Proxy mProxy;
    private boolean processDataOnBackground;
    private ResponseDelivery responseDelivery;
    private IResponseDispatcher responseProcessDispatcher;
    private boolean reconnectWithNetworkChanged = true;
    private int connectionLostTimeout = 60;
    private int connectTimeout = 0;
    private int reconnectFrequency = 10;

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public String getConnectUrl() {
        return this.connectUrl;
    }

    public int getConnectionLostTimeout() {
        return this.connectionLostTimeout;
    }

    public Draft getDraft() {
        return this.draft;
    }

    public Map<String, String> getHttpHeaders() {
        return this.httpHeaders;
    }

    public Proxy getProxy() {
        return this.mProxy;
    }

    public int getReconnectFrequency() {
        return this.reconnectFrequency;
    }

    public ResponseDelivery getResponseDelivery() {
        return this.responseDelivery;
    }

    public IResponseDispatcher getResponseDispatcher() {
        if (this.responseProcessDispatcher == null) {
            this.responseProcessDispatcher = new DefaultResponseDispatcher();
        }
        return this.responseProcessDispatcher;
    }

    public boolean processDataOnBackground() {
        return this.processDataOnBackground;
    }

    public boolean reconnectWithNetworkChanged() {
        return this.reconnectWithNetworkChanged;
    }

    public void setConnectTimeout(int i2) {
        this.connectTimeout = i2;
    }

    public void setConnectUrl(String str) {
        this.connectUrl = str;
    }

    public void setConnectionLostTimeout(int i2) {
        this.connectionLostTimeout = i2;
    }

    public void setDraft(Draft draft) {
        this.draft = draft;
    }

    public void setHttpHeaders(Map<String, String> map) {
        this.httpHeaders = map;
    }

    public void setProcessDataOnBackground(boolean z) {
        this.processDataOnBackground = z;
    }

    public void setProxy(Proxy proxy) {
        this.mProxy = proxy;
    }

    public void setReconnectFrequency(int i2) {
        this.reconnectFrequency = i2;
    }

    public void setReconnectWithNetworkChanged(boolean z) {
        this.reconnectWithNetworkChanged = z;
    }

    public void setResponseDelivery(ResponseDelivery responseDelivery) {
        this.responseDelivery = responseDelivery;
    }

    public void setResponseProcessDispatcher(IResponseDispatcher iResponseDispatcher) {
        this.responseProcessDispatcher = iResponseDispatcher;
    }
}
