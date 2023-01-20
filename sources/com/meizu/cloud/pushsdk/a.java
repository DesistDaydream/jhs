package com.meizu.cloud.pushsdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.List;

/* loaded from: classes2.dex */
public class a {
    public static void a(Context context) {
        if (context.getPackageName().equalsIgnoreCase(MzSystemUtils.isWatch() ? PushConstants.WEARABLE_PUSH_PACKAGE_NAME : PushConstants.PUSH_PACKAGE_NAME)) {
            return;
        }
        b(context);
        c(context);
    }

    private static void b(Context context) {
        String str = MzSystemUtils.isWatch() ? PushConstants.WEARABLE_PUSH_PACKAGE_NAME : PushConstants.PUSH_PACKAGE_NAME;
        String appVersionName = MzSystemUtils.getAppVersionName(context, str);
        e.p.a.a.a.c("PullUpPush", context.getPackageName() + " start register cloudVersion_name " + appVersionName);
        Intent intent = new Intent();
        if (str.equals(MzSystemUtils.getMzPushServicePackageName(context))) {
            e.p.a.a.a.f("PullUpPush", "cloud pushService start");
            intent.setAction(PushConstants.PUSH_SERVICE_ACTION);
            intent.setClassName(str, PushConstants.MZ_PUSH_SERVICE_NAME);
        } else if (!TextUtils.isEmpty(appVersionName) && MzSystemUtils.compareVersion(appVersionName, PushConstants.PUSH_FLYME_4_CHANGE_VERSION)) {
            e.p.a.a.a.f("PullUpPush", "flyme 4.x start register cloud versionName " + appVersionName);
            intent.setPackage(str);
            intent.setAction(PushConstants.MZ_PUSH_ON_START_PUSH_REGISTER);
        } else if (TextUtils.isEmpty(appVersionName) || !appVersionName.startsWith("3")) {
            e.p.a.a.a.f("PullUpPush", context.getPackageName() + " start register ");
            intent.setClassName(context.getPackageName(), PushConstants.MZ_PUSH_SERVICE_NAME);
            intent.setAction(PushConstants.PUSH_SERVICE_ACTION);
        } else {
            e.p.a.a.a.f("PullUpPush", "flyme 3.x start register cloud versionName " + appVersionName);
            intent.setAction(PushConstants.REQUEST_REGISTER_INTENT);
            intent.setPackage(str);
        }
        try {
            context.startService(intent);
        } catch (Exception e2) {
            e.p.a.a.a.f("PullUpPush", "start service error " + e2.getMessage());
        }
    }

    private static void c(Context context) {
        if (Build.VERSION.SDK_INT > 22) {
            return;
        }
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(PushConstants.MZ_PUSH_TRACKER_SERVICE_ACTION), 0);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            com.meizu.cloud.pushsdk.d.a.a(context, false).a();
        }
    }
}
