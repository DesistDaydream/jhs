package com.moor.imkf.lib.socket.java_websocket.extensions;

import com.moor.imkf.lib.socket.java_websocket.exceptions.InvalidDataException;
import com.moor.imkf.lib.socket.java_websocket.exceptions.InvalidFrameException;
import com.moor.imkf.lib.socket.java_websocket.framing.ControlFrame;
import com.moor.imkf.lib.socket.java_websocket.framing.DataFrame;
import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;

/* loaded from: classes2.dex */
public abstract class CompressionExtension extends DefaultExtension {
    @Override // com.moor.imkf.lib.socket.java_websocket.extensions.DefaultExtension, com.moor.imkf.lib.socket.java_websocket.extensions.IExtension
    public void isFrameValid(Framedata framedata) throws InvalidDataException {
        if ((framedata instanceof DataFrame) && (framedata.isRSV2() || framedata.isRSV3())) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.isRSV1() + " RSV2: " + framedata.isRSV2() + " RSV3: " + framedata.isRSV3());
        } else if (framedata instanceof ControlFrame) {
            if (framedata.isRSV1() || framedata.isRSV2() || framedata.isRSV3()) {
                throw new InvalidFrameException("bad rsv RSV1: " + framedata.isRSV1() + " RSV2: " + framedata.isRSV2() + " RSV3: " + framedata.isRSV3());
            }
        }
    }
}
