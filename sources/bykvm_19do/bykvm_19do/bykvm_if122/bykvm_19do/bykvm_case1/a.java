package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.api.v2.ad.custom.bean.GMCustomInitConfig;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private GMCustomInitConfig f736c;

    public a(String str, String str2) {
        this.a = str;
        this.b = str2;
        this.f736c = new GMCustomInitConfig();
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.a = str2;
        this.b = str3;
        this.f736c = new GMCustomInitConfig(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
    }

    public static a a(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("app_id");
            String optString2 = jSONObject.optString(TTBaseAdapterConfiguration.APP_KEY_EXTRA_KEY);
            String optString3 = jSONObject.optString("custom_type");
            return !TextUtils.equals(optString3, "1") ? new a(optString, optString2) : new a(str, optString, optString2, jSONObject.optString("init_class_name"), jSONObject.optString("banner_class_name"), jSONObject.optString("interstitial_class_name"), jSONObject.optString("reward_class_name"), jSONObject.optString("full_video_class_name"), jSONObject.optString("splash_class_name"), jSONObject.optString("feed_class_name"), jSONObject.optString("draw_class_name"), optString3);
        }
        return null;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public GMCustomInitConfig c() {
        return this.f736c;
    }

    public boolean d() {
        GMCustomInitConfig gMCustomInitConfig = this.f736c;
        return gMCustomInitConfig != null && gMCustomInitConfig.isCustom();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0003, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0051, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r3 = this;
            r0 = 55
            r1 = 0
        L3:
            r2 = 72
        L5:
            switch(r2) {
                case 72: goto L51;
                case 73: goto L18;
                case 74: goto L9;
                default: goto L8;
            }
        L8:
            goto L3
        L9:
            r2 = 52
            if (r1 == r2) goto L3
            r2 = 53
            if (r1 == r2) goto L12
            goto L51
        L12:
            switch(r0) {
                case 29: goto L1c;
                case 30: goto L3;
                case 31: goto L9;
                default: goto L15;
            }
        L15:
            r0 = 30
            goto L12
        L18:
            r2 = 57
            if (r1 > r2) goto L51
        L1c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "AdNetworkConfValue{mAppId='"
            r0.append(r1)
            java.lang.String r1 = r3.a
            r0.append(r1)
            r1 = 39
            r0.append(r1)
            java.lang.String r2 = ", mAppKey='"
            r0.append(r2)
            java.lang.String r2 = r3.b
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = ", mGMCustomConfig="
            r0.append(r1)
            com.bytedance.msdk.api.v2.ad.custom.bean.GMCustomInitConfig r1 = r3.f736c
            r0.append(r1)
            r1 = 125(0x7d, float:1.75E-43)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        L51:
            r1 = 16
            r2 = 73
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a.toString():java.lang.String");
    }
}
