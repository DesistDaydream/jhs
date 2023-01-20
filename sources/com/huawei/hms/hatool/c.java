package com.huawei.hms.hatool;

import java.util.Map;

/* loaded from: classes2.dex */
public abstract class c {
    public static void a(String str, String str2, long j2) {
        k h2 = h(str, str2);
        if (h2 != null) {
            h2.a(j2);
        }
    }

    public static boolean a(String str, String str2) {
        k h2 = h(str, str2);
        if (h2 != null) {
            return h2.a();
        }
        return true;
    }

    public static int b(String str, String str2) {
        k h2 = h(str, str2);
        if (h2 != null) {
            return h2.d();
        }
        return 7;
    }

    public static boolean c(String str, String str2) {
        k h2 = h(str, str2);
        if (h2 != null) {
            return h2.g();
        }
        return true;
    }

    public static String d(String str, String str2) {
        k h2 = h(str, str2);
        return h2 != null ? h2.f() : "";
    }

    public static boolean e(String str, String str2) {
        k h2 = h(str, str2);
        if (h2 != null) {
            return h2.i();
        }
        return false;
    }

    public static String f(String str, String str2) {
        k h2 = h(str, str2);
        return h2 != null ? h2.h() : "";
    }

    public static String g(String str, String str2) {
        k h2 = h(str, str2);
        return h2 != null ? h2.n() : "";
    }

    public static k h(String str, String str2) {
        m a = i.c().a(str);
        if (a != null) {
            if ("alltype".equals(str2)) {
                k a2 = a.a("oper");
                return a2 == null ? a.a("maint") : a2;
            }
            return a.a(str2);
        }
        return null;
    }

    public static Map<String, String> i(String str, String str2) {
        k h2 = h(str, str2);
        if (h2 != null) {
            return h2.k();
        }
        return null;
    }

    public static long j(String str, String str2) {
        k h2 = h(str, str2);
        if (h2 != null) {
            return h2.l();
        }
        return 0L;
    }

    public static int k(String str, String str2) {
        k h2 = h(str, str2);
        if (h2 != null) {
            return h2.b();
        }
        return 10;
    }

    public static String l(String str, String str2) {
        k h2 = h(str, str2);
        return h2 != null ? h2.o() : "";
    }

    public static String m(String str, String str2) {
        k h2 = h(str, str2);
        return h2 != null ? h2.q() : "";
    }

    public static String n(String str, String str2) {
        k h2 = h(str, str2);
        return h2 != null ? h2.m() : "";
    }

    public static String o(String str, String str2) {
        k h2 = h(str, str2);
        return h2 != null ? h2.p() : "";
    }
}
