package com.xiaomi.b.a;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b extends d {
    public String a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public long f8202c;

    /* renamed from: d  reason: collision with root package name */
    public String f8203d;

    @Override // com.xiaomi.b.a.d
    public JSONObject a() {
        try {
            JSONObject a = super.a();
            if (a == null) {
                return null;
            }
            a.put(com.heytap.mcssdk.constant.b.f3343k, this.a);
            a.put("eventType", this.b);
            a.put("eventTime", this.f8202c);
            String str = this.f8203d;
            if (str == null) {
                str = "";
            }
            a.put("eventContent", str);
            return a;
        } catch (JSONException e2) {
            com.xiaomi.a.a.a.c.a(e2);
            return null;
        }
    }

    @Override // com.xiaomi.b.a.d
    public String b() {
        return super.b();
    }
}
