package com.moor.imkf.lib.socket.websocket;

import com.moor.imkf.lib.socket.websocket.request.Request;
import com.moor.imkf.lib.socket.websocket.response.Response;

/* loaded from: classes2.dex */
public interface SocketWrapperListener {
    void onConnectFailed(Throwable th);

    void onConnected();

    void onDisconnect();

    void onMessage(Response response);

    void onSendDataError(Request request, int i2, Throwable th);
}
