package com.moor.imkf.lib.socket.java_websocket;

import com.moor.imkf.lib.socket.java_websocket.drafts.Draft;
import java.io.IOException;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;

/* loaded from: classes2.dex */
public interface WebSocketServerFactory extends WebSocketFactory {
    void close();

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketFactory
    WebSocketImpl createWebSocket(WebSocketAdapter webSocketAdapter, Draft draft);

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketFactory
    WebSocketImpl createWebSocket(WebSocketAdapter webSocketAdapter, List<Draft> list);

    ByteChannel wrapChannel(SocketChannel socketChannel, SelectionKey selectionKey) throws IOException;
}
