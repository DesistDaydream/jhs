package e.j.a.c.z;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class b implements d {
    private final d a;
    private final float b;

    public b(float f2, @NonNull d dVar) {
        while (dVar instanceof b) {
            dVar = ((b) dVar).a;
            f2 += ((b) dVar).b;
        }
        this.a = dVar;
        this.b = f2;
    }

    @Override // e.j.a.c.z.d
    public float a(@NonNull RectF rectF) {
        return Math.max(0.0f, this.a.a(rectF) + this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.a.equals(bVar.a) && this.b == bVar.b;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.b)});
    }
}
