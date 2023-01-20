package e.j.a.c.z;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class a implements d {
    private final float a;

    public a(float f2) {
        this.a = f2;
    }

    @Override // e.j.a.c.z.d
    public float a(@NonNull RectF rectF) {
        return this.a;
    }

    public float b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.a == ((a) obj).a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }
}
