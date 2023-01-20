package e.j.f.q;

import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public final class e extends h {
    @Override // e.j.f.q.h
    public b c(b bVar, int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) throws NotFoundException {
        return d(bVar, i2, i3, j.b(f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17));
    }

    @Override // e.j.f.q.h
    public b d(b bVar, int i2, int i3, j jVar) throws NotFoundException {
        if (i2 > 0 && i3 > 0) {
            b bVar2 = new b(i2, i3);
            int i4 = i2 * 2;
            float[] fArr = new float[i4];
            for (int i5 = 0; i5 < i3; i5++) {
                float f2 = i5 + 0.5f;
                for (int i6 = 0; i6 < i4; i6 += 2) {
                    fArr[i6] = (i6 / 2) + 0.5f;
                    fArr[i6 + 1] = f2;
                }
                jVar.f(fArr);
                h.a(bVar, fArr);
                for (int i7 = 0; i7 < i4; i7 += 2) {
                    try {
                        if (bVar.f((int) fArr[i7], (int) fArr[i7 + 1])) {
                            bVar2.r(i7 / 2, i5);
                        }
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
            }
            return bVar2;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
