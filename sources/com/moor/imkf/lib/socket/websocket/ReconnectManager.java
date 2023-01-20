package com.moor.imkf.lib.socket.websocket;

/* loaded from: classes2.dex */
public interface ReconnectManager {

    /* loaded from: classes2.dex */
    public interface OnConnectListener {
        void onConnected();

        void onDisconnect();
    }

    void destroy();

    void onConnectError(Throwable th);

    void onConnected();

    boolean reconnecting();

    void startReconnect();

    void stopReconnect();
}
