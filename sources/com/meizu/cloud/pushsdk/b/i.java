package com.meizu.cloud.pushsdk.b;

/* loaded from: classes2.dex */
public class i {
    public static String a(String str) {
        com.meizu.cloud.pushsdk.b.b.d a = com.meizu.cloud.pushsdk.b.b.a.a("android.os.SystemProperties").a("get", String.class).a(str);
        if (a.a) {
            return (String) a.b;
        }
        return null;
    }
}
