package com.tencent.qcloud.tim.tuiofflinepush.utils;

import com.tencent.imsdk.common.IMLog;

/* loaded from: classes3.dex */
public class TUIOfflinePushLog extends IMLog {
    private static final String PRE = "";

    public static void d(String str, String str2) {
        IMLog.d(mixTag(str), str2);
    }

    public static void e(String str, String str2) {
        IMLog.e(mixTag(str), str2);
    }

    public static void i(String str, String str2) {
        IMLog.i(mixTag(str), str2);
    }

    private static String mixTag(String str) {
        return "" + str;
    }

    public static void v(String str, String str2) {
        IMLog.v(mixTag(str), str2);
    }

    public static void w(String str, String str2) {
        IMLog.w(mixTag(str), str2);
    }
}
