package e.j.f;

/* loaded from: classes2.dex */
public final class d extends e {

    /* renamed from: c  reason: collision with root package name */
    private final e f11329c;

    public d(e eVar) {
        super(eVar.e(), eVar.b());
        this.f11329c = eVar;
    }

    @Override // e.j.f.e
    public e a(int i2, int i3, int i4, int i5) {
        return new d(this.f11329c.a(i2, i3, i4, i5));
    }

    @Override // e.j.f.e
    public byte[] c() {
        byte[] c2 = this.f11329c.c();
        int e2 = e() * b();
        byte[] bArr = new byte[e2];
        for (int i2 = 0; i2 < e2; i2++) {
            bArr[i2] = (byte) (255 - (c2[i2] & 255));
        }
        return bArr;
    }

    @Override // e.j.f.e
    public byte[] d(int i2, byte[] bArr) {
        byte[] d2 = this.f11329c.d(i2, bArr);
        int e2 = e();
        for (int i3 = 0; i3 < e2; i3++) {
            d2[i3] = (byte) (255 - (d2[i3] & 255));
        }
        return d2;
    }

    @Override // e.j.f.e
    public e f() {
        return this.f11329c;
    }

    @Override // e.j.f.e
    public boolean g() {
        return this.f11329c.g();
    }

    @Override // e.j.f.e
    public boolean h() {
        return this.f11329c.h();
    }

    @Override // e.j.f.e
    public e i() {
        return new d(this.f11329c.i());
    }

    @Override // e.j.f.e
    public e j() {
        return new d(this.f11329c.j());
    }
}
