package e.t.l;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import h.t1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0005"}, d2 = {"clear", "", "Landroid/graphics/Canvas;", "removeFilter", "setAntialias", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class g {
    public static final void a(@k.e.a.d Canvas canvas) {
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        t1 t1Var = t1.a;
        canvas.drawPaint(paint);
    }

    public static final void b(@k.e.a.d Canvas canvas) {
        canvas.setDrawFilter(null);
    }

    public static final void c(@k.e.a.d Canvas canvas) {
        if (canvas.getDrawFilter() == null) {
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        }
    }
}
