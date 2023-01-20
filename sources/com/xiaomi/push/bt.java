package com.xiaomi.push;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class bt {
    private int a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private long f8296c;

    /* renamed from: d  reason: collision with root package name */
    private String f8297d;

    /* renamed from: e  reason: collision with root package name */
    private long f8298e;

    public bt() {
        this(0, 0L, 0L, null);
    }

    public bt(int i2, long j2, long j3, Exception exc) {
        this.a = i2;
        this.b = j2;
        this.f8298e = j3;
        this.f8296c = System.currentTimeMillis();
        if (exc != null) {
            this.f8297d = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.a;
    }

    public bt a(JSONObject jSONObject) {
        this.b = jSONObject.getLong("cost");
        this.f8298e = jSONObject.getLong("size");
        this.f8296c = jSONObject.getLong("ts");
        this.a = jSONObject.getInt("wt");
        this.f8297d = jSONObject.optString("expt");
        return this;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.b);
        jSONObject.put("size", this.f8298e);
        jSONObject.put("ts", this.f8296c);
        jSONObject.put("wt", this.a);
        jSONObject.put("expt", this.f8297d);
        return jSONObject;
    }
}
