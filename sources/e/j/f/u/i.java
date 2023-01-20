package e.j.f.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class i extends y {
    private static final int a = 95;

    @Override // e.j.f.u.r, e.j.f.n
    public e.j.f.q.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_13) {
            return super.a(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // e.j.f.u.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + x.r(str);
            } catch (FormatException e2) {
                throw new IllegalArgumentException(e2);
            }
        } else if (length == 13) {
            try {
                if (!x.i(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got ".concat(String.valueOf(length)));
        }
        int i2 = h.f11638l[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int c2 = r.c(zArr, 0, x.f11657f, true) + 0;
        for (int i3 = 1; i3 <= 6; i3++) {
            int digit = Character.digit(str.charAt(i3), 10);
            if (((i2 >> (6 - i3)) & 1) == 1) {
                digit += 10;
            }
            c2 += r.c(zArr, c2, x.f11661j[digit], false);
        }
        int c3 = c2 + r.c(zArr, c2, x.f11658g, false);
        for (int i4 = 7; i4 <= 12; i4++) {
            c3 += r.c(zArr, c3, x.f11660i[Character.digit(str.charAt(i4), 10)], true);
        }
        r.c(zArr, c3, x.f11657f, true);
        return zArr;
    }
}
