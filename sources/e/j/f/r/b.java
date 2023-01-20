package e.j.f.r;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import e.j.f.c;
import e.j.f.n;
import e.j.f.r.d.e;
import e.j.f.r.d.i;
import e.j.f.r.d.j;
import e.j.f.r.d.k;
import java.util.Map;

/* loaded from: classes2.dex */
public final class b implements n {
    private static e.j.f.q.b c(e.j.f.w.e.b bVar, int i2, int i3) {
        e.j.f.q.b bVar2;
        int e2 = bVar.e();
        int d2 = bVar.d();
        int max = Math.max(i2, e2);
        int max2 = Math.max(i3, d2);
        int min = Math.min(max / e2, max2 / d2);
        int i4 = (max - (e2 * min)) / 2;
        int i5 = (max2 - (d2 * min)) / 2;
        if (i3 >= d2 && i2 >= e2) {
            bVar2 = new e.j.f.q.b(i2, i3);
        } else {
            bVar2 = new e.j.f.q.b(e2, d2);
            i4 = 0;
            i5 = 0;
        }
        bVar2.b();
        int i6 = 0;
        while (i6 < d2) {
            int i7 = i4;
            int i8 = 0;
            while (i8 < e2) {
                if (bVar.b(i8, i6) == 1) {
                    bVar2.s(i7, i5, min, min);
                }
                i8++;
                i7 += min;
            }
            i6++;
            i5 += min;
        }
        return bVar2;
    }

    private static e.j.f.q.b d(e eVar, k kVar, int i2, int i3) {
        int i4 = kVar.i();
        int h2 = kVar.h();
        e.j.f.w.e.b bVar = new e.j.f.w.e.b(kVar.k(), kVar.j());
        int i5 = 0;
        for (int i6 = 0; i6 < h2; i6++) {
            if (i6 % kVar.f11543e == 0) {
                int i7 = 0;
                for (int i8 = 0; i8 < kVar.k(); i8++) {
                    bVar.h(i7, i5, i8 % 2 == 0);
                    i7++;
                }
                i5++;
            }
            int i9 = 0;
            for (int i10 = 0; i10 < i4; i10++) {
                if (i10 % kVar.f11542d == 0) {
                    bVar.h(i9, i5, true);
                    i9++;
                }
                bVar.h(i9, i5, eVar.e(i10, i6));
                i9++;
                int i11 = kVar.f11542d;
                if (i10 % i11 == i11 - 1) {
                    bVar.h(i9, i5, i6 % 2 == 0);
                    i9++;
                }
            }
            i5++;
            int i12 = kVar.f11543e;
            if (i6 % i12 == i12 - 1) {
                int i13 = 0;
                for (int i14 = 0; i14 < kVar.k(); i14++) {
                    bVar.h(i13, i5, true);
                    i13++;
                }
                i5++;
            }
        }
        return c(bVar, i2, i3);
    }

    @Override // e.j.f.n
    public e.j.f.q.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) {
        c cVar;
        if (!str.isEmpty()) {
            if (barcodeFormat == BarcodeFormat.DATA_MATRIX) {
                if (i2 >= 0 && i3 >= 0) {
                    SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
                    c cVar2 = null;
                    if (map != null) {
                        SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
                        if (symbolShapeHint2 != null) {
                            symbolShapeHint = symbolShapeHint2;
                        }
                        c cVar3 = (c) map.get(EncodeHintType.MIN_SIZE);
                        if (cVar3 == null) {
                            cVar3 = null;
                        }
                        cVar = (c) map.get(EncodeHintType.MAX_SIZE);
                        if (cVar == null) {
                            cVar = null;
                        }
                        cVar2 = cVar3;
                    } else {
                        cVar = null;
                    }
                    String c2 = j.c(str, symbolShapeHint, cVar2, cVar);
                    k o = k.o(c2.length(), symbolShapeHint, cVar2, cVar, true);
                    e eVar = new e(i.c(c2, o), o.i(), o.h());
                    eVar.k();
                    return d(eVar, o, i2, i3);
                }
                throw new IllegalArgumentException("Requested dimensions can't be negative: " + i2 + 'x' + i3);
            }
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(barcodeFormat)));
        }
        throw new IllegalArgumentException("Found empty contents");
    }

    @Override // e.j.f.n
    public e.j.f.q.b b(String str, BarcodeFormat barcodeFormat, int i2, int i3) {
        return a(str, barcodeFormat, i2, i3, null);
    }
}
