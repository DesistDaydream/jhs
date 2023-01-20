package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class r extends d {
    public short a = 0;
    public long b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f6362c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f6363d = "";

    /* renamed from: e  reason: collision with root package name */
    public byte f6364e = 0;

    /* renamed from: f  reason: collision with root package name */
    public byte f6365f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f6366g = 0;

    /* renamed from: h  reason: collision with root package name */
    public String f6367h = "";

    @Override // com.tencent.android.tpush.service.protocol.d
    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("deviceType", (int) this.a);
        jSONObject.put("accessId", this.b);
        jSONObject.put("accessKey", this.f6362c);
        jSONObject.put("appCert", this.f6363d);
        jSONObject.put("keyEncrypted", (int) this.f6364e);
        jSONObject.put("isUninstall", (int) this.f6365f);
        jSONObject.put("timestamp", this.f6366g);
        jSONObject.put(com.heytap.mcssdk.constant.b.C, this.f6367h);
        return jSONObject;
    }

    @Override // com.tencent.android.tpush.service.protocol.c
    public MessageType a() {
        return MessageType.UNREGISTER;
    }
}
