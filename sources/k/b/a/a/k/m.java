package k.b.a.a.k;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes4.dex */
public class m implements k.b.a.a.a, k.b.a.a.b {

    /* renamed from: c  reason: collision with root package name */
    private static final int f16063c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final int f16064d = 2;

    /* renamed from: e  reason: collision with root package name */
    private static final int f16065e = 4;

    /* renamed from: f  reason: collision with root package name */
    private static final int f16066f = 8;

    /* renamed from: g  reason: collision with root package name */
    private static final int f16067g = 16;

    /* renamed from: h  reason: collision with root package name */
    private static final int f16068h = 32;

    /* renamed from: i  reason: collision with root package name */
    private static final int f16069i = 64;

    /* renamed from: j  reason: collision with root package name */
    private static final int f16070j = 128;
    private static final char[] a = new char[0];
    private static final byte[] b = new byte[0];

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f16071k = {1, 2, 4, 8, 16, 32, 64, 128};

    public static byte[] a(byte[] bArr) {
        if (c(bArr)) {
            return b;
        }
        int length = bArr.length >> 3;
        byte[] bArr2 = new byte[length];
        int length2 = bArr.length - 1;
        int i2 = 0;
        while (i2 < length) {
            int i3 = 0;
            while (true) {
                int[] iArr = f16071k;
                if (i3 < iArr.length) {
                    if (bArr[length2 - i3] == 49) {
                        bArr2[i2] = (byte) (iArr[i3] | bArr2[i2]);
                    }
                    i3++;
                }
            }
            i2++;
            length2 -= 8;
        }
        return bArr2;
    }

    public static byte[] b(char[] cArr) {
        if (cArr != null && cArr.length != 0) {
            int length = cArr.length >> 3;
            byte[] bArr = new byte[length];
            int length2 = cArr.length - 1;
            int i2 = 0;
            while (i2 < length) {
                int i3 = 0;
                while (true) {
                    int[] iArr = f16071k;
                    if (i3 < iArr.length) {
                        if (cArr[length2 - i3] == '1') {
                            bArr[i2] = (byte) (iArr[i3] | bArr[i2]);
                        }
                        i3++;
                    }
                }
                i2++;
                length2 -= 8;
            }
            return bArr;
        }
        return b;
    }

    private static boolean c(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static byte[] d(byte[] bArr) {
        if (c(bArr)) {
            return b;
        }
        int length = bArr.length << 3;
        byte[] bArr2 = new byte[length];
        int i2 = length - 1;
        int i3 = 0;
        while (i3 < bArr.length) {
            int i4 = 0;
            while (true) {
                int[] iArr = f16071k;
                if (i4 < iArr.length) {
                    if ((iArr[i4] & bArr[i3]) == 0) {
                        bArr2[i2 - i4] = 48;
                    } else {
                        bArr2[i2 - i4] = 49;
                    }
                    i4++;
                }
            }
            i3++;
            i2 -= 8;
        }
        return bArr2;
    }

    public static char[] g(byte[] bArr) {
        if (c(bArr)) {
            return a;
        }
        int length = bArr.length << 3;
        char[] cArr = new char[length];
        int i2 = length - 1;
        int i3 = 0;
        while (i3 < bArr.length) {
            int i4 = 0;
            while (true) {
                int[] iArr = f16071k;
                if (i4 < iArr.length) {
                    if ((iArr[i4] & bArr[i3]) == 0) {
                        cArr[i2 - i4] = '0';
                    } else {
                        cArr[i2 - i4] = '1';
                    }
                    i4++;
                }
            }
            i3++;
            i2 -= 8;
        }
        return cArr;
    }

    public static String h(byte[] bArr) {
        return new String(g(bArr));
    }

    @Override // k.b.a.a.a
    public byte[] decode(byte[] bArr) {
        return a(bArr);
    }

    @Override // k.b.a.a.b
    public byte[] encode(byte[] bArr) {
        return d(bArr);
    }

    public byte[] i(String str) {
        if (str == null) {
            return b;
        }
        return b(str.toCharArray());
    }

    @Override // k.b.a.a.e
    public Object decode(Object obj) throws DecoderException {
        if (obj == null) {
            return b;
        }
        if (obj instanceof byte[]) {
            return a((byte[]) obj);
        }
        if (obj instanceof char[]) {
            return b((char[]) obj);
        }
        if (obj instanceof String) {
            return b(((String) obj).toCharArray());
        }
        throw new DecoderException("argument not a byte array");
    }

    @Override // k.b.a.a.f
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof byte[]) {
            return g((byte[]) obj);
        }
        throw new EncoderException("argument not a byte array");
    }
}
