package com.tencent.android.tpush.service.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.Util;

/* loaded from: classes3.dex */
public class SharePrefsUtil {
    public static final String SHAREPRE_WATCH_PORT = "tpush_watchdog_port";
    public static int a = 100;
    private static SharedPreferences b;

    private static SharedPreferences a(Context context) {
        if (b == null) {
            b = context.getSharedPreferences("tpush.vip.shareprefs", 0);
        }
        return b;
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        a(context);
        try {
            return b.getBoolean(a(str), z);
        } catch (Throwable th) {
            TLogger.e("SharePrefsUtil", "getBoolean", th);
            return z;
        }
    }

    public static int getInt(Context context, String str, int i2) {
        a(context);
        return b.getInt(a(str), i2);
    }

    public static long getLong(Context context, String str, long j2) {
        a(context);
        return b.getLong(a(str), j2);
    }

    public static int getSeqId(Context context) {
        int i2 = a + 1;
        a = i2;
        if (i2 == Integer.MAX_VALUE) {
            a = 1;
        }
        TLogger.i("SharePrefsUtil", "seqId = " + a);
        return a;
    }

    public static String getString(Context context, String str, String str2) {
        a(context);
        return b.getString(a(str), str2);
    }

    public static void setBoolean(Context context, String str, boolean z) {
        try {
            SharedPreferences.Editor edit = a(context).edit();
            edit.putBoolean(a(str), z);
            edit.commit();
        } catch (Throwable th) {
            TLogger.e("SharePrefsUtil", "", th);
        }
    }

    public static void setInt(Context context, String str, int i2) {
        try {
            SharedPreferences.Editor edit = a(context).edit();
            edit.putInt(a(str), i2);
            edit.commit();
        } catch (Throwable th) {
            TLogger.e("SharePrefsUtil", "", th);
        }
    }

    public static void setLong(Context context, String str, long j2) {
        try {
            SharedPreferences.Editor edit = a(context).edit();
            edit.putLong(a(str), j2);
            edit.commit();
        } catch (Throwable th) {
            TLogger.e("SharePrefsUtil", "", th);
        }
    }

    public static void setString(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = a(context).edit();
            edit.putString(a(str), str2);
            edit.commit();
        } catch (Throwable th) {
            TLogger.e("SharePrefsUtil", "", th);
        }
    }

    private static String a(String str) {
        return Util.getKey(str);
    }
}
