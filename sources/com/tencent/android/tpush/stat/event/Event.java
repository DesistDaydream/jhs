package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import com.umeng.analytics.pro.am;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class Event {
    public static String channel = "xgsdk";

    /* renamed from: h  reason: collision with root package name */
    public static String f6450h;

    /* renamed from: i  reason: collision with root package name */
    public static long f6451i;

    /* renamed from: c  reason: collision with root package name */
    public String f6452c;

    /* renamed from: d  reason: collision with root package name */
    public long f6453d;

    /* renamed from: e  reason: collision with root package name */
    public long f6454e;

    /* renamed from: f  reason: collision with root package name */
    public int f6455f;

    /* renamed from: g  reason: collision with root package name */
    public String f6456g;

    /* renamed from: j  reason: collision with root package name */
    public long f6457j;

    /* renamed from: k  reason: collision with root package name */
    public Context f6458k;

    public Event(Context context, int i2, long j2) {
        this.f6452c = null;
        this.f6453d = 0L;
        this.f6456g = null;
        this.f6457j = 0L;
        this.f6452c = "Axg" + j2;
        a(context, i2, j2);
    }

    private void a(Context context, int i2, long j2) {
        this.f6458k = context;
        this.f6453d = j2;
        this.f6454e = System.currentTimeMillis() / 1000;
        this.f6455f = i2;
        this.f6456g = com.tencent.android.tpush.stat.b.b.b(context, j2);
        String str = f6450h;
        if (str == null || str.trim().length() < 40) {
            String token = XGPushConfig.getToken(context);
            f6450h = token;
            if (!com.tencent.android.tpush.stat.b.b.c(token)) {
                f6450h = "0";
            }
        }
        if (f6451i == 0) {
            f6451i = CacheManager.getGuid(getContext());
        }
    }

    public boolean decode(JSONObject jSONObject) {
        return true;
    }

    public boolean encode(JSONObject jSONObject) {
        try {
            com.tencent.android.tpush.stat.b.e.a(jSONObject, "ky", this.f6452c);
            EventType type = getType();
            if (type != null) {
                jSONObject.put("et", type.GetIntValue());
            }
            jSONObject.put("ui", com.tencent.android.tpush.stat.b.e.a(this.f6458k));
            com.tencent.android.tpush.stat.b.e.a(jSONObject, am.A, CustomDeviceInfos.getFacilityMacAddr(this.f6458k));
            jSONObject.put("ut", 1);
            if (getType() != EventType.SESSION_ENV) {
                com.tencent.android.tpush.stat.b.e.a(jSONObject, "av", this.f6456g);
                com.tencent.android.tpush.stat.b.e.a(jSONObject, "ch", channel);
            }
            com.tencent.android.tpush.stat.b.e.a(jSONObject, "mid", f6450h);
            jSONObject.put("si", this.f6455f);
            if (getType() == EventType.CUSTOM) {
                jSONObject.put("cts", this.f6454e);
                long j2 = this.f6457j;
                if (j2 == 0) {
                    long j3 = this.f6454e;
                    if (j3 != 0) {
                        jSONObject.put("ts", j3);
                    }
                }
                jSONObject.put("ts", j2);
            } else {
                jSONObject.put("ts", this.f6454e);
            }
            if ("0".equals(com.tencent.android.tpush.stat.b.b.a(this.f6458k, this.f6453d))) {
                jSONObject.put("sv", com.tencent.android.tpush.stat.b.b.a(this.f6458k));
            } else {
                jSONObject.put("sv", com.tencent.android.tpush.stat.b.b.a(this.f6458k, this.f6453d));
            }
            jSONObject.put("guid", f6451i);
            jSONObject.put("dts", com.tencent.android.tpush.stat.b.b.a(this.f6458k, false));
            return onEncode(jSONObject);
        } catch (Throwable unused) {
            return false;
        }
    }

    public long getAccessid() {
        return this.f6453d;
    }

    public String getAppkey() {
        return this.f6452c;
    }

    public Context getContext() {
        return this.f6458k;
    }

    public long getMsgTimeSec() {
        return this.f6457j;
    }

    public long getTimestamp() {
        return this.f6454e;
    }

    public abstract EventType getType();

    public abstract boolean onEncode(JSONObject jSONObject);

    public void setAccessid(long j2) {
        this.f6453d = j2;
    }

    public void setAppkey(String str) {
        this.f6452c = str;
    }

    public void setMsgTimeSec(long j2) {
        this.f6457j = j2;
    }

    public String toJsonString() {
        try {
            JSONObject jSONObject = new JSONObject();
            encode(jSONObject);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String toString() {
        return toJsonString();
    }

    public Event(Context context, String str) {
        this.f6452c = null;
        this.f6453d = 0L;
        this.f6456g = null;
        this.f6457j = 0L;
        this.f6452c = str;
        a(context, 0, 0L);
    }

    public Event(Context context, String str, long j2) {
        this.f6452c = null;
        this.f6453d = 0L;
        this.f6456g = null;
        this.f6457j = 0L;
        this.f6452c = str;
        a(context, 0, j2);
    }

    public Event(Context context) {
        this.f6452c = null;
        this.f6453d = 0L;
        this.f6456g = null;
        this.f6457j = 0L;
        a(context, 0, 0L);
    }
}
