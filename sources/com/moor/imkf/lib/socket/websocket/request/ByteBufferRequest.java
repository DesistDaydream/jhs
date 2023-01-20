package com.moor.imkf.lib.socket.websocket.request;

import com.moor.imkf.lib.socket.java_websocket.client.WebSocketClient;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class ByteBufferRequest implements Request<ByteBuffer> {
    private ByteBuffer data;

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void release() {
        RequestFactory.releaseByteBufferRequest(this);
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void send(WebSocketClient webSocketClient) {
        webSocketClient.send(this.data);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashCode());
        ByteBuffer byteBuffer = this.data;
        objArr[1] = byteBuffer == null ? "null" : byteBuffer.toString();
        return String.format("[@ByteBufferRequest%s,ByteBuffer:%s]", objArr);
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public ByteBuffer getRequestData() {
        return this.data;
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void setRequestData(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
    }
}
