package com.tencent.qcloud.tuikit.tuichat.component.camera.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import androidx.core.view.ViewCompat;

/* loaded from: classes3.dex */
public class TypeButton extends View {
    public static final int TYPE_CANCEL = 1;
    public static final int TYPE_CONFIRM = 2;
    private float button_radius;
    private int button_size;
    private int button_type;
    private float center_X;
    private float center_Y;
    private float index;
    private Paint mPaint;
    private Path path;
    private RectF rectF;
    private float strokeWidth;

    public TypeButton(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.button_type == 1) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(-287515428);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(this.center_X, this.center_Y, this.button_radius, this.mPaint);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.strokeWidth);
            Path path = this.path;
            float f2 = this.center_X;
            float f3 = this.index;
            path.moveTo(f2 - (f3 / 7.0f), this.center_Y + f3);
            Path path2 = this.path;
            float f4 = this.center_X;
            float f5 = this.index;
            path2.lineTo(f4 + f5, this.center_Y + f5);
            this.path.arcTo(this.rectF, 90.0f, -180.0f);
            Path path3 = this.path;
            float f6 = this.center_X;
            float f7 = this.index;
            path3.lineTo(f6 - f7, this.center_Y - f7);
            canvas.drawPath(this.path, this.mPaint);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.path.reset();
            Path path4 = this.path;
            float f8 = this.center_X;
            float f9 = this.index;
            path4.moveTo(f8 - f9, (float) (this.center_Y - (f9 * 1.5d)));
            Path path5 = this.path;
            float f10 = this.center_X;
            float f11 = this.index;
            path5.lineTo(f10 - f11, (float) (this.center_Y - (f11 / 2.3d)));
            Path path6 = this.path;
            float f12 = this.index;
            path6.lineTo((float) (this.center_X - (f12 * 1.6d)), this.center_Y - f12);
            this.path.close();
            canvas.drawPath(this.path, this.mPaint);
        }
        if (this.button_type == 2) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(-1);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(this.center_X, this.center_Y, this.button_radius, this.mPaint);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(-16724992);
            this.mPaint.setStrokeWidth(this.strokeWidth);
            this.path.moveTo(this.center_X - (this.button_size / 6.0f), this.center_Y);
            Path path7 = this.path;
            float f13 = this.center_X;
            int i2 = this.button_size;
            path7.lineTo(f13 - (i2 / 21.2f), this.center_Y + (i2 / 7.7f));
            Path path8 = this.path;
            float f14 = this.center_X;
            int i3 = this.button_size;
            path8.lineTo(f14 + (i3 / 4.0f), this.center_Y - (i3 / 8.5f));
            Path path9 = this.path;
            float f15 = this.center_X;
            int i4 = this.button_size;
            path9.lineTo(f15 - (i4 / 21.2f), this.center_Y + (i4 / 9.4f));
            this.path.close();
            canvas.drawPath(this.path, this.mPaint);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int i4 = this.button_size;
        setMeasuredDimension(i4, i4);
    }

    public TypeButton(Context context, int i2, int i3) {
        super(context);
        this.button_type = i2;
        this.button_size = i3;
        float f2 = i3;
        float f3 = f2 / 2.0f;
        this.button_radius = f3;
        this.center_X = f3;
        this.center_Y = f3;
        this.mPaint = new Paint();
        this.path = new Path();
        this.strokeWidth = f2 / 50.0f;
        this.index = this.button_size / 12.0f;
        float f4 = this.center_X;
        float f5 = this.center_Y;
        float f6 = this.index;
        this.rectF = new RectF(f4, f5 - f6, (2.0f * f6) + f4, f5 + f6);
    }
}
