package com.moor.imkf.lib.socket.java_websocket.exceptions;

/* loaded from: classes2.dex */
public class LimitExceededException extends InvalidDataException {
    private static final long serialVersionUID = 6908339749836826785L;
    private final int limit;

    public LimitExceededException() {
        this(Integer.MAX_VALUE);
    }

    public int getLimit() {
        return this.limit;
    }

    public LimitExceededException(int i2) {
        super(1009);
        this.limit = i2;
    }

    public LimitExceededException(String str, int i2) {
        super(1009, str);
        this.limit = i2;
    }

    public LimitExceededException(String str) {
        this(str, Integer.MAX_VALUE);
    }
}
