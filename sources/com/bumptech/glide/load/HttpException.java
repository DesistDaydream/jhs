package com.bumptech.glide.load;

import androidx.annotation.Nullable;
import java.io.IOException;

/* loaded from: classes.dex */
public final class HttpException extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1;
    private final int statusCode;

    public HttpException(int i2) {
        this("Http request failed", i2);
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    @Deprecated
    public HttpException(String str) {
        this(str, -1);
    }

    public HttpException(String str, int i2) {
        this(str, i2, null);
    }

    public HttpException(String str, int i2, @Nullable Throwable th) {
        super(str + ", status code: " + i2, th);
        this.statusCode = i2;
    }
}
