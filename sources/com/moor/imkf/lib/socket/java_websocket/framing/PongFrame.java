package com.moor.imkf.lib.socket.java_websocket.framing;

import com.moor.imkf.lib.socket.java_websocket.enums.Opcode;

/* loaded from: classes2.dex */
public class PongFrame extends ControlFrame {
    public PongFrame() {
        super(Opcode.PONG);
    }

    public PongFrame(PingFrame pingFrame) {
        super(Opcode.PONG);
        setPayload(pingFrame.getPayloadData());
    }
}
