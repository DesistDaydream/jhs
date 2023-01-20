package com.moor.imkf.lib.socket.java_websocket.exceptions;

/* loaded from: classes2.dex */
public class IncompleteException extends Exception {
    private static final long serialVersionUID = 7330519489840500997L;
    private final int preferredSize;

    public IncompleteException(int i2) {
        this.preferredSize = i2;
    }

    public int getPreferredSize() {
        return this.preferredSize;
    }
}
