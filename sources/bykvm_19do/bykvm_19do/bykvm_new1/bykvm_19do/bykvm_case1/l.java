package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* loaded from: classes.dex */
public class l {
    private static final CharSequence a = "amigo";
    private static final CharSequence b = "funtouch";

    public static String a() {
        return a("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    private static String a(String str) {
        BufferedReader bufferedReader;
        String str2 = "";
        try {
            Runtime runtime = Runtime.getRuntime();
            Process exec = runtime.exec("getprop " + str);
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
            try {
                str2 = bufferedReader.readLine();
                exec.destroy();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        f.a(bufferedReader);
        return str2;
    }

    public static String b() {
        return Build.DISPLAY + "_" + a("ro.gn.sv.version");
    }

    public static String c() {
        if (l()) {
            return "coloros_" + a("ro.build.version.opporom") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static String d() {
        String a2 = c.a();
        if (a2 == null || !a2.toLowerCase(Locale.getDefault()).contains("emotionui")) {
            return "";
        }
        return a2 + "_" + Build.DISPLAY;
    }

    public static String e() {
        if (m()) {
            return "eui_" + a("ro.letv.release.version") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static String f() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str;
    }

    public static String g() {
        return a("ro.vivo.os.build.display.id") + "_" + a("ro.vivo.product.version");
    }

    public static String h() {
        if (c.d()) {
            return "miui_" + a("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
        }
        return "";
    }

    public static String i() {
        if (c.d()) {
            return h();
        }
        if (c.b()) {
            return f();
        }
        if (l()) {
            return c();
        }
        String d2 = d();
        if (TextUtils.isEmpty(d2)) {
            if (n()) {
                return g();
            }
            if (k()) {
                return b();
            }
            if (j()) {
                return a();
            }
            String e2 = e();
            return TextUtils.isEmpty(e2) ? Build.DISPLAY : e2;
        }
        return d2;
    }

    public static boolean j() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase(Locale.getDefault());
            if (lowerCase.contains("360") || lowerCase.contains("qiku")) {
                return true;
            }
        }
        return false;
    }

    public static boolean k() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase(Locale.getDefault()).contains(a);
    }

    public static boolean l() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    public static boolean m() {
        return !TextUtils.isEmpty(a("ro.letv.release.version"));
    }

    public static boolean n() {
        String a2 = a("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(a2) && a2.toLowerCase(Locale.getDefault()).contains(b);
    }
}
