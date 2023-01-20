package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.push.gg;
import com.xiaomi.push.jc;
import com.xiaomi.push.jl;
import com.xiaomi.push.jm;
import com.xiaomi.push.service.aj;
import java.util.Locale;

/* loaded from: classes3.dex */
public class cp {
    public final String a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final String f9167c;

    /* renamed from: d  reason: collision with root package name */
    public final String f9168d;

    /* renamed from: e  reason: collision with root package name */
    public final String f9169e;

    /* renamed from: f  reason: collision with root package name */
    public final String f9170f;

    /* renamed from: g  reason: collision with root package name */
    public final int f9171g;

    public cp(String str, String str2, String str3, String str4, String str5, String str6, int i2) {
        this.a = str;
        this.b = str2;
        this.f9167c = str3;
        this.f9168d = str4;
        this.f9169e = str5;
        this.f9170f = str6;
        this.f9171g = i2;
    }

    public static boolean a() {
        try {
            return jl.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && a();
    }

    private static boolean b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    private static String c(Context context) {
        if ("com.xiaomi.xmsf".equals(context)) {
            if (TextUtils.isEmpty(null)) {
                String a = jc.a("ro.miui.region");
                return TextUtils.isEmpty(a) ? jc.a("ro.product.locale.region") : a;
            }
            return null;
        }
        return jc.f();
    }

    public aj.b a(XMPushService xMPushService) {
        aj.b bVar = new aj.b(xMPushService);
        a(bVar, xMPushService, xMPushService.e(), "c");
        return bVar;
    }

    public aj.b a(aj.b bVar, Context context, cf cfVar, String str) {
        bVar.a = context.getPackageName();
        bVar.b = this.a;
        bVar.f9081i = this.f9167c;
        bVar.f9075c = this.b;
        bVar.f9080h = "5";
        bVar.f9076d = "XMPUSH-PASS";
        bVar.f9077e = false;
        jm.a aVar = new jm.a();
        aVar.a(HiAnalyticsConstant.BI_KEY_SDK_VER, 48).a("cpvn", "4_9_1").a("cpvc", 40091).a("country_code", b.a(context).b()).a("region", b.a(context).a()).a("miui_vn", jc.h()).a("miui_vc", Integer.valueOf(jc.b(context))).a("xmsf_vc", Integer.valueOf(gg.b(context, "com.xiaomi.xmsf"))).a("android_ver", Integer.valueOf(Build.VERSION.SDK_INT)).a("n_belong_to_app", Boolean.valueOf(z.a(context))).a("systemui_vc", Integer.valueOf(gg.a(context)));
        String c2 = c(context);
        if (!TextUtils.isEmpty(c2)) {
            aVar.a("latest_country_code", c2);
        }
        String j2 = jc.j();
        if (!TextUtils.isEmpty(j2)) {
            aVar.a("device_ch", j2);
        }
        String k2 = jc.k();
        if (!TextUtils.isEmpty(k2)) {
            aVar.a("device_mfr", k2);
        }
        bVar.f9078f = aVar.toString();
        String str2 = b(context) ? "1000271" : this.f9168d;
        jm.a aVar2 = new jm.a();
        aVar2.a("appid", str2).a("locale", Locale.getDefault().toString()).a("sync", 1);
        if (a(context)) {
            aVar2.a("ab", str);
        }
        bVar.f9079g = aVar2.toString();
        bVar.f9083k = cfVar;
        return bVar;
    }
}
