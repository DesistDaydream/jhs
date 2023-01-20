package e.j.a.c.z;

import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class m implements d {
    private final float a;

    public m(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.a = f2;
    }

    @Override // e.j.a.c.z.d
    public float a(@NonNull RectF rectF) {
        return this.a * rectF.height();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m) && this.a == ((m) obj).a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }
}
