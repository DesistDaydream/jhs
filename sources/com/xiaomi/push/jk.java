package com.xiaomi.push;

/* loaded from: classes3.dex */
public class jk {
    public static String a(String str, String str2) {
        try {
            return (String) jl.a(null, "android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("SystemProperties.get: " + e2);
            return str2;
        }
    }
}
