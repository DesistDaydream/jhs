package e.j.f.w.d;

import e.j.f.l;

/* loaded from: classes2.dex */
public final class a extends l {

    /* renamed from: c  reason: collision with root package name */
    private final float f11751c;

    public a(float f2, float f3, float f4) {
        super(f2, f3);
        this.f11751c = f4;
    }

    public boolean f(float f2, float f3, float f4) {
        if (Math.abs(f3 - d()) > f2 || Math.abs(f4 - c()) > f2) {
            return false;
        }
        float abs = Math.abs(f2 - this.f11751c);
        return abs <= 1.0f || abs <= this.f11751c;
    }

    public a g(float f2, float f3, float f4) {
        return new a((c() + f3) / 2.0f, (d() + f2) / 2.0f, (this.f11751c + f4) / 2.0f);
    }
}
