package e.j.f.o;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import e.j.f.n;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* loaded from: classes2.dex */
public final class c implements n {
    private static e.j.f.q.b c(String str, BarcodeFormat barcodeFormat, int i2, int i3, Charset charset, int i4, int i5) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return d(e.j.f.o.e.c.e(str.getBytes(charset), i4, i5), i2, i3);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(barcodeFormat)));
    }

    private static e.j.f.q.b d(e.j.f.o.e.a aVar, int i2, int i3) {
        e.j.f.q.b c2 = aVar.c();
        if (c2 != null) {
            int n = c2.n();
            int j2 = c2.j();
            int max = Math.max(i2, n);
            int max2 = Math.max(i3, j2);
            int min = Math.min(max / n, max2 / j2);
            int i4 = (max - (n * min)) / 2;
            int i5 = (max2 - (j2 * min)) / 2;
            e.j.f.q.b bVar = new e.j.f.q.b(max, max2);
            int i6 = 0;
            while (i6 < j2) {
                int i7 = i4;
                int i8 = 0;
                while (i8 < n) {
                    if (c2.f(i8, i6)) {
                        bVar.s(i7, i5, min, min);
                    }
                    i8++;
                    i7 += min;
                }
                i6++;
                i5 += min;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }

    @Override // e.j.f.n
    public e.j.f.q.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) {
        Charset charset;
        int i4;
        int i5;
        Charset charset2 = StandardCharsets.ISO_8859_1;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType)) {
                charset2 = Charset.forName(map.get(encodeHintType).toString());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.ERROR_CORRECTION;
            int parseInt = map.containsKey(encodeHintType2) ? Integer.parseInt(map.get(encodeHintType2).toString()) : 33;
            EncodeHintType encodeHintType3 = EncodeHintType.AZTEC_LAYERS;
            if (map.containsKey(encodeHintType3)) {
                charset = charset2;
                i4 = parseInt;
                i5 = Integer.parseInt(map.get(encodeHintType3).toString());
                return c(str, barcodeFormat, i2, i3, charset, i4, i5);
            }
            charset = charset2;
            i4 = parseInt;
        } else {
            charset = charset2;
            i4 = 33;
        }
        i5 = 0;
        return c(str, barcodeFormat, i2, i3, charset, i4, i5);
    }

    @Override // e.j.f.n
    public e.j.f.q.b b(String str, BarcodeFormat barcodeFormat, int i2, int i3) {
        return a(str, barcodeFormat, i2, i3, null);
    }
}
