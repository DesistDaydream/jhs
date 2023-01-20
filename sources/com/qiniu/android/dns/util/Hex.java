package com.qiniu.android.dns.util;

import com.umeng.analytics.pro.cb;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class Hex {
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* loaded from: classes3.dex */
    public static class HexDecodeException extends IOException {
        public HexDecodeException(String str) {
            super(str);
        }
    }

    public static byte[] decodeHex(char[] cArr) throws HexDecodeException {
        int length = cArr.length;
        if ((length & 1) == 0) {
            byte[] bArr = new byte[length >> 1];
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = i2 + 1;
                i2 = i4 + 1;
                bArr[i3] = (byte) (((toDigit(cArr[i2], i2) << 4) | toDigit(cArr[i4], i4)) & 255);
                i3++;
            }
            return bArr;
        }
        throw new HexDecodeException("Odd number of characters.");
    }

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, true);
    }

    public static String encodeHexString(byte[] bArr) {
        return new String(encodeHex(bArr));
    }

    public static int toDigit(char c2, int i2) throws HexDecodeException {
        int digit = Character.digit(c2, 16);
        if (digit != -1) {
            return digit;
        }
        throw new HexDecodeException("Illegal hexadecimal character " + c2 + " at index " + i2);
    }

    public static char[] encodeHex(byte[] bArr, boolean z) {
        return encodeHex(bArr, z ? DIGITS_LOWER : DIGITS_UPPER);
    }

    private static char[] encodeHex(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[length << 1];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            cArr2[i2] = cArr[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr2[i4] = cArr[bArr[i3] & cb.f7124m];
        }
        return cArr2;
    }
}
