package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class ac {
    private static final String a = "ro.build.version.emui";
    private static final String b = "hw_sc.build.platform.version";

    public static z a(Context context) {
        String str = Build.BRAND;
        al.a("Device", "Brand", str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase("huawei") && !str.equalsIgnoreCase("honor") && !str.equalsIgnoreCase("华为")) {
            if (!str.equalsIgnoreCase("xiaomi") && !str.equalsIgnoreCase("redmi") && !str.equalsIgnoreCase("meitu") && !str.equalsIgnoreCase("小米") && !str.equalsIgnoreCase("blackshark")) {
                if (str.equalsIgnoreCase("vivo")) {
                    return new aj();
                }
                if (!str.equalsIgnoreCase("oppo") && !str.equalsIgnoreCase("oneplus") && !str.equalsIgnoreCase("realme")) {
                    if (!str.equalsIgnoreCase("lenovo") && !str.equalsIgnoreCase("zuk")) {
                        if (str.equalsIgnoreCase("nubia")) {
                            return new ag();
                        }
                        if (Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG")) {
                            return new ai();
                        }
                        if (b()) {
                            return new ab();
                        }
                        if (a()) {
                            return new ad();
                        }
                        if (str.equalsIgnoreCase("meizu") || str.equalsIgnoreCase("mblu")) {
                            return new af();
                        }
                        return null;
                    }
                    return new ae();
                }
                return new ah();
            }
            return new ak();
        }
        return new ad();
    }

    private static boolean b() {
        return !TextUtils.isEmpty(a("ro.coolos.version"));
    }

    private static boolean a() {
        return (TextUtils.isEmpty(a(a)) && TextUtils.isEmpty(a(b))) ? false : true;
    }

    private static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }
}
