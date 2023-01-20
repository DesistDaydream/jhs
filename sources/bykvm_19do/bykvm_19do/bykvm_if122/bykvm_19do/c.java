package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.k0;

/* loaded from: classes.dex */
public class c {
    private static String a;
    private static String b;

    public static String a() {
        return k0.a("https://" + a.f().d());
    }

    public static String b() {
        return k0.a(c() + "/api/ad/union/mediation/exchange/");
    }

    private static String c() {
        String e2 = e();
        return !TextUtils.isEmpty(e2) ? e2 : "https://gromore.pangolin-sdk-toutiao.com";
    }

    public static String d() {
        return k0.a(c() + "/api/ad/union/mediation/stats/");
    }

    private static String e() {
        String d2 = d.R().d("server_dist_host");
        if (TextUtils.isEmpty(d2)) {
            return null;
        }
        if (!TextUtils.equals(d2, a) || TextUtils.isEmpty(b)) {
            a = d2;
            b = null;
            if (!TextUtils.isEmpty(d2)) {
                b = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.a(a, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
            }
            if (TextUtils.isEmpty(b)) {
                return null;
            }
            String str = "https://" + b;
            b = str;
            return str;
        }
        return b;
    }

    public static String f() {
        return k0.a(c() + "/api/ad/union/mediation/reward_video/reward/");
    }

    public static String g() {
        return k0.a(c() + "/api/ad/union/mediation/config/");
    }
}
