package com.moor.imkf.lib.socket.java_websocket.server;

import com.moor.imkf.lib.socket.java_websocket.WebSocket;
import com.moor.imkf.lib.socket.java_websocket.WebSocketAdapter;
import com.moor.imkf.lib.socket.java_websocket.WebSocketImpl;
import com.moor.imkf.lib.socket.java_websocket.WebSocketServerFactory;
import com.moor.imkf.lib.socket.java_websocket.drafts.Draft;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;

/* loaded from: classes2.dex */
public class DefaultWebSocketServerFactory implements WebSocketServerFactory {
    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketServerFactory
    public void close() {
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketServerFactory
    public SocketChannel wrapChannel(SocketChannel socketChannel, SelectionKey selectionKey) {
        return socketChannel;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketServerFactory, com.moor.imkf.lib.socket.java_websocket.WebSocketFactory
    public /* bridge */ /* synthetic */ WebSocket createWebSocket(WebSocketAdapter webSocketAdapter, List list) {
        return createWebSocket(webSocketAdapter, (List<Draft>) list);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketServerFactory, com.moor.imkf.lib.socket.java_websocket.WebSocketFactory
    public WebSocketImpl createWebSocket(WebSocketAdapter webSocketAdapter, Draft draft) {
        return new WebSocketImpl(webSocketAdapter, draft);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketServerFactory, com.moor.imkf.lib.socket.java_websocket.WebSocketFactory
    public WebSocketImpl createWebSocket(WebSocketAdapter webSocketAdapter, List<Draft> list) {
        return new WebSocketImpl(webSocketAdapter, list);
    }
}
