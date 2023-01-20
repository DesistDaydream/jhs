package com.tencent.android.tpush.stat.event;

import android.content.Context;
import android.os.Build;
import com.tencent.android.tpush.common.AppInfos;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b extends Event {
    public String a;
    public long b;

    /* renamed from: l  reason: collision with root package name */
    private String f6459l;

    /* renamed from: m  reason: collision with root package name */
    private String f6460m;
    private String n;
    private long o;
    private int p;

    public b(Context context, long j2, int i2) {
        super(context, XGApiConfig.getAccessKey(context), XGApiConfig.getAccessId(context));
        this.b = 0L;
        this.f6459l = null;
        this.f6460m = null;
        this.n = null;
        this.o = 0L;
        this.p = 0;
        this.f6452c = XGApiConfig.getAccessKey(context);
        this.f6453d = XGApiConfig.getAccessId(context);
        this.f6459l = GuidInfoManager.getToken(context.getApplicationContext());
        this.f6460m = "1.3.5.0";
        this.n = AppInfos.getCurAppVersion(context);
        this.o = j2;
        this.p = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            try {
                if (this.f6453d == bVar.f6453d && this.f6454e == bVar.f6454e && this.f6459l.equals(bVar.f6459l) && this.f6460m.equals(bVar.f6460m) && this.a.equals(bVar.a)) {
                    if (this.b == bVar.b) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                TLogger.d("CloudEvent equals Error:", th.getMessage());
            }
        }
        return false;
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public long getAccessid() {
        return this.f6453d;
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public EventType getType() {
        return null;
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public boolean onEncode(JSONObject jSONObject) {
        return true;
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public void setAccessid(long j2) {
        this.f6453d = j2;
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("accessId", this.f6453d);
            jSONObject.put("timestamp", this.f6454e);
            String str = this.f6459l;
            if (str != null) {
                jSONObject.put("token", str);
            }
            String str2 = this.f6452c;
            if (str2 != null) {
                jSONObject.put("accessKey", str2);
            }
            String str3 = this.f6460m;
            if (str3 != null) {
                jSONObject.put(com.heytap.mcssdk.constant.b.C, str3);
            }
            String str4 = this.n;
            if (str4 != null) {
                jSONObject.put("appVersion", str4);
            }
            jSONObject.put("et", 4);
            jSONObject.put("sdkVersionName", Build.VERSION.RELEASE);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cloudVersion", this.o);
            jSONObject2.put("cloudControlRet", this.p);
            jSONObject.put("cloudMsg", jSONObject2);
            return jSONObject.toString();
        } catch (Throwable th) {
            TLogger.e("CloudEvent toJson Error:", th.getMessage());
            return null;
        }
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public String toString() {
        return toJsonString();
    }
}
