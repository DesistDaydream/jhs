package com.qiniu.android.utils;

import java.io.IOException;

/* loaded from: classes3.dex */
public class BytesUtils {
    public static byte[] subBytes(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 + i2 <= bArr.length) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            return bArr2;
        }
        throw new IOException("copy bytes out of range");
    }
}
