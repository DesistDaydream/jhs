package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.android.tpush.common.Constants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class l extends d {
    public long a = 0;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public int f6328c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f6329d = 100;

    /* renamed from: e  reason: collision with root package name */
    public long f6330e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f6331f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f6332g = "";

    @Override // com.tencent.android.tpush.service.protocol.d
    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessId", this.a);
        jSONObject.put("accessKey", this.b);
        jSONObject.put("offset", this.f6328c);
        jSONObject.put("limit", this.f6329d);
        jSONObject.put("timestamp", this.f6330e);
        jSONObject.put(com.heytap.mcssdk.constant.b.C, this.f6331f);
        if (!TextUtils.isEmpty(this.f6332g)) {
            jSONObject.put(Constants.FLAG_TAG_QUERY_TYPE, this.f6332g);
        }
        return jSONObject;
    }

    @Override // com.tencent.android.tpush.service.protocol.c
    public MessageType a() {
        return MessageType.QUERY_TAGS;
    }
}
