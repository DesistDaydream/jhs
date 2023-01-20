package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class q extends f {

    /* renamed from: f  reason: collision with root package name */
    public final transient byte[][] f294f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int[] f295g;

    public q(c cVar, int i2) {
        super(null);
        u.a(cVar.b, 0L, i2);
        o oVar = cVar.a;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = oVar.f289c;
            int i7 = oVar.b;
            if (i6 == i7) {
                throw new AssertionError("s.limit == s.pos");
            }
            i4 += i6 - i7;
            i5++;
            oVar = oVar.f292f;
        }
        this.f294f = new byte[i5];
        this.f295g = new int[i5 * 2];
        o oVar2 = cVar.a;
        int i8 = 0;
        while (i3 < i2) {
            byte[][] bArr = this.f294f;
            bArr[i8] = oVar2.a;
            int i9 = oVar2.f289c;
            int i10 = oVar2.b;
            int i11 = (i9 - i10) + i3;
            i3 = i11 > i2 ? i2 : i11;
            int[] iArr = this.f295g;
            iArr[i8] = i3;
            iArr[bArr.length + i8] = i10;
            oVar2.f290d = true;
            i8++;
            oVar2 = oVar2.f292f;
        }
    }

    private int b(int i2) {
        int binarySearch = Arrays.binarySearch(this.f295g, 0, this.f294f.length, i2 + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    private f i() {
        return new f(g());
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public byte a(int i2) {
        u.a(this.f295g[this.f294f.length - 1], i2, 1L);
        int b = b(i2);
        int i3 = b == 0 ? 0 : this.f295g[b - 1];
        int[] iArr = this.f295g;
        byte[][] bArr = this.f294f;
        return bArr[b][(i2 - i3) + iArr[bArr.length + b]];
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public f a(int i2, int i3) {
        return i().a(i2, i3);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public String a() {
        return i().a();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public void a(c cVar) {
        int length = this.f294f.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.f295g;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            o oVar = new o(this.f294f[i2], i4, (i4 + i5) - i3, true, false);
            o oVar2 = cVar.a;
            if (oVar2 == null) {
                oVar.f293g = oVar;
                oVar.f292f = oVar;
                cVar.a = oVar;
            } else {
                oVar2.f293g.a(oVar);
            }
            i2++;
            i3 = i5;
        }
        cVar.b += i3;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public boolean a(int i2, f fVar, int i3, int i4) {
        if (i2 < 0 || i2 > e() - i4) {
            return false;
        }
        int b = b(i2);
        while (i4 > 0) {
            int i5 = b == 0 ? 0 : this.f295g[b - 1];
            int min = Math.min(i4, ((this.f295g[b] - i5) + i5) - i2);
            int[] iArr = this.f295g;
            byte[][] bArr = this.f294f;
            if (!fVar.a(i3, bArr[b], (i2 - i5) + iArr[bArr.length + b], min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            b++;
        }
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        if (i2 < 0 || i2 > e() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int b = b(i2);
        while (i4 > 0) {
            int i5 = b == 0 ? 0 : this.f295g[b - 1];
            int min = Math.min(i4, ((this.f295g[b] - i5) + i5) - i2);
            int[] iArr = this.f295g;
            byte[][] bArr2 = this.f294f;
            if (!u.a(bArr2[b], (i2 - i5) + iArr[bArr2.length + b], bArr, i3, min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            b++;
        }
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public String b() {
        return i().b();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public f c() {
        return i().c();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public f d() {
        return i().d();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public int e() {
        return this.f295g[this.f294f.length - 1];
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            if (fVar.e() != e() || !a(0, fVar, 0, e())) {
                return false;
            }
        }
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public f f() {
        return i().f();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public byte[] g() {
        int[] iArr = this.f295g;
        byte[][] bArr = this.f294f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr2 = this.f295g;
            int i4 = iArr2[length + i2];
            int i5 = iArr2[i2];
            System.arraycopy(this.f294f[i2], i4, bArr2, i3, i5 - i3);
            i2++;
            i3 = i5;
        }
        return bArr2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public String h() {
        return i().h();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public int hashCode() {
        int i2 = this.b;
        if (i2 != 0) {
            return i2;
        }
        int length = this.f294f.length;
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        while (i3 < length) {
            byte[] bArr = this.f294f[i3];
            int[] iArr = this.f295g;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            for (int i8 = i6; i8 < (i7 - i5) + i6; i8++) {
                i4 = (i4 * 31) + bArr[i8];
            }
            i3++;
            i5 = i7;
        }
        this.b = i4;
        return i4;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f
    public String toString() {
        return i().toString();
    }
}
