package com.heytap.mcssdk.utils;

import android.util.Log;

/* loaded from: classes2.dex */
public class d {
    public static final String a = "mcssdk---";
    private static String b = "MCS";

    /* renamed from: c  reason: collision with root package name */
    private static boolean f3349c = false;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f3350d = false;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f3351e = true;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f3352f = true;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f3353g = true;

    /* renamed from: h  reason: collision with root package name */
    private static String f3354h = "-->";

    /* renamed from: i  reason: collision with root package name */
    private static boolean f3355i = true;

    public static String a() {
        return b;
    }

    public static void a(Exception exc) {
        if (!f3353g || exc == null) {
            return;
        }
        Log.e(a, exc.getMessage());
    }

    public static void a(String str) {
        if (f3349c && f3355i) {
            Log.v(a, b + f3354h + str);
        }
    }

    public static void a(String str, String str2) {
        if (f3349c && f3355i) {
            Log.v(str, b + f3354h + str2);
        }
    }

    public static void a(String str, Throwable th) {
        if (f3353g) {
            Log.e(str, th.toString());
        }
    }

    public static void a(boolean z) {
        f3349c = z;
    }

    public static void b(String str) {
        if (f3351e && f3355i) {
            Log.d(a, b + f3354h + str);
        }
    }

    public static void b(String str, String str2) {
        if (f3351e && f3355i) {
            Log.d(str, b + f3354h + str2);
        }
    }

    public static void b(boolean z) {
        f3351e = z;
    }

    public static boolean b() {
        return f3349c;
    }

    public static void c(String str) {
        if (f3350d && f3355i) {
            Log.i(a, b + f3354h + str);
        }
    }

    public static void c(String str, String str2) {
        if (f3350d && f3355i) {
            Log.i(str, b + f3354h + str2);
        }
    }

    public static void c(boolean z) {
        f3350d = z;
    }

    public static boolean c() {
        return f3351e;
    }

    public static void d(String str) {
        if (f3352f && f3355i) {
            Log.w(a, b + f3354h + str);
        }
    }

    public static void d(String str, String str2) {
        if (f3352f && f3355i) {
            Log.w(str, b + f3354h + str2);
        }
    }

    public static void d(boolean z) {
        f3352f = z;
    }

    public static boolean d() {
        return f3350d;
    }

    public static void e(String str) {
        if (f3353g && f3355i) {
            Log.e(a, b + f3354h + str);
        }
    }

    public static void e(String str, String str2) {
        if (f3353g && f3355i) {
            Log.e(str, b + f3354h + str2);
        }
    }

    public static void e(boolean z) {
        f3353g = z;
    }

    public static boolean e() {
        return f3352f;
    }

    public static void f(String str) {
        b = str;
    }

    public static void f(boolean z) {
        f3355i = z;
        boolean z2 = z;
        f3349c = z2;
        f3351e = z2;
        f3350d = z2;
        f3352f = z2;
        f3353g = z2;
    }

    public static boolean f() {
        return f3353g;
    }

    public static void g(String str) {
        f3354h = str;
    }

    public static boolean g() {
        return f3355i;
    }

    public static String h() {
        return f3354h;
    }
}
