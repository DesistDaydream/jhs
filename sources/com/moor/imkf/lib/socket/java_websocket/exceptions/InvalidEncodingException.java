package com.moor.imkf.lib.socket.java_websocket.exceptions;

import java.io.UnsupportedEncodingException;

/* loaded from: classes2.dex */
public class InvalidEncodingException extends RuntimeException {
    private final UnsupportedEncodingException encodingException;

    public InvalidEncodingException(UnsupportedEncodingException unsupportedEncodingException) {
        if (unsupportedEncodingException != null) {
            this.encodingException = unsupportedEncodingException;
            return;
        }
        throw new IllegalArgumentException();
    }

    public UnsupportedEncodingException getEncodingException() {
        return this.encodingException;
    }
}
