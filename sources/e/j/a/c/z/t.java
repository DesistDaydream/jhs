package e.j.a.c.z;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class t extends g {
    private final float a;
    private final boolean b;

    public t(float f2, boolean z) {
        this.a = f2;
        this.b = z;
    }

    @Override // e.j.a.c.z.g
    public void b(float f2, float f3, float f4, @NonNull q qVar) {
        qVar.n(f3 - (this.a * f4), 0.0f);
        qVar.n(f3, (this.b ? this.a : -this.a) * f4);
        qVar.n(f3 + (this.a * f4), 0.0f);
        qVar.n(f2, 0.0f);
    }
}
