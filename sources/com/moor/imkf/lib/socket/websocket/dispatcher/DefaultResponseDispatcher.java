package com.moor.imkf.lib.socket.websocket.dispatcher;

import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;
import com.moor.imkf.lib.socket.websocket.response.ErrorResponse;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class DefaultResponseDispatcher implements IResponseDispatcher {
    @Override // com.moor.imkf.lib.socket.websocket.dispatcher.IResponseDispatcher
    public void onConnectFailed(Throwable th, ResponseDelivery responseDelivery) {
        responseDelivery.onConnectFailed(th);
    }

    @Override // com.moor.imkf.lib.socket.websocket.dispatcher.IResponseDispatcher
    public void onConnected(ResponseDelivery responseDelivery) {
        responseDelivery.onConnected();
    }

    @Override // com.moor.imkf.lib.socket.websocket.dispatcher.IResponseDispatcher
    public void onDisconnect(ResponseDelivery responseDelivery) {
        responseDelivery.onDisconnect();
    }

    @Override // com.moor.imkf.lib.socket.websocket.dispatcher.IResponseDispatcher
    public void onMessage(String str, ResponseDelivery responseDelivery) {
        responseDelivery.onMessage(str, (String) null);
    }

    @Override // com.moor.imkf.lib.socket.websocket.dispatcher.IResponseDispatcher
    public void onPing(Framedata framedata, ResponseDelivery responseDelivery) {
        responseDelivery.onPing(framedata);
    }

    @Override // com.moor.imkf.lib.socket.websocket.dispatcher.IResponseDispatcher
    public void onPong(Framedata framedata, ResponseDelivery responseDelivery) {
        responseDelivery.onPong(framedata);
    }

    @Override // com.moor.imkf.lib.socket.websocket.dispatcher.IResponseDispatcher
    public void onSendDataError(ErrorResponse errorResponse, ResponseDelivery responseDelivery) {
        responseDelivery.onSendDataError(errorResponse);
    }

    @Override // com.moor.imkf.lib.socket.websocket.dispatcher.IResponseDispatcher
    public void onMessage(ByteBuffer byteBuffer, ResponseDelivery responseDelivery) {
        responseDelivery.onMessage(byteBuffer, (ByteBuffer) null);
    }
}
