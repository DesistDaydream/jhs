package com.huawei.hms.framework.common;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import java.util.List;

/* loaded from: classes2.dex */
public class ActivityUtil {
    private static final String TAG = "ActivityUtil";

    public static PendingIntent getActivities(Context context, int i2, Intent[] intentArr, int i3) {
        if (context == null) {
            Logger.w(TAG, "context is null");
            return null;
        }
        try {
            return PendingIntent.getActivities(context, i2, intentArr, i3);
        } catch (RuntimeException e2) {
            Logger.e(TAG, "dealType rethrowFromSystemServer:", e2);
            return null;
        }
    }

    public static boolean isForeground(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) ContextCompat.getSystemService(context, "activity")) == null) {
            return false;
        }
        List<ActivityManager.RunningAppProcessInfo> list = null;
        try {
            list = activityManager.getRunningAppProcesses();
        } catch (RuntimeException e2) {
            Logger.w(TAG, "activityManager getRunningAppProcesses occur exception: ", e2);
        }
        if (list != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
                String str = runningAppProcessInfo.processName;
                if (str != null && str.equals(context.getPackageName()) && runningAppProcessInfo.importance == 100) {
                    Logger.v(TAG, "isForeground true");
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
