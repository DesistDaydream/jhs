package com.moor.imkf.lib.socket.java_websocket.framing;

import com.moor.imkf.lib.socket.java_websocket.enums.Opcode;
import com.moor.imkf.lib.socket.java_websocket.exceptions.InvalidDataException;
import com.moor.imkf.lib.socket.java_websocket.util.Charsetfunctions;

/* loaded from: classes2.dex */
public class TextFrame extends DataFrame {
    public TextFrame() {
        super(Opcode.TEXT);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.framing.DataFrame, com.moor.imkf.lib.socket.java_websocket.framing.FramedataImpl1
    public void isValid() throws InvalidDataException {
        super.isValid();
        if (!Charsetfunctions.isValidUTF8(getPayloadData())) {
            throw new InvalidDataException(1007, "Received text is no valid utf8 string!");
        }
    }
}
