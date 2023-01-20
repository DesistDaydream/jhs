package com.tencent.qcloud.tuikit.tuichat.component.camera.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuicore.util.ScreenUtil;

/* loaded from: classes3.dex */
public class FoucsView extends View {
    private int center_x;
    private int center_y;
    private int length;
    private Paint mPaint;
    private int size;

    public FoucsView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i2 = this.center_x;
        int i3 = this.length;
        int i4 = this.center_y;
        canvas.drawRect(i2 - i3, i4 - i3, i2 + i3, i4 + i3, this.mPaint);
        canvas.drawLine(2.0f, getHeight() / 2, this.size / 10, getHeight() / 2, this.mPaint);
        canvas.drawLine(getWidth() - 2, getHeight() / 2, getWidth() - (this.size / 10), getHeight() / 2, this.mPaint);
        canvas.drawLine(getWidth() / 2, 2.0f, getWidth() / 2, this.size / 10, this.mPaint);
        canvas.drawLine(getWidth() / 2, getHeight() - 2, getWidth() / 2, getHeight() - (this.size / 10), this.mPaint);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int i4 = this.size;
        this.center_x = (int) (i4 / 2.0d);
        this.center_y = (int) (i4 / 2.0d);
        this.length = ((int) (i4 / 2.0d)) - 2;
        setMeasuredDimension(i4, i4);
    }

    public FoucsView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FoucsView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.size = ScreenUtil.getScreenWidth(context) / 3;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setColor(-300503530);
        this.mPaint.setStrokeWidth(4.0f);
        this.mPaint.setStyle(Paint.Style.STROKE);
    }
}
