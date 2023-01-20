package com.tencent.android.tpush.service.protocol;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class o {
    public String a = "";
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f6353c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f6354d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f6355e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f6356f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f6357g = "";

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bootTime", this.a);
        jSONObject.put("countryCode", this.b);
        jSONObject.put("deviceName", this.f6353c);
        jSONObject.put("carrierInfo", this.f6354d);
        jSONObject.put("memorySize", this.f6355e);
        jSONObject.put("diskSize", this.f6356f);
        jSONObject.put("sysFileTime", this.f6357g);
        return jSONObject;
    }
}
