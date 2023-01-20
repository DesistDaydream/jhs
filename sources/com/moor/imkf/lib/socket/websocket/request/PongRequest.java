package com.moor.imkf.lib.socket.websocket.request;

import com.moor.imkf.lib.socket.java_websocket.client.WebSocketClient;
import com.moor.imkf.lib.socket.java_websocket.framing.PingFrame;
import com.moor.imkf.lib.socket.java_websocket.framing.PongFrame;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes2.dex */
public class PongRequest implements Request<PingFrame> {
    private static Queue<PongFrame> PONG_POOL = new ArrayDeque(7);
    private PingFrame pingFrame;

    private PongFrame getPongFrame() {
        PongFrame poll = PONG_POOL.poll();
        return poll == null ? new PongFrame() : poll;
    }

    private void offerPongFrame(PongFrame pongFrame) {
        this.pingFrame = null;
        PONG_POOL.offer(pongFrame);
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void release() {
        RequestFactory.releasePongRequest(this);
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void send(WebSocketClient webSocketClient) {
        PongFrame pongFrame = getPongFrame();
        PingFrame pingFrame = this.pingFrame;
        if (pingFrame != null) {
            pongFrame.setPayload(pingFrame.getPayloadData());
            this.pingFrame = null;
        } else {
            pongFrame.setPayload(null);
        }
        webSocketClient.sendFrame(pongFrame);
        offerPongFrame(pongFrame);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashCode());
        PingFrame pingFrame = this.pingFrame;
        objArr[1] = pingFrame == null ? "null" : pingFrame.toString();
        return String.format("[@PongRequest%s,PingFrame:%s]", objArr);
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public PingFrame getRequestData() {
        return this.pingFrame;
    }

    @Override // com.moor.imkf.lib.socket.websocket.request.Request
    public void setRequestData(PingFrame pingFrame) {
        this.pingFrame = pingFrame;
    }
}
