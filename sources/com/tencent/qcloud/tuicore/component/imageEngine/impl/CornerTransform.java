package com.tencent.qcloud.tuicore.component.imageEngine.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import e.b.a.c;
import e.b.a.p.i;
import e.b.a.p.k.s;
import e.b.a.p.k.x.e;
import e.b.a.p.m.d.g;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class CornerTransform implements i<Bitmap> {
    private boolean exceptLeftBottom;
    private boolean exceptLeftTop;
    private boolean exceptRightBottom;
    private boolean exceptRightTop;
    private e mBitmapPool;
    private float radius;

    public CornerTransform(Context context, float f2) {
        this.mBitmapPool = c.e(context).h();
        this.radius = f2;
    }

    public void setExceptCorner(boolean z, boolean z2, boolean z3, boolean z4) {
        this.exceptLeftTop = z;
        this.exceptRightTop = z2;
        this.exceptLeftBottom = z3;
        this.exceptRightBottom = z4;
    }

    @Override // e.b.a.p.i
    @NonNull
    public s<Bitmap> transform(@NonNull Context context, @NonNull s<Bitmap> sVar, int i2, int i3) {
        int height;
        int i4;
        Bitmap bitmap = sVar.get();
        if (i2 > i3) {
            float f2 = i3;
            float f3 = i2;
            height = bitmap.getWidth();
            i4 = (int) (bitmap.getWidth() * (f2 / f3));
            if (i4 > bitmap.getHeight()) {
                i4 = bitmap.getHeight();
                height = (int) (bitmap.getHeight() * (f3 / f2));
            }
        } else if (i2 < i3) {
            float f4 = i2;
            float f5 = i3;
            int height2 = bitmap.getHeight();
            int height3 = (int) (bitmap.getHeight() * (f4 / f5));
            if (height3 > bitmap.getWidth()) {
                height = bitmap.getWidth();
                i4 = (int) (bitmap.getWidth() * (f5 / f4));
            } else {
                height = height3;
                i4 = height2;
            }
        } else {
            height = bitmap.getHeight();
            i4 = height;
        }
        this.radius *= i4 / i3;
        Bitmap f6 = this.mBitmapPool.f(height, i4, Bitmap.Config.ARGB_8888);
        if (f6 == null) {
            f6 = Bitmap.createBitmap(height, i4, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(f6);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        int width = (bitmap.getWidth() - height) / 2;
        int height4 = (bitmap.getHeight() - i4) / 2;
        if (width != 0 || height4 != 0) {
            Matrix matrix = new Matrix();
            matrix.setTranslate(-width, -height4);
            bitmapShader.setLocalMatrix(matrix);
        }
        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        float f7 = this.radius;
        canvas.drawRoundRect(rectF, f7, f7, paint);
        if (this.exceptLeftTop) {
            float f8 = this.radius;
            canvas.drawRect(0.0f, 0.0f, f8, f8, paint);
        }
        if (this.exceptRightTop) {
            float f9 = this.radius;
            canvas.drawRect(canvas.getWidth() - f9, 0.0f, f9, f9, paint);
        }
        if (this.exceptLeftBottom) {
            float f10 = this.radius;
            canvas.drawRect(0.0f, canvas.getHeight() - f10, f10, canvas.getHeight(), paint);
        }
        if (this.exceptRightBottom) {
            canvas.drawRect(canvas.getWidth() - this.radius, canvas.getHeight() - this.radius, canvas.getWidth(), canvas.getHeight(), paint);
        }
        return g.d(f6, this.mBitmapPool);
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
    }
}
