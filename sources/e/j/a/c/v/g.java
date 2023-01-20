package e.j.a.c.v;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import e.j.a.c.v.b;

/* loaded from: classes2.dex */
public abstract class g<S extends b> {
    public S a;
    public f b;

    public g(S s) {
        this.a = s;
    }

    public abstract void a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f2);

    public abstract void b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @ColorInt int i2);

    public abstract void c(@NonNull Canvas canvas, @NonNull Paint paint);

    public abstract int d();

    public abstract int e();

    public void f(@NonNull f fVar) {
        this.b = fVar;
    }

    public void g(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.a.e();
        a(canvas, f2);
    }
}
