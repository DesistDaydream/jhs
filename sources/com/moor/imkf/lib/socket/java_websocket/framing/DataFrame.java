package com.moor.imkf.lib.socket.java_websocket.framing;

import com.moor.imkf.lib.socket.java_websocket.enums.Opcode;
import com.moor.imkf.lib.socket.java_websocket.exceptions.InvalidDataException;

/* loaded from: classes2.dex */
public abstract class DataFrame extends FramedataImpl1 {
    public DataFrame(Opcode opcode) {
        super(opcode);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.framing.FramedataImpl1
    public void isValid() throws InvalidDataException {
    }
}
