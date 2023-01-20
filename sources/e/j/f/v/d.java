package e.j.f.v;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.encoder.Compaction;
import e.j.f.n;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: classes2.dex */
public final class d implements n {
    private static final int a = 30;
    private static final int b = 2;

    private static e.j.f.q.b c(byte[][] bArr, int i2) {
        int i3 = i2 * 2;
        e.j.f.q.b bVar = new e.j.f.q.b(bArr[0].length + i3, bArr.length + i3);
        bVar.b();
        int j2 = (bVar.j() - i2) - 1;
        int i4 = 0;
        while (i4 < bArr.length) {
            byte[] bArr2 = bArr[i4];
            for (int i5 = 0; i5 < bArr[0].length; i5++) {
                if (bArr2[i5] == 1) {
                    bVar.r(i5 + i2, j2);
                }
            }
            i4++;
            j2--;
        }
        return bVar;
    }

    private static e.j.f.q.b d(e.j.f.v.g.d dVar, String str, int i2, int i3, int i4, int i5) throws WriterException {
        boolean z;
        dVar.e(str, i2);
        byte[][] c2 = dVar.f().c(1, 4);
        if ((i4 > i3) != (c2[0].length < c2.length)) {
            c2 = e(c2);
            z = true;
        } else {
            z = false;
        }
        int length = i3 / c2[0].length;
        int length2 = i4 / c2.length;
        if (length >= length2) {
            length = length2;
        }
        if (length > 1) {
            byte[][] c3 = dVar.f().c(length, length << 2);
            if (z) {
                c3 = e(c3);
            }
            return c(c3, i5);
        }
        return c(c2, i5);
    }

    private static byte[][] e(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance(byte.class, bArr[0].length, bArr.length);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int length = (bArr.length - i2) - 1;
            for (int i3 = 0; i3 < bArr[0].length; i3++) {
                bArr2[i3][length] = bArr[i2][i3];
            }
        }
        return bArr2;
    }

    @Override // e.j.f.n
    public e.j.f.q.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        int i4;
        int i5;
        if (barcodeFormat == BarcodeFormat.PDF_417) {
            e.j.f.v.g.d dVar = new e.j.f.v.g.d();
            if (map != null) {
                EncodeHintType encodeHintType = EncodeHintType.PDF417_COMPACT;
                if (map.containsKey(encodeHintType)) {
                    dVar.h(Boolean.valueOf(map.get(encodeHintType).toString()).booleanValue());
                }
                EncodeHintType encodeHintType2 = EncodeHintType.PDF417_COMPACTION;
                if (map.containsKey(encodeHintType2)) {
                    dVar.i(Compaction.valueOf(map.get(encodeHintType2).toString()));
                }
                EncodeHintType encodeHintType3 = EncodeHintType.PDF417_DIMENSIONS;
                if (map.containsKey(encodeHintType3)) {
                    e.j.f.v.g.c cVar = (e.j.f.v.g.c) map.get(encodeHintType3);
                    dVar.j(cVar.a(), cVar.c(), cVar.b(), cVar.d());
                }
                EncodeHintType encodeHintType4 = EncodeHintType.MARGIN;
                int parseInt = map.containsKey(encodeHintType4) ? Integer.parseInt(map.get(encodeHintType4).toString()) : 30;
                EncodeHintType encodeHintType5 = EncodeHintType.ERROR_CORRECTION;
                int parseInt2 = map.containsKey(encodeHintType5) ? Integer.parseInt(map.get(encodeHintType5).toString()) : 2;
                EncodeHintType encodeHintType6 = EncodeHintType.CHARACTER_SET;
                if (map.containsKey(encodeHintType6)) {
                    dVar.k(Charset.forName(map.get(encodeHintType6).toString()));
                }
                i5 = parseInt;
                i4 = parseInt2;
            } else {
                i4 = 2;
                i5 = 30;
            }
            return d(dVar, str, i4, i2, i3, i5);
        }
        throw new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // e.j.f.n
    public e.j.f.q.b b(String str, BarcodeFormat barcodeFormat, int i2, int i3) throws WriterException {
        return a(str, barcodeFormat, i2, i3, null);
    }
}
