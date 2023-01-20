package com.huawei.hms.hatool;

import android.os.Build;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class g1 extends p {

    /* renamed from: f  reason: collision with root package name */
    public String f3535f;

    /* renamed from: g  reason: collision with root package name */
    public String f3536g;

    /* renamed from: h  reason: collision with root package name */
    public String f3537h;

    @Override // com.huawei.hms.hatool.s
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_rom_ver", this.f3537h);
        jSONObject.put("_emui_ver", this.a);
        jSONObject.put("_model", Build.MODEL);
        jSONObject.put("_mcc", this.f3535f);
        jSONObject.put("_mnc", this.f3536g);
        jSONObject.put("_package_name", this.b);
        jSONObject.put("_app_ver", this.f3595c);
        jSONObject.put("_lib_ver", "2.2.0.313");
        jSONObject.put("_channel", this.f3596d);
        jSONObject.put("_lib_name", "hianalytics");
        jSONObject.put("_oaid_tracking_flag", this.f3597e);
        return jSONObject;
    }

    public void f(String str) {
        this.f3535f = str;
    }

    public void g(String str) {
        this.f3536g = str;
    }

    public void h(String str) {
        this.f3537h = str;
    }
}
