package com.huawei.hms.hatool;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public class e1 extends n {
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f3526c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f3527d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f3528e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f3529f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f3530g;

    @Override // com.huawei.hms.hatool.s
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("androidid", this.a);
        jSONObject.put("oaid", this.f3530g);
        jSONObject.put("uuid", this.f3529f);
        jSONObject.put("upid", this.f3528e);
        jSONObject.put("imei", this.b);
        jSONObject.put("sn", this.f3526c);
        jSONObject.put("udid", this.f3527d);
        return jSONObject;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.f3530g = str;
    }

    public void d(String str) {
        this.f3526c = str;
    }

    public void e(String str) {
        this.f3527d = str;
    }

    public void f(String str) {
        this.f3528e = str;
    }

    public void g(String str) {
        this.f3529f = str;
    }
}
