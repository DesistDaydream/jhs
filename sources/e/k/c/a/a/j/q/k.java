package e.k.c.a.a.j.q;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: classes2.dex */
public class k {
    private static final String a = "aegis";
    private static SharedPreferences b;

    public static int a(String str, int i2, Context context) {
        return f(context).getInt(str, i2);
    }

    public static long b(String str, long j2, Context context) {
        return f(context).getLong(str, j2);
    }

    public static String c(String str, String str2, Context context) {
        return f(context).getString(str, str2);
    }

    public static void d(Context context) {
        f(context).edit().clear().apply();
    }

    public static void e(String str, Context context) {
        f(context).edit().remove(str).apply();
    }

    public static synchronized SharedPreferences f(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (k.class) {
            if (b == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    b = context.createDeviceProtectedStorageContext().getSharedPreferences(a, 0);
                } else {
                    b = context.getApplicationContext().getSharedPreferences(a, 0);
                }
            }
            sharedPreferences = b;
        }
        return sharedPreferences;
    }

    public static void g(String str, int i2, Context context) {
        f(context).edit().putInt(str, i2).apply();
    }

    public static void h(String str, long j2, Context context) {
        f(context).edit().putLong(str, j2).apply();
    }

    public static void i(String str, String str2, Context context) {
        f(context).edit().putString(str, str2).apply();
    }
}
