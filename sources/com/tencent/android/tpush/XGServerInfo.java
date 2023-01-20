package com.tencent.android.tpush;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class XGServerInfo {
    public static final String TAG_IP = "ip";
    public static final String TAG_PORT = "port";
    public static final String TAG_PROXY_IP = "p_ip";
    public static final String TAG_PROXY_PORT = "p_port";
    private JSONArray a;

    public XGServerInfo() {
        this.a = new JSONArray();
    }

    private void a(String str, int i2, String str2, int i3) {
        if (TextUtils.isEmpty(str) || i2 <= 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TAG_IP, str);
            jSONObject.put("port", i2);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(TAG_PROXY_IP, i3);
                jSONObject.put(TAG_PROXY_PORT, i3);
            }
            this.a.put(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public XGServerInfo addServerIp(String str, int i2) {
        a(str, i2, null, 0);
        return this;
    }

    public JSONArray getIpArray() {
        return this.a;
    }

    public boolean isEmpty() {
        JSONArray jSONArray = this.a;
        return jSONArray != null && jSONArray.length() > 0;
    }

    public void reset() {
        this.a = new JSONArray();
    }

    public XGServerInfo addServerIp(String str, int i2, String str2, int i3) {
        a(str, i2, str2, i3);
        return this;
    }

    public XGServerInfo(String str) {
        this.a = new JSONArray();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.a = new JSONArray(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
