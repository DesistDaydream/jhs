package com.moor.imkf.lib.socket.websocket.request;

import com.moor.imkf.lib.socket.java_websocket.client.WebSocketClient;

/* loaded from: classes2.dex */
public interface Request<T> {
    T getRequestData();

    void release();

    void send(WebSocketClient webSocketClient);

    void setRequestData(T t);
}
