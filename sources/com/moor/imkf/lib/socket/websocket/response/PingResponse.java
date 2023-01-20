package com.moor.imkf.lib.socket.websocket.response;

import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;
import com.moor.imkf.lib.socket.websocket.dispatcher.IResponseDispatcher;
import com.moor.imkf.lib.socket.websocket.dispatcher.ResponseDelivery;

/* loaded from: classes2.dex */
public class PingResponse implements Response<Framedata> {
    private Framedata framedata;

    @Override // com.moor.imkf.lib.socket.websocket.response.Response
    public void onResponse(IResponseDispatcher iResponseDispatcher, ResponseDelivery responseDelivery) {
        iResponseDispatcher.onPing(this.framedata, responseDelivery);
    }

    @Override // com.moor.imkf.lib.socket.websocket.response.Response
    public void release() {
        this.framedata = null;
        ResponseFactory.releasePingResponse(this);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashCode());
        Framedata framedata = this.framedata;
        objArr[1] = framedata == null ? "null" : framedata.toString();
        return String.format("[@PingResponse%s->Framedata:%s]", objArr);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.moor.imkf.lib.socket.websocket.response.Response
    public Framedata getResponseData() {
        return this.framedata;
    }

    @Override // com.moor.imkf.lib.socket.websocket.response.Response
    public void setResponseData(Framedata framedata) {
        this.framedata = framedata;
    }
}
