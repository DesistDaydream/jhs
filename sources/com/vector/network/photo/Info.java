package com.vector.network.photo;

import android.graphics.PointF;
import android.graphics.RectF;
import android.widget.ImageView;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class Info implements Serializable {
    public float mDegrees;
    public float mScale;
    public ImageView.ScaleType mScaleType;
    public RectF mRect = new RectF();
    public RectF mImgRect = new RectF();
    public RectF mWidgetRect = new RectF();
    public RectF mBaseRect = new RectF();
    public PointF mScreenCenter = new PointF();

    public Info(RectF rectF, RectF rectF2, RectF rectF3, RectF rectF4, PointF pointF, float f2, float f3, ImageView.ScaleType scaleType) {
        this.mRect.set(rectF);
        this.mImgRect.set(rectF2);
        this.mWidgetRect.set(rectF3);
        this.mScale = f2;
        this.mScaleType = scaleType;
        this.mDegrees = f3;
        this.mBaseRect.set(rectF4);
        this.mScreenCenter.set(pointF);
    }
}
