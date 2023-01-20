package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import j.p0;

/* loaded from: classes.dex */
public class g {
    private static final byte[] a = {48, 75, 97, 106, 68, 55, 65, 90, 99, 70, 50, 81, 110, 80, 114, 53, 102, 119, 105, 72, 82, 78, 121, 103, 109, 117, 112, 85, 84, 73, 88, 120, 54, 57, 66, 87, 98, 45, 104, 77, 67, 71, 74, 111, 95, 86, 56, 69, 115, 107, 122, 49, 89, 100, 118, 76, 51, 52, 108, 101, 116, 113, 83, 79};
    private static final byte[] b = new byte[128];

    static {
        int i2 = 0;
        while (true) {
            byte[] bArr = a;
            if (i2 >= bArr.length) {
                return;
            }
            b[bArr[i2]] = (byte) i2;
            i2++;
        }
    }

    public static String b(String str) {
        if (str == null || str.length() < 4) {
            return null;
        }
        try {
            String str2 = new String(c(str));
            while (str2.endsWith("$")) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            return str2;
        } catch (Exception unused) {
            return "";
        }
    }

    private static byte[] c(String str) {
        byte[] bArr;
        if (d(str) || str == null || str.length() < 4) {
            return null;
        }
        if (str.charAt(str.length() - 2) == '$') {
            bArr = new byte[(((str.length() / 4) - 1) * 3) + 1];
        } else if (str.charAt(str.length() - 1) == '$') {
            bArr = new byte[(((str.length() / 4) - 1) * 3) + 2];
        } else {
            bArr = new byte[(str.length() / 4) * 3];
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length() - 4) {
            byte[] bArr2 = b;
            byte b2 = bArr2[str.charAt(i2)];
            byte b3 = bArr2[str.charAt(i2 + 1)];
            byte b4 = bArr2[str.charAt(i2 + 2)];
            byte b5 = bArr2[str.charAt(i2 + 3)];
            bArr[i3] = (byte) ((b2 << 2) | (b3 >> 4));
            bArr[i3 + 1] = (byte) ((b3 << 4) | (b4 >> 2));
            bArr[i3 + 2] = (byte) (b5 | (b4 << 6));
            i2 += 4;
            i3 += 3;
        }
        if (str.charAt(str.length() - 2) == '$') {
            byte[] bArr3 = b;
            byte b6 = bArr3[str.charAt(str.length() - 4)];
            bArr[bArr.length - 1] = (byte) ((bArr3[str.charAt(str.length() - 3)] >> 4) | (b6 << 2));
        } else if (str.charAt(str.length() - 1) == '$') {
            byte[] bArr4 = b;
            byte b7 = bArr4[str.charAt(str.length() - 4)];
            byte b8 = bArr4[str.charAt(str.length() - 3)];
            byte b9 = bArr4[str.charAt(str.length() - 2)];
            bArr[bArr.length - 2] = (byte) ((b7 << 2) | (b8 >> 4));
            bArr[bArr.length - 1] = (byte) ((b9 >> 2) | (b8 << 4));
        } else {
            byte[] bArr5 = b;
            byte b10 = bArr5[str.charAt(str.length() - 4)];
            byte b11 = bArr5[str.charAt(str.length() - 3)];
            byte b12 = bArr5[str.charAt(str.length() - 2)];
            byte b13 = bArr5[str.charAt(str.length() - 1)];
            bArr[bArr.length - 3] = (byte) ((b10 << 2) | (b11 >> 4));
            bArr[bArr.length - 2] = (byte) ((b11 << 4) | (b12 >> 2));
            bArr[bArr.length - 1] = (byte) (b13 | (b12 << 6));
        }
        return bArr;
    }

    private static boolean d(String str) {
        if (str == null) {
            return true;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (!a((byte) str.charAt(i2))) {
                return true;
            }
        }
        return false;
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (int length = str.getBytes().length % 3; length > 0 && length < 3; length++) {
            str = str + "$";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[(bytes.length / 3) * 4];
        int i2 = 0;
        int i3 = 0;
        while (i2 < bytes.length) {
            byte[] bArr2 = a;
            bArr[i3] = bArr2[(bytes[i2] & 252) >> 2];
            int i4 = i2 + 1;
            bArr[i3 + 1] = bArr2[((bytes[i2] & 3) << 4) + ((bytes[i4] & 240) >> 4)];
            int i5 = i2 + 2;
            bArr[i3 + 2] = bArr2[((bytes[i4] & com.umeng.analytics.pro.cb.f7124m) << 2) + ((bytes[i5] & 192) >> 6)];
            bArr[i3 + 3] = bArr2[bytes[i5] & p0.a];
            i2 += 3;
            i3 += 4;
        }
        return new String(bArr);
    }

    private static boolean a(byte b2) {
        if (b2 == 36) {
            return true;
        }
        return b2 >= 0 && b2 < 128 && b[b2] != -1;
    }
}
