package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ah implements s {
    public final /* synthetic */ ac a;

    public ah(ac acVar) {
        this.a = acVar;
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void a(ViewGroup viewGroup) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("entry", 2);
        iArr = this.a.t;
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, Integer.valueOf(iArr[0]));
        this.a.a(co.r, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void a(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.a.g());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.a.h()));
        hashMap.put("entry", 2);
        iArr = this.a.t;
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, Integer.valueOf(iArr[0]));
        hashMap.put("novel_info", jSONObject);
        this.a.a(co.t, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.a.h()));
        hashMap.put("entry", 2);
        iArr = this.a.t;
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, Integer.valueOf(iArr[0]));
        hashMap.put("novel_info", jSONObject);
        this.a.a(co.s, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void b(ViewGroup viewGroup) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", viewGroup.getContext());
        hashMap.put("banner_container", viewGroup);
        hashMap.put("entry", 2);
        iArr = this.a.t;
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, Integer.valueOf(iArr[0]));
        this.a.a(co.v, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i2) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.a.g());
        hashMap.put("banner_container", viewGroup2);
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.a.h()));
        hashMap.put("entry", 2);
        iArr = this.a.t;
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, Integer.valueOf(iArr[0]));
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
        bj bjVar = this.a.f1462i;
        bjVar.a("单次阅读器打开时长 = " + j2);
    }

    @Override // com.baidu.mobads.sdk.internal.s
    public void a(ViewGroup viewGroup, int i2) {
        int[] iArr;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("novel_activity", this.a.g());
        hashMap.put("interstitial_container", viewGroup);
        hashMap.put("isnight", Boolean.valueOf(this.a.h()));
        hashMap.put("entry", 2);
        iArr = this.a.t;
        hashMap.put(RemoteMessageConst.Notification.CHANNEL_ID, Integer.valueOf(iArr[0]));
        hashMap.put("count_down", Integer.valueOf(i2));
        this.a.a(co.x, hashMap);
    }
}
