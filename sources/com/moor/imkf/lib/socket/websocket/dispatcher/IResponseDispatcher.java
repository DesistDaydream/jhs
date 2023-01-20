package com.moor.imkf.lib.socket.websocket.dispatcher;

import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;
import com.moor.imkf.lib.socket.websocket.response.ErrorResponse;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public interface IResponseDispatcher {
    void onConnectFailed(Throwable th, ResponseDelivery responseDelivery);

    void onConnected(ResponseDelivery responseDelivery);

    void onDisconnect(ResponseDelivery responseDelivery);

    void onMessage(String str, ResponseDelivery responseDelivery);

    void onMessage(ByteBuffer byteBuffer, ResponseDelivery responseDelivery);

    void onPing(Framedata framedata, ResponseDelivery responseDelivery);

    void onPong(Framedata framedata, ResponseDelivery responseDelivery);

    void onSendDataError(ErrorResponse errorResponse, ResponseDelivery responseDelivery);
}
