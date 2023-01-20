package com.qq.e.comm.util;

/* loaded from: classes3.dex */
public class AdError {
    private int a;
    private String b;

    public AdError() {
    }

    public AdError(int i2, String str) {
        this.a = i2;
        this.b = str;
    }

    public int getErrorCode() {
        return this.a;
    }

    public String getErrorMsg() {
        return this.b;
    }
}
