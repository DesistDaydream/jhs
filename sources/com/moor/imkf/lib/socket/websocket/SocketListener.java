package com.moor.imkf.lib.socket.websocket;

import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;
import com.moor.imkf.lib.socket.websocket.response.ErrorResponse;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public interface SocketListener {
    void onConnectFailed(Throwable th);

    void onConnected();

    void onDisconnect();

    <T> void onMessage(String str, T t);

    <T> void onMessage(ByteBuffer byteBuffer, T t);

    void onPing(Framedata framedata);

    void onPong(Framedata framedata);

    void onSendDataError(ErrorResponse errorResponse);
}
