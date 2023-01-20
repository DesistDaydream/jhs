package com.meizu.cloud.pushsdk.a.a;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class c {
    private final int a;
    private final String b;

    public c(int i2, String str) {
        this.a = i2;
        this.b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.a);
            jSONObject.put("body", this.b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
