package com.moor.imkf.lib.socket.java_websocket.protocols;

/* loaded from: classes2.dex */
public interface IProtocol {
    boolean acceptProvidedProtocol(String str);

    IProtocol copyInstance();

    String getProvidedProtocol();

    String toString();
}
