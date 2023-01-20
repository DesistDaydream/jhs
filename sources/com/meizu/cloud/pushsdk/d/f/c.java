package com.meizu.cloud.pushsdk.d.f;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* loaded from: classes2.dex */
public class c {
    private static int a;

    private static String a() {
        return Thread.currentThread().getName();
    }

    private static String a(String str) {
        return "PushTracker->" + str;
    }

    private static String a(String str, Object... objArr) {
        return a() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + String.format(str, objArr);
    }

    public static void a(b bVar) {
        a = bVar.a();
    }

    public static void a(String str, String str2, Object... objArr) {
        if (a >= b.ERROR.a()) {
            e.p.a.a.a.f(a(str), a(str2, objArr));
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        if (a >= b.DEBUG.a()) {
            e.p.a.a.a.e(a(str), a(str2, objArr));
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        if (a >= b.VERBOSE.a()) {
            e.p.a.a.a.c(a(str), a(str2, objArr));
        }
    }
}
