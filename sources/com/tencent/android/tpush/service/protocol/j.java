package com.tencent.android.tpush.service.protocol;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.logging.TLogger;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class j {
    public long a = 0;
    public long b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f6317c = 0;

    /* renamed from: d  reason: collision with root package name */
    public String f6318d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f6319e = "";

    /* renamed from: f  reason: collision with root package name */
    public long f6320f = 0;

    /* renamed from: g  reason: collision with root package name */
    public String f6321g = "";

    /* renamed from: h  reason: collision with root package name */
    public long f6322h = 0;

    /* renamed from: i  reason: collision with root package name */
    public long f6323i = 0;

    /* renamed from: j  reason: collision with root package name */
    public String f6324j = "";

    /* renamed from: k  reason: collision with root package name */
    public long f6325k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f6326l = 0;

    /* renamed from: m  reason: collision with root package name */
    public long f6327m = 0;
    public long n = 0;
    public long o = 0;
    public String p = "";
    public String q = "";
    public String r = "";
    public String s = "";
    public long t = 0;
    public long u = 0;
    public int v = 0;
    public String w = "";
    public String x = "";
    public String y = "";

    public void a(JSONObject jSONObject) {
        b(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("content");
        if (optJSONObject != null) {
            this.f6319e = optJSONObject.toString();
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(MessageKey.MSG_IN_MSG);
        if (optJSONObject2 != null) {
            this.y = optJSONObject2.toString();
        }
    }

    public void b(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("xg");
            if (optJSONObject != null) {
                TLogger.w("PushMessage", "parse mqtt msg contain key \"xg\"");
                jSONObject = optJSONObject;
            } else {
                TLogger.w("PushMessage", "parse mqtt msg not contain key \"xg\"");
            }
            this.a = jSONObject.optLong("msgId", 0L);
            this.b = jSONObject.optLong("accessId", 0L);
            this.f6317c = jSONObject.optLong("busiMsgId", 0L);
            this.f6318d = jSONObject.optString("title", "");
            long optLong = jSONObject.optLong("type", 0L);
            this.f6320f = optLong;
            if (optLong == 0) {
                this.f6320f = jSONObject.optLong("msgType", 0L);
            }
            this.f6321g = jSONObject.optString("appPkgName", "");
            this.f6322h = jSONObject.optLong("timestamp", 0L) * 1000;
            this.f6323i = jSONObject.optLong(MessageKey.MSG_CREATE_MULTIPKG, 0L);
            this.f6324j = jSONObject.optString(MessageKey.MSG_DATE, "");
            this.f6325k = jSONObject.optLong("serverTime", 0L) * 1000000;
            this.f6326l = jSONObject.optInt("ttl", 0);
            this.f6327m = jSONObject.optLong(RemoteMessageConst.Notification.CHANNEL_ID, 0L);
            this.n = jSONObject.optLong("adPush", 0L);
            this.o = jSONObject.optLong("reseverId", 0L);
            this.p = jSONObject.optString("statTag", "");
            this.r = jSONObject.optString("groupId", "");
            this.t = jSONObject.optLong(MessageKey.MSG_TARGET_TYPE, 0L);
            this.u = jSONObject.optLong(MessageKey.MSG_SOURCE, 0L);
            this.v = jSONObject.optInt(MessageKey.MSG_REVOKEID, 0);
            this.w = jSONObject.optString(MessageKey.MSG_TEMPLATE_ID, "");
            this.x = jSONObject.optString(MessageKey.MSG_TRACE_ID, "");
        } catch (Throwable unused) {
        }
    }
}
