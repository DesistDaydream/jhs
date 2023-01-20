package com.tencent.android.tpush.e;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.reflecttools.Reflect;
import com.tencent.tpns.reflecttools.ReflectException;

/* loaded from: classes3.dex */
public class a {
    private static Boolean a;
    private static Boolean b;

    public static boolean a(Context context) {
        Boolean bool = Boolean.FALSE;
        if (a == null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo.uid > 1000 && (applicationInfo.flags & 1) == 0) {
                a = bool;
                TLogger.d("SysPush", "Run in normal app");
            } else {
                try {
                    Class.forName("com.tencent.tpns.syspush.XGSystemPush");
                    a = Boolean.TRUE;
                    TLogger.ii("SysPush", "Run As SysPush!");
                } catch (Throwable unused) {
                    a = bool;
                    TLogger.ii("SysPush", "Run in sys app, but not found sys push sdk");
                    return a.booleanValue();
                }
            }
        }
        return a.booleanValue();
    }

    public static boolean b(Context context) {
        Boolean bool = Boolean.FALSE;
        if (b == null) {
            try {
                for (ProviderInfo providerInfo : context.getPackageManager().queryContentProviders(null, 0, 0)) {
                    if (providerInfo.name.equals("com.tencent.tpns.syspush.XGSystemPushProvider") && providerInfo.authority.equals(Constants.XG_SYS_PUSH_AUTH)) {
                        TLogger.d("SysPush", "get sys push content provider");
                        ApplicationInfo applicationInfo = providerInfo.applicationInfo;
                        if (context.getPackageName().equals(applicationInfo.packageName)) {
                            b = bool;
                            TLogger.i("SysPush", "Get isUseXgSysDevice false, beacuse it is itself");
                            return b.booleanValue();
                        } else if (applicationInfo.uid <= 1000 || (applicationInfo.flags & 1) != 0) {
                            b = Boolean.TRUE;
                            TLogger.i("SysPush", "Get isUseXgSysDevice true -> uid:" + applicationInfo.uid + ", applicationInfo.flags:" + applicationInfo.flags);
                            return b.booleanValue();
                        }
                    }
                }
            } catch (Throwable th) {
                TLogger.w("SysPush", "isUseXgSysDevice Throwable ", th);
            }
            b = bool;
        }
        TLogger.i("SysPush", "isUseXgSysDevice: " + b);
        return b.booleanValue();
    }

    public static boolean a(Context context, long j2, String str) {
        try {
            return ((Boolean) Reflect.on("com.tencent.tpns.syspush.XGSystemPush").call("checkAccessIdAndPackage", context, Long.valueOf(j2), str).get()).booleanValue();
        } catch (ReflectException unused) {
            return false;
        }
    }

    public static String a(Context context, long j2) {
        try {
            return (String) Reflect.on("com.tencent.tpns.syspush.XGSystemPush").call("getAppPackage", context, Long.valueOf(j2)).get();
        } catch (ReflectException unused) {
            return null;
        }
    }

    public static int a() {
        try {
            return ((Integer) Reflect.on("com.tencent.tpns.syspush.XGSystemPush").call("getPushChannelType").get()).intValue();
        } catch (ReflectException unused) {
            return -1;
        }
    }
}
