package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes2.dex */
public class q0 {
    public static boolean a(Context context) {
        return System.currentTimeMillis() - g0.a(context, "Privacy_MY", "flashKeyTime", -1L) > com.heytap.mcssdk.constant.a.f3317g;
    }

    public static boolean a(Context context, String str) {
        if (context == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
                y.f("hmsSdk", "not have read phone permission!");
                return true;
            }
            return false;
        } else if (context.checkSelfPermission(str) != 0) {
            y.f("hmsSdk", "not have read phone permission!");
            return true;
        } else {
            return false;
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean a(Context context, String str, int i2) {
        String str2 = g0.c(context, str) + ".xml";
        long length = new File(context.getFilesDir(), "../shared_prefs/" + str2).length();
        if (length > i2) {
            y.c("hmsSdk", String.format("reach local file limited size - file len: %d limitedSize: %d", Long.valueOf(length), Integer.valueOf(i2)));
            return true;
        }
        return false;
    }

    public static boolean a(String str, long j2, long j3) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return j2 - Long.parseLong(str) > j3;
        } catch (NumberFormatException unused) {
            y.f("hmsSdk", "isTimeExpired(): Data type conversion error : number format !");
            return true;
        }
    }
}
