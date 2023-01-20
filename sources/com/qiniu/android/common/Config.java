package com.qiniu.android.common;

import com.qiniu.android.utils.ContextGetter;

/* loaded from: classes3.dex */
public final class Config {
    public static double interval = 0.0d;
    public static boolean isRecord = true;
    public static boolean isUpload = true;
    public static int maxRecordFileSize = 0;
    public static String preQueryHost00 = null;
    public static String preQueryHost01 = null;
    public static String preQueryHost02 = null;
    public static String recordDir = null;
    public static final String upLogURL = "uplog.qbox.me";
    public static int uploadThreshold;

    static {
        try {
            recordDir = ContextGetter.applicationContext().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
        maxRecordFileSize = 20971520;
        uploadThreshold = 16384;
        interval = 0.5d;
        preQueryHost00 = "uc.qbox.me";
        preQueryHost01 = "api.qiniu.com";
        preQueryHost02 = "kodo-config.qiniuapi.com";
    }

    public static void normal() {
        uploadThreshold = 4096;
        interval = 10.0d;
    }

    public static void quick() {
        uploadThreshold = 1024;
        interval = 2.0d;
    }

    public static void slow() {
        uploadThreshold = 153600;
        interval = 300.0d;
    }
}
