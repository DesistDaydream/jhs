package com.m7.imkfsdk.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class PointBottomView extends View {
    private int circleInterval;
    private int currentPage;
    private int currentScroll;
    private int flowWidth;
    private final Paint mPaintFill;
    private final Paint mPaintStroke;
    private int pageTotalCount;
    private int radius;

    public PointBottomView(Context context) {
        super(context);
        this.radius = 4;
        this.mPaintStroke = new Paint(1);
        this.mPaintFill = new Paint(1);
        this.currentScroll = 0;
        this.flowWidth = 0;
        this.pageTotalCount = 1;
        this.currentPage = 0;
        this.circleInterval = this.radius;
        initColors(-1, -2500135);
    }

    private void initColors(int i2, int i3) {
        this.mPaintStroke.setStyle(Paint.Style.FILL);
        this.mPaintStroke.setColor(i3);
        this.mPaintFill.setStyle(Paint.Style.FILL);
        this.mPaintFill.setColor(i2);
    }

    private int measureHeight(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (this.radius * 2) + getPaddingTop() + getPaddingBottom();
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    private int measureWidth(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i3 = this.pageTotalCount;
        int i4 = paddingLeft + (i3 * 2 * this.radius) + ((i3 - 1) * this.circleInterval);
        return mode == Integer.MIN_VALUE ? Math.min(i4, size) : i4;
    }

    public void initData(int i2, int i3) {
        this.pageTotalCount = i2;
        this.flowWidth = i3;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        int i3;
        super.onDraw(canvas);
        for (int i4 = 0; i4 < this.pageTotalCount; i4++) {
            int paddingLeft = getPaddingLeft();
            int i5 = this.radius;
            int paddingTop = getPaddingTop();
            canvas.drawCircle(paddingLeft + i5 + (((i5 * 2) + this.circleInterval) * i4), paddingTop + i3, this.radius, this.mPaintStroke);
        }
        float paddingLeft2 = getPaddingLeft() + this.radius + (((this.radius * 2) + this.circleInterval) * this.currentPage);
        int paddingTop2 = getPaddingTop();
        canvas.drawCircle(paddingLeft2, paddingTop2 + i2, this.radius, this.mPaintFill);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(measureWidth(i2), measureHeight(i3));
    }

    public void onScrolled(int i2, int i3, int i4, int i5) {
        this.currentScroll = i2;
        invalidate();
    }

    public void setCircleInterval(int i2) {
        this.circleInterval = i2;
        invalidate();
    }

    public void setCurrentPage(int i2) {
        this.currentPage = i2;
        invalidate();
    }

    public void setFillColor(int i2) {
        this.mPaintFill.setColor(i2);
        invalidate();
    }

    public void setPageTotalCount(int i2) {
        this.pageTotalCount = i2;
        invalidate();
    }

    public void setRadius(int i2) {
        this.radius = i2;
        invalidate();
    }

    public void setStrokeColor(int i2) {
        this.mPaintStroke.setColor(i2);
        invalidate();
    }

    public PointBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.radius = 4;
        this.mPaintStroke = new Paint(1);
        this.mPaintFill = new Paint(1);
        this.currentScroll = 0;
        this.flowWidth = 0;
        this.pageTotalCount = 1;
        this.currentPage = 0;
        this.circleInterval = this.radius;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ykfsdk_PointBottomView);
        try {
            try {
                int color = obtainStyledAttributes.getColor(R.styleable.ykfsdk_PointBottomView_ykfsdk_fillColor, -1);
                int color2 = obtainStyledAttributes.getColor(R.styleable.ykfsdk_PointBottomView_ykfsdk_strokeColor, -2500135);
                int dimension = (int) obtainStyledAttributes.getDimension(R.styleable.ykfsdk_PointBottomView_ykfsdk_radius, this.radius);
                this.radius = dimension;
                this.circleInterval = (int) obtainStyledAttributes.getDimension(R.styleable.ykfsdk_PointBottomView_ykfsdk_circleInterval, dimension);
                initColors(color, color2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
