package com.huawei.hms.hatool;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public class f1 extends o {

    /* renamed from: g  reason: collision with root package name */
    public String f3534g = "";

    @Override // com.huawei.hms.hatool.s
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("protocol_version", "1");
        jSONObject.put("compress_mode", "1");
        jSONObject.put("serviceid", this.f3588d);
        jSONObject.put("appid", this.a);
        jSONObject.put("hmac", this.f3534g);
        jSONObject.put("chifer", this.f3590f);
        jSONObject.put("timestamp", this.b);
        jSONObject.put("servicetag", this.f3587c);
        jSONObject.put("requestid", this.f3589e);
        return jSONObject;
    }

    public void g(String str) {
        this.f3534g = str;
    }
}
