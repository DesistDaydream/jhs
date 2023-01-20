package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cn implements s {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f1577c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ cj f1578d;

    public cn(cj cjVar, int i2, int i3, String str) {
        this.f1578d = cjVar;
        this.a = i2;
        this.b = i3;
        this.f1577c = str;
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f1578d.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.a));
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, Integer.valueOf(this.b));
        hashMap.put("novel_id", this.f1577c);
        this.f1578d.a(co.r, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void a(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f1578d.f());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f1578d.g()));
        hashMap.put("entry", Integer.valueOf(this.a));
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, Integer.valueOf(this.b));
        hashMap.put("novel_id", this.f1577c);
        hashMap.put("novel_info", jSONObject);
        this.f1578d.a(co.t, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f1578d.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f1578d.g()));
        hashMap.put("entry", Integer.valueOf(this.a));
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, Integer.valueOf(this.b));
        hashMap.put("novel_id", this.f1577c);
        hashMap.put("novel_info", jSONObject);
        this.f1578d.a(co.s, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.a));
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, Integer.valueOf(this.b));
        hashMap.put("novel_id", this.f1577c);
        this.f1578d.a(co.v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f1578d.f());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f1578d.g()));
        hashMap.put("entry", Integer.valueOf(this.a));
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, Integer.valueOf(this.b));
        hashMap.put("novel_id", this.f1577c);
        hashMap.put("backgroundColor", Integer.valueOf(i2));
        this.f1578d.a(co.w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String h2 = this.f1578d.h("get_cuid");
        String h3 = this.f1578d.h("get_imei");
        String h4 = this.f1578d.h("get_oaid");
        try {
            jSONObject.put("cuid", h2);
            jSONObject.put("imei", h3);
            jSONObject.put("oaid", h4);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void a(long j2) {
        bj bjVar = this.f1578d.f1462i;
        bjVar.a("单次阅读器打开时长 = " + j2);
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void a(ViewGroup viewGroup, int i2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.f1578d.f());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.f1578d.g()));
        hashMap.put("entry", Integer.valueOf(this.a));
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, Integer.valueOf(this.b));
        hashMap.put("novel_id", this.f1577c);
        hashMap.put("count_down", Integer.valueOf(i2));
        this.f1578d.a(co.x, hashMap);
    }
}
