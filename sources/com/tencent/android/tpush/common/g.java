package com.tencent.android.tpush.common;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.android.tpush.logging.TLogger;

/* loaded from: classes3.dex */
public class g {
    private static String a = "";
    private static String b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f6090c = "";

    /* renamed from: d  reason: collision with root package name */
    private static String f6091d = "";

    /* renamed from: e  reason: collision with root package name */
    private static String f6092e = "";

    /* renamed from: f  reason: collision with root package name */
    private static String f6093f = "";

    public static String a() {
        try {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (lowerCase.contains("huawei")) {
                return d();
            }
            if (lowerCase.contains("xiaomi")) {
                return h();
            }
            if (lowerCase.contains("meizu")) {
                return g();
            }
            if (!lowerCase.contains("oppo") && !lowerCase.contains("realme")) {
                if (lowerCase.contains("vivo")) {
                    return e();
                }
                return lowerCase.contains("oneplus") ? i() : "";
            }
            return f();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean b() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public static String c() {
        if (b()) {
            try {
                return ((Integer) Class.forName("ohos.system.version.SystemVersion").getMethod("getMajorVerion", new Class[0]).invoke(null, new Object[0])).toString();
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    private static String d() {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String a2 = a("ro.build.version.emui");
        a = a2;
        return a2;
    }

    private static String e() {
        if (!TextUtils.isEmpty(f6090c)) {
            return f6090c;
        }
        String a2 = a("ro.vivo.os.build.display.id");
        f6090c = a2;
        return a2;
    }

    private static String f() {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        String a2 = a("ro.build.version.opporom");
        b = a2;
        return a2;
    }

    private static String g() {
        if (!TextUtils.isEmpty(f6093f)) {
            return f6093f;
        }
        String a2 = a("ro.build.display.id");
        f6093f = a2;
        return a2;
    }

    private static String h() {
        if (!TextUtils.isEmpty(f6092e)) {
            return f6092e;
        }
        String a2 = a("ro.miui.ui.version.name");
        f6092e = a2;
        return a2;
    }

    private static String i() {
        if (!TextUtils.isEmpty(f6091d)) {
            return f6091d;
        }
        String a2 = a("ro.rom.version");
        f6091d = a2;
        return a2;
    }

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            TLogger.i("RomVersionHelper", "get " + str + " version is:" + str2);
            return str2;
        } catch (Throwable unused) {
            return "";
        }
    }
}
