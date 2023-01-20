package com.m7.imkfsdk.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class CircleProgressView extends View {
    public static final int PI_RADIUS = 180;
    private int height;
    private RectF mBackground;
    private int mBackgroundColor;
    private PointF mCenter;
    private Path mClipArcPath;
    private Path mClipBgPath;
    private int mCorner;
    private RectF mEnclosingRectF;
    private Paint mPaint;
    private int mProgress;
    private float mRadius;
    private PointF mStart;
    private int mStartAngle;
    private int width;

    public CircleProgressView(Context context) {
        super(context);
        this.mClipArcPath = new Path();
        this.mClipBgPath = new Path();
        this.mPaint = new Paint();
    }

    private Path getSectorClip(float f2) {
        this.mClipArcPath.reset();
        Path path = this.mClipArcPath;
        PointF pointF = this.mCenter;
        path.moveTo(pointF.x, pointF.y);
        Path path2 = this.mClipArcPath;
        PointF pointF2 = this.mStart;
        path2.lineTo(pointF2.x, pointF2.y);
        double d2 = (f2 * 3.141592653589793d) / 180.0d;
        this.mClipArcPath.lineTo((float) (this.mCenter.x + (this.mRadius * Math.cos(d2))), (float) (this.mCenter.y + (this.mRadius * Math.sin(d2))));
        this.mClipArcPath.close();
        Path path3 = this.mClipArcPath;
        RectF rectF = this.mEnclosingRectF;
        int i2 = this.mStartAngle;
        path3.addArc(rectF, i2, f2 - i2);
        return this.mClipArcPath;
    }

    private void init(Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ykfsdk_CircleProgress);
        this.mProgress = obtainStyledAttributes.getInt(R.styleable.ykfsdk_CircleProgress_ykfsdk_circleProgress, 0);
        this.mCorner = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ykfsdk_CircleProgress_ykfsdk_circleCorner, 0);
        this.mStartAngle = obtainStyledAttributes.getInt(R.styleable.ykfsdk_CircleProgress_ykfsdk_startAngle, 315);
        this.mBackgroundColor = obtainStyledAttributes.getColor(R.styleable.ykfsdk_CircleProgress_ykfsdk_backgroundColor, Color.argb(90, 90, 90, 90));
        obtainStyledAttributes.recycle();
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.mBackgroundColor);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.clipPath(this.mClipBgPath);
        canvas.clipPath(getSectorClip(((this.mProgress * 360) / 100.0f) + this.mStartAngle), Region.Op.DIFFERENCE);
        RectF rectF = this.mBackground;
        int i2 = this.mCorner;
        canvas.drawRoundRect(rectF, i2, i2, this.mPaint);
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.width = i2;
        this.height = i3;
        float paddingStart = ((i2 - getPaddingStart()) - getPaddingEnd()) / 2.0f;
        float paddingTop = ((this.height - getPaddingTop()) - getPaddingBottom()) / 2.0f;
        this.mRadius = (float) Math.sqrt((paddingStart * paddingStart) + (paddingTop * paddingTop));
        this.mCenter = new PointF(getPaddingStart() + paddingStart, getPaddingTop() + paddingTop);
        this.mStart = new PointF((float) (this.mCenter.x + (this.mRadius * Math.cos((this.mStartAngle * 3.141592653589793d) / 180.0d))), (float) (this.mCenter.y + (this.mRadius * Math.sin((this.mStartAngle * 3.141592653589793d) / 180.0d))));
        this.mBackground = new RectF(getPaddingStart(), getPaddingTop(), this.width - getPaddingEnd(), this.height - getPaddingBottom());
        PointF pointF = this.mCenter;
        float f2 = pointF.x;
        float f3 = this.mRadius;
        float f4 = pointF.y;
        this.mEnclosingRectF = new RectF(f2 - f3, f4 - f3, f2 + f3, f4 + f3);
        this.mClipBgPath.reset();
        Path path = this.mClipBgPath;
        RectF rectF = this.mBackground;
        int i6 = this.mCorner;
        path.addRoundRect(rectF, i6, i6, Path.Direction.CW);
    }

    public void setProgress(int i2) {
        this.mProgress = i2;
        invalidate();
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mClipArcPath = new Path();
        this.mClipBgPath = new Path();
        this.mPaint = new Paint();
        init(context, attributeSet);
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mClipArcPath = new Path();
        this.mClipBgPath = new Path();
        this.mPaint = new Paint();
        init(context, attributeSet);
    }
}
