package com.m7.imkfsdk.view.widget;

import android.util.Log;

/* loaded from: classes2.dex */
public class PagerConfig {
    private static final String TAG = "PagerGrid";
    private static int sFlingThreshold = 1000;
    private static float sMillisecondsPreInch = 60.0f;
    private static boolean sShowLog = false;

    public static void Loge(String str) {
        if (isShowLog()) {
            Log.e(TAG, str);
        }
    }

    public static void Logi(String str) {
        if (isShowLog()) {
            Log.i(TAG, str);
        }
    }

    public static int getFlingThreshold() {
        return sFlingThreshold;
    }

    public static float getMillisecondsPreInch() {
        return sMillisecondsPreInch;
    }

    public static boolean isShowLog() {
        return sShowLog;
    }

    public static void setFlingThreshold(int i2) {
        sFlingThreshold = i2;
    }

    public static void setMillisecondsPreInch(float f2) {
        sMillisecondsPreInch = f2;
    }

    public static void setShowLog(boolean z) {
        sShowLog = z;
    }
}
