package com.m7.imkfsdk.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes2.dex */
public class RoundImageView extends AppCompatImageView {
    private BitmapShader mBitmapShader;
    private int mBorderRadius;
    private Matrix mMatrix;
    private Paint mPaint;

    public RoundImageView(Context context) {
        this(context, null);
    }

    private Bitmap drawableToBitamp(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return createBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (getDrawable() == null) {
            return;
        }
        Bitmap drawableToBitamp = drawableToBitamp(getDrawable());
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mBitmapShader = new BitmapShader(drawableToBitamp, tileMode, tileMode);
        float f2 = 1.0f;
        if (drawableToBitamp.getWidth() != getWidth() || drawableToBitamp.getHeight() != getHeight()) {
            f2 = Math.max((getWidth() * 1.0f) / drawableToBitamp.getWidth(), (getHeight() * 1.0f) / drawableToBitamp.getHeight());
        }
        this.mMatrix.setScale(f2, f2);
        this.mBitmapShader.setLocalMatrix(this.mMatrix);
        this.mPaint.setShader(this.mBitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        int i2 = this.mBorderRadius;
        canvas.drawRoundRect(rectF, i2, i2, this.mPaint);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mBorderRadius = 15;
        this.mMatrix = new Matrix();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
    }
}
