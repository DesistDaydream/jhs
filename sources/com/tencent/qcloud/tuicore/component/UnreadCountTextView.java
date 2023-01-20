package com.tencent.qcloud.tuicore.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.util.ScreenUtil;

/* loaded from: classes3.dex */
public class UnreadCountTextView extends AppCompatTextView {
    private int mNormalSize;
    private Paint mPaint;

    public UnreadCountTextView(Context context) {
        super(context);
        this.mNormalSize = ScreenUtil.getPxByDp(15.0f);
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(getResources().getColor(R.color.read_dot_bg));
        this.mPaint.setAntiAlias(true);
        setTextColor(-1);
        setTextSize(2, 10.0f);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (getText().length() == 0) {
            int measuredWidth = (getMeasuredWidth() - ScreenUtil.getPxByDp(6.0f)) / 2;
            int measuredWidth2 = getMeasuredWidth() - measuredWidth;
            float f2 = measuredWidth;
            float f3 = measuredWidth2;
            canvas.drawOval(new RectF(f2, f2, f3, f3), this.mPaint);
        } else if (getText().length() == 1) {
            int i2 = this.mNormalSize;
            canvas.drawOval(new RectF(0.0f, 0.0f, i2, i2), this.mPaint);
        } else if (getText().length() > 1) {
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight()), getMeasuredHeight() / 2, getMeasuredHeight() / 2, this.mPaint);
        }
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4 = this.mNormalSize;
        setMeasuredDimension(getText().length() > 1 ? this.mNormalSize + ScreenUtil.getPxByDp((getText().length() - 1) * 6) : i4, i4);
    }

    public void setPaintColor(int i2) {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setColor(i2);
        }
    }

    public UnreadCountTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mNormalSize = ScreenUtil.getPxByDp(15.0f);
        init();
    }

    public UnreadCountTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mNormalSize = ScreenUtil.getPxByDp(15.0f);
        init();
    }
}
