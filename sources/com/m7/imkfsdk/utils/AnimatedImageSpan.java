package com.m7.imkfsdk.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.style.DynamicDrawableSpan;

/* loaded from: classes2.dex */
public class AnimatedImageSpan extends DynamicDrawableSpan {
    private Drawable mDrawable;

    public AnimatedImageSpan(Drawable drawable) {
        this.mDrawable = drawable;
        final Handler handler = new Handler();
        handler.post(new Runnable() { // from class: com.m7.imkfsdk.utils.AnimatedImageSpan.1
            @Override // java.lang.Runnable
            public void run() {
                ((AnimatedGifDrawable) AnimatedImageSpan.this.mDrawable).nextFrame();
                handler.postDelayed(this, ((AnimatedGifDrawable) AnimatedImageSpan.this.mDrawable).getFrameDuration());
            }
        });
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        Drawable drawable = getDrawable();
        canvas.save();
        int i7 = i6 - drawable.getBounds().bottom;
        if (((DynamicDrawableSpan) this).mVerticalAlignment == 1) {
            i7 -= paint.getFontMetricsInt().descent;
        }
        canvas.translate(f2, i7);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        return ((AnimatedGifDrawable) this.mDrawable).getDrawable();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            int i4 = -bounds.bottom;
            fontMetricsInt.ascent = i4;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i4;
            fontMetricsInt.bottom = 0;
        }
        return bounds.right;
    }
}
