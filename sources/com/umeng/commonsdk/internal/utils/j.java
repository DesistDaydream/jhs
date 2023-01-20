package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class j {
    private static final String a = "um_pri";
    private static final String b = "um_common_strength";

    /* renamed from: c  reason: collision with root package name */
    private static final String f7430c = "um_common_battery";

    public static String a(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(f7430c, null);
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(f7430c, str).commit();
    }
}
