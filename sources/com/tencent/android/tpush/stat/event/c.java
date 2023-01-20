package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class c extends Event {
    public a a;
    public long b;

    public c(Context context, int i2, String str, long j2, long j3) {
        super(context, i2, j2);
        a aVar = new a();
        this.a = aVar;
        this.b = -1L;
        aVar.a = str;
        this.f6457j = j3;
    }

    public a a() {
        return this.a;
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public EventType getType() {
        return EventType.CUSTOM;
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public boolean onEncode(JSONObject jSONObject) {
        return true;
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.heytap.mcssdk.constant.b.f3343k, this.a.a);
            JSONObject jSONObject3 = this.a.f6461c;
            if (jSONObject3 != null && jSONObject3.length() != 0) {
                jSONObject2.put("kv", this.a.f6461c);
            }
            jSONObject.put("customEvent", jSONObject2);
            EventType type = getType();
            if (type != null) {
                jSONObject.put("et", type.GetIntValue());
            }
            jSONObject.put(com.heytap.mcssdk.constant.b.C, "1.3.5.0");
            jSONObject.put("token", GuidInfoManager.getToken(this.f6458k.getApplicationContext()));
            jSONObject.put("accessId", XGApiConfig.getAccessId(this.f6458k));
            jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject.put("idx", com.tencent.android.tpush.stat.b.b.a());
            return jSONObject.toString();
        } catch (Throwable th) {
            TLogger.e("CustomEvent toJson Error:", th.getMessage());
            return "";
        }
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public String toString() {
        return toJsonString();
    }

    /* loaded from: classes3.dex */
    public static class a {
        public String a;
        public JSONArray b;

        /* renamed from: c  reason: collision with root package name */
        public JSONObject f6461c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f6462d;

        public a(String str, String[] strArr, Properties properties) {
            this.f6461c = null;
            this.f6462d = false;
            this.a = str;
            if (properties != null) {
                this.f6461c = new JSONObject(properties);
            } else if (strArr != null) {
                this.b = new JSONArray();
                for (String str2 : strArr) {
                    this.b.put(str2);
                }
            } else {
                this.f6461c = new JSONObject();
            }
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                return toString().equals(((a) obj).toString());
            }
            return false;
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.a);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            JSONArray jSONArray = this.b;
            if (jSONArray != null) {
                sb.append(jSONArray.toString());
            }
            JSONObject jSONObject = this.f6461c;
            if (jSONObject != null) {
                sb.append(jSONObject.toString());
            }
            return sb.toString();
        }

        public a() {
            this.f6461c = null;
            this.f6462d = false;
        }
    }
}
