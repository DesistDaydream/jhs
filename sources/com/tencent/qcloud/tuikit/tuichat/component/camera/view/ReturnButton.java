package com.tencent.qcloud.tuikit.tuichat.component.camera.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/* loaded from: classes3.dex */
public class ReturnButton extends View {
    private int center_X;
    private int center_Y;
    private Paint paint;
    public Path path;
    private int size;
    private float strokeWidth;

    public ReturnButton(Context context, int i2) {
        this(context);
        this.size = i2;
        int i3 = i2 / 2;
        this.center_X = i3;
        this.center_Y = i3;
        this.strokeWidth = i2 / 15.0f;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.strokeWidth);
        this.path = new Path();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = this.path;
        float f2 = this.strokeWidth;
        path.moveTo(f2, f2 / 2.0f);
        this.path.lineTo(this.center_X, this.center_Y - (this.strokeWidth / 2.0f));
        Path path2 = this.path;
        float f3 = this.strokeWidth;
        path2.lineTo(this.size - f3, f3 / 2.0f);
        canvas.drawPath(this.path, this.paint);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4 = this.size;
        setMeasuredDimension(i4, i4 / 2);
    }

    public ReturnButton(Context context) {
        super(context);
    }
}
