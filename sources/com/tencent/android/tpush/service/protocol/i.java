package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import com.vivo.push.PushClientConstants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class i extends d {
    public long a = 0;
    public long b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f6310c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f6311d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f6312e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f6313f = 0;

    /* renamed from: g  reason: collision with root package name */
    public String f6314g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f6315h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f6316i = "";

    @Override // com.tencent.android.tpush.service.protocol.d
    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.a);
        jSONObject.put("accessId", this.b);
        jSONObject.put("msgId", this.f6310c);
        jSONObject.put("broadcastId", this.f6311d);
        jSONObject.put("msgTimestamp", this.f6312e);
        jSONObject.put("clientTimestamp", this.f6313f);
        jSONObject.put("msg", this.f6314g);
        jSONObject.put("ext", this.f6315h);
        jSONObject.put(PushClientConstants.TAG_PKG_NAME, this.f6316i);
        return jSONObject;
    }

    @Override // com.tencent.android.tpush.service.protocol.c
    public MessageType a() {
        return MessageType.COMMON_REPORT;
    }
}
