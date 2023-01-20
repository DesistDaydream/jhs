package com.huawei.hms.push;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.android.tpush.common.Constants;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class k {
    public int B;
    public String D;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public String f3662c;

    /* renamed from: d  reason: collision with root package name */
    public String f3663d;

    /* renamed from: l  reason: collision with root package name */
    public String f3671l;

    /* renamed from: m  reason: collision with root package name */
    public String f3672m;
    public String n;
    public String o;
    public String p;
    public String r;
    public String s;
    public String z;
    public String a = "";

    /* renamed from: e  reason: collision with root package name */
    public String f3664e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f3665f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f3666g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f3667h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f3668i = "";

    /* renamed from: j  reason: collision with root package name */
    public String f3669j = "";

    /* renamed from: k  reason: collision with root package name */
    public String f3670k = "";
    public String q = "";
    public int t = n.STYLE_DEFAULT.ordinal();
    public String u = "";
    public String v = "";
    public String w = "";
    public int x = 0;
    public int y = 0;
    public String A = "";
    public String C = "";
    public String E = "";
    public String F = "";

    public k(byte[] bArr, byte[] bArr2) {
        Charset charset = x.a;
        this.r = new String(bArr, charset);
        this.s = new String(bArr2, charset);
    }

    public final JSONObject a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject);
        jSONObject2.put("group", this.a);
        jSONObject2.put(RemoteMessageConst.Notification.TAG, this.A);
        jSONObject2.put(RemoteMessageConst.Notification.AUTO_CANCEL, this.x);
        jSONObject2.put("visibility", this.y);
        jSONObject2.put(RemoteMessageConst.Notification.WHEN, this.z);
        return jSONObject2;
    }

    public final JSONObject b(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(Constants.MQTT_STATISTISC_MSGTYPE_KEY, this.f3666g);
        jSONObject2.put("content", this.f3667h);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_ICON, this.f3668i);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, this.f3669j);
        jSONObject2.put("notifySummary", this.f3670k);
        jSONObject2.put(RemoteMessageConst.MessageBody.PARAM, jSONObject);
        return jSONObject2;
    }

    public final void c(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("ap")) {
            String string = jSONObject.getString("ap");
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(string) && string.length() < 48) {
                int length = 48 - string.length();
                for (int i2 = 0; i2 < length; i2++) {
                    sb.append("0");
                }
                sb.append(string);
                this.f3663d = sb.toString();
                return;
            }
            this.f3663d = string.substring(0, 48);
        }
    }

    public final boolean d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has(RemoteMessageConst.Notification.CLICK_ACTION)) {
            this.f3672m = jSONObject.getString(RemoteMessageConst.Notification.CLICK_ACTION);
        }
        if (jSONObject.has(RemoteMessageConst.Notification.INTENT_URI)) {
            this.f3662c = jSONObject.getString(RemoteMessageConst.Notification.INTENT_URI);
        }
        if (jSONObject.has("appPackageName")) {
            this.f3671l = jSONObject.getString("appPackageName");
            return true;
        }
        HMSLog.d("PushSelfShowLog", "appPackageName is null");
        return false;
    }

    public final boolean e(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("msgId")) {
            Object obj = jSONObject.get("msgId");
            if (obj instanceof String) {
                this.f3664e = (String) obj;
                return true;
            } else if (obj instanceof Integer) {
                this.f3664e = String.valueOf(((Integer) obj).intValue());
                return true;
            } else {
                return true;
            }
        }
        HMSLog.i("PushSelfShowLog", "msgId == null");
        return false;
    }

    public final boolean f(JSONObject jSONObject) {
        HMSLog.d("PushSelfShowLog", "enter parseNotifyParam");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
            if (jSONObject2.has("style")) {
                this.t = jSONObject2.getInt("style");
            }
            this.u = jSONObject2.optString("bigTitle");
            this.v = jSONObject2.optString("bigContent");
            this.E = jSONObject2.optString("icon");
            return true;
        } catch (JSONException e2) {
            HMSLog.i("PushSelfShowLog", e2.toString());
            return false;
        }
    }

    public final void g(JSONObject jSONObject) {
        this.a = jSONObject.optString("group");
        HMSLog.d("PushSelfShowLog", "NOTIFY_GROUP:" + this.a);
        this.x = jSONObject.optInt(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        HMSLog.d("PushSelfShowLog", "autoCancel: " + this.x);
        this.y = jSONObject.optInt("visibility", 0);
        this.z = jSONObject.optString(RemoteMessageConst.Notification.WHEN);
        this.A = jSONObject.optString(RemoteMessageConst.Notification.TAG);
    }

    public final boolean h(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PARAM);
            if (jSONObject2.has("autoClear")) {
                this.b = jSONObject2.getInt("autoClear");
            } else {
                this.b = 0;
            }
            if (!PushConstants.EXTRA_APPLICATION_PENDING_INTENT.equals(this.f3666g) && !"cosa".equals(this.f3666g)) {
                if ("url".equals(this.f3666g)) {
                    k(jSONObject2);
                    return true;
                } else if ("rp".equals(this.f3666g)) {
                    j(jSONObject2);
                    return true;
                } else {
                    return true;
                }
            }
            d(jSONObject2);
            return true;
        } catch (Exception e2) {
            HMSLog.e("PushSelfShowLog", "ParseParam error ", e2);
            return false;
        }
    }

    public final boolean i(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(RemoteMessageConst.MessageBody.PS_CONTENT)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
            this.f3666g = jSONObject2.getString(Constants.MQTT_STATISTISC_MSGTYPE_KEY);
            this.f3667h = jSONObject2.optString("content");
            this.f3668i = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.f3669j = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f3670k = jSONObject2.optString("notifySummary");
            this.D = jSONObject2.optString(RemoteMessageConst.Notification.TICKER);
            if ((!jSONObject2.has(RemoteMessageConst.MessageBody.NOTIFY_DETAIL) || f(jSONObject2)) && jSONObject2.has(RemoteMessageConst.MessageBody.PARAM)) {
                return h(jSONObject2);
            }
        }
        return false;
    }

    public final boolean j(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("appPackageName")) {
            this.f3671l = jSONObject.getString("appPackageName");
        }
        if (jSONObject.has("rpt") && jSONObject.has("rpl")) {
            this.o = jSONObject.getString("rpl");
            this.p = jSONObject.getString("rpt");
            if (jSONObject.has("rpct")) {
                this.q = jSONObject.getString("rpct");
                return true;
            }
            return true;
        }
        HMSLog.d("PushSelfShowLog", "rpl or rpt is null");
        return false;
    }

    public final boolean k(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("url")) {
            this.n = jSONObject.getString("url");
            if (jSONObject.has("appPackageName")) {
                this.f3671l = jSONObject.getString("appPackageName");
            }
            if (jSONObject.has("rpt") && jSONObject.has("rpl")) {
                this.o = jSONObject.getString("rpl");
                this.p = jSONObject.getString("rpt");
                if (jSONObject.has("rpct")) {
                    this.q = jSONObject.getString("rpct");
                    return true;
                }
                return true;
            }
            return true;
        }
        HMSLog.d("PushSelfShowLog", "url is null");
        return false;
    }

    public String l() {
        return this.a;
    }

    public String m() {
        return this.E;
    }

    public String n() {
        return this.f3662c;
    }

    public byte[] o() {
        try {
            return a(a(b(v()), r())).toString().getBytes(x.a);
        } catch (JSONException e2) {
            HMSLog.e("PushSelfShowLog", "getMsgData failed JSONException:", e2);
            return new byte[0];
        }
    }

    public String p() {
        HMSLog.d("PushSelfShowLog", "msgId =" + this.f3664e);
        return this.f3664e;
    }

    public String q() {
        return this.A;
    }

    public final JSONObject r() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("style", this.t);
        jSONObject.put("bigTitle", this.u);
        jSONObject.put("bigContent", this.v);
        jSONObject.put("bigPic", this.w);
        return jSONObject;
    }

    public int s() {
        return this.B;
    }

    public String t() {
        return this.f3670k;
    }

    public String u() {
        return this.f3669j;
    }

    public final JSONObject v() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoClear", this.b);
        jSONObject.put("url", this.n);
        jSONObject.put("rpl", this.o);
        jSONObject.put("rpt", this.p);
        jSONObject.put("rpct", this.q);
        jSONObject.put("appPackageName", this.f3671l);
        jSONObject.put(RemoteMessageConst.Notification.CLICK_ACTION, this.f3672m);
        jSONObject.put(RemoteMessageConst.Notification.INTENT_URI, this.f3662c);
        return jSONObject;
    }

    public int w() {
        return this.t;
    }

    public String x() {
        return this.D;
    }

    public byte[] y() {
        return this.s.getBytes(x.a);
    }

    public boolean z() {
        try {
            if (TextUtils.isEmpty(this.r)) {
                HMSLog.d("PushSelfShowLog", "msg is null");
                return false;
            }
            JSONObject jSONObject = new JSONObject(this.r);
            g(jSONObject);
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
            if (e(jSONObject2)) {
                this.f3665f = jSONObject2.optString("dispPkgName");
                c(jSONObject2);
                this.B = jSONObject2.optInt(RemoteMessageConst.Notification.NOTIFY_ID, -1);
                this.C = jSONObject2.optString("data");
                this.F = jSONObject2.optString(RemoteMessageConst.ANALYTIC_INFO);
                return i(jSONObject2);
            }
            return false;
        } catch (JSONException unused) {
            HMSLog.d("PushSelfShowLog", "parse message exception.");
            return false;
        } catch (Exception e2) {
            HMSLog.d("PushSelfShowLog", e2.toString());
            return false;
        }
    }

    public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("dispPkgName", this.f3665f);
        jSONObject3.put("msgId", this.f3664e);
        jSONObject3.put("ap", this.f3663d);
        jSONObject3.put(RemoteMessageConst.Notification.NOTIFY_ID, this.B);
        jSONObject3.put(RemoteMessageConst.MessageBody.PS_CONTENT, jSONObject);
        jSONObject3.put(RemoteMessageConst.MessageBody.NOTIFY_DETAIL, jSONObject2);
        jSONObject3.put(RemoteMessageConst.Notification.TICKER, this.D);
        jSONObject3.put("data", this.C);
        return jSONObject3;
    }

    public String b() {
        return this.F;
    }

    public String d() {
        return this.f3671l;
    }

    public String g() {
        return this.v;
    }

    public int e() {
        return this.x;
    }

    public int f() {
        return this.b;
    }

    public String j() {
        return this.f3667h;
    }

    public String c() {
        return this.f3663d;
    }

    public String k() {
        return this.f3665f;
    }

    public String h() {
        return this.u;
    }

    public String i() {
        return this.f3666g;
    }

    public String a() {
        return this.f3672m;
    }

    public void a(int i2) {
        this.B = i2;
    }
}
