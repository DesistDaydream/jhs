package com.tencent.qcloud.tuicore.component.gatherimage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuicore.util.ScreenUtil;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class ShadeImageView extends ImageView {
    private static SparseArray<Bitmap> sRoundBitmapArray = new SparseArray<>();
    private Bitmap mRoundBitmap;
    private Paint mShadePaint;
    private int radius;

    public ShadeImageView(Context context) {
        super(context);
        this.mShadePaint = new Paint();
        this.radius = ScreenUtil.getPxByDp(4.0f);
    }

    private Bitmap getRoundBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int parseColor = Color.parseColor("#cfd3d8");
        RectF rectF = new RectF(new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight()));
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(parseColor);
        int i2 = this.radius;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        return createBitmap;
    }

    private void init(AttributeSet attributeSet) {
        setLayerType(2, null);
    }

    public int getRadius() {
        return this.radius;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mShadePaint.setColor(-65536);
        this.mShadePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        Bitmap bitmap = sRoundBitmapArray.get(getMeasuredWidth() + this.radius);
        this.mRoundBitmap = bitmap;
        if (bitmap == null) {
            this.mRoundBitmap = getRoundBitmap();
            sRoundBitmapArray.put(getMeasuredWidth() + this.radius, this.mRoundBitmap);
        }
        canvas.drawBitmap(this.mRoundBitmap, 0.0f, 0.0f, this.mShadePaint);
    }

    public void setRadius(int i2) {
        this.radius = i2;
    }

    public ShadeImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mShadePaint = new Paint();
        this.radius = ScreenUtil.getPxByDp(4.0f);
        init(attributeSet);
    }

    public ShadeImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mShadePaint = new Paint();
        this.radius = ScreenUtil.getPxByDp(4.0f);
        init(attributeSet);
    }
}
