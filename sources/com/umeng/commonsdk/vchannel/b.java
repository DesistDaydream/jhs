package com.umeng.commonsdk.vchannel;

import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b {
    private String b;
    private String a = "_$unknown";

    /* renamed from: c  reason: collision with root package name */
    private long f7630c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f7631d = 0;

    /* renamed from: e  reason: collision with root package name */
    private String f7632e = a.f7629j;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, Object> f7633f = null;

    public b(Context context) {
        this.b = UMGlobalContext.getInstance(context).getProcessName(context);
    }

    public String a() {
        return this.a;
    }

    public long b() {
        return this.f7630c;
    }

    public Map<String, Object> c() {
        return this.f7633f;
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.a);
            jSONObject.put("pn", this.b);
            jSONObject.put("ds", this.f7631d);
            jSONObject.put("ts", this.f7630c);
            Map<String, Object> map = this.f7633f;
            if (map != null && map.size() > 0) {
                for (String str : this.f7633f.keySet()) {
                    jSONObject.put(str, this.f7633f.get(str));
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(this.f7632e, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ekv", jSONArray2);
            return jSONObject3;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("[");
        sb.append("id:" + this.a + Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("pn:" + this.b + Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("ts:" + this.f7630c + Constants.ACCEPT_TIME_SEPARATOR_SP);
        Map<String, Object> map = this.f7633f;
        if (map != null && map.size() > 0) {
            for (String str : this.f7633f.keySet()) {
                sb.append(this.f7633f.get(str) == null ? str + ": null" + Constants.ACCEPT_TIME_SEPARATOR_SP : str + ": " + obj.toString() + Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        sb.append("ds:" + this.f7631d + "]");
        return sb.toString();
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(long j2) {
        this.f7630c = j2;
    }

    public void a(Map<String, Object> map) {
        this.f7633f = map;
    }
}
