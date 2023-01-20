package com.moor.imkf.lib.socket.java_websocket;

import com.moor.imkf.lib.socket.java_websocket.drafts.Draft;
import com.moor.imkf.lib.socket.java_websocket.exceptions.InvalidDataException;
import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;
import com.moor.imkf.lib.socket.java_websocket.framing.PingFrame;
import com.moor.imkf.lib.socket.java_websocket.handshake.ClientHandshake;
import com.moor.imkf.lib.socket.java_websocket.handshake.Handshakedata;
import com.moor.imkf.lib.socket.java_websocket.handshake.ServerHandshake;
import com.moor.imkf.lib.socket.java_websocket.handshake.ServerHandshakeBuilder;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public interface WebSocketListener {
    InetSocketAddress getLocalSocketAddress(WebSocket webSocket);

    InetSocketAddress getRemoteSocketAddress(WebSocket webSocket);

    PingFrame onPreparePing(WebSocket webSocket);

    void onWebsocketClose(WebSocket webSocket, int i2, String str, boolean z);

    void onWebsocketCloseInitiated(WebSocket webSocket, int i2, String str);

    void onWebsocketClosing(WebSocket webSocket, int i2, String str, boolean z);

    void onWebsocketError(WebSocket webSocket, Exception exc);

    void onWebsocketHandshakeReceivedAsClient(WebSocket webSocket, ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidDataException;

    ServerHandshakeBuilder onWebsocketHandshakeReceivedAsServer(WebSocket webSocket, Draft draft, ClientHandshake clientHandshake) throws InvalidDataException;

    void onWebsocketHandshakeSentAsClient(WebSocket webSocket, ClientHandshake clientHandshake) throws InvalidDataException;

    void onWebsocketMessage(WebSocket webSocket, String str);

    void onWebsocketMessage(WebSocket webSocket, ByteBuffer byteBuffer);

    void onWebsocketOpen(WebSocket webSocket, Handshakedata handshakedata);

    void onWebsocketPing(WebSocket webSocket, Framedata framedata);

    void onWebsocketPong(WebSocket webSocket, Framedata framedata);

    void onWriteDemand(WebSocket webSocket);
}
