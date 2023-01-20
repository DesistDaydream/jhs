package e.j.a.c.z;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public final class i extends g {
    private final float a;

    public i(float f2) {
        this.a = f2 - 0.001f;
    }

    @Override // e.j.a.c.z.g
    public boolean a() {
        return true;
    }

    @Override // e.j.a.c.z.g
    public void b(float f2, float f3, float f4, @NonNull q qVar) {
        float sqrt = (float) ((this.a * Math.sqrt(2.0d)) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow(this.a, 2.0d) - Math.pow(sqrt, 2.0d));
        qVar.p(f3 - sqrt, ((float) (-((this.a * Math.sqrt(2.0d)) - this.a))) + sqrt2);
        qVar.n(f3, (float) (-((this.a * Math.sqrt(2.0d)) - this.a)));
        qVar.n(f3 + sqrt, ((float) (-((this.a * Math.sqrt(2.0d)) - this.a))) + sqrt2);
    }
}
