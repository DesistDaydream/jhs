package e.j.f.r;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.datamatrix.detector.Detector;
import e.j.f.j;
import e.j.f.k;
import e.j.f.l;
import e.j.f.q.d;
import e.j.f.q.f;
import e.j.f.r.c.c;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a implements j {
    private static final l[] b = new l[0];
    private final c a = new c();

    private static e.j.f.q.b b(e.j.f.q.b bVar) throws NotFoundException {
        int[] m2 = bVar.m();
        int[] g2 = bVar.g();
        if (m2 != null && g2 != null) {
            int d2 = d(m2, bVar);
            int i2 = m2[1];
            int i3 = g2[1];
            int i4 = m2[0];
            int i5 = ((g2[0] - i4) + 1) / d2;
            int i6 = ((i3 - i2) + 1) / d2;
            if (i5 > 0 && i6 > 0) {
                int i7 = d2 / 2;
                int i8 = i2 + i7;
                int i9 = i4 + i7;
                e.j.f.q.b bVar2 = new e.j.f.q.b(i5, i6);
                for (int i10 = 0; i10 < i6; i10++) {
                    int i11 = (i10 * d2) + i8;
                    for (int i12 = 0; i12 < i5; i12++) {
                        if (bVar.f((i12 * d2) + i9, i11)) {
                            bVar2.r(i12, i10);
                        }
                    }
                }
                return bVar2;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int d(int[] iArr, e.j.f.q.b bVar) throws NotFoundException {
        int n = bVar.n();
        int i2 = iArr[0];
        int i3 = iArr[1];
        while (i2 < n && bVar.f(i2, i3)) {
            i2++;
        }
        if (i2 != n) {
            int i4 = i2 - iArr[0];
            if (i4 != 0) {
                return i4;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // e.j.f.j
    public k a(e.j.f.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        l[] b2;
        d dVar;
        if (map != null && map.containsKey(DecodeHintType.PURE_BARCODE)) {
            dVar = this.a.b(b(bVar.b()));
            b2 = b;
        } else {
            f c2 = new Detector(bVar.b()).c();
            d b3 = this.a.b(c2.a());
            b2 = c2.b();
            dVar = b3;
        }
        k kVar = new k(dVar.j(), dVar.g(), b2, BarcodeFormat.DATA_MATRIX);
        List<byte[]> a = dVar.a();
        if (a != null) {
            kVar.j(ResultMetadataType.BYTE_SEGMENTS, a);
        }
        String b4 = dVar.b();
        if (b4 != null) {
            kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, b4);
        }
        return kVar;
    }

    @Override // e.j.f.j
    public k c(e.j.f.b bVar) throws NotFoundException, ChecksumException, FormatException {
        return a(bVar, null);
    }

    @Override // e.j.f.j
    public void reset() {
    }
}
