package com.moor.imkf.lib.socket.java_websocket.framing;

import com.moor.imkf.lib.socket.java_websocket.enums.Opcode;
import com.moor.imkf.lib.socket.java_websocket.exceptions.InvalidDataException;
import com.moor.imkf.lib.socket.java_websocket.exceptions.InvalidFrameException;

/* loaded from: classes2.dex */
public abstract class ControlFrame extends FramedataImpl1 {
    public ControlFrame(Opcode opcode) {
        super(opcode);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.framing.FramedataImpl1
    public void isValid() throws InvalidDataException {
        if (isFin()) {
            if (!isRSV1()) {
                if (!isRSV2()) {
                    if (isRSV3()) {
                        throw new InvalidFrameException("Control frame can't have rsv3==true set");
                    }
                    return;
                }
                throw new InvalidFrameException("Control frame can't have rsv2==true set");
            }
            throw new InvalidFrameException("Control frame can't have rsv1==true set");
        }
        throw new InvalidFrameException("Control frame can't have fin==false set");
    }
}
