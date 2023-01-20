package d.a.a.e;

import j.p0;

/* loaded from: classes.dex */
public class b {
    private static final byte[] a = new byte[256];

    static {
        for (int i2 = 0; i2 < 256; i2++) {
            a[i2] = -1;
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            a[i3] = (byte) (i3 - 65);
        }
        for (int i4 = 97; i4 <= 122; i4++) {
            a[i4] = (byte) ((i4 + 26) - 97);
        }
        for (int i5 = 48; i5 <= 57; i5++) {
            a[i5] = (byte) ((i5 + 52) - 48);
        }
        byte[] bArr = a;
        bArr[43] = 62;
        bArr[47] = p0.a;
    }

    public static byte[] a(String str) {
        return b(str.toCharArray());
    }

    public static byte[] b(char[] cArr) {
        int length = cArr.length;
        for (char c2 : cArr) {
            if (c2 > 255 || a[c2] < 0) {
                length--;
            }
        }
        int i2 = (length / 4) * 3;
        int i3 = length % 4;
        if (i3 == 3) {
            i2 += 2;
        }
        if (i3 == 2) {
            i2++;
        }
        byte[] bArr = new byte[i2];
        int length2 = cArr.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length2; i7++) {
            char c3 = cArr[i7];
            byte b = c3 > 255 ? (byte) -1 : a[c3];
            if (b >= 0) {
                i6 += 6;
                i5 = (i5 << 6) | b;
                if (i6 >= 8) {
                    i6 -= 8;
                    bArr[i4] = (byte) ((i5 >> i6) & 255);
                    i4++;
                }
            }
        }
        if (i4 == i2) {
            return bArr;
        }
        throw new Error("Miscalculated data length (wrote " + i4 + " instead of " + i2 + ")");
    }
}
