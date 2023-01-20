package e.j.a.c.z;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class n extends e {
    public float a;

    public n() {
        this.a = -1.0f;
    }

    @Override // e.j.a.c.z.e
    public void b(@NonNull q qVar, float f2, float f3, float f4) {
        qVar.q(0.0f, f4 * f3, 180.0f, 180.0f - f2);
        float f5 = f4 * 2.0f * f3;
        qVar.a(0.0f, 0.0f, f5, f5, 180.0f, f2);
    }

    @Deprecated
    public n(float f2) {
        this.a = -1.0f;
        this.a = f2;
    }
}
