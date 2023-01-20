package com.huawei.hms.push;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.DateUtil;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.api.push.PushException;
import com.huawei.hms.support.log.HMSLog;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class RemoteMessage implements Parcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;
    public static final String[] a;
    public static final int[] b;

    /* renamed from: c  reason: collision with root package name */
    public static final long[] f3641c;

    /* renamed from: d  reason: collision with root package name */
    public static final HashMap<String, Object> f3642d;

    /* renamed from: e  reason: collision with root package name */
    public static final HashMap<String, Object> f3643e;

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<String, Object> f3644f;

    /* renamed from: g  reason: collision with root package name */
    public static final HashMap<String, Object> f3645g;

    /* renamed from: h  reason: collision with root package name */
    public static final HashMap<String, Object> f3646h;

    /* renamed from: i  reason: collision with root package name */
    public Bundle f3647i;

    /* renamed from: j  reason: collision with root package name */
    public Notification f3648j;

    /* loaded from: classes2.dex */
    public static class Builder {
        public final Bundle a;
        public final Map<String, String> b;

        public Builder(String str) {
            Bundle bundle = new Bundle();
            this.a = bundle;
            this.b = new HashMap();
            bundle.putString("to", str);
        }

        public Builder addData(String str, String str2) {
            if (str != null) {
                this.b.put(str, str2);
                return this;
            }
            throw new IllegalArgumentException("add data failed, key is null.");
        }

        public RemoteMessage build() {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : this.b.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                try {
                    String jSONObject2 = jSONObject.toString();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(RemoteMessageConst.COLLAPSE_KEY, this.a.getString(RemoteMessageConst.COLLAPSE_KEY));
                    jSONObject3.put("ttl", this.a.getInt("ttl"));
                    jSONObject3.put(RemoteMessageConst.SEND_MODE, this.a.getInt(RemoteMessageConst.SEND_MODE));
                    jSONObject3.put(RemoteMessageConst.RECEIPT_MODE, this.a.getInt(RemoteMessageConst.RECEIPT_MODE));
                    JSONObject jSONObject4 = new JSONObject();
                    if (jSONObject.length() != 0) {
                        jSONObject4.put("data", jSONObject2);
                    }
                    jSONObject4.put("msgId", this.a.getString("msgId"));
                    jSONObject3.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject4);
                    bundle.putByteArray(RemoteMessageConst.MSGBODY, jSONObject3.toString().getBytes(x.a));
                    bundle.putString("to", this.a.getString("to"));
                    bundle.putString("message_type", this.a.getString("message_type"));
                    return new RemoteMessage(bundle);
                } catch (JSONException unused) {
                    HMSLog.w("RemoteMessage", "JSONException: parse message body failed.");
                    throw new PushException(PushException.EXCEPTION_SEND_FAILED);
                }
            } catch (JSONException unused2) {
                HMSLog.w("RemoteMessage", "JSONException: parse data to json failed.");
                throw new PushException(PushException.EXCEPTION_SEND_FAILED);
            }
        }

        public Builder clearData() {
            this.b.clear();
            return this;
        }

        public Builder setCollapseKey(String str) {
            this.a.putString(RemoteMessageConst.COLLAPSE_KEY, str);
            return this;
        }

        public Builder setData(Map<String, String> map) {
            this.b.clear();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.b.put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Builder setMessageId(String str) {
            this.a.putString("msgId", str);
            return this;
        }

        public Builder setMessageType(String str) {
            this.a.putString("message_type", str);
            return this;
        }

        public Builder setReceiptMode(int i2) {
            if (i2 != 1 && i2 != 0) {
                throw new IllegalArgumentException("receipt mode can only be 0 or 1.");
            }
            this.a.putInt(RemoteMessageConst.RECEIPT_MODE, i2);
            return this;
        }

        public Builder setSendMode(int i2) {
            if (i2 != 0 && i2 != 1) {
                throw new IllegalArgumentException("send mode can only be 0 or 1.");
            }
            this.a.putInt(RemoteMessageConst.SEND_MODE, i2);
            return this;
        }

        public Builder setTtl(int i2) {
            if (i2 >= 1 && i2 <= 1296000) {
                this.a.putInt("ttl", i2);
                return this;
            }
            throw new IllegalArgumentException("ttl must be greater than or equal to 1 and less than or equal to 1296000");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface MessagePriority {
    }

    /* loaded from: classes2.dex */
    public static class Notification implements Serializable {
        public final long[] A;
        public final String B;
        public final String a;
        public final String b;

        /* renamed from: c  reason: collision with root package name */
        public final String[] f3649c;

        /* renamed from: d  reason: collision with root package name */
        public final String f3650d;

        /* renamed from: e  reason: collision with root package name */
        public final String f3651e;

        /* renamed from: f  reason: collision with root package name */
        public final String[] f3652f;

        /* renamed from: g  reason: collision with root package name */
        public final String f3653g;

        /* renamed from: h  reason: collision with root package name */
        public final String f3654h;

        /* renamed from: i  reason: collision with root package name */
        public final String f3655i;

        /* renamed from: j  reason: collision with root package name */
        public final String f3656j;

        /* renamed from: k  reason: collision with root package name */
        public final String f3657k;

        /* renamed from: l  reason: collision with root package name */
        public final String f3658l;

        /* renamed from: m  reason: collision with root package name */
        public final String f3659m;
        public final Uri n;
        public final int o;
        public final String p;
        public final int q;
        public final int r;
        public final int s;
        public final int[] t;
        public final String u;
        public final int v;
        public final String w;
        public final int x;
        public final String y;
        public final String z;

        public /* synthetic */ Notification(Bundle bundle, b bVar) {
            this(bundle);
        }

        public final Integer a(String str) {
            if (str != null) {
                try {
                    return Integer.valueOf(str);
                } catch (NumberFormatException unused) {
                    HMSLog.w("RemoteMessage", "NumberFormatException: get " + str + " failed.");
                }
            }
            return null;
        }

        public Integer getBadgeNumber() {
            return a(this.w);
        }

        public String getBody() {
            return this.f3650d;
        }

        public String[] getBodyLocalizationArgs() {
            String[] strArr = this.f3652f;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getBodyLocalizationKey() {
            return this.f3651e;
        }

        public String getChannelId() {
            return this.f3659m;
        }

        public String getClickAction() {
            return this.f3657k;
        }

        public String getColor() {
            return this.f3656j;
        }

        public String getIcon() {
            return this.f3653g;
        }

        public Uri getImageUrl() {
            String str = this.p;
            if (str == null) {
                return null;
            }
            return Uri.parse(str);
        }

        public Integer getImportance() {
            return a(this.y);
        }

        public String getIntentUri() {
            return this.f3658l;
        }

        public int[] getLightSettings() {
            int[] iArr = this.t;
            return iArr == null ? new int[0] : (int[]) iArr.clone();
        }

        public Uri getLink() {
            return this.n;
        }

        public int getNotifyId() {
            return this.o;
        }

        public String getSound() {
            return this.f3654h;
        }

        public String getTag() {
            return this.f3655i;
        }

        public String getTicker() {
            return this.z;
        }

        public String getTitle() {
            return this.a;
        }

        public String[] getTitleLocalizationArgs() {
            String[] strArr = this.f3649c;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getTitleLocalizationKey() {
            return this.b;
        }

        public long[] getVibrateConfig() {
            long[] jArr = this.A;
            return jArr == null ? new long[0] : (long[]) jArr.clone();
        }

        public Integer getVisibility() {
            return a(this.B);
        }

        public Long getWhen() {
            if (!TextUtils.isEmpty(this.u)) {
                try {
                    return Long.valueOf(DateUtil.parseUtcToMillisecond(this.u));
                } catch (StringIndexOutOfBoundsException unused) {
                    HMSLog.w("RemoteMessage", "StringIndexOutOfBoundsException: parse when failed.");
                } catch (ParseException unused2) {
                    HMSLog.w("RemoteMessage", "ParseException: parse when failed.");
                }
            }
            return null;
        }

        public boolean isAutoCancel() {
            return this.x == 1;
        }

        public boolean isDefaultLight() {
            return this.q == 1;
        }

        public boolean isDefaultSound() {
            return this.r == 1;
        }

        public boolean isDefaultVibrate() {
            return this.s == 1;
        }

        public boolean isLocalOnly() {
            return this.v == 1;
        }

        public Notification(Bundle bundle) {
            this.a = bundle.getString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f3650d = bundle.getString("content");
            this.b = bundle.getString(RemoteMessageConst.Notification.TITLE_LOC_KEY);
            this.f3651e = bundle.getString(RemoteMessageConst.Notification.BODY_LOC_KEY);
            this.f3649c = bundle.getStringArray(RemoteMessageConst.Notification.TITLE_LOC_ARGS);
            this.f3652f = bundle.getStringArray(RemoteMessageConst.Notification.BODY_LOC_ARGS);
            this.f3653g = bundle.getString("icon");
            this.f3656j = bundle.getString("color");
            this.f3654h = bundle.getString(RemoteMessageConst.Notification.SOUND);
            this.f3655i = bundle.getString(RemoteMessageConst.Notification.TAG);
            this.f3659m = bundle.getString(RemoteMessageConst.Notification.CHANNEL_ID);
            this.f3657k = bundle.getString(RemoteMessageConst.Notification.CLICK_ACTION);
            this.f3658l = bundle.getString(RemoteMessageConst.Notification.INTENT_URI);
            this.o = bundle.getInt(RemoteMessageConst.Notification.NOTIFY_ID);
            String string = bundle.getString("url");
            this.n = !TextUtils.isEmpty(string) ? Uri.parse(string) : null;
            this.p = bundle.getString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.q = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS);
            this.r = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_SOUND);
            this.s = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS);
            this.t = bundle.getIntArray(RemoteMessageConst.Notification.LIGHT_SETTINGS);
            this.u = bundle.getString(RemoteMessageConst.Notification.WHEN);
            this.v = bundle.getInt(RemoteMessageConst.Notification.LOCAL_ONLY);
            this.w = bundle.getString(RemoteMessageConst.Notification.BADGE_SET_NUM, null);
            this.x = bundle.getInt(RemoteMessageConst.Notification.AUTO_CANCEL);
            this.y = bundle.getString(RemoteMessageConst.Notification.PRIORITY, null);
            this.z = bundle.getString(RemoteMessageConst.Notification.TICKER);
            this.A = bundle.getLongArray(RemoteMessageConst.Notification.VIBRATE_TIMINGS);
            this.B = bundle.getString("visibility", null);
        }
    }

    static {
        String[] strArr = new String[0];
        a = strArr;
        int[] iArr = new int[0];
        b = iArr;
        long[] jArr = new long[0];
        f3641c = jArr;
        HashMap<String, Object> hashMap = new HashMap<>(8);
        f3642d = hashMap;
        hashMap.put("from", "");
        hashMap.put(RemoteMessageConst.COLLAPSE_KEY, "");
        hashMap.put(RemoteMessageConst.SEND_TIME, "");
        hashMap.put("ttl", Integer.valueOf((int) RemoteMessageConst.DEFAULT_TTL));
        hashMap.put(RemoteMessageConst.URGENCY, 2);
        hashMap.put(RemoteMessageConst.ORI_URGENCY, 2);
        hashMap.put(RemoteMessageConst.SEND_MODE, 0);
        hashMap.put(RemoteMessageConst.RECEIPT_MODE, 0);
        HashMap<String, Object> hashMap2 = new HashMap<>(8);
        f3643e = hashMap2;
        hashMap2.put(RemoteMessageConst.Notification.TITLE_LOC_KEY, "");
        hashMap2.put(RemoteMessageConst.Notification.BODY_LOC_KEY, "");
        hashMap2.put(RemoteMessageConst.Notification.NOTIFY_ICON, "");
        hashMap2.put(RemoteMessageConst.Notification.TITLE_LOC_ARGS, strArr);
        hashMap2.put(RemoteMessageConst.Notification.BODY_LOC_ARGS, strArr);
        hashMap2.put(RemoteMessageConst.Notification.TICKER, "");
        hashMap2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, "");
        hashMap2.put("content", "");
        HashMap<String, Object> hashMap3 = new HashMap<>(8);
        f3644f = hashMap3;
        hashMap3.put("icon", "");
        hashMap3.put("color", "");
        hashMap3.put(RemoteMessageConst.Notification.SOUND, "");
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS, 1);
        hashMap3.put(RemoteMessageConst.Notification.LIGHT_SETTINGS, iArr);
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_SOUND, 1);
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS, 1);
        hashMap3.put(RemoteMessageConst.Notification.VIBRATE_TIMINGS, jArr);
        HashMap<String, Object> hashMap4 = new HashMap<>(8);
        f3645g = hashMap4;
        hashMap4.put(RemoteMessageConst.Notification.TAG, "");
        hashMap4.put(RemoteMessageConst.Notification.WHEN, "");
        hashMap4.put(RemoteMessageConst.Notification.LOCAL_ONLY, 1);
        hashMap4.put(RemoteMessageConst.Notification.BADGE_SET_NUM, "");
        hashMap4.put(RemoteMessageConst.Notification.PRIORITY, "");
        hashMap4.put(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        hashMap4.put("visibility", "");
        hashMap4.put(RemoteMessageConst.Notification.CHANNEL_ID, "");
        HashMap<String, Object> hashMap5 = new HashMap<>(3);
        f3646h = hashMap5;
        hashMap5.put(RemoteMessageConst.Notification.CLICK_ACTION, "");
        hashMap5.put(RemoteMessageConst.Notification.INTENT_URI, "");
        hashMap5.put("url", "");
        CREATOR = new b();
    }

    public RemoteMessage(Bundle bundle) {
        this.f3647i = a(bundle);
    }

    public static JSONObject b(Bundle bundle) {
        try {
            return new JSONObject(w.a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
        } catch (JSONException unused) {
            HMSLog.w("RemoteMessage", "JSONException:parse message body failed.");
            return null;
        }
    }

    public static JSONObject c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PARAM);
        }
        return null;
    }

    public static JSONObject d(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
        }
        return null;
    }

    public final Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        JSONObject b2 = b(bundle);
        JSONObject a2 = a(b2);
        String string = JsonUtil.getString(a2, "data", null);
        bundle2.putString(RemoteMessageConst.ANALYTIC_INFO, JsonUtil.getString(a2, RemoteMessageConst.ANALYTIC_INFO, null));
        bundle2.putString(RemoteMessageConst.DEVICE_TOKEN, bundle.getString(RemoteMessageConst.DEVICE_TOKEN));
        JSONObject d2 = d(a2);
        JSONObject b3 = b(d2);
        JSONObject c2 = c(d2);
        if (bundle.getInt(RemoteMessageConst.INPUT_TYPE) == 1 && s.a(a2, d2, string)) {
            bundle2.putString("data", w.a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
            return bundle2;
        }
        String string2 = bundle.getString("to");
        String string3 = bundle.getString("message_type");
        String string4 = JsonUtil.getString(a2, "msgId", null);
        bundle2.putString("to", string2);
        bundle2.putString("data", string);
        bundle2.putString("msgId", string4);
        bundle2.putString("message_type", string3);
        JsonUtil.transferJsonObjectToBundle(b2, bundle2, f3642d);
        bundle2.putBundle(RemoteMessageConst.NOTIFICATION, a(b2, a2, d2, b3, c2));
        return bundle2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public String getAnalyticInfo() {
        return this.f3647i.getString(RemoteMessageConst.ANALYTIC_INFO);
    }

    public Map<String, String> getAnalyticInfoMap() {
        HashMap hashMap = new HashMap();
        String string = this.f3647i.getString(RemoteMessageConst.ANALYTIC_INFO);
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    hashMap.put(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.w("RemoteMessage", "JSONException: get analyticInfo from map failed.");
            }
        }
        return hashMap;
    }

    public String getCollapseKey() {
        return this.f3647i.getString(RemoteMessageConst.COLLAPSE_KEY);
    }

    public String getData() {
        return this.f3647i.getString("data");
    }

    public Map<String, String> getDataOfMap() {
        HashMap hashMap = new HashMap();
        String string = this.f3647i.getString("data");
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    hashMap.put(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.w("RemoteMessage", "JSONException: get data from map failed");
            }
        }
        return hashMap;
    }

    public String getFrom() {
        return this.f3647i.getString("from");
    }

    public String getMessageId() {
        return this.f3647i.getString("msgId");
    }

    public String getMessageType() {
        return this.f3647i.getString("message_type");
    }

    public Notification getNotification() {
        Bundle bundle = this.f3647i.getBundle(RemoteMessageConst.NOTIFICATION);
        if (this.f3648j == null && bundle != null) {
            this.f3648j = new Notification(bundle, null);
        }
        if (this.f3648j == null) {
            this.f3648j = new Notification(new Bundle(), null);
        }
        return this.f3648j;
    }

    public int getOriginalUrgency() {
        int i2 = this.f3647i.getInt(RemoteMessageConst.ORI_URGENCY);
        if (i2 == 1 || i2 == 2) {
            return i2;
        }
        return 0;
    }

    public int getReceiptMode() {
        return this.f3647i.getInt(RemoteMessageConst.RECEIPT_MODE);
    }

    public int getSendMode() {
        return this.f3647i.getInt(RemoteMessageConst.SEND_MODE);
    }

    public long getSentTime() {
        try {
            String string = this.f3647i.getString(RemoteMessageConst.SEND_TIME);
            if (TextUtils.isEmpty(string)) {
                return 0L;
            }
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            HMSLog.w("RemoteMessage", "NumberFormatException: get sendTime error.");
            return 0L;
        }
    }

    public String getTo() {
        return this.f3647i.getString("to");
    }

    public String getToken() {
        return this.f3647i.getString(RemoteMessageConst.DEVICE_TOKEN);
    }

    public int getTtl() {
        return this.f3647i.getInt("ttl");
    }

    public int getUrgency() {
        int i2 = this.f3647i.getInt(RemoteMessageConst.URGENCY);
        if (i2 == 1 || i2 == 2) {
            return i2;
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeBundle(this.f3647i);
        parcel.writeSerializable(this.f3648j);
    }

    public RemoteMessage(Parcel parcel) {
        this.f3647i = parcel.readBundle();
        this.f3648j = (Notification) parcel.readSerializable();
    }

    public static JSONObject b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
        }
        return null;
    }

    public final Bundle a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        Bundle bundle = new Bundle();
        JsonUtil.transferJsonObjectToBundle(jSONObject3, bundle, f3643e);
        JsonUtil.transferJsonObjectToBundle(jSONObject4, bundle, f3644f);
        JsonUtil.transferJsonObjectToBundle(jSONObject, bundle, f3645g);
        JsonUtil.transferJsonObjectToBundle(jSONObject5, bundle, f3646h);
        bundle.putInt(RemoteMessageConst.Notification.NOTIFY_ID, JsonUtil.getInt(jSONObject2, RemoteMessageConst.Notification.NOTIFY_ID, 0));
        return bundle;
    }

    public static JSONObject a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
        }
        return null;
    }
}
