package com.bytedance.sdk.openadsdk.live;

import java.io.Serializable;

/* loaded from: classes.dex */
public class TTLiveToken implements Serializable {
    public String accessToken;
    public long expireAt;
    public String name;
    public String openId;
    public String refreshToken;

    public TTLiveToken(String str, String str2, String str3, long j2, String str4) {
        this.expireAt = 0L;
        this.refreshToken = "";
        this.name = str;
        this.accessToken = str2;
        this.openId = str3;
        this.expireAt = j2;
        this.refreshToken = str4;
    }

    public String toString() {
        return "TTLiveToken{accessToken='" + this.accessToken + "', openId='" + this.openId + "', expireAt=" + this.expireAt + ", refreshToken='" + this.refreshToken + "'}";
    }
}
