package com.huawei.hms.push;

import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes2.dex */
public class c {
    public static byte[] a(Bundle bundle, String str) {
        try {
            byte[] byteArray = bundle.getByteArray(str);
            return byteArray == null ? new byte[0] : byteArray;
        } catch (Exception e2) {
            HMSLog.i("BundleUtil", "getByteArray exception" + e2.getMessage());
            return new byte[0];
        }
    }

    public static String b(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (Exception e2) {
            HMSLog.i("BundleUtil", "getString exception" + e2.getMessage());
            return null;
        }
    }

    public static String c(Bundle bundle, String str) {
        try {
            String string = bundle.getString(str);
            return string == null ? "" : string;
        } catch (Exception e2) {
            HMSLog.i("BundleUtil", "getString exception" + e2.getMessage());
            return "";
        }
    }
}
