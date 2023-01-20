package com.moor.imkf.lib.socket.java_websocket.framing;

import com.moor.imkf.lib.socket.java_websocket.enums.Opcode;

/* loaded from: classes2.dex */
public class ContinuousFrame extends DataFrame {
    public ContinuousFrame() {
        super(Opcode.CONTINUOUS);
    }
}
