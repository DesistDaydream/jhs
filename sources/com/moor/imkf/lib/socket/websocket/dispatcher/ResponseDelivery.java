package com.moor.imkf.lib.socket.websocket.dispatcher;

import com.moor.imkf.lib.socket.websocket.SocketListener;

/* loaded from: classes2.dex */
public interface ResponseDelivery extends SocketListener {
    void addListener(SocketListener socketListener);

    void clear();

    boolean isEmpty();

    void removeListener(SocketListener socketListener);
}
