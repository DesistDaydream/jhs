package e.j.f.t;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import e.j.f.j;
import e.j.f.k;
import e.j.f.l;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a implements j {
    private final j a;

    public a(j jVar) {
        this.a = jVar;
    }

    private static void b(l[] lVarArr, int i2, int i3) {
        if (lVarArr != null) {
            for (int i4 = 0; i4 < lVarArr.length; i4++) {
                l lVar = lVarArr[i4];
                lVarArr[i4] = new l(lVar.c() + i2, lVar.d() + i3);
            }
        }
    }

    @Override // e.j.f.j
    public k a(e.j.f.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int e2 = bVar.e() / 2;
        int d2 = bVar.d() / 2;
        try {
            try {
                try {
                    try {
                        return this.a.a(bVar.a(0, 0, e2, d2), map);
                    } catch (NotFoundException unused) {
                        k a = this.a.a(bVar.a(e2, 0, e2, d2), map);
                        b(a.f(), e2, 0);
                        return a;
                    }
                } catch (NotFoundException unused2) {
                    k a2 = this.a.a(bVar.a(0, d2, e2, d2), map);
                    b(a2.f(), 0, d2);
                    return a2;
                }
            } catch (NotFoundException unused3) {
                k a3 = this.a.a(bVar.a(e2, d2, e2, d2), map);
                b(a3.f(), e2, d2);
                return a3;
            }
        } catch (NotFoundException unused4) {
            int i2 = e2 / 2;
            int i3 = d2 / 2;
            k a4 = this.a.a(bVar.a(i2, i3, e2, d2), map);
            b(a4.f(), i2, i3);
            return a4;
        }
    }

    @Override // e.j.f.j
    public k c(e.j.f.b bVar) throws NotFoundException, ChecksumException, FormatException {
        return a(bVar, null);
    }

    @Override // e.j.f.j
    public void reset() {
        this.a.reset();
    }
}
