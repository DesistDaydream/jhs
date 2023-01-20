package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class gg {

    /* loaded from: classes3.dex */
    public enum a {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);
        

        /* renamed from: d  reason: collision with root package name */
        private final int f8666d;

        a(int i2) {
            this.f8666d = i2;
        }

        public int a() {
            return this.f8666d;
        }
    }

    public static int a(Context context) {
        Bundle bundle;
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.android.systemui", 128);
                if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                    return 0;
                }
                return bundle.getInt("SupportForPushVersionCode");
            } catch (PackageManager.NameNotFoundException unused) {
                return 0;
            }
        }
        return 0;
    }

    private static a a(Context context, ApplicationInfo applicationInfo) {
        int i2 = Build.VERSION.SDK_INT;
        if (applicationInfo == null || i2 < 24) {
            return a.UNKNOWN;
        }
        Boolean bool = null;
        try {
            if (applicationInfo.packageName.equals(context.getPackageName())) {
                bool = Boolean.valueOf(((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).areNotificationsEnabled());
            } else {
                Object a2 = i2 >= 29 ? am.a(context.getSystemService(RemoteMessageConst.NOTIFICATION), "getService", new Object[0]) : context.getSystemService("security");
                if (a2 != null) {
                    bool = (Boolean) am.b(a2, "areNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid));
                }
            }
            if (bool != null) {
                return bool.booleanValue() ? a.ALLOWED : a.NOT_ALLOWED;
            }
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("are notifications enabled error " + e2);
        }
        return a.UNKNOWN;
    }

    @TargetApi(19)
    public static a a(Context context, String str, boolean z) {
        ApplicationInfo applicationInfo;
        a a2;
        a aVar;
        if (context == null || TextUtils.isEmpty(str)) {
            return a.UNKNOWN;
        }
        try {
            applicationInfo = str.equals(context.getPackageName()) ? context.getApplicationInfo() : context.getPackageManager().getApplicationInfo(str, 0);
            a2 = a(context, applicationInfo);
            aVar = a.UNKNOWN;
        } catch (Throwable th) {
            com.xiaomi.a.a.a.c.a("get app op error " + th);
        }
        if (a2 != aVar) {
            return a2;
        }
        Integer num = (Integer) am.a((Class<? extends Object>) AppOpsManager.class, "OP_POST_NOTIFICATION");
        if (num == null) {
            return aVar;
        }
        Integer num2 = (Integer) am.a((Object) ((AppOpsManager) context.getSystemService("appops")), "checkOpNoThrow", num, Integer.valueOf(applicationInfo.uid), str);
        int i2 = (Integer) am.a((Class<? extends Object>) AppOpsManager.class, "MODE_ALLOWED");
        int i3 = (Integer) am.a((Class<? extends Object>) AppOpsManager.class, "MODE_IGNORED");
        com.xiaomi.a.a.a.c.b(String.format("get app mode %s|%s|%s", num2, i2, i3));
        if (i2 == null) {
            i2 = 0;
        }
        if (i3 == null) {
            i3 = 1;
        }
        if (num2 != null) {
            return z ? !num2.equals(i3) ? a.ALLOWED : a.NOT_ALLOWED : num2.equals(i2) ? a.ALLOWED : a.NOT_ALLOWED;
        }
        return a.UNKNOWN;
    }

    public static String a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    public static int b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    public static boolean b(Context context) {
        String str = (String) am.a("android.app.ActivityThread", "currentProcessName", new Object[0]);
        if (TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        return str.equals(context.getPackageName());
    }

    public static boolean c(Context context, String str) {
        if (jc.a()) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean d(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean e(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static String f(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) ? str : packageManager.getApplicationLabel(applicationInfo).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return str;
        }
    }

    public static int g(Context context, String str) {
        ApplicationInfo j2 = j(context, str);
        if (j2 != null) {
            int i2 = j2.icon;
            return i2 == 0 ? j2.logo : i2;
        }
        return 0;
    }

    public static Drawable h(Context context, String str) {
        ApplicationInfo j2 = j(context, str);
        Drawable drawable = null;
        if (j2 != null) {
            try {
                drawable = j2.loadIcon(context.getPackageManager());
                if (drawable == null) {
                    drawable = j2.loadLogo(context.getPackageManager());
                }
            } catch (Exception e2) {
                com.xiaomi.a.a.a.c.a("get app icon drawable failed, " + e2);
            }
        }
        return drawable != null ? drawable : new ColorDrawable(0);
    }

    public static boolean i(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "freeform_window_state", -1) >= 0) {
                return str.equals(Settings.Secure.getString(context.getContentResolver(), "freeform_package_name"));
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static ApplicationInfo j(Context context, String str) {
        if (str.equals(context.getPackageName())) {
            return context.getApplicationInfo();
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            com.xiaomi.a.a.a.c.a("not found app info " + str);
            return null;
        }
    }
}
