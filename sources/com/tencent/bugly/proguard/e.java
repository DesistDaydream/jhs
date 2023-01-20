package com.tencent.bugly.proguard;

import com.umeng.analytics.pro.cb;

/* loaded from: classes3.dex */
public final class e {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b = bArr[i2];
            int i3 = i2 * 2;
            char[] cArr2 = a;
            cArr[i3 + 1] = cArr2[b & cb.f7124m];
            cArr[i3] = cArr2[((byte) (b >>> 4)) & cb.f7124m];
        }
        return new String(cArr);
    }
}
