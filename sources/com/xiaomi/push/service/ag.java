package com.xiaomi.push.service;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class ag {
    private static long a = 0;
    private static String b = "";

    public static String a() {
        if (TextUtils.isEmpty(b)) {
            b = com.xiaomi.push.ar.a(4);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(b);
        long j2 = a;
        a = 1 + j2;
        sb.append(j2);
        return sb.toString();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 32) {
            return str;
        }
        try {
            return "BlockId_" + str.substring(8);
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.d("Exception occurred when filtering registration packet id for log. " + e2);
            return "UnexpectedId";
        }
    }

    public static String b() {
        return com.xiaomi.push.ar.a(32);
    }
}
