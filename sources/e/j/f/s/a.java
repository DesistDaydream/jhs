package e.j.f.s;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import e.j.f.j;
import e.j.f.k;
import e.j.f.l;
import e.j.f.q.b;
import e.j.f.q.d;
import e.j.f.s.b.c;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a implements j {
    private static final l[] b = new l[0];

    /* renamed from: c  reason: collision with root package name */
    private static final int f11547c = 30;

    /* renamed from: d  reason: collision with root package name */
    private static final int f11548d = 33;
    private final c a = new c();

    private static b b(b bVar) throws NotFoundException {
        int[] h2 = bVar.h();
        if (h2 != null) {
            int i2 = h2[0];
            int i3 = h2[1];
            int i4 = h2[2];
            int i5 = h2[3];
            b bVar2 = new b(30, 33);
            for (int i6 = 0; i6 < 33; i6++) {
                int i7 = (((i6 * i5) + (i5 / 2)) / 33) + i3;
                for (int i8 = 0; i8 < 30; i8++) {
                    if (bVar.f(((((i8 * i4) + (i4 / 2)) + (((i6 & 1) * i4) / 2)) / 30) + i2, i7)) {
                        bVar2.r(i8, i6);
                    }
                }
            }
            return bVar2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // e.j.f.j
    public k a(e.j.f.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        if (map != null && map.containsKey(DecodeHintType.PURE_BARCODE)) {
            d c2 = this.a.c(b(bVar.b()), map);
            k kVar = new k(c2.j(), c2.g(), b, BarcodeFormat.MAXICODE);
            String b2 = c2.b();
            if (b2 != null) {
                kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, b2);
            }
            return kVar;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // e.j.f.j
    public k c(e.j.f.b bVar) throws NotFoundException, ChecksumException, FormatException {
        return a(bVar, null);
    }

    @Override // e.j.f.j
    public void reset() {
    }
}
