package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes3.dex */
public class c {
    private static final String a = "um_slmode_sp";
    private static final String b = "lastReqTime";

    /* renamed from: c  reason: collision with root package name */
    private static final int f7602c = 48;

    /* renamed from: d  reason: collision with root package name */
    private static final int f7603d = 1;

    /* renamed from: e  reason: collision with root package name */
    private static final int f7604e = 720;

    /* renamed from: f  reason: collision with root package name */
    private static final String f7605f = "iss";

    /* renamed from: g  reason: collision with root package name */
    private static final String f7606g = "sinr";

    /* renamed from: h  reason: collision with root package name */
    private static final String f7607h = "clean";

    /* renamed from: i  reason: collision with root package name */
    private static boolean f7608i = false;

    /* renamed from: j  reason: collision with root package name */
    private static int f7609j = 720;

    /* renamed from: k  reason: collision with root package name */
    private static Object f7610k = new Object();

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(appContext, f7605f, "");
            if (TextUtils.isEmpty(imprintProperty) || !"1".equals(imprintProperty)) {
                return;
            }
            synchronized (f7610k) {
                f7608i = true;
            }
            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(appContext, f7606g, "");
            if (!TextUtils.isEmpty(imprintProperty)) {
                try {
                    f7609j = a(Integer.parseInt(imprintProperty2));
                    return;
                } catch (Throwable unused) {
                    f7609j = 48;
                    return;
                }
            }
            f7609j = 48;
        }
    }

    private static int a(int i2) {
        if (i2 > f7604e) {
            return f7604e;
        }
        if (i2 < 1) {
            return 1;
        }
        return i2;
    }

    public static boolean a() {
        boolean z;
        synchronized (f7610k) {
            z = f7608i;
        }
        return z;
    }

    public static long b(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(b, 0L);
        }
        return 0L;
    }

    public static void c(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f7607h, true).commit();
        }
    }

    public static void d(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f7607h, false).commit();
        }
    }

    public static boolean e(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(f7607h, false);
        }
        return false;
    }

    public static int a(Context context) {
        int i2;
        synchronized (f7610k) {
            i2 = f7609j;
        }
        return i2;
    }

    public static boolean a(long j2, long j3, int i2) {
        Date date = new Date(j3);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j2));
        calendar.add(10, i2);
        return date.after(calendar.getTime());
    }

    public static void a(Context context, long j2) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(b, j2).commit();
        }
    }
}
