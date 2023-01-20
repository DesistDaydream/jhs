package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes.dex */
public class i {
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
        if (r2 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a() {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L28
            java.lang.String r2 = "getprop ro.build.version.emui"
            java.lang.Process r1 = r1.exec(r2)     // Catch: java.lang.Throwable -> L28
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L28
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L28
            java.io.InputStream r1 = r1.getInputStream()     // Catch: java.lang.Throwable -> L28
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L28
            r1 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3, r1)     // Catch: java.lang.Throwable -> L28
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L26
            r2.close()     // Catch: java.lang.Throwable -> L26
        L22:
            r2.close()     // Catch: java.io.IOException -> L30
            goto L30
        L26:
            r1 = move-exception
            goto L2a
        L28:
            r1 = move-exception
            r2 = r0
        L2a:
            bykvm_19do.bykvm_19do.bykvm_19do.l0.a(r1)     // Catch: java.lang.Throwable -> L31
            if (r2 == 0) goto L30
            goto L22
        L30:
            return r0
        L31:
            r0 = move-exception
            if (r2 == 0) goto L37
            r2.close()     // Catch: java.io.IOException -> L37
        L37:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.i.a():java.lang.String");
    }

    public static boolean a(Context context) {
        return l().toUpperCase().contains("HUAWEI");
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = a();
        }
        return (!TextUtils.isEmpty(str) && (str.toLowerCase().contains("emotionui") || str.toLowerCase().contains("magicui"))) || b() || c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
        if (r1 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String b(java.lang.String r4) {
        /*
            java.lang.String r0 = ""
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L38
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38
            r2.<init>()     // Catch: java.lang.Throwable -> L38
            java.lang.String r3 = "getprop "
            r2.append(r3)     // Catch: java.lang.Throwable -> L38
            r2.append(r4)     // Catch: java.lang.Throwable -> L38
            java.lang.String r4 = r2.toString()     // Catch: java.lang.Throwable -> L38
            java.lang.Process r4 = r1.exec(r4)     // Catch: java.lang.Throwable -> L38
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L38
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L38
            java.io.InputStream r3 = r4.getInputStream()     // Catch: java.lang.Throwable -> L38
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L38
            r3 = 1024(0x400, float:1.435E-42)
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L38
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Throwable -> L36
            r4.destroy()     // Catch: java.lang.Throwable -> L36
        L32:
            r1.close()     // Catch: java.io.IOException -> L3c
            goto L3c
        L36:
            goto L39
        L38:
            r1 = 0
        L39:
            if (r1 == 0) goto L3c
            goto L32
        L3c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.i.b(java.lang.String):java.lang.String");
    }

    public static boolean b() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("huawei")) {
            String str2 = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str2) || !str2.toLowerCase().startsWith("huawei")) {
                return false;
            }
        }
        return true;
    }

    public static boolean c() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("honor")) {
            String str2 = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str2) || !str2.toLowerCase().startsWith("honor")) {
                return false;
            }
        }
        return true;
    }

    public static boolean d() {
        return Class.forName("miui.os.Build").getName().length() > 0;
    }

    public static boolean e() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo");
    }

    public static boolean f() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        return str.toLowerCase(Locale.ENGLISH).contains("meizu");
    }

    public static boolean g() {
        return "OnePlus".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean h() {
        return "samsung".equalsIgnoreCase(Build.BRAND) || "samsung".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean i() {
        String str = Build.FINGERPRINT;
        if (TextUtils.isEmpty(str)) {
            String b = b("ro.build.version.incremental");
            return !TextUtils.isEmpty(b) && b.contains("VIBEUI_V2");
        }
        return str.contains("VIBEUI_V2");
    }

    public static boolean j() {
        return l().toUpperCase().contains("NUBIA");
    }

    public static boolean k() {
        return l().toUpperCase().contains("ASUS");
    }

    private static String l() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }
}
