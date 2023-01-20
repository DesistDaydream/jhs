package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class ClipImageView extends ImageView {
    private boolean a;
    private Path b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f5412c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f5413d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f5414e;

    public ClipImageView(Context context) {
        super(context);
        this.a = true;
        a(context);
    }

    public void a(Context context) {
        this.b = new Path();
        this.f5412c = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.a) {
            this.b.reset();
            this.f5412c.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.f5414e;
            if (fArr != null) {
                this.b.addRoundRect(this.f5412c, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.b);
            Paint paint = this.f5413d;
            if (paint != null) {
                canvas.drawPath(this.b, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Paint paint = new Paint(1);
        this.f5413d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f5413d.setColor(i2);
    }

    public void setClip(boolean z) {
        this.a = z;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.f5414e = fArr;
    }

    public void setRoundRadius(int i2) {
        if (i2 > 0) {
            float f2 = i2;
            setRadius(new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
        }
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        a(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = true;
        a(context);
    }
}
