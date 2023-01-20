package com.tencent.qcloud.tuikit.tuicontact.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;

/* loaded from: classes3.dex */
public class CircleImageView extends ImageView {
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int COLORDRAWABLE_DIMENSION = 2;
    private Bitmap mBitmap;
    private BitmapShader mBitmapShader;
    private Paint mPaint;

    public CircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(2, 2, BITMAP_CONFIG);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), BITMAP_CONFIG);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void init() {
        if (this.mBitmap == null) {
            return;
        }
        Bitmap bitmap = this.mBitmap;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
    }

    private void updateBitmapShader() {
        int min;
        if (this.mBitmap == null || (min = Math.min(getWidth(), getHeight())) == 0) {
            return;
        }
        if (min == this.mBitmap.getWidth() && min == this.mBitmap.getHeight()) {
            return;
        }
        Matrix matrix = new Matrix();
        float width = min / this.mBitmap.getWidth();
        matrix.setScale(width, width);
        this.mBitmapShader.setLocalMatrix(matrix);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null || this.mBitmapShader == null || bitmap.getHeight() == 0 || this.mBitmap.getWidth() == 0) {
            return;
        }
        updateBitmapShader();
        this.mPaint.setShader(this.mBitmapShader);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, Math.min(getWidth() / 2.0f, getHeight() / 2.0f), this.mPaint);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.mBitmap = bitmap;
        init();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.mBitmap = getBitmapFromDrawable(drawable);
        init();
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i2) {
        super.setImageResource(i2);
        this.mBitmap = getBitmapFromDrawable(getDrawable());
        init();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.mBitmap = uri != null ? getBitmapFromDrawable(getDrawable()) : null;
        init();
    }
}
