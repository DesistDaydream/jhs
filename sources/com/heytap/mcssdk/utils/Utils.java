package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.heytap.mcssdk.PushService;

/* loaded from: classes2.dex */
public class Utils {
    public static String getString(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 : iArr) {
            sb.append((char) i2);
        }
        return sb.toString();
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e2) {
            d.b("getVersionCode--Exception:" + e2.getMessage());
            return 0;
        }
    }

    public static int getVersionCode(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Exception e2) {
            d.b("getVersionCode--Exception:" + e2.getMessage());
            return 0;
        }
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e2) {
            d.b("getVersionName--Exception:" + e2.getMessage());
            return "0";
        }
    }

    public static String getVersionName(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Exception e2) {
            d.b("getVersionName--Exception:" + e2.getMessage());
            return null;
        }
    }

    public static boolean isExistPackage(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            d.e("isExistPackage NameNotFoundException:" + e2.getMessage());
            return false;
        }
    }

    public static boolean isSupportPush(Context context, String str, String str2) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
        } catch (PackageManager.NameNotFoundException e2) {
            d.e("isSupportPush NameNotFoundException:" + e2.getMessage());
            applicationInfo = null;
        }
        return applicationInfo != null && applicationInfo.metaData.getBoolean(str2, false);
    }

    public static boolean isSupportPushByClient(Context context) {
        return PushService.getInstance().isSupportPushByClient(context);
    }

    public static int parseInt(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                d.e("parseInt--NumberFormatException" + e2.getMessage());
            }
        }
        return -1;
    }
}
