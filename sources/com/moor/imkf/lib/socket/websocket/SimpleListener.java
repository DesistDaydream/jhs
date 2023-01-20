package com.moor.imkf.lib.socket.websocket;

import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;
import com.moor.imkf.lib.socket.websocket.response.ErrorResponse;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public abstract class SimpleListener implements SocketListener {
    private final String TAG = "SimpleListener";

    @Override // com.moor.imkf.lib.socket.websocket.SocketListener
    public void onConnectFailed(Throwable th) {
    }

    @Override // com.moor.imkf.lib.socket.websocket.SocketListener
    public void onConnected() {
    }

    @Override // com.moor.imkf.lib.socket.websocket.SocketListener
    public void onDisconnect() {
    }

    @Override // com.moor.imkf.lib.socket.websocket.SocketListener
    public <T> void onMessage(String str, T t) {
    }

    @Override // com.moor.imkf.lib.socket.websocket.SocketListener
    public <T> void onMessage(ByteBuffer byteBuffer, T t) {
    }

    @Override // com.moor.imkf.lib.socket.websocket.SocketListener
    public void onPing(Framedata framedata) {
    }

    @Override // com.moor.imkf.lib.socket.websocket.SocketListener
    public void onPong(Framedata framedata) {
    }

    @Override // com.moor.imkf.lib.socket.websocket.SocketListener
    public void onSendDataError(ErrorResponse errorResponse) {
    }
}
