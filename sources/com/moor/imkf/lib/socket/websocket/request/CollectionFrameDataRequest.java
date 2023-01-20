package com.moor.imkf.lib.socket.websocket.request;

import com.moor.imkf.lib.socket.java_websocket.client.WebSocketClient;
import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;
import java.util.Collection;

/* loaded from: classes2.dex */
public class CollectionFrameDataRequest implements Request<Collection<Framedata>> {
    private Collection<Framedata> data;

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void release() {
        RequestFactory.releaseCollectionFrameRequest(this);
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void send(WebSocketClient webSocketClient) {
        webSocketClient.sendFrame(this.data);
    }

    public String toString() {
        String str;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashCode());
        if (this.data == null) {
            str = "null";
        } else {
            str = this.data.size() + " length";
        }
        objArr[1] = str;
        return String.format("[@CollectionFrameDataRequest%s,Collection<Framedata>:%s]", objArr);
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public Collection<Framedata> getRequestData() {
        return this.data;
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void setRequestData(Collection<Framedata> collection) {
        this.data = collection;
    }
}
