package com.huawei.agconnect.config.impl;

import com.umeng.analytics.pro.cb;

/* loaded from: classes2.dex */
public class Hex {
    private static final char[] HEX_CODE = "0123456789ABCDEF".toCharArray();

    private static byte[] decodeHex(char[] cArr) {
        if ((cArr.length & 1) == 0) {
            byte[] bArr = new byte[cArr.length >> 1];
            int i2 = 0;
            int i3 = 0;
            while (i2 < cArr.length) {
                int digit = Character.digit(cArr[i2], 16);
                if (digit == -1) {
                    throw new IllegalArgumentException("Illegal hexadecimal character at index " + i2);
                }
                int i4 = i2 + 1;
                int digit2 = Character.digit(cArr[i4], 16);
                if (digit2 == -1) {
                    throw new IllegalArgumentException("Illegal hexadecimal character at index " + i4);
                }
                i2 = i4 + 1;
                bArr[i3] = (byte) (((digit << 4) | digit2) & 255);
                i3++;
            }
            return bArr;
        }
        throw new IllegalArgumentException("Odd number of characters.");
    }

    public static byte[] decodeHexString(String str) {
        return decodeHex(str.toCharArray());
    }

    public static String encodeHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            char[] cArr = HEX_CODE;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & cb.f7124m]);
        }
        return sb.toString();
    }
}
