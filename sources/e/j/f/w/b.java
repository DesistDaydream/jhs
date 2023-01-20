package e.j.f.w;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import e.j.f.n;
import e.j.f.w.e.c;
import e.j.f.w.e.f;
import java.util.Map;

/* loaded from: classes2.dex */
public final class b implements n {
    private static final int a = 4;

    private static e.j.f.q.b c(f fVar, int i2, int i3, int i4) {
        e.j.f.w.e.b c2 = fVar.c();
        if (c2 != null) {
            int e2 = c2.e();
            int d2 = c2.d();
            int i5 = i4 << 1;
            int i6 = e2 + i5;
            int i7 = i5 + d2;
            int max = Math.max(i2, i6);
            int max2 = Math.max(i3, i7);
            int min = Math.min(max / i6, max2 / i7);
            int i8 = (max - (e2 * min)) / 2;
            int i9 = (max2 - (d2 * min)) / 2;
            e.j.f.q.b bVar = new e.j.f.q.b(max, max2);
            int i10 = 0;
            while (i10 < d2) {
                int i11 = i8;
                int i12 = 0;
                while (i12 < e2) {
                    if (c2.b(i12, i10) == 1) {
                        bVar.s(i11, i9, min, min);
                    }
                    i12++;
                    i11 += min;
                }
                i10++;
                i9 += min;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }

    @Override // e.j.f.n
    public e.j.f.q.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (!str.isEmpty()) {
            if (barcodeFormat == BarcodeFormat.QR_CODE) {
                if (i2 >= 0 && i3 >= 0) {
                    ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
                    int i4 = 4;
                    if (map != null) {
                        EncodeHintType encodeHintType = EncodeHintType.ERROR_CORRECTION;
                        if (map.containsKey(encodeHintType)) {
                            errorCorrectionLevel = ErrorCorrectionLevel.valueOf(map.get(encodeHintType).toString());
                        }
                        EncodeHintType encodeHintType2 = EncodeHintType.MARGIN;
                        if (map.containsKey(encodeHintType2)) {
                            i4 = Integer.parseInt(map.get(encodeHintType2).toString());
                        }
                    }
                    return c(c.p(str, errorCorrectionLevel, map), i2, i3, i4);
                }
                throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
            }
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(barcodeFormat)));
        }
        throw new IllegalArgumentException("Found empty contents");
    }

    @Override // e.j.f.n
    public e.j.f.q.b b(String str, BarcodeFormat barcodeFormat, int i2, int i3) throws WriterException {
        return a(str, barcodeFormat, i2, i3, null);
    }
}
