package e.j.a.c.z;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public final class l extends g {
    private final g a;
    private final float b;

    public l(@NonNull g gVar, float f2) {
        this.a = gVar;
        this.b = f2;
    }

    @Override // e.j.a.c.z.g
    public boolean a() {
        return this.a.a();
    }

    @Override // e.j.a.c.z.g
    public void b(float f2, float f3, float f4, @NonNull q qVar) {
        this.a.b(f2, f3 - this.b, f4, qVar);
    }
}
