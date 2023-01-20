package com.tencent.android.tpush.service.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: classes3.dex */
public class e {
    private static SharedPreferences a;

    public static synchronized SharedPreferences a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (e.class) {
            if (a == null) {
                a = context.getSharedPreferences(".tpns.vip.service.xml", 0);
            }
            sharedPreferences = a;
        }
        return sharedPreferences;
    }

    public static void b(Context context, String str, String str2) {
        SharedPreferences.Editor edit = a(context).edit();
        edit.putString(str, str2);
        a(edit);
    }

    public static String a(Context context, String str, String str2) {
        return !a(context).contains(str) ? str2 : a(context).getString(str, str2);
    }

    @SuppressLint({"NewApi"})
    private static void a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            editor.commit();
        }
    }
}
