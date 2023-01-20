package com.moor.imkf.lib.socket.websocket.request;

import com.moor.imkf.lib.socket.java_websocket.client.WebSocketClient;

/* loaded from: classes2.dex */
public class ByteArrayRequest implements Request<byte[]> {
    private byte[] data;

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void release() {
        RequestFactory.releaseByteArrayRequest(this);
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void send(WebSocketClient webSocketClient) {
        webSocketClient.send(this.data);
    }

    public String toString() {
        String str;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashCode());
        if (this.data == null) {
            str = "data:null";
        } else {
            str = "data.length:" + this.data.length;
        }
        objArr[1] = str;
        return String.format("[@ByteArrayRequest%s,%s]", objArr);
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public byte[] getRequestData() {
        return this.data;
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void setRequestData(byte[] bArr) {
        this.data = bArr;
    }
}
