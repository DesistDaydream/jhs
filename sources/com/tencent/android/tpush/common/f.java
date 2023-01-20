package com.tencent.android.tpush.common;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.logging.TLogger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class f {
    private static final String[] a = {"android.permission.INTERNET", "android.permission.ACCESS_WIFI_STATE", "android.permission.ACCESS_NETWORK_STATE"};
    private static Map<String, Boolean> b = new HashMap(8);

    public static boolean a() {
        String[] strArr;
        Context b2 = b();
        if (b2 != null) {
            try {
                PackageManager packageManager = b2.getPackageManager();
                if (packageManager != null) {
                    String[] strArr2 = packageManager.getPackageInfo(b2.getPackageName(), 4096).requestedPermissions;
                    if (strArr2 == null) {
                        return false;
                    }
                    for (String str : a) {
                        boolean a2 = a(strArr2, str);
                        b.put(str, Boolean.valueOf(a2));
                        if (!a2) {
                            TLogger.ee("PermissionChecker", "The required permission of <" + str + "> does not found!");
                            return false;
                        }
                    }
                    return true;
                }
                return true;
            } catch (Throwable th) {
                TLogger.e("PermissionChecker", "check required permissins exception.", th);
                return false;
            }
        }
        throw new IllegalArgumentException("The context parameter can not be null!");
    }

    private static Context b() {
        return XGPushManager.getContext() != null ? XGPushManager.getContext() : com.tencent.android.tpush.service.b.e();
    }

    private static boolean a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
