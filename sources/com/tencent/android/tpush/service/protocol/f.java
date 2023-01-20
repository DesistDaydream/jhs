package com.tencent.android.tpush.service.protocol;

import com.baidu.mobads.sdk.internal.bc;
import com.tencent.android.tpush.service.util.b;
import com.umeng.analytics.pro.am;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class f {
    public List<b.a> u;
    public String a = "";
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f6296c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f6297d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f6298e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f6299f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f6300g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f6301h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f6302i = "";

    /* renamed from: j  reason: collision with root package name */
    public String f6303j = "";

    /* renamed from: k  reason: collision with root package name */
    public long f6304k = 0;

    /* renamed from: l  reason: collision with root package name */
    public String f6305l = "";

    /* renamed from: m  reason: collision with root package name */
    public String f6306m = "";
    public String n = "";
    public String o = "";
    public String p = "";
    public String q = "";
    public String r = "";
    public String s = "";
    public int t = 3;
    public o v = null;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("imei", this.a);
        jSONObject.put(bc.f1474i, this.b);
        jSONObject.put(am.x, this.f6296c);
        jSONObject.put("network", this.f6297d);
        jSONObject.put("sdCard", this.f6298e);
        jSONObject.put("sdDouble", this.f6299f);
        jSONObject.put("resolution", this.f6300g);
        jSONObject.put("manu", this.f6301h);
        jSONObject.put("apiLevel", this.f6302i);
        jSONObject.put("sdkVersionName", this.f6303j);
        jSONObject.put("isRooted", this.f6304k);
        jSONObject.put("appList", this.f6305l);
        jSONObject.put("cpuInfo", this.f6306m);
        jSONObject.put(am.N, this.n);
        jSONObject.put(am.M, this.o);
        jSONObject.put("launcherName", this.p);
        jSONObject.put("xgAppList", this.q);
        jSONObject.put("ntfBar", this.t);
        o oVar = this.v;
        if (oVar != null) {
            jSONObject.put("tUinInfo", oVar.a());
        }
        jSONObject.put("osVersion", this.r);
        if (!com.tencent.android.tpush.common.i.b(this.s)) {
            jSONObject.put("ohVersion", this.s);
        }
        List<b.a> list = this.u;
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (b.a aVar : this.u) {
                try {
                    jSONArray.put(aVar.a());
                } catch (Throwable unused) {
                }
            }
            jSONObject.put("channels", jSONArray);
        }
        return jSONObject;
    }
}
