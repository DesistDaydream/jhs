package e.j.a.c.z;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class f extends e {
    public float a;

    public f() {
        this.a = -1.0f;
    }

    @Override // e.j.a.c.z.e
    public void b(@NonNull q qVar, float f2, float f3, float f4) {
        qVar.q(0.0f, f4 * f3, 180.0f, 180.0f - f2);
        double d2 = f4;
        double d3 = f3;
        qVar.n((float) (Math.sin(Math.toRadians(f2)) * d2 * d3), (float) (Math.sin(Math.toRadians(90.0f - f2)) * d2 * d3));
    }

    @Deprecated
    public f(float f2) {
        this.a = -1.0f;
        this.a = f2;
    }
}
