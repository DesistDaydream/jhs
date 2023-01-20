package com.moor.imkf.lib.socket.java_websocket.extensions;

import com.moor.imkf.lib.socket.java_websocket.exceptions.InvalidDataException;
import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;

/* loaded from: classes2.dex */
public interface IExtension {
    boolean acceptProvidedExtensionAsClient(String str);

    boolean acceptProvidedExtensionAsServer(String str);

    IExtension copyInstance();

    void decodeFrame(Framedata framedata) throws InvalidDataException;

    void encodeFrame(Framedata framedata);

    String getProvidedExtensionAsClient();

    String getProvidedExtensionAsServer();

    void isFrameValid(Framedata framedata) throws InvalidDataException;

    void reset();

    String toString();
}
