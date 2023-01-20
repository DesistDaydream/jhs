package com.moor.imkf.lib.socket.websocket.request;

import android.text.TextUtils;
import com.moor.imkf.lib.socket.java_websocket.client.WebSocketClient;

/* loaded from: classes2.dex */
public class StringRequest implements Request<String> {
    private String requestText;

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void release() {
        RequestFactory.releaseStringRequest(this);
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void send(WebSocketClient webSocketClient) {
        webSocketClient.send(this.requestText);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = TextUtils.isEmpty(this.requestText) ? "null" : this.requestText;
        return String.format("@StringRequest%s,requestText:%s", objArr);
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public String getRequestData() {
        return this.requestText;
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void setRequestData(String str) {
        this.requestText = str;
    }
}
