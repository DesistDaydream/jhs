package com.moor.imkf.lib.utils;

import android.os.Build;

/* loaded from: classes2.dex */
public class MoorSdkVersionUtil {
    public static boolean over19() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public static boolean over21() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean over23() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean over24() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean over25() {
        return Build.VERSION.SDK_INT >= 25;
    }

    public static boolean over26() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean over29() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
