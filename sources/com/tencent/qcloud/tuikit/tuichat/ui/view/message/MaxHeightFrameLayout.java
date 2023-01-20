package com.tencent.qcloud.tuikit.tuichat.ui.view.message;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: classes3.dex */
public class MaxHeightFrameLayout extends FrameLayout {
    public int maxHeightPx;

    public MaxHeightFrameLayout(@NonNull Context context) {
        super(context);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.max_height_style);
        this.maxHeightPx = obtainStyledAttributes.getDimensionPixelSize(R.styleable.max_height_style_maxHeight, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        int i4 = this.maxHeightPx;
        if (i4 > 0 && i4 < size) {
            i3 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
    }

    public MaxHeightFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MaxHeightFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context, attributeSet);
    }
}
