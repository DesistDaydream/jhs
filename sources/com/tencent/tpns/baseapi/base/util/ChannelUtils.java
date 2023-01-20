package com.tencent.tpns.baseapi.base.util;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class ChannelUtils {
    public static Boolean isBrandXiaoMi;

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method declaredMethod = cls.getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(cls, str);
        } catch (Exception unused) {
            TBaseLogger.w("ChannelUtils", "unexpected for getSystemPropertiesKey:" + str);
            return "";
        }
    }

    public static String getMiuiVersionCode() {
        return a("ro.miui.ui.version.code");
    }

    public static String getMiuiVersionName() {
        return a("ro.miui.ui.version.name");
    }

    public static boolean isBrandBlackShark() {
        return "blackshark".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isBrandHonor() {
        return "honor".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isBrandHuaWei() {
        return "huawei".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isBrandMeiZu() {
        if (TextUtils.isEmpty(a("ro.meizu.product.model"))) {
            String str = Build.BRAND;
            if (!"meizu".equalsIgnoreCase(str) && !"meizu".equalsIgnoreCase(Build.MANUFACTURER) && !"22c4185e".equalsIgnoreCase(str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBrandPTAC() {
        return "ptac".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static synchronized boolean isBrandXiaoMi() {
        boolean booleanValue;
        synchronized (ChannelUtils.class) {
            if (isBrandXiaoMi == null) {
                isBrandXiaoMi = Boolean.valueOf("xiaomi".equalsIgnoreCase(Build.MANUFACTURER));
            }
            booleanValue = isBrandXiaoMi.booleanValue();
        }
        return booleanValue;
    }

    public static boolean isEmuiOrOhosVersion() {
        return (TextUtils.isEmpty(a("ro.build.version.emui")) && TextUtils.isEmpty(a("hw_sc.build.platform.version"))) ? false : true;
    }

    public static boolean isHonorVersionOver6() {
        String a = a("ro.build.version.magic");
        TBaseLogger.i("ChannelUtils", "get magicUi version: " + a);
        return "6.0".compareToIgnoreCase(a) <= 0;
    }

    public static boolean isMiuiV12() {
        return !TextUtils.isEmpty(getMiuiVersionName()) && "v12".compareTo(getMiuiVersionName().toLowerCase()) <= 0;
    }
}
