package com.moor.imkf.lib.http.utils;

import com.moor.imkf.lib.utils.MoorLogUtils;

/* loaded from: classes2.dex */
public class MoorNetLogUtil {
    private static final String TAG = "Moor_Http";

    public static void d(String str) {
        MoorLogUtils.dTag(TAG, str);
    }

    public static void e(String str, Throwable th) {
        MoorLogUtils.eTag(TAG, th, str);
    }

    public static void i(String str) {
        MoorLogUtils.iTag(TAG, str);
    }

    public static void json(String str) {
        MoorLogUtils.json(TAG, str);
    }

    public static void w(String str, Throwable th) {
        String th2 = th != null ? th.toString() : "null";
        MoorLogUtils.wTag(TAG, str + "：" + th2);
    }
}
