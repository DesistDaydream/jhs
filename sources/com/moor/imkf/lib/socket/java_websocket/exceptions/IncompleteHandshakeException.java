package com.moor.imkf.lib.socket.java_websocket.exceptions;

/* loaded from: classes2.dex */
public class IncompleteHandshakeException extends RuntimeException {
    private static final long serialVersionUID = 7906596804233893092L;
    private final int preferredSize;

    public IncompleteHandshakeException(int i2) {
        this.preferredSize = i2;
    }

    public int getPreferredSize() {
        return this.preferredSize;
    }

    public IncompleteHandshakeException() {
        this.preferredSize = 0;
    }
}
