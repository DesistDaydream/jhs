package com.moor.imkf.lib.socket.websocket.request;

import com.moor.imkf.lib.socket.java_websocket.client.WebSocketClient;
import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;

/* loaded from: classes2.dex */
public class FrameDataRequest implements Request<Framedata> {
    private Framedata framedata;

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void release() {
        RequestFactory.releaseFrameDataRequest(this);
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void send(WebSocketClient webSocketClient) {
        webSocketClient.sendFrame(this.framedata);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashCode());
        Framedata framedata = this.framedata;
        objArr[1] = framedata == null ? "null" : framedata.toString();
        return String.format("[@FrameDataRequest%s,Framedata:%s]", objArr);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public Framedata getRequestData() {
        return this.framedata;
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void setRequestData(Framedata framedata) {
        this.framedata = framedata;
    }
}
