package com.moor.imkf.lib.socket.websocket.request;

import com.moor.imkf.lib.socket.java_websocket.client.WebSocketClient;

/* loaded from: classes2.dex */
public class PingRequest implements Request<Object> {
    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public Object getRequestData() {
        return null;
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void release() {
        RequestFactory.releasePingRequest(this);
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void send(WebSocketClient webSocketClient) {
        webSocketClient.sendPing();
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void setRequestData(Object obj) {
    }
}
