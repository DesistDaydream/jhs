package com.moor.imkf.lib.socket.java_websocket.handshake;

import java.util.Iterator;

/* loaded from: classes2.dex */
public interface Handshakedata {
    byte[] getContent();

    String getFieldValue(String str);

    boolean hasFieldValue(String str);

    Iterator<String> iterateHttpFields();
}
