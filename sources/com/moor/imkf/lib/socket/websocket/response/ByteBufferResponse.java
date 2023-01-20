package com.moor.imkf.lib.socket.websocket.response;

import com.moor.imkf.lib.socket.websocket.dispatcher.IResponseDispatcher;
import com.moor.imkf.lib.socket.websocket.dispatcher.ResponseDelivery;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class ByteBufferResponse implements Response<ByteBuffer> {
    private ByteBuffer data;

    @Override // com.moor.imkf.lib.socket.websocket.response.Response
    public void onResponse(IResponseDispatcher iResponseDispatcher, ResponseDelivery responseDelivery) {
        iResponseDispatcher.onMessage(this.data, responseDelivery);
        release();
    }

    @Override // com.moor.imkf.lib.socket.websocket.response.Response
    public void release() {
        ResponseFactory.releaseByteBufferResponse(this);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashCode());
        ByteBuffer byteBuffer = this.data;
        objArr[1] = byteBuffer == null ? "null" : byteBuffer.toString();
        return String.format("[@ByteBufferResponse%s->ByteBuffer:%s]", objArr);
    }

    @Override // com.moor.imkf.lib.socket.websocket.response.Response
    public ByteBuffer getResponseData() {
        return this.data;
    }

    @Override // com.moor.imkf.lib.socket.websocket.response.Response
    public void setResponseData(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
    }
}
