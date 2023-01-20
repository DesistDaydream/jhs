package com.tencent.qcloud.tuikit.tuichat.util;

import android.util.DisplayMetrics;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.util.TUIBuild;

/* loaded from: classes3.dex */
public class DeviceUtil {
    private static String[] huaweiAndHonorDevice = {"hwH60", "hwPE", "hwH30", "hwHol", "hwG750", "hw7D", "hwChe2"};

    public static int[] getScreenSize() {
        DisplayMetrics displayMetrics = TUIConfig.getAppContext().getResources().getDisplayMetrics();
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    public static boolean isHuaWeiOrHonor() {
        String device = TUIBuild.getDevice();
        int length = huaweiAndHonorDevice.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (huaweiAndHonorDevice[i2].equals(device)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isVivoX21() {
        return "vivo X21".equalsIgnoreCase(TUIBuild.getModel());
    }
}
