package com.m7.imkfsdk.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.m7.imkfsdk.R;
import com.moor.imkf.lib.utils.MoorDensityUtil;

/* loaded from: classes2.dex */
public class ProgressLineView extends View {
    private int PAINTSTROKEWIDTH;
    private int RADIUS;
    private int STARTX;
    private int TOPLINELENGTH;
    private float mEndLineStartX;
    private float mEndLineStartY;
    private float mEndLineStopX;
    private float mEndLineStopY;
    private float mStartLineStartX;
    private float mStartLineStartY;
    private float mStartLineStopX;
    private float mStartLineStopY;
    public Paint paint;

    public ProgressLineView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.paint = new Paint(1);
        this.PAINTSTROKEWIDTH = MoorDensityUtil.dp2px(1.0f);
        this.STARTX = MoorDensityUtil.dp2px(15.0f);
        this.TOPLINELENGTH = MoorDensityUtil.dp2px(15.0f);
        this.RADIUS = MoorDensityUtil.dp2px(4.0f);
        this.paint.setColor(getResources().getColor(R.color.ykfsdk_color_ebebeb));
        this.paint.setStrokeWidth(this.PAINTSTROKEWIDTH);
        initSize();
    }

    private void initSize() {
        int i2 = this.STARTX;
        this.mStartLineStartX = i2;
        this.mStartLineStartY = 0.0f;
        this.mStartLineStopX = i2;
        int i3 = this.TOPLINELENGTH;
        this.mStartLineStopY = i3;
        this.mEndLineStartX = i2;
        this.mEndLineStartY = i3 + (this.RADIUS * 2);
        this.mEndLineStopX = i2;
        this.mEndLineStopY = (getHeight() - this.TOPLINELENGTH) - (this.RADIUS * 2);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.paint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(this.mStartLineStartX, this.mStartLineStartY, this.mStartLineStopX, this.mStartLineStopY, this.paint);
        this.paint.setStyle(Paint.Style.FILL);
        int i2 = this.TOPLINELENGTH;
        int i3 = this.RADIUS;
        canvas.drawCircle(this.STARTX, i2 + i3, i3, this.paint);
        this.paint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(this.mEndLineStartX, this.mEndLineStartY, this.mEndLineStopX, this.mEndLineStopY, this.paint);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        setMeasuredDimension(View.MeasureSpec.getSize(getMeasuredWidth()), View.MeasureSpec.getSize(getMeasuredHeight()));
        initSize();
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        initSize();
    }
}
