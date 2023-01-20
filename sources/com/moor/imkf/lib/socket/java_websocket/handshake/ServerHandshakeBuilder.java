package com.moor.imkf.lib.socket.java_websocket.handshake;

/* loaded from: classes2.dex */
public interface ServerHandshakeBuilder extends HandshakeBuilder, ServerHandshake {
    void setHttpStatus(short s);

    void setHttpStatusMessage(String str);
}
