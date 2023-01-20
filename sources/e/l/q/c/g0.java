package e.l.q.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import e.t.o.d;

/* loaded from: classes2.dex */
public final class g0 extends Drawable {
    private final int a;
    @k.e.a.d
    private final Paint b = new Paint();

    public g0(int i2) {
        this.a = i2;
    }

    public final int a() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@k.e.a.d Canvas canvas) {
        int i2;
        this.b.setColor(this.a);
        this.b.setStyle(Paint.Style.FILL);
        Rect bounds = getBounds();
        int i3 = bounds.left;
        d.a aVar = e.t.o.d.a;
        bounds.left = i3 + d.a.c(aVar, null, 1, null).d(7);
        bounds.right -= d.a.c(aVar, null, 1, null).d(7);
        int i4 = bounds.bottom - bounds.top;
        int d2 = d.a.c(aVar, null, 1, null).d(24);
        float d3 = d.a.c(aVar, null, 1, null).d(16);
        float d4 = d.a.c(aVar, null, 1, null).d(8);
        Path path = new Path();
        path.moveTo(bounds.left + d2, bounds.top);
        int i5 = bounds.left;
        int i6 = bounds.top;
        path.quadTo(i5 + d4, i6, i5 + d4, i6 + d3);
        path.lineTo(bounds.left + d4, i4 - d4);
        int i7 = bounds.left;
        int i8 = bounds.bottom;
        path.quadTo(i7 + d4, i8, i7, i8);
        path.lineTo(bounds.right, bounds.bottom);
        int i9 = bounds.right;
        int i10 = bounds.bottom;
        path.quadTo(i9 - d4, i10, i9 - d4, i10 - d4);
        path.lineTo(bounds.right - d4, bounds.top + d3);
        float f2 = bounds.right - d4;
        int i11 = bounds.top;
        path.quadTo(f2, i11, i2 - d2, i11);
        path.lineTo(bounds.left + d2, bounds.top);
        canvas.drawPath(path, this.b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.b.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@k.e.a.e ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }
}
