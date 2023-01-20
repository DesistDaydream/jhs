package com.moor.imkf.lib.socket.websocket;

import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;
import com.moor.imkf.lib.socket.websocket.dispatcher.IResponseDispatcher;
import com.moor.imkf.lib.socket.websocket.dispatcher.ResponseDelivery;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public abstract class SimpleDispatcher implements IResponseDispatcher {
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
    public void onMessage(ByteBuffer byteBuffer, ResponseDelivery responseDelivery) {
        responseDelivery.onMessage(byteBuffer, (ByteBuffer) null);
    }

    @Override // com.moor.imkf.lib.socket.websocket.dispatcher.IResponseDispatcher
    public void onPing(Framedata framedata, ResponseDelivery responseDelivery) {
        responseDelivery.onPing(framedata);
    }

    @Override // com.moor.imkf.lib.socket.websocket.dispatcher.IResponseDispatcher
    public void onPong(Framedata framedata, ResponseDelivery responseDelivery) {
        responseDelivery.onPong(framedata);
    }
}
