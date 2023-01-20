package com.tencent.android.tpush.service.protocol;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;
import com.tencent.tpns.baseapi.base.util.CacheHelper;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.Md5;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class m extends d {
    public String L;
    public String M;
    public long a = 0;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f6333c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f6334d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f6335e = "";

    /* renamed from: f  reason: collision with root package name */
    public short f6336f = 0;

    /* renamed from: g  reason: collision with root package name */
    public short f6337g = 0;

    /* renamed from: h  reason: collision with root package name */
    public f f6338h = null;

    /* renamed from: i  reason: collision with root package name */
    public short f6339i = 0;

    /* renamed from: j  reason: collision with root package name */
    public byte f6340j = 0;

    /* renamed from: k  reason: collision with root package name */
    public h f6341k = null;

    /* renamed from: l  reason: collision with root package name */
    public short f6342l = 0;

    /* renamed from: m  reason: collision with root package name */
    public String f6343m = "";
    public String n = "";
    public String o = "";
    public long p = 0;
    public long q = 0;
    public long r = 0;
    public long s = 0;
    public long t = 0;
    public long u = 0;
    public String v = "";
    public long w = 0;
    public long x = 0;
    public String y = "";
    public String z = "";
    public String A = "";
    public String B = "";
    public String C = "";
    public int D = 0;
    public g E = null;
    public int F = 0;
    public long G = 0;
    public boolean H = true;
    public boolean I = false;
    public String J = null;
    public boolean K = false;

    @Override // com.tencent.android.tpush.service.protocol.d
    public JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accessId", this.a);
        jSONObject.put("accessKey", this.b);
        jSONObject.put(Constants.FLAG_DEVICE_ID, this.f6333c);
        jSONObject.put("appCert", this.f6334d);
        jSONObject.put(Constants.FLAG_TICKET, this.f6335e);
        jSONObject.put(Constants.FLAG_TICKET_TYPE, (int) this.f6336f);
        jSONObject.put("deviceType", (int) this.f6337g);
        f fVar = this.f6338h;
        if (fVar != null) {
            jSONObject.put("deviceInfo", fVar.a());
            f fVar2 = this.f6338h;
            this.M = com.tencent.android.tpush.service.util.b.a(fVar2.t, fVar2.u);
        }
        jSONObject.put("version", (int) this.f6339i);
        jSONObject.put("keyEncrypted", (int) this.f6340j);
        h hVar = this.f6341k;
        if (hVar != null) {
            jSONObject.put("mutableInfo", hVar.a());
        }
        jSONObject.put("updateAutoTag", (int) this.f6342l);
        jSONObject.put("appVersion", this.f6343m);
        jSONObject.put("clientid", this.o);
        jSONObject.put("connVersion", this.r);
        jSONObject.put(RemoteMessageConst.Notification.CHANNEL_ID, this.s);
        jSONObject.put("otherPushTokenOpType", this.t);
        jSONObject.put("otherPushTokenType", this.u);
        jSONObject.put("otherPushToken", this.v);
        jSONObject.put("otherPushTokenCrc32", this.w);
        jSONObject.put("tokenCrc32", this.x);
        jSONObject.put("otherPushData", this.y);
        jSONObject.put(com.heytap.mcssdk.constant.b.C, this.z);
        if (!com.tencent.android.tpush.common.i.b(this.A) && !com.tencent.android.tpush.common.i.b(this.B)) {
            jSONObject.put("channelToken", this.A);
            jSONObject.put("channelType", this.B);
        }
        if (!com.tencent.android.tpush.common.i.b(this.C)) {
            jSONObject.put("appPkgName", this.C);
        }
        jSONObject.put("tAd", this.D);
        g gVar = this.E;
        if (gVar != null && gVar.a()) {
            jSONObject.put("freeVersionInfo", this.E.b());
        }
        jSONObject.put("hwSdk", this.F);
        jSONObject.put("cloudVersion", this.G);
        try {
            String jSONObject2 = jSONObject.toString();
            String str = (String) CacheHelper.get(context, com.tencent.android.tpush.d.b.a.a());
            String md5 = Md5.md5(jSONObject2.substring(0, jSONObject2.indexOf("bootTime")) + jSONObject2.substring(jSONObject2.indexOf("countryCode")));
            if (md5 != null && md5.equals(str)) {
                this.H = false;
            } else {
                this.H = true;
                CacheHelper.set(context, com.tencent.android.tpush.d.b.a.a().set(md5));
            }
        } catch (Throwable unused) {
            this.H = true;
        }
        jSONObject.put("timestamp", this.q);
        return jSONObject;
    }

    public boolean b(Context context) {
        try {
            a(context);
        } catch (Throwable th) {
            TLogger.d("RegisterReq", "unexpected for:" + th.getMessage());
        }
        return this.H;
    }

    @Override // com.tencent.android.tpush.service.protocol.c
    public MessageType a() {
        return MessageType.REGISTER;
    }

    public static m a(Context context, Intent intent, boolean z) {
        if (intent == null) {
            Logger.w("RegReq", "intent was null");
            return null;
        } else if (context == null) {
            Logger.w("RegReq", "context was null");
            return null;
        } else {
            try {
                m mVar = new m();
                mVar.a = Long.parseLong(Rijndael.decrypt(intent.getStringExtra("accId")));
                mVar.b = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_ACC_KEY));
                mVar.J = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_PACK_NAME));
                mVar.f6335e = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_TICKET));
                mVar.f6336f = (short) intent.getIntExtra(Constants.FLAG_TICKET_TYPE, -1);
                String decrypt = Rijndael.decrypt(intent.getStringExtra("qua"));
                mVar.f6343m = intent.getStringExtra("appVer");
                mVar.n = Rijndael.decrypt(intent.getStringExtra("reserved"));
                mVar.s = intent.getLongExtra("accChannel", -1L);
                String stringExtra = intent.getStringExtra("url");
                mVar.v = intent.getStringExtra("otherToken");
                String stringExtra2 = intent.getStringExtra("payload");
                mVar.u = intent.getLongExtra("otherPushType", -1L);
                mVar.t = intent.getLongExtra("otherPushTokenOpType", -1L);
                mVar.I = intent.getBooleanExtra("aidl", false);
                String stringExtra3 = intent.getStringExtra("channelToken");
                String stringExtra4 = intent.getStringExtra("channelType");
                mVar.G = CloudManager.getInstance(context).getCloudVersion();
                try {
                    if (!com.tencent.android.tpush.common.i.b(decrypt)) {
                        CacheManager.setQua(context, mVar.a, decrypt);
                    }
                } catch (Throwable unused) {
                }
                try {
                    mVar.f6334d = TpnsSecurity.getEncryptAPKSignature(context.createPackageContext(mVar.J, 0));
                } catch (Throwable unused2) {
                }
                mVar.f6333c = com.tencent.android.tpush.service.util.a.a();
                mVar.z = "1.3.5.0";
                mVar.f6338h = com.tencent.android.tpush.service.c.a(com.tencent.android.tpush.service.b.e());
                mVar.f6339i = (short) 4;
                mVar.r = 0L;
                mVar.q = System.currentTimeMillis() / 1000;
                if (!com.tencent.android.tpush.common.i.b(stringExtra)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("url", stringExtra);
                        if (!com.tencent.android.tpush.common.i.b(stringExtra2)) {
                            jSONObject.put("payload", stringExtra2);
                        }
                    } catch (JSONException unused3) {
                    }
                    mVar.y = jSONObject.toString();
                }
                mVar.p = CacheManager.getGuid(com.tencent.android.tpush.service.b.e());
                if (stringExtra3 != null && stringExtra4 != null) {
                    mVar.A = stringExtra3;
                    mVar.B = stringExtra4;
                }
                if (context != null) {
                    mVar.C = context.getPackageName();
                }
                Class.forName("com.qq.e.ads.ADActivity");
                mVar.D = 1;
                mVar.F = com.tencent.android.tpush.c.a.a();
                mVar.K = intent.getBooleanExtra("hasRegisted", false);
                mVar.L = intent.getStringExtra("token");
                TLogger.vv("RegReq", "Register(" + mVar.a + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + mVar.f6333c + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + mVar.f6335e + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + ((int) mVar.f6336f) + "),payload: " + mVar.y + " channel id" + mVar.s);
                return mVar;
            } catch (Throwable th) {
                TLogger.e("RegReq", ">> register error " + th);
                TLogger.e("RegReq", ">> register error-> " + TLogger.getStackTraceString(th));
                return null;
            }
        }
    }
}
