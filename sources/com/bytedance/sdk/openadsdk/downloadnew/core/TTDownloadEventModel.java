package com.bytedance.sdk.openadsdk.downloadnew.core;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class TTDownloadEventModel {
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f2449c;

    /* renamed from: d  reason: collision with root package name */
    private JSONObject f2450d;

    public static TTDownloadEventModel builder() {
        return new TTDownloadEventModel();
    }

    public JSONObject getExtJson() {
        return this.f2449c;
    }

    public String getLabel() {
        return this.b;
    }

    public JSONObject getMaterialMeta() {
        return this.f2450d;
    }

    public String getTag() {
        return this.a;
    }

    public TTDownloadEventModel setExtJson(JSONObject jSONObject) {
        this.f2449c = jSONObject;
        return this;
    }

    public TTDownloadEventModel setLabel(String str) {
        this.b = str;
        return this;
    }

    public TTDownloadEventModel setMaterialMeta(JSONObject jSONObject) {
        this.f2450d = jSONObject;
        return this;
    }

    public TTDownloadEventModel setTag(String str) {
        this.a = str;
        return this;
    }
}
