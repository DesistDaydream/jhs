package com.moor.imkf.lib.jsoup;

import java.io.IOException;

/* loaded from: classes2.dex */
public class UncheckedIOException extends RuntimeException {
    public UncheckedIOException(IOException iOException) {
        super(iOException);
    }

    public IOException ioException() {
        return (IOException) getCause();
    }

    public UncheckedIOException(String str) {
        super(new IOException(str));
    }
}
