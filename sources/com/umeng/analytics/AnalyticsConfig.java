package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.j;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Map;

/* loaded from: classes3.dex */
public class AnalyticsConfig {
    public static boolean CATCH_EXCEPTION = false;
    public static boolean CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    public static boolean CLEAR_EKV_BL = false;
    public static boolean CLEAR_EKV_WL = false;
    public static final String DEBUG_KEY = "debugkey";
    public static final String DEBUG_MODE_PERIOD = "sendaging";
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";
    public static final String RTD_PERIOD = "period";
    public static final String RTD_SP_FILE = "um_rtd_conf";
    public static final String RTD_START_TIME = "startTime";
    public static double[] a = null;
    private static String b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f6957c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String f6958d = null;

    /* renamed from: e  reason: collision with root package name */
    private static int f6959e = 0;
    public static boolean enable = true;

    /* renamed from: f  reason: collision with root package name */
    private static Object f6960f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static boolean f6961g = false;

    /* renamed from: h  reason: collision with root package name */
    private static String f6962h = "";
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType;
    public static String mWrapperVersion;

    public static void a(String str) {
        f6957c = str;
    }

    public static String getAppkey(Context context) {
        return UMUtils.getAppkey(context);
    }

    public static String getChannel(Context context) {
        return UMUtils.getChannel(context);
    }

    public static String getGameSdkVersion(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.analytics.game.GameSdkVersion");
            if (cls != null) {
                return (String) cls.getDeclaredField("SDK_VERSION").get(cls);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static double[] getLocation() {
        return a;
    }

    public static String getRealTimeDebugKey() {
        String str;
        synchronized (f6960f) {
            str = f6962h;
        }
        return str;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f6958d)) {
            f6958d = com.umeng.common.b.a(context).c();
        }
        return f6958d;
    }

    public static int getVerticalType(Context context) {
        if (f6959e == 0) {
            f6959e = com.umeng.common.b.a(context).d();
        }
        return f6959e;
    }

    public static boolean isRealTimeDebugMode() {
        boolean z;
        synchronized (f6960f) {
            z = f6961g;
        }
        return z;
    }

    public static void turnOffRealTimeDebug() {
        synchronized (f6960f) {
            f6961g = false;
            f6962h = "";
        }
    }

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        synchronized (f6960f) {
            f6961g = true;
            if (map != null && map.containsKey(DEBUG_KEY)) {
                f6962h = map.get(DEBUG_KEY);
            }
        }
    }

    public static void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            f6958d = str;
            com.umeng.common.b.a(context).a(f6958d);
            return;
        }
        UMLog.aq(j.A, 0, "\\|");
    }

    public static void a(Context context, int i2) {
        f6959e = i2;
        com.umeng.common.b.a(context).a(f6959e);
    }
}
