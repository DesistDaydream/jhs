package com.meizu.cloud.pushsdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes2.dex */
public class c {
    private static String a = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(a)) {
            a = !a() ? d(context) : b(context);
            return a;
        }
        return a;
    }

    public static boolean a() {
        String a2 = i.a("ro.target.product");
        if (TextUtils.isEmpty(a2)) {
            e.p.a.a.a.c("DeviceUtils", "current product is phone");
            return true;
        }
        e.p.a.a.a.c("DeviceUtils", "current product is " + a2);
        return false;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String b(Context context) {
        String deviceId;
        try {
            com.meizu.cloud.pushsdk.b.b.d a2 = com.meizu.cloud.pushsdk.b.b.a.a("android.telephony.MzTelephonyManager").a("getDeviceId", new Class[0]).a(new Object[0]);
            if (!a2.a || TextUtils.isEmpty((CharSequence) a2.b)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return null;
                }
                deviceId = telephonyManager.getDeviceId();
            } else {
                deviceId = (String) a2.b;
            }
            return deviceId;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String c(Context context) {
        return null;
    }

    private static String d(Context context) {
        StringBuilder sb = new StringBuilder();
        String str = Build.SERIAL;
        e.p.a.a.a.c("DeviceUtils", "device serial " + str);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            String c2 = c(context);
            e.p.a.a.a.f("DeviceUtils", "mac address " + c2);
            if (!TextUtils.isEmpty(c2)) {
                sb.append(c2.replace(Constants.COLON_SEPARATOR, "").toUpperCase());
                return sb.toString();
            }
        }
        return null;
    }
}
