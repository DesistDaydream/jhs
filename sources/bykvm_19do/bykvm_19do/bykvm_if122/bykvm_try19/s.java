package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes.dex */
public class s {
    public static int a(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith("network_ad_num_")) {
                return Integer.valueOf(str.substring(15)).intValue();
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public static String a(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            sb.append(iArr[i2]);
            if (i2 != iArr.length - 1) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        return sb.toString();
    }
}
