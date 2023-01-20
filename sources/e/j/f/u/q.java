package e.j.f.u;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class q implements e.j.f.j {
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d A[Catch: ReaderException -> 0x00c6, TryCatch #0 {ReaderException -> 0x00c6, blocks: (B:39:0x0077, B:41:0x007d, B:43:0x008e), top: B:62:0x0077 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00c5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private e.j.f.k d(e.j.f.b r22, java.util.Map<com.google.zxing.DecodeHintType, ?> r23) throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.f.u.q.d(e.j.f.b, java.util.Map):e.j.f.k");
    }

    public static float e(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = i2;
        float f4 = f3 / i3;
        float f5 = f2 * f4;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            float f7 = iArr2[i5] * f4;
            float f8 = iArr[i5];
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }

    public static void f(e.j.f.q.a aVar, int i2, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i3 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int n = aVar.n();
        if (i2 < n) {
            boolean z = !aVar.j(i2);
            while (i2 < n) {
                if (aVar.j(i2) == z) {
                    i3++;
                    if (i3 == length) {
                        break;
                    }
                    iArr[i3] = 1;
                    z = !z;
                } else {
                    iArr[i3] = iArr[i3] + 1;
                }
                i2++;
            }
            if (i3 != length) {
                if (i3 != length - 1 || i2 != n) {
                    throw NotFoundException.getNotFoundInstance();
                }
                return;
            }
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static void g(e.j.f.q.a aVar, int i2, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean j2 = aVar.j(i2);
        while (i2 > 0 && length >= 0) {
            i2--;
            if (aVar.j(i2) != j2) {
                length--;
                j2 = !j2;
            }
        }
        if (length < 0) {
            f(aVar, i2 + 1, iArr);
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // e.j.f.j
    public e.j.f.k a(e.j.f.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        try {
            return d(bVar, map);
        } catch (NotFoundException e2) {
            if ((map != null && map.containsKey(DecodeHintType.TRY_HARDER)) && bVar.g()) {
                e.j.f.b h2 = bVar.h();
                e.j.f.k d2 = d(h2, map);
                Map<ResultMetadataType, Object> e3 = d2.e();
                int i2 = 270;
                if (e3 != null) {
                    ResultMetadataType resultMetadataType = ResultMetadataType.ORIENTATION;
                    if (e3.containsKey(resultMetadataType)) {
                        i2 = (((Integer) e3.get(resultMetadataType)).intValue() + 270) % 360;
                    }
                }
                d2.j(ResultMetadataType.ORIENTATION, Integer.valueOf(i2));
                e.j.f.l[] f2 = d2.f();
                if (f2 != null) {
                    int d3 = h2.d();
                    for (int i3 = 0; i3 < f2.length; i3++) {
                        f2[i3] = new e.j.f.l((d3 - f2[i3].d()) - 1.0f, f2[i3].c());
                    }
                }
                return d2;
            }
            throw e2;
        }
    }

    public abstract e.j.f.k b(int i2, e.j.f.q.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    @Override // e.j.f.j
    public e.j.f.k c(e.j.f.b bVar) throws NotFoundException, FormatException {
        return a(bVar, null);
    }

    @Override // e.j.f.j
    public void reset() {
    }
}
