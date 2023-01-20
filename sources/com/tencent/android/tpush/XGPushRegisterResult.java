package com.tencent.android.tpush;

import android.content.Intent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.logging.TLogger;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class XGPushRegisterResult implements XGIResult {
    public long a = 0;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f6026c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f6027d = "";

    /* renamed from: e  reason: collision with root package name */
    public short f6028e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f6029f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f6030g = "";

    /* renamed from: h  reason: collision with root package name */
    public int f6031h = 100;

    public long getAccessId() {
        return this.a;
    }

    public String getAccount() {
        return this.f6026c;
    }

    public String getFacilityIdentity() {
        return this.b;
    }

    public String getOtherPushToken() {
        return this.f6030g;
    }

    public int getPushChannel() {
        return this.f6031h;
    }

    public String getTicket() {
        return this.f6027d;
    }

    public short getTicketType() {
        return this.f6028e;
    }

    public String getToken() {
        return this.f6029f;
    }

    @Override // com.tencent.android.tpush.XGIResult
    public void parseIntent(Intent intent) {
        try {
            this.a = intent.getLongExtra("accId", -1L);
            this.b = intent.getStringExtra(Constants.FLAG_DEVICE_ID);
            this.f6026c = intent.getStringExtra(Constants.FLAG_ACCOUNT);
            this.f6027d = intent.getStringExtra(Constants.FLAG_TICKET);
            this.f6028e = intent.getShortExtra(Constants.FLAG_TICKET_TYPE, (short) 0);
            this.f6029f = intent.getStringExtra("token");
        } catch (Throwable unused) {
            TLogger.w("XGPushRegisterResult", "unexpected for parseIntent");
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.FLAG_ACCOUNT, this.f6026c);
            jSONObject.put(Constants.FLAG_TICKET, this.f6027d);
            jSONObject.put(Constants.FLAG_DEVICE_ID, this.b);
            jSONObject.put(Constants.FLAG_TICKET_TYPE, (int) this.f6028e);
            jSONObject.put("token", this.f6029f);
        } catch (Throwable unused) {
            TLogger.w("XGPushRegisterResult", "unexpected for toJson");
        }
        return jSONObject;
    }

    public String toString() {
        return "TPushRegisterMessage [accessId=" + this.a + ", deviceId=" + this.b + ", account=" + this.f6026c + ", ticket=" + this.f6027d + ", ticketType=" + ((int) this.f6028e) + ", token=" + this.f6029f + ", pushChannel=" + this.f6031h + "]";
    }
}
