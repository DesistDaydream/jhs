package e.j.f.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class k extends y {
    private static final int a = 67;

    @Override // e.j.f.u.r, e.j.f.n
    public e.j.f.q.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_8) {
            return super.a(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // e.j.f.u.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + x.r(str);
            } catch (FormatException e2) {
                throw new IllegalArgumentException(e2);
            }
        } else if (length == 8) {
            try {
                if (!x.i(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length)));
        }
        boolean[] zArr = new boolean[67];
        int c2 = r.c(zArr, 0, x.f11657f, true) + 0;
        for (int i2 = 0; i2 <= 3; i2++) {
            c2 += r.c(zArr, c2, x.f11660i[Character.digit(str.charAt(i2), 10)], false);
        }
        int c3 = c2 + r.c(zArr, c2, x.f11658g, false);
        for (int i3 = 4; i3 <= 7; i3++) {
            c3 += r.c(zArr, c3, x.f11660i[Character.digit(str.charAt(i3), 10)], true);
        }
        r.c(zArr, c3, x.f11657f, true);
        return zArr;
    }
}
