package com.tencent.tpns.baseapi.core.b;

import com.tencent.android.tpush.common.Constants;
import com.tencent.tpns.baseapi.base.util.Util;
import com.umeng.analytics.pro.am;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b {
    public String a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f6893c;

    /* renamed from: d  reason: collision with root package name */
    public String f6894d;

    /* renamed from: e  reason: collision with root package name */
    public String f6895e;

    /* renamed from: f  reason: collision with root package name */
    private JSONObject f6896f;

    public JSONObject a() {
        this.f6896f = new JSONObject();
        if (!Util.isNullOrEmptyString(this.a)) {
            this.f6896f.put("appVersion", this.a);
        }
        if (!Util.isNullOrEmptyString(this.b)) {
            this.f6896f.put("network", this.b);
        }
        if (!Util.isNullOrEmptyString(this.f6893c)) {
            this.f6896f.put(am.x, this.f6893c);
        }
        if (!Util.isNullOrEmptyString(this.f6894d)) {
            this.f6896f.put(Constants.FLAG_PACKAGE_NAME, this.f6894d);
        }
        if (!Util.isNullOrEmptyString(this.f6895e)) {
            this.f6896f.put("sdkVersionName", this.f6895e);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appDeviceInfo", this.f6896f);
        return jSONObject;
    }
}
