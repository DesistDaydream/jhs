package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class j0 implements n0 {
    public Context a = b.i();
    public String b;

    /* renamed from: c */
    public JSONObject f3551c;

    /* renamed from: d */
    public String f3552d;

    /* renamed from: e */
    public String f3553e;

    /* renamed from: f */
    public String f3554f;

    /* renamed from: g */
    public String f3555g;

    /* renamed from: h */
    public Boolean f3556h;

    public j0(String str, JSONObject jSONObject, String str2, String str3, long j2) {
        this.b = str;
        this.f3551c = jSONObject;
        this.f3552d = str2;
        this.f3553e = str3;
        this.f3554f = String.valueOf(j2);
        if (a.i(str2, "oper")) {
            f0 a = e0.a().a(str2, j2);
            this.f3555g = a.a();
            this.f3556h = Boolean.valueOf(a.b());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray;
        y.c("hmsSdk", "Begin to run EventRecordTask...");
        int h2 = b.h();
        int k2 = c.k(this.f3552d, this.f3553e);
        if (q0.a(this.a, "stat_v2_1", h2 * 1048576)) {
            y.c("hmsSdk", "stat sp file reach max limited size, discard new event");
            h0.a().a("", "alltype");
            return;
        }
        q qVar = new q();
        qVar.b(this.b);
        qVar.a(this.f3551c.toString());
        qVar.d(this.f3553e);
        qVar.c(this.f3554f);
        qVar.f(this.f3555g);
        Boolean bool = this.f3556h;
        qVar.e(bool == null ? null : String.valueOf(bool));
        try {
            JSONObject d2 = qVar.d();
            String a = u0.a(this.f3552d, this.f3553e);
            String a2 = g0.a(this.a, "stat_v2_1", a, "");
            try {
                jSONArray = !TextUtils.isEmpty(a2) ? new JSONArray(a2) : new JSONArray();
            } catch (JSONException unused) {
                y.d("hmsSdk", "Cached data corrupted: stat_v2_1");
                jSONArray = new JSONArray();
            }
            jSONArray.put(d2);
            g0.b(this.a, "stat_v2_1", a, jSONArray.toString());
            if (jSONArray.toString().length() > k2 * 1024) {
                h0.a().a(this.f3552d, this.f3553e);
            }
        } catch (JSONException unused2) {
            y.e("hmsSdk", "eventRecord toJson error! The record failed.");
        }
    }
}
