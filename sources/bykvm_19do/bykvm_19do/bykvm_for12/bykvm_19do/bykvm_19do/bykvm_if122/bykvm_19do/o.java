package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

/* loaded from: classes.dex */
public final class o {
    public final byte[] a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f289c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f290d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f291e;

    /* renamed from: f  reason: collision with root package name */
    public o f292f;

    /* renamed from: g  reason: collision with root package name */
    public o f293g;

    public o() {
        this.a = new byte[8192];
        this.f291e = true;
        this.f290d = false;
    }

    public o(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.a = bArr;
        this.b = i2;
        this.f289c = i3;
        this.f290d = z;
        this.f291e = z2;
    }

    public final o a(int i2) {
        o a;
        if (i2 <= 0 || i2 > this.f289c - this.b) {
            throw new IllegalArgumentException();
        }
        if (i2 >= 1024) {
            a = c();
        } else {
            a = p.a();
            System.arraycopy(this.a, this.b, a.a, 0, i2);
        }
        a.f289c = a.b + i2;
        this.b += i2;
        this.f293g.a(a);
        return a;
    }

    public final o a(o oVar) {
        oVar.f293g = this;
        oVar.f292f = this.f292f;
        this.f292f.f293g = oVar;
        this.f292f = oVar;
        return oVar;
    }

    public final void a() {
        o oVar = this.f293g;
        if (oVar == this) {
            throw new IllegalStateException();
        }
        if (oVar.f291e) {
            int i2 = this.f289c - this.b;
            if (i2 <= (oVar.f290d ? 0 : oVar.b) + (8192 - oVar.f289c)) {
                a(oVar, i2);
                b();
                p.a(this);
            }
        }
    }

    public final void a(o oVar, int i2) {
        if (!oVar.f291e) {
            throw new IllegalArgumentException();
        }
        int i3 = oVar.f289c;
        int i4 = i3 + i2;
        if (i4 > 8192) {
            if (oVar.f290d) {
                throw new IllegalArgumentException();
            }
            int i5 = oVar.b;
            if (i4 - i5 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = oVar.a;
            System.arraycopy(bArr, i5, bArr, 0, i3 - i5);
            oVar.f289c -= oVar.b;
            oVar.b = 0;
        }
        System.arraycopy(this.a, this.b, oVar.a, oVar.f289c, i2);
        oVar.f289c += i2;
        this.b += i2;
    }

    public final o b() {
        o oVar = this.f292f;
        o oVar2 = oVar != this ? oVar : null;
        o oVar3 = this.f293g;
        if (oVar3 != null) {
            oVar3.f292f = oVar;
        }
        o oVar4 = this.f292f;
        if (oVar4 != null) {
            oVar4.f293g = oVar3;
        }
        this.f292f = null;
        this.f293g = null;
        return oVar2;
    }

    public final o c() {
        this.f290d = true;
        return new o(this.a, this.b, this.f289c, true, false);
    }
}
