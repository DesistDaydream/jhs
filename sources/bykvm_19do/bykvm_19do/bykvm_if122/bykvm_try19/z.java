package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class z {
    private static volatile String a = "";

    static {
        try {
            if (TextUtils.isEmpty(a)) {
                a = c0.a("tt_device_info", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).a("oaid", "");
            }
        } catch (Throwable unused) {
        }
    }

    public static String a() {
        try {
            if (TextUtils.isEmpty(a)) {
                a = p.d();
                a(a);
            }
        } catch (Throwable unused) {
        }
        return a == null ? "" : a;
    }

    private static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c0.a("tt_device_info", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).b("oaid", str);
    }
}
