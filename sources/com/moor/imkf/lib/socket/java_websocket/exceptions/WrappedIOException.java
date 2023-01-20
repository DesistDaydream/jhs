package com.moor.imkf.lib.socket.java_websocket.exceptions;

import com.moor.imkf.lib.socket.java_websocket.WebSocket;
import java.io.IOException;

/* loaded from: classes2.dex */
public class WrappedIOException extends Exception {
    private final WebSocket connection;
    private final IOException ioException;

    public WrappedIOException(WebSocket webSocket, IOException iOException) {
        this.connection = webSocket;
        this.ioException = iOException;
    }

    public WebSocket getConnection() {
        return this.connection;
    }

    public IOException getIOException() {
        return this.ioException;
    }
}
