package com.huawei.hms.hatool;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class q implements s {
    public String a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f3598c;

    /* renamed from: d  reason: collision with root package name */
    public String f3599d;

    /* renamed from: e  reason: collision with root package name */
    public String f3600e;

    /* renamed from: f  reason: collision with root package name */
    public String f3601f;

    @Override // com.huawei.hms.hatool.s
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.a);
        jSONObject.put("eventtime", this.f3599d);
        jSONObject.put("event", this.b);
        jSONObject.put("event_session_name", this.f3600e);
        jSONObject.put("first_session_event", this.f3601f);
        if (TextUtils.isEmpty(this.f3598c)) {
            return null;
        }
        jSONObject.put("properties", new JSONObject(this.f3598c));
        return jSONObject;
    }

    public void a(String str) {
        this.f3598c = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.b = jSONObject.optString("event");
        this.f3598c = jSONObject.optString("properties");
        this.f3598c = d.a(this.f3598c, d0.f().a());
        this.a = jSONObject.optString("type");
        this.f3599d = jSONObject.optString("eventtime");
        this.f3600e = jSONObject.optString("event_session_name");
        this.f3601f = jSONObject.optString("first_session_event");
    }

    public String b() {
        return this.f3599d;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.a;
    }

    public void c(String str) {
        this.f3599d = str;
    }

    public JSONObject d() {
        JSONObject a = a();
        a.put("properties", d.b(this.f3598c, d0.f().a()));
        return a;
    }

    public void d(String str) {
        this.a = str;
    }

    public void e(String str) {
        this.f3601f = str;
    }

    public void f(String str) {
        this.f3600e = str;
    }
}
