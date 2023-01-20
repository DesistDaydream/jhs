package com.ss.android.downloadlib.addownload.b;

import com.ss.android.downloadlib.g.l;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a {
    public long a;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public long f5231c;

    /* renamed from: d  reason: collision with root package name */
    public String f5232d;

    /* renamed from: e  reason: collision with root package name */
    public String f5233e;

    /* renamed from: f  reason: collision with root package name */
    public String f5234f;

    /* renamed from: g  reason: collision with root package name */
    public String f5235g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f5236h;

    public a() {
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.a);
            jSONObject.put("mAdId", this.b);
            jSONObject.put("mExtValue", this.f5231c);
            jSONObject.put("mPackageName", this.f5232d);
            jSONObject.put("mAppName", this.f5233e);
            jSONObject.put("mLogExtra", this.f5234f);
            jSONObject.put("mFileName", this.f5235g);
            jSONObject.put("mTimeStamp", this.f5236h);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public a(long j2, long j3, long j4, String str, String str2, String str3, String str4) {
        this.a = j2;
        this.b = j3;
        this.f5231c = j4;
        this.f5232d = str;
        this.f5233e = str2;
        this.f5234f = str3;
        this.f5235g = str4;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        try {
            aVar.a = l.a(jSONObject, "mDownloadId");
            aVar.b = l.a(jSONObject, "mAdId");
            aVar.f5231c = l.a(jSONObject, "mExtValue");
            aVar.f5232d = jSONObject.optString("mPackageName");
            aVar.f5233e = jSONObject.optString("mAppName");
            aVar.f5234f = jSONObject.optString("mLogExtra");
            aVar.f5235g = jSONObject.optString("mFileName");
            aVar.f5236h = l.a(jSONObject, "mTimeStamp");
            return aVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
