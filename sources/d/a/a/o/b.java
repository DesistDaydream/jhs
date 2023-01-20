package d.a.a.o;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class b {
    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b() {
        return d() || c();
    }

    private static boolean c() {
        String a = a("ro.product.cpu.abi");
        return (a == null || TextUtils.isEmpty(a) || !a.contains("x86")) ? false : true;
    }

    private static boolean d() {
        return "1".equals(a("ro.kernel.qemu"));
    }
}
