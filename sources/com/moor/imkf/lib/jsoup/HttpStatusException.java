package com.moor.imkf.lib.jsoup;

import java.io.IOException;

/* loaded from: classes2.dex */
public class HttpStatusException extends IOException {
    private int statusCode;
    private String url;

    public HttpStatusException(String str, int i2, String str2) {
        super(str);
        this.statusCode = i2;
        this.url = str2;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getUrl() {
        return this.url;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + ". Status=" + this.statusCode + ", URL=" + this.url;
    }
}
