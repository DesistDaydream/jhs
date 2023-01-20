package com.tencent.tpns.baseapi.base;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.tpns.baseapi.crosssp.a;

/* loaded from: classes3.dex */
public class PushPreferences {
    private static a a;

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (PushPreferences.class) {
            if (a == null) {
                a = a.a(context);
            }
            aVar = a;
        }
        return aVar;
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return a(context).a(str, z);
    }

    public static float getFloat(Context context, String str, float f2) {
        return a(context).a(str, f2);
    }

    public static int getInt(Context context, String str, int i2) {
        return a(context).a(str, i2);
    }

    public static long getLong(Context context, String str, long j2) {
        return a(context).a(str, j2);
    }

    public static Object getObject(Context context, String str, String str2) {
        return a(context).b(str, str2);
    }

    public static String getString(Context context, String str, String str2) {
        return a(context).a(str, str2);
    }

    public static void putBoolean(Context context, String str, boolean z) {
        a.C0271a a2 = a(context).a();
        a2.a(str, z);
        a2.b();
    }

    public static void putContentValues(Context context, ContentValues contentValues) {
        a.C0271a a2 = a(context).a();
        a2.a(contentValues);
        a2.b();
    }

    public static void putFloat(Context context, String str, float f2) {
        a.C0271a a2 = a(context).a();
        a2.a(str, f2);
        a2.b();
    }

    public static void putInt(Context context, String str, int i2) {
        a.C0271a a2 = a(context).a();
        a2.a(str, i2);
        a2.b();
    }

    public static void putLong(Context context, String str, long j2) {
        a.C0271a a2 = a(context).a();
        a2.a(str, j2);
        a2.b();
    }

    public static void putString(Context context, String str, String str2) {
        a.C0271a a2 = a(context).a();
        a2.a(str, str2);
        a2.b();
    }

    public static void remove(Context context, String str) {
        if (a(context) != null) {
            a.C0271a a2 = a(context).a();
            a2.a(str);
            a2.b();
        }
    }
}
