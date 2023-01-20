package e.j.f.v.e.j;

import com.google.zxing.ChecksumException;

/* loaded from: classes2.dex */
public final class a {
    private final b a = b.f11704f;

    private int[] b(c cVar) throws ChecksumException {
        int e2 = cVar.e();
        int[] iArr = new int[e2];
        int i2 = 0;
        for (int i3 = 1; i3 < this.a.e() && i2 < e2; i3++) {
            if (cVar.b(i3) == 0) {
                iArr[i2] = this.a.g(i3);
                i2++;
            }
        }
        if (i2 == e2) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    private int[] c(c cVar, c cVar2, int[] iArr) {
        int e2 = cVar2.e();
        int[] iArr2 = new int[e2];
        for (int i2 = 1; i2 <= e2; i2++) {
            iArr2[e2 - i2] = this.a.i(i2, cVar2.c(i2));
        }
        c cVar3 = new c(this.a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            int g2 = this.a.g(iArr[i3]);
            iArr3[i3] = this.a.i(this.a.j(0, cVar.b(g2)), this.a.g(cVar3.b(g2)));
        }
        return iArr3;
    }

    private c[] d(c cVar, c cVar2, int i2) throws ChecksumException {
        if (cVar.e() < cVar2.e()) {
            cVar2 = cVar;
            cVar = cVar2;
        }
        c f2 = this.a.f();
        c d2 = this.a.d();
        while (true) {
            c cVar3 = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
            c cVar4 = d2;
            c cVar5 = f2;
            f2 = cVar4;
            if (cVar.e() >= i2 / 2) {
                if (!cVar.f()) {
                    c f3 = this.a.f();
                    int g2 = this.a.g(cVar.c(cVar.e()));
                    while (cVar2.e() >= cVar.e() && !cVar2.f()) {
                        int e2 = cVar2.e() - cVar.e();
                        int i3 = this.a.i(cVar2.c(cVar2.e()), g2);
                        f3 = f3.a(this.a.b(e2, i3));
                        cVar2 = cVar2.k(cVar.i(e2, i3));
                    }
                    d2 = f3.h(f2).k(cVar5).j();
                } else {
                    throw ChecksumException.getChecksumInstance();
                }
            } else {
                int c2 = f2.c(0);
                if (c2 != 0) {
                    int g3 = this.a.g(c2);
                    return new c[]{f2.g(g3), cVar.g(g3)};
                }
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    public int a(int[] iArr, int i2, int[] iArr2) throws ChecksumException {
        c cVar = new c(this.a, iArr);
        int[] iArr3 = new int[i2];
        boolean z = false;
        for (int i3 = i2; i3 > 0; i3--) {
            int b = cVar.b(this.a.c(i3));
            iArr3[i2 - i3] = b;
            if (b != 0) {
                z = true;
            }
        }
        if (z) {
            c d2 = this.a.d();
            if (iArr2 != null) {
                for (int i4 : iArr2) {
                    int c2 = this.a.c((iArr.length - 1) - i4);
                    b bVar = this.a;
                    d2 = d2.h(new c(bVar, new int[]{bVar.j(0, c2), 1}));
                }
            }
            c[] d3 = d(this.a.b(i2, 1), new c(this.a, iArr3), i2);
            c cVar2 = d3[0];
            c cVar3 = d3[1];
            int[] b2 = b(cVar2);
            int[] c3 = c(cVar3, cVar2, b2);
            for (int i5 = 0; i5 < b2.length; i5++) {
                int length = (iArr.length - 1) - this.a.h(b2[i5]);
                if (length >= 0) {
                    iArr[length] = this.a.j(iArr[length], c3[i5]);
                } else {
                    throw ChecksumException.getChecksumInstance();
                }
            }
            return b2.length;
        }
        return 0;
    }
}
