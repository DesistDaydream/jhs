package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import com.tencent.android.tpush.common.Constants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b extends d {
    public long a = 0;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f6292c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f6293d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f6294e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f6295f = "";

    @Override // com.tencent.android.tpush.service.protocol.d
    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessId", this.a);
        jSONObject.put("accessKey", this.b);
        jSONObject.put("attributes", new JSONObject(this.f6292c));
        jSONObject.put(Constants.FLAG_ACCOUNT_OP_TYPE, this.f6293d);
        jSONObject.put("timestamp", this.f6294e);
        jSONObject.put(com.heytap.mcssdk.constant.b.C, this.f6295f);
        return jSONObject;
    }

    @Override // com.tencent.android.tpush.service.protocol.c
    public MessageType a() {
        return MessageType.ATTRIBUTE_INFO;
    }
}
