package com.m7.imkfsdk.view.imageviewer.subscaleview;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class MoorImageViewState implements Serializable {
    private final float centerX;
    private final float centerY;
    private final int orientation;
    private final float scale;

    public MoorImageViewState(float f2, @NonNull PointF pointF, int i2) {
        this.scale = f2;
        this.centerX = pointF.x;
        this.centerY = pointF.y;
        this.orientation = i2;
    }

    @NonNull
    public PointF getCenter() {
        return new PointF(this.centerX, this.centerY);
    }

    public int getOrientation() {
        return this.orientation;
    }

    public float getScale() {
        return this.scale;
    }
}
