package com.moor.imkf.lib.analytics.bean;

/* loaded from: classes2.dex */
public class MoorAnalyticsResult {
    private int return_code;
    private String return_message;
    private String warn_did;

    public int getReturn_code() {
        return this.return_code;
    }

    public String getReturn_message() {
        return this.return_message;
    }

    public String getWarn_did() {
        return this.warn_did;
    }

    public void setReturn_code(int i2) {
        this.return_code = i2;
    }

    public void setReturn_message(String str) {
        this.return_message = str;
    }

    public void setWarn_did(String str) {
        this.warn_did = str;
    }
}
