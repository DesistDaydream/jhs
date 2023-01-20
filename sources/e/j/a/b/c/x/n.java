package e.j.a.b.c.x;

import com.umeng.analytics.pro.cb;

@e.j.a.b.c.m.a
@e.j.a.b.c.r.d0
/* loaded from: classes2.dex */
public class n {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @e.j.a.b.c.m.a
    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = b2 & 255;
            int i4 = i2 + 1;
            char[] cArr2 = b;
            cArr[i2] = cArr2[i3 >>> 4];
            i2 = i4 + 1;
            cArr[i4] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    @e.j.a.b.c.m.a
    public static String b(byte[] bArr) {
        return c(bArr, false);
    }

    @e.j.a.b.c.m.a
    public static String c(byte[] bArr, boolean z) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length << 1);
        for (int i2 = 0; i2 < length && (!z || i2 != length - 1 || (bArr[i2] & 255) != 0); i2++) {
            char[] cArr = a;
            sb.append(cArr[(bArr[i2] & 240) >>> 4]);
            sb.append(cArr[bArr[i2] & cb.f7124m]);
        }
        return sb.toString();
    }

    @e.j.a.b.c.m.a
    public static byte[] d(String str) throws IllegalArgumentException {
        int length = str.length();
        if (length % 2 == 0) {
            byte[] bArr = new byte[length / 2];
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 2;
                bArr[i2 / 2] = (byte) Integer.parseInt(str.substring(i2, i3), 16);
                i2 = i3;
            }
            return bArr;
        }
        throw new IllegalArgumentException("Hex string has odd number of characters");
    }
}
