package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.client.Result;

/* loaded from: classes2.dex */
public class TokenResult extends Result {
    @Packed
    public String belongId;
    @Packed
    public String token = "";
    @Packed
    public int retCode = 0;

    public String getBelongId() {
        return this.belongId;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String getToken() {
        return this.token;
    }

    public void setBelongId(String str) {
        this.belongId = str;
    }

    public void setRetCode(int i2) {
        this.retCode = i2;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
