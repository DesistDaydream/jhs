package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public class jc {
    private static volatile int a = 0;
    private static int b = -1;

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, jg> f9013c;

    public static String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + ExpandableTextView.N + a(intent.getExtras());
    }

    public static String a(Bundle bundle) {
        String a2;
        StringBuilder sb = new StringBuilder("Bundle[");
        if (bundle == null) {
            sb.append("null");
        } else {
            boolean z = true;
            for (String str : bundle.keySet()) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append('=');
                Object obj = bundle.get(str);
                if (obj instanceof int[]) {
                    a2 = Arrays.toString((int[]) obj);
                } else if (obj instanceof byte[]) {
                    a2 = Arrays.toString((byte[]) obj);
                } else if (obj instanceof boolean[]) {
                    a2 = Arrays.toString((boolean[]) obj);
                } else if (obj instanceof short[]) {
                    a2 = Arrays.toString((short[]) obj);
                } else if (obj instanceof long[]) {
                    a2 = Arrays.toString((long[]) obj);
                } else if (obj instanceof float[]) {
                    a2 = Arrays.toString((float[]) obj);
                } else if (obj instanceof double[]) {
                    a2 = Arrays.toString((double[]) obj);
                } else if (obj instanceof String[]) {
                    a2 = Arrays.toString((String[]) obj);
                } else if (obj instanceof CharSequence[]) {
                    a2 = Arrays.toString((CharSequence[]) obj);
                } else if (obj instanceof Parcelable[]) {
                    a2 = Arrays.toString((Parcelable[]) obj);
                } else if (obj instanceof Bundle) {
                    a2 = a((Bundle) obj);
                } else {
                    sb.append(obj);
                    z = false;
                }
                sb.append(a2);
                z = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String a(String str) {
        try {
            try {
                return (String) am.a("android.os.SystemProperties", "get", str, "");
            } catch (Exception e2) {
                com.xiaomi.a.a.a.c.d("fail to get property. " + e2);
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean a() {
        return c() == 1;
    }

    public static boolean a(Context context) {
        return context != null && b(context.getPackageName());
    }

    public static int b(Context context) {
        String a2 = a("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(a2) || !TextUtils.isDigitsOnly(a2)) {
            return 0;
        }
        return Integer.parseInt(a2);
    }

    public static boolean b() {
        return c() == 2;
    }

    public static boolean b(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int c() {
        /*
            int r0 = com.xiaomi.push.jc.a
            if (r0 != 0) goto L47
            r0 = 0
            java.lang.String r1 = "ro.miui.ui.version.code"
            java.lang.String r1 = a(r1)     // Catch: java.lang.Throwable -> L29
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L29
            r2 = 1
            if (r1 == 0) goto L21
            java.lang.String r1 = "ro.miui.ui.version.name"
            java.lang.String r1 = a(r1)     // Catch: java.lang.Throwable -> L29
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L29
            if (r1 != 0) goto L1f
            goto L21
        L1f:
            r1 = 0
            goto L22
        L21:
            r1 = 1
        L22:
            if (r1 == 0) goto L25
            goto L26
        L25:
            r2 = 2
        L26:
            com.xiaomi.push.jc.a = r2     // Catch: java.lang.Throwable -> L29
            goto L31
        L29:
            r1 = move-exception
            java.lang.String r2 = "get isMIUI failed"
            com.xiaomi.a.a.a.c.a(r2, r1)
            com.xiaomi.push.jc.a = r0
        L31:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "isMIUI's value is: "
            r0.append(r1)
            int r1 = com.xiaomi.push.jc.a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.xiaomi.a.a.a.c.b(r0)
        L47:
            int r0 = com.xiaomi.push.jc.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.jc.c():int");
    }

    public static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static jg c(String str) {
        jg d2 = d(str);
        return d2 == null ? jg.Global : d2;
    }

    private static jg d(String str) {
        l();
        return f9013c.get(str.toUpperCase());
    }

    public static String d() {
        int b2 = jl.b();
        return (!a() || b2 <= 0) ? "" : b2 < 2 ? "alpha" : b2 < 3 ? "development" : "stable";
    }

    private static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        return split.length > 0 ? split[0] : str;
    }

    public static boolean e() {
        if (b < 0) {
            b = !i() ? 1 : 0;
        }
        return b > 0;
    }

    public static String f() {
        String a2 = jk.a("ro.miui.region", "");
        if (TextUtils.isEmpty(a2)) {
            a2 = jk.a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = jk.a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = jk.a("ro.vendor.oplus.regionmark", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = jk.a("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = jk.a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = e(jk.a("ro.product.country.region", ""));
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = jk.a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = jk.a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = jk.a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = jk.a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(a2)) {
            com.xiaomi.a.a.a.c.a("get region from system, region = " + a2);
        }
        if (TextUtils.isEmpty(a2)) {
            String country = Locale.getDefault().getCountry();
            com.xiaomi.a.a.a.c.a("locale.default.country = " + country);
            return country;
        }
        return a2;
    }

    public static boolean g() {
        return !jg.China.name().equalsIgnoreCase(c(f()).name());
    }

    public static String h() {
        return a("ro.miui.ui.version.name");
    }

    public static boolean i() {
        String str = "";
        try {
            str = jk.a("ro.miui.ui.version.code", "");
        } catch (Exception unused) {
        }
        return !TextUtils.isEmpty(str);
    }

    public static String j() {
        return a("ro.build.characteristics");
    }

    public static String k() {
        return a("ro.product.manufacturer");
    }

    private static void l() {
        if (f9013c != null) {
            return;
        }
        HashMap hashMap = new HashMap();
        f9013c = hashMap;
        hashMap.put("CN", jg.China);
        Map<String, jg> map = f9013c;
        jg jgVar = jg.Europe;
        map.put("FI", jgVar);
        f9013c.put("SE", jgVar);
        f9013c.put("NO", jgVar);
        f9013c.put("FO", jgVar);
        f9013c.put("EE", jgVar);
        f9013c.put("LV", jgVar);
        f9013c.put("LT", jgVar);
        f9013c.put("BY", jgVar);
        f9013c.put("MD", jgVar);
        f9013c.put("UA", jgVar);
        f9013c.put("PL", jgVar);
        f9013c.put("CZ", jgVar);
        f9013c.put("SK", jgVar);
        f9013c.put("HU", jgVar);
        f9013c.put("DE", jgVar);
        f9013c.put("AT", jgVar);
        f9013c.put("CH", jgVar);
        f9013c.put("LI", jgVar);
        f9013c.put("GB", jgVar);
        f9013c.put("IE", jgVar);
        f9013c.put("NL", jgVar);
        f9013c.put("BE", jgVar);
        f9013c.put("LU", jgVar);
        f9013c.put("FR", jgVar);
        f9013c.put("RO", jgVar);
        f9013c.put("BG", jgVar);
        f9013c.put("RS", jgVar);
        f9013c.put("MK", jgVar);
        f9013c.put("AL", jgVar);
        f9013c.put("GR", jgVar);
        f9013c.put("SI", jgVar);
        f9013c.put("HR", jgVar);
        f9013c.put("IT", jgVar);
        f9013c.put("SM", jgVar);
        f9013c.put("MT", jgVar);
        f9013c.put("ES", jgVar);
        f9013c.put("PT", jgVar);
        f9013c.put("AD", jgVar);
        f9013c.put("CY", jgVar);
        f9013c.put("DK", jgVar);
        f9013c.put("IS", jgVar);
        f9013c.put("UK", jgVar);
        f9013c.put("EL", jgVar);
        f9013c.put("RU", jg.Russia);
        f9013c.put("IN", jg.India);
    }
}
