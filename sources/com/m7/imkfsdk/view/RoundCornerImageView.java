package com.m7.imkfsdk.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes2.dex */
public class RoundCornerImageView extends AppCompatImageView {
    private int mHeight;
    private int mWidth;
    private Path path;
    private float radius;

    public RoundCornerImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 24 && getBackground() != null) {
            float cornerRadius = ((GradientDrawable) getBackground()).getCornerRadius();
            this.radius = cornerRadius;
            this.path.addRoundRect(0.0f, 0.0f, this.mWidth, this.mHeight, cornerRadius, cornerRadius, Path.Direction.CW);
            canvas.clipPath(this.path);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.mWidth = View.MeasureSpec.getSize(i2);
        this.mHeight = View.MeasureSpec.getSize(i3);
    }

    public RoundCornerImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.path = new Path();
    }
}
