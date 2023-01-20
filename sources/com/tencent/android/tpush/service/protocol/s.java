package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class s extends d {
    public long a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f6368c;

    /* renamed from: d  reason: collision with root package name */
    public String f6369d;

    /* renamed from: e  reason: collision with root package name */
    public long f6370e;

    /* renamed from: f  reason: collision with root package name */
    public String f6371f;

    public s() {
        this.a = 0L;
        this.b = "";
        this.f6368c = "";
        this.f6369d = "";
        this.f6370e = 0L;
        this.f6371f = "";
    }

    @Override // com.tencent.android.tpush.service.protocol.d
    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessId", this.a);
        jSONObject.put("accessKey", this.b);
        jSONObject.put("channelType", this.f6368c);
        jSONObject.put("channelToken", this.f6369d);
        jSONObject.put("timestamp", this.f6370e);
        jSONObject.put(com.heytap.mcssdk.constant.b.C, this.f6371f);
        return jSONObject;
    }

    public s(long j2, String str, String str2, String str3, long j3, String str4) {
        this.a = 0L;
        this.b = "";
        this.f6368c = "";
        this.f6369d = "";
        this.f6370e = 0L;
        this.f6371f = "";
        this.a = j2;
        this.b = str;
        this.f6368c = str2;
        this.f6369d = str3;
        this.f6370e = j3;
        this.f6371f = str4;
    }

    @Override // com.tencent.android.tpush.service.protocol.c
    public MessageType a() {
        return MessageType.UPDATE_OTHER_TOKEN;
    }
}
