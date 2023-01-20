package com.bytedance.sdk.openadsdk;

/* loaded from: classes.dex */
public class CSJAdError {
    private int a;
    private String b;

    public CSJAdError(int i2, String str) {
        this.a = i2;
        this.b = str;
    }

    public int getCode() {
        return this.a;
    }

    public String getMsg() {
        return this.b;
    }
}
