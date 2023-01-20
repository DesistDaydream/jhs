package com.tencent.android.tpush.stat.event;

import android.content.Context;
import android.os.Process;
import androidx.annotation.Nullable;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.logger.DeviceInfo;
import com.umeng.analytics.pro.am;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class d extends Event {
    private static DeviceInfo a;
    private String b;

    /* renamed from: l  reason: collision with root package name */
    private JSONArray f6463l;

    /* renamed from: m  reason: collision with root package name */
    private int f6464m;
    private Thread n;
    private String o;
    private long p;
    private String q;
    private String r;
    private String s;

    public d(Context context, int i2, int i3, JSONArray jSONArray, long j2) {
        super(context, 0, j2);
        this.n = null;
        this.o = null;
        this.p = -1L;
        this.q = null;
        this.r = null;
        this.s = null;
        this.f6464m = i3;
        this.f6463l = jSONArray;
    }

    private void b(JSONObject jSONObject) {
        JSONObject a2 = a(this.n);
        try {
            if (a == null) {
                a = new DeviceInfo(this.f6458k);
            }
            a2.put("deviceInfo", a);
        } catch (Throwable unused) {
            TLogger.w("ErrorEvent", "unexpected for encodeCrashThread");
        }
        JSONArray jSONArray = this.f6463l;
        if (jSONArray != null) {
            a2.put("stack", jSONArray);
            if (this.p > -1) {
                a2.put("gfra", this.f6463l);
            }
        } else {
            a2.put("stack", this.b);
            if (this.p > -1) {
                a2.put("gfra", this.b);
            }
        }
        jSONObject.put("cth", a2);
        if (this.f6464m == 3) {
            a2.put("nfra", this.s);
        }
    }

    public void a(String str) {
        this.o = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            d dVar = (d) obj;
            try {
                if (this.f6453d == dVar.f6453d && this.q.equals(dVar.q) && this.r.equals(dVar.r)) {
                    if (this.f6463l.toString().equals(dVar.f6463l.toString())) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable unused) {
                TLogger.w("ErrorEvent", "unexpected for equals");
            }
        }
        return false;
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public EventType getType() {
        return EventType.ERROR;
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public boolean onEncode(JSONObject jSONObject) {
        jSONObject.put("cmode", 2);
        jSONObject.put("ea", this.f6464m);
        jSONObject.put("prcp", Process.myPid());
        jSONObject.put("prct", Process.myTid());
        new com.tencent.android.tpush.stat.b.a(this.f6458k, this.f6453d).a(jSONObject, this.n);
        b(jSONObject);
        a(jSONObject);
        return true;
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("accessId", this.f6453d);
            jSONObject.put("timestamp", this.f6454e);
            String str = this.q;
            if (str != null) {
                jSONObject.put("token", str);
            }
            String str2 = this.f6452c;
            if (str2 != null) {
                jSONObject.put("accessKey", str2);
            }
            String str3 = this.r;
            if (str3 != null) {
                jSONObject.put(com.heytap.mcssdk.constant.b.C, str3);
            }
            jSONObject.put("et", getType().GetIntValue());
            b(jSONObject);
            return jSONObject.toString();
        } catch (Throwable unused) {
            TLogger.w("ErrorEvent", "unexpected for toJsonString");
            return null;
        }
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public String toString() {
        return toJsonString();
    }

    private void a(JSONObject jSONObject) {
        jSONObject.put("md5", com.tencent.android.tpush.stat.b.b.a(this.b));
        jSONObject.put("ct", this.f6464m);
        jSONObject.put("bid", this.f6458k.getPackageName());
        jSONObject.put("dt", System.currentTimeMillis() / 1000);
    }

    private JSONObject a(Thread thread) {
        JSONObject jSONObject = new JSONObject();
        if (thread != null) {
            jSONObject.put("id", thread.getId());
            jSONObject.put("name", thread.getName());
            jSONObject.put(am.ay, thread.getPriority());
        }
        long j2 = this.p;
        if (j2 > -1) {
            jSONObject.put("gthn", j2);
        }
        return jSONObject;
    }

    public boolean a() {
        String str;
        JSONArray jSONArray = this.f6463l;
        if (jSONArray != null) {
            str = jSONArray.toString();
        } else {
            str = this.b;
        }
        return str.contains("com.tencent.android.tpush.") || str.contains("com.tencent.android.tpns.") || str.contains("com.tencent.tpns.");
    }
}
