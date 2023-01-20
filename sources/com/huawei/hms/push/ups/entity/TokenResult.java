package com.huawei.hms.push.ups.entity;

/* loaded from: classes2.dex */
public class TokenResult extends CodeResult {

    /* renamed from: c  reason: collision with root package name */
    public String f3677c;

    public TokenResult() {
    }

    public String getToken() {
        return this.f3677c;
    }

    public void setToken(String str) {
        this.f3677c = str;
    }

    public TokenResult(int i2) {
        super(i2);
    }

    public TokenResult(int i2, String str) {
        super(i2, str);
    }

    public TokenResult(String str) {
        this.f3677c = str;
    }
}
