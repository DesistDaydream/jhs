package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* loaded from: classes.dex */
public class c {
    private static boolean a;

    public static String a() {
        return a("ro.build.version.emui");
    }

    private static String a(String str) {
        String str2;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        String str3 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
        } catch (Throwable unused) {
            str2 = null;
        }
        try {
            str3 = bufferedReader.readLine();
            bufferedReader.close();
            f.a(bufferedReader);
            return str3;
        } catch (Throwable unused2) {
            str2 = str3;
            bufferedReader2 = bufferedReader;
            f.a(bufferedReader2);
            return str2;
        }
    }

    public static boolean b() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = a();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return c();
        }
        return true;
    }

    public static boolean c() {
        String str;
        try {
            str = Build.BRAND;
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
            String str2 = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str2)) {
                if (str2.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean d() {
        if (!a) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b.a = true;
                    a = true;
                    return true;
                }
            } catch (Exception unused) {
            }
            a = true;
        }
        return bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b.a;
    }
}
