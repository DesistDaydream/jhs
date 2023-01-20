package com.tencent.bugly.proguard;

import android.util.Log;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class y {
    public static String a = "CrashReport";
    public static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static String f6814c = "CrashReportInfo";

    private static boolean a(int i2, String str, Object... objArr) {
        if (b) {
            if (str == null) {
                str = "null";
            } else if (objArr != null && objArr.length != 0) {
                str = String.format(Locale.US, str, objArr);
            }
            if (i2 == 0) {
                Log.i(a, str);
                return true;
            } else if (i2 == 1) {
                Log.d(a, str);
                return true;
            } else if (i2 == 2) {
                Log.w(a, str);
                return true;
            } else if (i2 == 3) {
                Log.e(a, str);
                return true;
            } else if (i2 != 5) {
                return false;
            } else {
                Log.i(f6814c, str);
                return true;
            }
        }
        return false;
    }

    public static boolean b(String str, Object... objArr) {
        return a(5, str, objArr);
    }

    public static boolean c(String str, Object... objArr) {
        return a(1, str, objArr);
    }

    public static boolean d(String str, Object... objArr) {
        return a(2, str, objArr);
    }

    public static boolean e(String str, Object... objArr) {
        return a(3, str, objArr);
    }

    public static boolean b(Class cls, String str, Object... objArr) {
        return a(1, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean b(Throwable th) {
        if (b) {
            return a(3, ab.a(th), new Object[0]);
        }
        return false;
    }

    public static boolean a(String str, Object... objArr) {
        return a(0, str, objArr);
    }

    public static boolean a(Class cls, String str, Object... objArr) {
        return a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    public static boolean a(Throwable th) {
        if (b) {
            return a(2, ab.a(th), new Object[0]);
        }
        return false;
    }
}
