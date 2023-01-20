package com.tencent.imsdk.common;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes3.dex */
public class IMLog {
    public static final int LOG_LEVEL_DEBUG = 3;
    public static final int LOG_LEVEL_ERROR = 6;
    public static final int LOG_LEVEL_INFO = 4;
    public static final int LOG_LEVEL_OFF = 0;
    public static final int LOG_LEVEL_VERBOSE = 2;
    public static final int LOG_LEVEL_WARN = 5;
    private static final String TAG = "IMLog";

    public static void d(String str, String str2) {
        log(3, str, str2);
    }

    public static void e(String str, String str2) {
        log(6, str, str2);
    }

    public static void i(String str, String str2) {
        log(4, str, str2);
    }

    private static void log(int i2, String str, String str2) {
        if (!SystemUtil.loadIMLibrary()) {
            Log.e(TAG, "libimsdk.so is not loaded");
        } else if (i2 >= 0 && i2 <= 6) {
            if (TextUtils.isEmpty(str)) {
                e(TAG, "empty logTag");
            } else if (TextUtils.isEmpty(str2)) {
                e(TAG, "empty logContent");
            } else {
                nativeWriteLog(i2, str, "", 0, str2);
            }
        } else {
            String str3 = TAG;
            e(str3, "invalid logLevel： " + i2);
        }
    }

    public static native void nativeWriteLog(int i2, String str, String str2, int i3, String str3);

    public static void v(String str, String str2) {
        log(2, str, str2);
    }

    public static void w(String str, String str2) {
        log(5, str, str2);
    }

    public static void writeException(String str, String str2, Throwable th) {
        if (!SystemUtil.loadIMLibrary()) {
            Log.e(TAG, "libimsdk.so is not loaded");
            return;
        }
        Log.e(str, str2 + " exception : " + Log.getStackTraceString(th));
    }
}
