package com.tencent.android.tpush.stat.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;

/* loaded from: classes3.dex */
public class d {
    private static SharedPreferences a;

    public static synchronized SharedPreferences a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (d.class) {
            try {
                try {
                    if (Build.VERSION.SDK_INT >= 11) {
                        a = context.getSharedPreferences(".tpush_mta", 4);
                    } else {
                        a = context.getSharedPreferences(".tpush_mta", 0);
                    }
                    if (a == null) {
                        a = PreferenceManager.getDefaultSharedPreferences(context);
                    }
                    sharedPreferences = a;
                } catch (Throwable unused) {
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                    a = defaultSharedPreferences;
                    return defaultSharedPreferences;
                }
            } catch (Throwable unused2) {
                return null;
            }
        }
        return sharedPreferences;
    }

    public static void b(Context context, String str, long j2) {
        String a2 = b.a(context, "tpush_" + str);
        SharedPreferences.Editor edit = a(context).edit();
        edit.putLong(a2, j2);
        edit.commit();
    }

    public static void b(Context context, String str, int i2) {
        String a2 = b.a(context, "tpush_" + str);
        SharedPreferences.Editor edit = a(context).edit();
        edit.putInt(a2, i2);
        edit.commit();
    }

    public static long a(Context context, String str, long j2) {
        return a(context).getLong(b.a(context, "tpush_" + str), j2);
    }

    public static void b(Context context, String str, String str2) {
        String a2 = b.a(context, "tpush_" + str);
        SharedPreferences.Editor edit = a(context).edit();
        edit.putString(a2, str2);
        edit.commit();
    }

    public static int a(Context context, String str, int i2) {
        return a(context).getInt(b.a(context, "tpush_" + str), i2);
    }

    public static String a(Context context, String str, String str2) {
        return a(context).getString(b.a(context, "tpush_" + str), str2);
    }
}
