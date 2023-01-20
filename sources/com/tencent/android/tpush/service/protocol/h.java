package com.tencent.android.tpush.service.protocol;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class h {
    public String a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f6308c;

    /* renamed from: d  reason: collision with root package name */
    public String f6309d;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ssid", this.a);
        jSONObject.put("bssid", this.b);
        jSONObject.put("mac", this.f6308c);
        jSONObject.put("wflist", this.f6309d);
        return jSONObject;
    }
}
