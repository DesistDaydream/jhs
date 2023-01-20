package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import com.huawei.hms.push.constant.RemoteMessageConst;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class p extends d {
    public long a = 0;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f6358c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f6359d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f6360e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f6361f = "";

    @Override // com.tencent.android.tpush.service.protocol.d
    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessId", this.a);
        jSONObject.put("accessKey", this.b);
        jSONObject.put(RemoteMessageConst.Notification.TAG, this.f6358c);
        jSONObject.put("flag", this.f6359d);
        jSONObject.put("timestamp", this.f6360e);
        jSONObject.put(com.heytap.mcssdk.constant.b.C, this.f6361f);
        return jSONObject;
    }

    @Override // com.tencent.android.tpush.service.protocol.c
    public MessageType a() {
        return MessageType.TAG_INFO;
    }
}
