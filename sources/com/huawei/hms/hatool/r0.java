package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class r0 {
    public static void a(String str, String str2) {
        b0 b0Var;
        String str3;
        String replace = "{url}/getPublicKey?keytype=2".replace("{url}", c.f(str, str2));
        String f2 = b.f();
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", f2);
        try {
            b0Var = a0.a(replace, new byte[0], hashMap);
        } catch (Exception e2) {
            y.e("GetPublicKey", "get pubKey response Exception :" + e2.getMessage());
            b0Var = null;
        }
        if (b0Var == null) {
            str3 = "get pubKey response is null";
        } else if (b0Var.b() == 200) {
            if (TextUtils.isEmpty(b0Var.a())) {
                return;
            }
            c(b0Var.a(), str2);
            return;
        } else {
            str3 = "get pubKey fail HttpCode :" + b0Var.b();
        }
        y.e("GetPublicKey", str3);
    }

    public static boolean a() {
        String a = b.a();
        if (TextUtils.isEmpty(a)) {
            a = g0.a(b.i(), "Privacy_MY", "public_key_time_interval", "");
            b.f(a);
        }
        String m2 = b.m();
        if (TextUtils.isEmpty(m2)) {
            m2 = g0.a(b.i(), "Privacy_MY", "public_key_time_last", "");
            b.c(m2);
        }
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(m2)) {
            return true;
        }
        try {
            return System.currentTimeMillis() - Long.parseLong(m2) > ((long) Integer.parseInt(a));
        } catch (NumberFormatException e2) {
            y.e("GetPublicKey", "checkCachePubKey NumberFormatException :" + e2.getMessage());
            return true;
        }
    }

    public static String b(String str, String str2) {
        String o;
        String c2 = b.c();
        if (TextUtils.isEmpty(c2)) {
            c2 = g0.a(b.i(), "Privacy_MY", "public_key_version", "");
            b.g(c2);
        }
        if ("maint".equals(str2)) {
            o = b.n();
            if (TextUtils.isEmpty(o)) {
                o = e.k.c.a.a.h.e.a.b.d("HiAnalytics_Sdk_Public_Sp_Key", g0.a(b.i(), "Privacy_MY", "public_key_maint", ""));
                b.d(o);
            }
        } else {
            o = b.o();
            if (TextUtils.isEmpty(o)) {
                o = e.k.c.a.a.h.e.a.b.d("HiAnalytics_Sdk_Public_Sp_Key", g0.a(b.i(), "Privacy_MY", "public_key_oper", ""));
                b.e(o);
            }
        }
        if (TextUtils.isEmpty(o) || TextUtils.isEmpty(c2) || a()) {
            o0.a().a(new m0(str, str2));
            return null;
        }
        return o;
    }

    public static void c(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("publicKey");
            String optString2 = jSONObject.optString("publicKeyOM");
            String optString3 = jSONObject.optString("pubkey_version");
            String str3 = System.currentTimeMillis() + "";
            String optString4 = jSONObject.optString("timeInterval");
            g0.b(b.i(), "Privacy_MY", "public_key_oper", e.k.c.a.a.h.e.a.b.g("HiAnalytics_Sdk_Public_Sp_Key", optString));
            g0.b(b.i(), "Privacy_MY", "public_key_maint", e.k.c.a.a.h.e.a.b.g("HiAnalytics_Sdk_Public_Sp_Key", optString2));
            g0.b(b.i(), "Privacy_MY", "public_key_time_interval", optString4);
            g0.b(b.i(), "Privacy_MY", "public_key_version", optString3);
            g0.b(b.i(), "Privacy_MY", "public_key_time_last", str3);
            b.e(optString);
            b.d(optString2);
            b.g(optString3);
            b.c(str3);
            b.f(optString4);
        } catch (JSONException e2) {
            y.e("GetPublicKey", "get pubKey parse json JSONException :" + e2.getMessage());
        }
    }
}
