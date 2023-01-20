package com.tencent.android.tpush.service.protocol;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class g {
    public long a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f6307c;

    public boolean a() {
        return (this.a <= 0 || TextUtils.isEmpty(this.b) || this.b.equals("0") || TextUtils.isEmpty(this.f6307c)) ? false : true;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessid", this.a);
        jSONObject.put("token", this.b);
        jSONObject.put("channel", this.f6307c);
        return jSONObject;
    }
}
