package e.j.f.w;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import e.j.f.j;
import e.j.f.k;
import e.j.f.l;
import e.j.f.q.f;
import e.j.f.w.c.d;
import e.j.f.w.d.c;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class a implements j {
    private static final l[] b = new l[0];
    private final d a = new d();

    private static e.j.f.q.b e(e.j.f.q.b bVar) throws NotFoundException {
        int[] m2 = bVar.m();
        int[] g2 = bVar.g();
        if (m2 != null && g2 != null) {
            float g3 = g(m2, bVar);
            int i2 = m2[1];
            int i3 = g2[1];
            int i4 = m2[0];
            int i5 = g2[0];
            if (i4 < i5 && i2 < i3) {
                int i6 = i3 - i2;
                if (i6 != i5 - i4 && (i5 = i4 + i6) >= bVar.n()) {
                    throw NotFoundException.getNotFoundInstance();
                }
                int round = Math.round(((i5 - i4) + 1) / g3);
                int round2 = Math.round((i6 + 1) / g3);
                if (round <= 0 || round2 <= 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (round2 == round) {
                    int i7 = (int) (g3 / 2.0f);
                    int i8 = i2 + i7;
                    int i9 = i4 + i7;
                    int i10 = (((int) ((round - 1) * g3)) + i9) - i5;
                    if (i10 > 0) {
                        if (i10 > i7) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        i9 -= i10;
                    }
                    int i11 = (((int) ((round2 - 1) * g3)) + i8) - i3;
                    if (i11 > 0) {
                        if (i11 > i7) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        i8 -= i11;
                    }
                    e.j.f.q.b bVar2 = new e.j.f.q.b(round, round2);
                    for (int i12 = 0; i12 < round2; i12++) {
                        int i13 = ((int) (i12 * g3)) + i8;
                        for (int i14 = 0; i14 < round; i14++) {
                            if (bVar.f(((int) (i14 * g3)) + i9, i13)) {
                                bVar2.r(i14, i12);
                            }
                        }
                    }
                    return bVar2;
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static float g(int[] iArr, e.j.f.q.b bVar) throws NotFoundException {
        int j2 = bVar.j();
        int n = bVar.n();
        int i2 = iArr[0];
        boolean z = true;
        int i3 = iArr[1];
        int i4 = 0;
        while (i2 < n && i3 < j2) {
            if (z != bVar.f(i2, i3)) {
                i4++;
                if (i4 == 5) {
                    break;
                }
                z = !z;
            }
            i2++;
            i3++;
        }
        if (i2 != n && i3 != j2) {
            return (i2 - iArr[0]) / 7.0f;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // e.j.f.j
    public final k a(e.j.f.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        l[] b2;
        e.j.f.q.d dVar;
        if (map != null && map.containsKey(DecodeHintType.PURE_BARCODE)) {
            dVar = this.a.c(e(bVar.b()), map);
            b2 = b;
        } else {
            f f2 = new c(bVar.b()).f(map);
            e.j.f.q.d c2 = this.a.c(f2.a(), map);
            b2 = f2.b();
            dVar = c2;
        }
        if (dVar.f() instanceof e.j.f.w.c.f) {
            ((e.j.f.w.c.f) dVar.f()).a(b2);
        }
        k kVar = new k(dVar.j(), dVar.g(), b2, BarcodeFormat.QR_CODE);
        List<byte[]> a = dVar.a();
        if (a != null) {
            kVar.j(ResultMetadataType.BYTE_SEGMENTS, a);
        }
        String b3 = dVar.b();
        if (b3 != null) {
            kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, b3);
        }
        if (dVar.k()) {
            kVar.j(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(dVar.i()));
            kVar.j(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(dVar.h()));
        }
        return kVar;
    }

    @Override // e.j.f.j
    public k c(e.j.f.b bVar) throws NotFoundException, ChecksumException, FormatException {
        return a(bVar, null);
    }

    public final d f() {
        return this.a;
    }

    @Override // e.j.f.j
    public void reset() {
    }
}
