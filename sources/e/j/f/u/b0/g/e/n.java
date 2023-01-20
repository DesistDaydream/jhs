package e.j.f.u.b0.g.e;

/* loaded from: classes2.dex */
public final class n extends p {
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11610c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f11611d;

    public n(int i2, String str) {
        super(i2);
        this.b = str;
        this.f11611d = false;
        this.f11610c = 0;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.f11610c;
    }

    public boolean d() {
        return this.f11611d;
    }

    public n(int i2, String str, int i3) {
        super(i2);
        this.f11611d = true;
        this.f11610c = i3;
        this.b = str;
    }
}
