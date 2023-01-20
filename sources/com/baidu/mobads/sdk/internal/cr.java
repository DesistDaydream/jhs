package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUNovelAd;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cr implements s {
    public final /* synthetic */ co a;

    public cr(co coVar) {
        this.a = coVar;
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.a.D));
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, Integer.valueOf(this.a.E));
        hashMap.put("novel_id", this.a.F);
        this.a.a(co.r, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.a.g());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.a.h()));
        hashMap.put("entry", Integer.valueOf(this.a.D));
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, Integer.valueOf(this.a.E));
        hashMap.put("novel_id", this.a.F);
        hashMap.put("novel_info", jSONObject);
        this.a.a(co.t, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.a.h()));
        hashMap.put("entry", Integer.valueOf(this.a.D));
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, Integer.valueOf(this.a.E));
        hashMap.put("novel_id", this.a.F);
        hashMap.put("novel_info", jSONObject);
        this.a.a(co.s, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", Integer.valueOf(this.a.D));
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, Integer.valueOf(this.a.E));
        hashMap.put("novel_id", this.a.F);
        hashMap.put("isnight", Boolean.valueOf(this.a.w()));
        this.a.a(co.v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.a.g());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.a.h()));
        hashMap.put("entry", Integer.valueOf(this.a.D));
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, Integer.valueOf(this.a.E));
        hashMap.put("novel_id", this.a.F);
        hashMap.put("backgroundColor", Integer.valueOf(i2));
        this.a.a(co.w, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String h2 = this.a.h("get_cuid");
        String h3 = this.a.h("get_imei");
        String h4 = this.a.h("get_oaid");
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
        CPUNovelAd.CpuNovelListener cpuNovelListener;
        CPUNovelAd.CpuNovelListener cpuNovelListener2;
        cpuNovelListener = this.a.H;
        if (cpuNovelListener != null) {
            cpuNovelListener2 = this.a.H;
            cpuNovelListener2.onReadTime(j2);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void a(ViewGroup viewGroup, int i2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.a.h()));
        hashMap.put("entry", Integer.valueOf(this.a.D));
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, Integer.valueOf(this.a.E));
        hashMap.put("novel_id", this.a.F);
        hashMap.put("count_down", Integer.valueOf(i2));
        this.a.a(co.x, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void a(boolean z) {
        SoftReference softReference;
        SoftReference softReference2;
        softReference = this.a.I;
        if (softReference != null) {
            softReference2 = this.a.I;
            RelativeLayout relativeLayout = (RelativeLayout) softReference2.get();
            if (relativeLayout != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("novel_activity", (Activity) this.a.f1461h);
                hashMap.put("interstitial_container", null);
                hashMap.put("banner_container", relativeLayout);
                hashMap.put("entry", Integer.valueOf(this.a.D));
                hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, Integer.valueOf(this.a.E));
                hashMap.put("novel_id", this.a.F);
                hashMap.put("isnight", Boolean.valueOf(this.a.w()));
                this.a.a(co.w, hashMap);
            }
        }
    }
}
