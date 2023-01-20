package e.j.f.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* loaded from: classes2.dex */
public class g extends r {
    @Deprecated
    public static int c(boolean[] zArr, int i2, int[] iArr, boolean z) {
        return g(zArr, i2, iArr);
    }

    private static int g(boolean[] zArr, int i2, int[] iArr) {
        int length = iArr.length;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i2 + 1;
            zArr[i2] = iArr[i3] != 0;
            i3++;
            i2 = i4;
        }
        return 9;
    }

    private static int h(String str, int i2) {
        int i3 = 0;
        int i4 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i3 += f.f11634c.indexOf(str.charAt(length)) * i4;
            i4++;
            if (i4 > i2) {
                i4 = 1;
            }
        }
        return i3 % 47;
    }

    private static void i(int i2, int[] iArr) {
        for (int i3 = 0; i3 < 9; i3++) {
            int i4 = 1;
            if (((1 << (8 - i3)) & i2) == 0) {
                i4 = 0;
            }
            iArr[i3] = i4;
        }
    }

    @Override // e.j.f.u.r, e.j.f.n
    public e.j.f.q.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_93) {
            return super.a(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // e.j.f.u.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            i(f.f11636e[47], iArr);
            boolean[] zArr = new boolean[((str.length() + 2 + 2) * 9) + 1];
            int g2 = g(zArr, 0, iArr);
            for (int i2 = 0; i2 < length; i2++) {
                i(f.f11636e[f.f11634c.indexOf(str.charAt(i2))], iArr);
                g2 += g(zArr, g2, iArr);
            }
            int h2 = h(str, 20);
            int[] iArr2 = f.f11636e;
            i(iArr2[h2], iArr);
            int g3 = g2 + g(zArr, g2, iArr);
            i(iArr2[h(str + f.f11634c.charAt(h2), 15)], iArr);
            int g4 = g3 + g(zArr, g3, iArr);
            i(iArr2[47], iArr);
            zArr[g4 + g(zArr, g4, iArr)] = true;
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
    }
}
