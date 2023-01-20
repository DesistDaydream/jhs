package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.m7.imkfsdk.utils.permission.PermissionConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class ii {
    private static String a = null;
    private static String b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f8985c = "";

    /* renamed from: d  reason: collision with root package name */
    private static String f8986d;

    /* renamed from: e  reason: collision with root package name */
    private static String f8987e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f8988f = String.valueOf((char) 2);

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f8989g = {"--", "a-", "u-", "v-", "o-", "g-"};

    /* renamed from: h  reason: collision with root package name */
    private static final Set<String> f8990h;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f8991i;

    static {
        HashSet hashSet = new HashSet();
        f8990h = hashSet;
        hashSet.add("com.xiaomi.xmsf");
        hashSet.add("com.xiaomi.finddevice");
        hashSet.add("com.miui.securitycenter");
        f8991i = true;
    }

    private static double a(double d2) {
        int i2 = 1;
        while (true) {
            double d3 = i2;
            if (d3 >= d2) {
                return d3;
            }
            i2 <<= 1;
        }
    }

    @TargetApi(17)
    public static int a() {
        Object a2 = am.a("android.os.UserHandle", "myUserId", new Object[0]);
        if (a2 == null) {
            return -1;
        }
        return ((Integer) Integer.class.cast(a2)).intValue();
    }

    private static long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    private static String a(int i2) {
        if (i2 > 0) {
            String[] strArr = f8989g;
            if (i2 < strArr.length) {
                return strArr[i2];
            }
        }
        return f8989g[0];
    }

    public static String a(Context context) {
        try {
            return ja.a(context).a();
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("failure to get gaid:" + e2.getMessage());
            return null;
        }
    }

    public static String a(Context context, boolean z) {
        if (f8986d == null) {
            String c2 = c(context);
            String d2 = !jc.g() ? z ? d(context) : n(context) : "";
            String b2 = b(context);
            int i2 = 1;
            if (!(Build.VERSION.SDK_INT < 26) && b(d2) && b(b2)) {
                String d3 = ac.a(context).d();
                if (TextUtils.isEmpty(d3)) {
                    String b3 = ac.a(context).b();
                    if (TextUtils.isEmpty(b3) || b3.startsWith("00000000-0000-0000-0000-000000000000")) {
                        i2 = 5;
                    } else {
                        i2 = 4;
                        c2 = b3;
                    }
                } else {
                    c2 = d3 + c2;
                    i2 = 2;
                }
            } else {
                c2 = d2 + c2 + b2;
            }
            com.xiaomi.a.a.a.c.b("devid rule select:" + i2);
            if (i2 == 3) {
                f8986d = c2;
            } else {
                f8986d = a(i2) + ar.b(c2);
            }
        }
        return f8986d;
    }

    public static boolean a(Context context, String str) {
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo = (PackageInfo) am.a((Object) context.getPackageManager(), "getPackageInfoAsUser", str, 0, 999);
        if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
            int i2 = applicationInfo.flags;
            if ((i2 & 2097152) != 2097152 || (i2 & 8388608) == 8388608) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i2 = 0;
        while (true) {
            String[] strArr = f8989g;
            if (i2 >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i2])) {
                return true;
            }
            i2++;
        }
    }

    private static float b(int i2) {
        float f2 = ((((((i2 + 102400) / 524288) + 1) * 512) * 1024) / 1024.0f) / 1024.0f;
        double d2 = f2;
        return d2 > 0.5d ? (float) Math.ceil(d2) : f2;
    }

    public static String b() {
        return b(c()) + "GB";
    }

    public static String b(Context context) {
        return null;
    }

    private static boolean b(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        return trim.length() == 0 || trim.equalsIgnoreCase("null") || trim.equalsIgnoreCase("unknown");
    }

    public static int c() {
        BufferedReader bufferedReader;
        Throwable th;
        String[] split;
        if (new File("/proc/meminfo").exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                } catch (Exception unused) {
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                }
                try {
                    String readLine = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine) && (split = readLine.split("\\s+")) != null && split.length >= 2 && TextUtils.isDigitsOnly(split[1])) {
                        Integer.parseInt(split[1]);
                    }
                    bufferedReader.close();
                } catch (Exception unused2) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return 0;
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused4) {
            }
        }
        return 0;
    }

    public static String c(Context context) {
        String str = b;
        if (str == null && f8991i) {
            boolean p = p(context);
            f8991i = p;
            if (p) {
                try {
                    b = Settings.Secure.getString(context.getContentResolver(), "android_id");
                } catch (Throwable th) {
                    com.xiaomi.a.a.a.c.a("failure to get androidId: " + th);
                }
                return b;
            }
            return null;
        }
        return str;
    }

    private static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 15 && str.length() >= 14 && ar.e(str) && !ar.f(str);
    }

    public static String d() {
        double a2 = a(((a(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d);
        return a2 + "GB";
    }

    public static String d(Context context) {
        int g2 = g();
        String e2 = e(context);
        while (e2 == null) {
            int i2 = g2 - 1;
            if (g2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused) {
            }
            e2 = e(context);
            g2 = i2;
        }
        return e2;
    }

    public static String e() {
        return c() + "KB";
    }

    public static String e(Context context) {
        String str;
        Object obj;
        Object a2;
        Object a3;
        if (jc.g()) {
            return "";
        }
        String str2 = a;
        if (str2 != null) {
            return str2;
        }
        try {
            if (o(context)) {
                str = (!jc.a() || (a2 = am.a("miui.telephony.TelephonyManager", "getDefault", new Object[0])) == null || (a3 = am.a(a2, "getMiuiDeviceId", new Object[0])) == null || !(a3 instanceof String)) ? null : (String) String.class.cast(a3);
                if (str == null) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (Build.VERSION.SDK_INT < 26) {
                        str = telephonyManager.getDeviceId();
                    } else {
                        if (1 == telephonyManager.getPhoneType()) {
                            obj = am.a((Object) telephonyManager, "getImei", (Object[]) null);
                        } else if (2 == telephonyManager.getPhoneType()) {
                            obj = am.a((Object) telephonyManager, "getMeid", (Object[]) null);
                        }
                        str = (String) obj;
                    }
                }
            } else {
                str = null;
            }
            if (c(str)) {
                a = str;
                return str;
            }
            return "";
        } catch (Throwable th) {
            com.xiaomi.a.a.a.c.a("failure to get id:" + th);
            return null;
        }
    }

    public static String f() {
        long a2 = a(Environment.getDataDirectory());
        return (a2 / 1024) + "KB";
    }

    public static String f(Context context) {
        int g2 = g();
        String h2 = h(context);
        while (h2 == null) {
            int i2 = g2 - 1;
            if (g2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused) {
            }
            h2 = h(context);
            g2 = i2;
        }
        return h2;
    }

    private static int g() {
        return Build.VERSION.SDK_INT < 29 ? 10 : 0;
    }

    public static String g(Context context) {
        Object a2;
        int i2 = Build.VERSION.SDK_INT;
        if (!jc.g() && i2 >= 22) {
            if (TextUtils.isEmpty(f8985c)) {
                e(context);
                if (TextUtils.isEmpty(a)) {
                    return "";
                }
                try {
                    if (o(context)) {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        Integer num = (Integer) am.a((Object) telephonyManager, "getPhoneCount", new Object[0]);
                        if (num != null && num.intValue() > 1) {
                            String str = null;
                            for (int i3 = 0; i3 < num.intValue(); i3++) {
                                if (i2 < 26) {
                                    a2 = am.a((Object) telephonyManager, "getDeviceId", Integer.valueOf(i3));
                                } else if (1 == telephonyManager.getPhoneType()) {
                                    a2 = am.a((Object) telephonyManager, "getImei", Integer.valueOf(i3));
                                } else {
                                    if (2 == telephonyManager.getPhoneType()) {
                                        a2 = am.a((Object) telephonyManager, "getMeid", Integer.valueOf(i3));
                                    }
                                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(a, str) && c(str)) {
                                        f8985c += str + Constants.ACCEPT_TIME_SEPARATOR_SP;
                                    }
                                }
                                str = (String) a2;
                                if (!TextUtils.isEmpty(str)) {
                                    f8985c += str + Constants.ACCEPT_TIME_SEPARATOR_SP;
                                }
                            }
                            int length = f8985c.length();
                            if (length > 0) {
                                f8985c = f8985c.substring(0, length - 1);
                            }
                            return f8985c;
                        }
                    }
                    return "";
                } catch (Exception e2) {
                    com.xiaomi.a.a.a.c.a("failure to get ids: " + e2);
                    return "";
                }
            }
            return f8985c;
        }
        return "";
    }

    public static String h(Context context) {
        g(context);
        String str = "";
        if (TextUtils.isEmpty(f8985c)) {
            return "";
        }
        for (String str2 : f8985c.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (c(str2)) {
                str = str + ar.a(str2) + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
        }
        int length = str.length();
        return length > 0 ? str.substring(0, length - 1) : str;
    }

    public static synchronized String i(Context context) {
        synchronized (ii.class) {
            String str = f8987e;
            if (str != null) {
                return str;
            }
            String c2 = c(context);
            String b2 = b(context);
            String b3 = ar.b(c2 + b2);
            f8987e = b3;
            return b3;
        }
    }

    public static synchronized String j(Context context) {
        String b2;
        synchronized (ii.class) {
            String c2 = c(context);
            b2 = ar.b(c2 + ((String) null));
        }
        return b2;
    }

    public static String k(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    public static boolean l(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            return intExtra == 2 || intExtra == 5;
        }
        return false;
    }

    public static boolean m(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    private static String n(Context context) {
        int g2 = g();
        String e2 = e(context);
        while (TextUtils.isEmpty(e2)) {
            int i2 = g2 - 1;
            if (g2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused) {
            }
            e2 = e(context);
            g2 = i2;
        }
        return e2;
    }

    private static boolean o(Context context) {
        String packageName = context.getPackageName();
        if (jc.a() && f8990h.contains(packageName)) {
            return context.getPackageManager().checkPermission(PermissionConstants.PHONE_STATE, packageName) == 0 || context.getPackageManager().checkPermission("android.permission.READ_PRIVILEGED_PHONE_STATE", packageName) == 0;
        }
        return false;
    }

    private static boolean p(Context context) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            return true;
        }
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName(context.getPackageName(), "com.xiaomi.push.service.XMPushService");
        intent.setComponent(componentName);
        try {
            Bundle bundle = context.getPackageManager().getServiceInfo(componentName, 128).metaData;
            if (bundle != null) {
                String string = bundle.getString("supportGetAndroidID");
                if (TextUtils.isEmpty(string)) {
                    return true;
                }
                return Boolean.parseBoolean(string);
            }
        } catch (Exception unused) {
        }
        return true;
    }
}
