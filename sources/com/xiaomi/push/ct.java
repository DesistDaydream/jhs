package com.xiaomi.push;

import android.content.Context;
import android.os.Build;

/* loaded from: classes3.dex */
public class ct {
    private static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    public static boolean a(Context context, String str, long j2) {
        if (com.xiaomi.push.service.ad.a(context).a(gv.DCJobMutualSwitch.a(), false)) {
            return (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && !k.a(context, str, j2);
        }
        return false;
    }

    public static byte[] a(String str, byte[] bArr) {
        byte[] b = ao.b(str);
        try {
            a(b);
            return hh.a(b, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] b = ao.b(str);
        try {
            a(b);
            return hh.b(b, bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
