package com.tencent.android.tpush.common;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import com.tencent.android.tpush.logging.TLogger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class AppInfos {
    private static String a = "";

    public static boolean checkApplicationIcon(Context context) {
        try {
            ApplicationInfo appInfo = getAppInfo(context);
            if (appInfo == null) {
                TLogger.ee("AppInfos", "Failed to init due to null ApplicationInfo.");
                return false;
            } else if (appInfo.icon == 0) {
                TLogger.ee("AppInfos", "Failed to get Application icon in AndroidManifest.xml, You App maybe can not show notification, Please add Application icon in AndroidManifest.xml");
                return false;
            } else {
                return true;
            }
        } catch (Throwable th) {
            TLogger.w("AppInfos", "unexpected for checkApplicationIcon:" + th.getMessage());
            return false;
        }
    }

    public static boolean forbidPullupService(Context context) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return false;
            }
            return bundle.getBoolean(Constants.METADATA_XG_SERVICE_PULL_UP_OFF);
        } catch (Throwable th) {
            TLogger.w("AppInfos", "unexpected for forbidPullupService", th);
            return false;
        }
    }

    public static int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    public static ApplicationInfo getAppInfo(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        } catch (Throwable th) {
            TLogger.ee("AppInfos", "Failed to get Application info", th);
            return null;
        }
    }

    public static String getAppVersion(Context context) {
        String str;
        if (i.c(a)) {
            return a;
        }
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            a = str;
        } catch (Throwable th) {
            TLogger.ee("AppInfos", "getAppVersion error!", th);
        }
        if (str != null) {
            if (str.length() == 0) {
                return "unknown";
            }
            return a;
        }
        return "unknown";
    }

    public static String getApplicationName(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i2 = applicationInfo.labelRes;
            return i2 == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i2);
        } catch (Throwable th) {
            TLogger.e("AppInfos", "", th);
            return null;
        }
    }

    public static String getCurAppVersion(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return str == null ? "" : str;
        } catch (Throwable th) {
            TLogger.e("AppInfos", "get app version error", th);
            return "";
        }
    }

    public static String getCurrentPackageName(Context context) {
        return context != null ? context.getPackageName() : "";
    }

    public static String getLauncherPackageName(Context context) {
        ActivityInfo activityInfo;
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null || (activityInfo = resolveActivity.activityInfo) == null || activityInfo.packageName.equals(com.effective.android.panel.Constants.ANDROID)) {
            return null;
        }
        return resolveActivity.activityInfo.packageName;
    }

    public static Object getMetaData(Context context, String str, Object obj) {
        Object obj2;
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        return (applicationInfo == null || (obj2 = applicationInfo.metaData.get(str)) == null) ? obj : obj2;
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static List<String> getRunningPkgsByPkgs(Context context, List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (isAppOnForeground(context, list.get(i2))) {
                arrayList.clear();
                arrayList.add(list.get(i2));
                return arrayList;
            }
            if (isAppRunning(context, list.get(i2))) {
                arrayList.add(list.get(i2));
            }
        }
        return arrayList;
    }

    public static boolean isAppOnForeground(Context context) {
        return isAppOnForeground(context, context.getPackageName());
    }

    public static boolean isAppRunning(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean isAppOnForeground(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(str) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }
}
