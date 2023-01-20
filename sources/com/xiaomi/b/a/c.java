package com.xiaomi.b.a;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class c extends d {
    public int a;
    public long b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f8204c = -1;

    public static c c() {
        return new c();
    }

    @Override // com.xiaomi.b.a.d
    public JSONObject a() {
        try {
            JSONObject a = super.a();
            if (a == null) {
                return null;
            }
            a.put("code", this.a);
            a.put("perfCounts", this.b);
            a.put("perfLatencies", this.f8204c);
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
