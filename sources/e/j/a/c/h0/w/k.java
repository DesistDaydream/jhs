package e.j.a.c.h0.w;

import android.graphics.Path;
import android.graphics.PointF;
import android.transition.PathMotion;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes2.dex */
public final class k extends PathMotion {
    private static PointF a(float f2, float f3, float f4, float f5) {
        if (f3 > f5) {
            return new PointF(f4, f3);
        }
        return new PointF(f2, f5);
    }

    @Override // android.transition.PathMotion
    @NonNull
    public Path getPath(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(f2, f3);
        PointF a = a(f2, f3, f4, f5);
        path.quadTo(a.x, a.y, f4, f5);
        return path;
    }
}
