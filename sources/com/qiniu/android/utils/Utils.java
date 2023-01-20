package com.qiniu.android.utils;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public class Utils {
    private static Boolean isDebug;

    public static Long calculateSpeed(Long l2, Long l3) {
        if (l2 == null || l2.longValue() < 0 || l3 == null || l3.longValue() == 0) {
            return null;
        }
        return Long.valueOf((l2.longValue() * 1000) / l3.longValue());
    }

    public static long currentSecondTimestamp() {
        return currentTimestamp() / 1000;
    }

    public static long currentTimestamp() {
        return new Date().getTime();
    }

    public static long dateDuration(Date date, Date date2) {
        if (date == null || date2 == null) {
            return 0L;
        }
        return date2.getTime() - date.getTime();
    }

    private static String deviceName(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (lowerCase.startsWith("unknown") || lowerCase.startsWith("alps") || lowerCase.startsWith(com.effective.android.panel.Constants.ANDROID) || lowerCase.startsWith("sprd") || lowerCase.startsWith("spreadtrum") || lowerCase.startsWith("rockchip") || lowerCase.startsWith("wondermedia") || lowerCase.startsWith("mtk") || lowerCase.startsWith("mt65") || lowerCase.startsWith("nvidia") || lowerCase.startsWith("brcm") || lowerCase.startsWith("marvell") || str2.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
            return null;
        }
        return str;
    }

    public static String formEscape(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    public static String getCurrentNetworkType() {
        Context applicationContext = ContextGetter.applicationContext();
        return applicationContext == null ? "" : AndroidNetwork.networkType(applicationContext);
    }

    public static Integer getCurrentProcessID() {
        return Integer.valueOf(Process.myPid());
    }

    public static Integer getCurrentSignalStrength() {
        return null;
    }

    public static Long getCurrentThreadID() {
        return Long.valueOf(Thread.currentThread().getId());
    }

    private static String getIPV4StringType(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = null;
        String[] split = str.split("\\.");
        if (split.length == 4) {
            str3 = Integer.parseInt(split[0]) + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + Integer.parseInt(split[1]);
        }
        return str2 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3;
    }

    private static String getIPV6StringType(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        String[] split = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        String[] strArr = {"0000", "0000", "0000", "0000", "0000", "0000", "0000", "0000"};
        String[] strArr2 = {"0000", "000", "00", "0", ""};
        int i2 = 0;
        while (i2 < split.length) {
            String str3 = split[i2];
            if (str3.length() <= 0) {
                break;
            }
            strArr[i2] = strArr2[str3.length()] + str3;
            i2++;
        }
        int length = split.length - 1;
        int i3 = 7;
        while (i2 < length) {
            String str4 = split[length];
            if (str4.length() <= 0) {
                break;
            }
            strArr[i3] = strArr2[str4.length()] + str4;
            length += -1;
            i3 += -1;
        }
        return str2 + "-ipv6-" + StringUtils.join((String[]) Arrays.copyOfRange(strArr, 0, 4), com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
    }

    public static String getIpType(String str, String str2) {
        if (str == null || str.length() == 0) {
            return str2;
        }
        if (str.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
            return getIPV6StringType(str, str2);
        }
        return str.contains(".") ? getIPV4StringType(str, str2) : str2;
    }

    public static boolean isDebug() {
        Boolean bool = isDebug;
        if (bool != null) {
            return bool.booleanValue();
        }
        Context applicationContext = ContextGetter.applicationContext();
        if (applicationContext == null) {
            return false;
        }
        try {
            Boolean valueOf = Boolean.valueOf((applicationContext.getApplicationInfo().flags & 2) != 0);
            isDebug = valueOf;
            return valueOf.booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isIpv6(String str) {
        if (StringUtils.isNullOrEmpty(str)) {
            return false;
        }
        return IPAddressUtil.isIPv6LiteralAddress(str);
    }

    public static String sdkDirectory() {
        Context applicationContext = ContextGetter.applicationContext();
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getCacheDir().getAbsolutePath() + "/qiniu";
    }

    public static String sdkLanguage() {
        return "Android";
    }

    public static String sdkVerion() {
        return com.qiniu.android.common.Constants.VERSION;
    }

    public static String systemName() {
        try {
            String str = Build.MODEL;
            String trim = str != null ? str.trim() : "";
            String deviceName = deviceName(Build.MANUFACTURER.trim(), trim);
            if (TextUtils.isEmpty(deviceName)) {
                deviceName = deviceName(Build.BRAND.trim(), trim);
            }
            String str2 = Build.VERSION.SDK;
            String str3 = str2 != null ? str2 : "";
            return deviceName + MqttTopic.TOPIC_LEVEL_SEPARATOR + trim + MqttTopic.TOPIC_LEVEL_SEPARATOR + str3;
        } catch (Throwable unused) {
            return com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    public static String systemVersion() {
        try {
            String str = Build.VERSION.RELEASE;
            return str == null ? com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER : StringUtils.strip(str.trim());
        } catch (Throwable unused) {
            return com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }
}
