package com.tencent.android.tpush.service.protocol;

import com.tencent.android.tpush.common.Constants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class q {
    public int a = 0;
    public String b = null;

    public void a(int i2) {
        this.a = i2;
    }

    public void a(String str) {
        this.b = str;
    }

    public JSONObject a() {
        if (this.b == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accountType", this.a);
        jSONObject.put(Constants.FLAG_ACCOUNT, this.b);
        return jSONObject;
    }
}
