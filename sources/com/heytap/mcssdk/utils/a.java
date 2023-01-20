package com.heytap.mcssdk.utils;

/* loaded from: classes2.dex */
public class a {
    private static final String a = "file";
    private static final String b = "ro.crypto.type";

    private static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean a() {
        return "file".equals(a(b));
    }
}
