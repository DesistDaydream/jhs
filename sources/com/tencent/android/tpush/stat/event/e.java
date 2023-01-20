package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class e extends Event {
    private int a;
    private int b;

    /* renamed from: l  reason: collision with root package name */
    private long f6465l;

    public e(Context context, int i2, int i3, long j2) {
        super(context);
        this.a = 1;
        this.a = i2;
        this.b = i3;
        this.f6465l = j2;
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public EventType getType() {
        return EventType.LAUNCH;
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public boolean onEncode(JSONObject jSONObject) {
        return true;
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            EventType type = getType();
            if (type != null) {
                jSONObject.put("et", type.GetIntValue());
            }
            jSONObject.put("launchType", this.a);
            jSONObject.put(com.heytap.mcssdk.constant.b.C, "1.3.5.0");
            jSONObject.put("token", GuidInfoManager.getToken(this.f6458k.getApplicationContext()));
            jSONObject.put("accessId", XGApiConfig.getAccessId(this.f6458k));
            jSONObject.put("appkey", XGApiConfig.getAccessKey(this.f6458k));
            jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject.put("idx", com.tencent.android.tpush.stat.b.b.a());
            jSONObject.put("firstLaunch", this.b);
            if (this.a == 3) {
                jSONObject.put(PushConstants.KEY_PUSH_ID, this.f6465l);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            TLogger.e("LaunchEvent toJson Error:", th.getMessage());
            return "";
        }
    }

    @Override // com.tencent.android.tpush.stat.event.Event
    public String toString() {
        return toJsonString();
    }
}
