package e.b.a.p.k.x;

/* loaded from: classes.dex */
public final class g implements a<byte[]> {
    private static final String a = "ByteArrayPool";

    @Override // e.b.a.p.k.x.a
    /* renamed from: a */
    public int x(byte[] bArr) {
        return bArr.length;
    }

    @Override // e.b.a.p.k.x.a
    /* renamed from: b */
    public byte[] newArray(int i2) {
        return new byte[i2];
    }

    @Override // e.b.a.p.k.x.a
    public String v() {
        return a;
    }

    @Override // e.b.a.p.k.x.a
    public int w() {
        return 1;
    }
}
