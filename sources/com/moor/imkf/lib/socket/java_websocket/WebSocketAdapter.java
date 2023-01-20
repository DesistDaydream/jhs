package com.moor.imkf.lib.socket.java_websocket;

import com.moor.imkf.lib.socket.java_websocket.drafts.Draft;
import com.moor.imkf.lib.socket.java_websocket.exceptions.InvalidDataException;
import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;
import com.moor.imkf.lib.socket.java_websocket.framing.PingFrame;
import com.moor.imkf.lib.socket.java_websocket.framing.PongFrame;
import com.moor.imkf.lib.socket.java_websocket.handshake.ClientHandshake;
import com.moor.imkf.lib.socket.java_websocket.handshake.HandshakeImpl1Server;
import com.moor.imkf.lib.socket.java_websocket.handshake.ServerHandshake;
import com.moor.imkf.lib.socket.java_websocket.handshake.ServerHandshakeBuilder;

/* loaded from: classes2.dex */
public abstract class WebSocketAdapter implements WebSocketListener {
    private PingFrame pingFrame;

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketListener
    public PingFrame onPreparePing(WebSocket webSocket) {
        if (this.pingFrame == null) {
            this.pingFrame = new PingFrame();
        }
        return this.pingFrame;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketListener
    public void onWebsocketHandshakeReceivedAsClient(WebSocket webSocket, ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidDataException {
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketListener
    public ServerHandshakeBuilder onWebsocketHandshakeReceivedAsServer(WebSocket webSocket, Draft draft, ClientHandshake clientHandshake) throws InvalidDataException {
        return new HandshakeImpl1Server();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketListener
    public void onWebsocketHandshakeSentAsClient(WebSocket webSocket, ClientHandshake clientHandshake) throws InvalidDataException {
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketListener
    public void onWebsocketPing(WebSocket webSocket, Framedata framedata) {
        webSocket.sendFrame(new PongFrame((PingFrame) framedata));
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketListener
    public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
    }
}
