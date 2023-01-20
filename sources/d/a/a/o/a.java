package d.a.a.o;

import com.moor.imkf.lib.jsoup.nodes.Attributes;

/* loaded from: classes.dex */
public class a {
    private static final char[] a = new char[64];
    private static final byte[] b;

    static {
        char c2 = 'A';
        int i2 = 0;
        while (c2 <= 'Z') {
            a[i2] = c2;
            c2 = (char) (c2 + 1);
            i2++;
        }
        char c3 = 'a';
        while (c3 <= 'z') {
            a[i2] = c3;
            c3 = (char) (c3 + 1);
            i2++;
        }
        char c4 = '0';
        while (c4 <= '9') {
            a[i2] = c4;
            c4 = (char) (c4 + 1);
            i2++;
        }
        char[] cArr = a;
        cArr[i2] = '+';
        cArr[i2 + 1] = Attributes.InternalPrefix;
        b = new byte[128];
        int i3 = 0;
        while (true) {
            byte[] bArr = b;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = -1;
            i3++;
        }
        for (int i4 = 0; i4 < 64; i4++) {
            b[a[i4]] = (byte) i4;
        }
    }

    public static char[] a(byte[] bArr) {
        return b(bArr, bArr.length);
    }

    public static char[] b(byte[] bArr, int i2) {
        int i3;
        int i4;
        int i5 = ((i2 * 4) + 2) / 3;
        char[] cArr = new char[((i2 + 2) / 3) * 4];
        int i6 = 0;
        int i7 = 0;
        while (i6 < i2) {
            int i8 = i6 + 1;
            int i9 = bArr[i6] & 255;
            if (i8 < i2) {
                i3 = bArr[i8] & 255;
                i8++;
            } else {
                i3 = 0;
            }
            if (i8 < i2) {
                i4 = bArr[i8] & 255;
                i8++;
            } else {
                i4 = 0;
            }
            int i10 = i9 >>> 2;
            int i11 = ((i9 & 3) << 4) | (i3 >>> 4);
            int i12 = ((i3 & 15) << 2) | (i4 >>> 6);
            int i13 = i7 + 1;
            char[] cArr2 = a;
            cArr[i7] = cArr2[i10];
            int i14 = i13 + 1;
            cArr[i13] = cArr2[i11];
            char c2 = '=';
            cArr[i14] = i14 < i5 ? cArr2[i12] : '=';
            int i15 = i14 + 1;
            int i16 = i4 & 63;
            if (i15 < i5) {
                c2 = cArr2[i16];
            }
            cArr[i15] = c2;
            i7 = i15 + 1;
            i6 = i8;
        }
        return cArr;
    }
}
