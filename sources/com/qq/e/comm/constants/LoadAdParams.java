package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class LoadAdParams {
    private LoginType a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f5069c;

    /* renamed from: d  reason: collision with root package name */
    private String f5070d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f5071e;

    /* renamed from: f  reason: collision with root package name */
    private JSONObject f5072f;

    /* renamed from: g  reason: collision with root package name */
    private final JSONObject f5073g = new JSONObject();

    public Map getDevExtra() {
        return this.f5071e;
    }

    public String getDevExtraJsonString() {
        try {
            Map<String, String> map = this.f5071e;
            return (map == null || map.size() <= 0) ? "" : new JSONObject(this.f5071e).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public JSONObject getExtraInfo() {
        return this.f5072f;
    }

    public String getLoginAppId() {
        return this.b;
    }

    public String getLoginOpenid() {
        return this.f5069c;
    }

    public LoginType getLoginType() {
        return this.a;
    }

    public JSONObject getParams() {
        return this.f5073g;
    }

    public String getUin() {
        return this.f5070d;
    }

    public void setDevExtra(Map<String, String> map) {
        this.f5071e = map;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.f5072f = jSONObject;
    }

    public void setLoginAppId(String str) {
        this.b = str;
    }

    public void setLoginOpenid(String str) {
        this.f5069c = str;
    }

    public void setLoginType(LoginType loginType) {
        this.a = loginType;
    }

    public void setUin(String str) {
        this.f5070d = str;
    }

    public String toString() {
        return "LoadAdParams{, loginType=" + this.a + ", loginAppId=" + this.b + ", loginOpenid=" + this.f5069c + ", uin=" + this.f5070d + ", passThroughInfo=" + this.f5071e + ", extraInfo=" + this.f5072f + '}';
    }
}
