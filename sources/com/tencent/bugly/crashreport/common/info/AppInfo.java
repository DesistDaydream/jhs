package com.tencent.bugly.crashreport.common.info;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.bugly.proguard.y;
import com.xiaomi.mipush.sdk.Constants;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class AppInfo {
    private static ActivityManager a;

    static {
        "@buglyAllChannel@".split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        "@buglyAllChannelPriority@".split(Constants.ACCEPT_TIME_SEPARATOR_SP);
    }

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            if (y.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static PackageInfo b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(a(context), 0);
        } catch (Throwable th) {
            if (y.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static String c(Context context) {
        CharSequence applicationLabel;
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (packageManager != null && applicationInfo != null && (applicationLabel = packageManager.getApplicationLabel(applicationInfo)) != null) {
                return applicationLabel.toString();
            }
        } catch (Throwable th) {
            if (!y.a(th)) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Map<String, String> d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                HashMap hashMap = new HashMap();
                Object obj = applicationInfo.metaData.get("BUGLY_DISABLE");
                if (obj != null) {
                    hashMap.put("BUGLY_DISABLE", obj.toString());
                }
                Object obj2 = applicationInfo.metaData.get("BUGLY_APPID");
                if (obj2 != null) {
                    hashMap.put("BUGLY_APPID", obj2.toString());
                }
                Object obj3 = applicationInfo.metaData.get("BUGLY_APP_CHANNEL");
                if (obj3 != null) {
                    hashMap.put("BUGLY_APP_CHANNEL", obj3.toString());
                }
                Object obj4 = applicationInfo.metaData.get("BUGLY_APP_VERSION");
                if (obj4 != null) {
                    hashMap.put("BUGLY_APP_VERSION", obj4.toString());
                }
                Object obj5 = applicationInfo.metaData.get("BUGLY_ENABLE_DEBUG");
                if (obj5 != null) {
                    hashMap.put("BUGLY_ENABLE_DEBUG", obj5.toString());
                }
                Object obj6 = applicationInfo.metaData.get("com.tencent.rdm.uuid");
                if (obj6 != null) {
                    hashMap.put("com.tencent.rdm.uuid", obj6.toString());
                }
                Object obj7 = applicationInfo.metaData.get("BUGLY_APP_BUILD_NO");
                if (obj7 != null) {
                    hashMap.put("BUGLY_APP_BUILD_NO", obj7.toString());
                }
                Object obj8 = applicationInfo.metaData.get("BUGLY_AREA");
                if (obj8 != null) {
                    hashMap.put("BUGLY_AREA", obj8.toString());
                }
                return hashMap;
            }
            return null;
        } catch (Throwable th) {
            if (!y.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static boolean e(Context context) {
        if (context == null) {
            return false;
        }
        if (a == null) {
            a = (ActivityManager) context.getSystemService("activity");
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            a.getMemoryInfo(memoryInfo);
            if (memoryInfo.lowMemory) {
                y.c("Memory is low.", new Object[0]);
                return true;
            }
            return false;
        } catch (Throwable th) {
            if (!y.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public static String a(int i2) {
        FileReader fileReader;
        Throwable th;
        try {
            fileReader = new FileReader("/proc/" + i2 + "/cmdline");
        } catch (Throwable th2) {
            fileReader = null;
            th = th2;
        }
        try {
            char[] cArr = new char[512];
            fileReader.read(cArr);
            int i3 = 0;
            while (i3 < 512 && cArr[i3] != 0) {
                i3++;
            }
            String substring = new String(cArr).substring(0, i3);
            try {
                fileReader.close();
            } catch (Throwable unused) {
            }
            return substring;
        } catch (Throwable th3) {
            th = th3;
            try {
                if (!y.a(th)) {
                    th.printStackTrace();
                }
                String valueOf = String.valueOf(i2);
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused2) {
                    }
                }
                return valueOf;
            } catch (Throwable th4) {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused3) {
                    }
                }
                throw th4;
            }
        }
    }

    public static List<String> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            String str = map.get("BUGLY_DISABLE");
            if (str != null && str.length() != 0) {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                for (int i2 = 0; i2 < split.length; i2++) {
                    split[i2] = split[i2].trim();
                }
                return Arrays.asList(split);
            }
            return null;
        } catch (Throwable th) {
            if (!y.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
