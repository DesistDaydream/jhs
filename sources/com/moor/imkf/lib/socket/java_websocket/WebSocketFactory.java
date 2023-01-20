package com.moor.imkf.lib.socket.java_websocket;

import com.moor.imkf.lib.socket.java_websocket.drafts.Draft;
import java.util.List;

/* loaded from: classes2.dex */
public interface WebSocketFactory {
    WebSocket createWebSocket(WebSocketAdapter webSocketAdapter, Draft draft);

    WebSocket createWebSocket(WebSocketAdapter webSocketAdapter, List<Draft> list);
}
