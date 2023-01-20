package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import com.tencent.android.tpush.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a extends d {
    public long a = 0;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public int f6288c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f6289d = 0;

    /* renamed from: e  reason: collision with root package name */
    public String f6290e = "";

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<q> f6291f = null;

    @Override // com.tencent.android.tpush.service.protocol.d
    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessId", this.a);
        jSONObject.put("accessKey", this.b);
        jSONObject.put(Constants.FLAG_ACCOUNT_OP_TYPE, this.f6288c);
        jSONObject.put("timestamp", this.f6289d);
        jSONObject.put(com.heytap.mcssdk.constant.b.C, this.f6290e);
        if (this.f6291f != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<q> it = this.f6291f.iterator();
            while (it.hasNext()) {
                JSONObject a = it.next().a();
                if (a != null) {
                    jSONArray.put(a);
                }
            }
            jSONObject.put("typeAccounts", jSONArray);
        }
        return jSONObject;
    }

    @Override // com.tencent.android.tpush.service.protocol.c
    public MessageType a() {
        return MessageType.ACCOUNT;
    }
}
