package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class g extends Event {
    public String a;
    public String b;

    /* renamed from: l  reason: collision with root package name */
    public int f6468l;

    /* renamed from: m  reason: collision with root package name */
    public String f6469m;
    public long n;
    public String o;
    public byte p;

    public g(Context context, int i2, String str) {
        super(context, XGApiConfig.getAccessKey(context), XGApiConfig.getAccessId(context));
        this.a = null;
        this.b = null;
        this.n = 0L;
        this.f6452c = XGApiConfig.getAccessKey(context);
        this.f6453d = XGApiConfig.getAccessId(context);
        this.a = GuidInfoManager.getToken(context.getApplicationContext());
        this.b = "1.3.5.0";
        this.f6468l = i2;
        this.o = str;
        this.p = DeviceInfos.getNetworkType(context);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            g gVar = (g) obj;
            try {
                if (this.f6453d == gVar.f6453d && this.f6454e == gVar.f6454e && this.a.equals(gVar.a) && this.b.equals(gVar.b) && this.f6468l == gVar.f6468l && this.f6469m.equals(gVar.f6469m) && this.n == gVar.n && this.o.equals(gVar.o)) {
                    if (this.p == gVar.p) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                TLogger.d("RspErrcodeEvent equals Error:", th.getMessage());
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
        return EventType.ERRCODE;
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
            String str = this.a;
            if (str != null) {
                jSONObject.put("token", str);
            }
            String str2 = this.f6452c;
            if (str2 != null) {
                jSONObject.put("accessKey", str2);
            }
            String str3 = this.b;
            if (str3 != null) {
                jSONObject.put(com.heytap.mcssdk.constant.b.C, str3);
            }
            jSONObject.put("et", getType().GetIntValue());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errCode", this.f6468l);
            String str4 = this.f6469m;
            if (str4 != null) {
                jSONObject2.put("msg", str4);
            }
            long j2 = this.n;
            if (0 != j2) {
                jSONObject2.put("id", j2);
            }
            jSONObject.put("errCode", jSONObject2);
            String str5 = this.o;
            if (str5 != null) {
                jSONObject.put("errType", str5);
            }
            jSONObject.put("networkType", (int) this.p);
            return jSONObject.toString();
        } catch (Throwable th) {
            TLogger.e("RspErrcodeEvent toJson Error:", th.getMessage());
            return null;
        }
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public String toString() {
        return toJsonString();
    }
}
