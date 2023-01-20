package com.bytedance.pangle.res.a;

import java.io.EOFException;
import java.io.InputStream;
import java.util.Objects;

/* loaded from: classes.dex */
public final class d {
    private static <T> T a(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static void a(InputStream inputStream, byte[] bArr, int i2, int i3) {
        a(inputStream);
        a(bArr);
        int i4 = 0;
        if (i3 >= 0) {
            int i5 = i2 + i3;
            int length = bArr.length;
            if (i2 < 0 || i5 < i2 || i5 > length) {
                StringBuilder sb = new StringBuilder();
                sb.append(i2);
                sb.append(i5);
                sb.append(length);
                throw new IndexOutOfBoundsException(sb.toString());
            }
            while (i4 < i3) {
                int read = inputStream.read(bArr, i2 + i4, i3 - i4);
                if (read == -1) {
                    break;
                }
                i4 += read;
            }
            if (i4 == i3) {
                return;
            }
            throw new EOFException("reached end of stream after reading " + i4 + " bytes; " + i3 + " bytes expected");
        }
        throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i3)));
    }
}
