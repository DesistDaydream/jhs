package com.meizu.cloud.pushsdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;

/* loaded from: classes2.dex */
public class PushManager {
    private static final String KEY_PUSH_ID = "pushId";
    private static final String PUSH_ID_PREFERENCE_NAME = "com.meizu.flyme.push";
    private static final int PUSH_SUPPORT_CHECK_NOTIFICATION_MSG_VERSION_START = 6;
    public static final String TAG = "4.1.4";

    public static void checkNotificationMessage(Context context) {
        String appVersionName = MzSystemUtils.getAppVersionName(context, PushConstants.PUSH_PACKAGE_NAME);
        e.p.a.a.a.c(TAG, context.getPackageName() + " checkNotificationMessage cloudVersion_name " + appVersionName);
        if (TextUtils.isEmpty(appVersionName) || Integer.parseInt(appVersionName.substring(0, 1)) < 6) {
            return;
        }
        Intent intent = new Intent(PushConstants.MZ_PUSH_ON_GET_NOTIFICATION_MESSAGE);
        intent.putExtra(PushConstants.EXTRA_GET_NOTIFICATION_PACKAGE_NAME, context.getPackageName());
        intent.setClassName(PushConstants.PUSH_PACKAGE_NAME, PushConstants.MZ_PUSH_SERVICE_NAME);
        try {
            context.startService(intent);
        } catch (Exception e2) {
            e.p.a.a.a.f(TAG, "start check notification message service error " + e2.getMessage());
        }
    }

    public static void checkPush(Context context, String str, String str2, String str3) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).a(str, str2, context.getPackageName(), str3);
        } else {
            e.p.a.a.a.f(TAG, "please invoke checkPush on meizu device Build-in FlymeOS");
        }
    }

    public static void checkSubScribeAlias(Context context, String str, String str2, String str3) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).d(str, str2, context.getPackageName(), str3);
        } else {
            e.p.a.a.a.f(TAG, "please invoke checkSubScribeAlias on meizu device Build-in FlymeOS");
        }
    }

    public static void checkSubScribeTags(Context context, String str, String str2, String str3) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).c(str, str2, context.getPackageName(), str3);
        } else {
            e.p.a.a.a.f(TAG, "please invoke checkSubScribeTags on meizu device Build-in FlymeOS");
        }
    }

    public static void clearNotification(Context context) {
        com.meizu.cloud.pushsdk.platform.a.b.a(context).a(context.getPackageName());
    }

    public static void clearNotification(Context context, int... iArr) {
        com.meizu.cloud.pushsdk.platform.a.b.a(context).a(context.getPackageName(), iArr);
    }

    public static void enableCacheRequest(Context context, boolean z) {
        com.meizu.cloud.pushsdk.platform.a.b.a(context).a(z);
    }

    public static String getPushId(Context context) {
        int b = com.meizu.cloud.pushsdk.util.b.b(context, context.getPackageName());
        if (b == 0 || System.currentTimeMillis() / 1000 <= b) {
            return com.meizu.cloud.pushsdk.util.b.a(context, context.getPackageName());
        }
        return null;
    }

    @Deprecated
    public static void register(Context context) {
        e.p.a.a.a.b(context);
        if (!MzSystemUtils.isBrandMeizu(context)) {
            e.p.a.a.a.f(TAG, "please invoke register on meizu device Build-in FlymeOS");
            return;
        }
        String str = PushConstants.PUSH_PACKAGE_NAME;
        String appVersionName = MzSystemUtils.getAppVersionName(context, PushConstants.PUSH_PACKAGE_NAME);
        e.p.a.a.a.c(TAG, context.getPackageName() + " start register cloudVersion_name " + appVersionName);
        Intent intent = new Intent(PushConstants.MZ_PUSH_ON_START_PUSH_REGISTER);
        try {
            if (!PushConstants.PUSH_PACKAGE_NAME.equals(MzSystemUtils.getMzPushServicePackageName(context))) {
                if (!TextUtils.isEmpty(appVersionName) && MzSystemUtils.compareVersion(appVersionName, PushConstants.PUSH_FLYME_4_CHANGE_VERSION)) {
                    e.p.a.a.a.f(TAG, "flyme 4.x start register cloud versionName " + appVersionName);
                } else if (TextUtils.isEmpty(appVersionName) || !appVersionName.startsWith("3")) {
                    e.p.a.a.a.f(TAG, context.getPackageName() + " start register ");
                    str = context.getPackageName();
                } else {
                    e.p.a.a.a.f(TAG, "flyme 3.x start register cloud versionName " + appVersionName);
                    intent.setAction(PushConstants.REQUEST_REGISTER_INTENT);
                }
                intent.setPackage(PushConstants.PUSH_PACKAGE_NAME);
                intent.putExtra("sender", context.getPackageName());
                context.startService(intent);
                return;
            }
            context.startService(intent);
            return;
        } catch (Exception e2) {
            e.p.a.a.a.f(TAG, "start register service error " + e2.getMessage());
            return;
        }
        intent.setClassName(str, PushConstants.MZ_PUSH_SERVICE_NAME);
        intent.putExtra("sender", context.getPackageName());
    }

    public static void register(Context context, String str, String str2) {
        e.p.a.a.a.b(context);
        if (MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).a(str, str2, context.getPackageName());
        } else {
            e.p.a.a.a.f(TAG, "please invoke register on meizu device Build-in FlymeOS");
        }
    }

    public static void subScribeAlias(Context context, String str, String str2, String str3, String str4) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).c(str, str2, context.getPackageName(), str3, str4);
        } else {
            e.p.a.a.a.f(TAG, "please invoke subScribeAlias on meizu device Build-in FlymeOS");
        }
    }

    public static void subScribeTags(Context context, String str, String str2, String str3, String str4) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).a(str, str2, context.getPackageName(), str3, str4);
        } else {
            e.p.a.a.a.f(TAG, "please invoke subScribeTags on meizu device Build-in FlymeOS");
        }
    }

    public static void switchPush(Context context, String str, String str2, String str3, int i2, boolean z) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).a(str, str2, context.getPackageName(), str3, i2, z);
        } else {
            e.p.a.a.a.f(TAG, "please invoke switchPush on meizu device Build-in FlymeOS");
        }
    }

    public static void switchPush(Context context, String str, String str2, String str3, boolean z) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).a(str, str2, context.getPackageName(), str3, z);
        } else {
            e.p.a.a.a.f(TAG, "please invoke switchPush on meizu device Build-in FlymeOS");
        }
    }

    @Deprecated
    public static void unRegister(Context context) {
        if (!MzSystemUtils.isBrandMeizu(context)) {
            e.p.a.a.a.f(TAG, "please invoke unRegister on meizu device Build-in FlymeOS");
            return;
        }
        String str = PushConstants.PUSH_PACKAGE_NAME;
        String appVersionName = MzSystemUtils.getAppVersionName(context, PushConstants.PUSH_PACKAGE_NAME);
        e.p.a.a.a.f(TAG, context.getPackageName() + " start unRegister cloud versionName " + appVersionName);
        Intent intent = new Intent(PushConstants.MZ_PUSH_ON_STOP_PUSH_REGISTER);
        try {
            if (!PushConstants.PUSH_PACKAGE_NAME.equals(MzSystemUtils.getMzPushServicePackageName(context))) {
                if (TextUtils.isEmpty(appVersionName) || !MzSystemUtils.compareVersion(appVersionName, PushConstants.PUSH_FLYME_4_CHANGE_VERSION)) {
                    if (TextUtils.isEmpty(appVersionName) || !appVersionName.startsWith("3")) {
                        e.p.a.a.a.f(TAG, context.getPackageName() + " start unRegister ");
                        str = context.getPackageName();
                    } else {
                        intent.setAction(PushConstants.REQUEST_UNREGISTER_INTENT);
                    }
                }
                intent.setPackage(PushConstants.PUSH_PACKAGE_NAME);
                intent.putExtra("sender", context.getPackageName());
                context.startService(intent);
                return;
            }
            context.startService(intent);
            return;
        } catch (Exception e2) {
            e.p.a.a.a.f(TAG, "start unRegister service error " + e2.getMessage());
            return;
        }
        intent.setClassName(str, PushConstants.MZ_PUSH_SERVICE_NAME);
        intent.putExtra("sender", context.getPackageName());
    }

    public static void unRegister(Context context, String str, String str2) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).b(str, str2, context.getPackageName());
        } else {
            e.p.a.a.a.f(TAG, "please invoke unRegister on meizu device Build-in FlymeOS");
        }
    }

    public static void unSubScribeAlias(Context context, String str, String str2, String str3, String str4) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).d(str, str2, context.getPackageName(), str3, str4);
        } else {
            e.p.a.a.a.f(TAG, "please invoke unSubScribeAlias on meizu device Build-in FlymeOS");
        }
    }

    public static void unSubScribeAllTags(Context context, String str, String str2, String str3) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).b(str, str2, context.getPackageName(), str3);
        } else {
            e.p.a.a.a.f(TAG, "please invoke unSubScribeAllTags on meizu device Build-in FlymeOS");
        }
    }

    public static void unSubScribeTags(Context context, String str, String str2, String str3, String str4) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.pushsdk.platform.a.b.a(context).b(str, str2, context.getPackageName(), str3, str4);
        } else {
            e.p.a.a.a.f(TAG, "please invoke unSubScribeTags on meizu device Build-in FlymeOS");
        }
    }
}