package com.tencent.android.tpush.service.protocol;

import com.tencent.android.tpush.common.MessageKey;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PushStatClientReport {
    public long a;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public String f6279c;

    /* renamed from: d  reason: collision with root package name */
    public String f6280d;

    /* renamed from: e  reason: collision with root package name */
    public long f6281e;

    /* renamed from: f  reason: collision with root package name */
    public long f6282f;

    /* renamed from: g  reason: collision with root package name */
    public EnumPushAction f6283g;

    /* renamed from: h  reason: collision with root package name */
    public long f6284h;

    /* renamed from: i  reason: collision with root package name */
    public String f6285i;

    /* renamed from: j  reason: collision with root package name */
    public long f6286j;

    /* renamed from: k  reason: collision with root package name */
    public String f6287k;

    /* loaded from: classes3.dex */
    public enum EnumPushAction {
        PUSH_ACTION_MOBILE_SERVICE_RECEIVED(4),
        PUSH_ACTION_MOBILE_APP_RECEIVED(8),
        PUSH_ACTION_MOBILE_USER_CLICK(16),
        PUSH_ACTION_MOBILE_CLEAN_UP(32);
        
        private long type;

        EnumPushAction(long j2) {
            this.type = j2;
        }

        public long getType() {
            return this.type;
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("msgId", this.a);
        jSONObject.put("accessId", this.b);
        jSONObject.put("accessKey", this.f6279c);
        jSONObject.put("token", this.f6280d);
        jSONObject.put(MessageKey.MSG_PUSH_TIME, this.f6281e / 1000);
        jSONObject.put("timestamp", this.f6282f / 1000);
        jSONObject.put("pushAction", this.f6283g.getType());
        jSONObject.put("msgType", this.f6284h);
        jSONObject.put("groupId", this.f6285i);
        jSONObject.put("pushChannel", this.f6286j);
        jSONObject.put(com.heytap.mcssdk.constant.b.C, this.f6287k);
        return jSONObject;
    }

    public String toString() {
        try {
            return a().toString();
        } catch (JSONException unused) {
            return "JSONException";
        }
    }
}
