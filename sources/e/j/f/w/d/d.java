package e.j.f.w.d;

import e.j.f.l;

/* loaded from: classes2.dex */
public final class d extends l {

    /* renamed from: c  reason: collision with root package name */
    private final float f11759c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11760d;

    public d(float f2, float f3, float f4) {
        this(f2, f3, f4, 1);
    }

    public boolean f(float f2, float f3, float f4) {
        if (Math.abs(f3 - d()) > f2 || Math.abs(f4 - c()) > f2) {
            return false;
        }
        float abs = Math.abs(f2 - this.f11759c);
        return abs <= 1.0f || abs <= this.f11759c;
    }

    public d g(float f2, float f3, float f4) {
        int i2 = this.f11760d;
        int i3 = i2 + 1;
        float c2 = (i2 * c()) + f3;
        float f5 = i3;
        return new d(c2 / f5, ((this.f11760d * d()) + f2) / f5, ((this.f11760d * this.f11759c) + f4) / f5, i3);
    }

    public int h() {
        return this.f11760d;
    }

    public float i() {
        return this.f11759c;
    }

    private d(float f2, float f3, float f4, int i2) {
        super(f2, f3);
        this.f11759c = f4;
        this.f11760d = i2;
    }
}
