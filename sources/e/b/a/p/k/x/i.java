package e.b.a.p.k.x;

/* loaded from: classes.dex */
public final class i implements a<int[]> {
    private static final String a = "IntegerArrayPool";

    @Override // e.b.a.p.k.x.a
    /* renamed from: a */
    public int x(int[] iArr) {
        return iArr.length;
    }

    @Override // e.b.a.p.k.x.a
    /* renamed from: b */
    public int[] newArray(int i2) {
        return new int[i2];
    }

    @Override // e.b.a.p.k.x.a
    public String v() {
        return a;
    }

    @Override // e.b.a.p.k.x.a
    public int w() {
        return 4;
    }
}
