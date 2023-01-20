package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import com.tencent.android.tpush.common.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class n extends e {
    public long a = 0;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public long f6344c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f6345d = 0;

    /* renamed from: e  reason: collision with root package name */
    public String f6346e = "";

    /* renamed from: f  reason: collision with root package name */
    public long f6347f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f6348g = 0;

    /* renamed from: h  reason: collision with root package name */
    public String f6349h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f6350i = "";

    /* renamed from: j  reason: collision with root package name */
    public int f6351j = -1;

    /* renamed from: k  reason: collision with root package name */
    public ArrayList<String> f6352k = null;

    public void a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        this.a = jSONObject.optLong("confVersion", this.a);
        this.b = jSONObject.optString("token", this.b);
        this.f6344c = jSONObject.optLong("guid", this.f6344c);
        this.f6345d = jSONObject.optLong("otherPushTokenType", this.f6345d);
        this.f6346e = jSONObject.optString("otherPushToken", this.f6346e);
        this.f6347f = jSONObject.optLong("otherPushTokenCrc32", this.f6347f);
        this.f6348g = jSONObject.optLong("tokenCrc32", this.f6348g);
        this.f6349h = jSONObject.optString("reserved", this.f6349h);
        this.f6350i = jSONObject.optString(Constants.FLAG_TICKET, this.f6350i);
        this.f6351j = jSONObject.optInt(Constants.FLAG_TICKET_TYPE, this.f6351j);
        JSONArray optJSONArray = jSONObject.optJSONArray("groupKeys");
        if (optJSONArray != null) {
            this.f6352k = new ArrayList<>();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                this.f6352k.add(optJSONArray.getString(i2));
            }
        }
    }

    @Override // com.tencent.android.tpush.service.protocol.c
    public MessageType a() {
        return MessageType.REGISTER;
    }

    public static String a(Context context, String str) {
        if (context != null && !com.tencent.android.tpush.common.i.b(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                return jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
