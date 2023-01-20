package com.yalantis.ucrop.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.R;

/* loaded from: classes3.dex */
public class HorizontalProgressWheelView extends View {
    private final Rect mCanvasClipBounds;
    private float mLastTouchedPosition;
    private int mMiddleLineColor;
    private int mProgressLineHeight;
    private int mProgressLineMargin;
    private Paint mProgressLinePaint;
    private int mProgressLineWidth;
    private Paint mProgressMiddleLinePaint;
    private boolean mScrollStarted;
    private ScrollingListener mScrollingListener;
    private float mTotalScrollDistance;

    /* loaded from: classes3.dex */
    public interface ScrollingListener {
        void onScroll(float f2, float f3);

        void onScrollEnd();

        void onScrollStart();
    }

    public HorizontalProgressWheelView(Context context) {
        this(context, null);
    }

    private void init() {
        this.mMiddleLineColor = ContextCompat.getColor(getContext(), R.color.ucrop_color_widget_rotate_mid_line);
        this.mProgressLineWidth = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_horizontal_wheel_progress_line);
        this.mProgressLineHeight = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_height_horizontal_wheel_progress_line);
        this.mProgressLineMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_margin_horizontal_wheel_progress_line);
        Paint paint = new Paint(1);
        this.mProgressLinePaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mProgressLinePaint.setStrokeWidth(this.mProgressLineWidth);
        this.mProgressLinePaint.setColor(getResources().getColor(R.color.ucrop_color_progress_wheel_line));
        Paint paint2 = new Paint(this.mProgressLinePaint);
        this.mProgressMiddleLinePaint = paint2;
        paint2.setColor(this.mMiddleLineColor);
        this.mProgressMiddleLinePaint.setStrokeCap(Paint.Cap.ROUND);
        this.mProgressMiddleLinePaint.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_middle_wheel_progress_line));
    }

    private void onScrollEvent(MotionEvent motionEvent, float f2) {
        this.mTotalScrollDistance -= f2;
        postInvalidate();
        this.mLastTouchedPosition = motionEvent.getX();
        ScrollingListener scrollingListener = this.mScrollingListener;
        if (scrollingListener != null) {
            scrollingListener.onScroll(-f2, this.mTotalScrollDistance);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mCanvasClipBounds);
        int width = this.mCanvasClipBounds.width();
        int i2 = this.mProgressLineWidth;
        int i3 = this.mProgressLineMargin;
        int i4 = width / (i2 + i3);
        float f2 = this.mTotalScrollDistance % (i3 + i2);
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i4 / 4;
            if (i5 < i6) {
                this.mProgressLinePaint.setAlpha((int) ((i5 / i6) * 255.0f));
            } else if (i5 > (i4 * 3) / 4) {
                this.mProgressLinePaint.setAlpha((int) (((i4 - i5) / i6) * 255.0f));
            } else {
                this.mProgressLinePaint.setAlpha(255);
            }
            float f3 = -f2;
            Rect rect = this.mCanvasClipBounds;
            float f4 = rect.left + f3 + ((this.mProgressLineWidth + this.mProgressLineMargin) * i5);
            float centerY = rect.centerY() - (this.mProgressLineHeight / 4.0f);
            Rect rect2 = this.mCanvasClipBounds;
            canvas.drawLine(f4, centerY, f3 + rect2.left + ((this.mProgressLineWidth + this.mProgressLineMargin) * i5), rect2.centerY() + (this.mProgressLineHeight / 4.0f), this.mProgressLinePaint);
        }
        canvas.drawLine(this.mCanvasClipBounds.centerX(), this.mCanvasClipBounds.centerY() - (this.mProgressLineHeight / 2.0f), this.mCanvasClipBounds.centerX(), (this.mProgressLineHeight / 2.0f) + this.mCanvasClipBounds.centerY(), this.mProgressMiddleLinePaint);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastTouchedPosition = motionEvent.getX();
        } else if (action == 1) {
            ScrollingListener scrollingListener = this.mScrollingListener;
            if (scrollingListener != null) {
                this.mScrollStarted = false;
                scrollingListener.onScrollEnd();
            }
        } else if (action == 2) {
            float x = motionEvent.getX() - this.mLastTouchedPosition;
            if (x != 0.0f) {
                if (!this.mScrollStarted) {
                    this.mScrollStarted = true;
                    ScrollingListener scrollingListener2 = this.mScrollingListener;
                    if (scrollingListener2 != null) {
                        scrollingListener2.onScrollStart();
                    }
                }
                onScrollEvent(motionEvent, x);
            }
        }
        return true;
    }

    public void setMiddleLineColor(@ColorInt int i2) {
        this.mMiddleLineColor = i2;
        this.mProgressMiddleLinePaint.setColor(i2);
        invalidate();
    }

    public void setScrollingListener(ScrollingListener scrollingListener) {
        this.mScrollingListener = scrollingListener;
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mCanvasClipBounds = new Rect();
        init();
    }

    @TargetApi(21)
    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.mCanvasClipBounds = new Rect();
    }
}
