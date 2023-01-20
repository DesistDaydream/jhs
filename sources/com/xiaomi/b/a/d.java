package com.xiaomi.b.a;

import com.umeng.analytics.pro.am;
import com.vivo.push.PushClientConstants;
import com.xiaomi.push.av;
import com.xiaomi.push.jc;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class d {
    private String a = av.a();
    private String b = jc.d();

    /* renamed from: c  reason: collision with root package name */
    private String f8205c;

    /* renamed from: d  reason: collision with root package name */
    private String f8206d;

    /* renamed from: e  reason: collision with root package name */
    public int f8207e;

    /* renamed from: f  reason: collision with root package name */
    public String f8208f;

    /* renamed from: g  reason: collision with root package name */
    public int f8209g;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("production", this.f8207e);
            jSONObject.put("reportType", this.f8209g);
            jSONObject.put("clientInterfaceId", this.f8208f);
            jSONObject.put(am.x, this.a);
            jSONObject.put("miuiVersion", this.b);
            jSONObject.put(PushClientConstants.TAG_PKG_NAME, this.f8205c);
            jSONObject.put(com.heytap.mcssdk.constant.b.C, this.f8206d);
            return jSONObject;
        } catch (JSONException e2) {
            com.xiaomi.a.a.a.c.a(e2);
            return null;
        }
    }

    public void a(String str) {
        this.f8205c = str;
    }

    public String b() {
        JSONObject a = a();
        return a == null ? "" : a.toString();
    }

    public void b(String str) {
        this.f8206d = str;
    }
}
