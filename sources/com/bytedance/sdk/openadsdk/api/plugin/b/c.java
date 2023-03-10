package com.bytedance.sdk.openadsdk.api.plugin.b;

import java.util.Objects;

/* loaded from: classes.dex */
public class c {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        Objects.requireNonNull(bArr, "bytes is null");
        return a(bArr, 0, bArr.length);
    }

    public static String a(byte[] bArr, int i2, int i3) {
        Objects.requireNonNull(bArr, "bytes is null");
        if (i2 >= 0 && i2 + i3 <= bArr.length) {
            int i4 = i3 * 2;
            char[] cArr = new char[i4];
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = bArr[i6 + i2] & 255;
                int i8 = i5 + 1;
                char[] cArr2 = a;
                cArr[i5] = cArr2[i7 >> 4];
                i5 = i8 + 1;
                cArr[i8] = cArr2[i7 & 15];
            }
            return new String(cArr, 0, i4);
        }
        throw new IndexOutOfBoundsException();
    }
}
